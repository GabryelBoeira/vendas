package br.com.gabryel.vendas.dto;

import br.com.gabryel.vendas.entity.PurchaseOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "The purchase order item DTO")
public class ResponsePurchaseOrderItemDTO {

    @Schema(description = "The unique identifier of the purchase order item")
    private Integer id;

    @Schema(description = "The quantity of the purchase order item")
    private Integer quantity;

    @Schema(description = "The product of the purchase order item")
    private ProductDTO product;

    @Schema(description = "The purchase order of the purchase order item")
    private PurchaseOrder purchaseOrder;

    public ResponsePurchaseOrderItemDTO() {
    }

    public ResponsePurchaseOrderItemDTO(Integer id, Integer quantity, ProductDTO product, PurchaseOrder purchaseOrder) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

}
