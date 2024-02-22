package com.Java_Training.Product_Management.services;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class KeycloakService {

    public boolean isTokenActive(String accessToken,String keycloakServerUrl,String clientId,String clientSecret) {
    	
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(clientId, clientSecret);

        // Request body
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("token", accessToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = new RestTemplate().exchange(keycloakServerUrl, HttpMethod.POST, request, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Map<String, Boolean> responseBody = response.getBody();
            if (responseBody != null && responseBody.containsKey("active")) {
                return responseBody.get("active");
            }
        }

        return false;
    }
}

