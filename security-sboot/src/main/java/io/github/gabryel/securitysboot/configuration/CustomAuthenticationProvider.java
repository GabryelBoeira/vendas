package io.github.gabryel.securitysboot.configuration;

import io.github.gabryel.securitysboot.entity.Usuario;
import io.github.gabryel.securitysboot.security.CustomAuthentication;
import io.github.gabryel.securitysboot.security.IdentificacaoUsuario;
import io.github.gabryel.securitysboot.service.UsuarioService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UsuarioService service;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario user = service.findUsuarioComPermissoesByLogin(login);
        if (user == null) return null;

        boolean passwordMatch = passwordEncoder.matches(password, user.getPassword());

        if (!passwordMatch)  return null;

        return new CustomAuthentication(
                new IdentificacaoUsuario(user.getId(), user.getNome(), user.getLogin(), user.getPermissoes()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
