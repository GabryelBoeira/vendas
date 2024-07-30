package io.github.gabryel.securitysboot.service;

import io.github.gabryel.securitysboot.entity.GrupoUsuario;
import io.github.gabryel.securitysboot.entity.Usuario;
import io.github.gabryel.securitysboot.repository.GrupoUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoUsuarioService {

    private final GrupoUsuarioRepository grupoUsuarioRepository;

    /**
     * Saves a list of GrupoUsuarioRepository objects to the database.
     *
     * @param  list  the list of GrupoUsuarioRepository objects to save
     */
    @Transactional
    public void savarTodos(List<GrupoUsuario> list) {
        grupoUsuarioRepository.saveAll(list);
    }


    public List<String> findPermissoesByUsuario(Usuario usuario) {
        return grupoUsuarioRepository.findPermissoesByUsuario(usuario);
    }

}
