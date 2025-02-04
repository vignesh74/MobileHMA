/**
 * BaseTest -This class includes all testNG annotations which have all desired capabilities. Date-02/11/2022
 */
package com.appium.base;

import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.manager.DriverFactory;
import com.appium.manager.DriverManager;
import com.appium.utils.SerialPortUtils;
import com.appium.utils.TestUtils;
import com.appium.utils.TestRailUpdater;
import com.appium.utils.AppiumServerUtils;
import com.appium.utils.ConfigLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.InputStream;

import static com.appium.constants.FrameworkConstants.*;
import static com.appium.deviceinfo_action.AndroidDeviceAction.executeCommandAndGetOutput;

public class BaseTest extends AbstractTestNGCucumberTests {

    private static AppiumDriverLocalService server;
    SerialPortUtils srlPortUtils = new SerialPortUtils();
    String deviceComPort;

    /**
     * beforeTest - Executes before any of the test method class is executed. This method is creating instance of the driver by using required parameters.
     *
     * @param emulator
     * @param platformName
     * @param udid
     * @param deviceName
     * @param systemPort
     * @param wdaLocalPort
     * @param platformVersion
     * @param chromeDriverPort
     * @param webkitDebugProxyPort
     * @param installApp
     * @param userId
     * @param comPort
     * @param roboticArmX
     * @param roboticArmY
     *
     * @throws Exception
     *         Date-02/11/2022
     */

    @Parameters({ "emulator", "platformName", "udid", "deviceName", "systemPort",
            "wdaLocalPort", "platformVersion", "chromeDriverPort", "webkitDebugProxyPort", "installApp", "userId", "devicePort", "comPort","roboticArmX","roboticArmY" })
    @BeforeTest
    public void beforeTest(
            @Optional("AndroidAndiOS") String emulator,
            @Optional("AndroidAndiOS") String platformName,
            @Optional("AndroidAndiOS") String udid,
            @Optional("AndroidAndiOS") String deviceName,
            @Optional("AndroidAndiOS") String systemPort,
            @Optional("AndroidAndiOS") String wdaLocalPort,
            @Optional("AndroidAndiOS") String platformVersion,
            @Optional("AndroidAndiOS") String chromeDriverPort,
            @Optional("AndroidAndiOS") String webkitDebugProxyPort,
            @Optional("AndroidAndiOS") String installApp,
            @Optional("AndroidAndiOS") String userId,
            @Optional("AndroidAndiOS") String devicePort,
            @Optional("AndroidAndiOS") String comPort,
            @Optional("AndroidAndiOS") String roboticArmX,
            @Optional("AndroidAndiOS") String roboticArmY) throws Exception {
        /*
         * @Optional("androidOnly") -> means we are setting the default value as androidOnly and it is Optional
         */
        AppiumDriver<MobileElement> driver;
        DriverManager.setPlatform(platformName);
        DriverManager.setPlatformVersion(platformVersion);
        DriverManager.setDeviceName(deviceName);
        DriverManager.setDateTime(TestUtils.dateTime());
        DriverManager.setUserId(userId);
        DriverManager.setRoboticArmX(roboticArmX);
        DriverManager.setRoboticArmY(roboticArmY);
        DriverManager.setComPort(comPort);
        deviceComPort = srlPortUtils.getDeviceCOMPort();
        TestUtils.log().debug("device port value is {}", deviceComPort);
        DriverManager.setDevicePort(deviceComPort);

        InputStream stringsIS;
        String xmlFileName = EXPECTED_DATA_XML_FILE;
        stringsIS = getClass().getClassLoader().getResourceAsStream(xmlFileName);

        DriverManager.setStrings(TestUtils.parseStringXML(stringsIS));
        String strFile = LOGS + File.separator + platformName + "_" + deviceName;
        File logFile = new File(strFile);
        if (!logFile.exists()) {
            logFile.mkdirs();
        }
        ThreadContext.put(ROUTINGKEY, strFile);
        TestUtils.log().debug("Log file path: {}", strFile);

        try {
            driver = DriverFactory.createInstance(udid, platformVersion, deviceName, Boolean.parseBoolean(installApp), Boolean.parseBoolean(emulator), Integer.parseInt(systemPort));
            DriverManager.setDriver(driver);
            String sessionId = driver.getSessionId().toString();
            TestUtils.log().debug("sessionId: {}", sessionId);
        } catch (Exception exception) {
            TestUtils.log().debug("Exception occurred while creating the session...{}", exception.getMessage());
        } finally {
            if (stringsIS != null) {
                stringsIS.close();
            }
        }
    }

    /**
     * afterTest-This method is quitting the driver instance. Date-02/11/2022
     */
    @AfterTest
    public void afterTest() {
        TestRailUpdater testRailUpdaterObj=new TestRailUpdater();
        testRailUpdaterObj.updateStatus();
        DriverManager.getDriver().quit();
    }

    /**
     * closeApp- This method is closing the app Date-02/11/2022
     */
    public void closeApp() {
        ((InteractsWithApps) DriverManager.getDriver()).closeApp();
    }

    /**
     * launchApp-This method is the launching app Date-02/11/2022
     */
    public void launchApp() {
        ((InteractsWithApps) DriverManager.getDriver()).launchApp();
    }

