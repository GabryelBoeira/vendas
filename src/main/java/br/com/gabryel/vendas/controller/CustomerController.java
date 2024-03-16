package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/save")
    public String save() {
        return customerService.saveCustomer();
    }






}
