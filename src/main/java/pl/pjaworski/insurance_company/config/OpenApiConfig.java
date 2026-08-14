package pl.pjaworski.insurance_company.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI insuranceCompanyOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Insurance Company Service API")
                        .description("API documentation for the Insurance Company Service")
                        .version("0.0.1-SNAPSHOT"));
    }
}
