package br.com.gabryel.vendas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class ConfigDevelopment {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Modo selecionado de desenvolvimento");
        };
    }
}
