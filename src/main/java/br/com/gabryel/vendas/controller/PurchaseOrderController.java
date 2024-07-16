package br.com.gabryel.vendas.controller;

import br.com.gabryel.vendas.dto.RequestPurchaseOrderDTO;
import br.com.gabryel.vendas.dto.ResponsePurchaseOrderDTO;
import br.com.gabryel.vendas.exception.BusinessException;
import br.com.gabryel.vendas.service.PurchaseOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/purchaseOrder")
@Tag(name = "Pedidos", description = "Gerenciamento de pedidos")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retorna um pedido pelo id")
    public ResponseEntity<Object> getPurchaseOrder(@PathVariable Integer id) throws BusinessException {
        return ResponseEntity.ok(purchaseOrderService.getPurchaseOrder(id));
    }

    @PostMapping
    @Operation(summary = "Cria um novo pedido")
    public ResponseEntity<Object> savePurchaseOrder(@RequestBody @Valid RequestPurchaseOrderDTO purchaseOrderDTO) throws BusinessException {
        return ResponseEntity.ok(purchaseOrderService.savePurchaseOrderDTO(purchaseOrderDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um pedido pelo id")
    public ResponseEntity<Object> deletePurchaseOrder(@PathVariable Integer id) {
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um pedido")
    public ResponseEntity<Object> updatePurchaseOrder(@PathVariable Integer id, @RequestBody @Valid RequestPurchaseOrderDTO purchaseOrderDTO) throws BusinessException {
        return ResponseEntity.ok(purchaseOrderService.updatePurchaseOrder(id, purchaseOrderDTO));
    }

    @PostMapping("/find")
    @Operation(summary = "Busca um/varios pedidos pelo filtro")
    public ResponseEntity<Object> findPurchaseOrder(@RequestBody ResponsePurchaseOrderDTO purchaseOrderDTO) {
        return ResponseEntity.ok(purchaseOrderService.findPurchaseOrderDTO(purchaseOrderDTO));
    }

}
