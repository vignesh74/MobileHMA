package com.appium.stepDefinition;

import com.appium.HIDPages.ios.*;
import com.appium.deviceinfo_action.IOSDeviceInfo;
import com.appium.manager.DriverManager;
import com.appium.utils.SerialPortUtils;
import com.appium.utils.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jssc.SerialPortException;
import org.testng.Assert;

public class IOSStepDef {

    IOS_HIDMobileIDScreenPage mobileIdScreen = new IOS_HIDMobileIDScreenPage();
    IOS_HIDNotificationScreenPage notificationScreen = new IOS_HIDNotificationScreenPage();
    IOS_HIDSettingsScreenPage settingScreen = new IOS_HIDSettingsScreenPage();
    IOS_HIDHelpCenterActivityLogScreenPage activityScreen = new IOS_HIDHelpCenterActivityLogScreenPage();
    IOS_HIDHelpCenterScreenPage helpCenterScreen = new IOS_HIDHelpCenterScreenPage();
    IOS_HIDHelpCenterActivityLogScreenPage helpCenterActivityLogScreen = new IOS_HIDHelpCenterActivityLogScreenPage();
    IOS_HIDHelpCenterAboutScreenPage aboutScreen = new IOS_HIDHelpCenterAboutScreenPage();
    IOS_HIDHelpCenterLegalScreenPage termAndConditionScreen = new IOS_HIDHelpCenterLegalScreenPage();
    IOS_HIDHelpCenterSupportScreenPage supportScreen = new IOS_HIDHelpCenterSupportScreenPage();
    IOS_HIDHelpCenterFeedbackPage feedbackScreen = new IOS_HIDHelpCenterFeedbackPage();
    IOSDeviceInfo iosDeviceInfo = new IOSDeviceInfo();
    SerialPortUtils serialPortUtils = new SerialPortUtils();
    String armLogs;

    @Given("Launch HID Access Mobile Application in iOS device")
    public void launchHidAccessMobileApp_iOS() {
        if (!mobileIdScreen.isMobileIdScreenDisplayed()) {
            DriverManager.getDriver().closeApp();
            DriverManager.getDriver().launchApp();
        }
        TestUtils.log().info("Application launched Successfully");
    }

    @When("Mobile IDs screen is displayed in iOS device")
    public void mobileIDScreenIsDisplayed_iOS() {
        settingScreen.handlingSettingPopUp();
        mobileIdScreen.clickOnMobileIDTabAndVerify();
    }

    @Then("Notification screen is displayed with message {string} and {string} in iOS device")
    public void notificationScreenIsDisplayed_iOS(String strMessage1, String strMessage2) {
        notificationScreen.clickOnNotificationAndVerify(strMessage1, strMessage2);
    }

    @When("Navigate to Settings in iOS device")
    public void navigateToSettingsScreen_iOS() {
        settingScreen.clickOnSettingTabAndVerify();
    }

    @When("Select the mode state as {string} in iOS device")
    public void selectModeState_iOS(String strMode) {

        settingScreen.selectModeStatus(strMode);
    }

    @When("Set BLE status as {string} in iOS device")
    public void setBLEStatus_iOS(String strBLEStatus) {

        settingScreen.setBluetoothStatus(strBLEStatus);
    }

    @When("Set location permission as {string} in iOS device")
    public void setLocationPermission_iOS(String strPermission) {

        settingScreen.setLocationPermissionStatus(strPermission);
    }

    @When("Set Application status as {string} in iOS device")
    public void setAppStatus_iOS(String strAppState) {

        settingScreen.setIosAppState(strAppState);
    }

    @When("Set device state as {string} in iOS device")
    public void setDeviceState_iOS(String strDeviceState) {
        iosDeviceInfo.setIOSDeviceState(strDeviceState);
    }

    @When("Set display screen as {string} in iOS device")
    public void setDisplayScreen_iOS(String strDisplayState) {
        TestUtils.log().info("Set display screen as {} in iOS device",strDisplayState);
    }

    @When("Perform robotic arm action as {string} for iOS device")
    public void performRoboticArmAction_iOS(String strRoboticAction) throws SerialPortException {
        armLogs = SerialPortUtils.performRoboticArmOperation(DriverManager.getDevicePort(), strRoboticAction);
    }

