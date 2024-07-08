package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
