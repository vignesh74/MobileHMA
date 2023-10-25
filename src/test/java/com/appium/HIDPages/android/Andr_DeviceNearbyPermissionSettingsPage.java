package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.*;

public class Andr_DeviceNearbyPermissionSettingsPage extends BasePage {
    /**
     * object created to access methods from page classes Date- 25/1/2023
     */
    Andr_HIDAppPreferencesScreenPage appPrefencesScreenPage = new Andr_HIDAppPreferencesScreenPage();
    Andr_HIDMobileIDScreenPage mobileIDScreenPage=new Andr_HIDMobileIDScreenPage();
    Andr_HIDSettingsScreenPage settingsScreenPage=new Andr_HIDSettingsScreenPage();
    /**
     * mobile elements - These are mobile elements which is present in device nearby permission settings page Date-25/01/2023
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Permissions']")
    private MobileElement txtPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']")
    private MobileElement txtLocation;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text='Nearby devices']", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']", priority = 1)
    private MobileElement txtNearByDevices;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/allow_radio_button")
    private MobileElement rdoAllow;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/deny_radio_button")
    private MobileElement rdoDonotAllow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App Preferences']")
    private MobileElement txtAppPreferences;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/allow_always_radio_button", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"Allow all the time\"]", priority = 1)
    private MobileElement rdoAllowAllTheTime;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.permissioncontroller:id/allow_foreground_only_radio_button", priority = 0)
    @AndroidFindBy(id = "com.android.permissioncontroller:id/foreground_only_radio_button", priority = 1)
    private MobileElement rdoAllowOnlyWhileUsingApp;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/ask_radio_button")
    private MobileElement rdoAskEveryTime;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/deny_radio_button")
    private MobileElement rdoDeny;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby Permission']/following-sibling::android.widget.TextView")
    private MobileElement txtNearbyPermissionStatusValue;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App permissions']", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Permissions']", priority = 1)
    private MobileElement btnAppPermission;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Locat')]/parent::android.widget.RelativeLayout/following-sibling::android.widget.LinearLayout/child::*", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']", priority = 1)
    private MobileElement tglBtnLocationPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Permission']/following-sibling::*[1]")
    private MobileElement txtLocationPermission;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location']")
    private MobileElement locTab;
    /**
     *  These mobile elements are used to validate warning banners Date-02-07-2023
     */

    @AndroidFindBy(id ="com.android.permissioncontroller:id/permission_message")
    private MobileElement popupPermissionMsg;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement allow_foreground_only;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
    private MobileElement allow_While_using_the_app;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private MobileElement allow_one_time;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement permission_deny;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Don’t allow']")
    private MobileElement permission_deny1;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_message")
    private MobileElement permMsg;
    
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement permAllow;
    
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement permDeny;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby permission Disabled']")
    private MobileElement nearByPermissionDisabled;

    @AndroidFindBy(id = "android:id/message")
    private MobileElement msg;

    @AndroidFindBy(id = "//android.widget.Button[@text='Deny']")
    private MobileElement deny;

    @AndroidFindBy(id = "//android.widget.Button[@text='Allow']")
    private MobileElement allow;
    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/1/2023
     */
    public MobileElement getTxtPermission() {
        return txtPermission;
    }

    public MobileElement getTxtNearByDevices() {
        return txtNearByDevices;
    }

    public MobileElement getAllowRadioButton() {
        return rdoAllow;
    }

    public MobileElement getRdoDonotAllow() {
        return rdoDonotAllow;
    }

    public MobileElement getTxtAppPreferences() {
        return txtAppPreferences;
    }

    public MobileElement getRdoAllowAllTheTime() {
        return rdoAllowAllTheTime;
    }

    public MobileElement getRdoAllowOnlyWhileUsingApp() {
        return rdoAllowOnlyWhileUsingApp;
    }

    public MobileElement getRdoAskEveryTime() {
        return rdoAskEveryTime;
    }

    public MobileElement getRdoDeny() {
        return rdoDeny;
    }

    public MobileElement getTxtNearbyPermissionStatusValue() {
        return txtNearbyPermissionStatusValue;
    }

    public MobileElement getBtnAppPermission() {
        return btnAppPermission;
    }

    public MobileElement getTglBtnLocationPermission() {
        return tglBtnLocationPermission;
    }

