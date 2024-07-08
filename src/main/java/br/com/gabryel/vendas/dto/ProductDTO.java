package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDTO(
        Integer id,

        @NotBlank
        @Size(max = 100)
        String description,

        @NotNull
        BigDecimal value
) {
}
