package com.winter25.RSVPmanager25.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Winter2025 RSVP manager API Documentation")
                        .description("Swagger UI documentation for rsvp and event management.")
                        .version("1.0.0"))

                .addSecurityItem(new SecurityRequirement().addList("JavaInUseSecurityScheme"))
                .components(
                        new Components()
                                .addSecuritySchemes("JavaInUseSecurityScheme", new SecurityScheme()
                                            .name("JavaInUseSecurityScheme")
                                            .type(SecurityScheme.Type.HTTP)
                                            .scheme("bearer")
                                            .bearerFormat("JWT")));

    }

}
