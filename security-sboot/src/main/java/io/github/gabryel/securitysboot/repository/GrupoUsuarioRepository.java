package io.github.gabryel.securitysboot.repository;

import io.github.gabryel.securitysboot.entity.GrupoUsuario;
import io.github.gabryel.securitysboot.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoUsuarioRepository extends JpaRepository<GrupoUsuario, String> {

    @Query(value = """ 
        Select distinct g.nome from GrupoUsuario gu
        join gu.grupo g
        join gu.usuarios u
        where u = ?1
     """)
    List<String> findPermissoesByUsuario(Usuario usuario);

}
