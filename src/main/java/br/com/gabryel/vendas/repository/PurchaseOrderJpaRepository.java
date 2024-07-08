package br.com.gabryel.vendas.repository;

import br.com.gabryel.vendas.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrder, Long> {
}
