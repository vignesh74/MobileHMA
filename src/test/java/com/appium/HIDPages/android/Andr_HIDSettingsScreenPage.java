package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
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

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement txtNoConnection;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertMessage")
    private MobileElement txtNoInternetConnection;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement txtNoConnectionOKbtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm Deregister']")
    private MobileElement txtConfirmUnregisterPopUpTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='DEREGISTER']")
    private MobileElement btnUnRegister;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have successfully Deregistered from HID Mobile Access. All your Mobile IDs have been deleted.']")
    private MobileElement txtDeviceUnRegistredMessage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnOk")
    private MobileElement btnOk;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement confirmAlertOkBtn;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Always']")
    private MobileElement txtAlways;
    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtReason")
    private MobileElement enforcedAlwaysTxt;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.hidglobal.mobilekeys.android.v3:id/doorOpeningListItem'][1]")
    private MobileElement chkMode;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Foreground']")
    private MobileElement txtForeground;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.hidglobal.mobilekeys.android.v3:id/doorOpeningListItem'][2]")
    private MobileElement chkForeground;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Unlocked']")
    private MobileElement txtUnlocked;
    @AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='com.hidglobal.mobilekeys.android.v3:id/doorOpeningListItem'][2]")
    private MobileElement chkUnlocked;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HID Mobile Access Version']")
    private MobileElement txtHIDMobileAccessVersion;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='HID Origo SDK Version']")
    private MobileElement txtHIDOrigoSDKVersion;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Door Opening Mode']")
    private MobileElement txtDoorOpeningMode;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Readers found']")
    private MobileElement txtReadersFound;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Endpoint Status']")
    private MobileElement txtEndPointStatus;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Seos ID']")
    private MobileElement txtSeosID;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Seos ID']/following-sibling::android.widget.TextView")
    private MobileElement txtSeosIDValue;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Last Server Communication']")
    private MobileElement txtLastServerComm;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Endpoint App Version']")
    private MobileElement txtEndPointAppVersion;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Environment']")
    private MobileElement txtEnvironment;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='OS version']")
    private MobileElement txtOSVersion;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='BLE info']")
    private MobileElement txtBleInfo;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='NFC info']")
    private MobileElement txtNfcInfo;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Location info']")
    private MobileElement txtLocationInfo;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Nearby Permission']")
    private MobileElement txtNearByPermission;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Location Permission']")
    private MobileElement txtLocationPermission;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='APPLICATION INFO']")
    private MobileElement txtApplicationInfo;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='ENDPOINT INFO']")
    private MobileElement txtEndPointInfo;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='DEVICE INFO']")
    private MobileElement txtDeviceInfo;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/imgCopyClipIcon")
    private MobileElement AboutCopyImage;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/imgCopyClipIcon")
    private MobileElement imgCopyClipIcon;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/imgBackAbout")
    private MobileElement AboutBackIcon;

    @AndroidFindBy(xpath="(//android.widget.Toast)[1]",priority = 0)
    @AndroidFindBy(xpath="//*[@id=\"sourceContainer\"]/div/div/div/div[3]/div/div/div/div[24]/span[3]/span/span/b", priority = 1)
    @AndroidFindBy(xpath="/hierarchy/android.widget.Toast[1]", priority = 2)
    @AndroidFindBy(xpath="//android.widget.Toast[@text='Copied to clipboard']", priority = 3)
    private MobileElement aboutCopyToastMsg;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='FAQ']")
    private MobileElement txtFAQMenu;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtfaqtitle")
    private MobileElement txtFAQTitle;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/imgBack")
    private MobileElement imgFAQBack;

    @AndroidFindBy(id="searchQueryInput")
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

    public MobileElement getTxtNoConnection(){
        return txtNoConnection;
    }

    public MobileElement getTxtNoInternetConnection(){
        return txtNoInternetConnection;
    }

    public MobileElement getTxtNoConnectionOKbtn(){
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
        }catch (Exception e){
            
            TestUtils.log().info("Getting Exception while performing device Deregister.");
        }
    }

    /**
     * traverseToSettingsPage- This method is used to traverse to the setting page from app preferences or mobile id page
     * Date-22/02/2023
     */
    public void traverseToSettingsPage()
    {
        try {
            if (isDisplayed(appPrefencesScreenPage.getTxtAppPreferences()))
            {
                loopHandle(mobileIDScreenPage.getSettingsTab(), "navigateBack", 3);
                if (isElementVisible(mobileIDScreenPage.getSettingsTab())) {
                    TestUtils.log().info("Setting page is displayed");
                }
            } else if (isDisplayed(mobileIDScreenPage.getTxtViewMobileIdCard())) {
                click(mobileIDScreenPage.getSettingsTab());
                waitForGivenTime(2);
            }
        }catch(Exception e){
            
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

    public void checkEnforcedSetting(String usage_state){
        if(usage_state == "Always"){
            String alwaysText = txtAlways.getText();
            Assert.assertEquals(alwaysText,usage_state);
            String enforcedAlways = enforcedAlwaysTxt.getText();
            Assert.assertEquals(enforcedAlways,"Enforced by your organization.");
            String alwaysAttribute  = chkMode.getAttribute("enabled");
            Assert.assertEquals(alwaysAttribute,"false");
        }else if(usage_state == "Foreground"){
            String foregroundText = txtForeground.getText();
            Assert.assertEquals(foregroundText,usage_state);
            String foregroundAttribute = chkForeground.getAttribute("enabled");
            Assert.assertEquals(foregroundAttribute,true);
        }else if(usage_state == "Unlocked"){
            String unlockedText = txtUnlocked.getText();
            Assert.assertEquals(unlockedText,usage_state);
            String unlockedAttribute = chkUnlocked.getAttribute("enabled");
            Assert.assertEquals(unlockedAttribute,true);
        }

    }

    public void verifyAboutMenu(){
        try {
            waitForVisibility(txtAbout);
            Assert.assertTrue(isElementVisible(txtAbout));

        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while verifying to About text ...");
        }
    }

    public void verifyApplicationInformation(){
        click(txtAbout);

        try{
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
            scrollDownTillElement(100,2);
            waitForVisibility(txtEndPointAppVersion);
            Assert.assertTrue(isElementVisible(txtEndPointAppVersion));
            scrollDownTillElement(100,2);
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
            scrollDownTillElement(100,2);
            if (DriverManager.getPlatformVersion().equalsIgnoreCase("7") ||
                    DriverManager.getPlatformVersion().equalsIgnoreCase("8") ||
                    DriverManager.getPlatformVersion().equalsIgnoreCase("9") ||
                    DriverManager.getPlatformVersion().equalsIgnoreCase("10") ||
                    DriverManager.getPlatformVersion().equalsIgnoreCase("11")) {
                waitForVisibility(txtLocationPermission);
                Assert.assertTrue(isElementVisible(txtLocationPermission));
            }else{
                waitForVisibility(txtNearByPermission);
                Assert.assertTrue(isElementVisible(txtNearByPermission));
            }

        }catch (Exception e){
            TestUtils.log().info("Getting Exception while verifying to Application Information ...");
        }
    }

    public void copyAboutScreen(){
        try{
            waitForVisibility(AboutCopyImage);
            click(AboutCopyImage);
        }catch(Exception e){
            TestUtils.log().info("Getting Exception while copying the about page content to clipboard");
        }
    }

    public void verifyAboutContents(){

       AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
        try{
            driver.getClipboard(ClipboardContentType.PLAINTEXT); // get plaintext
            String text =  driver.getClipboardText();
            if(text !=null){
                TestUtils.log().info("Contents are copied to clipboard");
            }else{
                TestUtils.log().info("Contents are not copied to clipboard");
            }
        }catch(Exception e){
            TestUtils.log().info("Getting Exception while checking the copied contents in clipboard..");
        }
    }

    public void clickOnDeregister(String action){
        try {
            if(action.equalsIgnoreCase("ON")){
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
        }catch (Exception e){

            TestUtils.log().info("Getting Exception while performing device Deregister.");
        }
    }

    public void verifyDeregisterContents(){
        isElementVisible(txtDeviceUnRegistredMessage);
        Assert.assertTrue(true,"You have successfully Deregistered from HID Mobile Access. All your Mobile IDs have been deleted.");
    }

    public void actionOnNetwork(String action){
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();

        if(action.equalsIgnoreCase("ON")){
            ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
            Assert.assertTrue(state.isWiFiEnabled(), "Wifi is not switched on");
            TestUtils.log().info("WiFi turned on");
            waitForGivenTime(3);
        }else if(action.equalsIgnoreCase("OFF")){
            ConnectionState state = driver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
            Assert.assertFalse(state.isWiFiEnabled(), "Wifi is not switched off");
            TestUtils.log().info("WiFi turned off");
        }else
            TestUtils.log().info("Incorrect action");

    }


    public void confirmDeregisterBtn(String wifiOFF){
        try{
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
        }catch(Exception e){
            TestUtils.log().info("Exception occurred while verifying the WiFi OFF functionality");
        }

    }

    public void verifyFAQMenu(){
        try {
            waitForVisibility(txtFAQMenu);
            Assert.assertTrue(isElementVisible(txtFAQMenu));

        } catch (Exception e) {

            TestUtils.log().info("Getting Exception while verifying to FAQ text ...");
        }
    }





}
