package com.appium.stepDefinition;

import com.appium.HIDPages.android.Andr_HIDSettingsScreenPage;
import com.appium.HIDPages.android.Andr_HandlePopUps;
import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.enums.AuthorType;
import com.appium.manager.DriverManager;
import com.appium.utils.ApplicationInfoUtils;
import com.appium.utils.ConfigLoader;
import com.appium.utils.ScreenshotUtils;
import com.appium.utils.VideoRecordUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.io.IOException;

import static com.appium.constants.FrameworkConstants.YES;

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
    @AfterStep
    public static void addScreenshotForScenario(Scenario scenario) {
        String status = String.valueOf(scenario.getStatus());
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
