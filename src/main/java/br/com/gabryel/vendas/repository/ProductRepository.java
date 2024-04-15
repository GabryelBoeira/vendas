package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final EntityManager entityManager;

    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Saves the product to the database.
     *
     * @param  product  the product to be saved
     * @return          the saved product
     */
    @Transactional
    public Product saveProduct(Product product) {
        entityManager.persist(product);
        return product;
    }

}
