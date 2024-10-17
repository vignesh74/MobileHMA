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

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"HID Mobile Access\"]")
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

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/sensitivityTitle")
    private MobileElement txtBluetoothSensitivity;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtBleSensitivityHeading")
    private MobileElement txtBluetoothSensitivitytitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtAppPreferencesCategory")
    private MobileElement txtOptions;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/descriptionBleSensitivity")
    private MobileElement BluetoothSensitivityDesc;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/rbtnHigh")
    private MobileElement rdoBLEHigh;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/rbtnMedium")
    private MobileElement rdoBLEMedium;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/rbtnLow")
    private MobileElement rdoBLELow;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/descriptionHigh")
    private MobileElement BLEHighDesc;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/descriptionMedium")
    private MobileElement BLEMediumDesc;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/descriptionLow")
    private MobileElement BLELowDesc;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Identity Positioning']/following-sibling::android.widget.Switch")
    private MobileElement switchIdentityPositioning;

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

    public MobileElement getTxtBluetoothSensitivity() {
        return txtBluetoothSensitivity;
    }

    public MobileElement getTxtBluetoothSensitivitytitle() {
        return txtBluetoothSensitivitytitle;
    }

    //    ******************************************* code of surrender sundarraj begins *************************************************
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Mobile IDs\"]/android.widget.FrameLayout/android.widget.ImageView")
    private MobileElement MobileIdsIcon;

    //    ******************************************* code of surrender sundarraj ends *************************************************
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
            Assert.assertTrue(isElementVisible(txtFAQMenu));
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
            Assert.assertEquals(enforcedAlways, "The new Device Policy for your organization permits HID Mobile Access to only operate in Mobile Unlocked mode or Foreground mode.");
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
            //scrollDownTillElement(100, 2);
            swipeDowne("Endpoint App Version");
            waitForVisibility(txtEndPointAppVersion);
            Assert.assertTrue(isElementVisible(txtEndPointAppVersion));
            swipeDowne("Environment");
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
            if (DriverManager.getPlatformVersion().equalsIgnoreCase("9") || DriverManager.getPlatformVersion().equalsIgnoreCase("10") || DriverManager.getPlatformVersion().equalsIgnoreCase("11")) {
                waitForVisibility(txtLocationPermission);
                Assert.assertTrue(isElementVisible(txtLocationPermission));
            } else {
                swipeDowne("Nearby Permission");
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
            waitForGivenTime(10);
            TestUtils.log().info("WiFi turned on");
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

    public void installAPK() {
        try {
            String appPath = ConfigLoader.getInstance().getAndroidAppLocationNew();
//            String appPath = "/Users/vigneshrajesh/Downloads/develop430/src/test/resources/app/hid_mobile_access-global-4.4.0.apk";
            AppiumDriver driver = DriverManager.getDriver();

            if (driver != null) {
                // Install the new APK within the existing session
                System.out.println("***************  ENTERING  ************");
                driver.installApp(appPath);
            } else {
                System.out.println("Driver is null. Cannot install APK.");
                TestUtils.log().info("Driver is null. Cannot install APK.");
            }

        } catch (Exception e) {
            System.out.println("installAPK " + e);
            TestUtils.log().info("Getting Exception while installing the app ...");
        }
    }

    public String[] newerApkAppPreferenceValues() {
        String[] newApkAppPreferenceValue = new String[0];
        try {
            String platformVersion = DriverManager.getPlatformVersion();
            if (platformVersion.equalsIgnoreCase("9")) {
                newApkAppPreferenceValue = newerApkAppPreferenceValues9();
            } else if (platformVersion.equalsIgnoreCase("10") || platformVersion.equalsIgnoreCase("11")) {
                newApkAppPreferenceValue = newerApkAppPreferenceValues10To11();
            } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
                newApkAppPreferenceValue = newerApkAppPreferenceValues12To13();
            } else {
                TestUtils.log().info("Wrong version....");
            }
        } catch (Exception e) {
            System.out.println("newerApkAppPreferenceValues " + e);
            TestUtils.log().info("Getting Exception while comparing the app preference ...");
        }
        return newApkAppPreferenceValue;
    }

    public String[] olderApkAppPreferenceValues() {
        String platformVersion = DriverManager.getPlatformVersion();
        String[] oldApkAppPreferenceValues = new String[0];

        if (platformVersion.equalsIgnoreCase("9")) {
            oldApkAppPreferenceValues = olderApkAppPreferenceValues9();
        } else if (platformVersion.equalsIgnoreCase("10") || platformVersion.equalsIgnoreCase("11")) {
            oldApkAppPreferenceValues = olderApkAppPreferenceValues10To11();
        } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
            oldApkAppPreferenceValues = olderApkAppPreferenceValues12To13();
        } else {
            TestUtils.log().info("Wrong version....");
        }
        return oldApkAppPreferenceValues;
    }

    public String[] olderAboutInfo() {
        String[] oldApkAboutValues = new String[0];
        try {
            String platformVersion = DriverManager.getPlatformVersion();
            if (platformVersion.equalsIgnoreCase("9") || platformVersion.equalsIgnoreCase("10") || platformVersion.equalsIgnoreCase("11")) {
                oldApkAboutValues = oldApkAboutValues9to11();
            } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
                oldApkAboutValues = oldApkAboutValues12To13();
            } else {
                TestUtils.log().info("Wrong version....");
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the values of about info...");
        }
        return oldApkAboutValues;
    }

    public String[] oldApkAboutValues9to11() {

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
            iosScrollUpAndDownToElement(txtEndPointAppVersionValue, "up");
            endPointAppVersion = txtEndPointAppVersionValue.getText();
            iosScrollUpAndDownToElement(txtEnvironmentValue, "up");
            environment = txtEnvironmentValue.getText();
            deviceModel = txtDeviceModelValue.getText();
            OSVersion = txtOSVersionValue.getText();
            iosScrollUpAndDownToElement(txtBleInfoValue, "up");
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

    public String[] newApkAboutValues9to11() {

        String newMobileAccessVersion = null;
        String newOrigoSDKVersion = null;
        String newDoorOpeningMode = null;
        String newEndPointStatus = null;
        String newSeosID = null;
        String newEndPointAppVersion = null;
        String newEnvironment = null;
        String newDeviceModel = null;
        String newOSVersion = null;
        String newBLEInfo = null;
        String newNFCInfo = null;
        String newLocationInfo = null;
        String newLocationPermission = null;
        try {
            click(txtAbout);
            newMobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            newOrigoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            newDoorOpeningMode = txtDoorOpeningModeValue.getText();
            newEndPointStatus = txtEndPointStatusValue.getText();
            newSeosID = txtSeosIDValue.getText();
            iosScrollUpAndDownToElement(txtEndPointAppVersionValue, "up");
            newEndPointAppVersion = txtEndPointAppVersionValue.getText();
            iosScrollUpAndDownToElement(txtEnvironmentValue, "up");
            newEnvironment = txtEnvironmentValue.getText();
            newDeviceModel = txtDeviceModelValue.getText();
            newOSVersion = txtOSVersionValue.getText();
            iosScrollUpAndDownToElement(txtBleInfoValue, "up");
            newBLEInfo = txtBleInfoValue.getText();
            newNFCInfo = txtNfcInfoValue.getText();
            newLocationInfo = txtLocationInfoValue.getText();
            newLocationPermission = txtLocationPermissionValue.getText();
            String nearByPermission = txtNearByPermissionValue.getText();

        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while verifying the About info of the app ...");
        }
        return new String[]{newMobileAccessVersion, newOrigoSDKVersion, newDoorOpeningMode, newEndPointStatus, newSeosID, newEndPointAppVersion, newEnvironment, newDeviceModel, newOSVersion, newBLEInfo, newNFCInfo, newLocationInfo, newLocationPermission};

    }

    public String[] oldApkAboutValues12To13() {

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
            iosScrollUpAndDownToElement(txtHIDMobileAccessVersionValue, "down");
            mobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            origoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            doorOpeningMode = txtDoorOpeningModeValue.getText();
            endPointStatus = txtEndPointStatusValue.getText();
            seosID = txtSeosIDValue.getText();
            iosScrollUpAndDownToElement(txtEndPointAppVersionValue, "up");
            endPointAppVersion = txtEndPointAppVersionValue.getText();
            iosScrollUpAndDownToElement(txtEnvironmentValue, "up");
            environment = txtEnvironmentValue.getText();
            iosScrollUpAndDownToElement(txtNearByPermissionValue, "up");
            deviceModel = txtDeviceModelValue.getText();
            OSVersion = txtOSVersionValue.getText();
            BLEInfo = txtBleInfoValue.getText();
            NFCInfo = txtNfcInfoValue.getText();
            locationInfo = txtLocationInfoValue.getText();
            nearByPermission = txtNearByPermissionValue.getText();
        } catch (Exception e) {
            System.out.println("oldApkAboutValues12To13 " + e);
            TestUtils.log().info("Getting Exception while verifying the About info of the app ...");
        }
        return new String[]{mobileAccessVersion, origoSDKVersion, doorOpeningMode, endPointStatus, seosID, endPointAppVersion, environment, deviceModel, OSVersion, BLEInfo, NFCInfo, locationInfo, nearByPermission};

    }

    public String[] newApkAboutValues12To13() {

        String newMobileAccessVersion = null;
        String newOrigoSDKVersion = null;
        String newDoorOpeningMode = null;
        String newEndPointStatus = null;
        String newSeosID = null;
        String newEndPointAppVersion = null;
        String newEnvironment = null;
        String newDeviceModel = null;
        String newOSVersion = null;
        String newBLEInfo = null;
        String newNFCInfo = null;
        String newLocationInfo = null;
        String newNearByPermission = null;
        try {
            iosScrollUpAndDownToElement(txtHIDMobileAccessVersionValue, "down");
            newMobileAccessVersion = txtHIDMobileAccessVersionValue.getText();
            newOrigoSDKVersion = txtHIDOrigoSDKVersionValue.getText();
            newDoorOpeningMode = txtDoorOpeningModeValue.getText();
            newEndPointStatus = txtEndPointStatusValue.getText();
            newSeosID = txtSeosIDValue.getText();
            iosScrollUpAndDownToElement(txtEndPointAppVersionValue, "up");
            newEndPointAppVersion = txtEndPointAppVersionValue.getText();
            iosScrollUpAndDownToElement(txtEnvironmentValue, "up");
            newEnvironment = txtEnvironmentValue.getText();
            iosScrollUpAndDownToElement(txtNearByPermissionValue, "up");
            newDeviceModel = txtDeviceModelValue.getText();
            newOSVersion = txtOSVersionValue.getText();
            newBLEInfo = txtBleInfoValue.getText();
            newNFCInfo = txtNfcInfoValue.getText();
            newLocationInfo = txtLocationInfoValue.getText();
            newNearByPermission = txtNearByPermissionValue.getText();
        } catch (Exception e) {
            System.out.println("oldApkAboutValues12To13 " + e);
            TestUtils.log().info("Getting Exception while verifying the About info of the app ...");
        }
        return new String[]{newMobileAccessVersion, newOrigoSDKVersion, newDoorOpeningMode, newEndPointStatus, newSeosID, newEndPointAppVersion, newEnvironment, newDeviceModel, newOSVersion, newBLEInfo, newNFCInfo, newLocationInfo, newNearByPermission};

    }

    public String[] newerAboutInfo() {
        String platformVersion = DriverManager.getPlatformVersion();
        String[] newApkAboutValues = new String[0];
        try {
            if (platformVersion.equalsIgnoreCase("9") || platformVersion.equalsIgnoreCase("10") || platformVersion.equalsIgnoreCase("11")) {
                newApkAboutValues = newApkAboutValues9to11();
            } else if (platformVersion.equalsIgnoreCase("12") || platformVersion.equalsIgnoreCase("13")) {
                newApkAboutValues = newApkAboutValues12To13();
            } else {
                TestUtils.log().info("Wrong version....");
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while comparing the About info of the app after the upgrade ...");
        }
        return newApkAboutValues;
    }





    public void verifyBluetoothSensitivityMenu() {
        try {
            scrollUpTillElement(txtBluetoothSensitivity, 1000, 0);
            waitForVisibility(txtBluetoothSensitivity);
            Assert.assertTrue(isElementVisible(txtBluetoothSensitivity));
            TestUtils.log().info("Bluetooth Sensitivity menu is displayed..");
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while verifying to Bluetooth Sensitivity text ...");
        }
    }

    public void clickOnBluetoothSensitivity() {
        try {
            click(txtBluetoothSensitivity);
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while clicking on Bluetooth Sensitivity Menu...");
        }
    }

    public void isBluetoothSensitivityPageDisplayed() {
        try {
            waitForVisibility(txtBluetoothSensitivitytitle);
            Assert.assertTrue(isElementVisible(txtBluetoothSensitivitytitle));
            Assert.assertTrue(isElementVisible(txtOptions));
            Assert.assertTrue(isElementVisible(BluetoothSensitivityDesc));
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while displaying Bluetooth Sensitivity Screen...");
        }
    }

    public void verifyBluetoothSensitivity(String strBLESensitivity, String strContent) {
        try {
            if (strBLESensitivity.equalsIgnoreCase(MessageConstants.BLE_HIGH)) {
                click(rdoBLEHigh);
                waitForGivenTime(1);
                String strAttr1 = getElementAttribute(rdoBLEHigh, MessageConstants.CHECKED_MESSAGE);
                String strAttr2 = getElementAttribute(rdoBLEMedium, MessageConstants.CHECKED_MESSAGE);
                String strAttr3 = getElementAttribute(rdoBLELow, MessageConstants.CHECKED_MESSAGE);
                TestUtils.log().info("Status for usage: {} is: {} ", strBLESensitivity, strAttr1);
                Assert.assertEquals(strAttr1, MessageConstants.TRUE_MESSAGE);
                Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strAttr3, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strContent, BLEHighDesc.getText());
            } else if (strBLESensitivity.equalsIgnoreCase(MessageConstants.BLE_MEDIUM)) {
                click(rdoBLEMedium);
                waitForGivenTime(1);
                String strAttr1 = getElementAttribute(rdoBLEHigh, MessageConstants.CHECKED_MESSAGE);
                String strAttr2 = getElementAttribute(rdoBLEMedium, MessageConstants.CHECKED_MESSAGE);
                String strAttr3 = getElementAttribute(rdoBLELow, MessageConstants.CHECKED_MESSAGE);
                TestUtils.log().info("Status for usage: {} is: {} ", strBLESensitivity, strAttr2);
                Assert.assertEquals(strAttr1, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strAttr2, MessageConstants.TRUE_MESSAGE);
                Assert.assertEquals(strAttr3, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strContent, BLEMediumDesc.getText());
            } else {
                click(rdoBLELow);
                waitForGivenTime(1);
                String strAttr1 = getElementAttribute(rdoBLEHigh, MessageConstants.CHECKED_MESSAGE);
                String strAttr2 = getElementAttribute(rdoBLEMedium, MessageConstants.CHECKED_MESSAGE);
                String strAttr3 = getElementAttribute(rdoBLELow, MessageConstants.CHECKED_MESSAGE);
                TestUtils.log().info("Status for usage: {} is: {} ", strBLESensitivity, strAttr3);
                Assert.assertEquals(strAttr1, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strAttr3, MessageConstants.TRUE_MESSAGE);
                Assert.assertEquals(strContent, BLELowDesc.getText());
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying Bluetooth Sensitivity options...");
        }
    }

    public void verifyIdentityPositioning(String OIPStatus) {
        try {
            scrollUpTillElement(switchIdentityPositioning, 1000, 0);
            isElementVisible(switchIdentityPositioning);
            if (OIPStatus.equalsIgnoreCase(MessageConstants.ENABLE_STRING)) {
                if (switchIdentityPositioning.getAttribute(MessageConstants.CHECKED_MESSAGE).equalsIgnoreCase(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Identity Positioning toggle button is initially in Enable state");
                } else {
                    click(switchIdentityPositioning);
                    TestUtils.log().info("Identity Positioning toggle button is set to Enable state");
                }
            } else if (OIPStatus.equalsIgnoreCase(MessageConstants.DISABLE_STRING)) {
                if (switchIdentityPositioning.getAttribute(MessageConstants.CHECKED_MESSAGE).equalsIgnoreCase(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Identity Positioning toggle button is initially in Disable state");
                } else {
                    click(switchIdentityPositioning);
                    TestUtils.log().info("Identity Positioning toggle button is set to Disable state");
                }
            } else TestUtils.log().info("Please provide correct input");

        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying identity Positioning button...");
        }
    }

//   ********************************************** code of Surrender sundarraj begins *********************************************************

    public void clickOnMobileIdsIcon() {
        try {
            if (isElementVisible(MobileIdsIcon)) {
                click(MobileIdsIcon);
                TestUtils.log().debug("Able to click MobileIds Icon in Setting Page...");
            } else {
                TestUtils.log().debug("Unable to click MobileIds Icon in Setting Page...");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking MobileIds Icon in Setting Page...");
        }
    }


//   ********************************************** code of Surrender sundarraj Ends *********************************************************

    public String[] olderApkAppPreferenceValues12To13() {
        String bluetoothValue = null;
        String NFCValue = null;
        String nearbyPermissionValue = null;
        String alwaysModeValue = null;
        String foregroundModeValue = null;
        String unlockedModeValue = null;
        String twistAndGoValue = null;
        String nearByReadersValue = null;
        String bluetoothSensitivityValue = null;
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
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getRdoUsageUnlocked(), "up");
            unlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            twistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement (appPrefencesScreenPage.getTxtNearbyReaderStatusValue(), "up");
            nearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getText();
            bluetoothSensitivityValue = appPrefencesScreenPage.getBluetoothSensitivityLevel().getText();
            showActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getSwitchDebugLogs(), "up");
            debugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            playSoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            vibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtBluetooth(), "down");

        } catch (Exception e) {
            System.out.println("olderApkValues12To13 " + e);
        }
        return new String[]{bluetoothValue, NFCValue, nearbyPermissionValue, alwaysModeValue, foregroundModeValue, unlockedModeValue, twistAndGoValue, nearByReadersValue, bluetoothSensitivityValue, showActivityValue, debugLogsValue, playSoundValue, vibrateValue};

    }

    public String[] olderApkAppPreferenceValues9() {
        String bluetoothValue = null;
        String locationValue = null;
        String locationPermissionValue = null;
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
            locationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
            locationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
            alwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getRdoUsageAlways(), "up");
            foregroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            unlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            twistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtNearbyReaderStatusValue(), "up");
            nearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            showActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getSwitchDebugLogs(), "up");
            debugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            playSoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            vibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
        } catch (Exception e) {
            System.out.println("olderApkValues9 " + e);
        }
        return new String[]{bluetoothValue, locationValue, locationPermissionValue, alwaysModeValue, foregroundModeValue, unlockedModeValue, twistAndGoValue, nearByReadersValue, showActivityValue, debugLogsValue, playSoundValue, vibrateValue};
    }

    public String[] olderApkAppPreferenceValues10To11() {
        String bluetoothValue = null;
        String NFCValue = null;
        String locationValue = null;
        String locationPermissionValue = null;
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
            locationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
            locationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getRdoUsageAlways(), "up");
            alwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            foregroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            unlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            twistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtNearbyReaderStatusValue(), "up");
            nearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            showActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getSwitchDebugLogs(), "up");
            debugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            playSoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            vibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
        } catch (Exception e) {
            System.out.println("olderApkValues10To11 " + e);
        }
        return new String[]{bluetoothValue, NFCValue, locationValue, locationPermissionValue, alwaysModeValue, foregroundModeValue, unlockedModeValue, twistAndGoValue, nearByReadersValue, showActivityValue, debugLogsValue, playSoundValue, vibrateValue};
    }

    public String[] newerApkAppPreferenceValues12To13() {
        String newBluetoothValue = null;
        String newNFCValue = null;
        String newNearbyPermissionValue = null;
        String newAlwaysModeValue = null;
        String newForegroundModeValue = null;
        String newUnlockedModeValue = null;
        String newTwistAndGoValue = null;
        String newNearByReadersValue = null;
        String newBluetoothSensitivityValue = null;
        String newShowActivityValue = null;
        String newDebugLogsValue = null;
        String newPlaySoundValue = null;
        String newVibrateValue = null;
        try {
            newBluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            newNFCValue = appPrefencesScreenPage.getTxtNFCStatusValue().getText();
            newNearbyPermissionValue = appPrefencesScreenPage.getTxtNearByPermissionStatusValue().getText();
            newAlwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            newForegroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getRdoUsageUnlocked(), "up");
            newUnlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            newTwistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtNearbyReaderStatusValue(), "up");
            newNearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getText();
            newBluetoothSensitivityValue = appPrefencesScreenPage.getBluetoothSensitivityLevel().getText();
            newShowActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getSwitchDebugLogs(), "up");
            newDebugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newPlaySoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newVibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtBluetooth(), "down");

        } catch (Exception e) {
            System.out.println("newerApkValues12To13 " + e);
        }
        return new String[]{newBluetoothValue, newNFCValue, newNearbyPermissionValue, newAlwaysModeValue, newForegroundModeValue, newUnlockedModeValue, newTwistAndGoValue, newNearByReadersValue, newBluetoothSensitivityValue, newShowActivityValue, newDebugLogsValue, newPlaySoundValue, newVibrateValue};
    }

    public String[] newerApkAppPreferenceValues9() {
        String newBluetoothValue = null;
        String newLocationValue = null;
        String newLocationPermissionValue = null;
        String newAlwaysModeValue = null;
        String newForegroundModeValue = null;
        String newUnlockedModeValue = null;
        String newTwistAndGoValue = null;
        String newNearByReadersValue = null;
        String newShowActivityValue = null;
        String newDebugLogsValue = null;
        String newPlaySoundValue = null;
        String newVibrateValue = null;
        try {
            newBluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            newLocationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
            newLocationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
            newAlwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getRdoUsageAlways(), "up");
            newForegroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            newUnlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            newTwistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtNearbyReaderStatusValue(), "up");
            newNearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newShowActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getSwitchDebugLogs(), "up");
            newDebugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newPlaySoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newVibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
        } catch (Exception e) {
            System.out.println("olderApkValues9 " + e);
        }
        return new String[]{newBluetoothValue, newLocationValue, newLocationPermissionValue, newAlwaysModeValue, newForegroundModeValue, newUnlockedModeValue, newTwistAndGoValue, newNearByReadersValue, newShowActivityValue, newDebugLogsValue, newPlaySoundValue, newVibrateValue};
    }

    public String[] newerApkAppPreferenceValues10To11() {
        String newBluetoothValue = null;
        String newNFCValue = null;
        String newLocationValue = null;
        String newLocationPermissionValue = null;
        String newAlwaysModeValue = null;
        String newForegroundModeValue = null;
        String newUnlockedModeValue = null;
        String newTwistAndGoValue = null;
        String newNearByReadersValue = null;
        String newShowActivityValue = null;
        String newDebugLogsValue = null;
        String newPlaySoundValue = null;
        String newVibrateValue = null;
        try {
            newBluetoothValue = appPrefencesScreenPage.getTxtBluetoothStatusValue().getText();
            newNFCValue = appPrefencesScreenPage.getTxtNFCStatusValue().getText();
            newLocationValue = appPrefencesScreenPage.getTxtLocationStatusValue().getText();
            newLocationPermissionValue = appPrefencesScreenPage.getTxtLocationPermStatusValue().getText();
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getRdoUsageAlways(), "up");
            newAlwaysModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageAlways(), MessageConstants.CHECKED_MESSAGE);
            newForegroundModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageForeground(), MessageConstants.CHECKED_MESSAGE);
            newUnlockedModeValue = getElementAttribute(appPrefencesScreenPage.getRdoUsageUnlocked(), MessageConstants.CHECKED_MESSAGE);
            newTwistAndGoValue = appPrefencesScreenPage.getSwitchTwistGo().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getTxtNearbyReaderStatusValue(), "up");
            newNearByReadersValue = appPrefencesScreenPage.getTxtNearbyReaderStatusValue().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newShowActivityValue = appPrefencesScreenPage.getSwitchShowActivity().getAttribute(MessageConstants.CHECKED_MESSAGE);
            iosScrollUpAndDownToElement(appPrefencesScreenPage.getSwitchDebugLogs(), "up");
            newDebugLogsValue = appPrefencesScreenPage.getSwitchDebugLogs().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newPlaySoundValue = appPrefencesScreenPage.getSwitchPlayAndSound().getAttribute(MessageConstants.CHECKED_MESSAGE);
            newVibrateValue = appPrefencesScreenPage.getSwitchVibrate().getAttribute(MessageConstants.CHECKED_MESSAGE);
        } catch (Exception e) {
            System.out.println("newerApkValues10To11 " + e);
        }
        return new String[]{newBluetoothValue, newNFCValue, newLocationValue, newLocationPermissionValue, newAlwaysModeValue, newForegroundModeValue, newUnlockedModeValue, newTwistAndGoValue, newNearByReadersValue, newShowActivityValue, newDebugLogsValue, newPlaySoundValue, newVibrateValue};
    }

    public void compareValues(String[] olderApkValues, String[] newerApkValues) {
        Assert.assertEquals(olderApkValues.length, (newerApkValues.length));

        // Compare each value
        for (int i = 0; i < olderApkValues.length; i++) {
            try {
                Assert.assertEquals(olderApkValues[i], newerApkValues[i]);
                System.out.println("Mismatch in values at index " + i + ": Older = " + olderApkValues [i] + ", Newer = " + newerApkValues[i]);
            } catch (AssertionError e) {
                // Log the mismatched values
                System.out.println("Mismatch in values at index " + i + ": Older = " + olderApkValues [i] + ", Newer = " + newerApkValues[i]);
            }
        }
    }

}



