package br.com.alura.forum_hub_api.infra.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Forum Hub API")
                        .description("The Forum Hub API is a backend service designed for the Alura discussion forum. It allows registered\n" +
                                "        users to create, manage, and participate in discussion topics. Each topic includes a title and a message, is\n" +
                                "        associated with a specific user, and belongs to a particular course. This API provides the necessary endpoints\n" +
                                "        for handling user authentication, topic creation, and course management.")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("backend@alura"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://forum_hub/api/licenca")));

    }

}