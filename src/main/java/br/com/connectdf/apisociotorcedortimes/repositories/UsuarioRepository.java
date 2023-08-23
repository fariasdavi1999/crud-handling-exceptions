package br.com.connectdf.apisociotorcedortimes.repositories;

import br.com.connectdf.apisociotorcedortimes.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByCnpj(String cnpj);

    Optional<Usuario> findByEmail(String email);

    @Modifying
    void deleteByCpf(String cpf);

}
