package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.ProductDTO;
import br.com.gabryel.vendas.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;


@RestController
@RequestMapping("/product")
@Tag(name = "Produto", description = "Gerenciar/Manipular dados de produtos")
public class ProductController {

    private final ProductService productService;

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

    @PostMapping("/extract/csv/zip")
    @Operation(summary = "Lista todos os produtos atualmente em estoque em formato CSV em um arquivo ZIP")
    public ResponseEntity<StreamingResponseBody> extractProductsListCsvZip(HttpServletResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=products.zip");
        headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.CONTENT_DISPOSITION);
        headers.setContentType(MediaType.valueOf("application/zip"));

        return ResponseEntity.ok()
                .headers(headers)
                .body(out -> productService.generateZipProductFile(response.getOutputStream()));
    }


    @Operation(summary = "Busca o produto pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(productService.findProductById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove o produto pelo ID")
    public ResponseEntity<Object> deleteProductById(@PathVariable Integer id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Operation(summary = "Cria um novo produto")
    public ResponseEntity<Object> createProduct(@RequestBody @Valid ProductDTO product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping
    @Operation(summary = "Atualiza os dados do produto")
    public ResponseEntity<Object> updateProduct(@RequestBody @Valid ProductDTO product) {
        try {
            return ResponseEntity.ok(productService.updateProduct(product));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
