package br.com.gabryel.vendas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Tag(name = "Produto", description = "Gerenciar/Manipular dados de produtos")
public class ProductController {

    public ProductController() {}

    @GetMapping("/")
    public String namePage() {
        return "Produto";
    }

}
