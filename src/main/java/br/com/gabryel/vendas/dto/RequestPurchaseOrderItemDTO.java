package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Represents a purchase order to be created")
public record RequestPurchaseOrderItemDTO(

        @Schema(description = "The quantity of the purchase order item")
        @NotNull
        Integer quantity,

        @Schema(description = "The product of the purchase order item")
        @NotNull
        Integer productId
) {
}
