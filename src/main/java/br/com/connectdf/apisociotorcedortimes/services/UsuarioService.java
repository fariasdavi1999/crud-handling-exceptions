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
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Logger logger;

    @Transactional
    public ResponseEntity<List<Usuario>> findAll() {

        List<Usuario> resultado = usuarioRepository.findAll();

        return ResponseEntity.ok(resultado);

    }

    @Transactional
    public ResponseEntity<Usuario> findById(UUID id) {

        Usuario resultado = usuarioRepository.findById(id).get();

        return ResponseEntity.ok(resultado);

    }

    @Transactional
    public ResponseEntity<Usuario> findByCpf(String cpf) {

        Usuario resultado = usuarioRepository.findByCpf(cpf).get();

//        return resultado.isPresent() ? ResponseEntity.ok(resultado) :
//                ResponseEntity.notFound().build();
        return ResponseEntity.ok(resultado);

    }

    @Transactional
    public ResponseEntity<Optional<Usuario>> findByCnpj(String cnpj) {

        Optional<Usuario> resultado = usuarioRepository.findByCnpj(cnpj);

        return ResponseEntity.ok(resultado);

    }

    @Transactional
    public ResponseEntity<Optional<Usuario>> findByEmail(String email) {

        Optional<Usuario> resultado = usuarioRepository.findByEmail(email);

        return ResponseEntity.ok(resultado);

    }

    @Transactional
    public ResponseEntity<Usuario> inserirUsuario(Usuario usuario) {

        Optional<Usuario> usuarioRequest = usuarioRepository.findByCpf(
                usuario.getCpf());
        if (usuarioRequest.isPresent()) {
            usuarioRequest.get();

        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRepository.saveAndFlush(usuario));

    }

    @Transactional
    public ResponseEntity<Usuario> alterarUsuario(Usuario usuario) {

        Usuario us = usuarioRepository.saveAndFlush(usuario);
        return ResponseEntity.ok().body(us);

    }

    @Transactional
    public void removerUsuario(UUID id) {

        usuarioRepository.deleteById(id);

    }

}
