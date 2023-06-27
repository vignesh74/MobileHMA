package com.appium.stepDefinition;

import com.appium.HIDPages.android.*;
import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.exceptions.AutomationException;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.SerialPortUtils;
import com.appium.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jssc.SerialPortException;
import org.testng.Assert;

import java.io.IOException;

import static com.appium.restAPI.CreateInvitationAPI.createInvitationAPI;

public class AndrStepDef {
    String strInvitationCode = "";
    Andr_HIDConvenientScreenPage convenientScreen = new Andr_HIDConvenientScreenPage();
    Andr_HIDInvitationCodeScreenPage invitationScreen = new Andr_HIDInvitationCodeScreenPage();
    Andr_HIDMobileIDScreenPage mobileIDScreen = new Andr_HIDMobileIDScreenPage();
    Andr_HIDSettingsScreenPage settingsScreen = new Andr_HIDSettingsScreenPage();
    Andr_HIDNotificationScreenPage notificationScreen = new Andr_HIDNotificationScreenPage();
    Andr_HIDAppPreferencesScreenPage appPreferencesScreen = new Andr_HIDAppPreferencesScreenPage();
    Andr_DeviceBLESettingsPage bleSettingsPage = new Andr_DeviceBLESettingsPage();
    Andr_DeviceNFCSettingsPage nfcSettingsPage = new Andr_DeviceNFCSettingsPage();
    Andr_DeviceNearbyPermissionSettingsPage nearbyPermissionSettingsPage = new Andr_DeviceNearbyPermissionSettingsPage();
    AndroidDeviceAction androidDeviceAction = new AndroidDeviceAction();
    SerialPortUtils serialPortUtils = new SerialPortUtils();
    Andr_DeviceLocationSettingsPage deviceLocationSettingsPage = new Andr_DeviceLocationSettingsPage();
    Andr_HIDSettingsAboutScreenPage settingsAboutScreenPage = new Andr_HIDSettingsAboutScreenPage();
    Andr_HIDSettingsReportIssueScreenPage settingsReportIssueScreenPage = new Andr_HIDSettingsReportIssueScreenPage();
    Andr_HIDSettingLegalScreenPage settingLegalScreenPage = new Andr_HIDSettingLegalScreenPage();
    Andr_HandlePopUps handlePopUps = new Andr_HandlePopUps();
    String strUDID = "";
    String armLogs;

    @Given("Launch HID Access Mobile Application in android device")
    public void launchHidAccessMobileApp_Andr() throws InterruptedException {
        if (convenientScreen.checkVisibilityOfConvenientPage()) {
            DriverManager.getDriver().closeApp();
            TestUtils.log().info("Application closed.....");
            DriverManager.getDriver().launchApp();
            TestUtils.log().info("Application launched.....");
        }
    }

    @Given("Get Invitation Code using Rest API when credential are {}")
    public void createInvitationCode_Andr(String assigned) throws AutomationException, IOException {
        boolean assign = true;
        strInvitationCode = createInvitationAPI(DriverManager.getUserId(), assign);
        TestUtils.log().info(strInvitationCode);
    }

    @When("Swipe EULA screen to left in android device")
    public void swipeEulaScreen_Andr() {
        convenientScreen.closeConvenientPage();
    }

    @When("Enter invitation code on HID mobile Application in android device")
    public void enterInvitationCode_Andr() {
        invitationScreen.enterInvitationCode(strInvitationCode);
    }

    @Then("Mobile IDs screen is displayed in android device")
    public void mobileIDScreenIsDisplayed_Andr() {
        boolean popups = handlePopUps.enableAllPopUps("initialPopupsHandling");
        DriverManager.setPopupHandled(popups);
        mobileIDScreen.toVerifyMobileID();
        mobileIDScreen.clickOnNextButton();
        mobileIDScreen.clickOnGotItButton();
    }

    @Then("Notification screen is displayed with message {string} in android device")
    public void notificationScreenIsDisplayed_Andr(String strMessage) {
        mobileIDScreen.clickOnNotificationTab();
        notificationScreen.verifyNotification(strMessage);
    }

