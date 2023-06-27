/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author-Brijesh Mishra DriverFactory- This class contains the method which creates instance of the appium driver Date-04/11/2022
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
