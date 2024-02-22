package com.Java_Training.Product_Management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI schedulePortalOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Product-Management")
						.description("This is a product management application.").version("1.0.0")
						.license(new License().name("Apache 1.0").url("apache.com")))
				.externalDocs(new ExternalDocumentation().description("product-management wiki")
						.url("wikipedia.com"));
	}
}