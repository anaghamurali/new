package com.example.tests;

import com.aventstack.extentreports.ExtentTest;
import com.example.api.*;
import io.restassured.response.Response;
import org.testng.annotations.*;

public class ParameterisedTests extends BaseTests {


    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() {
        return new Object[][]{
            {"1", "Leanne Graham"},
            {"2", "Ervin Howell"}
        };
    }

    @Test(dataProvider = "userDataProvider")
    public void testGetUser(String userId, String expectedName) {
        ExtentTest test = ExtentManager.createTest("get user test for ID " + userId);

        Response response = getRequest("/users/" + userId);
        System.out.println("hello "+response);

        ApiValidation.validateResponseCode(response, 200);
        JsonPathValidation.validateJsonPath(response, "name", expectedName);
        SchemaValidation.validateSchema(response, "schemas/user-schema.json");

        test.pass("Test passed successfully");

        Response response1 = postRequest("/users/" ,C.createPayload(userId,expectedName));

        System.out.println("hello "+response1);

        ApiValidation.validateResponseCode(response1, 201);
    }

    @AfterSuite
    public void generateReport() {
        ExtentManager.flush();  // Generate the final report
    }
}
