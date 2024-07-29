package io.github.gabryel.securitysboot.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthenticationProviderConfig implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String loginMaster = "master";
        String passwordMaster = "master123";

        if (!authentication.getName().equals(loginMaster)
                && !authentication.getCredentials().toString().equals(passwordMaster)) {
            return authentication;
        }

        return new UsernamePasswordAuthenticationToken(
                authentication.getName(),
                null,
                List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("USER"))
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
