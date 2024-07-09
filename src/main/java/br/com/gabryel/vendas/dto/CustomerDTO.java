package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Customer object that is sent in requests to the API")
public record CustomerDTO (
        @Schema(description = "The unique identifier of the customer")
        Integer id,

        @Schema(description = "The name of the customer")
        @NotBlank
        @Size(max = 100)
        String name,

        @Schema(description = "The purchase orders of the customer")
        List purchaseOrders
) {}
