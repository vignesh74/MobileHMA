package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import com.appium.constants.MessageConstants;
import org.testng.Assert;

public class Andr_HIDWarningBanners extends BasePage {

    Andr_HIDAppPreferencesScreenPage appPreferenceScreenPage = new Andr_HIDAppPreferencesScreenPage();
    Andr_DeviceNearbyPermissionSettingsPage deviceNearbyPermissionSettingsPage =new Andr_DeviceNearbyPermissionSettingsPage();
    Andr_DeviceBLESettingsPage deviceBLESettingsPage=new Andr_DeviceBLESettingsPage();
    Andr_DeviceLocationSettingsPage deviceLocationSettingsPage=new Andr_DeviceLocationSettingsPage();
    Andr_DeviceNFCSettingsPage deviceNFCSettingsPage=new Andr_DeviceNFCSettingsPage();

    /**
     * These are the Mobile elements required for validating Warning Banners
     */

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC Disabled']")
    private MobileElement nfcDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable NFC to use your Mobile ID by presenting your phone to the reader.']")
    private MobileElement nfcDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Permission']")
    private MobileElement locationPermissionDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We do not track your location. Enable Location to use your Mobile ID over Bluetooth.']")
    private MobileElement locationPermissionDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nearby permission Disabled']")
    private MobileElement nearByPermissionDisabled;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We do not track your location. Enable this to find readers nearby and use your Mobile ID over Bluetooth.']")
    private MobileElement nearByPermissionDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth Disabled']")
    private MobileElement bleDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Bluetooth to find readers nearby and use your Mobile ID over Bluetooth.']")
    private MobileElement bleDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GPS Disabled']")
    private MobileElement gpsDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We do not track your location. Enable this to find readers nearby and use your Mobile ID over Bluetooth.']")
    private MobileElement gpsDisabledText;

    @AndroidFindBy(id = "com.android.settings:id/switch_widget")
    private MobileElement nfcTurnOn;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_widget", priority = 0)
    @AndroidFindBy(id = "android:id/switch_widget", priority = 1)
    private MobileElement nfcTurnOnOFF;

    /**
     *  These mobile elements are used to validate warning banners Date-02-07-2023
     */

    @AndroidFindBy(id ="com.android.permissioncontroller:id/permission_message")
    private MobileElement popupPermissionMsg;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement allow_foreground_only;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    private MobileElement allow_one_time;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement permission_deny;
    @AndroidFindBy(id = "com.android.settings:id/switch_text")
    private MobileElement txtSwitchOnOffBle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Granted always']")
    private MobileElement nearByStatusText;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_text", priority = 0)
    @AndroidFindBy(id = "android:id/switch_text", priority = 1)
    private MobileElement txtSwitchOnOffNfc;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.hidglobal.mobilekeys.android.v3:id/statusDevices']",priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='On']",priority = 0)
    private MobileElement nfcStatusOn;

    @AndroidFindBy(xpath ="//android.widget.TextView[@text='Off']")
    private MobileElement nfcStatusOff;




