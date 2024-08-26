/**
 * AndroidDriverManager- This class used to initialize appium driver for android platform Date- 04/11/2022
 */
package com.appium.manager;

import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import java.net.MalformedURLException;
import java.net.URL;

import com.appium.utils.TestUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.constants.FrameworkConstants;
import com.appium.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;

public class AndroidDriverManager implements IDriver {

    private AppiumDriver<MobileElement> driver;

    /**
     * createInstance- This method creates the device instance and sets the capabilities
     *
     * @param-udid- String
     * @param-platformVersion-String
     * @param-deviceName-String
     * @param-installApp-boolean
     * @param-emulator-boolean
     * @param-systemPort-String
     * @return-AppiumDriver Date-04/11/2022
     **/
    @Override
    public AppiumDriver<MobileElement> createInstance(String udid, String platformVersion, String deviceName, boolean installApp, boolean emulator, int systemPort) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(UDID, udid);
            capabilities.setCapability(DEVICE_NAME, deviceName);
            capabilities.setCapability(PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
//            capabilities.setCapability("adbExecTimeout", 50000);
           // capabilities.setCapability("appWaitDuration",30000);
            if (Boolean.TRUE.equals(emulator)) {
                capabilities.setCapability("avd", deviceName);
                capabilities.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, 180000);
                capabilities.setCapability(AndroidMobileCapabilityType.AVD_READY_TIMEOUT, 90000);
            }
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("skipDeviceInitialization", true);
            capabilities.setCapability("appium:maxInstances", 1);
//                    "skipServerInstallation": true,

            if (Boolean.TRUE.equals(installApp)) {

                capabilities.setCapability(APP,
                        FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getAndroidApplocation());
            } else {
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
                        ConfigLoader.getInstance().getAndroidAppPackage());
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
                        ConfigLoader.getInstance().getAndroidAppActivity());
            }
            capabilities.setCapability("autoGrantPermissions", "true");

            driver = new AndroidDriver<>(new URL(appiumUrl()), capabilities);
        } catch (MalformedURLException e) {
            TestUtils.log().debug("Failed to initiate the tests for the Android device", e);
        }
        return driver;
    }
}
