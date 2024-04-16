package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.dto.CustomerDTO;
import br.com.gabryel.vendas.entity.Customer;
import br.com.gabryel.vendas.mapper.CustomerMapper;
import br.com.gabryel.vendas.repository.CustomerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerMapper = Mappers.getMapper(CustomerMapper.class);
        this.customerRepository = customerRepository;
    }

    public CustomerDTO saveCustomer() {
        return customerMapper.toDTO(customerRepository.saveCustomer(new Customer("Gabryel")));
    }

    public List<CustomerDTO> findAllCustomer() {
        return customerMapper.toDTOs(customerRepository.findAllCustomer());
    }

}
