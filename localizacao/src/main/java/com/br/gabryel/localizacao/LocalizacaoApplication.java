package com.br.gabryel.localizacao;

import com.br.gabryel.localizacao.entity.Cidade;
import com.br.gabryel.localizacao.repository.CidadeRepository;
import com.br.gabryel.localizacao.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

    @Autowired
    private CidadeService service;

    public static void main(String[] args) {
        SpringApplication.run(LocalizacaoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ListarCidades();
    }

    public void ListarCidades() {
        for (Cidade c : service.findByNomeSQLNativo("o")) {
            System.out.println(c.toString());
        }
    }

}
