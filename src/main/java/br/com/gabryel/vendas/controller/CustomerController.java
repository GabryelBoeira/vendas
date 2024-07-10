package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;

@RestController
@RequestMapping("/customer")
@Tag(name = "Cliente", description = "Gerenciar/Manipular dados de clientes")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customer) {
        return new CustomerDTO(1, "will smith", new ArrayList<>());
    }

    @Operation(summary = "Busca o cliente pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findCustomerById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(customerService.findCustomerAndPurchaseOrderById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Busca o cliente pelo nome")
    @GetMapping("/find/name")
    public CustomerDTO findCustomerByName(@RequestParam String name) {
        return new CustomerDTO(1, "will smith", new ArrayList<>());
    }

    @Operation(summary = "Atualizar dados do cliente")
    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody @Valid CustomerDTO customer) {
        return new CustomerDTO(1, "will smith", new ArrayList<>());
    }

    @Operation(summary = "Deletar o cliente pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

}
