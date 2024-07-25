package com.br.gabryel.localizacao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "tb_cidades")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cidade implements Serializable  {

    private static final long serialVersionUID = -8562205829485761237L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    @Column(name = "populacao")
    private Long populacao;

    public Cidade(String nome) {
        this.nome = nome;
        //this.populacao = populacao;
    }

}
