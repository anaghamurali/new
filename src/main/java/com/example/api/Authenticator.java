package com.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Authenticator {

    // Correct Logger initialization
    public static final Logger logger = LoggerFactory.getLogger(Authenticator.class);
    
    // Token variable
    private static String token;

    // Method to get the authentication token
    public static String getToken() {
        if (token == null || token.isEmpty()) {
            logger.info("Fetching new authentication token");

            // Make the POST request to get the token
            Response response = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(getAuthPayload())  // Get the authentication payload
                    .when()
                    .post(ConfigManager.getProperty("auth.url"));  // Corrected the reference to auth.url

            // Handle the response
            if (response.getStatusCode() == 200) {
                token = response.jsonPath().getString("access_token");
                logger.info("Token accessed successfully");
            } else {
                logger.error("Failed to fetch token: {}", response.getBody().asString());
            }
        }
        return token;  // Return the token (either new or cached)
    }

    // Method to build the authentication payload
    private static Map<String, String> getAuthPayload() {
        Map<String, String> payload = new HashMap<>();
        payload.put("username", ConfigManager.getProperty("username"));
        payload.put("password", ConfigManager.getProperty("password"));
        return payload;
    }
}
