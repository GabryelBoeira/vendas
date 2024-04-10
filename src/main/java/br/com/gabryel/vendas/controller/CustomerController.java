package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    public CustomerController() {}

    @GetMapping("/")
    public String namePage() {
        return "customer";
    }

}
