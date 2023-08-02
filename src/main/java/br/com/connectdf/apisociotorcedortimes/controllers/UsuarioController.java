package br.com.connectdf.apisociotorcedortimes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.connectdf.apisociotorcedortimes.entities.Usuario;
import br.com.connectdf.apisociotorcedortimes.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> findById(
			@Valid @PathVariable Long id) {
		return usuarioService.findById(id);
	}

	@GetMapping("/cpf")
	public ResponseEntity<Optional<Usuario>> findByCpf(
			@Valid @RequestParam String cpf) {
		return usuarioService.findByCpf(cpf);
	}

	@GetMapping("/cnpj")
	public ResponseEntity<Optional<Usuario>> findByCnpj(
			@Valid @RequestParam String cnpj) {
		return usuarioService.findByCnpj(cnpj);
	}

	@PostMapping("")
	public ResponseEntity<Usuario> inserirUsuario(
			@Valid @RequestBody Usuario usuario) {
		return usuarioService.inserirUsuario(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> alterarUsuario(@PathVariable Long id,
			@Valid @RequestBody Usuario usuario) {
		return usuarioService.alterarUsuario(usuario);
	}

	@DeleteMapping("/{id}")
	public void removerUsuario(@PathVariable Long id) {
		usuarioService.removerUsuario(id);
	}

}
