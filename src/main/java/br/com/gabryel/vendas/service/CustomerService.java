package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.entity.Customer;
import br.com.gabryel.vendas.exception.BusinessException;
import br.com.gabryel.vendas.repository.customer.CustomerJpaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public CustomerDTO saveCustomerDTO(CustomerDTO customerDTO) {
        return modelMapper.map(saveCustomer(customerDTO), CustomerDTO.class);
    }

    /**
     * Retrieves all customers from the database and maps them to a list of CustomerDTO objects.
     *
     * @return a list of CustomerDTO objects representing all customers in the database
     */
    public List<CustomerDTO> findAllCustomer() {
        return modelMapper.map(customerJpaRepository.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    /**
     * Find a customer by ID.
     *
     * @param id the ID of the customer to find
     * @return the customer DTO if found
     * @throws BusinessException if the customer is not found
     */
    public CustomerDTO findCustomerDTOById(Integer id) throws BusinessException {
        Customer customer = customerJpaRepository.findCustomerAndPurchaseOrdersById(id).orElseThrow(() -> new BusinessException("Customer not found"));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    /**
     * Find a customer by ID.
     *
     * @param id the ID of the customer to find
     * @return the customer entity if found
     */
    public Customer findCustomerById(Integer id) throws BusinessException {
        Customer customer = customerJpaRepository.findCustomerAndPurchaseOrdersById(id).orElseThrow(() -> new BusinessException("Customer not found"));
        customer.setOrders(null);
        return customer;
    }

    /**
     * Find a customer by name.
     *
     * @param name the name of the customer to find
     * @return the customer entity if found
     */
    public CustomerDTO findCustomerByName(String name) {
        Customer customer = customerJpaRepository.findByName(name);
        return customer == null ? null : modelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO updateCustomer(CustomerDTO customer) {
        return modelMapper.map(saveCustomer(customer), CustomerDTO.class);
    }

    /**
     * Find customers by parameters.
     *
     * @param params the parameters to search for customers
     * @return a list of customers that match the parameters
     */
    public List<CustomerDTO> findCustomerByParams(CustomerDTO params) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(modelMapper.map(params, Customer.class), matcher);

        return modelMapper.map(customerJpaRepository.findAll(example), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    private Customer saveCustomer(CustomerDTO customer) {
        return customerJpaRepository.save(modelMapper.map(customer, Customer.class));
    }

}
