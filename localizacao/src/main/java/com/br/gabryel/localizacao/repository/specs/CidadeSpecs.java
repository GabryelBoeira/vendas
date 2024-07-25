package com.br.gabryel.localizacao.repository.specs;

import com.br.gabryel.localizacao.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), nome);
    }

    public static Specification<Cidade> populacaoGreaterThan(Long populacao) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("populacao"), populacao);
    }

}
