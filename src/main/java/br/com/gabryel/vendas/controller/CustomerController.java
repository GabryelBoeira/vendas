package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
@Tag(name = "Cliente", description = "Gerenciar/Manipular dados de clientes")
public class CustomerController {

    public CustomerController() {}

    @Operation(summary = "Cria um novo cliente")
    @PostMapping
    public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customer) {
        return new CustomerDTO(1, "will smith", new ArrayList());
    }

    @Operation(summary = "Busca o cliente pelo ID")
    @GetMapping("/{id}")
    public CustomerDTO findCustomerById(@PathVariable Integer id) {
        return new CustomerDTO(1, "will smith", new ArrayList());
    }

    @Operation(summary = "Busca o cliente pelo nome")
    @GetMapping("/find/name")
    public CustomerDTO findCustomerByName(@RequestParam String name) {
        return new CustomerDTO(1, "will smith", new ArrayList());
    }

    @Operation(summary = "Atualizar dados do cliente")
    @PutMapping
    public CustomerDTO updateCustomer(@RequestBody @Valid CustomerDTO customer) {
        return new CustomerDTO(1, "will smith", new ArrayList());
    }

    @Operation(summary = "Deletar o cliente pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

}
