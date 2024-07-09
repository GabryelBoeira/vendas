package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "The purchase order item DTO")
public record PurchaseOrderItemDTO(
        @Schema(description = "The unique identifier of the purchase order item")
        Integer id,

        @Schema(description = "The quantity of the purchase order item")
        Integer quantity,

        @Schema(description = "The product of the purchase order item")
        ProductDTO product
) {
}
