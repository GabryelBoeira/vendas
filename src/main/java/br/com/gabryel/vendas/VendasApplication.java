package br.com.gabryel.vendas;


import br.com.gabryel.vendas.config.exemploField.Animal;
import br.com.gabryel.vendas.config.exemploField.Gato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.gabryel.vendas.config"})
@RestController
public class VendasApplication {

    @Value("${spring.application.name}")
    private String applicationName;

    @Gato
    private Animal animal;

    @Bean
    public CommandLineRunner executarBarulho() {
        return args -> {
            this.animal.fazerBarulho();
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    @GetMapping("/")
    public String save() {
        return applicationName;
    }

}
