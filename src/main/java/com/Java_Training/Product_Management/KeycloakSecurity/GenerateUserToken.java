package com.Java_Training.Product_Management.KeycloakSecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GenerateUserToken {

	private final String tokenUrl = "http://localhost:8081/realms/FirstRealm/protocol/openid-connect/token";
    private final String clientId = "admin-cli";
    private final String clientSecret = "zJTNwsSAIxKOBdUNLvNf2dn8cfqIgbul";
    private final String grantType = "password";

    public List<String> getToken(String username , String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("grant_type", grantType);
        map.add("username", username);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = new RestTemplate().postForEntity(tokenUrl, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Parse the JSON response body to extract the access token
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode;
            try {
                jsonNode = objectMapper.readTree(response.getBody());
                String accessToken = jsonNode.get("access_token").asText();
                String refreshToken = jsonNode.get("refresh_token").asText();
                List<String>tokenList = new ArrayList<String>();
                tokenList.add(accessToken);
                tokenList.add(refreshToken);
				return tokenList;
            } catch (Exception e) {
                // Handle the exception
                e.printStackTrace();
                return null;
            }
        } else {
            // Handle the error response
            return null;
        }
    }
}
