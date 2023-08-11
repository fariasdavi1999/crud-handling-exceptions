package br.com.connectdf.apisociotorcedortimes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.connectdf.apisociotorcedortimes.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByCnpj(String cnpj);

	Optional<Usuario> findByEmail(String email);

}
