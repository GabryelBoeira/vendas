package br.com.gabryel.vendas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigurationProject {

    @Bean
    public String applicationName() {
        return "Sistema de vendas";
    }

}
