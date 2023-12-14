package com.appium.stepDefinition;

import com.appium.HIDPages.android.*;
import com.appium.base.BasePage;
import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.exceptions.AutomationException;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.SerialPortUtils;
import com.appium.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.core.plugin.TimelineFormatter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jssc.SerialPortException;
import org.testng.Assert;
import org.testng.internal.collections.Pair;
import org.testng.util.TimeUtils;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.Locale;

import static com.appium.constants.MessageConstants.EULA;
import static com.appium.restAPI.CreateInvitationAPI.createInvitationAPI;


public class AndrStepDef extends BasePage {
    String strInvitationCode = "";
    Andr_HIDOnboardingScreenPage OnboardingScreen = new Andr_HIDOnboardingScreenPage();
    Andr_HIDMobileAccessTermsOfUse termsOfUseScreen = new Andr_HIDMobileAccessTermsOfUse();
    Andr_HIDInvitationCodeScreenPage invitationScreen = new Andr_HIDInvitationCodeScreenPage();
    Andr_HIDMobileIDScreenPage mobileIDScreen = new Andr_HIDMobileIDScreenPage();
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
    Andr_HIDWarningBanners warningBanners = new Andr_HIDWarningBanners();
    Andr_HIDSettingsScreenPage settingsScreen = new Andr_HIDSettingsScreenPage();

    Andr_HIDSettingsFAQScreenPage FAQScreen = new Andr_HIDSettingsFAQScreenPage();

    String strUDID = "";
    Pair<String, String> armLogs;

    @Given("Launch HID Access Mobile Application in android device")
    public void launchHidAccessMobileApp_Andr() throws InterruptedException {
        DriverManager.getDriver().closeApp();
        TestUtils.log().info("Application closed.....");
        DriverManager.getDriver().launchApp();
        TestUtils.log().info("Application launched.....");
    }


    @Given("Launch HID Mobile Access Application Onboarding Screen in Android Device")
    public void launchOnboardingScreen() {

        DriverManager.getDriver().closeApp();
        TestUtils.log().info("Application closed.....");
        DriverManager.getDriver().launchApp();
        TestUtils.log().info("Application launched.....");

    }

    @When("Header and Description is displayed for Convenient Screen")
    public void headerConvenientDisplay() {
        OnboardingScreen.checkVisibilityOfConvenientPage();
        OnboardingScreen.checkDescriptionConvScreen();
    }

    @Then("Terms of Use Page is displayed when {string} is clicked in Convenient Screen")
    public void skipConvenientPage(String button) {
        OnboardingScreen.skipConvenientPageOnboardingScreen(button);

    }

    @And("Header and Description  is displayed for Twist&Go")
    public void headerTwistAndGoDisplay() {
        OnboardingScreen.checkVisibilityOfTwistAndGoPage();
        OnboardingScreen.checkDescriptionTwistAndGoScreen();
    }

    @Then("Favorite Reader Page is displayed when {string} is clicked in Twist&Go Screen")
    public void skipTwistAndGo(String button) {
        OnboardingScreen.skipTwistAndGoPage(button);

    }

    @And("Header and Description is displayed for Favorite Reader Screen")
    public void headerFavoriteReaderScreen() {
        OnboardingScreen.checkVisibilityOfFavoriteReaderPage();
        OnboardingScreen.checkDescriptionFavoriteReaderScreen();
    }

    @Then("Terms of Use Page is displayed when {string} is clicked in Favorite Reader Screen")
    public void getStartedBanner(String button) {
        OnboardingScreen.GetStartedFavoriteReaderPage();

    }


    @Given("Get Invitation Code using Rest API when credential are {}")
    public void createInvitationCode_Andr(String assigned) throws AutomationException, IOException {
        boolean assign = true;
        strInvitationCode = createInvitationAPI(DriverManager.getUserId(), assign);
        TestUtils.log().info(strInvitationCode);
    }

