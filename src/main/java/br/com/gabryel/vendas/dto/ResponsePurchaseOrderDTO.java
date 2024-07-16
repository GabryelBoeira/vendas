package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Represents a purchase order")
public class ResponsePurchaseOrderDTO {

    @Schema(description = "The unique identifier of the purchase order")
    private Integer id;

    @Schema(description = "The customer of the purchase order")
    private CustomerDTO customer;

    @Schema(description = "The date when the order was placed")
    @NotBlank
    private LocalDateTime dateOrder;

    @Schema(description = "The total value of the order")
    private BigDecimal valueTotal;

    @Schema(description = "The items of the order")
    private List<ResponsePurchaseOrderItemDTO> items;

    public ResponsePurchaseOrderDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public @NotBlank LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(@NotBlank LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public BigDecimal getValueTotal() {
        return valueTotal;
    }

    public void setValueTotal(BigDecimal valueTotal) {
        this.valueTotal = valueTotal;
    }

    public List<ResponsePurchaseOrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ResponsePurchaseOrderItemDTO> items) {
        this.items = items;
    }
}
