package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDSettingsScreenPage extends BasePage {
    /**
     * object created to access methods from page classes  Date- 25/1/2023
     */
    IOS_DeviceSettingsPage deviceSettingScreen = new IOS_DeviceSettingsPage();
    IOS_DeviceLocationSettingsPage deviceLocationSettingScreen = new IOS_DeviceLocationSettingsPage();
    IOS_HIDHelpCenterScreenPage helpCenterSettingScreen = new IOS_HIDHelpCenterScreenPage();

    /**
     * mobile elements - These are mobile elements which is present in HID settings Page Date-25/1/2023
     */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Settings\"]")
    private MobileElement tabSettings;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
    private MobileElement txtSettings;
    @iOSXCUITFindBy(accessibility = "DEVICE")
    private MobileElement txtDevice;
    @iOSXCUITFindBy(accessibility = "Bluetooth Permission Required")
    private MobileElement txtBluetoothOffError;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"severityIcon\"])[1]")
    private MobileElement imgBluetoothOffError;
    @iOSXCUITFindBy(accessibility = "Location Permission Required")
    private MobileElement txtLocationNotAsAlwaysError;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"severityIcon\"])[2]")
    private MobileElement imgLocationOffError;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Location Permission Required, Enable this to find readers nearby\"]]")
    private MobileElement txtInfoMessageLocation;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Bluetooth, On\"]")
    private MobileElement txtBluetoothON;
    @iOSXCUITFindBy(xpath = "//*[@name='Bluetooth']//following-sibling:: XCUIElementTypeStaticText")
    private MobileElement txtStatusBluetooth;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Bluetooth Permissions, Allowed\"]")
    private MobileElement lnkBluetoothPermissionAllowed;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Bluetooth Permissions']//following-sibling:: XCUIElementTypeStaticText", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Bluetooth Permissions, Allowed\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Bluetooth Permissions, Denied\"]", priority = 2)

    private MobileElement txtBluetoothPermissionStatus;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Bluetooth Permissions']//following-sibling:: XCUIElementTypeImage|XCUIElementTypeStaticText", priority = 0)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Bluetooth Permissions')]", priority = 1)
    private MobileElement imgBluetoothPermissionStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Location Services, On\"]")
    private MobileElement txtLocationON;
    @iOSXCUITFindBy(xpath = "//*[@name='Location Services']//following-sibling:: XCUIElementTypeImage")
    private MobileElement imgLocationServices;
    @iOSXCUITFindBy(xpath = "//*[@name='Location Services']//following-sibling:: XCUIElementTypeStaticText")
    private MobileElement txtLocationServicesStatus;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Location Permissions']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Location Permissions')]", priority = 1)
    private MobileElement imgLocationPermission;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Location Permissions']//following-sibling:: XCUIElementTypeStaticText", priority = 0)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Location Permissions, Always')]", priority = 1)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Location Permissions, While using the app\"]", priority = 2)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Location Permissions, Never\"]", priority = 3)
    private MobileElement txtLocationPermission;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Settings\"]")
    private MobileElement btnSettingPopUpLocation;

    @iOSXCUITFindBy(accessibility = "alertTitle")
    private MobileElement txtPopUpAlertTitle;

    //2. MODE
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='MODE']//following-sibling:: XCUIElementTypeButton//*[@name='Always']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Always, Use your Mobile ID when the app is in foreground or background or when your iPhone is locked\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Always')]", priority = 2)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Always, Use your Mobile ID when the app is in foreground or background or when your iPhone is locked')]", priority = 3)
    private MobileElement chkAlways;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='MODE']//following-sibling:: XCUIElementTypeButton//*[@name='Always']", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Always, Use your Mobile ID when the app is in foreground or background or when your iPhone is locked\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Always')]", priority = 2)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Always, Use your Mobile ID when the app is in foreground or background or when your iPhone is locked')]", priority = 3)
    private MobileElement txtAlways;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Foreground']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Foreground, Only use your Mobile ID when the app is in foreground\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Foreground')]", priority = 2)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Foreground, Only use your Mobile ID when the app is in foreground')]", priority = 3)
    private MobileElement chkForeground;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Foreground\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Foreground, Only use your Mobile ID when the app is in foreground\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Foreground')]", priority = 2)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Foreground, Only use your Mobile ID when the app is in foreground')]", priority = 3)
    private MobileElement txtForeground;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Unlocked']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Unlocked, Only use your Mobile ID when your iPhone is unlocked\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Unlocked')]", priority = 2)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Unlocked, Only use your Mobile ID when your iPhone is unlocked')]", priority = 3)
    private MobileElement chkUnlocked;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Unlocked\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Unlocked, Only use your Mobile ID when your iPhone is unlocked\"]", priority = 1)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Unlocked')]", priority = 2)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Unlocked, Only use your Mobile ID when your iPhone is unlocked')]", priority = 3)
    private MobileElement txtUnlocked;

    //3. Sounds and Vibration
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Play Sound\"]|/XCUIElementTypeSwitch", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Play Sound\"]", priority = 1)
    private MobileElement tglBtnPlayAndSound;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Play Sound\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Play Sound\"]", priority = 1)
    private MobileElement txtPlayAndSound;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Vibrate\"]|/XCUIElementTypeSwitch", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Vibrate\"]", priority = 1)
    private MobileElement tglBtnVibrate;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Vibrate\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Vibrate\"]", priority = 1)
    private MobileElement txtVibrate;

    //4. Gestures
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Twist & Go\"]|/XCUIElementTypeSwitch", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Twist & Go\"]", priority = 1)
    private MobileElement tglBtnTwistAndGo;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Twist & Go\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Twist & Go\"]", priority = 1)
    private MobileElement txtTwistAndGo;

    //5. Help Center
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Help Centre']//following-sibling:: XCUIElementTypeStaticText", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]", priority = 1)
    private MobileElement txtHelpCenter;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Help Centre']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]", priority = 1)
    private MobileElement imgHelpCenter;

    //6. Deregister
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DEREGISTER\"]")
    private MobileElement txtDeregister;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='DEREGISTER']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"DEREGISTER\"]", priority = 1)
    private MobileElement imgDeregister;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */
    public MobileElement getTabSettings() {
        return tabSettings;
    }

    public MobileElement getTxtSettings() {
        return txtSettings;
    }

    public MobileElement getTxtDevice() {
        return txtDevice;
    }

    public MobileElement getTxtBluetoothOffError() {
        return txtBluetoothOffError;
    }

    public MobileElement getImgBluetoothOffError() {
        return imgBluetoothOffError;
    }

    public MobileElement getTxtLocationNotAsAlwaysError() {
        return txtLocationNotAsAlwaysError;
    }

    public MobileElement getImgLocationOffError() {
        return imgLocationOffError;
    }

    public MobileElement getTxtInfoMessageLocation() {
        return txtInfoMessageLocation;
    }

    public MobileElement getTxtLocationPermission() {
        return txtLocationPermission;
    }

    public MobileElement getTxtBluetoothON() {
        return txtBluetoothON;
    }

    public MobileElement getTxtStatusBluetooth() {
        return txtStatusBluetooth;
    }

    public MobileElement getLnkBluetoothPermissionAllowed() {
        return lnkBluetoothPermissionAllowed;
    }

    public MobileElement getTxtBluetoothPermissionStatus() {
        return txtBluetoothPermissionStatus;
    }

    public MobileElement getTxtLocationON() {
        return txtLocationON;
    }

    public MobileElement getImgLocationServices() {
        return imgLocationServices;
    }

    public MobileElement getTxtLocationServicesStatus() {
        return txtLocationServicesStatus;
    }

    public MobileElement getImgLocationPermission() {
        return imgLocationPermission;
    }

    public MobileElement getChkAlways() {
        return chkAlways;
    }

    public MobileElement getChkForeground() {
        return chkForeground;
    }

    public MobileElement getChkUnlocked() {
        return chkUnlocked;
    }

    public MobileElement getTglBtnPlayAndSound() {
        return tglBtnPlayAndSound;
    }

    public MobileElement getTglBtnVibrate() {
        return tglBtnVibrate;
    }

    public MobileElement getImgBluetoothPermissionStatus() {
        return imgBluetoothPermissionStatus;
    }

    public MobileElement getTxtAlways() {
        return txtAlways;
    }

    public MobileElement getTxtForeground() {
        return txtForeground;
    }

    public MobileElement getTxtUnlocked() {
        return txtUnlocked;
    }

    public MobileElement getTxtPlayAndSound() {
        return txtPlayAndSound;
    }

    public MobileElement getTxtVibrate() {
        return txtVibrate;
    }

    public MobileElement getTxtTwistAndGo() {
        return txtTwistAndGo;
    }

    public MobileElement getTglBtnTwistAndGo() {
        return tglBtnTwistAndGo;
    }

    public MobileElement getTxtHelpCenter() {
        return txtHelpCenter;
    }

    public MobileElement getImgHelpCenter() {
        return imgHelpCenter;
    }

    public MobileElement getTxtDeregister() {
        return txtDeregister;
    }

    public MobileElement getImgDeregister() {
        return imgDeregister;
    }

    public MobileElement getTxtPopUpAlertTitle() {
        return txtPopUpAlertTitle;
    }

    public MobileElement getBtnSettingPopUpLocation() {
        return btnSettingPopUpLocation;
    }

    /**
     * isHidAppSettingScreenDisplayed- This method is used to verify the settings screen is displayed or not
     *
     * @return- boolean Date-25/1/2023
     */
    public boolean isHidAppSettingScreenDisplayed() {
        return isElementVisible(txtSettings);
    }

    /**
     * clickOnSettingTabAndVerify- This method is used to click and verify the hid settings screen Date-25/1/2023
     */
    public void clickOnSettingTabAndVerify() {
        try {
            handlingSettingPopUp();
            click(tabSettings);
            Assert.assertTrue(isHidAppSettingScreenDisplayed());
            Assert.assertTrue(isElementVisible(txtDevice));
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while clicking on Settings Tab...");
        }
    }

    /**
     * selectModeStatus- This method is used to set the mode state according to parameter
     *
     * @param- mode- String Date-25/1/2023
     */
    public void selectModeStatus(String mode) {
        try {
            iOSScrollDownTillElement(chkUnlocked);
            if (getElementText(txtAlways).contains(mode)) {
                click(chkAlways);
                TestUtils.log().info("{} as {}",MessageConstants.MODE_SET_AS_STRING,mode);
                swipeUp(1);
            } else if (getElementText(txtForeground).contains(mode)) {
                click(chkForeground);
                TestUtils.log().info("{} as {}",MessageConstants.MODE_SET_AS_STRING,mode);
                swipeUp(1);
            } else if (getElementText(txtUnlocked).contains(mode)) {
                click(chkUnlocked);
                TestUtils.log().info("{} as {}",MessageConstants.MODE_SET_AS_STRING,mode);
                swipeUp(1);
            } else {
                TestUtils.log().info("Please select the correct mode value");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while selecting mode status...{}",e.getMessage());
        }
    }

    /**
     * setBluetoothStatus- This method is used to set the bluetooth state according to parameter
     *
     * @param- status- String Date-25/1/2023
     */
    public void setBluetoothStatus(String status) {
        try {
            if (getElementText(txtBluetoothPermissionStatus).contains(status)) {
                TestUtils.log().info("Bluetooth already set as {}",status);
            } else {
                click(imgBluetoothPermissionStatus);
                deviceSettingScreen.clickOnBluetoothSwitch();
                switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
                if (isDisplayed(txtPopUpAlertTitle)) {
                    click(btnSettingPopUpLocation);
                    switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
                }
                clickOnSettingTabAndVerify();
                Assert.assertTrue(getElementText(txtBluetoothPermissionStatus).contains(status));
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while setting Bluetooth status...");
        }
    }

    /**
     * setLocationPermissionStatus- This method is used to set the location permission state according to parameter
     *
     * @param- locationPermission- String Date-25/1/2023
     */
    public void setLocationPermissionStatus(String locationPermission) {
        try {
            if (getElementText(txtLocationPermission).contains(locationPermission)) {
                TestUtils.log().info("Location Permission already set as " + locationPermission);
            } else {
                click(txtLocationPermission);
                deviceSettingScreen.clickOnLocationPermissionsArrow();
                deviceLocationSettingScreen.setLocationPermission(locationPermission);
                switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
                Assert.assertTrue(getElementText(txtLocationPermission).contains(locationPermission));
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while setting Location Permission status...");
        }
    }

    /**
     * setIosAppState- This method is used to set the application state according to parameter
     *
     * @param- appState- String Date-25/1/2023
     */
    public void setIosAppState(String appState) {
        try {
            if (getAppState().equalsIgnoreCase(appState)) {
                TestUtils.log().info("Application is already running in {} state",appState);
            } else
                switch (appState) {
                    case "Background" -> {
                        switchToAnotherApp(ConfigLoader.getInstance().getiOSHomeBundleId());
                        TestUtils.log().info("{} to {}",MessageConstants.APPLICATION_STATE_CHANGE_STRING,appState);
                    }
                    case "Foreground" -> {
                        switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
                        TestUtils.log().info("{} to {}",MessageConstants.APPLICATION_STATE_CHANGE_STRING,appState);
                    }
                    case "Killed" -> {
                        DriverManager.getDriver().terminateApp(ConfigLoader.getInstance().getiOSBundleID());
                        TestUtils.log().info("{} to {}",MessageConstants.APPLICATION_STATE_CHANGE_STRING,appState);
                    }
                    case "AlwaysForeground" -> {
                        switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
                        TestUtils.log().info("{} to {}",MessageConstants.APPLICATION_STATE_CHANGE_STRING,appState);
                        clickOnSettingTabAndVerify();
                    }
                    default ->
                        TestUtils.log().info("Please select the correct application state ");

                }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while setting IOS app state...{}",e.getMessage());
        }
    }

    /**
     * handlingSettingPopUp- This method is used to handle the permission settings pop-up Date-25/1/2023
     */
    public void handlingSettingPopUp() {
        try {
            if (isDisplayed(txtPopUpAlertTitle)) {
                click(btnSettingPopUpLocation);
                switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
            } else
                TestUtils.log().info("Turn on location pop-up is not displayed");
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while handling Settings popup...");
        }
    }

    /**
     * clickModeStatusAndVerify- This method is used to click and verify the mode state  according to parameter
     *
     * @param- appState- String Date-25/1/2023
     */
    public void clickModeStatusAndVerify(String mode) {
        try {
            iOSScrollDownTillElement(chkUnlocked);
            if (getElementText(txtUnlocked).contains(mode)) {
                click(chkUnlocked);
                if (DriverManager.getPlatformVersion().contains("14")) {
                    TestUtils.log().info("{} as {}",MessageConstants.MODE_SET_AS_STRING,txtUnlocked);
                } else {
                    Assert.assertTrue(chkUnlocked.isSelected());
                    Assert.assertFalse(chkForeground.isSelected());
                    Assert.assertFalse(chkAlways.isSelected());
                }
            } else if (getElementText(txtForeground).contains(mode)) {
                click(chkForeground);
                if (DriverManager.getPlatformVersion().contains("14")) {
                    TestUtils.log().info("{} as {}",MessageConstants.MODE_SET_AS_STRING,txtForeground);
                } else {
                    Assert.assertTrue(chkForeground.isSelected());
                    Assert.assertFalse(chkUnlocked.isSelected());
                    Assert.assertFalse(chkAlways.isSelected());
                }
            } else if (getElementText(txtAlways).contains(mode)) {
                click(chkAlways);
                if (DriverManager.getPlatformVersion().contains("14")) {
                    TestUtils.log().info("{} as {}",MessageConstants.MODE_SET_AS_STRING,txtAlways);
                } else {
                    Assert.assertTrue(chkAlways.isSelected());
                    Assert.assertFalse(chkForeground.isSelected());
                    Assert.assertFalse(chkUnlocked.isSelected());
                }
            } else {
                TestUtils.log().info("Please select the correct Mode value");
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying mode status...");
        }
    }

    /**
     * verifyPlaySoundToggleButtonState- This method is used to verify the state of toggle switch for play and sound
     *
     * @param- switchState- String Date-25/1/2023
     */
    public void verifyPlaySoundToggleButtonState(String switchState) {
        try {
            iOSScrollDownTillElement(txtPlayAndSound);
            isElementVisible(txtPlayAndSound);
            switch (switchState) {
                case MessageConstants.ENABLE_STRING -> {
                    if (tglBtnPlayAndSound.getAttribute(MessageConstants.VALUE_STRING).equals("0")) {
                        TestUtils.log().info("Play Sound toggle button is initially in Disable state");
                    } else {
                        tapByElement(tglBtnPlayAndSound);
                        Assert.assertEquals(tglBtnPlayAndSound.getAttribute(MessageConstants.VALUE_STRING), "0");
                        TestUtils.log().info("Play Sound toggle button is set in Disable state");
                    }
                    tapByElement(tglBtnPlayAndSound);
                    Assert.assertEquals(tglBtnPlayAndSound.getAttribute(MessageConstants.VALUE_STRING), "1");
                    TestUtils.log().info("Play Sound toggle button is change in Enable state");
                }
                case MessageConstants.DISABLE_STRING -> {
                    if (tglBtnPlayAndSound.getAttribute(MessageConstants.VALUE_STRING).equals("1")) {
                        TestUtils.log().info("Play Sound toggle button is initially in Enable state");
                    } else {
                        tapByElement(tglBtnPlayAndSound);
                        Assert.assertEquals(tglBtnPlayAndSound.getAttribute(MessageConstants.VALUE_STRING), "1");
                        TestUtils.log().info("Play Sound toggle button is set in Enable state");
                    }
                    tapByElement(tglBtnPlayAndSound);
                    Assert.assertEquals(tglBtnPlayAndSound.getAttribute(MessageConstants.VALUE_STRING), "0");
                    TestUtils.log().info("Play Sound toggle button is change in Disable state");
                }
                default ->
                    TestUtils.log().info("Please select the correct switch value of play and sound");

            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying play and sound toggle button status...");
        }
    }

    /**
     * verifyTwistAndGoToggleButtonState- This method is used to verify the state of toggle switch for vibrate
     *
     * @param- vibrate- String Date-25/1/2023
     */
    public void verifyVibrateToggleButtonState(String vibrate) {
        try {
            iOSScrollDownTillElement(txtVibrate);
            isElementVisible(txtVibrate);
            switch (vibrate) {
                case MessageConstants.ENABLE_STRING -> {
                    if (tglBtnVibrate.getAttribute(MessageConstants.VALUE_STRING).equals("0")) {
                        TestUtils.log().info("Vibrate toggle button is initially in Disable state");
                    } else {
                        tapByElement(tglBtnVibrate);
                        Assert.assertEquals(tglBtnVibrate.getAttribute(MessageConstants.VALUE_STRING), "0");
                        TestUtils.log().info("Vibrate toggle button is set in Disable state");
                    }
                    tapByElement(tglBtnVibrate);
                    Assert.assertEquals(tglBtnVibrate.getAttribute(MessageConstants.VALUE_STRING), "1");
                    TestUtils.log().info("Vibrate toggle button is change in Enable state");
                }
                case MessageConstants.DISABLE_STRING -> {
                    if (tglBtnVibrate.getAttribute(MessageConstants.VALUE_STRING).equals("1")) {
                        TestUtils.log().info("Vibrate toggle button is initially in Enable state");
                    } else {
                        tapByElement(tglBtnVibrate);
                        Assert.assertEquals(tglBtnVibrate.getAttribute(MessageConstants.VALUE_STRING), "1");
                        TestUtils.log().info("Vibrate toggle button is set in Enable state");
                    }
                    tapByElement(tglBtnVibrate);
                    Assert.assertEquals(tglBtnVibrate.getAttribute(MessageConstants.VALUE_STRING), "0");
                    TestUtils.log().info("Vibrate toggle button is change in Disable state");
                }
                default ->
                    TestUtils.log().info("Please select the correct switch value of vibrate");

            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying Vibrate toggle button status...");
        }
    }

    /**
     * verifyTwistAndGoToggleButtonState- This method is used to verify the state of toggle switch for twist and go
     *
     * @param- twistAndGo- String Date-25/1/2023
     */
    public void verifyTwistAndGoToggleButtonState(String twistAndGo) {
        try {
            iOSScrollDownTillElement(txtTwistAndGo);
            isElementVisible(txtTwistAndGo);
            switch (twistAndGo) {
                case MessageConstants.ENABLE_STRING -> {
                    if (tglBtnTwistAndGo.getAttribute(MessageConstants.VALUE_STRING).equals("0")) {
                        TestUtils.log().info("Vibrate toggle button is initially in Disable state");
                    } else {
                        tapByElement(tglBtnTwistAndGo);
                        Assert.assertEquals(tglBtnTwistAndGo.getAttribute(MessageConstants.VALUE_STRING), "0");
                        TestUtils.log().info("Vibrate toggle button is set in Disable state");
                    }
                    tapByElement(tglBtnTwistAndGo);
                    Assert.assertEquals(tglBtnTwistAndGo.getAttribute(MessageConstants.VALUE_STRING), "1");
                    TestUtils.log().info("Vibrate toggle button is change in Enable state");
                }
                case MessageConstants.DISABLE_STRING -> {
                    if (tglBtnTwistAndGo.getAttribute(MessageConstants.VALUE_STRING).equals("1")) {
                        TestUtils.log().info("Vibrate toggle button is initially in Enable state");
                    } else {
                        tapByElement(tglBtnTwistAndGo);
                        Assert.assertEquals(tglBtnTwistAndGo.getAttribute(MessageConstants.VALUE_STRING), "1");
                        TestUtils.log().info("Vibrate toggle button is set in Enable state");
                    }
                    tapByElement(tglBtnTwistAndGo);
                    Assert.assertEquals(tglBtnTwistAndGo.getAttribute(MessageConstants.VALUE_STRING), "0");
                    TestUtils.log().info("Vibrate toggle button is change in Disable state");
                }
                default ->
                    TestUtils.log().info("Please select the correct switch value of twist and go");

            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying twist and go toggle button status...");
        }
    }

    /**
     * clickOnHelpCenterAndVerify- This method is used to click and verify the help center screen Date-25/1/2023
     */
    public void clickOnHelpCenterAndVerify() {
        try {
            iOSScrollDownTillElement(txtHelpCenter);
            isElementVisible(txtHelpCenter);
            click(imgHelpCenter);
            helpCenterSettingScreen.isHelpCenterScreenDisplayed();
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying help center screen...");
        }
    }
}
