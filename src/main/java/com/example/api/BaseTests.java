package com.example.api;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.util.HashMap;
import java.util.Map;


public class BaseTests {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTests.class);

    
    public BaseTests(){
        RestAssured.baseURI =ConfigManager.getProperty("base.url");
    }

    public Response getRequest(String endpoint){

        logger.info("Sending get request to {}",endpoint);
        return given().header("Authorization","Bearer"+Authenticator.getToken()).log().all()
        .when().get(endpoint);
    }

    public Response postRequest(String endpoint, Map<String,Object> payload){

        logger.info("send post request to ()", endpoint);
        return given().header("Authorization","Bearer"+Authenticator.getToken()).log().all()
        .body(payload)
        .when().post(endpoint);


    }

}
