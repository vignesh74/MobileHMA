package com.appium.restAPI;

import com.appium.exceptions.AutomationException;
import com.appium.utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

import static io.restassured.RestAssured.config;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class CreateInvitationAPI {

    public static String createInvitationAPI(String userId, boolean issueCredential) throws IOException {
        AuthenticationAPI.getAccessToken();

        JSONArray schemas = new JSONArray();
        schemas.add("urn:hid:scim:api:ma:2.2:UserAction");

        JSONObject objURN1 = new JSONObject();
        objURN1.put("resourceType", "UserInvitation");

        JSONObject objURN = new JSONObject();
        objURN.put("createInvitationCode", "Y");
        objURN.put("sendInvitationEmail", "N");
        if (issueCredential) {
            objURN.put("assignCredential", "Y");
        } else {
            objURN.put("assignCredential", "N");
        }
        objURN.put("partNumber",EnvironmentProperties.get("part-number"));

        JSONObject payLoad = new JSONObject();
        payLoad.put("schemas", schemas);
        payLoad.put("urn:hid:scim:api:ma:2.2:UserAction", objURN);
        payLoad.put("meta", objURN1);
        config = config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

        String invitationUri = EnvironmentProperties.get("BASE_URL") + "/" + EnvironmentProperties.get("COMMON_SOURCE") + "/users/" + userId + "/invitation";
       TestUtils.log().info(invitationUri);

        Response res = RestAssured.
                given()
                .header("Authorization", EnvironmentProperties.get("token_type") + " " + EnvironmentProperties.get("access_token"))
                .contentType(EnvironmentProperties.get("MEDIA_TYPE"))
                .body(payLoad.toString())
                .post(invitationUri);
        res.prettyPrint();
        String invitationCode = StringUtils.substringBetween(res.asString(), "invitationCode", "status")
                .replace("\"", "").replace(",", "").replace(":", "").trim();
        EnvironmentProperties.storeProp("invitation-code", invitationCode);
        if (res.statusCode() != 201)
            throw new AutomationException("CreateInvitationAPI failed");
        return invitationCode;
    }
}
