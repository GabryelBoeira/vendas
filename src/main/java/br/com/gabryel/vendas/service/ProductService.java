package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.entity.Product;
import br.com.gabryel.vendas.repository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class ProductService {

    private static final String CSV_HEADER = "ID, DESCRICAO, VALOR \n";
    private final ProductJpaRepository productRepository;

    @Autowired
    public ProductService(ProductJpaRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Method to create a CSV file containing product information.
     *
     * @return          a byte array representing the CSV file content
     */
    public byte[] createCsvProductFile() {
        StringBuilder csvContent = new StringBuilder();
        csvContent.append(CSV_HEADER);

        for (Product product : productRepository.findAll()) {
            csvContent.append(product.getId()).append(",")
                    .append(product.getDescription()).append(",")
                    .append(product.getValue()).append("\n");
        }

        return csvContent.toString().getBytes(StandardCharsets.UTF_8);
    }

}
