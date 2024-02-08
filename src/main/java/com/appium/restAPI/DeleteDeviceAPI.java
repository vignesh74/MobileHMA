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

public class DeleteDeviceAPI {

    public static void deleteDeviceAPI() throws IOException {
        AuthenticationAPI.getAccessToken();
        config = config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

        String deleteUri = EnvironmentProperties.get("BASE_URL") + "/" + EnvironmentProperties.get("COMMON_SOURCE") + "/credential-container/" + EnvironmentProperties.get("device-id");
        TestUtils.log().info(deleteUri);

        Response res = RestAssured.
                given()
                .header("Authorization", EnvironmentProperties.get("token_type") + " " + EnvironmentProperties.get("access_token"))
                .contentType(EnvironmentProperties.get("MEDIA_TYPE"))
                .delete(deleteUri);
        res.prettyPrint();
        if (res.statusCode() != 204)
            throw new AutomationException("DeleteDeviceAPI failed");
    }
}
