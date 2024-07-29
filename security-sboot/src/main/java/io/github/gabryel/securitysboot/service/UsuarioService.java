package io.github.gabryel.securitysboot.service;

import io.github.gabryel.securitysboot.dto.UsuarioDTO;
import io.github.gabryel.securitysboot.entity.GrupoUsuario;
import io.github.gabryel.securitysboot.entity.Usuario;
import io.github.gabryel.securitysboot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final GrupoService grupoService;
    private final GrupoUsuarioService grupoUsuarioService;

    @Transactional
    public Usuario salvar(UsuarioDTO usuarioDto) {
        var usuario = repository.save(usuarioDto.usuario());

        List<GrupoUsuario> grupos = new ArrayList<>();
        usuarioDto.permissoes()
                .forEach(permissao -> {
                    var grupo = grupoService.findByNome(permissao);
                    if (grupo.isPresent())
                        grupos.add(new GrupoUsuario(usuario, grupo.get()));
                });
        grupoUsuarioService.savarTodos(grupos);

        return usuario;
    }

}
