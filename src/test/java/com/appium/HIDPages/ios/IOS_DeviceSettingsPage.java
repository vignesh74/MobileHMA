package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOS_DeviceSettingsPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Device Settings Page Date-25/1/2023
     */
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Allow Mobile Access To Access\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ALLOW MOBILE ACCESS TO ACCESS\"]", priority = 1)
    private MobileElement txtMobileAccessScreen;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Location']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Location')])[1]", priority = 1)
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Location')])[2]", priority = 2)
    private MobileElement imgLocationDeviceSetting;

    @iOSXCUITFindBy(xpath = "//*[@name='Settings']")
    private MobileElement imgDeviceSetting;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Bluetooth\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Bluetooth\"]/XCUIElementTypeSwitch", priority = 1)
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Bluetooth')])[2]", priority = 2)
    private MobileElement tglBtnBluetoothDeviceSetting;

    @iOSXCUITFindBy(xpath = "//*[@name='Background App Refresh']//following-sibling:: XCUIElementTypeSwitch")
    private MobileElement tglBtnBackgroundRefresh;

    @iOSXCUITFindBy(xpath = "//*[@name='Mobile Data']//following-sibling:: XCUIElementTypeSwitch")
    private MobileElement tglBtnMobileDataSetting;

    @iOSXCUITFindBy(accessibility = "Privacy")
    private MobileElement txtPrivacySecuritySetting;

    @iOSXCUITFindBy(xpath = "//*[@name='Privacy']//following-sibling:: XCUIElementTypeButton")
    private MobileElement imgPrivacySecuritySetting;

    @iOSXCUITFindBy(xpath = "//*[@name='Location Services']//following-sibling:: XCUIElementTypeButton")
    private MobileElement imgLocationServicesSetting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Location Services\"]")
    private MobileElement tglBtnLocationServicesSetting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"LOCATION\"]")
    private MobileElement txtLocationServicesSetting;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"LOCATION\"]")
    private MobileElement tglBtnLocationServicesSettingSwitch;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getTxtMobileAccessScreen() {
        return txtMobileAccessScreen;
    }

    public MobileElement getImgLocationDeviceSetting() {
        return imgLocationDeviceSetting;
    }

    public MobileElement getImgDeviceSetting() {
        return imgDeviceSetting;
    }

    public MobileElement getTglBtnBluetoothDeviceSetting() {
        return tglBtnBluetoothDeviceSetting;
    }

    public MobileElement getTglBtnBackgroundRefresh() {
        return tglBtnBackgroundRefresh;
    }

    public MobileElement getTglBtnMobileDataSetting() {
        return tglBtnMobileDataSetting;
    }

    public MobileElement getTxtPrivacySecuritySetting() {
        return txtPrivacySecuritySetting;
    }

    public MobileElement getImgPrivacySecuritySetting() {
        return imgPrivacySecuritySetting;
    }

    public MobileElement getImgLocationServicesSetting() {
        return imgLocationServicesSetting;
    }

    public MobileElement getTglBtnLocationServicesSettingSwitch() {
        return tglBtnLocationServicesSettingSwitch;
    }

    public MobileElement getTxtLocationServicesSetting() {
        return txtLocationServicesSetting;
    }

    public MobileElement getTglBtnLocationServicesSetting() {
        return tglBtnLocationServicesSettingSwitch;
    }

    /**
     * clickOnBluetoothSwitch- This method is used to click on bluetooth switch Date-25/1/2023
     */

    public void clickOnBluetoothSwitch() {
        try {
            waitForGivenTime(2);
            waitForVisibility(txtMobileAccessScreen);
            tglBtnBluetoothDeviceSetting.click();
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking on Bluetooth button...");
        }
    }

    /**
     * clickOnLocationPermissionsArrow- This method is used to click on location permissions arrow Date-25/1/2023
     */

    public void clickOnLocationPermissionsArrow() {
        try {
            waitForGivenTime(2);
            waitForVisibility(txtMobileAccessScreen);
            click(imgLocationDeviceSetting);
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking Location Permission arrow...");
        }
    }

}

