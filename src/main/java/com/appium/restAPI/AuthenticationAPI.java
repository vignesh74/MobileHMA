package com.appium.restAPI;

import com.appium.exceptions.AutomationException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

public class AuthenticationAPI {
    public static String getAccessToken() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        Response res = RestAssured.
                given()
                .formParam("client_id", EnvironmentProperties.get("client_id"))
                .formParam("client_secret", EnvironmentProperties.get("client_secret"))
                .formParam("grant_type", "client_credentials")
                .post(EnvironmentProperties.get("4tress_URL"));
        String bearerToken = res.then().extract().path("access_token"); 
        String tokenType = res.then().extract().path("token_type");
        EnvironmentProperties.storeProp("access_token", bearerToken);
        EnvironmentProperties.storeProp("token_type", tokenType);
        res.prettyPrint();
        if (res.statusCode() != 200)
            throw new AutomationException("AuthenticationAPI - getAccessToken failed");
        return bearerToken;
    }
}
