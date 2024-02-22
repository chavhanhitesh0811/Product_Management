package com.Java_Training.Product_Management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	public static final String[] PUBLIC_URLS= {
			"/auth/**",
			"/v3/api-docs/**",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**"
	};
	
	@Autowired
	private JwtAuthConverter jwtAuthConverter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(PUBLIC_URLS).permitAll().anyRequest().authenticated())
				.oauth2ResourceServer(t -> t.jwt(configurer -> configurer.jwtAuthenticationConverter(jwtAuthConverter)))
	//				.oauth2ResourceServer(t-> {
	//					t.jwt(Customizer.withDefaults());
	//				})
				.sessionManagement(t -> t.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}
}