    @When("Navigate to Settings and App Preferences screen in android device")
    public void navigateToAppPreferencesScreen_Andr() {
        mobileIDScreen.clickOnSettingsTab();
        TestUtils.log().info("Settings screen is displayed");
        settingsScreen.clickOnAppPreferences();
    }

    @When("Select the usage state as {string} in android device")
    public void selectUsageState_Andr(String usageType) {
        appPreferencesScreen.selectUsageType(usageType);
    }

    @When("Set BLE status as {string} in android device")
    public void setBLEStatus_Andr(String strBLEStatus) {
        bleSettingsPage.setBLEStatus(strBLEStatus);
    }

    @When("Set NFC status as {string} in android device")
    public void setNFCStatus_Andr(String strNFCStatus) {
        nfcSettingsPage.setNFCStatus(strNFCStatus);
    }

    @When("Set location as {string} in android device")
    public void setLocation_Andr(String strLocationStatus) {
        strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        deviceLocationSettingsPage.setLocationStatus(strLocationStatus, strUDID);
    }

    @When("Set device state as {string} in android device")
    public void setDeviceState_Andr(String strDeviceState) {
        strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        androidDeviceAction.setDeviceState(strDeviceState, strUDID);
    }

    @When("Set display screen as {string} in android device")
    public void setDisplayScreen_Andr(String strDisplayStatus) {
        strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        androidDeviceAction.setScreenDisplayStatus(strDisplayStatus, strUDID);
    }

    @When("Set Application status as {string} in android device")
    public void setAppStatus_Andr(String strAppState) {
        String strUdId = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        String strAndroidAppPackage = ConfigLoader.getInstance().getAndroidAppPackage();
        androidDeviceAction.setAppState(strAppState, strAndroidAppPackage, strUdId);
    }

    @When("Perform robotic arm action as {string} for android device")
    public void performRoboticArmAction_Andr(String RoboticAction) throws SerialPortException {
        armLogs = serialPortUtils.performRoboticArmOperation(DriverManager.getDevicePort(), RoboticAction);
    }

    @Then("Activity log is displayed in android device and {string}, {string} are verified")
    public void activityLogIsDisplayed_Andr(String strDate, String strMessage) {
        if (armLogs.equalsIgnoreCase("TAP:ENABLE") || armLogs.equalsIgnoreCase("TWIST_AND_GO=:ENABLE")) {
            appPreferencesScreen.enableActivityLogsAndNavigateToMobileIDScreen();
            boolean popups = handlePopUps.enableAllPopUps("endTestPopupsHandling");
            DriverManager.setPopupHandled(popups);
            mobileIDScreen.clickOnMobileIDTabAndVerify();
            mobileIDScreen.expandActivityLogs();
            Assert.assertTrue(mobileIDScreen.verifySuccessIcon());
            Assert.assertEquals(mobileIDScreen.verifyDate(), strDate);
            if (strMessage.equalsIgnoreCase("Successful NFC Transaction")) {

                Assert.assertEquals(mobileIDScreen.verifySuccessMessage().substring(0, 26), strMessage);
            } else {
                Assert.assertEquals(mobileIDScreen.verifySuccessMessage().substring(0, 32), strMessage);

            }
        } else {
            TestUtils.log().info("Robotic arm action is not performed");
        }
    }

    @Then("Robotic arms log {string} is displayed for android device")
    public void roboticArmsLogIsDisplayed_Andr(String strRoboticLog) {
        TestUtils.log().info("Robotic arms: "+armLogs+" is Equal to "+strRoboticLog);
        Assert.assertTrue(armLogs.toLowerCase().contains(strRoboticLog.toLowerCase()));

    }

    //setting scenarios step definition method
    @Then("Bluetooth status is displayed as {string} in android device")
    public void checkBluetoothStatus(String status1) {
        bleSettingsPage.setBLEStatus(status1);
    }
     @Then("NFC status is displayed as {string} in android device")
    public void checkNFCStatus(String status1) {
        nfcSettingsPage.setNFCStatus(status1);
    }

