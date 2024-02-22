//package com.Java_Training.Product_Management.utils;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.Java_Training.Product_Management.KeycloakSecurity.TokenApiClient;
//import com.Java_Training.Product_Management.KeycloakSecurity.UserRequest;
//
//@Component
//public class CreateKeyCloakUser {
//	
////	@Value("${spring.security.oauth2.client.provider.keycloak.token_endpoint}")
////	private String tokenUrl;
////	
////	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
////    private String clientId;
////	
////	@Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
////    private String clientSecret;
////	
////    private String grantType = "client_credentials";
//
//
//	private final String apiUrl = "http://localhost:8081/admin/realms/FirstRealm/users";
//	private final String token = new TokenApiClient().getToken();
//	
//	public boolean createUser(UserRequest userRequest) {
//		HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer " + token);
//
//        HttpEntity<UserRequest> request = new HttpEntity<>(userRequest, headers);
//
//        ResponseEntity<String> response = new RestTemplate().postForEntity(apiUrl, request, String.class);
//        
//        if(response.getStatusCode().is2xxSuccessful()) {
//        	return true;
//        }
//        else {
//        	return false;
//        }
//	}
//}
