package com.appium.HIDPages.android;

import com.appium.base.BasePage;

import com.appium.constants.MessageConstants;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.NAVIGATE_BACK;

public class Andr_HIDAppPreferencesScreenPage extends BasePage {
    /**
     * mobile elements - These are mobile elements which is present in app preferences page Date-25/01/2023
     */

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Bluetooth']",priority = 2)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth']",priority = 0)
    @AndroidFindBy(xpath = "android.widget.TextView[@text='Use Bluetooth']",priority = 1)
    private MobileElement txtBluetooth;

    @AndroidFindBy(xpath = "//*[@text='NFC']", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC']", priority = 1)
    private MobileElement txtNFC;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby Permission']")
    private MobileElement txtNearByPermission;

    @AndroidFindBy(xpath="((//android.widget.ImageView[@content-desc='Right arrow'])[3]")
    private MobileElement txtNearByPermissionTab;

    @AndroidFindBy(xpath="(//android.widget.ImageView[@content-desc='Right arrow'])[3])")
    private MobileElement txtNearByPermissionTabin13;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Always']/following-sibling::android.widget.RadioButton")
//    @AndroidFindBy(xpath = "(//android.widget.RadioButton[@resource-id='com.hidglobal.mobilekeys.android.v3:id/rbtnDoorOpening'])[1]")
//    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.TextView[@text=‘Always’]/following-sibling::android.widget.RadioButton[2]")
    private MobileElement rdoUsageAlways;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Foreground']/following-sibling::android.widget.RadioButton")
    //@AndroidFindBy(xpath = "(//android.widget.RadioButton[@resource-id='com.hidglobal.mobilekeys.android.v3:id/rbtnDoorOpening'])[2]")
    private MobileElement rdoUsageForeground;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Unlocked']/following-sibling::android.widget.RadioButton")
//    @AndroidFindBy(xpath = "(//android.widget.RadioButton[@resource-id='com.hidglobal.mobilekeys.android.v3:id/rbtnDoorOpening'])[3]")
    private MobileElement rdoUsageUnlocked;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth']/following-sibling::android.widget.TextView")
    private MobileElement txtBluetoothStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC']/following-sibling::android.widget.TextView")
    private MobileElement txtNFCStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']/following-sibling::android.widget.TextView")
    private MobileElement txtLocationStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/child::android.widget.TextView[2]")
    private MobileElement txtLocationPermissionStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby Permission']/following-sibling::android.widget.TextView")
    private MobileElement txtNearByPermissionStatusValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Permission']/following-sibling::android.widget.ImageView")
    private MobileElement imgLocationPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Activity']//following-sibling::android.widget.Switch")
    private MobileElement btnShowActivity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Play sound']")
    private MobileElement txtPlayAndSound;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Play sound']/following-sibling::android.widget.Switch")
    private MobileElement switchPlayAndSound;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Activity']")
    private MobileElement txtShowActivity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Show Activity']/following-sibling::android.widget.Switch")
    private MobileElement switchShowActivity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vibrate']")
    private MobileElement txtVibrate;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vibrate']/following-sibling::android.widget.Switch")
    private MobileElement switchVibrate;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Twist & Go']")
    private MobileElement txtTwistGo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Twist & Go']/following-sibling::android.widget.Switch")
    private MobileElement switchTwistGo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Debug logs']")
    private MobileElement txtDebugLogs;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Debug logs']/following-sibling::android.widget.Switch")
    private MobileElement switchDebugLogs;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App Preferences']//following-sibling::androidx.recyclerview.widget.RecyclerView//child::android.widget.TextView[@text='DEVICE']")
    private MobileElement txtDeviceAppPreference;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']")
    private MobileElement txtLocation;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtAppPreferences")
    private MobileElement txtAppPreferences;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/mobile_ids")
    private MobileElement txtViewMobileIdCard;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement batteryOptimizationTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement settingsAlertBtn;

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement backgroundPermissionPopup;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']")
    private MobileElement allowBtnBGPerm;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allowing HID Mobile Access to always run in the background may reduce battery life. You can change this later from Settings > Apps & notifications.']")
    private MobileElement PermPopupDescription;

    @AndroidFindBy(xpath="//android.view.ViewGroup[5]/android.widget.TextView[@resource-id='com.hidglobal.mobilekeys.android.v3:id/statusDevices']")
    private MobileElement txtLocationPermissionStatus;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Nearby Readers']")
    private MobileElement txtNearByReaders;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby Readers']/following-sibling::android.widget.TextView")
    private MobileElement txtNearbyReaderStatusValue;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtManageFavReaderHeading")
    private MobileElement txtNearbyReadersTitle;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/switchAppPreferencesWidget")
    private MobileElement nearByReaderTglBtn;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement nearByReaderAlertTitle;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertMessage")
    private MobileElement nearByReaderAlertContent;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertNegativeBtn")
    private MobileElement nearByReaderAlertNoBtn;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/alertPositiveBtn")
    private MobileElement nearByReaderAlertYesBtn;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/sensitivityLevel")
    private MobileElement bluetoothSensitivityLevel;

//   ************************************************* code of surrender sundarraj begins  ************************************************

    // *** New Xpath Discover nearby Readers

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Discover Nearby Readers']")
    private MobileElement txtDiscoverNearbyReaders;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HID Signo']")
    private MobileElement txtSignoReader;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Signo Icon\"])")
    private MobileElement txtSignoReaderIcon;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/signoReaderCheckbox")
    private MobileElement txtSignoReaderCheckbox;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement txtalertTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Positive Button\"]")
    private MobileElement alertPositiveBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Back Arrow\"]")
    private MobileElement ImgBackBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Back Arrow\"]")
    private MobileElement ImgBackAppPreferences;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HID iCLASS \\ multiCLASS SE']")
    private MobileElement txtRevEReader;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Rev-E Icon\"]")
    private MobileElement txtRevEReaderIcon;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/revECheckbox")
    private MobileElement txtRevEReaderCheckbox;


    //    ******************************************* code of surrender sundarraj ends *************************************************

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */

    public MobileElement getTxtDeviceAppPreference() {
        return txtDeviceAppPreference;
    }

    public MobileElement getTxtBluetoothStatusValue() {
        return txtBluetoothStatusValue;
    }

    public MobileElement getTxtNearbyReaderStatusValue() {
        return txtNearbyReaderStatusValue;
    }

    public MobileElement getSwitchPlayAndSound() {
        return switchPlayAndSound;
    }

    public MobileElement getTxtShowActivity() {
        return txtShowActivity;
    }

    public MobileElement getSwitchShowActivity() {
        return switchShowActivity;
    }

    public MobileElement getTxtLocationStatusValue() {
        return txtLocationStatusValue;
    }

    public MobileElement getTxtBluetooth() {
        return txtBluetooth;
    }

    public MobileElement getTxtNFC() {
        return txtNFC;
    }

    public MobileElement getTxtNearByPermission() {
        return txtNearByPermission;
    }

    public MobileElement getTxtNearByPermissionTab() {
        return txtNearByPermissionTab;
    }

    public MobileElement getRdoUsageAlways() {
        return rdoUsageAlways;
    }

    public MobileElement getRdoUsageForeground() {
        return rdoUsageForeground;
    }

    public MobileElement getRdoUsageUnlocked() {
        return rdoUsageUnlocked;
    }

    public MobileElement getTxtNFCStatusValue() {
        return txtNFCStatusValue;
    }

    public MobileElement getTxtLocationPermStatusValue() {
        return txtLocationPermissionStatusValue;
    }

    public MobileElement getTxtNearByPermissionStatusValue() {
        return txtNearByPermissionStatusValue;
    }

    public MobileElement getTxtLocationPermissionStatus(){
        return txtLocationPermissionStatus;
    }


    public MobileElement getImgLocationPermission() {
        return imgLocationPermission;
    }

    public MobileElement getBtnShowActivity() {
        return btnShowActivity;
    }

    public MobileElement getTxtPlayAndSound() {
        return txtPlayAndSound;
    }

    public MobileElement getTxtVibrate() {
        return txtVibrate;
    }

    public MobileElement getSwitchVibrate() {
        return switchVibrate;
    }

    public MobileElement getTxtTwistGo() {
        return txtTwistGo;
    }

    public MobileElement getSwitchTwistGo() {
        return switchTwistGo;
    }

    public MobileElement getTxtDebugLogs() {
        return txtDebugLogs;
    }

    public MobileElement getSwitchDebugLogs() {
        return switchDebugLogs;
    }

    public MobileElement getTxtLocation() {
        return txtLocation;
    }

    public MobileElement getTxtAppPreferences() {
        return txtAppPreferences;
    }

    public MobileElement getTxtViewMobileIdCard() {
        return txtViewMobileIdCard;
    }
    public MobileElement getTxtNearByPermissionTabin13(){
        return txtNearByPermissionTabin13;
    }

    public MobileElement getBluetoothSensitivityLevel(){
        return bluetoothSensitivityLevel;
    }

    /**
     * selectUsageType- This method is used to select the usage type
     *
     * @param usageType
     *         - String Date- 25/01/2023
     */
    public void selectUsageType(String usageType) {
        try {
            if (usageType.equalsIgnoreCase(MessageConstants.ALWAYS_STRING)) {
                click(rdoUsageAlways);
            } else if (usageType.equalsIgnoreCase(MessageConstants.FOREGROUND_STRING)) {
                click(rdoUsageForeground);
            } else if (usageType.equalsIgnoreCase(MessageConstants.UNLOCKED_STRING)) {
                click(rdoUsageUnlocked);
            } else {
                TestUtils.log().info("Please select correct usage type");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while selecting the usage type....",e);
        }
    }

    /**
     * clickOnBLETab- This method is used to click on the BLE tab Date- 25/01/2023
     */
    public void clickOnBLETab() {
        try {
            click(txtBluetooth);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on BLE tab...");
        }

    }


    /**
     * clickOnNFCTab- This method is used to click on the NFC tab Date- 25/01/2023
     */
    public void clickOnNFCTab() {
        try {
            click(txtNFC);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on NFC tab...");
        }
    }

    /**
     * clickOnNearByPermission- This method is used to click on the NearByPermission tab Date- 25/01/2023
     */
    public void clickOnNearByPermission() {
        try {
            if (isDisplayed(txtNearByPermission)) {
                click(txtNearByPermission);
            } else {
                TestUtils.log().info("Nearby Permission is not available in this Android Version");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Nearby Permission...");
        }
    }

    public void clickOnNearByPermissionTab(){
        try {
            if (isDisplayed(txtNearByPermissionTab)) {
                click(txtNearByPermissionTab);
            } else {
                TestUtils.log().info("Nearby Permission tab is not available in this Android Version");
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Nearby Permission tab...");
        }
    }

    /**
     * checkBLEStatus- This method is used to check BLE status Date- 25/01/2023
     */
    public boolean checkBLEStatus() {
        boolean flag = false;
        try {
            String strBLEStatusValue = txtBluetoothStatusValue.getText();
            if (strBLEStatusValue.equalsIgnoreCase("Off")) {
                flag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking on BLE status...");
        }
        return flag;
    }

    /**
     * checkNFCStatus- This method is used to check NFC status Date- 30/06/2023
     */
    public boolean checkNFCStatus() {
        boolean flag = false;
        try {
            String strNFCStatusValue = txtNFCStatusValue.getText();
            if (strNFCStatusValue.equalsIgnoreCase("Off")) {
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking on NFC status...");
        }
        return flag;
    }

    /**
     * checkLocationStatus- This method is used to check location status Date- 25/01/2023
     */
    public boolean checkLocationStatus() {
        boolean flag = false;
        try {
            String strLocationStatusValue = txtLocationStatusValue.getText();
            if (strLocationStatusValue.equalsIgnoreCase("Off")) {
                flag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking Location status...");
        }
        return flag;
    }

    /**
     * clickOnLocationPermission- This method is used to click on the location permission Date- 25/01/2023
     */
    public void clickOnLocationPermission() {
        try {
            click(txtLocationPermissionStatusValue);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking on Location Permission...");
        }
    }

    /**
     * clickOnShowActivity- This method is used to click on the show activity Date- 25/01/2023
     */
    public void clickOnShowActivity() {
        try {
            loopHandle(btnShowActivity, "swipeDown", 5);
            String statusShowActivity = getElementAttribute(btnShowActivity, MessageConstants.CHECKED_MESSAGE);
            if (statusShowActivity.equalsIgnoreCase(MessageConstants.FALSE_MESSAGE))
                click(btnShowActivity);
            else {
                TestUtils.log().info("Show Activity toggle button is already enabled");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Show Activity...",e);
        }
    }

    /**
     * backToMobileIdScreen- This method used to navigate back to the mobile id screen Date- 25/01/2023
     */
    public void backToMobileIdScreen() {
//        loopHandle(txtViewMobileIdCard, "navigateBack", 5);
        navigateBack();
        navigateBack();
    }

    /**
     * enableActivityLogsAndNavigateToMobileIDScreen- This method is used to enable activity los and navigate back to mobileId screen Date-03/02/2023
     */
    public void enableActivityLogsAndNavigateToMobileIDScreen() {
        try {
//            clickOnShowActivity();
            backToMobileIdScreen();
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while enable activity logs...");
        }
    }

    /**
     * toVerifyNearByDevicesPermissionStatus - This method is used to verify the nearby devices permission
     *
     * @param strPermissionStatus-String
     *         Date-16/02/2023
     */
        public void toVerifyNearByOrLocationPermissionStatus(String strPermissionStatus) {
        String strDevicePlatformVersion = DriverManager.getPlatformVersion();
        switch (strDevicePlatformVersion) {
            case "12","13" -> {
                if (strPermissionStatus.equalsIgnoreCase("Allow")) {
                    Assert.assertEquals(getTxtNearByPermissionStatusValue().getText(), "Granted always");
                } else if (strPermissionStatus.equalsIgnoreCase("Don't allow") || strPermissionStatus.equalsIgnoreCase("Deny")) {
                    Assert.assertEquals(getTxtNearByPermissionStatusValue().getText(), "Denied");
                } else
                    TestUtils.log().info("Please provide correct input");

            }
            case "10","11" -> {
                if (strPermissionStatus.equalsIgnoreCase("Allow all the time")) {
                    Assert.assertEquals(getTxtLocationPermissionStatus().getText(), "Always");
                } else if (strPermissionStatus.equalsIgnoreCase("Allow only while using the app") || strPermissionStatus.equalsIgnoreCase("Allow only while using app")) {
                    Assert.assertEquals(getTxtLocationPermissionStatus().getText(), "While using the app");
                }else if (strPermissionStatus.equalsIgnoreCase("Don't allow") || strPermissionStatus.equalsIgnoreCase("Deny") || strPermissionStatus.equalsIgnoreCase("Ask every time")) {
                    Assert.assertEquals(getTxtLocationPermissionStatus().getText(), "Denied");
                } else
                    TestUtils.log().info("Please provide correct input");

            }
            default -> {
                if (strPermissionStatus.equalsIgnoreCase("Allow") || strPermissionStatus.equalsIgnoreCase("Allow all the time") || strPermissionStatus.equalsIgnoreCase("Allow only while using app") || strPermissionStatus.equalsIgnoreCase(" Allow only while using the app")) {
                    Assert.assertEquals(getTxtLocationPermStatusValue().getText(), MessageConstants.ALWAYS_STRING);
                } else if (strPermissionStatus.equalsIgnoreCase("Don't allow") || strPermissionStatus.equalsIgnoreCase("Deny")) {
                    Assert.assertEquals(getTxtLocationPermStatusValue().getText(), "We do not track your location. Enable Location to use your Mobile ID over Bluetooth.");
                } else
                    TestUtils.log().info("Please provide correct input");
            }
        }

    }

    /**
     * checkUsageState- This method is used to check the usage state
     *
     * @param usageType
     *         - String Date- 25/01/2023
     */
    public void checkUsageState(String usageType) {
        try {
            loopHandle(txtPlayAndSound, "swipeUp", 5);
            if (usageType.equalsIgnoreCase(MessageConstants.ALWAYS_STRING)) {
                click(rdoUsageAlways);
                if(isDisplayed(batteryOptimizationTitle)){
                    Assert.assertTrue(true, "The Battery Optimization Title  is  displayed...");
                    TestUtils.log().info("The BG Permission Popup  is  displayed...");
                    click(settingsAlertBtn);
                    if(isDisplayed(backgroundPermissionPopup))
                    {
                        Assert.assertTrue(true, "The BG Permission Popup  is  displayed...");
                        TestUtils.log().info("The BG Permission Popup  is  displayed...");
                        click(allowBtnBGPerm);
                    }
                    else
                    {
                        Assert.assertTrue(false, "The BG Permission Popup  is not displayed...");
                        TestUtils.log().info("The BG Permission Popup  is not displayed...");
                    }
                    waitForGivenTime(1);
                    String strAttr1 = getElementAttribute(rdoUsageAlways, MessageConstants.CHECKED_MESSAGE);
                    String strAttr2 = getElementAttribute(rdoUsageForeground, MessageConstants.CHECKED_MESSAGE);
                    String strAttr3 = getElementAttribute(rdoUsageUnlocked, MessageConstants.CHECKED_MESSAGE);
                    Assert.assertEquals(strAttr1, MessageConstants.TRUE_MESSAGE);
                    Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                    Assert.assertEquals(strAttr3, MessageConstants.FALSE_MESSAGE);
                    TestUtils.log().info("Status for usage: {} is: {} ",usageType, strAttr1);
                }else{
                    waitForGivenTime(1);
                    String strAttr1 = getElementAttribute(rdoUsageAlways, MessageConstants.CHECKED_MESSAGE);
                    String strAttr2 = getElementAttribute(rdoUsageForeground, MessageConstants.CHECKED_MESSAGE);
                    String strAttr3 = getElementAttribute(rdoUsageUnlocked, MessageConstants.CHECKED_MESSAGE);
                    Assert.assertEquals(strAttr1, MessageConstants.TRUE_MESSAGE);
                    Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                    Assert.assertEquals(strAttr3, MessageConstants.FALSE_MESSAGE);
                    TestUtils.log().info("Status for usage: {} is: {} ",usageType, strAttr1);
                }
                waitForGivenTime(1);
                String strAttr1 = getElementAttribute(rdoUsageAlways, MessageConstants.CHECKED_MESSAGE);
                String strAttr2 = getElementAttribute(rdoUsageForeground, MessageConstants.CHECKED_MESSAGE);
                String strAttr3 = getElementAttribute(rdoUsageUnlocked, MessageConstants.CHECKED_MESSAGE);
                TestUtils.log().info("Status for usage: {} is: {} ",usageType, strAttr1);
                Assert.assertEquals(strAttr1, MessageConstants.TRUE_MESSAGE);
                Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strAttr3, MessageConstants.FALSE_MESSAGE);
            } else if (usageType.equalsIgnoreCase(MessageConstants.FOREGROUND_STRING)) {
                click(rdoUsageForeground);
                waitForGivenTime(1);
                String strAttr1 = getElementAttribute(rdoUsageAlways, MessageConstants.CHECKED_MESSAGE);
                String strAttr2 = getElementAttribute(rdoUsageForeground, MessageConstants.CHECKED_MESSAGE);
                String strAttr3 = getElementAttribute(rdoUsageUnlocked, MessageConstants.CHECKED_MESSAGE);
                TestUtils.log().info("Status for usage: {} is: {} ",usageType, strAttr2);
                Assert.assertEquals(strAttr2, MessageConstants.TRUE_MESSAGE);
                Assert.assertEquals(strAttr1, MessageConstants.FALSE_MESSAGE);
                Assert.assertEquals(strAttr3, MessageConstants.FALSE_MESSAGE);
            } else if (usageType.equalsIgnoreCase(MessageConstants.UNLOCKED_STRING)) {
                click(rdoUsageUnlocked);
                if(isDisplayed(batteryOptimizationTitle))
                {
                    Assert.assertTrue(true, "The Battery Optimization Title  is  displayed...");
                    TestUtils.log().info("The BG Permission Popup  is  displayed...");
                    click(settingsAlertBtn);
                        if(isDisplayed(backgroundPermissionPopup))
                       {
                          Assert.assertTrue(true, "The BG Permission Popup  is  displayed...");
                          TestUtils.log().info("The BG Permission Popup  is  displayed...");
                          click(allowBtnBGPerm);
                       }
                      else
                      {
                        Assert.assertTrue(false, "The BG Permission Popup  is not displayed...");
                        TestUtils.log().info("The BG Permission Popup  is not displayed...");
                      }
                    waitForGivenTime(1);
                    String strAttr1 = getElementAttribute(rdoUsageAlways, MessageConstants.CHECKED_MESSAGE);
                    String strAttr2 = getElementAttribute(rdoUsageForeground, MessageConstants.CHECKED_MESSAGE);
                    String strAttr3 = getElementAttribute(rdoUsageUnlocked, MessageConstants.CHECKED_MESSAGE);
                    Assert.assertEquals(strAttr3, MessageConstants.TRUE_MESSAGE);
                    Assert.assertEquals(strAttr1, MessageConstants.FALSE_MESSAGE);
                    Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                    TestUtils.log().info("Status for usage: {} is: {} ",usageType, strAttr3);
                }
                else
                {
                    waitForGivenTime(1);
                    String strAttr1 = getElementAttribute(rdoUsageAlways, MessageConstants.CHECKED_MESSAGE);
                    String strAttr2 = getElementAttribute(rdoUsageForeground, MessageConstants.CHECKED_MESSAGE);
                    String strAttr3 = getElementAttribute(rdoUsageUnlocked, MessageConstants.CHECKED_MESSAGE);
                    Assert.assertEquals(strAttr3, MessageConstants.TRUE_MESSAGE);
                    Assert.assertEquals(strAttr1, MessageConstants.FALSE_MESSAGE);
                    Assert.assertEquals(strAttr2, MessageConstants.FALSE_MESSAGE);
                    TestUtils.log().info("Status for usage: {} is: {} ",usageType, strAttr3);
                }
            }
            else
                TestUtils.log().info("Please select the correct usage state");


        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking usages status...");
        }
    }

    /**
     * verifyPlaySoundToggleButton- This method used to verify play sound toggle button state
     *
     * @param -switchState
     *         -String Date- 25/01/2023
     */
    public void verifyPlaySoundToggleButton(String switchState) {
        try {
            scrollUpTillElement(txtPlayAndSound, 1000, 0);
            //swipeDown(2);
            isElementVisible(txtPlayAndSound);
            if (switchState.equalsIgnoreCase(MessageConstants.DISABLE_ENABLE_STRING)) {
                if (switchPlayAndSound.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Play Sound toggle button is initially in Enable state");
                } else {
                    click(switchPlayAndSound);
                    Assert.assertTrue(switchPlayAndSound.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                    TestUtils.log().info("Play Sound toggle button is change in Enable state");
                }
                click(switchPlayAndSound);
                Assert.assertTrue(switchPlayAndSound.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                TestUtils.log().info("Play Sound toggle button is set in Disable state");
                click(switchPlayAndSound);
                Assert.assertTrue(switchPlayAndSound.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                TestUtils.log().info("Play Sound toggle button is change in Enable state");
            } else {
                TestUtils.log().info("Please provide correct toggle switch value of Play and sound");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying play sound toggle button...");
        }
    }

    /**
     * verifyShowActivityToggleButton- This method used to verify show activity toggle button state
     *
     * @param -switchState
     *         -String Date- 25/01/2023
     */
    public void verifyShowActivityToggleButton(String switchState) {
        try {
            scrollUpTillElement(txtShowActivity, 1000, 0);
            isElementVisible(txtShowActivity);
            if (switchState.equalsIgnoreCase(MessageConstants.ENABLE_DISABLE_STRING)) {
                if (switchShowActivity.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Show activity toggle button is initially in Disable state");
                } else {
                    click(switchShowActivity);
                    Assert.assertTrue(switchShowActivity.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                    TestUtils.log().info("Show activity toggle button is set in Disable state");
                }
                click(switchShowActivity);
                Assert.assertTrue(switchShowActivity.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                TestUtils.log().info("Show activity toggle button is change in Enable state");
                click(switchShowActivity);
                Assert.assertTrue(switchShowActivity.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                TestUtils.log().info("Show activity toggle button is set in Disable state");
            } else {
                TestUtils.log().info("Please provide correct toggle switch value of Show activity");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying show activity toggle button...");
        }
    }

    /**
     * verifyVibrateToggleButton- This method used to verify vibrate toggle button state
     *
     * @param -
     *         switchState -String Date- 25/01/2023
     */
    public void verifyVibrateToggleButton(String switchState) {
        try {
            scrollUpTillElement(txtVibrate, 1000, 0);
            isElementVisible(txtVibrate);
            if (switchState.equalsIgnoreCase(MessageConstants.DISABLE_ENABLE_STRING)) {
                if (switchVibrate.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Vibrate toggle button is initially in Enable state");
                } else {
                    click(switchVibrate);
                    Assert.assertTrue(switchVibrate.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                    TestUtils.log().info("Vibrate toggle button is set in Enable state");
                }
                click(switchVibrate);
                Assert.assertTrue(switchVibrate.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                TestUtils.log().info("Vibrate toggle button is set in Disable state");
                click(switchVibrate);
                Assert.assertTrue(switchVibrate.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                TestUtils.log().info("Vibrate toggle button is change in Enable state");
            } else {
                TestUtils.log().info("Please provide correct toggle switch value of Vibrate");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying vibrate toggle button...");
        }

    }

    /**
     * verifyTwistAndGoToggleButton- This method used to verify twist and go toggle button state
     *
     * @param -switchState
     *         -String Date- 25/01/2023
     */
    public void verifyTwistAndGoToggleButton(String switchState) {
        try {
            scrollUpTillElement(txtTwistGo, 1000, 0);
            isElementVisible(txtTwistGo);
            if (switchState.equalsIgnoreCase(MessageConstants.DISABLE_ENABLE_STRING)) {
                if (switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Twist & Go toggle button is initially in Enable state");
                } else {
                    click(switchTwistGo);
                    Assert.assertTrue(switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                    TestUtils.log().info("Twist & Go toggle button is set in Enable state");
                }
                click(switchTwistGo);
                Assert.assertTrue(switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                TestUtils.log().info("Twist & Go toggle button is set in Disable state");
                click(switchTwistGo);
                Assert.assertTrue(switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                TestUtils.log().info("Twist & Go toggle button is change in Enable state");
            } else {
                TestUtils.log().info("Please provide correct toggle switch value of Twist and Go");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying twist and go toggle button...");
        }

    }

    /**
     * verifyDebugLogsToggleButton- This method used to verify debug logs toggle button state
     *
     * @param -switchState
     *         -String Date- 25/01/2023
     */
    public void verifyDebugLogsToggleButton(String switchState) {
        try {
            scrollUpTillElement(txtDebugLogs, 1000, 0);
            isElementVisible(txtDebugLogs);
            if (switchState.equalsIgnoreCase(MessageConstants.ENABLE_DISABLE_STRING)) {
                if (switchDebugLogs.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Debug logs toggle button is initially in Disable state");
                } else {
                    click(switchDebugLogs);
                    Assert.assertTrue(switchDebugLogs.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                    TestUtils.log().info("Debug logs toggle button is set in Disable state");
                }
                click(switchDebugLogs);
                Assert.assertTrue(switchDebugLogs.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE));
                TestUtils.log().info("Debug logs toggle button is change in Enable state");
                click(switchDebugLogs);
                Assert.assertTrue(switchDebugLogs.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE));
                TestUtils.log().info("Debug logs toggle button is set in Disable state");
            } else {
                TestUtils.log().info("Please provide correct toggle switch value of Debug logs");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying debug logs button...");
        }
    }

    public void debugLogsToggleButton(String switchState) {
        try {
            scrollUpTillElement(txtDebugLogs, 1000, 0);
            isElementVisible(txtDebugLogs);
            if (switchState.equalsIgnoreCase(MessageConstants.ENABLE_STRING)) {
                if (switchDebugLogs.getAttribute(MessageConstants.CHECKED_MESSAGE).equalsIgnoreCase(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Debug logs toggle button is initially in Enable state");
                }else{
                    click(switchDebugLogs);
                    TestUtils.log().info("Debug logs toggle button is set to Enable state");
                }
            } else if (switchState.equalsIgnoreCase(MessageConstants.DISABLE_STRING)) {
                if (switchDebugLogs.getAttribute(MessageConstants.CHECKED_MESSAGE).equalsIgnoreCase(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Debug logs toggle button is initially in Disable state");
                }else{
                    click(switchDebugLogs);
                    TestUtils.log().info("Debug logs toggle button is set to Disable state");
                }
            } else TestUtils.log().info("Please provide correct input");

        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying debug logs button...");
        }
    }

    public void setTwistAndGoEnableOrDisable(String switchState){
        try {
            scrollUpTillElement(txtTwistGo, 1000, 0);
            isElementVisible(txtTwistGo);
            if (switchState.equalsIgnoreCase(MessageConstants.ENABLE_STRING)) {
                if (switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Twist & Go toggle button is initially in Enable state");
                }else
                    click(switchTwistGo);
                if (switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Twist & Go toggle button is set to Enable state");
                }
            }else{
                if (switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Twist & Go toggle button is initially in Disable state");
                }else
                    click(switchTwistGo);
                if (switchTwistGo.getAttribute(MessageConstants.CHECKED_MESSAGE).equals(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Twist & Go toggle button is set to Disable state");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying twist and go toggle button....");
        }
    }

    public void verifyActivityToggleButton(String switchState) {
        try {
            scrollUpTillElement(switchShowActivity, 1000, 0);
            isElementVisible(switchShowActivity);
            if (switchState.equalsIgnoreCase(MessageConstants.ENABLE_STRING)) {
                if (switchShowActivity.getAttribute(MessageConstants.CHECKED_MESSAGE).equalsIgnoreCase(MessageConstants.TRUE_MESSAGE)) {
                    TestUtils.log().info("Show Activity toggle button is initially in Enable state");
                } else {
                    click(switchShowActivity);
                    TestUtils.log().info("Show Activity toggle button is set to Enable state");
                }
            } else if (switchState.equalsIgnoreCase(MessageConstants.DISABLE_STRING)) {
                if (switchShowActivity.getAttribute(MessageConstants.CHECKED_MESSAGE).equalsIgnoreCase(MessageConstants.FALSE_MESSAGE)) {
                    TestUtils.log().info("Show Activity toggle button is initially in Disable state");
                } else {
                    click(switchShowActivity);
                    TestUtils.log().info("Show Activity toggle button is set to Disable state");
                }
            } else TestUtils.log().info("Please provide correct input");

        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying Show Activity button...");
        }
    }

    public void clickOnNearbyReaders(){
        try{
            scrollUpTillElement(txtNearByReaders, 1000, 0);
            isElementVisible(txtNearByReaders);
            click(txtNearByReaders);
        }catch (Exception e){
            TestUtils.log().debug("Exception occurred while clicking Nearby Readers tab...");
        }
    }

    public void setNearByReaderStatus(String nearByReaderStatus) {
        try {
            scrollUpTillElement(txtNearByReaders, 1000, 0);
            isElementVisible(txtNearByReaders);
            String strNearByReaderStatusValue = getElementText(getTxtNearbyReaderStatusValue());
            String nearByReaderToggle = "false";
            System.out.println(strNearByReaderStatusValue+ "><<<<<M<< M<<");
            if (nearByReaderStatus.equalsIgnoreCase(strNearByReaderStatusValue)) {
                TestUtils.log().info("NearBy Reader status is already set as {}",strNearByReaderStatusValue);
            }else{
                click(txtNearByReaders);
                isDisplayed(txtNearbyReadersTitle);
                String nearByReaderToggleStatus = getElementAttribute(nearByReaderTglBtn,"checked");
                if(nearByReaderToggleStatus.equalsIgnoreCase("true")){
                    if(nearByReaderStatus.equalsIgnoreCase("On")){
                        click(nearByReaderTglBtn);
                        isDisplayed(nearByReaderAlertTitle);
                        isDisplayed(nearByReaderAlertContent);
                        click(nearByReaderAlertYesBtn);
                    }else{
                        TestUtils.log().info("NearBy Reader status is already set as Off");
                    }
                }else{
                    TestUtils.log().info("NearBy Reader status is already set as {}",strNearByReaderStatusValue);
                }

            }
        }catch(Exception e){
            TestUtils.log().info("Exception occurred while setting the NearBy Reader status...");
        }
    }

//   ********************************************** code of Surrender sundarraj *********************************************************

    public void checkDiscoverNearbyReaderText() {
        try {
            scrollUpTillElement(txtDiscoverNearbyReaders, 1000, 0);
            isElementVisible(txtDiscoverNearbyReaders);
            TestUtils.log().debug("DiscoverNearbyReaders Text is Visible...");
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking Discover Nearby Readers tab...");
        }
    }

    public void checkSignoReaderText() {
        try {
            isElementVisible(txtSignoReader);
            TestUtils.log().debug("Signo Reader Text is Visible...");
            isElementVisible(txtSignoReaderCheckbox);
            TestUtils.log().debug("Signo Reader Checkbox is Visible...");
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking Signo Readers tab...");
        }
    }

    public void checkSignoReaderStatus(String SignoReader) {
        try {
            isDisplayed(txtSignoReaderCheckbox);
            String SignoReaderCheckbox = getElementAttribute(txtSignoReaderCheckbox, "checked");
            if (SignoReaderCheckbox.equalsIgnoreCase(SignoReader)) {
                TestUtils.log().info("Signo Reader status is already set as Off");
            } else {
                TestUtils.log().info("Signo Reader status is already set as On");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking Signo Readers Status...");
        }


    }

    public void checkRevEReaderText() {
        try {
            isElementVisible(txtRevEReader);
            TestUtils.log().debug("RivE Reader Text is Visible...");
            isElementVisible(txtRevEReaderCheckbox);
            TestUtils.log().debug("RivE Reader Checkbox is Visible...");
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking RivE Readers tab...");
        }
    }

    public void checkRevEReaderStatus(String RevEReader) {
        try {
            isDisplayed(txtRevEReaderCheckbox);
            String RevEReaderCheckbox = getElementAttribute(txtRevEReaderCheckbox, "checked");
            if (RevEReaderCheckbox.equalsIgnoreCase(RevEReader)) {
                TestUtils.log().info("RevE Reader status is already set as Off");
            } else {
                TestUtils.log().info("RevE Reader status is already set as On");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking RevE Readers Status...");
        }


    }

    public void clickRevEReadercheckbox() {
        try {
            click(txtRevEReaderCheckbox);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking RevE Reader Checkbox...");
        }
    }

    public void disableRevEReadercheckbox() {
        try {
            click(txtRevEReaderCheckbox);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while disable RevE Reader Checkbox...");
        }
    }

    public void checkAlertTitleText() {
        try {
            scrollUpTillElement(txtalertTitle, 1000, 0);
            if (isElementVisible(txtalertTitle)) {
                TestUtils.log().debug("AlertTitle pop up Text is Visible...");
            } else {
                TestUtils.log().debug("AlertTitle pop up Text is Invisible...");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking AlertTitle pop up Text...");
        }

    }

    public void clickAlertPositiveBtn() {
        try {
            click(alertPositiveBtn);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking alertPositiveBtn...");
        }
    }

    public void disableSignoReadercheckbox() {
        try {
            click(txtSignoReaderCheckbox);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while disable Signo Reader Checkbox...");
        }
    }

    public void checkNearbyReaderStatus() {
        try {
            scrollUpTillElement(txtalertTitle, 1000, 0);
            if (isElementVisible(txtalertTitle)) {
                TestUtils.log().debug("Nearby Reader toggle button is disabled in android device...");
            } else {
                TestUtils.log().debug("Nearby Reader toggle button is enabled in android device...");

            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking Nearby Reader Status...");
        }
    }

    public void clickOnNearbyReaderSwitch() {
        try {
            scrollUpTillElement(nearByReaderTglBtn, 1000, 0);
            isElementVisible(nearByReaderTglBtn);
            click(nearByReaderTglBtn);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking Nearby Readers tab...");
        }
    }

    public void clickImgBackBtn() {
        try {
//            scrollUpTillElement(txtalertTitle, 1000, 0);
            if (isElementVisible(ImgBackBtn)) {
                click(ImgBackBtn);
                TestUtils.log().debug("Able to click back button in Nearby Readers Page...");
            } else {
                TestUtils.log().debug("Unable to click back button in Nearby Readers Page...");

            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking back button in Nearby Readers Page...");
        }
    }

    public void clickImgBackAppPreferencesPage() {
        try {
            if (isElementVisible(ImgBackAppPreferences)) {
                click(ImgBackAppPreferences);
                TestUtils.log().debug("Able to click back button in App Preferences Page...");
            } else {
                TestUtils.log().debug("Unable to click back button in App Preferences Page...");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while clicking back button in App Preferences Page...");
        }
    }

    //   ********************************************** code of Surrender sundarraj Ends *********************************************************
}
