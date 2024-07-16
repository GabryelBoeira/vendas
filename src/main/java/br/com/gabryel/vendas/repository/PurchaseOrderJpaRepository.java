package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrder, Integer> {

    @Query("SELECT p FROM PurchaseOrder p join fetch p.items join fetch p.customer WHERE p.id = ?1")
    PurchaseOrder findAllDataPurchaseOrder(Integer id);
}
