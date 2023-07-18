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

public class Andr_WarningBanners extends BasePage {

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


    public boolean checkBleWb(){
        boolean flag = false;
        String str=bleDisabledText.getText();
        try{

            if(!(isDisplayed(bleDisabled)))
            {
                TestUtils.log().debug("BLE WARNING BANNER TEXT is not visible for this particular Scenario");
                flag=true;
            }
            else
            {
                MessageConstants.BLEWARNINGBANNERTEXT.equalsIgnoreCase(str);
                TestUtils.log().debug("BLE WARNING BANNER TEXT is visible");
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on Location Disabled Warning Banner tab...");
        }
        return flag;
    }


    public boolean checkNfcWb(){
        boolean flag = false;
        String str=nfcDisabledText.getText();
        try{

            if(!(isDisplayed(nfcDisabled)))
            {
                TestUtils.log().debug("NFC WARNING BANNER TEXT is not visible for this particular Scenario");
               flag=true;
            }
            else
            {
                MessageConstants.NFCWARNINGBANNERTEXT.equalsIgnoreCase(str);
                TestUtils.log().debug("NFC WARNING BANNER TEXT is visible");
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on Location Disabled Warning Banner tab...");
        }
        return flag;
    }

    public boolean checkLocationWb(){
        boolean flag = false;
        String str=gpsDisabledText.getText();
        try{

            if(!(isDisplayed(gpsDisabled)))
            {

                TestUtils.log().debug("GPS WARNING BANNER TEXT is not visible in this particular Scenario.It will be visible after changing Permissions to Allow");
                flag=true;
            }
            else
            {
                MessageConstants.GPSWARNINGBANNERTEXT.equalsIgnoreCase(str);
                TestUtils.log().debug("GPS WARNING BANNER TEXT is  visible ");
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on Location Disabled Warning Banner tab...");
        }
        return flag;
    }

    public boolean checkLocationPermissionWb(){
        boolean flag = false;
        String str=locationPermissionDisabledText.getText();
        try{

            if(!(isDisplayed(locationPermissionDisabled)))
            {

                TestUtils.log().debug("LOCATION PERMISSION WARNING BANNER TEXT is not visible for this particular Scenario");
                flag=true;
            }
            else
            {
                MessageConstants.LOCATIONPERMISSIONWARNINGBANNERTEXT.equalsIgnoreCase(str);
                TestUtils.log().debug("LOCATION PERMISSION WARNING BANNER TEXT is visible");
            }
        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on Location Disabled Warning Banner tab...");
        }
        return flag;
    }

    public void checkNearByPermissionWb(){
        String str=nearByPermissionDisabledText.getText();
        try{

                MessageConstants.NEARBYPERMISSIONWARNINGBANNERTEXT.equalsIgnoreCase(str);
                TestUtils.log().debug("NEARBY PERMISSION WARNING BANNER TEXT is visible ");

        }
        catch(Exception e)
        {
            TestUtils.log().debug("Exception occurred while checking on NEARBY PERMISSION Disabled Warning Banner TEXT...");
        }

    }



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

    public void warningBanners(){
        try{
            String strPlatformVersion = DriverManager.getPlatformVersion();
            switch (strPlatformVersion) {
                case "12" -> {
                    try {
                        if (isDisplayed(bleDisabled)) {
                            checkBleWb();
                        } else {
                            TestUtils.log().debug("BLUETOOTH PERMISSION WARNING BANNER TEXT is not available for particular Scenario");
                        }
                    } catch(Exception e)
                    {
                        TestUtils.log().debug("Element not visible for this Scenario");
                    }

                    try {
                        if (isDisplayed(nfcDisabled)) {
                            checkNfcWb();
                        } else {
                            TestUtils.log().debug("NFC PERMISSION WARNING BANNER TEXT is not available for particular Scenario");
                        }
                    } catch(Exception e)
                    {
                        TestUtils.log().debug("Element not visible for this Scenario");
                    }


                    try {
                        if (isDisplayed(nearByPermissionDisabled)) {
                            checkNearByPermissionWb();
                        } else {
                            TestUtils.log().debug("NEARBY PERMISSION WARNING BANNER TEXT is not available for particular Scenario");
                        }
                    } catch(Exception e)
                    {
                        TestUtils.log().debug("Element not visible for this Scenario");
                    }

                }
                case "11" -> {

                    checkBleWb();
                    checkNfcWb();
                    checkLocationWb();
                    checkLocationPermissionWb();
                }
                default -> {TestUtils.log().debug("Different Android Version");}
            }


        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


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
}