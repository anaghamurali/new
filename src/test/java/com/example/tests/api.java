package com.example.tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class api {

    @Test
    public void test1(){
        RestAssured.baseURI ="https://jsonplaceholder.typicode.com";

        String res=given().log().all()
        .when().get("/posts")
        .then().statusCode(200).extract().response().asString();


        JsonPath js = new JsonPath(res);
        System.out.println(js.getInt("[6].id"));

        for(int i=0; i< js.getInt("size()");i++){

            if(js.getString("["+i+"].title").equalsIgnoreCase("rem alias distinctio quo quis")){
                System.out.println("body : " +js.getString("["+i+"].body"));
                break;
            }
            
        }

    }

}
