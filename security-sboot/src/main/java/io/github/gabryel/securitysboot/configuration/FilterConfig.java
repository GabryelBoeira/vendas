package io.github.gabryel.securitysboot.configuration;

import io.github.gabryel.securitysboot.security.CustomAuthentication;
import io.github.gabryel.securitysboot.security.IdentificacaoUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class FilterConfig extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String secret = request.getHeader("x-secret");

        if (StringUtils.isAllBlank(secret)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (secret.equals("secr3t")) {
            IdentificacaoUsuario idUser = new IdentificacaoUsuario("id_secret", "user_secret", "user_secret", List.of("USER"));

            Authentication auth = new CustomAuthentication(idUser);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

}
