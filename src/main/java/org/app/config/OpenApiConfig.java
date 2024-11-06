package org.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPIConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("MyApp")
                        .version("1.0.0")
                        .description("MyApp Service"));
    }
}