    public MobileElement getTxtLocation() {
        return txtLocation;
    }

    public MobileElement getRdoAllow() {
        return rdoAllow;
    }

    public MobileElement getTxtLocationPermission() {
        return txtLocationPermission;
    }

    /**
     * clickOnPermissionTab- This method is used to clicked on the permission tab Date-25/01/2023
     */
    public void clickOnPermissionTab() {
        try {
            if (isDisplayed(txtPermission)) {
                click(txtPermission);
            } else {
                loopHandle(txtPermission, "swipeDown", 5);
                click(txtPermission);
            }
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }

    /**
     * clickOnNearByDevices- This method is used to clicked on the nearby devices Date-25/01/2023
     */
    public void clickOnNearByDevices() {
        try {
            click(txtNearByDevices);
            TestUtils.log().info("Successfully click to near by devices button");
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }

    public void clickOnLocationTab(){
        try {
            click(locTab);
            TestUtils.log().info("Successfully click to location button");
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }

    /**
     * setLocationPermissionAsAllow- This method is used to set location permission as allow for android version 11 Date-03/02/2023
     */
    public void setLocationPermissionAsAllow() {
        try {
            clickOnPermissionTab();
            clickOnNearByDevices();
            if (isDisplayed(rdoAllowAllTheTime)) {
                selectRadioButton(rdoAllowAllTheTime);
                TestUtils.log().info(LOCATION_PERMISSION_MESSAGE+" Allow");
            } else {
                TestUtils.log().info("unable to set location permission as  Allow");
            }
            loopHandle(txtAppPreferences, NAVIGATE_BACK, 15);
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }

    public boolean handlePermissionMsg(){
       try {
           if (isDisplayed(popupPermissionMsg))
           {

               TestUtils.log().info("Popup is handled");
               click(allow_foreground_only);
           }
           else {
               clickOnPermissionTab();
           }


       }
       catch (Exception e) {
           throw new RuntimeException(e);
       }
       return true;
    }


    /**
     * setLocationPermission- This method is used to set location permission
     *
     * @param strLocationPermission
     *         Date-22/02/2023
     */
    public void setLocationPermission(String strLocationPermission) {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("9")) {
                if (isDisplayed(btnAppPermission)) {
                    click(btnAppPermission);
                }
                waitForVisibility(tglBtnLocationPermission);
                click(tglBtnLocationPermission);
                String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                    TestUtils.log().info("{} as {}",LOCATION_PERMISSION_MESSAGE,strLocationPermission);
                }
                loopHandle(txtAppPreferences, NAVIGATE_BACK, 5);
            }
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());}
    }

