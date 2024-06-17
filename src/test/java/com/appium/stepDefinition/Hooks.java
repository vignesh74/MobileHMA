package com.appium.stepDefinition;

import com.appium.HIDPages.android.Andr_HIDSettingsScreenPage;
import com.appium.HIDPages.android.Andr_HandlePopUps;
import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.enums.AuthorType;
import com.appium.manager.DriverManager;
import com.appium.utils.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import com.appium.base.BasePage;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;

import static com.appium.constants.FrameworkConstants.YES;
import static com.appium.utils.SerialPortUtils.basePage;

public class Hooks {
    Andr_HandlePopUps handlePopUps = new Andr_HandlePopUps();

    /**
     * addScreenshotForScenario - This method is used to add screenshots whenever scenario got passed ,failed or skipped
     *
     * @param scenario-
     *         Scenario
     * @throws IOException
     *         Date- 06/03/2023
     **/
    /*@AfterStep
    public static void addScreenshotForScenario(Scenario scenario) {
        try{

            basePage.waitForGivenTime(1);
            String status = String.valueOf(scenario.getStatus());
            if(scenario.getName().equalsIgnoreCase("ANDR_11_10_upgrade: Verify the upgrade of app")){
                byte[] screenshot = null;
            }else{
                byte[] screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
                if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES) && status.equalsIgnoreCase("PASSED")) {
                    if (ConfigLoader.getInstance().getBase64Screenshot().equalsIgnoreCase(YES)) {
                        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
                    } else {
                        scenario.attach(screenshot, MessageConstants.IMAGE_PNG_STRING, "");
                    }
                } else if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES) && status.equalsIgnoreCase("FAILED")) {
                    if (ConfigLoader.getInstance().getBase64Screenshot().equalsIgnoreCase(YES)) {
                        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
                    } else {
                        scenario.attach(screenshot, MessageConstants.IMAGE_PNG_STRING, "");
                    }
                } else if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES) && status.equalsIgnoreCase("SKIPPED")) {
                    if (ConfigLoader.getInstance().getBase64Screenshot().equalsIgnoreCase(YES)) {
                        ExtentCucumberAdapter.getCurrentStep().log(Status.SKIP, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
                    } else {
                        scenario.attach(screenshot, MessageConstants.IMAGE_PNG_STRING, "");
                    }
                }
            }

        }catch(Exception e){
            System.out.println("addScreenshotForScenario "+e);
        }

    }*/

    @AfterStep
    public static void addScreenshotForScenario(Scenario scenario) {
        try {
            basePage.waitForGivenTime(1);
            String status = String.valueOf(scenario.getStatus());

            // Declare the screenshot variable here
            byte[] screenshot = null;

            // Check if the WebDriver session is active
            if (DriverManager.getDriver() != null) {
                // Capture screenshot only if the scenario name doesn't match the specific case
                if (!scenario.getName().equalsIgnoreCase("ANDR_11_10_upgrade: Verify the upgrade of app")) {
                    try {
                        screenshot = DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
                    } catch (WebDriverException e) {
                        System.out.println("Error capturing screenshot: " + e);
                    }
                }

                // Determine if screenshot is needed based on status and configuration
                boolean shouldAttachScreenshot = false;
                String base64Image = null;

                if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES) && status.equalsIgnoreCase("PASSED")) {
                    shouldAttachScreenshot = true;
                    if (ConfigLoader.getInstance().getBase64Screenshot().equalsIgnoreCase(YES)) {
                        base64Image = ScreenshotUtils.getBase64Image();
                        ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
                    }
                } else if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES) && status.equalsIgnoreCase("FAILED")) {
                    shouldAttachScreenshot = true;
                    if (ConfigLoader.getInstance().getBase64Screenshot().equalsIgnoreCase(YES)) {
                        base64Image = ScreenshotUtils.getBase64Image();
                        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
                    }
                } else if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES) && status.equalsIgnoreCase("SKIPPED")) {
                    shouldAttachScreenshot = true;
                    if (ConfigLoader.getInstance().getBase64Screenshot().equalsIgnoreCase(YES)) {
                        base64Image = ScreenshotUtils.getBase64Image();
                        ExtentCucumberAdapter.getCurrentStep().log(Status.SKIP, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
                    }
                }

                // Attach screenshot if needed and not in base64 format
                if (shouldAttachScreenshot && base64Image == null && screenshot != null) {
                    scenario.attach(screenshot, MessageConstants.IMAGE_PNG_STRING, "");
                }
            } else {
                System.out.println("WebDriver session is not active. Skipping screenshot capture.");
            }

        } catch (Exception e) {
            System.out.println("addScreenshotForScenario " + e);
        }
    }


    /**
     * beforeScenario- This method is used to set application details to the extent report
     *
     * @param scenario
     *         -Scenario Date- 06/03/2023
     */
    @Before
    public void beforeScenario(Scenario scenario) {
        scenario.log("Application Name:" + ApplicationInfoUtils.getApplicationName() + " Application Version:" + ApplicationInfoUtils.getVersionName());
        ExtentCucumberAdapter.getCurrentScenario().assignAuthor(String.valueOf(AuthorType.AUTOMATION));
        ExtentCucumberAdapter.getCurrentScenario().assignDevice(DriverManager.getPlatform() + ":" + DriverManager.getDeviceName() + ":V-" + DriverManager.getPlatformVersion());
        VideoRecordUtils.startRecording();
    }

    /**
     * quit-This method is used to stop recording
     *
     * @param scenario
     * @throws IOException
     *         Date-06/03/2023
     */
    @After
    public void quit(Scenario scenario) throws IOException {
        VideoRecordUtils.stopRecording(scenario);
    }

    /**
     * unRegisterDevice- This method is used to unregister device after each scenario execution Date-06/03/2023
     */
    @After
    public void unRegisterDevice() {
//        BasePage basePage = new BasePage();
//        Andr_HIDSettingsScreenPage settingsScreenPage = new Andr_HIDSettingsScreenPage();
//        if (DriverManager.getDriver().getPlatformName().equalsIgnoreCase("Android")) {
//            settingsScreenPage.traverseToSettingsPage();
//            if (!DriverManager.getPopupHandled()) {
//                handlePopUps.enableAllPopUps("endTestPopupsHandling");
//            }
//            settingsScreenPage.unRegisterThisDevice();
//            basePage.waitForGivenTime(2);
//        }
    }
}
