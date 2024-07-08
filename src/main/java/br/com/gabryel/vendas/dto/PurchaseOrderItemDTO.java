package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PurchaseOrderItemDTO(
        Integer id,
        Integer quantity,
        ProductDTO product
) {
}
