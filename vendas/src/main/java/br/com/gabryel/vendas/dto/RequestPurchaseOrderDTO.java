package br.com.gabryel.vendas.dto;

import br.com.gabryel.vendas.util.listValidation.NotEmptyList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Represents a purchase order to be created")
public record RequestPurchaseOrderDTO(

        @Schema(description = "The customer of the purchase order")
        @NotNull
        Integer customerId,

        @Schema(description = "The date when the order was placed")
        @PositiveOrZero
        @NotNull
        BigDecimal valueTotal,

        @Schema(description = "The items of the order")
        @NotNull
        @NotEmptyList
        List<RequestPurchaseOrderItemDTO> items
) {
}
