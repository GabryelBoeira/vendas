package br.com.gabryel.vendas.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    public String saveCustomer() {
        return "Cliente Salvo";
    }

}
