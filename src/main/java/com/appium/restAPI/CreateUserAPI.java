package com.appium.restAPI;

import io.restassured.path.json.JsonPath;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;

public class CreateUserAPI {

    private static List<String> cardDetails = new ArrayList<>();

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

    public static List<String> createGWUser(String access_token, String id_token, String token_type) throws IOException {
        List<String> token = null;
        try {
            String createUserParam = "/scim/organization/7512113/users";

            JSONObject requestBody = new org.json.JSONObject();
            requestBody.put("schemas", new org.json.JSONArray()
                    .put("urn:ietf:params:scim:schemas:core:2.0:User")
                    .put("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User"));

            requestBody.put("userName", "42939887884948" + Math.random());
            requestBody.put("externalId", "Vignesh");
            requestBody.put("displayName", "Vignesh Rajesh");

            JSONObject name = new org.json.JSONObject();
            name.put("givenName", "Bernita");
            name.put("familyName", "McLaughlin");
            name.put("middleName", "P");
            name.put("honorificPrefix", "test");
            name.put("honorificSuffix", "test");
            requestBody.put("name", name);

            JSONArray emails = new org.json.JSONArray();
            JSONObject email = new org.json.JSONObject();
            email.put("value", "testuser1" + Math.random() + "@vrr.la");
            email.put("type", "personal");
            emails.put(email);
            requestBody.put("emails", emails);

            JSONArray phoneNumbers = new org.json.JSONArray();
            org.json.JSONObject phoneNumber = new org.json.JSONObject();
            phoneNumber.put("value", "9944952202");
            phoneNumber.put("type", "personal");
            phoneNumbers.put(phoneNumber);
            requestBody.put("phoneNumbers", phoneNumbers);

            JSONArray roles = new org.json.JSONArray();
            JSONObject role1 = new org.json.JSONObject();
            role1.put("value", "391d87ae-0525-448d-b50b-c3a73bb6e04f");
            role1.put("type", "secondary");
            role1.put("display", "ROLE_USER");
            role1.put("primary", true);

            JSONObject role2 = new org.json.JSONObject();
            role2.put("value", "007c33dd-3434-4571-a214-cd4c5a15ec51");
            role2.put("type", "primary");
            role2.put("display", "ROLE_ADMIN");
            role2.put("primary", false);

            roles.put(role1);
            roles.put(role2);
            requestBody.put("roles", roles);

            JSONArray groups = new org.json.JSONArray();
            JSONObject group1 = new org.json.JSONObject();
            group1.put("display", "Account Group");
            group1.put("value", "e9e30dba-f08f-4109-8486-d5c6a331660a");
            group1.put("$ref", "https://example.com/v2/Groups/e9e30dba-f08f-4109-8486-d5c6a331660a");

            JSONObject group2 = new org.json.JSONObject();
            group2.put("display", "Sales Group");
            group2.put("value", "1b5f5b0a-a1c0-4d57-ba10-374971c2d6db");
            group2.put("$ref", "https://example.com/v2/Groups/1b5f5b0a-a1c0-4d57-ba10-374971c2d6db");

            groups.put(group1);
            groups.put(group2);
            requestBody.put("groups", groups);

            requestBody.put("active", true);
            requestBody.put("userType", "Employee");

            JSONArray photos = new JSONArray();
            JSONObject photo1 = new org.json.JSONObject();
            photo1.put("value", "https://user-photo-sample.s3.amazonaws.com/golf.png");
            photo1.put("type", "photo");

            JSONObject photo2 = new org.json.JSONObject();
            photo2.put("value", "https://user-photo-sample.s3.amazonaws.com/angrybird.png");
            photo2.put("type", "photo");

            photos.put(photo1);
            photos.put(photo2);
            requestBody.put("photos", photos);

            JSONObject enterpriseExtension = new org.json.JSONObject();
            enterpriseExtension.put("employeeNumber", "KPWOPRO1");
            enterpriseExtension.put("department", "HID-PACS");
            enterpriseExtension.put("organization", "Apple Wallet");
            requestBody.put("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User", enterpriseExtension);

            JSONObject origoExtension = new org.json.JSONObject();
            JSONObject domainKey = new JSONObject();
            domainKey.put("domainId", "Domain123");
            origoExtension.put("domainKey", domainKey);
            requestBody.put("urn:ietf:params:scim:schemas:extension:origo:1.0:User", origoExtension);

            String createUserResponse = given()
                    .header("x-requestId", "12312384")
                    .header("Content-Type", "application/json")
                    .header("Authorization", token_type + " " + access_token)
                    .header("Application-ID", "HID-ORIGO-ENGINEERING")
                    .body(requestBody.toString())
                    .when().post(createUserParam)
                    .then().assertThat().statusCode(201).extract().asString();

            JsonPath js1 = new JsonPath(createUserResponse);
            String id = js1.getString("id");

            token = createGWPassBasicRequest(id, access_token, token_type);

        } catch (Exception e) {
            System.out.println("catch... " + e.getMessage());
        }
        return token;
    }

