package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.enums.OrderStatus;
import br.com.gabryel.vendas.dto.ProductDTO;
import br.com.gabryel.vendas.dto.RequestPurchaseOrderDTO;
import br.com.gabryel.vendas.dto.RequestPurchaseOrderItemDTO;
import br.com.gabryel.vendas.dto.ResponsePurchaseOrderDTO;
import br.com.gabryel.vendas.entity.PurchaseOrder;
import br.com.gabryel.vendas.entity.PurchaseOrderItem;
import br.com.gabryel.vendas.exception.BusinessException;
import br.com.gabryel.vendas.repository.PurchaseOrderItemJpaRepository;
import br.com.gabryel.vendas.repository.PurchaseOrderJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderJpaRepository purchaseOrderRepository;
    private final PurchaseOrderItemJpaRepository orderItemRepository;
    private final ModelMapper modelMapper;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public PurchaseOrderService(PurchaseOrderJpaRepository purchaseOrderRepository, PurchaseOrderItemJpaRepository orderItemRepository, ModelMapper modelMapper, CustomerService customerService, ProductService productService) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.orderItemRepository = orderItemRepository;
        this.modelMapper = modelMapper;
        this.customerService = customerService;
        this.productService = productService;
    }

    /**
     * Saves a purchase order by mapping the provided DTO to an entity, saving it to the repository,
     * and then mapping the saved entity back to a DTO.
     *
     * @param purchaseOrderDTO the DTO containing the purchase order data to be saved
     * @return the saved purchase order as a DTO
     */
    @Transactional
    public PurchaseOrder savePurchaseOrderDTO(RequestPurchaseOrderDTO purchaseOrderDTO) throws BusinessException {
        PurchaseOrder purchaseOrder = new PurchaseOrder(null, purchaseOrderDTO);
        purchaseOrder.setStatus(OrderStatus.DONE);
        purchaseOrder.setCustomer(customerService.findCustomerById(purchaseOrderDTO.customerId()));
        purchaseOrderRepository.save(purchaseOrder);

        List<PurchaseOrderItem> items = loadOrderItems(purchaseOrder, purchaseOrderDTO.items());
        orderItemRepository.saveAll(items);
        purchaseOrder.setItems(items);
        return purchaseOrder;
    }

    /**
     * Retrieves a purchase order by its ID.
     *
     * @param id the unique identifier of the purchase order
     * @return the mapped PurchaseOrderDTO if found, otherwise null
     */
    public ResponsePurchaseOrderDTO getPurchaseOrder(Integer id) throws BusinessException {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new BusinessException("Purchase order not found"));
        return purchaseOrder == null ? null : modelMapper.map(purchaseOrder, ResponsePurchaseOrderDTO.class);
    }

    /**
     * Deletes a purchase order by its ID.
     *
     * @param id the ID of the purchase order to be deleted
     */
    public void deletePurchaseOrder(Integer id) throws BusinessException {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new BusinessException("Purchase order not found"));
        purchaseOrder.setStatus(OrderStatus.CANCELED);
        purchaseOrderRepository.save(purchaseOrder);
    }

    /**
     * Updates a purchase order by saving the provided purchase order DTO.
     *
     * @param purchaseOrderDTO the purchase order DTO to be updated
     * @return the updated purchase order DTO
     */
    public ResponsePurchaseOrderDTO updatePurchaseOrder(Integer id, RequestPurchaseOrderDTO purchaseOrderDTO) throws BusinessException {
        PurchaseOrder purchaseOrder = new PurchaseOrder(id, purchaseOrderDTO);
        purchaseOrder.setCustomer(customerService.findCustomerById(purchaseOrderDTO.customerId()));
        purchaseOrderRepository.save(purchaseOrder);

        List<PurchaseOrderItem> items = loadOrderItems(purchaseOrder, purchaseOrderDTO.items());
        orderItemRepository.saveAll(items);
        purchaseOrder.setItems(items);
        return modelMapper.map(purchaseOrder, ResponsePurchaseOrderDTO.class);
    }

    /**
     * Finds a purchase order based on the provided purchase order DTO.
     *
     * @param params the purchase order DTO to search for
     * @return an object representing the found purchase order, or null if not found
     */
    public List<ProductDTO> findPurchaseOrderDTO(ResponsePurchaseOrderDTO params) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(modelMapper.map(params, PurchaseOrder.class), matcher);

        return modelMapper.map(purchaseOrderRepository.findAll(example), new TypeToken<List<ProductDTO>>() {
        }.getType());
    }

    /**
     * Updates the status of a purchase order.
     *
     * @param id   the ID of the purchase order
     * @param status the new status
     * @throws BusinessException if the purchase order is not found
     */
    public void updatePurchaseOrderStatus(Integer id, OrderStatus status) throws BusinessException {
        PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).orElseThrow(() -> new BusinessException("Purchase order not found"));
        purchaseOrder.setStatus(status);
        purchaseOrderRepository.save(purchaseOrder);
    }

    /**
     * Loads purchase order items from a list of DTO objects.
     *
     * @param order the purchase order
     * @param items the list of DTO objects
     * @return the list of purchase order items
     */
    private List<PurchaseOrderItem> loadOrderItems(PurchaseOrder order, List<RequestPurchaseOrderItemDTO> items) {
        return items
                .stream()
                .map(item -> new PurchaseOrderItem(order, item.quantity(), productService.findProductById(item.productId())))
                .toList();
    }

}