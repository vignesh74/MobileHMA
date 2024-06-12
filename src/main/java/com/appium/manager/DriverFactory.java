/**
 *  DriverFactory- This class contains the method which creates instance of the appium driver Date-04/11/2022
 */
package com.appium.manager;

import com.appium.constants.FrameworkConstants;
import com.appium.exceptions.PlatformNotSupportedException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

 public class DriverFactory {

     DriverFactory()
     {

     }
    /**
     * createInstance- This method creates the device instance.
     * This method returns the appium driver of android and IOS
     * @param udid- String
     * @param platformVersion- String
     * @param deviceName- deviceName
     * @param installApp- boolean
     * @param emulator- boolean
     * @param systemPort- String
     * @return- AppiumDriver
     * Date-04/11/2022
     */
    public static AppiumDriver<MobileElement> createInstance(String udid, String platformVersion, String deviceName, boolean installApp, boolean emulator, int systemPort) {

        AppiumDriver<MobileElement> driver;

        String mobilePlatform = DriverManager.getPlatform();

        switch (mobilePlatform) {
            case FrameworkConstants.PLATFORM_IOS:
                driver = new IOSDriverManager().createInstance(udid, platformVersion, deviceName, installApp, emulator, systemPort);
                break;

            case FrameworkConstants.PLATFORM_ANDROID:
                driver = new AndroidDriverManager().createInstance(udid, platformVersion, deviceName, installApp, emulator, systemPort);
                break;

            default:
                throw new PlatformNotSupportedException(
                        "Platform not supported! Check if you set ios or android on the parameter.");
        }
        return driver;
    }
}
