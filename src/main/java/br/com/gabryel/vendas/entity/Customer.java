package br.com.gabryel.vendas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer id;

    private String name;

    public Customer(String name) {
        this.name = name;
    }

}
