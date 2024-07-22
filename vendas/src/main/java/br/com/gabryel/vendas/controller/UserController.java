package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.UserSystemRequest;
import br.com.gabryel.vendas.dto.UserSystemResponse;
import br.com.gabryel.vendas.dto.security.CredentialsDTO;
import br.com.gabryel.vendas.dto.security.TokenDTO;
import br.com.gabryel.vendas.exception.PasswordInvalidException;
import br.com.gabryel.vendas.security.JwtService;
import br.com.gabryel.vendas.service.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "basicAuth")
@Tag(name = "Usuario", description = "Gerenciamento de Usuarios")
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;

    @Autowired
    public UserController(UserDetailsServiceImpl userDetailsService, JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSystemResponse createUser(@RequestBody @Valid UserSystemRequest user) {
        return userDetailsService.createUser(user);
    }


    @PostMapping("/auth")
    public TokenDTO auth(@RequestBody @Valid CredentialsDTO user) throws UsernameNotFoundException {
        try {
            //Altenticar o usuario
            UserSystemResponse userSystem = userDetailsService.authenticateUser(user);

            String token = jwtService.generateTokenJWT(userSystem);
            return new TokenDTO(user.getUsername(), token);
        } catch (PasswordInvalidException | UsernameNotFoundException  e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
    
}