    /**
     * beforeSuite- This method is starting the Appium server
     *
     * @param runLocation
     * @throws AppiumServerHasNotBeenStartedLocallyException
     * @throws Exception
     *         Date-02/11/2022
     */
    @Parameters("runLocation")
    @BeforeSuite
    public static void beforeSuite(@Optional("AndroidAndiOS") String runLocation) throws AppiumServerHasNotBeenStartedLocallyException, Exception {
        ThreadContext.put(ROUTINGKEY, SERVER_LOGS);
        try {
            if (runLocation.equalsIgnoreCase("local")) {
                server = AppiumServerUtils.getAppiumService();
                if (!AppiumServerUtils.checkIfAppiumServerIsRunnning(4723)) {
                    server.start();
                    /* This will not print the Appium server Logs in IDE console */
                    server.clearOutPutStreams();
                    TestUtils.log().debug("Appium Server started.................");
                } else {
                    TestUtils.log().debug("Appium Server is already running................");
                }
            } else {
                TestUtils.log().debug("Appium Server is run by grid(manually)................");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while starting the Appium server...{}", e.getMessage());
        }
    }

    /**
     * afterSuite-This method is stopping the Appium server
     *
     * @param runLocation
     *         Date-02/11/2022
     */
    @Parameters("runLocation")
    @AfterSuite
    public void afterSuite(@Optional("AndroidAndiOS") String runLocation) {
        try {
            if (runLocation.equalsIgnoreCase("local")) {
                server.stop();
                TestUtils.log().debug("Appium Server stopped.............");
            } else {
                TestUtils.log().debug("Appium Server stopped by grid(manually).............");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while stopping the Appium server...{}", e.getMessage());
        }
    }

    /**
     * verifyDeviceStateAndUnlockDevice- This method is used to check device state and unlock the device for at starting of the execution Date-14/02/2023
     */
    @BeforeMethod
    public void verifyDeviceStateAndUnlockDevice() {
        try {
            BasePage basePage = new BasePage();
            String platform = DriverManager.getPlatform();
            TestUtils.log().info("Verifying device state on platform: " + platform);

            if (platform.equalsIgnoreCase(PLATFORM_ANDROID)) {
                unlockAndroidDevice(basePage);
            } else if (platform.equalsIgnoreCase(PLATFORM_IOS)) {
                unlockiOSDevice(basePage);
            } else {
                TestUtils.log().warn("Unsupported platform detected: " + platform);
            }

        } catch (Exception e) {
            TestUtils.log().error("Exception occurred while verifying device state: ", e);
        }
    }

    /**
     * Unlocks an Android device if it's locked.
     */
    private void unlockAndroidDevice(BasePage basePage) {
        try {
            AndroidDeviceAction androidDeviceAction = new AndroidDeviceAction();
            String mobilePin = ConfigLoader.getInstance().getAndroidMobilePin();
            String strUdId = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");

            if (!isScreenAwake()) {
                wakeUpScreen();
            }

            if (basePage.toKnowDeviceLockedState()) {
                TestUtils.log().info("Device is locked, attempting to unlock...");
                androidDeviceAction.unlockDeviceWithPin(mobilePin);
                basePage.waitForGivenTime(2);

                // Re-check lock state after unlock attempt
                if (basePage.toKnowDeviceLockedState()) {
                    TestUtils.log().warn("Unlock attempt failed, retrying...");
                    androidDeviceAction.unlockDeviceWithPin(mobilePin);
                    basePage.waitForGivenTime(2);
                }
                TestUtils.log().info("Device is unlocked and ready for execution");
            } else {
                TestUtils.log().info("Device is already in an unlocked state.");
            }
        } catch (Exception e) {
            TestUtils.log().error("Error while unlocking Android device: ", e);
        }
    }

    /**
     * Unlocks an iOS device if it's locked.
     */
    private void unlockiOSDevice(BasePage basePage) {
        try {
            if (basePage.toKnowDeviceLockedState()) {
                TestUtils.log().info("iOS device is locked, unlocking...");
                basePage.toUnlock();
                TestUtils.log().info("iOS device is unlocked and ready for execution");
            } else {
                TestUtils.log().info("iOS device is already in an unlocked state.");
            }
        } catch (Exception e) {
            TestUtils.log().error("Error while unlocking iOS device: ", e);
        }
    }

    /**
     * Checks if the Android screen is awake.
     */
    private boolean isScreenAwake() {
        try {
            String output = executeCommandAndGetOutput(ConfigLoader.getInstance().getAdbPath(), "shell", "dumpsys", "power");
            return output.contains("mWakefulness=Awake") || output.contains("Display Power: state=ON");
        } catch (Exception e) {
            TestUtils.log().error("Error checking screen state: ", e);
            return false;
        }
    }

    /**
     * Wakes up the Android screen.
     */
    private void wakeUpScreen() {
        try {
            TestUtils.log().info("Waking up the device...");
            executeCommandAndGetOutput(ConfigLoader.getInstance().getAdbPath(), "shell", "input", "keyevent", "26"); // POWER button
            Thread.sleep(1000);
        } catch (Exception e) {
            TestUtils.log().error("Error waking up screen: ", e);
        }
    }

}
