package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class Andr_HIDSettingsScreenPage extends BasePage {
    Andr_HIDMobileIDScreenPage mobileIDScreenPage = new Andr_HIDMobileIDScreenPage();
    Andr_HIDAppPreferencesScreenPage appPrefencesScreenPage = new Andr_HIDAppPreferencesScreenPage();

    /**
     * mobile elements - These are mobile elements which is present in Settings page
     * Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtSettings")
    private MobileElement txtSettingsTitle;
    @AndroidFindBy(xpath = "//*[@text='App Preferences']")
    private MobileElement txtAppPreference;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private MobileElement txtAbout;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Legal']")
    private MobileElement txtLegal;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Report Issue']")
    private MobileElement txtReportIssue;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtLegal")
    private MobileElement txtLegalHeadline;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtReportIssue")
    private MobileElement txtReportIssueHeadline;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edtTxtIssueDescription")
    private MobileElement txtareaDescription;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnSubmit")
    private MobileElement btnSubmit;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Deregister This Device']")
    private MobileElement txtUnRegisterThisDevice;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement txtNoConnection;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertMessage")
    private MobileElement txtNoInternetConnection;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement txtNoConnectionOKbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm Deregister']")
    private MobileElement txtConfirmUnregisterPopUpTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='DEREGISTER']")
    private MobileElement btnUnRegister;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have successfully Deregistered from HID Mobile Access. All your Mobile IDs have been deleted.']")
    private MobileElement txtDeviceUnRegistredMessage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnOk")
    private MobileElement btnOk;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement confirmAlertOkBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Always']")
    private MobileElement txtAlways;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtReason")
    private MobileElement enforcedAlwaysTxt;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.hidglobal.mobilekeys.android.v3:id/doorOpeningListItem'][1]")
    private MobileElement chkMode;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Foreground']")
    private MobileElement txtForeground;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.hidglobal.mobilekeys.android.v3:id/doorOpeningListItem'][2]")
    private MobileElement chkForeground;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unlocked']")
    private MobileElement txtUnlocked;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='com.hidglobal.mobilekeys.android.v3:id/doorOpeningListItem'][2]")
    private MobileElement chkUnlocked;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HID Mobile Access Version']")
    private MobileElement txtHIDMobileAccessVersion;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HID Mobile Access Version']/following-sibling::android.widget.TextView")
    private MobileElement txtHIDMobileAccessVersionValue;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HID Origo SDK Version']")
    private MobileElement txtHIDOrigoSDKVersion;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HID Origo SDK Version']/following-sibling::android.widget.TextView")
    private MobileElement txtHIDOrigoSDKVersionValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Door Opening Mode']")
    private MobileElement txtDoorOpeningMode;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Door Opening Mode']/following-sibling::android.widget.TextView")
    private MobileElement txtDoorOpeningModeValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Readers found']")
    private MobileElement txtReadersFound;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Endpoint Status']")
    private MobileElement txtEndPointStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Endpoint Status']/following-sibling::android.widget.TextView")
    private MobileElement txtEndPointStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Seos ID']")
    private MobileElement txtSeosID;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Seos ID']/following-sibling::android.widget.TextView")
    private MobileElement txtSeosIDValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Last Server Communication']")
    private MobileElement txtLastServerComm;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Endpoint App Version']")
    private MobileElement txtEndPointAppVersion;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Endpoint App Version']/following-sibling::android.widget.TextView")
    private MobileElement txtEndPointAppVersionValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Environment']")
    private MobileElement txtEnvironment;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Environment']/following-sibling::android.widget.TextView")
    private MobileElement txtEnvironmentValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Device model']/following-sibling::android.widget.TextView")
    private MobileElement txtDeviceModel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Device model']")
    private MobileElement txtDeviceModelValue;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OS version']")
    private MobileElement txtOSVersion;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OS version']/following-sibling::android.widget.TextView")
    private MobileElement txtOSVersionValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BLE info']")
    private MobileElement txtBleInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='BLE info']/following-sibling::android.widget.TextView")
    private MobileElement txtBleInfoValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC info']")
    private MobileElement txtNfcInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC info']/following-sibling::android.widget.TextView")
    private MobileElement txtNfcInfoValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location info']")
    private MobileElement txtLocationInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location info']/following-sibling::android.widget.TextView")
    private MobileElement txtLocationInfoValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby Permission']")
    private MobileElement txtNearByPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby Permission']/following-sibling::android.widget.TextView")
    private MobileElement txtNearByPermissionValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Permission']")
    private MobileElement txtLocationPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Permission']/following-sibling::android.widget.TextView")
    private MobileElement txtLocationPermissionValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='APPLICATION INFO']")
    private MobileElement txtApplicationInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENDPOINT INFO']")
    private MobileElement txtEndPointInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DEVICE INFO']")
    private MobileElement txtDeviceInfo;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgCopyClipIcon")
    private MobileElement AboutCopyImage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgCopyClipIcon")
    private MobileElement imgCopyClipIcon;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBackAbout")
    private MobileElement AboutBackIcon;

    @AndroidFindBy(xpath = "(//android.widget.Toast)[1]", priority = 0)
    @AndroidFindBy(xpath = "//*[@id=\"sourceContainer\"]/div/div/div/div[3]/div/div/div/div[24]/span[3]/span/span/b", priority = 1)
    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast[1]", priority = 2)
    @AndroidFindBy(xpath = "//android.widget.Toast[@text='Copied to clipboard']", priority = 3)
    private MobileElement aboutCopyToastMsg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQ']")
    private MobileElement txtFAQMenu;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtfaqtitle")
    private MobileElement txtFAQTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBack")
    private MobileElement imgFAQBack;

    @AndroidFindBy(id = "searchQueryInput")
    private MobileElement searchBox;


    public MobileElement getTxtConfirmUnregisterPopUpTitle() {
        return txtConfirmUnregisterPopUpTitle;
    }

    public MobileElement getBtnUnRegister() {
        return btnUnRegister;
    }

    public MobileElement getTxtUnRegisterThisDevice() {
        return txtUnRegisterThisDevice;
    }

    public MobileElement getTxtAppPreference() {
        return txtAppPreference;
    }

    public MobileElement getTxtAbout() {
        return txtAbout;
    }

    public MobileElement getTxtLegal() {
        return txtLegal;
    }

    public MobileElement getTxtReportIssue() {
        return txtReportIssue;
    }

    public MobileElement getTxtLegalHeadline() {
        return txtLegalHeadline;
    }

    public MobileElement getTxtReportIssueHeadline() {
        return txtReportIssueHeadline;
    }

    public MobileElement getTxtareaDescription() {
        return txtareaDescription;
    }

    public MobileElement getBtnSubmit() {
        return btnSubmit;
    }

    public MobileElement getTxtNoConnection() {
        return txtNoConnection;
    }

    public MobileElement getTxtNoInternetConnection() {
        return txtNoInternetConnection;
    }

    public MobileElement getTxtNoConnectionOKbtn() {
        return txtNoConnectionOKbtn;
    }


    public void clickOnAppPreferences() {
        try {
            click(txtAppPreference);
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on app preferences...");
        }

    }

    /**
     * checkReportIssue- This method click on report issue and verify the report issue headline
     * Date-25/01/2023
     */
    public void checkReportIssue() {
        try {
            click(txtReportIssue);
            Assert.assertTrue(txtReportIssueHeadline.isDisplayed());
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking report issue...");
        }
    }

    /**
     * sendTextInReportIssue- This method send text to description area in report issue screen Date-25/01/2023
     */
    public void sendTextInReportIssue(String text) {
        try {
            sendKeys(txtareaDescription, text);
            Assert.assertTrue(btnSubmit.getAttribute("enabled").equals("true"));
            navigateBack();
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while sending text in report issue...");
        }
    }

    /**
     * checkLegalScreen- It is used to verify legal screen headline
     * Date-25/01/2023
     */
    public void checkLegalScreen() {
        try {
            click(txtLegal);
            Assert.assertTrue(txtLegalHeadline.isDisplayed());
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking Legal Screen...");
        }
    }

    /**
     * checkAboutScreen- It is used to verify About screen headline
     * Date-25/01/2023
     */
    public void checkAboutScreen() {
        try {
            navigateBack();
            click(txtAbout);
            waitForGivenTime(2);
            Assert.assertTrue(txtAbout.isDisplayed());
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking About Screen...");
        }
    }

    /**
     * unRegisterThisDevice - This method is used to unregister mobile device
     * Date-25/01/2023
     */
    public void unRegisterThisDevice() {
        try {
            if (isElementVisible(txtUnRegisterThisDevice)) {
                click(txtUnRegisterThisDevice);
                if (isDisplayed(txtConfirmUnregisterPopUpTitle)) {
                    click(btnUnRegister);
                    waitForGivenTime(2);
                    if (isDisplayed(txtDeviceUnRegistredMessage)) {
                        click(btnOk);
                        waitForGivenTime(4);
                        TestUtils.log().info("Device has been Deregistered");
                    }
                }
            }
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while performing device Deregister.");
        }
    }

    /**
     * traverseToSettingsPage- This method is used to traverse to the setting page from app preferences or mobile id page
     * Date-22/02/2023
     */
    public void traverseToSettingsPage() {
        try {
            if (isDisplayed(appPrefencesScreenPage.getTxtAppPreferences())) {
                loopHandle(mobileIDScreenPage.getSettingsTab(), "navigateBack", 3);
                if (isElementVisible(mobileIDScreenPage.getSettingsTab())) {
                    TestUtils.log().info("Setting page is displayed");
                }
            } else if (isDisplayed(mobileIDScreenPage.getTxtViewMobileIdCard())) {
                click(mobileIDScreenPage.getSettingsTab());
                waitForGivenTime(2);
            }
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while coming to settings screen");
        }
    }

    /**
     * VerifySettingsScreen- This method is used to verify Settings screen displayed or not Date-13/02/2023
     */
    public void verifySettingsScreen() {
        try {
            waitForVisibility(txtAbout);
            Assert.assertTrue(isElementVisible(txtSettingsTitle));
            Assert.assertTrue(isElementVisible(txtAppPreference));
            Assert.assertTrue(isElementVisible(txtLegal));
            Assert.assertTrue(isElementVisible(txtReportIssue));
            Assert.assertTrue((isElementVisible(txtUnRegisterThisDevice)));
            Assert.assertTrue(isElementVisible(txtAbout));
//            Assert.assertTrue(isElementVisible(txtFAQMenu));
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while verifying to settings screen...");
        }
    }

    /**
     * clickAndVerifyLegalScreen- This method is used to click on legal screen Date-13/02/2023
     */
    public void clickOnLegalScreen() {
        try {
            click(txtLegal);
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while clicking on Legal Screen...");
        }
    }

    /**
     * clickAndVerifyReportIssueScreen- This method is used to click on report issue screen Date-13/02/2023
     */
    public void clickOnReportIssueScreen() {
        try {
            click(txtReportIssue);
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while clicking on Report Issue Screen...");
        }
    }

    /**
     * clickAndVerifyAboutScreen- This method is used to click on About screen Date-13/02/2023
     */
    public void clickOnAboutScreen() {
        try {
            click(txtAbout);
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while clicking on About Screen...");
        }
    }

    public void clickOnFAQScreen() {
        try {
            click(txtFAQMenu);
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while clicking on FAQ Screen...");
        }
    }

    public void checkEnforcedSetting(String usage_state) {
        if (usage_state == "Always") {
            String alwaysText = txtAlways.getText();
            Assert.assertEquals(alwaysText, usage_state);
            String enforcedAlways = enforcedAlwaysTxt.getText();
            Assert.assertEquals(enforcedAlways, "Enforced by your organization.");
            String alwaysAttribute = chkMode.getAttribute("enabled");
            Assert.assertEquals(alwaysAttribute, "false");
        } else if (usage_state == "Foreground") {
            String foregroundText = txtForeground.getText();
            Assert.assertEquals(foregroundText, usage_state);
            String foregroundAttribute = chkForeground.getAttribute("enabled");
            Assert.assertEquals(foregroundAttribute, true);
        } else if (usage_state == "Unlocked") {
            String unlockedText = txtUnlocked.getText();
            Assert.assertEquals(unlockedText, usage_state);
            String unlockedAttribute = chkUnlocked.getAttribute("enabled");
            Assert.assertEquals(unlockedAttribute, true);
        }

    }

    public void verifyAboutMenu() {
        try {
            waitForVisibility(txtAbout);
            Assert.assertTrue(isElementVisible(txtAbout));
            TestUtils.log().info("About menu is displayed..");
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while verifying to About text ...");
        }
    }

    public void verifyApplicationInformation() {
        click(txtAbout);

        try {
            waitForVisibility(txtApplicationInfo);
            Assert.assertTrue(isElementVisible(txtApplicationInfo));
            waitForVisibility(txtHIDMobileAccessVersion);
            Assert.assertTrue(isElementVisible(txtHIDMobileAccessVersion));
            waitForVisibility((txtHIDOrigoSDKVersion));
            Assert.assertTrue(isElementVisible(txtHIDOrigoSDKVersion));
            waitForVisibility(txtDoorOpeningMode);
            Assert.assertTrue(isElementVisible(txtDoorOpeningMode));
            waitForVisibility(txtReadersFound);
            Assert.assertTrue(isElementVisible(txtReadersFound));
            waitForVisibility(txtEndPointStatus);
            Assert.assertTrue(isElementVisible(txtEndPointInfo));
            waitForVisibility(txtEndPointStatus);
            Assert.assertTrue(isElementVisible(txtEndPointStatus));
            waitForVisibility(txtSeosID);
            Assert.assertTrue(isElementVisible(txtSeosID));
            waitForVisibility(txtLastServerComm);
            Assert.assertTrue(isElementVisible(txtLastServerComm));
            scrollDownTillElement(100, 2);
            waitForVisibility(txtEndPointAppVersion);
            Assert.assertTrue(isElementVisible(txtEndPointAppVersion));
            scrollDownTillElement(100, 2);
            waitForVisibility(txtEnvironment);
            Assert.assertTrue(isElementVisible(txtEnvironment));
            waitForVisibility(txtDeviceInfo);
            Assert.assertTrue(isElementVisible(txtDeviceInfo));
            waitForVisibility(txtOSVersion);
            Assert.assertTrue(isElementVisible(txtOSVersion));
            waitForVisibility(txtBleInfo);
            Assert.assertTrue(isElementVisible(txtBleInfo));
            waitForVisibility(txtNfcInfo);
            Assert.assertTrue(isElementVisible(txtNfcInfo));
            waitForVisibility(txtLocationInfo);
            Assert.assertTrue(isElementVisible(txtLocationInfo));
            scrollDownTillElement(100, 2);
            if (DriverManager.getPlatformVersion().equalsIgnoreCase("7") || DriverManager.getPlatformVersion().equalsIgnoreCase("8") || DriverManager.getPlatformVersion().equalsIgnoreCase("9") || DriverManager.getPlatformVersion().equalsIgnoreCase("10") || DriverManager.getPlatformVersion().equalsIgnoreCase("11")) {
                waitForVisibility(txtLocationPermission);
                Assert.assertTrue(isElementVisible(txtLocationPermission));
            } else {
                waitForVisibility(txtNearByPermission);
                Assert.assertTrue(isElementVisible(txtNearByPermission));
            }

        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while verifying to Application Information ...");
        }
    }

    public void copyAboutScreen() {
        try {
            waitForVisibility(AboutCopyImage);
            click(AboutCopyImage);
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while copying the about page content to clipboard");
        }
    }

    public void verifyAboutContents() {

        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
        try {
            driver.getClipboard(ClipboardContentType.PLAINTEXT); // get plaintext
            String text = driver.getClipboardText();
            if (text != null) {
                TestUtils.log().info("Contents are copied to clipboard");
            } else {
                TestUtils.log().info("Contents are not copied to clipboard");
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the copied contents in clipboard..");
        }
    }

    public void clickOnDeregister(String action) {
        try {
            if (action.equalsIgnoreCase("ON")) {
                if (isElementVisible(txtUnRegisterThisDevice)) {
                    click(txtUnRegisterThisDevice);
                    if (isDisplayed(txtConfirmUnregisterPopUpTitle)) {
                        click(btnUnRegister);
                        waitForGivenTime(2);
                        if (isDisplayed(txtDeviceUnRegistredMessage)) {
                            click(btnOk);
                            waitForGivenTime(4);
                            TestUtils.log().info("Device has been Deregistered");
                        }
                    }
                }
            } else if (action.equalsIgnoreCase("OFF")) {
                if (isElementVisible(txtUnRegisterThisDevice)) {
                    click(txtUnRegisterThisDevice);
                    if (isElementVisible(getTxtNoConnection())) {
                        Assert.assertTrue(isElementVisible(getTxtNoConnection()));
                        click(txtNoConnectionOKbtn);
                    }
                }
            }
        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while performing device Deregister.");
        }
    }

    public void verifyDeregisterContents() {
        isElementVisible(txtDeviceUnRegistredMessage);
        Assert.assertTrue(true, "You have successfully Deregistered from HID Mobile Access. All your Mobile IDs have been deleted.");
    }

    public void actionOnNetwork(String action) {
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();

        if (action.equalsIgnoreCase("ON")) {
            ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
            Assert.assertTrue(state.isWiFiEnabled(), "Wifi is not switched on");
            TestUtils.log().info("WiFi turned on");
            waitForGivenTime(3);
        } else if (action.equalsIgnoreCase("OFF")) {
            ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
            Assert.assertFalse(state.isWiFiEnabled(), "Wifi is not switched off");
            TestUtils.log().info("WiFi turned off");
        } else TestUtils.log().info("Incorrect action");

    }


    public void confirmDeregisterBtn(String wifiOFF) {
        try {
            if (isElementVisible(txtUnRegisterThisDevice)) {
                click(txtUnRegisterThisDevice);
                if (isDisplayed(txtConfirmUnregisterPopUpTitle)) {
                    actionOnNetwork("OFF");
                    click(btnUnRegister);
                    waitForGivenTime(4);
                    if (isDisplayed(getTxtNoConnection())) {
                        click(txtNoConnectionOKbtn);
                        actionOnNetwork("ON");
                        waitForGivenTime(4);
                        TestUtils.log().info("Confirm button on wifiOFF functionality is verified");
                    }
                }
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the WiFi OFF functionality");
        }

    }

    public void verifyFAQMenu() {
        try {
            waitForVisibility(txtFAQMenu);
            Assert.assertTrue(isElementVisible(txtFAQMenu));

        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while verifying to FAQ text ...");
        }
    }

    public void uninstall() {
        try {
            String strAndroidAppPackage = ConfigLoader.getInstance().getAndroidAppPackage();
            DriverManager.getDriver().removeApp(strAndroidAppPackage);
            TestUtils.log().info("App is uninstalled...");
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while uninstalling the app ...");
        }
    }

//    public String[] checkAboutInfo() {
//        String mobileAccessVersion = "";
//        String origoSDKVersion = "";
//        String doorOpeningMode = "";
//        String endPointStatus = "";
//        String seosID = "";
//        String endPointAppVersion = "";
//        String environment = "";
//        String OSVersion = "";
//        String deviceModel = "";
//        String BLEInfo = "";
//        String NFCInfo = "";
//        String locationInfo = "";
//        String nearByPermission = "";
//        String locationPermission = "";
//
//        try {
//            click(txtAbout);
//            mobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
//            origoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
//            doorOpeningMode = txtDoorOpeningModeValue.getText();
//            endPointStatus = txtEndPointStatusValue.getText();
//            seosID = txtSeosIDValue.getText();
//            endPointAppVersion = txtEndPointAppVersionValue.getText();
//            environment = txtEnvironmentValue.getText();
//            deviceModel = txtDeviceModelValue.getText();
//            OSVersion = txtOSVersionValue.getText();
//            BLEInfo = txtBleInfoValue.getText();
//            NFCInfo = txtNfcInfoValue.getText();
//            locationInfo = txtLocationInfoValue.getText();
//            if(DriverManager.getPlatformVersion().equalsIgnoreCase("9") || DriverManager.getPlatformVersion().equalsIgnoreCase("10") || DriverManager.getPlatformVersion().equalsIgnoreCase("11")){
//                locationPermission = txtLocationPermissionValue.getText();
//            }else{
//                nearByPermission = txtNearByPermissionValue.getText();
//            }
//        } catch (Exception e) {
//            TestUtils.log().info("Getting Exception while verifying the version of the app ...");
//        }
//        if(DriverManager.getPlatformVersion().equalsIgnoreCase("9") || DriverManager.getPlatformVersion().equalsIgnoreCase("10") || DriverManager.getPlatformVersion().equalsIgnoreCase("11")){
//            return new String[]{mobileAccessVersion, origoSDKVersion,doorOpeningMode,endPointStatus,seosID,endPointAppVersion,environment,deviceModel,OSVersion,BLEInfo,NFCInfo,locationInfo,locationPermission};
//        }else if(DriverManager.getPlatformVersion().equalsIgnoreCase("12") || DriverManager.getPlatformVersion().equalsIgnoreCase("13")){
//            return new String[]{mobileAccessVersion, origoSDKVersion,doorOpeningMode,endPointStatus,seosID,endPointAppVersion,environment,deviceModel,OSVersion,BLEInfo,NFCInfo,locationInfo,nearByPermission};
//        }
//
//    }

    public void installAPK() {
        try {
            String appPath = "/Users/vigneshrajesh/Downloads/develop430/src/test/resources/app/hid_mobile_access-global-4.2.0.apk";
            AppiumDriver driver = DriverManager.getDriver(); // Assuming DriverManager manages the driver lifecycle

            if (driver != null) {
                // Install the new APK within the existing session
                driver.installApp(appPath);

                // Optionally, perform additional actions with the installed app
                // ...

            } else {
                System.out.println("Driver is null. Cannot install APK.");
                TestUtils.log().info("Driver is null. Cannot install APK.");
            }

        } catch (Exception e) {
            System.out.println("installAPK " + e);
            TestUtils.log().info("Getting Exception while installing the app ...");
        }
    }

    public void compareAppPreference(){
        try{
            String platformVersion = DriverManager.getPlatformVersion();

            if(platformVersion.equalsIgnoreCase("9")){
                compareElementsForVersion9();
            }else if (platformVersion.equalsIgnoreCase("10") || platformVersion.equalsIgnoreCase("11")) {
                compareElementsForVersion10to11();
            } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
                compareElementsForVersion12to13();
            } else {
                TestUtils.log().info("Wrong version....");
            }
        }catch (Exception e){
            System.out.println("compareAppPreference "+e);
            TestUtils.log().info("Getting Exception while comparing the app preference ...");
        }
    }

    public void settingsStatus() {
        String platformVersion = DriverManager.getPlatformVersion();

        if(platformVersion.equalsIgnoreCase("9")){
            settingsElementsForVersion9();
        }else if (platformVersion.equalsIgnoreCase("10") || platformVersion.equalsIgnoreCase("11")) {
            settingsElementsForVersion10To11();
        } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
            settingsElementsForVersion12To13();
        } else {
            TestUtils.log().info("Wrong version....");
        }
    }

    public String[] settingsElementsForVersion9(){
        String bluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
        String locationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
        String locationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
        String alwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
        String foregroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
        String unlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
        String twistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String nearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String showActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String debugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String playSoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String vibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
        return new String[]{bluetoothValue,locationValue,locationPermissionValue,alwaysModeValue,foregroundModeValue,unlockedModeValue,twistAndGoValue,nearByReadersValue,showActivityValue,debugLogsValue,playSoundValue,vibrateValue};
    }

    public String[] settingsElementsForVersion10To11(){
        String bluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
        String NFCValue = appPrefencesScreenPage.getTxtNFCStatusValue().getText();
        String locationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
        String locationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
        String alwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
        String foregroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
        String unlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
        String twistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String nearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String showActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String debugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String playSoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
        String vibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
        return new String[]{bluetoothValue,NFCValue,locationValue,locationPermissionValue,alwaysModeValue,foregroundModeValue,unlockedModeValue,twistAndGoValue,nearByReadersValue,showActivityValue,debugLogsValue,playSoundValue,vibrateValue};
    }

    public String[] settingsElementsForVersion12To13() {
        String bluetoothValue = null;
        String NFCValue = null;
        String nearbyPermissionValue = null;
        String alwaysModeValue = null;
        String foregroundModeValue = null;
        String unlockedModeValue = null;
        String twistAndGoValue = null;
        String nearByReadersValue = null;
        String showActivityValue = null;
        String debugLogsValue = null;
        String playSoundValue = null;
        String vibrateValue = null;
        try {
            bluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            NFCValue = appPrefencesScreenPage.getTxtNFCStatusValue().getText();
            nearbyPermissionValue = appPrefencesScreenPage.getTxtNearByPermissionStatusValue().getText();
            alwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            foregroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            scrollDownTillElement(100, 2);
            unlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            scrollDownTillElement(100, 2);
            twistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            nearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            showActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            debugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            playSoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            vibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
            scrollUpTillElement(appPrefencesScreenPage.getTxtBluetooth(), 100, 1);

        } catch (Exception e) {
            System.out.println("settingsElementsForVersion12To13 " + e);
        }
        return new String[]{bluetoothValue, NFCValue, nearbyPermissionValue, alwaysModeValue, foregroundModeValue, unlockedModeValue, twistAndGoValue, nearByReadersValue, showActivityValue, debugLogsValue, playSoundValue, vibrateValue};
    }

    public void compareElementsForVersion9(){
        try {
            String bluetoothValue = settingsElementsForVersion9()[0];
            String locationValue = settingsElementsForVersion9()[1];
            String locationPermissionValue = settingsElementsForVersion9()[2];
            String alwaysModeValue = settingsElementsForVersion9()[3];
            String foregroundModeValue = settingsElementsForVersion9()[4];
            String unlockedModeValue = settingsElementsForVersion9()[5];
            String twistAndGoValue = settingsElementsForVersion9()[6];
            String nearByReadersValue = settingsElementsForVersion9()[7];
            String showActivityValue = settingsElementsForVersion9()[8];
            String debugLogsValue = settingsElementsForVersion9()[9];
            String playSoundValue = settingsElementsForVersion9()[10];
            String vibrateValue = settingsElementsForVersion9()[11];

            String newBluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            String newLocationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
            String newLocationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
            String newAlwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            String newForegroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            String newUnlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            String newTwistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newNearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newShowActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newDebugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newPlaySoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newVibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);

            Assert.assertEquals(bluetoothValue, newBluetoothValue);
            TestUtils.log().info("Bluetooth value is same after the upgrade....");

            Assert.assertEquals(locationValue, newLocationValue);
            TestUtils.log().info("Location value is same after the upgrade....");

            Assert.assertEquals(locationPermissionValue,newLocationPermissionValue);
            TestUtils.log().info("Location Permission value is same after the upgrade....");

            Assert.assertEquals(alwaysModeValue, newAlwaysModeValue);
            TestUtils.log().info("Always mode value is same after the upgrade....");

            Assert.assertEquals(foregroundModeValue, newForegroundModeValue);
            TestUtils.log().info("Foreground mode value is same after the upgrade....");

            Assert.assertEquals(unlockedModeValue, newUnlockedModeValue);
            TestUtils.log().info("Unlocked mode value is same after the upgrade....");

            Assert.assertEquals(twistAndGoValue, newTwistAndGoValue);
            TestUtils.log().info("Twist & Go button value is same after the upgrade....");

            Assert.assertEquals(nearByReadersValue, newNearByReadersValue);
            TestUtils.log().info("NearBy Reader button value is same after the upgrade....");

            Assert.assertEquals(showActivityValue, newShowActivityValue);
            TestUtils.log().info("Show Activity button value is same after the upgrade....");

            Assert.assertEquals(debugLogsValue, newDebugLogsValue);
            TestUtils.log().info("Debugs Log button value is same after the upgrade....");

            Assert.assertEquals(playSoundValue, newPlaySoundValue);
            TestUtils.log().info("Play Sound button value is same after the upgrade....");

            Assert.assertEquals(vibrateValue, newVibrateValue);
            TestUtils.log().info("Vibrate button value is same after the upgrade....");


        }catch(Exception e){
            System.out.println("compareElementsForVersion9 "+e);
            TestUtils.log().info("Getting Exception while comparing the values of old app information with upgraded app in App preference screen in 9...");
        }
    }

    public void compareElementsForVersion10to11(){
        try {
            String bluetoothValue = settingsElementsForVersion10To11()[0];
            String NFCValue = settingsElementsForVersion10To11()[1];
            String locationValue = settingsElementsForVersion10To11()[2];
            String locationPermissionValue = settingsElementsForVersion10To11()[3];
            String alwaysModeValue = settingsElementsForVersion10To11()[4];
            String foregroundModeValue = settingsElementsForVersion10To11()[5];
            String unlockedModeValue = settingsElementsForVersion10To11()[6];
            String twistAndGoValue = settingsElementsForVersion10To11()[7];
            String nearByReadersValue = settingsElementsForVersion10To11()[8];
            String showActivityValue = settingsElementsForVersion10To11()[9];
            String debugLogsValue = settingsElementsForVersion10To11()[10];
            String playSoundValue = settingsElementsForVersion10To11()[11];
            String vibrateValue = settingsElementsForVersion10To11()[12];

            String newBluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            String newNFCValue = appPrefencesScreenPage.getTxtNFCStatusValue().getText();
            String newLocationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
            String newLocationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
            String newAlwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            String newForegroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            String newUnlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            String newTwistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newNearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newShowActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newDebugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newPlaySoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newVibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);

            Assert.assertEquals(bluetoothValue, newBluetoothValue);
            TestUtils.log().info("Bluetooth value is same after the upgrade....");

            Assert.assertEquals(NFCValue, newNFCValue);
            TestUtils.log().info("NFC value is same after the upgrade....");

            Assert.assertEquals(locationValue, newLocationValue);
            TestUtils.log().info("Location value is same after the upgrade....");

            Assert.assertEquals(locationPermissionValue, newLocationPermissionValue);
            TestUtils.log().info("Location value is same after the upgrade....");

            Assert.assertEquals(alwaysModeValue, newAlwaysModeValue);
            TestUtils.log().info("Always mode value is same after the upgrade....");

            Assert.assertEquals(foregroundModeValue, newForegroundModeValue);
            TestUtils.log().info("Foreground mode value is same after the upgrade....");

            Assert.assertEquals(unlockedModeValue, newUnlockedModeValue);
            TestUtils.log().info("Unlocked mode value is same after the upgrade....");

            Assert.assertEquals(twistAndGoValue, newTwistAndGoValue);
            TestUtils.log().info("Twist & Go button value is same after the upgrade....");

            Assert.assertEquals(nearByReadersValue, newNearByReadersValue);
            TestUtils.log().info("NearBy Reader button value is same after the upgrade....");

            Assert.assertEquals(showActivityValue, newShowActivityValue);
            TestUtils.log().info("Show Activity button value is same after the upgrade....");

            Assert.assertEquals(debugLogsValue, newDebugLogsValue);
            TestUtils.log().info("Debugs Log button value is same after the upgrade....");

            Assert.assertEquals(playSoundValue, newPlaySoundValue);
            TestUtils.log().info("Play Sound button value is same after the upgrade....");

            Assert.assertEquals(vibrateValue, newVibrateValue);
            TestUtils.log().info("Vibrate button value is same after the upgrade....");


        }catch(Exception e){
            System.out.println("compareElementsForVersion10to11 "+e);
            TestUtils.log().info("Getting Exception while comparing the values of old app information with upgraded app in App preference screen in 11...");
        }
    }

    public void compareElementsForVersion12to13(){
        try {
            String bluetoothValue = settingsElementsForVersion12To13()[0];
            String NFCValue = settingsElementsForVersion12To13()[1];
            String nearbyPermissionValue = settingsElementsForVersion12To13()[2];
            String alwaysModeValue = settingsElementsForVersion12To13()[3];
            String foregroundModeValue = settingsElementsForVersion12To13()[4];
            String unlockedModeValue = settingsElementsForVersion12To13()[5];
            String twistAndGoValue = settingsElementsForVersion12To13()[6];
            String nearByReadersValue = settingsElementsForVersion12To13()[7];
            String showActivityValue = settingsElementsForVersion12To13()[8];
            String debugLogsValue = settingsElementsForVersion12To13()[9];
            String playSoundValue = settingsElementsForVersion12To13()[10];
            String vibrateValue = settingsElementsForVersion12To13()[11];

            String newBluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            String newNFCValue = appPrefencesScreenPage.getTxtNFCStatusValue().getText();
            String newNearbyPermissionValue = appPrefencesScreenPage.getTxtNearByPermissionStatusValue().getText();
            String newAlwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            scrollDownTillElement(100,2);
            String newForegroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            String newUnlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            scrollDownTillElement(100,2);
            String newTwistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newNearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newShowActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newDebugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newPlaySoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            String newVibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);

            Assert.assertEquals(bluetoothValue, newBluetoothValue);
            TestUtils.log().info("Bluetooth value is same after the upgrade....");

            Assert.assertEquals(NFCValue, newNFCValue);
            TestUtils.log().info("NFC value is same after the upgrade....");

            Assert.assertEquals(nearbyPermissionValue, newNearbyPermissionValue);
            TestUtils.log().info("Nearby Permission value is same after the upgrade....");

            Assert.assertEquals(alwaysModeValue, newAlwaysModeValue);
            TestUtils.log().info("Always mode value is same after the upgrade....");

            Assert.assertEquals(foregroundModeValue, newForegroundModeValue);
            TestUtils.log().info("Foreground mode value is same after the upgrade....");

            Assert.assertEquals(unlockedModeValue, newUnlockedModeValue);
            TestUtils.log().info("Unlocked mode value is same after the upgrade....");

            Assert.assertEquals(twistAndGoValue, newTwistAndGoValue);
            TestUtils.log().info("Twist & Go button value is same after the upgrade....");

            Assert.assertEquals(nearByReadersValue, newNearByReadersValue);
            TestUtils.log().info("NearBy Reader button value is same after the upgrade....");

            Assert.assertEquals(showActivityValue, newShowActivityValue);
            TestUtils.log().info("Show Activity button value is same after the upgrade....");

            Assert.assertEquals(debugLogsValue, newDebugLogsValue);
            TestUtils.log().info("Debugs Log button value is same after the upgrade....");

            Assert.assertEquals(playSoundValue, newPlaySoundValue);
            TestUtils.log().info("Play Sound button value is same after the upgrade....");

            Assert.assertEquals(vibrateValue, newVibrateValue);
            TestUtils.log().info("Vibrate button value is same after the upgrade....");


        }catch(Exception e){
            System.out.println("compareElementsForVersion12to13 "+e);
            TestUtils.log().info("Getting Exception while comparing the values of old app information with upgraded app in App preference screen in 12...");
        }
    }

    public void checkAboutInfo() {
        try{
            String platformVersion = DriverManager.getPlatformVersion();

            if(platformVersion.equalsIgnoreCase("9") || platformVersion.equalsIgnoreCase("10")||platformVersion.equalsIgnoreCase("11")){
                checkAboutInfoForVersion9to11();
            }else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
                checkAboutInfoForVersion12To13();
            } else {
                TestUtils.log().info("Wrong version....");
            }
        }catch(Exception e){
            TestUtils.log().info("Getting Exception while checking the values of about info...");
        }

    }

    public String[] checkAboutInfoForVersion9to11() {

        String mobileAccessVersion = null;
        String origoSDKVersion = null;
        String doorOpeningMode = null;
        String endPointStatus = null;
        String seosID = null;
        String endPointAppVersion = null;
        String environment = null;
        String deviceModel = null;
        String OSVersion = null;
        String BLEInfo = null;
        String NFCInfo = null;
        String locationInfo = null;
        String locationPermission = null;
        try {
            click(txtAbout);
            mobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            origoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            doorOpeningMode = txtDoorOpeningModeValue.getText();
            endPointStatus = txtEndPointStatusValue.getText();
            seosID = txtSeosIDValue.getText();
            scrollDownTillElement(100, 2);
            endPointAppVersion = txtEndPointAppVersionValue.getText();
            scrollDownTillElement(100, 2);
            environment = txtEnvironmentValue.getText();
            deviceModel = txtDeviceModelValue.getText();
            OSVersion = txtOSVersionValue.getText();
            BLEInfo = txtBleInfoValue.getText();
            NFCInfo = txtNfcInfoValue.getText();
            locationInfo = txtLocationInfoValue.getText();
            locationPermission = txtLocationPermissionValue.getText();
            String nearByPermission = txtNearByPermissionValue.getText();

        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while verifying the About info of the app ...");
        }
        return new String[]{mobileAccessVersion, origoSDKVersion, doorOpeningMode, endPointStatus, seosID, endPointAppVersion, environment, deviceModel, OSVersion, BLEInfo, NFCInfo, locationInfo, locationPermission};

    }

    public String[] checkAboutInfoForVersion12To13() {

        String mobileAccessVersion = null;
        String origoSDKVersion = null;
        String doorOpeningMode = null;
        String endPointStatus = null;
        String seosID = null;
        String endPointAppVersion = null;
        String environment = null;
        String deviceModel = null;
        String OSVersion = null;
        String BLEInfo = null;
        String NFCInfo = null;
        String locationInfo = null;
        String nearByPermission = null;
        try {
            isElementVisible(txtHIDMobileAccessVersionValue);
            mobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            origoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            doorOpeningMode = txtDoorOpeningModeValue.getText();
            endPointStatus = txtEndPointStatusValue.getText();
            seosID = txtSeosIDValue.getText();
            scrollDownTillElement(100, 2);
            isElementVisible(txtEndPointAppVersionValue);
            endPointAppVersion = txtEndPointAppVersionValue.getText();
            scrollDownTillElement(100, 2);
            isElementVisible(txtEnvironmentValue);
            environment = txtEnvironmentValue.getText();
            deviceModel = txtDeviceModelValue.getText();
            OSVersion = txtOSVersionValue.getText();
            BLEInfo = txtBleInfoValue.getText();
            NFCInfo = txtNfcInfoValue.getText();
            locationInfo = txtLocationInfoValue.getText();
            nearByPermission = txtNearByPermissionValue.getText();
            scrollUpTillElement(txtHIDMobileAccessVersionValue,100,1);
        } catch (Exception e) {
            System.out.println("checkAboutInfoForVersion12To13 "+e);
            TestUtils.log().info("Getting Exception while verifying the About info of the app ...");
        }
        return new String[]{mobileAccessVersion, origoSDKVersion, doorOpeningMode, endPointStatus, seosID, endPointAppVersion, environment, deviceModel, OSVersion, BLEInfo, NFCInfo, locationInfo, nearByPermission};

    }

    public void compareAboutInfo(){
        try{
            String platformVersion = DriverManager.getPlatformVersion();

            if(platformVersion.equalsIgnoreCase("9")||platformVersion.equalsIgnoreCase("10")||platformVersion.equalsIgnoreCase("11")){
                compareAboutInfoForVersion9to11();
            } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
                compareAboutInfoForVersion12to13();
            } else {
                TestUtils.log().info("Wrong version....");
            }
        }catch(Exception e){
            TestUtils.log().info("Getting Exception while comparing the About info of the app after the upgrade ...");
        }
    }

    public void compareAboutInfoForVersion9to11(){
        try{
            String mobileAccessVersion = checkAboutInfoForVersion9to11()[0];
            String origoSDKVersion = checkAboutInfoForVersion9to11()[1];
            String doorOpeningMode = checkAboutInfoForVersion9to11()[2];
            String endPointStatus = checkAboutInfoForVersion9to11()[3];
            String seosID = checkAboutInfoForVersion9to11()[4];
            String endPointAppVersion = checkAboutInfoForVersion9to11()[5];
            String environment = checkAboutInfoForVersion9to11()[6];
            String deviceModel = checkAboutInfoForVersion9to11()[7];
            String OSVersion = checkAboutInfoForVersion9to11()[8];
            String BLEInfo = checkAboutInfoForVersion9to11()[9];
            String NFCInfo = checkAboutInfoForVersion9to11()[10];
            String locationInfo = checkAboutInfoForVersion9to11()[11];
            String locationPermission = checkAboutInfoForVersion9to11()[12];

            String newMobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            String newOrigoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            String newDoorOpeningMode = txtDoorOpeningModeValue.getText();
            String newEndPointStatus = txtEndPointStatusValue.getText();
            String newSeosID = txtSeosIDValue.getText();
            scrollDownTillElement(100,2);
            String newEndPointAppVersion = txtEndPointAppVersionValue.getText();
            scrollDownTillElement(100,2);
            String newEnvironment = txtEnvironmentValue.getText();
            String newDeviceModel = txtDeviceModelValue.getText();
            String newOSVersion = txtOSVersionValue.getText();
            String newBLEInfo = txtBleInfoValue.getText();
            String newNFCInfo = txtNfcInfoValue.getText();
            String newLocationInfo = txtLocationInfoValue.getText();
            String newLocationPermission = txtNearByPermissionValue.getText();

            Assert.assertEquals(mobileAccessVersion, newMobileAccessVersion);
            TestUtils.log().info("mobileAccessVersion is same");

            Assert.assertEquals(origoSDKVersion, newOrigoSDKVersion);
            TestUtils.log().info("origoSDKVersion is same");

            Assert.assertEquals(doorOpeningMode, newDoorOpeningMode);
            TestUtils.log().info("doorOpeningMode is same");

            Assert.assertEquals(endPointStatus, newEndPointStatus);
            TestUtils.log().info("endPointStatus is same");

            Assert.assertEquals(seosID, newSeosID);
            TestUtils.log().info("seosID is same");

            Assert.assertEquals(endPointAppVersion, newEndPointAppVersion);
            TestUtils.log().info("endPointAppVersion is same");

            Assert.assertEquals(environment, newEnvironment);
            TestUtils.log().info("environment is same");

            Assert.assertEquals(deviceModel, newDeviceModel);
            TestUtils.log().info("deviceModel is same");

            Assert.assertEquals(OSVersion, newOSVersion);
            TestUtils.log().info("OSVersion is same");

            Assert.assertEquals(BLEInfo, newBLEInfo);
            TestUtils.log().info("BLEInfo is same");

            Assert.assertEquals(NFCInfo, newNFCInfo);
            TestUtils.log().info("NFCInfo is same");

            Assert.assertEquals(locationInfo, newLocationInfo);
            TestUtils.log().info("locationInfo is same");

            Assert.assertEquals(locationPermission, newLocationPermission);
            TestUtils.log().info("locationPermission is same");
        }catch (Exception e){
            System.out.println("compareAboutInfoForVersion9to11 "+e);
            TestUtils.log().info("Getting Exception while comparing the About info of the app after the upgrade ...");
        }
    }

    public void compareAboutInfoForVersion12to13(){
        try{
            scrollUpTillElement(txtHIDMobileAccessVersion,100,2);
            isElementVisible(txtHIDMobileAccessVersion);
            String mobileAccessVersion = checkAboutInfoForVersion12To13()[0];
            String origoSDKVersion = checkAboutInfoForVersion12To13()[1];
            String doorOpeningMode = checkAboutInfoForVersion12To13()[2];
            String endPointStatus = checkAboutInfoForVersion12To13()[3];
            String seosID = checkAboutInfoForVersion12To13()[4];
            String endPointAppVersion = checkAboutInfoForVersion12To13()[5];
            String environment = checkAboutInfoForVersion12To13()[6];
            String deviceModel = checkAboutInfoForVersion12To13()[7];
            String OSVersion = checkAboutInfoForVersion12To13()[8];
            String BLEInfo = checkAboutInfoForVersion12To13()[9];
            String NFCInfo = checkAboutInfoForVersion12To13()[10];
            String locationInfo = checkAboutInfoForVersion12To13()[11];
            String nearbyPermission = checkAboutInfoForVersion12To13()[12];

            isElementVisible(txtHIDMobileAccessVersionValue);
            String newMobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            String newOrigoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            String newDoorOpeningMode = txtDoorOpeningModeValue.getText();
            String newEndPointStatus = txtEndPointStatusValue.getText();
            String newSeosID = txtSeosIDValue.getText();
            scrollDownTillElement(100,2);
            isElementVisible(txtEndPointAppVersionValue);
            String newEndPointAppVersion = txtEndPointAppVersionValue.getText();
            scrollDownTillElement(100,2);
            isElementVisible(txtEnvironmentValue);
            String newEnvironment = txtEnvironmentValue.getText();
            String newDeviceModel = txtDeviceModelValue.getText();
            String newOSVersion = txtOSVersionValue.getText();
            String newBLEInfo = txtBleInfoValue.getText();
            String newNFCInfo = txtNfcInfoValue.getText();
            String newLocationInfo = txtLocationInfoValue.getText();
            String newNearByPermission = txtNearByPermissionValue.getText();

            Assert.assertEquals(mobileAccessVersion, newMobileAccessVersion);
            TestUtils.log().info("mobileAccessVersion is same");

            Assert.assertEquals(origoSDKVersion, newOrigoSDKVersion);
            TestUtils.log().info("origoSDKVersion is same");

            Assert.assertEquals(doorOpeningMode, newDoorOpeningMode);
            TestUtils.log().info("doorOpeningMode is same");

            Assert.assertEquals(endPointStatus, newEndPointStatus);
            TestUtils.log().info("endPointStatus is same");

            Assert.assertEquals(seosID, newSeosID);
            TestUtils.log().info("seosID is same");

            Assert.assertEquals(endPointAppVersion, newEndPointAppVersion);
            TestUtils.log().info("endPointAppVersion is same");

            Assert.assertEquals(environment, newEnvironment);
            TestUtils.log().info("environment is same");

            Assert.assertEquals(deviceModel, newDeviceModel);
            TestUtils.log().info("deviceModel is same");

            Assert.assertEquals(OSVersion, newOSVersion);
            TestUtils.log().info("OSVersion is same");

            Assert.assertEquals(BLEInfo, newBLEInfo);
            TestUtils.log().info("BLEInfo is same");

            Assert.assertEquals(NFCInfo, newNFCInfo);
            TestUtils.log().info("NFCInfo is same");

            Assert.assertEquals(locationInfo, newLocationInfo);
            TestUtils.log().info("locationInfo is same");

            Assert.assertEquals(nearbyPermission, newNearByPermission);
            TestUtils.log().info("nearbyPermission is same");


        }catch (Exception e){
            System.out.println("compareAboutInfoForVersion12to13 "+e);
            TestUtils.log().info("Getting Exception while comparing the About info of the app after the upgrade ...");
        }
    }


}
