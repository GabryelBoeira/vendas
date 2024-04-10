package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.entity.Customer;
import br.com.gabryel.vendas.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer() {
        return customerRepository.saveCustomer(new Customer("Gabryel"));
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAllCustomer();
    }

}
