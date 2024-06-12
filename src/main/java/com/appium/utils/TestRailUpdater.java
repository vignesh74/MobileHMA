package com.appium.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.appium.testrail.APIClient;

public class TestRailUpdater {

    private static final String PASSED_STATUS_ID = "1"; // Replace with the actual TestRail status ID for passed tests
    private static final String FAILED_STATUS_ID = "5"; // Replace with the actual TestRail status ID for failed tests
    private static final String UNTESTED_STATUS_ID = "3"; // Replace with the actual TestRail status ID for untested tests
    public void updateStatus() {
        try {
            APIClient testRailClient = new APIClient(ConfigLoader.getInstance().getBaseUrlTestRail());
            testRailClient.setUser(ConfigLoader.getInstance().getUsernameTestRail());
            testRailClient.setPassword(ConfigLoader.getInstance().getApikeyTestRail());
            // Parse the Cucumber JSON report
            Map<Integer, String> testRailResults = new HashMap<>();
            JsonReader reader = null;
            try {
                reader = new JsonReader(new FileReader("target/cucumber-reports/cucumber-json-report/cucumber.json"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            JsonArray features = new Gson().fromJson(reader, JsonArray.class);
            for (JsonElement featureElement : features) {
                JsonObject feature = featureElement.getAsJsonObject();
                JsonArray elements = feature.getAsJsonArray("elements");
                for (JsonElement elementElement : elements) {
                    JsonObject element = elementElement.getAsJsonObject();
                    String scenarioName = element.get("name").getAsString();
                    if (scenarioName.contains("_TC-")) {
                        JsonArray steps = element.getAsJsonArray("steps");
                        for (JsonElement stepElement : steps) {
                            JsonObject step = stepElement.getAsJsonObject();
                            JsonObject result = step.getAsJsonObject("result");
                            result.get("status").getAsString();
                            System.out.println(result);
                            if (result != null) {
                                if (result.get("status").getAsString().equals("passed")) {
                                    // Test passed
                                    int testCaseId = getTestCaseId(scenarioName);
                                    testRailResults.put(testCaseId, PASSED_STATUS_ID);
                                } else if (result.get("status").getAsString().equals("failed")) {
                                    // Test failed
                                    int testCaseId = getTestCaseId(scenarioName);
                                    testRailResults.put(testCaseId, FAILED_STATUS_ID+"|"+result.get("error_message").getAsString());
                                    break;
                                } else {
                                    // Test untested
                                    int testCaseId = getTestCaseId(scenarioName);
                                    testRailResults.put(testCaseId, UNTESTED_STATUS_ID);
                                }
                            }
                        }
                    }
                }
            }
            for (Map.Entry<Integer, String> entry : testRailResults.entrySet()) {
                int testCaseId = entry.getKey();
               String errorComments=null;
                int statusId =0;
                if((entry.getValue()).contains("|")){
                    statusId= Integer.parseInt(entry.getValue().split("|")[0]);
                    errorComments=entry.getValue();
                    errorComments=errorComments.replace("5|","");
                }else {
                     statusId = Integer.parseInt(entry.getValue());
                    errorComments="Executed by Automation";
                }
                JSONObject data = new JSONObject();
                data.put("status_id", statusId);
                data.put("comment", errorComments);
                testRailClient.sendPost("add_result_for_case/" + ConfigLoader.getInstance().getTestRunTestRail() + "/" + testCaseId, data);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static int getTestCaseId(String scenarioName) {
        String testId = null;
        try {
            // Assuming scenario names follow a convention like "TC123: Scenario description"
            // Regex pattern to extract the numeric ID following "TC-"
            Pattern pattern = Pattern.compile("(?<=TC-)\\d+");
            Matcher matcher = pattern.matcher(scenarioName);

            if (matcher.find()) {
                testId = matcher.group();
                System.out.println("Extracted Test ID: " + testId);
            } else {
                System.out.println("No Test ID found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Integer.parseInt(testId);
    }
}

