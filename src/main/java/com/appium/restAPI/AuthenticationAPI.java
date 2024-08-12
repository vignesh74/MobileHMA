package com.appium.restAPI;

import com.appium.exceptions.AutomationException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

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

    public static List<String> getGWToken() {
        List<String> result = null;
        try {
            RestAssured.baseURI = "https://api.origo.hidglobal.com";
            String authParamToken = "/authentication/customer/7512113/token";

            String authenticationResponse = given()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .formParam("client_id", "7512113-OSRV6893557897")
                    .formParam("client_secret", "Welcome@123")
                    .formParam("grant_type", "client_credentials")
                    .when().post(authParamToken)
                    .then().assertThat().statusCode(200).extract().asString();

            JsonPath js = new JsonPath(authenticationResponse);
            String access_token = js.getString("access_token");
            String id_token = js.getString("id_token");
            String token_type = js.getString("token_type");

            result = CreateUserAPI.createGWUser(access_token, id_token, token_type);

//            System.out.println("token 1 "+token);

        } catch (Exception e) {
            System.out.println("catch... " + e.getMessage());
        }
        return result;
    }
}
