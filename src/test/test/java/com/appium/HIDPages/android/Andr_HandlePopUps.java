package com.appium.HIDPages.android;

import com.appium.constants.MessageConstants;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import static com.appium.constants.MessageConstants.ENDTESTPOPUPSHANDLING;
import static com.appium.constants.MessageConstants.INITIALPOPUPSHANDLING;

public class Andr_HandlePopUps
{
    Andr_HIDMobileIDScreenPage mobileIDScreen=new Andr_HIDMobileIDScreenPage();
    Andr_DeviceNearbyPermissionSettingsPage nearbyPermissionSettingsPage=new Andr_DeviceNearbyPermissionSettingsPage();
    

    /**
     * enableAllPopUpsV9- This method is used to handle popups from version 9
     * @param level-String
     * @return -boolean
     * Date-22/02/2023
     */
    public boolean enableAllPopUpsV9(String level) {
        boolean popups = false;
        switch (level) {
            case INITIALPOPUPSHANDLING -> {
                if (!mobileIDScreen.checkVisibilityOFNextButton()) {
                    mobileIDScreen.handleNFCPopUp();
                    if (mobileIDScreen.checkVisibilityOfAllowButton()) {
                        mobileIDScreen.allowAccessToDeviceLocationPopUp();
                        mobileIDScreen.handleBluetoothPopUp();
                    }
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
            }
            case ENDTESTPOPUPSHANDLING -> {
                if(!mobileIDScreen.checkVisibilityOFSettingsTab()) {
                    mobileIDScreen.handleNFCPopUp();
                    if(mobileIDScreen.checkVisibilityOfAllowButton()) {
                        mobileIDScreen.locationPermissionPopUpEnable();
                        nearbyPermissionSettingsPage.setLocationPermission("On");
                        mobileIDScreen.locationPopUpEnable();
                        mobileIDScreen.handleBluetoothPopUp();
                    }
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
                popups = true;
            }
            default ->
                TestUtils.log().info(MessageConstants.POPUP_NOT_AVAILABLE);

        }
        return popups;
    }

    /**
     * enableAllPopUpsV12- This method is used to handle popups from version 12
     * It will handle sequence of NFC,bluetooth and mobile access popup appears at start and at time of the device unregister
     * @param level-String
     * @return -boolean
     * Date-22/02/2023
     */
    public boolean enableAllPopUpsV12(String level)
    {
        boolean popups = false;
        switch (level) {
            case INITIALPOPUPSHANDLING -> {
                if (!mobileIDScreen.checkVisibilityOFNextButton())
                {
                    mobileIDScreen.handleNFCPopUp();
                    if (!mobileIDScreen.checkVisibilityOFNextButton())
                    {
                        mobileIDScreen.handleBluetoothPopUp();
                    }
                    if (!mobileIDScreen.checkVisibilityOFNextButton()) {
                        mobileIDScreen.handleHIDMobileAccessPopUp();
                    }
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
            }
            case ENDTESTPOPUPSHANDLING -> {
                if(!mobileIDScreen.checkVisibilityOFSettingsTab()) {
                    mobileIDScreen.handleNFCPopUp();
                    mobileIDScreen.handleBluetoothPopUp();
                    mobileIDScreen.handleHIDMobileAccessPopUp();
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
                popups = true;
            }
            default ->
                TestUtils.log().info(MessageConstants.POPUP_NOT_AVAILABLE);

        }
        return popups;
    }

    /**
     * enableAllPopUpsV11- This method is used to handle popups for version 11
     * It will handle sequence of NFC,Device location ,bluetooth and location permission popup appears at start and at time of the device unregister
     * @param level-String
     * @return -boolean
     * Date-22/02/2023
     */
    public boolean enableAllPopUpsV11(String level)
    {
        boolean popups = false;
        switch (level) {
            case INITIALPOPUPSHANDLING -> {
                if (!mobileIDScreen.checkVisibilityOFNextButton())
                {
                    mobileIDScreen.handleNFCPopUp();
                    mobileIDScreen.allowAccessToDeviceLocationPopUp();
                    mobileIDScreen.handleBluetoothPopUp();
                    mobileIDScreen.handleBackgroundLocationPermissionPopUp();
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
            }
            case ENDTESTPOPUPSHANDLING -> {
                if(!mobileIDScreen.checkVisibilityOFSettingsTab())
                {
                    mobileIDScreen.handleNFCPopUp();
                    boolean blnPopUpState = mobileIDScreen.handleDeviceLocationPermissionPopUp();
                    if (blnPopUpState) {
                        nearbyPermissionSettingsPage.setLocationPermissionAsAllow();
                    }
                    mobileIDScreen.handleBluetoothPopUp();
                    mobileIDScreen.handleBackgroundLocationPermissionPopUp();
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
                popups = true;
            }
            default ->
                TestUtils.log().info(MessageConstants.POPUP_NOT_AVAILABLE);

        }
        return popups;
    }

    /**
     * enableAllPopUpsV10- This method is used to handle popups from version 10
     * It will handle sequence of NFC,Device location ,bluetooth and location permission popup appears at start and at time of the device unregister
     * @param level-String
     * @return -boolean
     * Date-22/02/2023
     */
    public boolean enableAllPopUpsV10(String level)
    {
        boolean popups = false;
        switch (level) {
            case INITIALPOPUPSHANDLING -> {
                if (!mobileIDScreen.checkVisibilityOFNextButton())
                {
                    mobileIDScreen.handleNFCPopUp();
                    if (!mobileIDScreen.checkVisibilityOFNextButton())
                    {
                        mobileIDScreen.handleBluetoothPopUp();
                    }
                    if (!mobileIDScreen.checkVisibilityOFNextButton()) {
                        mobileIDScreen.handleHIDMobileAccessPopUp();
                    }
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
            }
            case ENDTESTPOPUPSHANDLING -> {
                if(!mobileIDScreen.checkVisibilityOFSettingsTab()) {
                    mobileIDScreen.handleNFCPopUp();
                    boolean blnPopUpState = mobileIDScreen.handleDeviceLocationPermissionPopUp();
                    if (blnPopUpState) {
                        nearbyPermissionSettingsPage.setLocationPermissionAsAllow();
                    }
                    mobileIDScreen.handleBluetoothPopUp();
                    mobileIDScreen.handleBackgroundLocationPermissionPopUp();
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
                popups = true;
            }
            default ->
                TestUtils.log().info(MessageConstants.POPUP_NOT_AVAILABLE);

        }
        return popups;
    }

    /**
     * enableAllPopUpsV8- This method is used to handle popups from version 8
     * It will handle sequence of NFC,bluetooth and mobile access popup appears at start and at time of the device unregister
     * @param level-String
     * @return -boolean
     * Date-22/02/2023
     */
    public boolean enableAllPopUpsV8(String level)
    {
        boolean popups = false;
        switch (level) {
            case INITIALPOPUPSHANDLING -> {
                if (!mobileIDScreen.checkVisibilityOFNextButton())
                {
                    mobileIDScreen.handleNFCPopUp();
                    if (!mobileIDScreen.checkVisibilityOFNextButton())
                    {
                        mobileIDScreen.handleBluetoothPopUp();
                    }
                    if (!mobileIDScreen.checkVisibilityOFNextButton()) {
                        mobileIDScreen.handleHIDMobileAccessPopUp();
                    }
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
            }
            case ENDTESTPOPUPSHANDLING -> {
                if(!mobileIDScreen.checkVisibilityOFSettingsTab()) {
                    mobileIDScreen.handleNFCPopUp();
                    mobileIDScreen.handleBluetoothPopUp();
                    mobileIDScreen.handleHIDMobileAccessPopUp();
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
                popups = true;
            }
            default ->
                TestUtils.log().info(MessageConstants.POPUP_NOT_AVAILABLE);

        }
        return popups;
    }

    /**
     * enableAllPopUpsV7- This method is used to handle popups from version 7
     * It will handle sequence of NFC,bluetooth and mobile access popup appears at start and at time of the device unregister
     * @param level-String
     * @return -boolean
     * Date-22/02/2023
     */
    public boolean enableAllPopUpsV7(String level)
    {
        boolean popups = false;
        switch (level) {
            case INITIALPOPUPSHANDLING -> {
                if (!mobileIDScreen.checkVisibilityOFNextButton())
                {
                    mobileIDScreen.handleNFCPopUp();
                    if (!mobileIDScreen.checkVisibilityOFNextButton())
                    {
                        mobileIDScreen.handleBluetoothPopUp();
                    }
                    if (!mobileIDScreen.checkVisibilityOFNextButton()) {
                        mobileIDScreen.handleHIDMobileAccessPopUp();
                    }
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
            }
            case ENDTESTPOPUPSHANDLING -> {
                if(!mobileIDScreen.checkVisibilityOFSettingsTab()) {
                    mobileIDScreen.handleNFCPopUp();
                    mobileIDScreen.handleBluetoothPopUp();
                    mobileIDScreen.handleHIDMobileAccessPopUp();
                }
                TestUtils.log().info(MessageConstants.ALL_POPUP_HANDLED);
                popups = true;
            }
            default ->
                TestUtils.log().info(MessageConstants.POPUP_NOT_AVAILABLE);

        }
        return popups;
    }

    /**
     * enableAllPopUps- This method is used to handle the all android version popups
     * @param level-String
     * @return -boolean
     */
    public boolean enableAllPopUps(String level){
        boolean popups = false;
        String strPlatformVersion = DriverManager.getPlatformVersion();
        if (strPlatformVersion.equalsIgnoreCase("12")){
            popups=enableAllPopUpsV12(level);
        } else if (strPlatformVersion.equalsIgnoreCase("11")){
            popups=enableAllPopUpsV11(level);
        }else if (strPlatformVersion.equalsIgnoreCase("10")){
            popups=enableAllPopUpsV10(level);
        }else if (strPlatformVersion.equalsIgnoreCase("9")){
            popups = enableAllPopUpsV9(level);
        }else if (strPlatformVersion.equalsIgnoreCase("8")){
            popups = enableAllPopUpsV8(level);
        }else if (strPlatformVersion.equalsIgnoreCase("7")){
            popups = enableAllPopUpsV7(level);
        }
        return popups;
    }
}
