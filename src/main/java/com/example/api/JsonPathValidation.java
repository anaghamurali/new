package com.example.api;
import io.restassured.response.Response;
import org.testng.Assert;

public class JsonPathValidation {

    public static void validateJsonPath(Response response , String jsonPath, Object expectedValue){
        Assert.assertEquals(response.jsonPath().get(jsonPath), expectedValue , "jsonpathvalidation failed");
        
    }


}





