package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
@Tag(name = "Produto", description = "Gerenciar/Manipular dados de produtos")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String namePage() {
        return "Produto";
    }

    @GetMapping("/extract/csv")
    @Operation(summary = "Lista todos os produtos atualmente em estoque em formato CSV")
    public ResponseEntity<Object> extractProductsListCsv() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=products.csv");
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            return new ResponseEntity<>(productService.createCsvProductFile(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/extract/csv/zip")
    @Operation(summary = "Lista todos os produtos atualmente em estoque em formato CSV em um arquivo ZIP")
    public String extractProductsListCsvZip() {
        return "Hello World";
    }

}
