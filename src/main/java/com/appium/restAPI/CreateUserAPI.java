package com.appium.restAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import static io.restassured.RestAssured.config;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class CreateUserAPI {

    /*public static String createUserAPI(boolean issueCredential) {
       AuthenticationAPI.getAccessToken();
        //Set Pre-requisite properties
        EnvironmentProperties.storeProp("email", "testuser" + (int) ((Math.random() * 9000000) + 1000000) + "@grr.la");
        EnvironmentProperties.storeProp("familyName", "familyName" + (int) ((Math.random() * 9000000) + 1000000));
        EnvironmentProperties.storeProp("givenName", "givenName" + (int) ((Math.random() * 9000000) + 1000000));
        EnvironmentProperties.storeProp("externalId", "1" + (int) ((Math.random() * 9000000) + 1000000));
        String schemas1 = EnvironmentProperties.get("schema-user-2.0");
        String externalId = EnvironmentProperties.get("externalId");
        String familyName = EnvironmentProperties.get("familyName");
        String givenName = EnvironmentProperties.get("givenName");
        String honorificSuffix = EnvironmentProperties.get("honorificSuffix");
        String honorificPrefix = EnvironmentProperties.get("honorificPrefix");
        String email = EnvironmentProperties.get("email");
        String partNumber = EnvironmentProperties.get("part-number");

        JSONArray schemas = new JSONArray();
        schemas.add(schemas1);
        schemas.add("urn:hid:scim:api:ma:2.1:UserAction");
        JSONObject objName = new JSONObject();
        objName.put("familyName", familyName);
        objName.put("givenName", givenName);
        objName.put("honorificSuffix", honorificSuffix);
        objName.put("honorificPrefix", honorificPrefix);
        JSONObject objURN = new JSONObject();
        objURN.put("createInvitationCode", "Y");
        objURN.put("sendInvitationEmail", "N");
        if (issueCredential) {
            objURN.put("assignCredential", "Y");
            objURN.put("partNumber", partNumber);
        } else {
            objURN.put("assignCredential", "N");
        }
        JSONArray emails = new JSONArray();
        JSONObject objEmail = new JSONObject();
        objEmail.put("value", email);
        emails.add(objEmail);
        JSONObject objMeta = new JSONObject();
        objMeta.put("resourceType", "PACSUser");

        JSONObject payLoad = new JSONObject();
        payLoad.put("schemas", schemas);
        payLoad.put("externalId", externalId);
        payLoad.put("name", objName);
        payLoad.put("urn:hid:scim:api:ma:2.1:UserAction", objURN);
        payLoad.put("emails", emails);
        payLoad.put("meta", objMeta);
        config = config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));
        RestAssured.useRelaxedHTTPSValidation();
        Response res = RestAssured.
                given()
                .header("Authorization", EnvironmentProperties.get("token_type") + " " + EnvironmentProperties.get("access_token"))
                .contentType(EnvironmentProperties.get("MEDIA_TYPE"))
                .body(payLoad.toString())
                .post(EnvironmentProperties.get("BASE_URL") + "/" + EnvironmentProperties.get("MA_CREATE_USER"));
        String id = res.then().extract().path("id").toString();
        String invitationCode = StringUtils.substringBetween(res.asString(), "invitationCode", "status")
                .replace("\"", "").replace(",", "").replace(":", "").trim();
        EnvironmentProperties.storeProp("user-id", id);
        EnvironmentProperties.storeProp("invitation-code", invitationCode);
        if (res.statusCode() != 201)
            throw new RuntimeException("CreateUserAPI failed");
        return invitationCode;

    }*/
}
