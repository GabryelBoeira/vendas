package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.UserSystemRequest;
import br.com.gabryel.vendas.dto.UserSystemResponse;
import br.com.gabryel.vendas.entity.UserSystem;
import br.com.gabryel.vendas.service.UserDetailsServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "basicAuth")
@Tag(name = "Usuario", description = "Gerenciamento de Usuarios")
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public UserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSystemResponse createUser(@RequestBody @Valid UserSystemRequest user) {
        return userDetailsService.createUser(user);
    }



}
