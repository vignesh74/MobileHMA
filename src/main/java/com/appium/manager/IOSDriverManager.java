/**
 # MIT License
 #
 # Organization   eInfochips
 # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED.
 #
 # Permission is hereby granted, free of charge, to any person obtaining a copy
 # of this software and associated documentation files (the "Software"), to deal
 # in the Software without restriction, including without limitation the rights
 # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 # copies of the Software, and to permit persons to whom the Software is
 # furnished to do so, subject to the following conditions:
 #
 # The above copyright notice and this permission notice shall be included in all
 # copies or substantial portions of the Software.
 #
 # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 # LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 # SOFTWARE.
 #
 #              EINFOCHIPS
 #             2025 Gateway Place, Suite #238,
 #              San Jose, CA 95110
 #------------------------------------------------------------------------------------
 * @author-Brijesh Mishra
 * IOSDriverManager- This class used to initialize appium driver for IOS platform
 * Date-04/11/2022
 */
package com.appium.manager;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.PLATFORM_VERSION;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import com.appium.constants.FrameworkConstants;
import com.appium.utils.ConfigLoader;

import com.appium.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSDriverManager implements IDriver {

    private AppiumDriver<MobileElement> driver;

    /**
     * createInstance- This method creates the device instance and sets the capabilities
     * @param-udid- String
     * @param-platformVersion- String
     * @param-deviceName- String
     * @param-installApp- boolean
     * @param-emulator- boolean
     * @param-wdaLocalPort- String
     * @return- AppiumDriver
     * Date-04/11/2022
     */

    @Override
    public AppiumDriver<MobileElement> createInstance(String udid, String platformVersion, String deviceName, boolean installApp, boolean emulator, int wdaLocalPort) {
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(UDID, udid);
            capabilities.setCapability(PLATFORM_VERSION, platformVersion);
            capabilities.setCapability(DEVICE_NAME, deviceName);
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.IOS);
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);

            if (Boolean.TRUE.equals(installApp)) {

                capabilities.setCapability(APP, FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());
            } else {
                capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, ConfigLoader.getInstance().getiOSBundleID());
            }

//            if (wdaLocalPort != 0) {
//                capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wdaLocalPort);
//            }
            driver = new IOSDriver<>(new URL(appiumUrl()), capabilities);
        } catch (MalformedURLException e) {
            TestUtils.log().debug("Failed to initiate the tests for the IOS device... {}",e.getMessage());
        }
        return driver;
    }
}
