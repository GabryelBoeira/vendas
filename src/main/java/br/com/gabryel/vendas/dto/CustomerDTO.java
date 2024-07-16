package br.com.gabryel.vendas.dto;

import br.com.gabryel.vendas.util.CustomerListDeserializer;
import br.com.gabryel.vendas.util.CustomerListSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Customer object that is sent in requests to the API")
public class CustomerDTO {

    @Schema(description = "The unique identifier of the customer")
    private Integer id;

    @Schema(description = "The name of the customer")
    @NotBlank
    @Size(max = 100)
    private String name;

    @Schema(description = "The CPF of the customer")
    @NotBlank
    @Size(max = 11)
    private String cpf;

    @Schema(description = "The purchase orders of the customer")
    @JsonSerialize(using = CustomerListSerializer.class)
    @JsonDeserialize(using = CustomerListDeserializer.class)
    private List<ResponsePurchaseOrderDTO> orders = new ArrayList<>();

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, List<ResponsePurchaseOrderDTO> orders) {
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

    public List<ResponsePurchaseOrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<ResponsePurchaseOrderDTO> orders) {
        this.orders = orders;
    }

    public @NotBlank @Size(max = 11) String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @Size(max = 11) String cpf) {
        this.cpf = cpf;
    }
}