    public void checkBleWb(){
        String str=bleDisabledText.getText();
        try{

            if(!(isDisplayed(bleDisabled)))
            {
                Assert.assertTrue(false, "BLE WARNING BANNER TEXT is invisible...");
                TestUtils.log().debug("BLE WARNING BANNER TEXT is not visible ");

            }
            else
            {

                if(MessageConstants.BLE_WARNING_BANNER_TEXT.equalsIgnoreCase(str))
                {
                    Assert.assertTrue(true, "BLE WARNING BANNER TEXT is visible and is correct...");
                    TestUtils.log().debug(" BLE WARNING BANNER TEXT is visible and is correct");
                }
                else {
                    Assert.assertTrue(false, "BLE WARNING BANNER TEXT is incorrect...");
                    TestUtils.log().debug(" BLE WARNING BANNER TEXT is incorrect");
                }


            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on BLE Disabled Warning Banner tab...");
        }

    }


    public void checkNfcWb(){

        String str=nfcDisabledText.getText();
        try{

            if(!(isDisplayed(nfcDisabled)))
            {
                Assert.assertTrue(false, "NFC WARNING BANNER is not visible...");
                TestUtils.log().debug("NFC WARNING BANNER is not visible... ");

            }
            else
            {

                if(MessageConstants.NFC_WARNING_BANNER_TEXT.equalsIgnoreCase(str))
                {
                Assert.assertTrue(true, "NFC WARNING BANNER TEXT is visible and is correct...");
                TestUtils.log().debug(" NFC WARNING BANNER TEXT is visible and is correct");
                }
                else {
                    Assert.assertTrue(false, "NFC WARNING BANNER TEXT is incorrect...");
                    TestUtils.log().debug(" NFC WARNING BANNER TEXT is incorrect");
                }
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on NFC Disabled Warning Banner tab...");
        }
    }

   /* public boolean checkLocationWb(){

        String str=gpsDisabledText.getText();
        try{

            if(!(isDisplayed(gpsDisabled)))
            {
                Assert.assertTrue(false, "GPS WARNING BANNER is not visible...");
                TestUtils.log().debug("GPS WARNING BANNER TEXT is not visible in this particular Scenario.It will be visible after changing Permissions to Allow");

            }
            else
            {
                if(MessageConstants.GPSWARNINGBANNERTEXT.equalsIgnoreCase(str))
                {
                    Assert.assertTrue(true, "GPS WARNING BANNER TEXT is visible and is correct...");
                    TestUtils.log().debug("GPS WARNING BANNER TEXT is  visible and is correct");
                }
                else {
                    Assert.assertTrue(false, "GPS WARNING BANNER TEXT is incorrect...");
                    TestUtils.log().debug("GPS WARNING BANNER TEXT is incorrect");
                }
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on GPS Disabled Warning Banner tab...");
        }
        return flag;
    }

    public boolean checkLocationPermissionWb(){
        String str=locationPermissionDisabledText.getText();
        try{

            if(!(isDisplayed(locationPermissionDisabled)))
            {
                Assert.assertTrue(false, "LOCATION PERMISSION WARNING BANNER is not visible...");
                TestUtils.log().debug("LOCATION PERMISSION WARNING BANNER TEXT is not visible ");

            }
            else
            {
                if(MessageConstants.LOCATIONPERMISSIONWARNINGBANNERTEXT.equalsIgnoreCase(str))
                {
                    Assert.assertTrue(true, "LOCATION PERMISSION WARNING BANNER TEXT is visible and is correct...");
                    TestUtils.log().debug("LOCATION PERMISSION WARNING BANNER TEXT is visible and is correct");
                }
                else {
                    Assert.assertTrue(false, "LOCATION PERMISSION WARNING BANNER TEXT is incorrect...");
                    TestUtils.log().debug("LOCATION PERMISSION WARNING BANNER TEXT is incorrect");
                }
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on Location Disabled Warning Banner tab...");
        }

    }
*/
    public void checkNearByPermissionWb(){
        String str=nearByPermissionDisabledText.getText();
        try{
            if(MessageConstants.NEARBY_PERMISSION_WARNING_BANNER_TEXT.equalsIgnoreCase(str))
            {
            Assert.assertTrue(true, "NEARBY PERMISSION WARNING BANNER TEXT is visible and is correct");
            TestUtils.log().debug(" NEARBY PERMISSION WARNING BANNER TEXT is visible and is correct");
            }
            else
            {
                Assert.assertTrue(false, "NEARBY PERMISSION WARNING BANNER TEXT is incorrect");
                TestUtils.log().debug(" NEARBY PERMISSION WARNING BANNER TEXT is is incorrect");
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on NEARBY PERMISSION Disabled Warning Banner TEXT...");
        }

    }

/*

    public void warningBannersWF1(String status1,String status2,String strLocationStatus,String strLocationOrNearBy, String strLocOrNearByPerm) {
        try {
            String strUDID = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("11")) ;
            deviceBLESettingsPage.setBLEStatus(status1);
            deviceNFCSettingsPage.setNFCStatus(status2);
            deviceLocationSettingsPage.setLocationStatus(strLocationStatus,strUDID);
            deviceNearbyPermissionSettingsPage.setNearByOrLocationPermWb(strLocationOrNearBy, strLocOrNearByPerm);


                checkBleWb();
                checkNfcWb();

              //  checkLocationWb();

               // waitForGivenTime(5);

             //   appPreferenceScreenPage.toVerifyNearByOrLocationPermissionStatus(strLocOrNearByPerm);

            if(strPlatformVersion.equalsIgnoreCase("12")){
                deviceBLESettingsPage.setBLEStatus(status1);
                deviceNFCSettingsPage.setNFCStatusWb(status2);
                deviceNearbyPermissionSettingsPage.setNearByOrLocationPerm(strLocationOrNearBy, strLocOrNearByPerm);
                checkBleWb();
                checkNfcWb();
                checkNearByPermissionWb();

            }
            }

        catch(Exception e)
        {
            throw new RuntimeException(e);
        }


    }
*/
    public void warningBanners(){
        try{
            String strPlatformVersion = DriverManager.getPlatformVersion();

            switch (strPlatformVersion) {
                case "12" -> {
                    try {
                        if (isDisplayed(bleDisabled)) {
                            Assert.assertTrue(true, "The BLE Disabled Banner is visible...");
                            TestUtils.log().debug(" The BLE Disabled Banner is visible...");
                            checkBleWb();
                        }
                        else
                        {
                            if(appPreferenceScreenPage.getTxtBluetoothStatusValue().getText().equalsIgnoreCase("On"))
                            {
                                Assert.assertTrue(true, "The BLE Disabled Banner is not available for particular Scenario...");
                                TestUtils.log().debug("BLUETOOTH PERMISSION DISABLED WARNING BANNER  is not available for particular Scenario...");
                            }
                            else
                            {
                                Assert.assertTrue(false, "The BLE Disabled Banner is not visible....");
                                TestUtils.log().debug("BLUETOOTH PERMISSION DISABLED WARNING BANNER  is not visible....");
                            }
                        }
                    } catch(Exception e)
                    {
                        TestUtils.log().debug("Element not visible for this Scenario");
                    }

                    try {
                        if (isDisplayed(nfcDisabled)) {
                            Assert.assertTrue(true, "The NFC Disabled Banner is visible...");
                            TestUtils.log().debug(" The NFC Disabled Banner is visible...");
                            checkNfcWb();
                        } else
                        {
                            if(deviceNFCSettingsPage.getElementText(nfcStatusOn).equalsIgnoreCase("On"))
                            {
                                Assert.assertTrue(true, "The NFC Disabled Banner is not available for particular Scenario...");
                                TestUtils.log().debug("NFC PERMISSION DISABLED WARNING BANNER  is not available for particular Scenario...");
                            }
                            else {
                                Assert.assertTrue(false, "The NFC Disabled Banner is not visible...");
                                TestUtils.log().debug("NFC PERMISSION DISABLED WARNING BANNER  is not visible...");
                            }
                        }
                    } catch(Exception e)
                    {
                        TestUtils.log().debug("Element not visible for this Scenario");
                    }


                    try {
                        if (isDisplayed(nearByPermissionDisabled)) {
                            Assert.assertTrue(true, "The Nearby Permission Disabled Banner is visible...");
                            TestUtils.log().debug(" The Nearby Permission Disabled Banner is visible...");
                            checkNearByPermissionWb();
                        } else {
                            if(getElementText(nearByStatusText).equalsIgnoreCase("Granted always"))
                            {
                                Assert.assertTrue(true, "The Nearby Permission Disabled Banner is not available for particular Scenario...");
                                TestUtils.log().debug("NEARBY PERMISSION WARNING BANNER TEXT is not available for particular Scenario");
                            }
                            else
                            {
                                Assert.assertTrue(false, "The Nearby Permission Disabled Banner is not visible...");
                                TestUtils.log().debug("NEARBY PERMISSION WARNING BANNER TEXT is not visible");
                            }

                        }
                    } catch(Exception e)
                    {
                        TestUtils.log().debug("Element not visible for this Scenario");
                    }

                }
               /* case "11" -> {

                    checkBleWb();
                    checkNfcWb();
                    checkLocationWb();
                    checkLocationPermissionWb();
                }*/
                default -> {TestUtils.log().debug("Different Android Version");}
            }


        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

/*
    public void warningBannersWF2(String strLocationStatus, String strUDID ,String strNFCStatus,String strBLEStatus,String strLocationOrNearBy, String strLocOrNearByPerm) {

        try {
            String strPlatformVersionWb = DriverManager.getPlatformVersion();
            if (strPlatformVersionWb.equalsIgnoreCase("11"))
            {
                if (isDisplayed(bleDisabled) && isDisplayed(locationPermissionDisabled) && isDisplayed(nfcDisabled) || isDisplayed(gpsDisabled)) {
                    {
                        deviceNFCSettingsPage.setNFCStatusWb(strNFCStatus);
                    }
                    for (int i = 0; i <= 3; i++) {
                        checkBleWb();
                        checkNfcWb();
                        checkLocationWb();
                        checkLocationPermissionWb();
                        deviceNearbyPermissionSettingsPage.setNearByOrLocationPermWb(strLocationOrNearBy, strLocOrNearByPerm);
                        appPreferenceScreenPage.toVerifyNearByOrLocationPermissionStatus(strLocOrNearByPerm);

                    }
                }

                if (strPlatformVersionWb.equalsIgnoreCase("11")) ;
                if (isDisplayed(bleDisabled) && isDisplayed(locationPermissionDisabled)  || isDisplayed(gpsDisabled)) {
                    {
                        deviceBLESettingsPage.setBLEStatusWb(strBLEStatus);
                    }
                    for (int i = 0; i <= 3; i++) {
                        checkBleWb();
                        checkNfcWb();
                        checkLocationWb();
                        checkLocationPermissionWb();
                        deviceNearbyPermissionSettingsPage.setNearByOrLocationPermWb(strLocationOrNearBy, strLocOrNearByPerm);
                        appPreferenceScreenPage.toVerifyNearByOrLocationPermissionStatus(strLocOrNearByPerm);

                    }
                }
                if (strPlatformVersionWb.equalsIgnoreCase("11")) ;
                if (isDisplayed(locationPermissionDisabled)  || isDisplayed(gpsDisabled)) {
                    {
                        deviceLocationSettingsPage.setLocationStatusWb(strLocationStatus, strUDID);
                    }
                    for (int i = 0; i <= 1; i++) {
                        checkBleWb();
                        checkNfcWb();
                        checkLocationWb();
                        checkLocationPermissionWb();
                        deviceNearbyPermissionSettingsPage.setNearByOrLocationPermWb(strLocationOrNearBy, strLocOrNearByPerm);
                        appPreferenceScreenPage.toVerifyNearByOrLocationPermissionStatus(strLocOrNearByPerm);

                    }
                }

                }
            } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    */
}