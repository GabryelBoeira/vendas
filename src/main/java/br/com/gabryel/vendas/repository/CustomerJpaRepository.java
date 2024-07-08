package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    Customer findByName(String name);
}
