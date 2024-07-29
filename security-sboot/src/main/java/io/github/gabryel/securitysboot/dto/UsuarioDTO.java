package io.github.gabryel.securitysboot.dto;

import io.github.gabryel.securitysboot.entity.Usuario;

import java.util.List;


public record UsuarioDTO(
        Usuario usuario,
        List<String> permissoes
) {
}