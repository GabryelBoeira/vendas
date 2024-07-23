package com.br.gabryel.localizacao;

import com.br.gabryel.localizacao.entity.Cidade;
import com.br.gabryel.localizacao.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        criarCidade();
        ListarCidades();
    }

    @Transactional
    public void criarCidade() {
        repository.save(new Cidade(1L, "São Paulo", 123L));
        repository.save(new Cidade(2L, "Rio de Janeiro", 456L));
        repository.save(new Cidade(3L, "Brasilia", 789L));
    }

    public void ListarCidades() {
        for (Cidade c : repository.findAll()) {
            System.out.println(c.toString());
        }
    }
}
