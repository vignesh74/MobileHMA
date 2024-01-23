package com.appium.stepDefinition;

import com.appium.HIDPages.ios.*;
import com.appium.deviceinfo_action.IOSDeviceInfo;
import com.appium.exceptions.AutomationException;
import com.appium.manager.DriverManager;
import com.appium.restAPI.EnvironmentProperties;
import com.appium.utils.ConfigLoader;
import com.appium.utils.SerialPortUtils;
import com.appium.utils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jssc.SerialPortException;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.sql.Driver;

import static com.appium.restAPI.CreateInvitationAPI.createInvitationAPI;
import static com.appium.restAPI.DeleteDeviceAPI.deleteDeviceAPI;
import static com.appium.restAPI.EnvironmentProperties.storeProp;

public class IOSStepDef {

    String strInvitationCode = "";

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
    IOS_HIDOnboardingScreenPage onboardingScreen = new IOS_HIDOnboardingScreenPage();
    IOS_HIDHelpCenterFAQScreenPage FAQScreen = new IOS_HIDHelpCenterFAQScreenPage();
    IOS_HIDMobileIDDetailedViewPage detailedViewScreen = new IOS_HIDMobileIDDetailedViewPage();

    IOSDeviceInfo iosDeviceInfo = new IOSDeviceInfo();
    SerialPortUtils serialPortUtils = new SerialPortUtils();
    String armLogs;
    String timeExp;

    String dateTime;

    String actSeosID="";

    @Given("Launch HID Access Mobile Application in iOS device")
    public void launchHidAccessMobileApp_iOS() {
        if (!mobileIdScreen.isMobileIdScreenDisplayed()) {
            DriverManager.getDriver().closeApp();
            //DriverManager.getDriver().installApp(ConfigLoader.getInstance().getiOSAppLocation());
            DriverManager.getDriver().launchApp();
        }
        TestUtils.log().info("Application launched Successfully");
    }

    @When("Mobile IDs screen is displayed in iOS device")
    public void mobileIDScreenIsDisplayed_iOS() {
        settingScreen.handlingAppCrashPopUp();
        settingScreen.verifyNoInternetPopUp();
        settingScreen.handlingSettingPopUp();
        dynamicAppReview_iOS("Yes");
        mobileIdScreen.clickOnMobileIDTabAndVerify();
    }

    @Then("Notification screen is displayed with message {string} and {string} in iOS device")
    public void notificationScreenIsDisplayed_iOS(String strMessage1, String strMessage2) {
        notificationScreen.clickOnNotificationAndVerify(strMessage1, strMessage2);
    }

    @When("Navigate to Settings in iOS device")
    public void navigateToSettingsScreen_iOS() {
        settingScreen.clickOnSettingTabAndVerify();
        //String dateTime = DriverManager.getDriver().getDeviceTime();
        //settingScreen.verifyTime(dateTime);

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
        dateTime = DriverManager.getDriver().getDeviceTime();
        timeExp = settingScreen.verifyTime(dateTime);
    }

