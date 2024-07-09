package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Represents a product")
public record ProductDTO(
        @Schema(description = "The unique identifier of the product")
        Integer id,

        @Schema(description = "The description of the product")
        @NotBlank
        @Size(max = 100)
        String description,

        @Schema(description = "The value of the product")
        @NotNull
        BigDecimal value
) {
}
