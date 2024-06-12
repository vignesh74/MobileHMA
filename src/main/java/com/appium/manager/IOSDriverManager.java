/**
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
