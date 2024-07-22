package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.dto.ProductDTO;
import br.com.gabryel.vendas.entity.Product;
import br.com.gabryel.vendas.exception.BusinessException;
import br.com.gabryel.vendas.repository.ProductJpaRepository;
import jakarta.servlet.ServletOutputStream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    private final ProductJpaRepository productRepository;
    private final ModelMapper modelMapper;
    private final ProductCsvService productCsvService;

    @Autowired
    public ProductService(ProductJpaRepository productRepository, ModelMapper modelMapper, ProductCsvService productCsvService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.productCsvService = productCsvService;
    }

    /**
     * Creates a CSV file containing all products.
     *
     * @return the byte array representing the CSV file
     */
    public byte[] createCsvProductFile() {
        return productCsvService.createCsvProductFile(productRepository.findAll());
    }

    public void generateZipProductFile(ServletOutputStream sos)  {
        try {
            productCsvService.createCsvZipProductFile(sos, productRepository.findAll());
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Finds a product by its ID.
     *
     * @param id the ID of the product to find
     * @return the product DTO corresponding to the ID
     */
    public ProductDTO findProductDTOById(Integer id) throws BusinessException {
        Product product = productRepository.findById(id).orElseThrow(() -> new BusinessException("Product not found"));
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product findProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to be deleted
     */
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    /**
     * Saves a product.
     *
     * @param product the product to be saved
     * @return the saved product
     */
    public ProductDTO saveProduct(ProductDTO product) {
        Product productEntity = modelMapper.map(product, Product.class);
        productEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    /**
     * Updates a product.
     *
     * @param product the product to be updated
     * @return the updated product
     */

    public Object updateProduct(Integer id, ProductDTO product) {
        product.setId(id);
        return saveProduct(product);
    }

    public Object updateProduct(ProductDTO product) {
        return saveProduct(product);
    }

}
