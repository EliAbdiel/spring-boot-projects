package com.coderforfun.banking.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Banking App",
                version = "1.0.0",
                description = "Demo project for Spring Boot Banking App"
        )
)
public class SwaggerConfig {
}
