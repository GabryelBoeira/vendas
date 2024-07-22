package br.com.gabryel.vendas.config.swagger;

import br.com.gabryel.vendas.config.Messages;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenAPIConfig {

    @Autowired
    private Messages messages;

    @Bean
    public OpenAPI myOpenAPI() {
        License license = new License();
        license.setName(messages.getMessage("swagger.license.description"));
        license.setUrl(messages.getMessage("swagger.license.url"));

        Info info = new Info()
                .title(messages.getMessage("swagger.title"))
                .description(messages.getMessage("swagger.description"))
                .termsOfService(messages.getMessage("swagger.terms.service"))
                .version(messages.getMessage("swagger.version"))
                .license(license);

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication", Arrays.asList("read", "write")))
                .components(new Components().addSecuritySchemes("Bearer Authentication", securityScheme()))
                .info(info);
    }

    /**
     * Returns a SecurityScheme object representing the bearer authentication scheme.
     *
     * @return a SecurityScheme object with the name "bearerAuth", type HTTP, scheme "bearer", and bearer format "JWT"
     */
    private SecurityScheme securityScheme() {
        return new SecurityScheme()
                .name("bearerAuth")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");
    }

}
