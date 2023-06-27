package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

public class Andr_DeviceLocationSettingsPage extends BasePage {
    /**
     * object created to access methods from page classes Date- 25/01/2023
     */
    Andr_HIDAppPreferencesScreenPage appPreferencesScreenPage = new Andr_HIDAppPreferencesScreenPage();
    AndroidDeviceAction androidDeviceAction = new AndroidDeviceAction();

    /**
     * mobile elements - These are mobile elements which is present in device BLE settings page Date-25/01/2023
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_widget", priority = 0)
    private MobileElement btnLocationOnOff;

    @AndroidFindBy(id = "com.android.settings:id/switch_text")
    private MobileElement txtLocationOnOff;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getBtnLocationOnOff() {
        return btnLocationOnOff;
    }

    public MobileElement getTxtLocationOnOff() {
        return txtLocationOnOff;
    }

    /**
     * setLocationStatus- This method is used to set Location status
     *
     * @param -strLocationStatus-String
     * @param -strUDID-String           Date-25/01/2023
     */
    public void setLocationStatus(String strLocationStatus, String strUDID) {
        try {
            if (appPreferencesScreenPage.isDisplayed(appPreferencesScreenPage.getTxtLocation())) {
                if (getElementText(appPreferencesScreenPage.getTxtLocationStatusValue()).equalsIgnoreCase(strLocationStatus)) {
                    TestUtils.log().info("Location status is already set as {}",strLocationStatus);
                } else {
                    click(appPreferencesScreenPage.getTxtLocation());
                    waitForGivenTime(1);
                    click(btnLocationOnOff);
                    String strCheckedAttrValue = getElementAttribute(btnLocationOnOff, "checked");
                    if (strCheckedAttrValue.equalsIgnoreCase("true")) {
                        TestUtils.log().info("Location status is set as on");
                    } else if (strCheckedAttrValue.equalsIgnoreCase("false")) {
                        TestUtils.log().info("Location status is set as off");
                    }
                    loopHandle(appPreferencesScreenPage.getTxtLocationStatusValue(), "navigateBack", 10);
                    Assert.assertTrue(strLocationStatus.equalsIgnoreCase(appPreferencesScreenPage.getTxtLocationStatusValue().getText()));
                }
            } else {
                if (strLocationStatus.equalsIgnoreCase("On")) {
                    androidDeviceAction.turnOnGpsLocation(strUDID);
                    TestUtils.log().info("Location is set as On");
                } else if (strLocationStatus.equalsIgnoreCase("Off")) {
                    androidDeviceAction.turnOffGpsLocation(strUDID);
                    TestUtils.log().info("Location is set as Off");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while setting the Location status...");
        }
    }

    /**
     * setLocationStatusForSettingFeature-This method is used to set location status for the setting features
     *
     * @param strLocationStatus - String
     * @param strUDID           - String
     *                          Date-22/02/2023
     */
    public void setLocationStatusForSettingFeature(String strLocationStatus, String strUDID) {
        String strDevicePlatformVersion = DriverManager.getPlatformVersion();
        try {
            switch (strDevicePlatformVersion) {
                case "12" -> {
                    TestUtils.log().info("Location is not required for this version");
                }
                default -> {
                    if (appPreferencesScreenPage.isDisplayed(appPreferencesScreenPage.getTxtLocation())) {
                        if (getElementText(appPreferencesScreenPage.getTxtLocationStatusValue()).equalsIgnoreCase(strLocationStatus)) {
                            TestUtils.log().info("Location status is already set as {}",strLocationStatus);
                        } else {
                            click(appPreferencesScreenPage.getTxtLocation());
                            waitForGivenTime(1);
                            click(btnLocationOnOff);
                            String strCheckedAttrValue = getElementAttribute(btnLocationOnOff, "checked");
                            if (strCheckedAttrValue.equalsIgnoreCase("true")) {
                                TestUtils.log().info("Location status is set as on");
                            } else if (strCheckedAttrValue.equalsIgnoreCase("false")) {
                                TestUtils.log().info("Location status is set as off");
                            }
                            loopHandle(appPreferencesScreenPage.getTxtLocationStatusValue(), "navigateBack", 10);
                            Assert.assertTrue(strLocationStatus.equalsIgnoreCase(appPreferencesScreenPage.getTxtLocationStatusValue().getText()));
                        }
                    }
                    TestUtils.log().info("Location status is successfully set");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while setting the Location status for setting feature...");
        }
    }
}