    public static List<String> createGWPassBasicRequest(String id, String access_token, String token_type) {
        List cardDetails = null;
        try {

            String createPassBasicRequestParam = "/organization/7512113/pass";
            baseURI = "https://credential-management.api.origo.hidglobal.com";
            JSONObject requestBody1 = new JSONObject();
            requestBody1.put("passTemplateId", "7b4f733d-3a4e-479e-82fe-5c4d39f73830");
            requestBody1.put("userId", id);

            JSONObject issuanceToken = new JSONObject();
            JSONObject validity = new JSONObject();
            validity.put("endDateTime", "2025-12-15T06:36:06.193014Z");
            issuanceToken.put("validity", validity);
            requestBody1.put("issuanceToken", issuanceToken);

            String createPassBasicRequestResponse = given()
                    .header("Authorization", token_type + " " + access_token)
                    .header("Application-ID", "HID-ORIGO-ENGINEERING")
                    .header("Content-Type", "application/json")
                    .body(requestBody1.toString())
                    .when().post(createPassBasicRequestParam)
                    .then().assertThat().statusCode(201).extract().asString();

            JsonPath js2 = new JsonPath(createPassBasicRequestResponse);
            String token = js2.getString("issuanceToken.token");
            String createPassID = js2.getString("id");

            cardDetails = new ArrayList<>();
            cardDetails.add(token);
            cardDetails.add(createPassID);
            cardDetails.add(token_type);
            cardDetails.add(access_token);

            setCardDetails(token, createPassID, token_type, access_token);
        } catch (Exception e) {
            System.out.println("xxxxx " + e);
        }
        return cardDetails;
    }

    private static void setCardDetails(String token, String createPassID, String token_type, String access_token) {
        cardDetails.add(token);
        cardDetails.add(createPassID);
        cardDetails.add(token_type);
        cardDetails.add(access_token);
    }

    public static List<String> getCardDetails() {
        return cardDetails;
    }

    public static void suspendGWPass(List<String> input){
        try{
            String createPassID = input.get(0);
            String token_type = input.get(1);
            String access_token = input.get(2);

            baseURI = "https://credential-management.api.origo.hidglobal.com";
            String suspendPassParam = "/organization/7512113/pass/"+createPassID+"/status";

            JSONObject requestBody3 = new JSONObject();
            requestBody3.put("action","SUSPEND");
            requestBody3.put("reason","User no longer work here");

            String suspendPass = given()
                    .header("Authorization", token_type+ " " + access_token)
                    .header("Application-ID", "HID-ORIGO-ENGINEERING")
                    .header("Content-Type", "application/json")
                    .body(requestBody3.toString())
                    .when()
                    .put(suspendPassParam)
                    .then().assertThat().statusCode(202).toString();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void resumeGWPass(List<String> input){
        try{
            String createPassID = input.get(0);
            String token_type = input.get(1);
            String access_token = input.get(2);

            System.out.println(createPassID);
            System.out.println(token_type);
            System.out.println(access_token);

            baseURI = "https://credential-management.api.origo.hidglobal.com";
            String resumePassParam = "/organization/7512113/pass/"+createPassID+"/status";

            JSONObject requestBody3 = new JSONObject();
            requestBody3.put("action","RESUME");
            requestBody3.put("reason","User has resumed");

            String resumePass = given()
                    .header("Authorization", token_type+ " " + access_token)
                    .header("Application-ID", "HID-ORIGO-ENGINEERING")
                    .header("Content-Type", "application/json")
                    .body(requestBody3.toString())
                    .when()
                    .put(resumePassParam)
                    .then().assertThat().statusCode(202).toString();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void revokeGWPass(List<String> input){
        try{
            String createPassID = input.get(0);
            String token_type = input.get(1);
            String access_token = input.get(2);

            baseURI = "https://credential-management.api.origo.hidglobal.com";
            String revokePassParam = "/organization/7512113/pass/"+createPassID;

            String revokePass = given()
                    .header("Authorization", token_type+ " " + access_token)
                    .header("Application-ID", "HID-ORIGO-ENGINEERING")
                    .header("Content-Type", "application/json")
                    .when()
                    .delete(revokePassParam)
                    .then().assertThat().statusCode(202).toString();

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void getStatus(List<String> input){
        try{
            String token_type = input.get(0);
            String access_token = input.get(1);
            String pass_ID = input.get(2);
            String application_ID = input.get(3);
            String organization_ID = "7512113";
            baseURI = "https://credential-management.api.origo.hidglobal.com";
            String getPassParam = "/organization/7512113/pass/"+pass_ID;

            String getStatus = given()
                    .header("Authorization", token_type+ " " + access_token)
                    .header("Application-ID", "HID-ORIGO-ENGINEERING")
                    .header("Content-Type", "application/json")
                    .when()
                    .get(getPassParam)
                    .then().assertThat().statusCode(200).extract().response().asString();
            JsonPath js11 = new JsonPath(getStatus);
            String id = js11.getString("statusid");
            String userid = js11.getString("userId");
            String status = js11.getString("status");
            System.out.println("****** "+status+" *****" );
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
