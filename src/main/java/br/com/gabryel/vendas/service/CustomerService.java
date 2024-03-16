package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String saveCustomer() {
        return customerRepository.saveCustomer();
    }

}
