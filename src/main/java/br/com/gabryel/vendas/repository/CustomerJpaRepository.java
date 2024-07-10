package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.name = ?1")
    Customer findByName(String name);

    /**
     * Find a customer by ID, including its purchase orders.
     *
     * @param  id  the ID of the customer to find
     * @return     the customer entity if found, null otherwise
     */
    @Query("SELECT c FROM Customer c left join fetch c.orders where c.id = :id")
    Customer findCustomerAndPurchaseOrdersById(@Param("id") Integer id);

}
