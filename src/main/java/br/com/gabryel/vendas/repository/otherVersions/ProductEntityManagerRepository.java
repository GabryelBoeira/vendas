package br.com.gabryel.vendas.repository.otherVersions;

import br.com.gabryel.vendas.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductEntityManagerRepository {

    private final EntityManager entityManager;

    public ProductEntityManagerRepository(EntityManager entityManager) {
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

    /**
     * Update a product in the database.
     *
     * @param  product   the product to be updated
     * @return           the updated product
     */
    @Transactional
    public Product updateProduct(Product product) {
        entityManager.merge(product);
        return product;
    }

    /**
     * Deletes a product from the database.
     *
     * @param  product  the product to be deleted
     */
    @Transactional
    public void deleteProduct(Product product) {
        if (!entityManager.contains(product)) product = entityManager.merge(product);
        entityManager.remove(product);
    }

    @Transactional
    public void deleteProductById(Integer productId) {
        Product product = entityManager.find(Product.class, productId);
        deleteProduct(product);
    }

    /**
     * Find products by description.
     *
     * @param  description  the description to search for
     * @return              a list of products matching the description
     */
    @Transactional(readOnly = true)
    public List<Product> findProductByDescription(String description) {
        return entityManager
                .createQuery("SELECT p FROM Product p WHERE p.description LIKE :description ", Product.class)
                .setParameter("description","%" + description + "%")
                .getResultList();
    }

    @Transactional(readOnly = true)
    public List<Product> findAllProduct() {
        return entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

}
