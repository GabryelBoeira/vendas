package com.br.gabryel.localizacao.repository.specs;

import com.br.gabryel.localizacao.entity.Cidade;
import org.springframework.data.jpa.domain.Specification;

public abstract class CidadeSpecs {

    public static Specification<Cidade> nomeLike(String nome) {
        return (root, query, cb) -> cb.like(cb.upper(root.get("nome")), "%" + nome + "%".toUpperCase());
    }

    public static Specification<Cidade> populacaoGreaterThan(Long populacao) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("populacao"), populacao);
    }

    public static Specification<Cidade> idEqual(Long id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<Cidade> populacaoBetween(Long min, Long max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("populacao"), min, max);
    }

}
