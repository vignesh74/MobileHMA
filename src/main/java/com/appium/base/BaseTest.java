/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author-Brijesh Mishra BaseTest -This class includes all testNG annotations which have all desired capabilities. Date-02/11/2022
 */
package com.appium.base;

import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.manager.DriverFactory;
import com.appium.manager.DriverManager;
import com.appium.utils.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.logging.log4j.ThreadContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.InputStream;

import static com.appium.constants.FrameworkConstants.*;

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
            String mobilePin = ConfigLoader.getInstance().getAndroidMobilePin();
            AndroidDeviceAction androidDeviceAction = new AndroidDeviceAction();
            if ((DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID))) {
                String strUdId = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
                if (basePage.toKnowDeviceLockedState()) {
                    //androidDeviceAction.toUnlockDevice(strUdId);
                    androidDeviceAction.unlockDeviceWithPin(mobilePin);
                    basePage.waitForGivenTime(2);
                    if (basePage.toKnowDeviceLockedState()) {
                        //androidDeviceAction.toUnlockDevice(strUdId);
                        androidDeviceAction.unlockDeviceWithPin(mobilePin);
                        basePage.waitForGivenTime(2);
                        TestUtils.log().info("Device is unlocked and ready for execution");
                    }
                } else {
                    TestUtils.log().info("Device is already in unlocked state");
                }
            } else if ((DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_IOS))) {
                if (basePage.toKnowDeviceLockedState()) {
                    basePage.toUnlock();
                    TestUtils.log().info("Device is unlocked and ready for execution");
                } else {
                    TestUtils.log().info("Device is already in unlocked state");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying the device state...{}", e.getMessage());
        }
    }

}