    /**
     * setNearByOrLocationPermission-This method is used to set nearBy and location permission for all version
     *
     * @param strLocationOrNearBy
     *         -String
     * @param strLocOrNearByPerm-
     *         String
     */
    public void setNearByOrLocationPerm(String strLocationOrNearBy, String strLocOrNearByPerm) {
        try {
            String strDevicePlatformVersion = DriverManager.getPlatformVersion();
            String txtLocationPermStatusValue = getElementText(appPrefencesScreenPage.getTxtLocationPermStatusValue());

            switch (strDevicePlatformVersion) {
                case "9" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {
                        appPrefencesScreenPage.clickOnLocationPermission();
                        waitForGivenTime(1);
                        if (isDisplayed(btnAppPermission)) {
                            click(btnAppPermission);
                        } else {
                            swipeDown(1);
                            waitForGivenTime(1);
                            if (isDisplayed(btnAppPermission)) {
                                click(btnAppPermission);
                            }
                        }
                    } else
                        TestUtils.log().info("Location Permission is already set as {}",strLocOrNearByPerm);

                    waitForVisibility(tglBtnLocationPermission);
                    click(tglBtnLocationPermission);
                    String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                    if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                        TestUtils.log().info("Location Permission set as :: {}",strLocOrNearByPerm);
                    }
                }
                case "7", "8" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {

                        appPrefencesScreenPage.clickOnLocationPermission();
                        loopHandle(txtPermission, "swipeDown", 5);
                        if (isDisplayed(btnAppPermission)) {
                            click(btnAppPermission);
                        }
                        click(tglBtnLocationPermission);
                        String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                        if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                            TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                        }
                    } else
                        TestUtils.log().info("Location Permission is already set as {}",strLocOrNearByPerm);

                }

                case "10", "11" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {
                        appPrefencesScreenPage.clickOnLocationPermission();
                        clickOnPermissionTab();
                        clickOnLocationTab();
                        switch (strLocationOrNearBy) {
                            case "Location" -> {
                                if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow") || strLocOrNearByPerm.equalsIgnoreCase("Deny")) {
                                    selectRadioButton(rdoDeny);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow all the time")) {
                                    selectRadioButton(rdoAllowAllTheTime);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow only while using app") || strLocOrNearByPerm.equalsIgnoreCase("Allow only while using the app")) {
                                    selectRadioButton(rdoAllowOnlyWhileUsingApp);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Ask every time")) {
                                    selectRadioButton(rdoAskEveryTime);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else
                                    TestUtils.log().info("Please provide correct permission option.");

                            }
                        }
                    }
                }
                case "12","13" -> {
                    appPrefencesScreenPage.clickOnLocationPermission();
                    clickOnPermissionTab();
                    clickOnNearByDevices();
                    switch (strLocationOrNearBy) {
                        case "Location" -> {
                            if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow") || strLocOrNearByPerm.equalsIgnoreCase("Deny")) {
                                selectRadioButton(rdoDeny);
                                TestUtils.log().info("Location Permission set as :: {}",strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow all the time")) {
                                selectRadioButton(rdoAllowAllTheTime);
                                TestUtils.log().info("Location Permission set as :: {}",strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow only while using app")||strLocOrNearByPerm.equalsIgnoreCase("Allow only while using the app")) {
                                selectRadioButton(rdoAllowOnlyWhileUsingApp);
                                TestUtils.log().info("Location Permission set as :: {}",strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Ask every time")) {
                                selectRadioButton(rdoAskEveryTime);
                                TestUtils.log().info("Location Permission set as :: {}",strLocOrNearByPerm);
                            } else
                                TestUtils.log().info("Please provide correct permission option");

                        }
                        case "NearBy" -> {
                            if (strLocOrNearByPerm.equalsIgnoreCase("Allow")) {
                                selectRadioButton(rdoAllow);
                                TestUtils.log().info("NearBy Devices Permission set as {}",strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow")) {
                                selectRadioButton(rdoDeny);
                                TestUtils.log().info("Location Permission set as :: {}",strLocOrNearByPerm);
                            } else
                                TestUtils.log().info("Please provide correct permission option.");

                        }
                        default ->
                                TestUtils.log().info("Please provide correct permission option for execution");

                    }
                }

                default -> {
                    appPrefencesScreenPage.getTxtNearByPermissionStatusValue().click();
                    clickOnPermissionTab();
                    clickOnNearByDevices();
                            if (strLocOrNearByPerm.equalsIgnoreCase("Allow")) {
                                selectRadioButton(rdoAllow);
                                TestUtils.log().info("NearBy Devices Permission set as {}", strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow")) {
                                selectRadioButton(rdoDeny);
                                TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                            } else
                                TestUtils.log().info("Please provide correct permission option");
                    }
                }
            loopHandle(txtAppPreferences, NAVIGATE_BACK, 10);
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }

    public void setNearByOrLocationPermWb(String strLocationOrNearBy, String strLocOrNearByPerm) {

        try {
            String strDevicePlatformVersion = DriverManager.getPlatformVersion();
            String txtLocationPermStatusValue = getElementText(appPrefencesScreenPage.getTxtLocationPermStatusValue());
            String txtNearByPermStatusValue=getElementText(appPrefencesScreenPage.getTxtNearByPermissionStatusValue());
            switch (strDevicePlatformVersion) {
                case "9" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {
                        appPrefencesScreenPage.clickOnLocationPermission();
                        waitForGivenTime(1);
                        if (isDisplayed(btnAppPermission)) {
                            click(btnAppPermission);
                        } else {
                            swipeDown(1);
                            waitForGivenTime(1);
                            if (isDisplayed(btnAppPermission)) {
                                click(btnAppPermission);
                            }
                        }
                    } else
                        TestUtils.log().info("Location Permission is already set as {}", strLocOrNearByPerm);

                    waitForVisibility(tglBtnLocationPermission);
                    click(tglBtnLocationPermission);
                    String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                    if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                        TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                    }
                }
                case "7", "8" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {

                        appPrefencesScreenPage.clickOnLocationPermission();
                        loopHandle(txtPermission, "swipeDown", 5);
                        if (isDisplayed(btnAppPermission)) {
                            click(btnAppPermission);
                        }
                        click(tglBtnLocationPermission);
                        String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                        if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                            TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                        }
                    } else
                        TestUtils.log().info("Location Permission is already set as {}", strLocOrNearByPerm);

                }
                default -> {
                    /**THESE METHODS WILL BE USED WITH ANDROID 10 & 11 WHICH WILL BE TAKEN UP LATER */
                    // appPreferencesScreenPage.clickOnLocationPermission();
                    //waitForGivenTime(2);
                    // handlePermissionMsg();
                    //clickOnPermissionTab();
                    //click(locTab);


                        if (isDisplayed(nearByPermissionDisabled)) {
                            Assert.assertTrue(true, "The Nearby Permission Warning Banner is visible...");
                            TestUtils.log().debug(" The Nearby Permission Warning Banner is visible...");
                            click(nearByPermissionDisabled);
                            if (isDisplayed(permMsg)) {
                                Assert.assertTrue(true, "The permission message is visible...");
                                TestUtils.log().debug(" The permission message is visible...");
                                if (strLocationOrNearBy.equals("Allow")) {
                                    click(permAllow);
                                } else {
                                    click(permDeny);
                                }
                            } else if (isDisplayed(msg)) {
                                Assert.assertTrue(true, "The  message popup is visible...");
                                TestUtils.log().debug(" The  message popup is visible...");
                                if (strLocationOrNearBy.equals("Allow")) {
                                    click(allow);
                                } else {
                                    click(deny);
                                }
                            }

                        } else {
                            Assert.assertTrue(true, "The Nearby Permission Warning Banner is not visible for this Scenario...");
                            TestUtils.log().debug(" The Nearby Permission Warning Banner is not visible for this Scenario...");
                            appPrefencesScreenPage.clickOnNearByPermission();
                        }

                        clickOnPermissionTab();
                        clickOnNearByDevices();
                        switch (strLocationOrNearBy) {
                            case "Location" -> {
                                if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow") || strLocOrNearByPerm.equalsIgnoreCase("Deny")) {
                                    selectRadioButton(rdoDeny);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow all the time")) {
                                    selectRadioButton(rdoAllowAllTheTime);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow only while using app")) {
                                    selectRadioButton(rdoAllowOnlyWhileUsingApp);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Ask every time")) {
                                    selectRadioButton(rdoAskEveryTime);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else
                                    TestUtils.log().info("Please provide correct permission option");

                            }
                            case "NearBy" -> {
                                if (strLocOrNearByPerm.equalsIgnoreCase("Allow")) {
                                    selectRadioButton(rdoAllow);
                                    TestUtils.log().info("NearBy Devices Permission set as {}", strLocOrNearByPerm);
                                } else if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow")) {
                                    selectRadioButton(rdoDeny);
                                    TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                                } else
                                    TestUtils.log().info("Please provide correct permission option");

                            }
                            default -> TestUtils.log().info("Please provide correct permission option for execution");
                        }

                }
            }
            loopHandle(txtAppPreferences, NAVIGATE_BACK, 10);
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }

    public void setNearByOrLocationPermWbWf3(String strLocationOrNearBy, String strLocOrNearByPerm) {

        try {
            String strDevicePlatformVersion = DriverManager.getPlatformVersion();
            String txtLocationPermStatusValue = getElementText(appPrefencesScreenPage.getTxtLocationPermStatusValue());
            String txtNearByPermStatusValue=getElementText(appPrefencesScreenPage.getTxtNearByPermissionStatusValue());
            switch (strDevicePlatformVersion) {
                case "9" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {
                        appPrefencesScreenPage.clickOnLocationPermission();
                        waitForGivenTime(1);
                        if (isDisplayed(btnAppPermission)) {
                            click(btnAppPermission);
                        } else {
                            swipeDown(1);
                            waitForGivenTime(1);
                            if (isDisplayed(btnAppPermission)) {
                                click(btnAppPermission);
                            }
                        }
                    } else
                        TestUtils.log().info("Location Permission is already set as {}", strLocOrNearByPerm);

                    waitForVisibility(tglBtnLocationPermission);
                    click(tglBtnLocationPermission);
                    String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                    if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                        TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                    }
                }
                case "7", "8" -> {
                    if (!strLocOrNearByPerm.equalsIgnoreCase(txtLocationPermStatusValue)) {

                        appPrefencesScreenPage.clickOnLocationPermission();
                        loopHandle(txtPermission, "swipeDown", 5);
                        if (isDisplayed(btnAppPermission)) {
                            click(btnAppPermission);
                        }
                        click(tglBtnLocationPermission);
                        String strCheckedValue = getElementAttribute(tglBtnLocationPermission, CHECKED_MESSAGE);
                        if (strCheckedValue.equalsIgnoreCase(FALSE_MESSAGE)) {
                            TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                        }
                    } else
                        TestUtils.log().info("Location Permission is already set as {}", strLocOrNearByPerm);

                }
                default -> {
                    /**THESE METHODS WILL BE USED WITH ANDROID 10 & 11 WHICH WILL BE TAKEN UP LATER */
                    appPrefencesScreenPage.clickOnLocationPermission();
                    waitForGivenTime(2);
                     handlePermissionMsg();
                    clickOnPermissionTab();
                    click(locTab);

                    loopHandle(mobileIDScreenPage.getTxtMobileIdsTab(), "navigateBack", 10);
                    if (isDisplayed(nearByPermissionDisabled)) {
                        Assert.assertTrue(true, "The Nearby Permission Warning Banner is visible...");
                        TestUtils.log().debug(" The Nearby Permission Warning Banner is visible...");
                        click(nearByPermissionDisabled);
                        if (isDisplayed(permMsg))
                        {
                            Assert.assertTrue(true, "The permission message is visible...");
                            TestUtils.log().debug(" The permission message is visible...");
                            if (strLocationOrNearBy.equals("Allow")) {
                                click(permAllow);
                            } else {
                                click(permDeny);
                            }
                        }
                        else if (isDisplayed(msg))
                        {
                            Assert.assertTrue(true, "The  message popup is visible...");
                            TestUtils.log().debug(" The  message popup is visible...");
                            if (strLocationOrNearBy.equals("Allow")) {
                                click(allow);
                            } else {
                                click(deny);
                            }
                        }
                        settingsScreenPage.traverseToSettingsPage();
                        settingsScreenPage.clickOnAppPreferences();
                    }
                    else
                    {
                        Assert.assertTrue(true, "The Nearby Permission Warning Banner is not visible for this Scenario...");
                        TestUtils.log().debug(" The Nearby Permission Warning Banner is not visible for this Scenario...");
                        settingsScreenPage.traverseToSettingsPage();
                        settingsScreenPage.clickOnAppPreferences();
                        appPrefencesScreenPage.clickOnNearByPermission();
                    }

                    clickOnPermissionTab();
                    clickOnNearByDevices();
                    switch (strLocationOrNearBy) {
                        case "Location" -> {
                            if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow") || strLocOrNearByPerm.equalsIgnoreCase("Deny")) {
                                selectRadioButton(rdoDeny);
                                TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow all the time")) {
                                selectRadioButton(rdoAllowAllTheTime);
                                TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Allow only while using app")) {
                                selectRadioButton(rdoAllowOnlyWhileUsingApp);
                                TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Ask every time")) {
                                selectRadioButton(rdoAskEveryTime);
                                TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                            } else
                                TestUtils.log().info("Please provide correct permission option");

                        }
                        case "NearBy" -> {
                            if (strLocOrNearByPerm.equalsIgnoreCase("Allow")) {
                                selectRadioButton(rdoAllow);
                                TestUtils.log().info("NearBy Devices Permission set as {}", strLocOrNearByPerm);
                            } else if (strLocOrNearByPerm.equalsIgnoreCase("Don't allow")) {
                                selectRadioButton(rdoDeny);
                                TestUtils.log().info("Location Permission set as :: {}", strLocOrNearByPerm);
                            } else
                                TestUtils.log().info("Please provide correct permission option");

                        }
                        default -> TestUtils.log().info("Please provide correct permission option for execution");
                    }

                }
            }
            loopHandle(txtAppPreferences, NAVIGATE_BACK, 10);
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE,e.getMessage());
        }
    }
}




