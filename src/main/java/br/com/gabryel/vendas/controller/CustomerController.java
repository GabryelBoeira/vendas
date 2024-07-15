package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
        return customerService.saveCustomerDTO(customer);
    }

    @Operation(summary = "Busca o cliente pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findCustomerById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(customerService.findCustomerById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Busca o cliente pelo nome")
    @GetMapping("/find/name")
    public CustomerDTO findCustomerByName(@RequestParam String name) {
        CustomerDTO customer = customerService.findCustomerByName(name);
        if (customer != null) return customer;

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found: " + name);
    }

    @Operation(summary = "Atualizar dados do cliente")
    @PutMapping
    public ResponseEntity<Object> updateCustomer(@RequestBody @Valid CustomerDTO customer) {
        try {
            return ResponseEntity.ok(customerService.updateCustomer(customer));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar o cliente pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

}
