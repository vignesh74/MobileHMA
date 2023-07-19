package com.appium.HIDPages.android;

import com.appium.base.BasePage;

import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.NAVIGATE_BACK;

public class Andr_DeviceBLESettingsPage extends BasePage {
    /**
     * object created to access methods from page classes Date- 25/01/2023
     */

    Andr_HIDAppPreferencesScreenPage appPrefencesScreenPage = new Andr_HIDAppPreferencesScreenPage();
    /**
     * mobile elements - These are mobile elements which is present in device BLE settings page Date-25/01/2023
     */
    @AndroidFindBy(id = "com.android.settings:id/switch_text")
    private MobileElement txtSwitchOnOff;
    @AndroidFindBy(id = "com.android.settings:id/switch_widget")
    private MobileElement btnOnOff;

    @AndroidFindBy(xpath = "//*[@text='Connection preferences']")
    private MobileElement txtConnectionRef;

    @AndroidFindBy(id = "android:id/checkbox")
    private MobileElement tglBtnBLE;

    /**
     * These mobile elements are used for validating BLE Warning Banners
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth Disabled']")
    private MobileElement bleDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Bluetooth to find readers nearby and use your Mobile ID over Bluetooth.']")
    private MobileElement bleDisabledText;

    @AndroidFindBy(id="android:id/message")
    private MobileElement message;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Deny']")
    private MobileElement permDeny;
    @AndroidFindBy(id = "//android.widget.Button[@text='Allow']")
    private MobileElement allow;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private MobileElement permMsg;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement permAllow;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement permDontAllow;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getTglBtnBLE() {
        return tglBtnBLE;
    }

    public MobileElement getTxtSwitchOnOff() {
        return txtSwitchOnOff;
    }

    public MobileElement getBtnOnOff() {
        return btnOnOff;
    }

    public MobileElement getTxtConnectionRef() {
        return txtConnectionRef;
    }

    /**
     * setBLEStatus- This method is used to set BLE status
     *
     * @param -strBLEStatus-String
     *         Date-25/01/2023
     */
    public void setBLEStatus(String strBLEStatus) {
        try {
            String strBLEStatusValue = getElementText(appPrefencesScreenPage.getTxtBluetoothStatusValue());
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (!strBLEStatus.equalsIgnoreCase(strBLEStatusValue)) {
                appPrefencesScreenPage.clickOnBLETab();
                if (isDisplayed(txtConnectionRef)) {
                    txtConnectionRef.click();
                    waitForVisibility(appPrefencesScreenPage.getTxtBluetooth());
                    appPrefencesScreenPage.clickOnBLETab();
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    String strActualBLEStatus = getElementText(txtSwitchOnOff);
                    TestUtils.log().info("BLE has been set as {}",strActualBLEStatus);
                    loopHandle(appPrefencesScreenPage.getTxtBluetoothStatusValue(), NAVIGATE_BACK, 10);
                    Assert.assertTrue(strActualBLEStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtBluetoothStatusValue().getText()));
                } else {
                    switch (strPlatformVersion) {
                        case "9","00" -> {
                            click(tglBtnBLE);
                            String strAttr = getElementAttribute(tglBtnBLE, "Checked");
                            if (strAttr.equalsIgnoreCase("false")) {
                                TestUtils.log().info("BLE Status set as {}",strBLEStatus);
                            }
                            loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), NAVIGATE_BACK, 10);
                        }
                        default -> {
                            click(btnOnOff);
                            String strActualBLEStatus = getElementText(txtSwitchOnOff);
                            TestUtils.log().info("BLE has been set as {}",strActualBLEStatus);
                            Assert.assertTrue(strBLEStatus.equalsIgnoreCase(strActualBLEStatus));
                            loopHandle(appPrefencesScreenPage.getTxtBluetoothStatusValue(), NAVIGATE_BACK, 10);
                            Assert.assertTrue(strActualBLEStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtBluetoothStatusValue().getText()));
                        }
                    }
                }
            } else {
                TestUtils.log().info("BLE  is  already set as {}",strBLEStatus);
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while setting the BLE status...");
        }
    }
    public void setBLEStatusWb(String strBLEStatus) {
        try {
            String strBLEStatusValue = getElementText(appPrefencesScreenPage.getTxtBluetoothStatusValue());
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strBLEStatus.equalsIgnoreCase(strBLEStatusValue)) {
               click(bleDisabled);
               waitForGivenTime(2);
                if(isDisplayed(message))
                {
                    Assert.assertTrue(true, "The message is visible...");
                    if (strBLEStatusValue.equals("On"))
                    {
                        click(allow);
                    }
                    else
                    {
                        click(permDeny);
                    }
                }
              else if(isDisplayed(permMsg))
                {
                    Assert.assertTrue(true, "The message is visible...");
                    if (strBLEStatusValue.equals("On"))
                    {
                        click(permAllow);
                    }
                    else
                    {
                        click(permDontAllow);
                    }
                }
              else if (isDisplayed(txtConnectionRef)) {
                    txtConnectionRef.click();
                    waitForVisibility(appPrefencesScreenPage.getTxtBluetooth());
                    appPrefencesScreenPage.clickOnBLETab();
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    String strActualBLEStatus = getElementText(txtSwitchOnOff);
                    TestUtils.log().info("BLE has been set as {}",strActualBLEStatus);
                    loopHandle(appPrefencesScreenPage.getTxtBluetoothStatusValue(), NAVIGATE_BACK, 10);
                    Assert.assertTrue(strActualBLEStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtBluetoothStatusValue().getText()));
                }
              else
                {
                    switch (strPlatformVersion) {
                        case "9","00" -> {
                            click(tglBtnBLE);
                            String strAttr = getElementAttribute(tglBtnBLE, "Checked");
                            if (strAttr.equalsIgnoreCase("false")) {
                                TestUtils.log().info("BLE Status set as {}",strBLEStatus);
                            }
                            loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), NAVIGATE_BACK, 10);
                        }
                        default -> {
                            click(btnOnOff);
                            String strActualBLEStatus = getElementText(txtSwitchOnOff);
                            TestUtils.log().info("BLE has been set as {}",strActualBLEStatus);
                            Assert.assertTrue(strBLEStatus.equalsIgnoreCase(strActualBLEStatus));
                            loopHandle(appPrefencesScreenPage.getTxtBluetoothStatusValue(), NAVIGATE_BACK, 10);
                            Assert.assertTrue(strActualBLEStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtBluetoothStatusValue().getText()));
                        }
                    }
                }
            }
            else
            {
                TestUtils.log().info("BLE  is  already set as {}",strBLEStatus);
            }
        }
        catch (Exception e) {
            TestUtils.log().info("Exception occurred while setting the BLE status...");
        }
    }
}

