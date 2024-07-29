package io.github.gabryel.securitysboot.repository;

import io.github.gabryel.securitysboot.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, String> {
}
