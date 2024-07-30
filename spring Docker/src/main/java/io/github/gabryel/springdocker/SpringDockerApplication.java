package io.github.gabryel.springdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringDockerApplication {

    @GetMapping("/")
    public String getGreeting() {
        return "Hello World from docker!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDockerApplication.class, args);
    }

}
