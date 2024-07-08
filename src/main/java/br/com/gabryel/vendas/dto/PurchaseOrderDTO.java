package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record PurchaseOrderDTO(
        Integer id,
        CustomerDTO customer,
        LocalDateTime dateOrder,
        BigDecimal valueTotal,
        List items
) {
}
