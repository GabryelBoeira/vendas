package io.github.gabryel.securitysboot.service;

import io.github.gabryel.securitysboot.entity.GrupoUsuario;
import io.github.gabryel.securitysboot.entity.Usuario;
import io.github.gabryel.securitysboot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(Usuario usuario, List<String> permissoes) throws Exception {
        if(StringUtils.isBlank(usuario.getPassword())) {
            throw new Exception("Senha e obrigatoria");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        var usuarioSalvo = repository.save(usuario);

        List<GrupoUsuario> grupos = new ArrayList<>();
        permissoes
                .forEach(permissao -> {
                    var grupo = grupoService.findByNome(permissao);
                    if (grupo.isPresent())
                        grupos.add(new GrupoUsuario(usuario, grupo.get()));
                });
        grupoUsuarioService.savarTodos(grupos);

        return usuarioSalvo;
    }

    public Usuario findUsuarioComPermissoesByLogin(String login) {
        Usuario usuario = repository.findByLoginEquals(login).orElse(null);

        if (usuario == null) return null;

        usuario.setPermissoes(grupoUsuarioService.findPermissoesByUsuario(usuario));

        return usuario;
    }

}
