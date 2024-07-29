package io.github.gabryel.securitysboot.controller;

import io.github.gabryel.securitysboot.dto.UsuarioDTO;
import io.github.gabryel.securitysboot.entity.Usuario;
import io.github.gabryel.securitysboot.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok().body(service.salvar(usuario));
    }

}
