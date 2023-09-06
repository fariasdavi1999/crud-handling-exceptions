package br.com.connectdf.apisociotorcedortimes.services;

import br.com.connectdf.apisociotorcedortimes.dto.UsuarioDTO;
import br.com.connectdf.apisociotorcedortimes.entities.Usuario;
import br.com.connectdf.apisociotorcedortimes.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity<List<UsuarioDTO>> findAll() {

        List<Usuario> resultado = usuarioRepository.findAll();

        List<UsuarioDTO> dto = new ArrayList<>();
        for (Usuario usuario : resultado) {
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
            dto.add(usuarioDTO);
        }

        return ResponseEntity.ok(dto);

    }

    @Transactional
    public ResponseEntity<Object> findById(UUID id) {

        Optional<Usuario> resultado = usuarioRepository.findById(id);
        if (resultado.isEmpty()) {
            var usuario = resultado.get();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuario);
        }

        return ResponseEntity.status(HttpStatus.OK).body(resultado.get());

    }

    @Transactional
    public ResponseEntity<Usuario> findByCpf(String cpf) {

        Usuario resultado = usuarioRepository.findByCpf(cpf).get();

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


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioRepository.saveAndFlush(usuario));
    }

    @Transactional
    public ResponseEntity<Usuario> alterarUsuario(UUID id, Usuario usuario) {

        Optional<Usuario> resultado = usuarioRepository.findById(id);
        if (resultado.isEmpty()) {
            var user = resultado.get();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    @Transactional
    public void removerUsuario(UUID id) {

        Optional<Usuario> usuarioResponse = usuarioRepository.findById(id);

        if (usuarioResponse.isEmpty()) {
            usuarioResponse.get();
            return;
        }
        usuarioRepository.deleteById(id);
    }

    @Transactional
    public void removerUsuarioBycpf(Usuario usuario, String cpf) {

        Optional<Usuario> usuarioResponse = usuarioRepository.findByCpf(
                usuario.getCpf());

        usuarioResponse.ifPresent(
                usuarioUm ->
                        usuarioRepository.deleteByCpf(cpf)
        );

    }

}