    @When("Swipe EULA screen to left in android device")
    public void swipeEulaScreen_Andr() {
        OnboardingScreen.skipConvenientPage();
        termsOfUseScreen.agreeCheckBox();
        termsOfUseScreen.continueTermsOfUsePage();

        invitationScreen.checkVisibilityOfInvitationPage();
        invitationScreen.checkDescriptionInvitationPage();
        invitationScreen.isEnabledGetStartedButton();
        invitationScreen.isEnabledScanQRButton();
        invitationScreen.checkAboutInfo();

    }

    @And("Skip is clicked")
    public void skipConvPage() {
        OnboardingScreen.skipConvenientPage();
    }

    @And("Terms of Use Page is displayed")
    public void headerTermsOfUse() {
        termsOfUseScreen.checkVisibilityOfTermsOfUsePage();
        termsOfUseScreen.checkVisibilityOfTermsOfUsePageImage();

    }


    @Then("{string} in Terms Of Use Screen is clicked")
    public void cancelTermsOfUse(String button) {
        termsOfUseScreen.cancelTermsOfUsePage(button);
    }

    @Then("{string} in Terms Of Use Page is clicked")
    public void eulaPrivacyLinks(String link) {
        if (link.equalsIgnoreCase(EULA)) {
            termsOfUseScreen.checkEulaPageLink(link);
            termsOfUseScreen.checkVisibilityOfEulaPage();
            DriverManager.getDriver().launchApp();
            TestUtils.log().info("Application launched.....");
            termsOfUseScreen.checkEulaPageLink(link);
            termsOfUseScreen.backButtonEula();
            DriverManager.getDriver().closeApp();
        } else {
            termsOfUseScreen.checkPrivacyPageLink(link);
            termsOfUseScreen.checkVisibilityOfPrivacyNoticePage();
            DriverManager.getDriver().launchApp();
            TestUtils.log().info("Application launched.....");
            termsOfUseScreen.checkPrivacyPageLink(link);
            termsOfUseScreen.backButtonPrivacyNoticePage();
            DriverManager.getDriver().closeApp();
        }

    }

    @And("Terms of Use Page Checkbox is checked")
    public void checkboxCheck() {
        termsOfUseScreen.checkCheckBoxTxt();
        termsOfUseScreen.continueBtnDisabled();
        termsOfUseScreen.agreeCheckBox();

    }

