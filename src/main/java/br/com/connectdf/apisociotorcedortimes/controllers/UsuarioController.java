package br.com.connectdf.apisociotorcedortimes.controllers;

import br.com.connectdf.apisociotorcedortimes.dto.UsuarioDTO;
import br.com.connectdf.apisociotorcedortimes.entities.Usuario;
import br.com.connectdf.apisociotorcedortimes.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> findAll() {

        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(
            @Valid @PathVariable UUID id) {
        return usuarioService.findById(id);
    }

    @GetMapping("/cpf")
    public ResponseEntity<Usuario> findByCpf(
            @Valid @RequestParam String cpf) {
        return usuarioService.findByCpf(cpf);
    }

    @GetMapping("/cnpj")
    public ResponseEntity<Optional<Usuario>> findByCnpj(
            @Valid @RequestParam String cnpj) {
        return usuarioService.findByCnpj(cnpj);
    }

    @GetMapping("/email")
    public ResponseEntity<Optional<Usuario>> findByEmail(
            @Valid @RequestParam String email) {
        return usuarioService.findByEmail(email);
    }

    @PostMapping("")
    public ResponseEntity<Usuario> inserirUsuario(
            @Valid @RequestBody Usuario usuario) {
        return usuarioService.inserirUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterarUsuario(@PathVariable UUID id,
                                                  @Valid @RequestBody
                                                  Usuario usuario) {

        return usuarioService.alterarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@Valid @PathVariable UUID id) {
        usuarioService.removerUsuario(id);
    }

    @DeleteMapping("/cpf/{cpf}")
    public void removerUsuarioByCpf(Usuario usuario,
                                    @Valid @PathVariable String cpf) {
        usuarioService.removerUsuarioBycpf(usuario, cpf);

    }
}
