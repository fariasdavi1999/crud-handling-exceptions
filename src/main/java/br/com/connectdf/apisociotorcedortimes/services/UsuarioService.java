package br.com.connectdf.apisociotorcedortimes.services;

import br.com.connectdf.apisociotorcedortimes.entities.Usuario;
import br.com.connectdf.apisociotorcedortimes.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity<List<Usuario>> findAll() {
        try {
            List<Usuario> resultado = usuarioRepository.findAll();

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            System.err.println("Erro ao buscar usuarios: " + e.getMessage());

            throw new RuntimeException(
                    "Ocorreu um erro ao buscar os usuarios.");
        }
    }

    @Transactional
    public ResponseEntity<Optional<Usuario>> findById(Long id) {
        try {
            Optional<Usuario> resultado = usuarioRepository.findById(id);

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            System.err.println(
                    "Erro ao buscar usuario por id: " + e.getMessage() + e.getCause());

            throw new RuntimeException(
                    "Ocorreu um erro ao buscar usuario por id");
        }
    }

    @Transactional
    public ResponseEntity<Optional<Usuario>> findByCpf(String cpf) {
        try {
            Optional<Usuario> resultado = usuarioRepository.findByCpf(cpf);

            return resultado.isPresent() ? ResponseEntity.ok(resultado) :
                    ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println(
                    "Erro ao buscar usuario por cpf: " + e.getMessage() + e.getCause());

            throw new RuntimeException(
                    "Ocorreu um erro ao buscar usuario por cpf");
        }
    }

    @Transactional
    public ResponseEntity<Optional<Usuario>> findByCnpj(String cnpj) {
        try {
            Optional<Usuario> resultado = usuarioRepository.findByCnpj(cnpj);

            return ResponseEntity.ok(resultado);
        } catch (Exception e) {
            System.err.println(
                    "Erro ao buscar usuario por cnpj: " + e.getMessage() + e.getCause());

            throw new RuntimeException(
                    "Ocorreu um erro ao buscar usuario por cnpj");
        }
    }

    @Transactional
    public ResponseEntity<Optional<Usuario>> findByEmail(String email) {
        try {
            Optional<Usuario> resultado = usuarioRepository.findByEmail(email);

            return resultado.isPresent() ? ResponseEntity.ok(resultado) :
                    ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.err.println(
                    "Erro ao buscar usuario por email: " + e.getMessage() + e.getCause());

            throw new RuntimeException(
                    "Ocorreu um erro ao buscar usuario por email");
        }
    }

    @Transactional
    public ResponseEntity<Usuario> inserirUsuario(Usuario usuario) {

        try {
            Optional<Usuario> usuarioRequest = usuarioRepository.findByCpf(
                    usuario.getCpf());
            if (usuarioRequest.isPresent()) {
                usuarioRequest.get();

            }

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(usuarioRepository.saveAndFlush(usuario));
        } catch (Exception e) {
            System.err.println(
                    "Erro ao inserir usuario: " + e.getMessage() + e.getCause());

            throw new RuntimeException("Ocorreu um erro ao cadastrar usuario");
        }

    }

    @Transactional
    public ResponseEntity<Usuario> alterarUsuario(Usuario usuario) {
        try {
            Usuario us = usuarioRepository.saveAndFlush(usuario);
            return ResponseEntity.ok().body(us);
        } catch (Exception e) {
            System.err.println(
                    "Erro ao alterar usuario: " + e.getMessage() + e.getCause());

            throw new RuntimeException("Ocorreu um erro ao alterar usuario");
        }
    }

    @Transactional
    public void removerUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            System.err.println(
                    "Erro ao deletar usuario: " + e.getMessage() + e.getCause());

            throw new RuntimeException("Ocorreu um erro ao deletar usuario");
        }
    }

}
