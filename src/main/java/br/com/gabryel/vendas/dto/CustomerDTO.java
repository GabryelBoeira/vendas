package br.com.gabryel.vendas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Customer object that is sent in requests to the API")
public class CustomerDTO {

    @Schema(description = "The unique identifier of the customer")
    private Integer id;

    @Schema(description = "The name of the customer")
    @NotBlank
    @Size(max = 100)
    private String name;

    @Schema(description = "The purchase orders of the customer")
    private List<PurchaseOrderDTO> orders = new ArrayList<>();

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, List<PurchaseOrderDTO> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(max = 100) String name) {
        this.name = name;
    }

    public List<PurchaseOrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<PurchaseOrderDTO> orders) {
        this.orders = orders;
    }
}
