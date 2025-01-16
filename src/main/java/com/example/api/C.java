package com.example.api;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;


public class C {
    public static Map<String,Object> createPayload(String userId, String expectedName) {
        Map<String,Object> payload = new HashMap<>();
        payload.put("id",userId);
        payload.put("name",expectedName);
        return payload;

    }

   

}