    @Then("Activity log is displayed in iOS device and {string}, {string}, {string}, {string}, {string} and {string} are verified")
    public void activityLogIsDisplayed_iOS(String strDate, String strMobileRead, String strMessage, String strArmActionName, String strReaderName, String strRoboticAction) {
        try {
            settingScreen.clickOnHelpCenterAndVerify();
            helpCenterScreen.clickOnActivityLogAndVerify();
            //Screen shot capture required

            if (armLogs.toLowerCase().contains(("TAP:ENABLE").toLowerCase()) || armLogs.toLowerCase().contains(("TWIST_AND_GO=:ENABLE").toLowerCase())) {
                Assert.assertEquals(activityScreen.getTodayDate(), strDate);
                Assert.assertEquals(activityScreen.getMobileIDRead(), strMobileRead);
                Assert.assertEquals(activityScreen.getSuccessMessage(), strMessage);
                Assert.assertEquals(activityScreen.getActionName(), strArmActionName);
                Assert.assertEquals(activityScreen.getReaderName(), strReaderName);

                //Validate the time stamp
                String timeAct = activityScreen.getLogTime();
                activityScreen.checkActivityLogTime(timeExp, timeAct);

            } else if(activityScreen.getSuccessMessage().equalsIgnoreCase("Please move closer to the reader to gain access.")||
                    activityScreen.getSuccessMessage().equalsIgnoreCase("Communication timeout. Please try again.")||
                    activityScreen.getSuccessMessage().equalsIgnoreCase("Bluetooth communication failed. Please try again.")||
                    activityScreen.getSuccessMessage().equalsIgnoreCase("Reader busy. Please try again.")||
                    activityScreen.getSuccessMessage().equalsIgnoreCase("This reader is anti-passback enabled. Please make sure your Mobile ID is not misused.")||
                    !activityScreen.getReaderName().equalsIgnoreCase(strReaderName)){

                    TestUtils.log().info("--- ---- RE-EXECUTE THE ROBOTIC ARM---- ---");
                    performRoboticArmAction_iOS(strRoboticAction);

                    //Validate the log values:
                    Assert.assertEquals(activityScreen.getTodayDate(), strDate);
                    Assert.assertEquals(activityScreen.getMobileIDRead(), strMobileRead);
                    Assert.assertEquals(activityScreen.getSuccessMessage(), strMessage);
                    Assert.assertEquals(activityScreen.getActionName(), strArmActionName);
                    Assert.assertEquals(activityScreen.getReaderName(), strReaderName);

                    //Validate the time stamp
                    String timeAct = activityScreen.getLogTime();
                    activityScreen.checkActivityLogTime(timeExp, timeAct);
            }
            else {
                TestUtils.log().info("Tap or Twist and Go is not performed hence activity logs are not captured ");
            }

        }catch(Exception e){
            TestUtils.log().info("Exception occurred while verifying the activity log: " + e);
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

    @Then("About screen is displayed {string}, {string}, {string} and {string} in iOS device")
    public void verifyAboutScreen_iOS(String Mode, String Env, String BLE, String LocSev) {
        helpCenterScreen.verifyAboutScreenDetails(Mode, Env, BLE, LocSev);
        aboutScreen.clickOnBackButtonAbout();
    }

    @Then("Mobile ID is {string} and the Notification screen is displayed with message as {string} and {string} in iOS device")
    public void verifyNotificationScreen_iOS(String strMobileID, String strMsg1, String strMsg2) {
        notificationScreen.verifyNotificationScreen(strMobileID, strMsg1, strMsg2);
    }

    @Then("Navigate back to Mobile ID screen in iOS device")
    public void clickOnMobileIDScreen_iOS() {
        mobileIdScreen.clickOnMobileIDTabAndVerify();
    }

    @Then("Verify the Mobile ID screen {string} in iOS device")
    public void verifyMobileIDScreen_iOS(String strMobileID) {
        mobileIdScreen.verifyMobileIDScreen(strMobileID);
    }

    @Then("Verify the warning banners of {string} BLE {string} and Location permission {string} in iOS device")
    public void checkWarningBanners_iOS(String strMode, String BLE, String Location) {
        settingScreen.verifyWarningBanners(strMode, BLE, Location);
    }

    @Then("Click on ADD button in iOS device")
    public void clickOnAddButton_iOS() {
        mobileIdScreen.clickOnAddButton();
    }

    @Then("Verify the Add Mobile ID screen in iOS device")
    public void verifyAddMobileIDPage_iOS() {
        mobileIdScreen.chkAddMobileIDPage();
    }

    @Given("Get Invitation Code iOS using Rest API when credential are {}")
    public void createInvitationCode_iOS(String assigned) throws AutomationException, IOException {
        boolean assign = true;
        strInvitationCode = createInvitationAPI(DriverManager.getUserId(), assign);
        TestUtils.log().info(strInvitationCode);
    }

    @Then("Enter invitation code on HID mobile Application in iOS device")
    public void enterInvitationCode_iOS() {
        mobileIdScreen.enterInvitationCode(strInvitationCode);
    }

    @Then("Enter invitation code using ADD button on HID mobile Application in iOS device")
    public void enterInvitationCodeADD_iOS() {
        mobileIdScreen.enterInvitationCode_ADD(strInvitationCode);
    }

    @Then("Enter Invalid or Expired invitation code {string} on HID mobile Application in iOS device")
    public void enterInvalidInvitationCode_iOS(String strInvalidCode) {
        mobileIdScreen.enterInvalidInvitationCode(strInvalidCode);
    }

    @Then("Verify the No Internet Error {string} on HID mobile Application in iOS device")
    public void chkNoInternetErrMsg_iOS(String strInvitation) {
        mobileIdScreen.chkNoInternet(strInvitation);
    }

    @Then("Set WIFI status as {string} in iOS device")
    public void setWIFIStatus_iOS(String strInternet) {
        settingScreen.setWifiStatus(strInternet);
    }

    @Then("Set back the WIFI status as ON in iOS device")
    public void setWIFIStatusON_iOS() {
        settingScreen.setWifiStatusON();
    }

    @Then("Verify Support status debug log file {string} in feedback page {string} in iOS device")
    public void chkDebugLogFile_iOS(String logFile, String strFeedback) {
        helpCenterScreen.clickOnSupportAndVerify();
        supportScreen.clickOnSubmitFeedbackButtonAndVerify();
        feedbackScreen.isFeedbackScreenDisplayed();
        feedbackScreen.chkSupportTermsOfUse();
        termAndConditionScreen.clickOnEndUserLicenceAgreementAndVerify();
        termAndConditionScreen.clickOnPrivacyNoticeLinkAndVerify();
        termAndConditionScreen.clickOnCancelButton();
        feedbackScreen.chkDebugLogFile(logFile, strFeedback);
        supportScreen.clickOnBackToHelpCenter();
    }

    @Then("Deregister all the Mobile IDs from this phone in iOS device")
    public void deregisterMobileIDs_iOS() {
        settingScreen.clickOnDegisterSetting();
        settingScreen.verifyDeregisterPopUp();
        settingScreen.deregisterSuccessfulPopUp();
        mobileIdScreen.verifyHIDMobilePage();
    }

    @Then("Verify No Internet pop up while deregister the Mobile IDs in iOS device")
    public void chkNoInternetPopUp_iOS() {
        settingScreen.clickOnDegisterSetting();
        settingScreen.verifyNoInternetPopUp();
    }

    @Then("Get the Seos ID from About screen in iOS device")
    public void getSeosID_iOS() throws AutomationException, IOException {
        helpCenterScreen.clickOnAboutAndVerify();
        actSeosID = aboutScreen.getSeosID();
        EnvironmentProperties.storeProp("device-id", actSeosID);
    }
    @Then("Trigger the Rest API to delete device in iOS device")
    public void deleteDeviceRestAPI_iOS() throws AutomationException, IOException {
        deleteDeviceAPI();
    }

    @Then("Verify Delete Mobile IDs pop up in welcome screen in iOS device")
    public void deleteMobileIDs_iOS() {
        mobileIdScreen.isDeletePopUpDispalyed();
        mobileIdScreen.verifyHIDMobilePage();
    }

    @Then("Verify the No Internet pop up in home screen in iOS device")
    public void noInternetPopUp_iOS() {
        settingScreen.verifyNoInternetPopUp();
    }

    @Then("Verify Dynamic App review pop up {string} in Mobile Ids screen in iOS device")
    public void dynamicAppReview_iOS(String review) {
        mobileIdScreen.chkDynamicAppReview(review);
    }
    @Then("Verify Onboarding screen in iOS device")
    public void chkOnboardingScreen_iOS() {
        onboardingScreen.onboardConvenientPage();
        onboardingScreen.onboardTwistAndGoPage();
        onboardingScreen.onboardBannersPage();
    }
    @Then("Agree Terms of Use License and policy in iOS device")
    public void agreeTermsOfUse_iOS() {
        onboardingScreen.checkTermsOfUse();
        termAndConditionScreen.clickOnEndUserLicenceAgreementAndVerify();
        termAndConditionScreen.clickOnPrivacyNoticeLinkAndVerify();
        onboardingScreen.clickAgreeAndContinue();
    }

    @Then("Welcome to HID Mobile Access screen in iOS device")
    public void welcomeMobileAccess_iOS() {
        mobileIdScreen.verifyHIDMobilePage();
        mobileIdScreen.clickAboutThisApp();
        aboutScreen.clickOnAboutCopyButton();
        aboutScreen.verifyAboutInHome("Always", "BLE Supported", "Location Services are enabled");
    }

    @Then("Navigate to FAQ screen in iOS device")
    public void chkFAQScreen_iOS() {
        FAQScreen.clickOnFAQButton();
        FAQScreen.isFAQScreenDisplayed();
        FAQScreen.checkFAQScreen();
    }

    @Then("Search in FAQ screen in iOS device")
    public void searchFAQScreen_iOS() {
        FAQScreen.verifySearchFieldValid();
        FAQScreen.verifySearchFieldInValid();
        FAQScreen.clickLetUsKnow();
        supportScreen.isSupportScreenDisplayed();
        supportScreen.clickOnSupportFAQ();
        FAQScreen.clickFAQBackBtn();
    }

    @Then("Navigate to Org specific contact information in iOS device")
    public void chkOrgSpecificInfo_iOS() {
        detailedViewScreen.clickHIDCard();
        detailedViewScreen.chkOrgSpecificInfo();
        detailedViewScreen.clickCallButton();
        detailedViewScreen.clickEmailButton();
        detailedViewScreen.clickWebsiteButton();
    }

    @Then("Add Nickname {string} to the card in iOS device")
    public void editNickNameInCard_iOS(String nickName) {
        detailedViewScreen.addNickName(nickName);
        detailedViewScreen.clickDetailedViewBack();
        detailedViewScreen.chkEditedNickname(nickName);
    }

    @Then("Navigate to Activity log screen in iOS device")
    public void navToActivityLog_iOS() {
        helpCenterScreen.clickOnActivityLogAndVerify();
    }

    @Then("Verify the log message {string} and {string} in Activity log screen in iOS device")
    public void verifyErrMsgInLog_iOS(String activityLog, String logMessage) {
        activityScreen.verifyLogMessage(activityLog, logMessage);
    }

    //Device Enforcement
    @Then("Verify {string} is disabled and other modes are enabled")
    public void checkEnforcedSetting(String mode_state){
        settingScreen.checkEnforcedSetting(mode_state);
    }

    //NearBy Readers
    @Then("click on the Nearby Readers tab")
    public void clickOnNearbyReaders() {
        settingScreen.clickOnNearbyReaders();
    }
    @And("Verify NearBy Reader Status is displayed as {string} in iOS device")
    public void checkNearByReaderStatus(String strNearByReaderStatus) {
        settingScreen.checkNearByReaderStatus(strNearByReaderStatus);
    }
    @And("Signo Reader Text is displayed as Signo Reader in iOS device")
    public void checkSignoReaderText() {
        settingScreen.checkSignoReaderText();
    }

    @And("Verify Signo Reader Status is displayed as {string} in iOS device")
    public void checkSignoReaderStatus(String SignoReader) {
        settingScreen.checkSignoReaderStatus(SignoReader);
    }
    @And("Click on the RevE Reader checkbox")
    public void clickRevEReadercheckbox() {
        settingScreen.clickRevEReadercheckbox();
    }
    @And ("Verify RevE Reader Status is displayed as {string} in iOS device")
    public void checkRevEReaderStatus(String RevEReader) {
        settingScreen.checkRevEReaderStatus(RevEReader);
    }
    @And("Disable the RevE Reader checkbox")
    public void disableRevEReadercheckbox() {
        settingScreen.disableRevEReadercheckbox();
    }

    @And("Verify alertTitle pop up is displayed in iOS device")
    public void checkAlertTitleText() {
        settingScreen.checkAlertTitleText();
    }

    @And("click on AlertPositiveBtn RevE Reader")
    public void clickAlertPositiveBtnRevE() {
        settingScreen.clickAlertPositiveBtnRevE();
    }
    @And("Disable the Signo Reader checkbox")
    public void disableSignoReadercheckbox() {
        settingScreen.disableSignoReadercheckbox();
    }
    @And("click on AlertPositiveBtn Signo Reader")
    public void clickAlertPositiveBtnSigno() {
        settingScreen.clickAlertPositiveBtnSigno();
    }
    @And("click on the Nearby Readers switch")
    public void clickOnNearbyReaderSwitch() {
        settingScreen.clickOnNearbyReaderSwitch();
    }
    @When("Verify nearby readers section in iOS device {string}")
    public void verifyNearByReaders(String nearbyReaderCount) {
        settingScreen.verifyNearByReaders(nearbyReaderCount);
    }
    @And("Verify the Manage Readers section in iOS device {string}")
    public void verifyManageReaders(String nearbyReaderCount) {
        settingScreen.verifyManageReaders(nearbyReaderCount);
    }

    @And("Verify nearby readers information icon is visible in iOS device")
    public void checkNearbyReadersDataIcon() {
        settingScreen.checkNearbyDataInfoIcon();
    }
    @And("Verify onboarding screen one is Visible")
    public void checkonboardingScreenOne() {
        settingScreen.checkonboardingScreenOne();
    }
    @And("Verify onboarding screen is navigable")
    public void onboardScreenNavigation() {
        settingScreen.onboardScreenNavigation();
    }
    @And("Click on Image back button in Nearby Readers page")
    public void clickImgBackBtn() {
        settingScreen.clickImgBackBtn();
    }
    @And("Click on the Mobile IDs in Settings page for navigating to home screen")
    public void clickOnMobileIdsIcon() {
        settingScreen.clickOnMobileIdsIcon();
    }
    @And("Verify Nearby Readers are visible in iOS device")
    public void checkNearbyReadersVisible() {
        settingScreen.checkNearbyReadersVisible();
    }

}