    @Then("{string} in Terms Of Use  is clicked")
    public void continueTermsOfUse(String link) {

        termsOfUseScreen.continueTermsOfUsePageLink(link);

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

    @Then("Tap on the Mobile ID to check back of the card details")
    public void backOfTheCardDetailsIsDisplayed_Andr() {
        //API need to integrate when received
        mobileIDScreen.clickOnMobileID();
        mobileIDScreen.checkHeaderMobileIdHeader();
        mobileIDScreen.checkOrgContactInfo();
        mobileIDScreen.checkCall();
        mobileIDScreen.checkEmail();
        mobileIDScreen.checkWebsite();
        mobileIDScreen.checkNickname();
        mobileIDScreen.checkName();
        mobileIDScreen.checkMobileKeySet();
        mobileIDScreen.checkID();
        mobileIDScreen.checkVisibilityOfEditNicknamePencilIcon();
        mobileIDScreen.checkVisibilityOfEditNicknamePopup();
        mobileIDScreen.validateNicknameDialogBox();
        mobileIDScreen.enterNickname();
        mobileIDScreen.removeNickname();
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
        isElementVisible(settingsScreen.getTxtAppPreference());
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
       AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
        strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        androidDeviceAction.setDeviceState(strDeviceState, strUDID);
        if(strDeviceState.equalsIgnoreCase("Locked")){
            androidDeviceAction.lockUnlockDevice();
            waitForGivenTime(2);
        }else{
            TestUtils.log().info("Device in unlocked state....");
        }

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

//    @When("Perform robotic arm action as {string} for android device")
//    public void performRoboticArmAction_Andr(String RoboticAction) throws SerialPortException {
//        armLogs = serialPortUtils.performRoboticArmOperation(DriverManager.getDevicePort(), RoboticAction);
//    }

//    @Then("Activity log is displayed in android device and {string}, {string} are verified")
//    public void activityLogIsDisplayed_Andr(String strDate, String strMessage) {
//        try {
//            if (armLogs.toLowerCase().contains(("TAP:ENABLE").toLowerCase()) || armLogs.toLowerCase().contains(("TWIST_AND_GO=:ENABLE").toLowerCase())) {
//                navigateToAppPreferencesScreen_Andr();
//                appPreferencesScreen.enableActivityLogsAndNavigateToMobileIDScreen();
//                boolean popups = handlePopUps.enableAllPopUps("endTestPopupsHandling");
//                DriverManager.setPopupHandled(popups);
//                mobileIDScreen.clickOnMobileIDTabAndVerify();
//                mobileIDScreen.expandActivityLogs();
//                Assert.assertTrue(mobileIDScreen.verifySuccessIcon());
//                Assert.assertEquals(mobileIDScreen.verifyDate(), strDate);
//                if (strMessage.contains("Bluetooth")) {
//                    Assert.assertEquals(mobileIDScreen.getSuccessMessage().substring(0, 33), strMessage);
//                } else {
//                    Assert.assertEquals(mobileIDScreen.getSuccessMessage().substring(0, 27), strMessage);
//                }
//            } else {
//                TestUtils.log().info("Robotic arm is not performed");
//            }
//        }catch(Exception e){
//            TestUtils.log().info("Exception occurred while verifying the activity log");
//        }
//    }

    @And("Activity log is displayed in android device and {string}, {string}, {string}, {string}, {string},{string} are verified")
    public void activityLogIsDisplayed_Andr(String strDate, String strMessage,String strReaderName,String strActionName,String strDeviceState,String strAppState) {
        try {
            navigateToAppPreferencesScreen_Andr();
            appPreferencesScreen.enableActivityLogsAndNavigateToMobileIDScreen();
            boolean popups = handlePopUps.enableAllPopUps("endTestPopupsHandling");
            DriverManager.setPopupHandled(popups);
            mobileIDScreen.clickOnMobileIDTabAndVerify();
            mobileIDScreen.expandActivityLogs();
            if(mobileIDScreen.getSuccessMessage().equalsIgnoreCase("Please move closer to the reader to gain access.")||
                    mobileIDScreen.getSuccessMessage().equalsIgnoreCase("Communication timeout. Please try again.")||
                    mobileIDScreen.getSuccessMessage().equalsIgnoreCase("Bluetooth communication failed. Please try again.")||
                    mobileIDScreen.getSuccessMessage().equalsIgnoreCase("Reader busy. Please try again.")||
                    mobileIDScreen.getSuccessMessage().equalsIgnoreCase("This reader is anti-passback enabled. Please make sure your Mobile ID is not misused.")||
                    !mobileIDScreen.getReaderName().equalsIgnoreCase(strReaderName)||
                    !mobileIDScreen.getActionName().equalsIgnoreCase(strActionName)){

                roboticExecution(strActionName,strDeviceState);
                androidDeviceAction.forceUnlock(strDeviceState,strAppState, (AndroidDriver) DriverManager.getDriver());
                setAppStatus_Andr(strAppState);

            }else if (armLogs.first().toLowerCase().contains(("TAP:ENABLE").toLowerCase()) || armLogs.first().toLowerCase().contains(("TWIST_AND_GO=:ENABLE").toLowerCase())) {

                Assert.assertTrue(mobileIDScreen.verifySuccessIcon());
                Assert.assertEquals(mobileIDScreen.verifyDate(), strDate);
                String deviceTime = armLogs.second();
                TestUtils.log().info("deviceTime: " + deviceTime);
                SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                Date deviceTimeNew = inputFormatter.parse(deviceTime);
                TestUtils.log().info("deviceTime formatted: " + deviceTimeNew);
                SimpleDateFormat outputFormatter = new SimpleDateFormat("hh:mm:ss");
                String deviceTimeFinal = outputFormatter.format(deviceTimeNew);
                TestUtils.log().info("deviceTimeFinal: " + deviceTimeFinal);

                String activityTime = mobileIDScreen.getTxtActivityTime().getText();
                String activityTimeNew = activityTime.substring(1,9);
                TestUtils.log().info("activityTimeNew: " + activityTimeNew);









//                DateTimeFormatter outputFormatter1 = DateTimeFormatter.ofPattern("hh:mm:ss");
//                String activityTimeNewFinal = activityTimeNew.format(outputFormatter1);
//                TestUtils.log().info("activityTimeNewFinal: " + activityTimeNewFinal);

//                TestUtils.log().info("activityTime: " + activityTime);
//                DateTimeFormatter inputFormatter1 = DateTimeFormatter.ofPattern("hh:mm:ss a");
//                LocalTime activityTimeNew = LocalTime.parse(activityTime, inputFormatter1);
//                TestUtils.log().info("activityTimeNew: " + activityTimeNew);

//                SimpleDateFormat outputFormatter = new SimpleDateFormat("hh:mm:ss");
//                String deviceTimeNew1 = outputFormatter.format(activityTimeNew);
//                TestUtils.log().info("deviceTimeNew1: " + deviceTimeNew1);
//                String activityTime1 = outputFormatter.format(activityTimeNew);
//
//                TestUtils.log().info("activityTime1: " + activityTime1);

                    if (mobileIDScreen.getSuccessMessage().contains("Bluetooth")) {
                        Assert.assertEquals(mobileIDScreen.getSuccessMessage().substring(0, 33), strMessage);
                    } else {
                        Assert.assertEquals(mobileIDScreen.getSuccessMessage().substring(0, 27), strMessage);
                    }
            } else {
                TestUtils.log().info("Robotic arm is not performed or disabled");
            }
        }catch(Exception e){
            TestUtils.log().info("qwqwqwqw "+e);
            TestUtils.log().info("Exception occurred while verifying the activity log");
        }
    }

    private static boolean compareTimes(String currentTime, String futureTime) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            Date currentTimeDate = sdf.parse(currentTime);
            Date futureTimeDate = sdf.parse(futureTime);

            // Compare the times
            return futureTimeDate.after(currentTimeDate);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }




//    @And("Activity log is displayed in android device and {string}, {string}, {string}, {string} and {string} are verified android device")
//    public void activityLogIsDisplayed_Andr(String strDate, String strMobileRead, String strMessage, String strArmActionName, String strReaderName) {
//        if (armLogs.toLowerCase().contains(("TAP:ENABLE").toLowerCase()) || armLogs.toLowerCase().contains(("TWIST_AND_GO=:ENABLE").toLowerCase())) {
//            appPreferencesScreen.enableActivityLogsAndNavigateToMobileIDScreen();
//            mobileIDScreen.expandActivityLogs();
//            Assert.assertEquals(mobileIDScreen.getTodayDate().toLowerCase(), strDate.toLowerCase());
//            Assert.assertEquals(mobileIDScreen.getMobileIDRead().toLowerCase(), strMobileRead.toLowerCase());
//            Assert.assertEquals(mobileIDScreen.getSuccessMessage().toLowerCase(), strMessage.toLowerCase());
//            Assert.assertEquals(mobileIDScreen.getActionName().toLowerCase(), strArmActionName.toLowerCase());
//            Assert.assertEquals(mobileIDScreen.getReaderName().toLowerCase(), strReaderName.toLowerCase());
//        } else {
//            TestUtils.log().info("Tap or Twist and Go is not performed hence activity logs are not captured ");
//        }
//
//    }

    @Then("Robotic arms log {string} is displayed for android device")
    public void roboticArmsLogIsDisplayed_Andr(String strRoboticLog) {
        TestUtils.log().info("Robotic arms: " + armLogs + " is Equal to " + strRoboticLog);
        Assert.assertTrue(armLogs.first().toLowerCase().contains(strRoboticLog.toLowerCase()));

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
        appPreferencesScreen.verifyActivityToggleButton(strShowActivity);
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
//        settingsReportIssueScreenPage.getBtnSubmit();
        settingsReportIssueScreenPage.click(settingsReportIssueScreenPage.getBtnSubmit());
        DriverManager.getDriver().closeApp();
        TestUtils.log().info("Application closed.....");
        DriverManager.getDriver().launchApp();
        TestUtils.log().info("Application launched.....");
        mobileIDScreen.clickOnSettingsTab();

//        settingsReportIssueScreenPage.backFromReportIssue();
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
    public void setLocationAndr(String strLocationStatus) {
        strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
        deviceLocationSettingsPage.setLocationStatusForSettingFeature(strLocationStatus, strUDID);
    }

    @When("Set {string} permission status as {string} in android device")
    public void set_permission_status_as_in_android_device(String strLocationOrNearBy, String strLocationOrNearByPermission) {
        nearbyPermissionSettingsPage.setNearByOrLocationPerm(strLocationOrNearBy, strLocationOrNearByPermission);
    }

    @Then("{string} Permission status is displayed as {string} in android device")
    public void verifyNearByPermissionForSettingFeature(String strLocationOrNearBy, String strLocationOrNearByPermission) {
        nearbyPermissionSettingsPage.setNearByOrLocationPerm(strLocationOrNearBy, strLocationOrNearByPermission);
        appPreferencesScreen.toVerifyNearByOrLocationPermissionStatus(strLocationOrNearByPermission);

    }

    @Then("Mobile IDs screen is displayed in android device with card and popup")
    public void mobileIDScreenAlongWithPopupIsDisplayed_Andr() {
        mobileIDScreen.toVerifyMobileID();
        mobileIDScreen.clickOnNextButton();
        mobileIDScreen.clickOnGotItButton();
    }

    /**
     * THIS SECTION IS MEANT FOR ANDROID 10 & 11.STILL WORK TO DONE IN UPCOMING SPRINT
     * /*
     *
     * @And("Warning BannersWF1 are displayed  in android device as {string},{string},{string},{string},{string}")
     * public void warningBanners1(String status1,String status2,String strLocationStatus,String strLocationOrNearBy, String strLocOrNearByPerm){
     * warningBanners.warningBannersWF1(status1,status2,strLocationStatus,strLocationOrNearBy,strLocOrNearByPerm);
     * }
     */
    @Then("Bluetooth status for Warning Banners is displayed as {string} in android device")
    public void setBLE(String bleStatusWb) {
        bleSettingsPage.setBLEStatusWb(bleStatusWb);
    }

    @And("NFC status for Warning Banners is displayed as {string} in android device")
    public void setNFC(String nfcStatusWb) {
        nfcSettingsPage.setNFCStatusWb(nfcStatusWb);
    }

    @And("Location Status for Warning Banners is displayed as {string} in android device")
    public void setLocation(String locationStatusWb, String strUDID) {
        deviceLocationSettingsPage.setLocationStatusWb(locationStatusWb, strUDID);
    }

    @And("{string} Permission status for Warning Banners is displayed as {string} in android device")
    public void setLocationPerm(String strLocationOrNearBy, String strLocationOrNearByPermission) {
        nearbyPermissionSettingsPage.setNearByOrLocationPermWb(strLocationOrNearBy, strLocationOrNearByPermission);
    }

    /**
     * THIS SECTION IS MEANT FOR ANDROID 10 & 11.STILL WORK TO DONE IN UPCOMING SPRINT
     *
     * @And("Warning BannersWF2 are displayed in android device")
     * public void warningBanners2(String strLocationStatus, String strUDID ,String strBLEStatus,String strNFCStatus,String strLocationOrNearBy,String strLocationOrNearByPermission){
     * warningBanners.warningBannersWF2(strLocationStatus, strUDID,strBLEStatus,strNFCStatus,strLocationOrNearBy,strLocationOrNearByPermission);
     * }
     */
    @Then("Warning Banners are displayed  in android device")
    public void WarningBanners3() {
        warningBanners.warningBanners();
    }

    @Then("Bluetooth status for Warning Banners in Wf3 is displayed as {string} in android device")
    public void setBLE_Wf3(String bleStatusWb) {
        bleSettingsPage.setBLEStatusWbWf3(bleStatusWb);
    }

    @And("NFC status for Warning Banners in Wf3 is displayed as {string} in android device")
    public void setNFC_Wf3(String nfcStatusWb) {
        nfcSettingsPage.setNFCStatusWbWf3(nfcStatusWb);
    }

    @And("{string} Permission status for Warning Banners in Wf3 is displayed as {string} in android device")
    public void setLocationPerm_Wf3(String strLocationOrNearBy, String strLocationOrNearByPermission) {
        nearbyPermissionSettingsPage.setNearByOrLocationPermWbWf3(strLocationOrNearBy, strLocationOrNearByPermission);
    }

    @Then("Warning Banners in Wf3 are displayed  in android device")
    public void WarningBannersWf3() {
        warningBanners.warningBannersWf3();
    }

    @And("Verify {string} always is disabled and other modes are enabled")
    public void checkEnforcedSetting(String usage_state) {
        settingsScreen.checkEnforcedSetting(usage_state);
    }

    @And("Set Twist and Go status as {string} in android device")
    public void setTwistAndGoEnableOrDisable(String Twist_And_Go_State) {
        appPreferencesScreen.setTwistAndGoEnableOrDisable(Twist_And_Go_State);
    }

    @Then("Verify About menu is displayed in android device")
    public void AboutTab() {
        settingsScreen.verifyAboutMenu();
    }

    @Then("Verify application information are displayed in android device")
    public void applicationInformation() {
        settingsScreen.verifyApplicationInformation();
    }

    @Then("Verify About Page contents are copied in android device")
    public void copyAboutScreen() {
        settingsScreen.copyAboutScreen();
    }

    @And("Copy image should turned to tick mark symbol and copied to clipboard toast")
    public void verifyTickSymbol() {
        settingsScreen.verifyAboutContents();
    }

    @When("Navigate to notification page in android device")
    public void navigateNotification() {
        mobileIDScreen.clickOnNotificationTab();
    }

    @Then("Verify the title of notification page in android device")
    public void notificationTitles() {
        notificationScreen.verifyNotificationTitle();
    }

    @And("Verify Notification Date in android device")
    public void notificationDate() {
        notificationScreen.verifyNotificationDate();
    }

    @And("Verify Notification of {string} issues and {string} in android device")
    public void verifyMobileIdStatus(String action, String notification) {
        notificationScreen.verifyMobileIdStatus(action, notification);
    }

    @Then("Verify the screen without any notification in android device")
    public void verifyNoNotificationScreen() {
        notificationScreen.verifyNoNotificationScreen();
    }

    @Then("Warning Banners are displayed {string} in android device with {string} {string} {string} {string}")
    public void verifyBanners(String BLE_Status, String NFC_Status, String location, String location_permission, String banners) {
        warningBanners.verifyWarningBanners(BLE_Status, NFC_Status, location, location_permission, banners);
    }

    @Then("Warning Banners are displayed {string} in android device with {string} {string}")
    public void verifyBanners12(String BLE_Status, String nearByPermission, String banners) {
        warningBanners.verifyWarningBanners12(BLE_Status, nearByPermission, banners);
    }

    @Then("Warning Banners are displayed {string} in android device with {string} {string} {string}")
    public void verifyBanners789(String BLE_Status, String location, String location_permission, String banners) {
        warningBanners.verifyWarningBanners789(BLE_Status, location, location_permission, banners);
    }

    @Then("Warning Banners are displayed as {string} in android device with {string} {string} {string}")
    public void verifyBanners13(String BLE_Status, String NFC_Status, String nearByPermission, String banners) {
        warningBanners.verifyWarningBanners13(BLE_Status, NFC_Status, nearByPermission);
    }

    @When("Verify Mobile ID screen is displayed in android device")
    public void verifyMobileIDScreen() {
        mobileIDScreen.verifyMobileIDScreen();
    }

    @And("Click on plus icon view the mobile ID screen in android device")
    public void verifyAddMobileIDScreen() {
        mobileIDScreen.plusIcon();
        mobileIDScreen.verifyAddMobileIDScreen();
    }

    @And("Click on Enter invitation code tab in android device")
    public void clickOnEnterInvitationCodeTab() {
        mobileIDScreen.clickOnEnterInvitationCodeTab();
    }

    @And("Verify the invitation code entering screen in android device")
    public void verifyInvitationCodeScreen() {
        mobileIDScreen.verifyInvitationCodeScreen();
    }

    @And("Verify after entering the {string} invitation code {string} and check the enter button in android device")
    public void verifyEnterButton(String typeOf, String invitationCode) {
        mobileIDScreen.verifyEnterButton(typeOf, invitationCode);
    }

    @And("Verify the alert message after entered the {string} wrong {string} in android device")
    public void verifyPopupContent(String typeOf, String invitationCode) {
        mobileIDScreen.verifyPopupContent(typeOf, invitationCode);
    }

    @And("Debug Logs status displayed as {string} in android device")
    public void DebugLogsSwitchButton(String strDebugLogs) {
        appPreferencesScreen.debugLogsToggleButton(strDebugLogs);
        appPreferencesScreen.navigateBack();
    }

    @And("Click on report issue submit button")
    public void clickOnSubmitButton() {
        settingsReportIssueScreenPage.click(settingsReportIssueScreenPage.getBtnSubmit());
    }

    @And("Share the access logs")
    public void shareLogs() {
        settingsReportIssueScreenPage.shareLogs();
    }

    @Then("Attachment will be displayed based on {string}")
    public void checkAttachment(String DebugLogs) {
        settingsReportIssueScreenPage.checkAttachment(DebugLogs);
    }


    @And("Click on the tab Deregister this device {string}")
    public void clickOnDeregister(String action) {
        settingsScreen.clickOnDeregister(action);
    }

    @And("Turn {string} the wifi")
    public void actionOnNetwork(String action) {
        settingsScreen.actionOnNetwork(action);
    }

    @Then("Verify the confirm button when deregister is {string}")
    public void confirmDeregisterBtn(String actionOFF) {
        settingsScreen.confirmDeregisterBtn(actionOFF);
    }

    @And("Verify the Delete device alert")
    public void verifyDeleteDeviceAlert() {
        mobileIDScreen.verifyDeleteDeviceAlert();
    }

    @And("Show Activity State is displayed as {string} in android device")
    public void verifyActivityToggleButton(String activityState) {
        appPreferencesScreen.verifyActivityToggleButton(activityState);
        appPreferencesScreen.navigateBack();
    }

    @And("Click on mobile ID tab in android device")
    public void clickOnMobileIDTab() {
        mobileIDScreen.click(mobileIDScreen.getMobileIDTab());
    }

    @Then("Activity will display in mobileID screen based on {string}")
    public void verifyShowActivity(String activity) {
        mobileIDScreen.verifyShowActivity(activity);
    }

    @When("Verify Mobile ID screen when Mobile ID is present in android device")
    public void verifyMobileIDWithID() {
        mobileIDScreen.verifyMobileIDWithID();
    }

    @And("Verify nearby readers section in android device {string}")
    public void verifyNearByReaders(String nearbyReaderCount) {
        mobileIDScreen.verifyNearByReaders(nearbyReaderCount);
    }

    @And("Verify the Manage Readers section in android device {string}")
    public void verifyManageReaders(String nearbyReaderCount) {
        mobileIDScreen.verifyManageReaders(nearbyReaderCount);
    }

    @And("click on the Nearby Readers tab")
    public void clickOnNearbyReaders() {
        appPreferencesScreen.clickOnNearbyReaders();
    }

    @And("NearBy Reader Status is displayed as {string} in android device")
    public void setNearByReaderStatus(String strNearByReaderStatus) {
        appPreferencesScreen.setNearByReaderStatus(strNearByReaderStatus);
    }

    @Then("Verify the FAQ Menu is displayed in android device")
    public void FAQTab() {
        FAQScreen.clickOnFAQScreen();
    }

    @Then("FAQ screen is displayed in android device")
    public void verifyFAQScreen() {
        FAQScreen.isFAQScreenPageDisplayed();
    }

    @And("Enter {string} type on the search box")
    public void checkSearch(String text) {
        FAQScreen.changeDriverContextToWeb();
        FAQScreen.checkSearch(text);
    }

    @And("Verify the rating popup UI in android device")
    public void checkRatingPopup() {
        mobileIDScreen.checkRatingPopup();
    }

    @When("Relaunch the app in android device")
    public void relaunchApp() {
        mobileIDScreen.relaunchApp();
    }

    @And("select the rating as {string} in android device")
    public void giveRating(String rating) {
        mobileIDScreen.giveRating(rating);
    }

    @And("Click on the submit button should close the popup in android device")
    public void reviewSubmitBtn() {
        mobileIDScreen.reviewSubmitBtn();
    }

    @Then("Verify the content on the improve popup in android device")
    public void improvePopup() {
        mobileIDScreen.improvePopup();
    }

    @Then("send the improve content {string} in android device")
    public void sendImprove(String improve) {
        mobileIDScreen.sendImprove(improve);
    }

    @Then("Verify the thank you popup in android device")
    public void verifyThankYou() {
        mobileIDScreen.verifyThankYou();
    }

    @And("Verify the {string} present on the screen in android device")
    public void searchText(String text) {
        FAQScreen.searchText(text);
    }

    @Then("Verify the log message {string} and {string} in Activity log screen in android device with {string}")
    public void verifyActivityLog(String mobileIDState, String message, String appState) {
        mobileIDScreen.verifyActivityLog(mobileIDState, message, appState);

    }

    @When("Set device state as {string} in android device.")
    public void setDeviceState_Android(String strDeviceState) {
        androidDeviceAction.setDeviceState_Android(strDeviceState);
    }

    @And("uninstall the app in android device")
    public void uninstall(){
        settingsScreen.uninstall();
    }

    @And("Verify new version available text in the notification screen in android device")
    public void upgrade(){
        notificationScreen.upgrade();
    }


    @And("Set device state as force unlock {string} with {string} in android device")
    public void forceUnlock(String strDeviceState, String appState){
        androidDeviceAction.forceUnlock(strDeviceState,appState, (AndroidDriver) DriverManager.getDriver());
    }


    private static String getAppMainActivity(AppiumDriver<MobileElement> driver) {
        return driver.getCapabilities().getCapability("appActivity").toString();
    }

    @And("Perform robotic arm action as {string} for android device {string}")
    public Pair<String, String> roboticExecution(String RoboticAction, String deviceState) throws SerialPortException{
        armLogs = serialPortUtils.performRoboticArmOperationWithDeviceState(DriverManager.getDevicePort(), RoboticAction, deviceState);
        return armLogs;
    }

    @And("Verify mobile about page information are displayed in android device")
    public void checkAboutInfo(){
        settingsScreen.navigateBack();
        settingsScreen.getTxtAbout().click();
        settingsScreen.checkAboutInfo();
    }

    @And("upgrade the new apk provided")
    public void installAPK(){
        settingsScreen.installAPK();
    }

//    @And("Verify the upgrade in android device")
//    public void verifyUpgrade(){
//        settingsScreen.verifyUpgrade();
//    }

    @And("Note down the settings of application before upgrade")
    public void settingsStatus(){
        settingsScreen.settingsStatus();
    }

    @And("compare the App Preference information are same after the upgrade")
    public void compareAppPreference(){
        settingsScreen.compareAppPreference();
    }

    @And("compare the About page information are same after the upgrade")
    public void compareAboutInfo(){
        settingsScreen.navigateBack();
        click(settingsScreen.getTxtAbout());
        settingsScreen.compareAboutInfo();
    }






}


