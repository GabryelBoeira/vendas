package br.com.gabryel.vendas.dto;

import java.util.List;

public record ResponseMessenger(
        List<String> message
) {
}
