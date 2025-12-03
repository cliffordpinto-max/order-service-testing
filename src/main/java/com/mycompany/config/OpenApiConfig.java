package com.mycompany.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI/Swagger configuration.
 *
 * <p>Configures Swagger UI documentation for the API. Access at:
 * http://localhost:8081/order-service/swagger-ui.html
 */
@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("order-service API")
                .version("1.0.0")
                .description("Order Management Service")
                .contact(
                    new Contact()
                        .name("API Support")
                        .email("support@example.com")
                        .url("https://example.com"))
                .license(
                    new License()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")));
  }
}
