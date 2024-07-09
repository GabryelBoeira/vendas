package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Represents a purchase order")
public record PurchaseOrderDTO(
        @Schema(description = "The unique identifier of the purchase order")
        Integer id,

        @Schema(description = "The customer that placed the order")
        CustomerDTO customer,

        @Schema(description = "The date when the order was placed")
        @NotBlank
        LocalDateTime dateOrder,

        @Schema(description = "The total value of the order")
        BigDecimal valueTotal,

        @Schema(description = "The items of the order")
        List items
) {
}
