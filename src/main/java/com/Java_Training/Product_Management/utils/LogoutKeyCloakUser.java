//package com.Java_Training.Product_Management.utils;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//public class LogoutKeyCloakUser {
//
//	private final String tokenUrl = "http://localhost:8081/realms/FirstRealm/protocol/openid-connect/logout";
//    private final String clientId = "admin-cli";
//    private final String clientSecret = "zJTNwsSAIxKOBdUNLvNf2dn8cfqIgbul";
//    
//	public boolean Logout(String refreshToken) {
//
//		HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("client_id", clientId);
//        map.add("client_secret", clientSecret);
//        map.add("refresh_token", refreshToken);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//        ResponseEntity<String> response = new RestTemplate().postForEntity(tokenUrl, request, String.class);
//
//        if(response.getStatusCodeValue() == 204) {
//        	return true;
//        }
//        else {
//        	return false;
//        }
//	}
//}
