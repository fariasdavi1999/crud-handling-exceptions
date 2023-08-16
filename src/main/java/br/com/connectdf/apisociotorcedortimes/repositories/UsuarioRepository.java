package br.com.connectdf.apisociotorcedortimes.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.connectdf.apisociotorcedortimes.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	Optional<Usuario> findByCpf(String cpf);
	Optional<Usuario> findByCnpj(String cnpj);

	Optional<Usuario> findByEmail(String email);

}
