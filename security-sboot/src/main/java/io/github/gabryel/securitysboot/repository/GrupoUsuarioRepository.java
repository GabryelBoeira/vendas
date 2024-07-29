package io.github.gabryel.securitysboot.repository;

import io.github.gabryel.securitysboot.entity.GrupoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, String> {
}
