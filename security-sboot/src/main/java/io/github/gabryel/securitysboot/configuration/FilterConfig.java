package io.github.gabryel.securitysboot.configuration;

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
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    "user_secret",
                    null,
                    List.of(new SimpleGrantedAuthority("USER"))
            );
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }

}
