package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.entity.Customer;
import br.com.gabryel.vendas.exception.BusinessException;
import br.com.gabryel.vendas.repository.CustomerJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerJpaRepository customerJpaRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerJpaRepository customerJpaRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.customerJpaRepository = customerJpaRepository;
    }

    public CustomerDTO saveCustomer() {
        return modelMapper.map(customerJpaRepository.save(new Customer("Gabryel")), CustomerDTO.class);
    }

    public List<CustomerDTO> findAllCustomer() {
        return  modelMapper.map(customerJpaRepository.findAll(), new TypeToken<List<CustomerDTO>>() {}.getType());
    }

    public CustomerDTO findCustomerAndPurchaseOrderById(Integer id) {
        return modelMapper.map(customerJpaRepository.findCustomerAndPurchaseOrdersById(id), CustomerDTO.class);
    }

    /**
     * Find a customer by ID.
     *
     * @param  id  the ID of the customer to find
     * @return     the customer entity if found
     * @throws BusinessException if the customer is not found
     */
    public Customer findCustomerById(Integer id) throws BusinessException {
        return customerJpaRepository.findById(id).orElseThrow(() -> new BusinessException("Customer not found"));
    }
}
