package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOS_DeviceLocationSettingsPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Device Location Settings Page Date-25/1/2023
     */

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Location\"]")
    private MobileElement txtLocationScreen;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Never\"]")
    private MobileElement txtLocationNever;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Ask Next Time Or When I Share\"]")
    private MobileElement txtLocationAskNextTime;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"While Using the App\"]", priority = 0)
    @iOSXCUITFindBy(accessibility = "While Using the App", priority = 1)

    private MobileElement txtLocationWhileUsingApp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Always\"]")
    private MobileElement txtLocationAlways;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Mobile Access']")
    private MobileElement btnMobileAccessBack;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */
    public MobileElement getTxtLocationScreen() {
        return txtLocationScreen;
    }

    public MobileElement getTxtLocationNever() {
        return txtLocationNever;
    }

    public MobileElement getTxtLocationAskNextTime() {
        return txtLocationAskNextTime;
    }

    public MobileElement getTxtLocationWhileUsingApp() {
        return txtLocationWhileUsingApp;
    }

    public MobileElement getTxtLocationAlways() {
        return txtLocationAlways;
    }

    public MobileElement getBtnMobileAccessBack() {
        return btnMobileAccessBack;
    }

    /**
     * setLocationPermission- This method is used to select the location permission type
     *
     * @param- locationType- String Date-25/1/2023
     */
    public void setLocationPermission(String locationType) {
        try {
            waitForVisibility(txtLocationScreen);
            switch (locationType) {
                case "Always" ->
                    click(txtLocationAlways);

                case "While using the app" ->
                    click(txtLocationWhileUsingApp);

                case "Ask Next Time Or When I Share" ->
                    click(txtLocationAskNextTime);

                case "Never" ->
                    click(txtLocationNever);

                default ->
                    TestUtils.log().info("Please provide correct location permission");

            }
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while setting Location Permission...");
        }
    }
}
