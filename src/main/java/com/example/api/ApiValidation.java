package com.example.api;

import io.restassured.response.Response;
import org.testng.Assert;


public class ApiValidation {
    public static void validateResponseCode(Response response , int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(),expectedStatusCode,"status code mismatch");
    }

    public static void validateResponseTime(Response response , int maximumTime){

        Assert.assertTrue(response.getTime()<maximumTime,"response Time exceeded");

    }

}
