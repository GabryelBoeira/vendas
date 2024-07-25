package com.br.gabryel.localizacao.service;

import com.br.gabryel.localizacao.entity.Cidade;
import com.br.gabryel.localizacao.repository.CidadeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    private final CidadeRepository repository;

    public CidadeService(CidadeRepository repository) {
        this.repository = repository;
    }

    public List<Cidade> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public List<Cidade> findByPopulacao(Long populacao) {
        return repository.findByPopulacao(populacao);
    }

    public Page<Cidade> findByNomeLike(String nome) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "populacao"));
        return repository.findByNomeLike(nome, pageable);
    }

    public List<Cidade> findByFilterDynamic(Cidade cidade) {
        var matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreNullValues();

        return repository.findAll( Example.of(cidade, matcher));
    }

}
