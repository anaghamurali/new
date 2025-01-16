package com.example.api;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.response.Response;

public class SchemaValidation {

    public static void validateSchema(Response response, String schemapath){

        response.then().assertThat().body(matchesJsonSchemaInClasspath(schemapath));
    }



}
