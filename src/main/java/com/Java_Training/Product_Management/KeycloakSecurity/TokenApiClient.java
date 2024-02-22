//package com.Java_Training.Product_Management.KeycloakSecurity;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class TokenApiClient {
//	
////	@Value("${spring.security.oauth2.client.provider.keycloak.token_endpoint}")
//	private String tokenUrl = "http://localhost:8081/realms/FirstRealm/protocol/openid-connect/token";
//	
////	@Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
//    private String clientId = "admin-cli";
//	
////	@Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
//    private String clientSecret = "zJTNwsSAIxKOBdUNLvNf2dn8cfqIgbul";
//	
//    private String grantType = "client_credentials";
//
//    public String getToken() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("client_id", clientId);
//        map.add("client_secret", clientSecret);
//        map.add("grant_type", grantType);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//        ResponseEntity<String> response = new RestTemplate().postForEntity(tokenUrl, request, String.class);
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            // Parse the JSON response body to extract the access token
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode;
//            try {
//                jsonNode = objectMapper.readTree(response.getBody());
//                String accessToken = jsonNode.get("access_token").asText();
//                return accessToken;
//            } catch (Exception e) {
//                // Handle the exception
//                e.printStackTrace();
//                return null;
//            }
//        } else {
//            // Handle the error response
//            return null;
//        }
//    }
//}
