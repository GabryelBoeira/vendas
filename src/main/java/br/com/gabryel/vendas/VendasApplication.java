package br.com.gabryel.vendas;


import br.com.gabryel.vendas.entity.Customer;
import br.com.gabryel.vendas.repository.otherVersions.CustomerJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner save(@Autowired CustomerJdbcRepository customerRepository) {
        return args -> {
            String s1 = "nome do cliente: " + customerRepository.saveCustomer(new Customer("teste 1")).getName();
            System.out.println(s1);

            String s2 = "nome do cliente: " + customerRepository.saveCustomer(new Customer("teste 2")).getName();
            System.out.println(s2);

            String s3 = "nome do cliente: " + customerRepository.saveCustomer(new Customer("teste 3")).getName();
            System.out.println(s3);
        };
    }

    @Bean
    public CommandLineRunner findAll(@Autowired CustomerJdbcRepository customerRepository) {
        return args -> {
            customerRepository.findAllCustomer().forEach(System.out::println);
        };
    }

}
