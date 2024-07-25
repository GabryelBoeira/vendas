package com.br.gabryel.localizacao.service;

import com.br.gabryel.localizacao.entity.Cidade;
import com.br.gabryel.localizacao.repository.CidadeRepository;
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

    


}
