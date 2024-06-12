/**
 * DriverManager-This class is used to define getter and setter methods of driver Date-04/11/2022
 */

package com.appium.manager;

import io.appium.java_client.AppiumDriver;

import java.util.HashMap;

public final class DriverManager {

    public static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    private static ThreadLocal<String> dateTime = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> platform = new ThreadLocal<String>();
    private static ThreadLocal<String> platformVersion = new ThreadLocal<String>();
    private static ThreadLocal<HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    private static ThreadLocal<String> userId = new ThreadLocal<String>();
    private static ThreadLocal<String> devicePort = new ThreadLocal<String>();
    private static ThreadLocal<Boolean> popupHandled = new ThreadLocal<>();

    private static ThreadLocal<String> comPort = new ThreadLocal<>();
    private static ThreadLocal<String> roboticArmX = new ThreadLocal<>();
    private static ThreadLocal<String> roboticArmY = new ThreadLocal<>();

     DriverManager()
    {
        //declared default constructor
    }

    /**
     * getcomPort -This method returns the device Port
     *
     * @return -comPort Date-23/03/2023
     */
    public static String getComPort() {
        return comPort.get();
    }

    /**
     * setcomPort-This method is used to set com Port Date-23/03/2023
     */
    public static void setComPort(String comPort1) {
        comPort.set(comPort1);
    }

    /**
     * getDevicePort -This method returns the device Port
     *
     * @return -devicePort Date-11/01/2022
     */
    public static String getDevicePort() {
        return devicePort.get();
    }

    /**
     * setDevicePort-This method is used to set device Port Date-11/01/2022
     */
    public static void setDevicePort(String deviceComPort) {
        devicePort.set(deviceComPort);
    }

    /**
     * unloadDevicePort- This method unload the Device Port - 23/03/23
     */
    public static void unloadDevicePort() {
        devicePort.remove();
    }

    /**
     * getDriver -This method returns the appium driver instance
     *
     * @return -AppiumDriver Date-04/11/2022
     */
    public static AppiumDriver getDriver() {
        return driver.get();
    }

    /**
     * setDriver-This method is used to set appium driver
     *
     * @param driverref
     *         -AppiumDriver Date-04/11/2022
     */
    public static void setDriver(AppiumDriver driverref) {
        driver.set(driverref);
    }

    /**
     * unload-This method is used to remove driver instance Date-04/11/2022
     */
    public static void unload() {
        driver.remove();
    }

    /**
     * getDateTime-This method returns current date and time
     *
     * @return Date-04/11/2022
     */
    public static String getDateTime() {
        return dateTime.get();
    }

    /**
     * setDateTime- This method sets the current date and time
     *
     * @param dateTime2-
     *         String Date-04/11/2022
     */
    public static void setDateTime(String dateTime2) {
        dateTime.set(dateTime2);
    }

    /**
     * unloadDateTime- This method unload the date and time Date-04/11/2022
     */
    public static void unloadDateTime() {
        dateTime.remove();
    }

    /**
     * getDeviceName- This method returns the device name
     *
     * @return -String Date-04/11/2022
     */
    public static String getDeviceName() {
        return deviceName.get();
    }

    /**
     * setDeviceName-This method sets the device name
     *
     * @param deviceName2-
     *         String Date-04/11/2022
     */
    public static void setDeviceName(String deviceName2) {
        deviceName.set(deviceName2);
    }

    /**
     * unloadDeviceName- This method remove the deviceName Date-04/11/2022
     */
    public static void unloadDeviceName() {
        deviceName.remove();
    }

    /**
     * getPlatform- This method return the platform name
     *
     * @return-String Date-04/11/2022
     */
    public static String getPlatform() {
        return platform.get();
    }

    /**
     * setPlatform-This method sets the platform name
     *
     * @param driverref-String
     *         Date-04/11/2022
     */
    public static void setPlatform(String driverref) {
        platform.set(driverref);
    }

    /**
     * unloadPlatform- This method remove the platform name Date-04/11/2022
     */
    public static void unloadPlatform() {
        platform.remove();
    }

    /**
     * getStrings -This method return the HashMap of string
     *
     * @return- HashMap Date-04/11/2022
     */
    public static HashMap<String, String> getStrings() {
        return strings.get();
    }

    /**
     * setStrings- This method sets the HaspMap String
     *
     * @param driverref-HashMap
     *         Date-04/11/2022
     */
    public static void setStrings(HashMap<String, String> driverref) {
        strings.set(driverref);
    }

    /**
     * unloadStrings-This method remove the strings Date-04/11/2022
     */
    public static void unloadStrings() {
        strings.remove();
    }

    /**
     * getPlatformVersion- This method return the platform version
     *
     * @return-String Date-04/11/2022
     */
    public static String getPlatformVersion() {
        return platformVersion.get();
    }

    /**
     * setPlatformVersion-This method sets the platform version
     *
     * @param driverref-String
     *         Date-04/11/2022
     */
    public static void setPlatformVersion(String driverref) {
        platformVersion.set(driverref);
    }

    /**
     * unloadPlatformVersion- This method remove the platform version Date-04/11/2022
     */
    public static void unloadPlatformVersion() {
        platformVersion.remove();
    }

    /**
     * getPlatformVersion- This method return the platform version
     *
     * @return-String Date-04/11/2022
     */
    public static String getUserId() {
        return userId.get();
    }

    /**
     * setPlatformVersion-This method sets the platform version
     *
     * @param usrId-String
     *         Date-04/11/2022
     */
    public static void setUserId(String usrId) {
        userId.set(usrId);
    }

    /**
     * unloadUserID- This method unload the User ID - 23/03/23
     */
    public static void unloadUserID() {
        userId.remove();
    }

    /**
     * getPopupHandled- This method return the popup handling true/false
     *
     * @return boolean Date-09/02/2023
     */
    public static boolean getPopupHandled() {
        return popupHandled.get();
    }

    /**
     * setPopupHandled- This method set the popup handling true/false
     *
     * @param popup
     *         Date-09/02/2023
     */
    public static void setPopupHandled(boolean popup) {
        popupHandled.set(popup);
    }

    /**
     * unloadPopupHandled- This method unload the Popup Handled - 23/03/23
     */
    public static void unloadPopupHandled() {
        popupHandled.remove();
    }

    public static String getRoboticArmX() {
        return roboticArmX.get();
    }

    public static void setRoboticArmX(String robotic_ArmX) {
        roboticArmX.set(robotic_ArmX);
    }

    public static String getRoboticArmY() {
        return roboticArmY.get();
    }

    public static void setRoboticArmY(String robotic_ArmY) {
        roboticArmY.set(robotic_ArmY);
    }
}
