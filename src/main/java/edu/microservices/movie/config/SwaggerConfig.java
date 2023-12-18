package edu.microservices.movie.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API for the Management service movies ",
                version = "1.0",
                description = "API that exposes the endpoints for the Movies entities solution (Movies Service)"
            )
        )
public class SwaggerConfig {
    @Value("${app.version}")
    private String appVersion;
}
