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
        SELECT DISTINCT g.nome FROM GrupoUsuario gu
        JOIN gu.grupo g
        JOIN gu.usuario u
        WHERE u = ?1
     """)
    List<String> findPermissoesByUsuario(Usuario usuario);

}