    @Then("Activity log is displayed in iOS device and {string}, {string}, {string}, {string} and {string} are verified")
    public void activityLogIsDisplayed_iOS(String strDate, String strMobileRead, String strMessage, String strArmActionName, String strReaderName) {
        if (armLogs.toLowerCase().contains(("TAP:ENABLE").toLowerCase()) || armLogs.toLowerCase().contains(("TWIST_AND_GO=:ENABLE").toLowerCase())) {
            settingScreen.clickOnHelpCenterAndVerify();
            helpCenterScreen.clickOnActivityLogAndVerify();
//            Assert.assertEquals(activityScreen.getTodayDate(), strDate);
//            Assert.assertEquals(activityScreen.getMobileIDRead(), strMobileRead);
//            Assert.assertEquals(activityScreen.getSuccessMessage(), strMessage);
//            Assert.assertEquals(activityScreen.getActionName(), strArmActionName);
           // Assert.assertEquals(activityScreen.getReaderName(), strReaderName);
        } else {
            TestUtils.log().info("Tap or Twist and Go is not performed hence activity logs are not captured ");
        }

    }

    @Then("Robotic arms log {string} is displayed for iOS device")
    public void roboticArmsLogIsDisplayed_iOS(String strRoboticLog) {
        TestUtils.log().info("Robotic arms: "+armLogs+" is Equal to "+strRoboticLog);
        Assert.assertTrue(armLogs.toLowerCase().contains(strRoboticLog.toLowerCase()));
    }

    @Then("BLE status is displayed as {string} in iOS device")
    public void bleStatusDisplayed_iOS(String strBLEStatus) {
        settingScreen.setBluetoothStatus(strBLEStatus);
    }

    @Then("Location permission is displayed as {string} in iOS device")
    public void locationPermissionDisplayed_iOS(String strPermission) {
        settingScreen.setLocationPermissionStatus(strPermission);
    }

    @Then("Mode state is displayed as {string} in iOS device")
    public void checkModeState_iOS(String strMode) {
        settingScreen.clickModeStatusAndVerify(strMode);
    }

    @Then("Play sound status is displayed as {string} in iOS device")
    public void checkPlaySoundStatus_iOS(String strPlaySound) {
        settingScreen.verifyPlaySoundToggleButtonState(strPlaySound);
    }

    @Then("Vibrate status is displayed as {string} in iOS device")
    public void checkVibrateStatus_iOS(String strVibration) {
        settingScreen.verifyVibrateToggleButtonState(strVibration);
    }

    @Then("Twist&Go state is displayed as {string} in iOS device")
    public void twistAndGoState_iOS(String strTwistAndGo) {
        settingScreen.verifyTwistAndGoToggleButtonState(strTwistAndGo);
    }

    @When("Navigate to Help center in iOS device")
    public void navigateHelpCenter_iOS() {
        settingScreen.clickOnHelpCenterAndVerify();
    }

    @Then("Activity log status is displayed in iOS device")
    public void checkActivityLog_iOS() {
        helpCenterScreen.clickOnActivityLogAndVerify();
        helpCenterActivityLogScreen.clickOnBackToHelpCenter();
    }

    @Then("About state is displayed in iOS device")
    public void checkAboutState_iOS() {
        helpCenterScreen.clickOnAboutAndVerify();
        aboutScreen.clickOnBackButtonAbout();
    }

    @Then("Term of use and privacy notice is displayed in iOS device")
    public void checkTermOfUseAndPrivacyNotice_iOS() {
        helpCenterScreen.clickOnTermsOfUseAndVerify();
        termAndConditionScreen.clickOnEndUserLicenceAgreementAndVerify();
        termAndConditionScreen.clickOnPrivacyNoticeLinkAndVerify();
        termAndConditionScreen.clickOnCancelButton();
    }

    @Then("Support status is displayed with text {string} in iOS device")
    public void checkSupportStatus_iOS(String strFeedback) {
        helpCenterScreen.clickOnSupportAndVerify();
        supportScreen.clickOnSubmitFeedbackButtonAndVerify();
        feedbackScreen.isFeedbackScreenDisplayed();
        feedbackScreen.isSubmitFeedbackButtonEnable(strFeedback);
        supportScreen.clickOnBackToHelpCenter();
    }

    @Then("Log file status is displayed as {string} in iOS device")
    public void checkLogFileStatus_iOS(String strSwitchState) {
        helpCenterScreen.verifyLogFileToggleButtonState(strSwitchState);
    }
}
