package br.com.gabryel.vendas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@Tag(name = "Cliente", description = "Cliente API")
public class CustomerController {

    public CustomerController() {}

    @GetMapping("/")
    public String namePage() {
        return "customer";
    }


}
