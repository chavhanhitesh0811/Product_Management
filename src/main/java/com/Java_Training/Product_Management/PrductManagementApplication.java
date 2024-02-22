package com.Java_Training.Product_Management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@SecurityScheme(
	    name = "Keycloak"
	    , openIdConnectUrl = "http://localhost:8081/realms/FirstRealm/.well-known/openid-configuration"
	    , scheme = "bearer"
	    , type = SecuritySchemeType.OPENIDCONNECT
	    , in = SecuritySchemeIn.HEADER
	    )
public class PrductManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrductManagementApplication.class, args);
	}

}
