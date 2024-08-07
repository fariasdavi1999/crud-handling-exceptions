package br.com.davi.api.controllers;

import br.com.davi.api.dto.UsuarioDTO;
import br.com.davi.api.entities.Usuario;
import br.com.davi.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public ResponseEntity<List<UsuarioDTO>> findAll() {

        List<UsuarioDTO> usuarioDTOS = usuarioService.findAll().getBody();
        if (!usuarioDTOS.isEmpty()) {
            for (UsuarioDTO usuarioDTO : usuarioDTOS) {
                UUID id = usuarioDTO.getId();
                usuarioDTO.add(linkTo(methodOn(UsuarioController.class).findById(
                        id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                usuarioDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(
            @PathVariable UUID id) {

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
    public ResponseEntity<Usuario> alterarUsuario(@PathVariable(value = "id") UUID id,
                                                  @RequestBody
                                                  @Valid
                                                  Usuario usuario) {

        return usuarioService.alterarUsuario(id, usuario);
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
