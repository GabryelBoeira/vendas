package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderItemJpaRepository extends JpaRepository<PurchaseOrderItem, Integer> {
}
