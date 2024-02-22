package com.Java_Training.Product_Management.config;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import com.Java_Training.Product_Management.services.KeycloakService;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

	@Autowired
	private KeycloakService keycloakService;

	@Value("${spring.security.oauth2.client.provider.keycloak.introspection_endpoint}")
	private String keycloakServerUrl;

	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
	private String clientId;

	@Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
	private String clientSecret;

	@Override
	public AbstractAuthenticationToken convert(Jwt jwt) {

//		if (!keycloakService.isTokenActive(jwt.getTokenValue(), keycloakServerUrl, clientId, clientSecret)) {
//			return new JwtAuthenticationToken(null);
//		} else {
			Collection<GrantedAuthority> roles = extractAuthorities(jwt);
			return new JwtAuthenticationToken(jwt, roles);
//		}
	}

	public Collection<GrantedAuthority> extractAuthorities(Jwt source) {
		Map<String, Object> realmAccess = source.getClaimAsMap("realm_access");

		if (Objects.nonNull(realmAccess)) {
			List<String> roles = (List<String>) realmAccess.get("roles");

			if (Objects.nonNull(roles)) {
				return roles.stream().map(rn -> new SimpleGrantedAuthority("ROLE_" + rn)).collect(Collectors.toList());
			}

		}

		return List.of();
	}
}