    @Then("Usage State status is displayed as {string} in android device")
    public void verifyUsageStateRadioButtons(String strUsageType) {
        appPreferencesScreen.checkUsageState(strUsageType);
    }

    @Then("Play Sound status is displayed as {string} in android device")
    public void verifyPlaySoundSwitchButton(String strPlaySound) {
        appPreferencesScreen.verifyPlaySoundToggleButton(strPlaySound);
    }

    @And("Vibrate status is displayed as {string} in android device")
    public void verifyVibrateSwitchButton(String strVibrate) {
        appPreferencesScreen.verifyVibrateToggleButton(strVibrate);
    }
    @And("Twist and Go status is displayed as {string} in android device")
    public void verifyTwistGoSwitchButton(String strTwistGo) {
        appPreferencesScreen.verifyTwistAndGoToggleButton(strTwistGo);
    }

    @And("Show Activity State status is displayed as {string} in android device")
    public void verifyShowActivityStateSwitchButton(String strShowActivity) {
        settingsScreen.clickOnAppPreferences();
        appPreferencesScreen.verifyShowActivityToggleButton(strShowActivity);
    }

    @When("Navigate to settings page in android device")
    public void navigateToSettingsPage() {
        mobileIDScreen.clickOnSettingsTab();
        settingsScreen.verifySettingsScreen();

    }

    @Then("Report issue by entering text {string} in android device")
    public void verifyReportIssue(String strReportIssue) {
        settingsScreen.clickOnReportIssueScreen();
        settingsReportIssueScreenPage.isReportIssuePageDisplayed();
        settingsReportIssueScreenPage.verifySubmitButtonEnable(strReportIssue);
        settingsReportIssueScreenPage.backFromReportIssue();
    }

    @Then("Legal Screen is displayed in android device")
    public void verifyLegalScreen() {
        settingsScreen.clickOnLegalScreen();
        settingLegalScreenPage.isLegalScreenPageDisplayed();
        settingLegalScreenPage.verifyEndUserLicenseScreenPageDisplayed();
        settingLegalScreenPage.verifyPrivacyNoticeScreenPageDisplayed();
        settingLegalScreenPage.verifyThirdPartyLicensesScreenPageDisplayed();
        settingLegalScreenPage.backFromLegalScreen();
    }

    @Then("About Screen is displayed in android device")
    public void verifyAboutScreen() {
        settingsScreen.clickOnAboutScreen();
        settingsAboutScreenPage.isAboutScreenPageDisplayed();
        settingsAboutScreenPage.backFromAboutScreen();
    }

    @And("Debug Logs status is displayed as {string} in android device")
    public void verifyDebugLogsSwitchButton(String strDebugLogs) {
        appPreferencesScreen.verifyDebugLogsToggleButton(strDebugLogs);
    }

    @And("Location Status is displayed as {string} in android device")
    public void setLocationAndr(String strLocationStatus)
    {
        strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        deviceLocationSettingsPage.setLocationStatusForSettingFeature(strLocationStatus, strUDID);
    }

   @When("Set {string} permission status as {string} in android device")
     public void set_permission_status_as_in_android_device(String strLocationOrNearBy, String strLocationOrNearByPermission) {
        nearbyPermissionSettingsPage.setNearByOrLocationPerm(strLocationOrNearBy, strLocationOrNearByPermission);
    }

    @Then("{string} Permission status is displayed as {string} in android device")
    public void verifyNearByPermissionForSettingFeature(String strLocationOrNearBy, String strLocationOrNearByPermission) {
        nearbyPermissionSettingsPage.setNearByOrLocationPerm(strLocationOrNearBy,strLocationOrNearByPermission);
        appPreferencesScreen.toVerifyNearByOrLocationPermissionStatus(strLocationOrNearByPermission);

    }
}
