/**
 * AndroidDeviceAction- This class provides action for android like wifi, gps, bluetooth and data ON/OFF Date-24/11/2022
 **/

package com.appium.deviceinfo_action;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.List;

import static com.appium.constants.FrameworkConstants.*;
import static com.appium.constants.MessageConstants.EXCEPTION_OCCURRED_MESSAGE;
import static com.appium.manager.DriverManager.driver;

public class AndroidDeviceAction {
    BasePage basePage = new BasePage();

    @AndroidFindBy(id="com.sec.android.app.launcher:id/clear_all")
    public MobileElement clearAll;

    @AndroidFindBy(id="com.sec.android.app.launcher:id/clear_all_button")
    public MobileElement closeAll;

    /**
     * turnOnWifi- This method will turn On the Wifi
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String turnOnWifi(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell svc wifi enable");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Getting Wifi turn on successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Exception Occurred while turning on wifi...");
        }
        return info.toString();
    }

    /**
     * turnOffWifi- This method turn off the wifi from android device
     *
     * @param udid
     * @return- String Date-10/11/2022
     */
    public String turnOffWifi(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell svc wifi disable");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Getting Wifi turn off successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Exception Occurred while turning off wifi....");
        }
        return info.toString();
    }

    /**
     * turnOnBluetooth- This method will turn on the bluetooth
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String turnOnBluetooth(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell am broadcast -a io.appium.settings.bluetooth --es setstatus enable");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Getting Bluetooth turn on successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Exception Occurred while turning on Bluetooth....");
        }
        return info.toString();
    }

    /**
     * turnOffBluetooth- This method turn off the bluetooth from device
     *
     * @param udid
     * @return- String Date-10/11/2022
     */
    public String turnOffBluetooth(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell dumpsys wifi");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Getting Bluetooth turn off successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Exception Occurred while turning off Bluetooth....");
        }
        return info.toString();
    }

    /**
     * getbluetoothStatus- This method will check whether the bluetooth is on or off
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String getBluetoothStatus(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell settings get global bluetooth_on");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Getting Bluetooth status successfully");
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * turnOnGpsLocation- This method will turn on the GPS location
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String turnOnGpsLocation(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell settings put secure location_mode 3");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("Getting GPS location turn on successfully");
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();

        } catch (Exception e) {
            TestUtils.log().debug("Exception Occurred while turning on the GPS...");
        }
        return info.toString();
    }

    /**
     * turnOffGpsLocation- This method will turn off the GPS location
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String turnOffGpsLocation(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell settings put secure location_mode 0");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("Getting GPS location turn off successfully");
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();

        } catch (Exception e) {
            TestUtils.log().debug("Exception Occurred while turing of GPS...");
        }
        return info.toString();
    }

    /**
     * setDisplayStateToSleep- This method will set the display screen to sleep
     *
     * @param udid
     * @return- String Date-6/12/2022
     */
    public String setDisplayStateToSleep(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 223");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("Getting display state to sleep successfully");
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();

        } catch (Exception e) {
            TestUtils.log().debug("check1sleep "+e);
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * setDisplayStateToWake- This method will set the display screen to wake
     *
     * @param udid
     * @return- String Date-6/12/2022
     */
    public String setDisplayStateToWake(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 224");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("Getting display state to wake successfully");
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();

        } catch (Exception e) {
            TestUtils.log().debug("check2 wake "+e);
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * getDisplayState- This method will return the display screen state
     *
     * @param udid
     * @return- String Date-6/12/2022
     */
    public String getDisplayState(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell dumpsys display | grep \"mScreenState\"");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("Getting display state successfully");
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();

        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * turnDataConnectionOn- This method will turn the data connection on
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String turnDataConnectionOn(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell svc data enable");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("Data connection is successfully turn on");
            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();

        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * turnDataConnectionoff- This method will turn the data connection off
     *
     * @param udid
     * @return- String Date-6/12/2022
     */

    public String turnDataConnectionOff(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell svc data disable");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Data connection is successfully turn off");
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * toUnlockDevice-This method unlock the device
     *
     * @param udid-String
     * @return-udid -String Date-10/11/2022
     */
    public String toUnlockDevice(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 26");
            basePage.waitForGivenTime(1);
            p = rt.exec(ADB_COMMAND + udid + " shell input swipe 540 1600 540 100 1500");
            basePage.waitForGivenTime(1);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device unlocked  ************");
            s = (reader.readLine());

            do {
                info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * toUnlockDeviceWithPin-This method unlocks the device by using pin
     *
     * @param udid-String
     * @param strPin-String
     * @return String Date-10/11/2022
     */
    public String toUnlockDeviceWithPin(String udid, String strPin) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 26 ");
            TestUtils.log().info("*************** clicked on unlock Button ************");
            p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 82 ");
            TestUtils.log().info("*************** clicked on swipe to unlock ************");
            basePage.waitForGivenTime(2000);
            p = rt.exec(ADB_COMMAND + udid + " shell input text " + strPin);
            TestUtils.log().info("*************** Pin entered  *****************");
            basePage.waitForGivenTime(2000);
            p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 66");
            basePage.waitForGivenTime(2000);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device locked by entering pin ************");
            s = (reader.readLine());

            do {
                info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /**
     * toLockDevice-This method used to lock the by pressing lock/power button
     *
     * @param udid-String
     * @return- String Date-10/11/2022
     */
    public String toLockDevice(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(" adb -s " + udid + "shell input keyevent 26");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device locked by entering pin ************");
            s = (reader.readLine());

            do {
                info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug(EXCEPTION_OCCURRED_MESSAGE);
        }
        return info.toString();
    }

    /** newly added methods rquired in HID Automation **/
    /**
     * setScreenDisplayStatus- This method is used to set screen display status
     *
     * @param displayStatus- String
     * @param udid-          String Date- 14/02/2023
     */

    public void setScreenDisplayStatus(String displayStatus, String udid) {
        try {
            if (displayStatus.equalsIgnoreCase("ON")) {
                basePage.waitForGivenTime(2);
                setDisplayStateToWake(udid);
                TestUtils.log().info("Display screen set as {}", displayStatus);
            } else if (displayStatus.equalsIgnoreCase("OFF")) {
                basePage.waitForGivenTime(2);
                setDisplayStateToSleep(udid);
                TestUtils.log().info("Display screen set as {}", displayStatus);
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting screen display status");
        }
    }

    /**
     * setLocationStatus- This method is used to set the location status
     *
     * @param locationStatus- String
     * @param udid-           String Date- 14/02/2023
     */

    public void setLocationStatus(String locationStatus, String udid) {
        try {
            if (locationStatus.equalsIgnoreCase("ON")) {
                turnOnGpsLocation(udid);
                TestUtils.log().info("Location Permission enabled");
            } else if (locationStatus.equalsIgnoreCase("OFF")) {
                turnOffGpsLocation(udid);
                TestUtils.log().info("Location Permission disabled");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting Location Permission status");
        }
    }

    /**
     * setDeviceState- This method is used to set the device state
     *
     * @param deviceState- String
     * @param udid-        String Date- 14/02/2023
     */
    public void setDeviceState(String deviceState, String udid) {
        try {
            switch (deviceState) {
                case "Locked" -> {
                    toLockDevice(udid);
                    basePage.waitForGivenTime(3);
                    TestUtils.log().info("Device State set as {} ...... ", deviceState);
                }
                case "Unlocked" -> {
                    toUnlockDevice(udid);
                    basePage.waitForGivenTime(3);
                    TestUtils.log().info("Device State set as {} ......", deviceState);
                }
                case "ForcedUnlock" -> {
                    if (DriverManager.getPlatformVersion().equalsIgnoreCase("7") ||
                            DriverManager.getPlatformVersion().equalsIgnoreCase("8") ||
                            DriverManager.getPlatformVersion().equalsIgnoreCase("9")) {
                        if (basePage.toKnowDeviceLockedState()) {
                            toUnlockDevice(udid);
                            basePage.waitForGivenTime(10);
                            if (basePage.toKnowDeviceLockedState()) {
                                toUnlockDevice(udid);
                                basePage.waitForGivenTime(10);
                            }
                            TestUtils.log().info("Device is going to forced unlock");
                        } else {
                            TestUtils.log().info("Device is already unlocked");
                        }
                    } else {
                        if (basePage.toKnowDeviceLockedState()) {
                            toUnlockDevice(udid);
                            basePage.waitForGivenTime(3);
                            if (basePage.toKnowDeviceLockedState()) {
                                toUnlockDevice(udid);
                                basePage.waitForGivenTime(3);
                            }
                            TestUtils.log().info("Device is going to forced unlock");
                        } else {
                            TestUtils.log().info("Device is already unlocked");
                        }
                    }
                }
                default -> TestUtils.log().info("Please enter valid device state  ");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while setting Device state");
        }

    }

    /**
     * getAppState- This method is used to get application state
     *
     * @return- String Date- 14/02/2023
     */
    public String getAppState() {
        String strAppState = "";
        try {
            if ((DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID))
                    || (DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_IOS))) {
                String bundelId = ConfigLoader.getInstance().getiOSBundleID();
                String appPackage = ConfigLoader.getInstance().getAndroidAppPackage();
                if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.RUNNING_IN_FOREGROUND))
                        || (DriverManager.getDriver().queryAppState(bundelId) == (ApplicationState.RUNNING_IN_FOREGROUND))) {
                    TestUtils.log().info("{} Application is running at foreground ", appPackage);
                    strAppState = "Foreground";
                } else if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.RUNNING_IN_BACKGROUND))
                        || (DriverManager.getDriver().queryAppState(bundelId) == (ApplicationState.RUNNING_IN_BACKGROUND))) {
                    TestUtils.log().info("{} Application is running at background ", appPackage);
                    strAppState = "Background";
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting app state");
        }
        return strAppState;
    }

    /**
     * setAppState- This method is used to set the application state
     *
     * @param strAppState-   String
     * @param strAppPackage- String
     * @param strUdid-       String Date- 14/02/2023
     */
    public void setAppState(String strAppState, String strAppPackage, String strUdid) {
        try {
            if (getAppState().equalsIgnoreCase(strAppState)) {
                TestUtils.log().info("Application is already running in {} state", strAppState);
            } else {
                switch (strAppState) {
                    case "Foreground" -> {
                        sendAppToForeground(strAppPackage, strUdid);
                        TestUtils.log().info("Application set to {} state ", strAppState);
                    }
                    case "Background" -> {
                        sendAppToBackground(strUdid);
                        TestUtils.log().info("Application running  in {}", strAppState);
                    }
                    case "Killed" -> {
                        KillApp();
                        TestUtils.log().info("Application running  in {}", strAppState);
                    }

                    default -> {
                        TestUtils.log().info("Please provide correct input");
                    }
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while app is running in {} .... ", strAppState,e);
        }
    }

    private final Object lock = new Object();

    private void KillApp() {
        try {
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
            driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
            synchronized (lock) {
                lock.wait(1000); // Wait for 1 second
            }
            String platformVersion = DriverManager.getPlatformVersion();
            TestUtils.log().info("Platform Version: " + platformVersion);

            if (platformVersion.equalsIgnoreCase("14")) {
                MobileElement clear14 = (MobileElement) driver.findElement(By.id("com.sec.android.app.launcher:id/clear_all"));
                basePage.waitForVisibility(clear14);
                clear14.click();
            } else if (platformVersion.equalsIgnoreCase("13")) {
                MobileElement clear13 = (MobileElement) driver.findElement(By.id("com.sec.android.app.launcher:id/clear_all_button"));
                basePage.waitForVisibility(clear13);
                clear13.click();
            } else if (platformVersion.equalsIgnoreCase("12")) {
                driver.closeApp();
            }else {
                TestUtils.log().info("Please provide correct input..");
            }

            TestUtils.log().info("Application is killed.....");
        } catch (NoSuchElementException e) {
            TestUtils.log().info("Element not found: ", e);
        } catch (IllegalMonitorStateException e) {
            TestUtils.log().info("Illegal Monitor State Exception: ", e);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurs on killing the app....", e);
        }
    }


    public void sendAppToForeground(String strAppPackage, String strUdid) {
        StringBuilder info = new StringBuilder();
        try {
            String appPackage = ConfigLoader.getInstance().getAndroidAppPackage();
            String udid = (String) DriverManager.getDriver().getCapabilities().getCapability("udid");
//            String adbPath = basePage.getADBPath();
//            String adbPath = "/opt/homebrew/bin/adb";
            String adbPath = ConfigLoader.getInstance().getAdbPath();
            String[] command = { adbPath, "-s", udid, "shell", "monkey", "-p", appPackage, "1" };

            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true); // Redirect error stream to input stream

            Process process = processBuilder.start();
            int exitCode = process.waitFor(); // Wait for the process to complete

            if (exitCode == 0) {
                InputStream is = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    info.append(line).append("\n");
                }

                is.close();
                TestUtils.log().info("Application is successfully brought to the foreground");
            } else {
                // Capture error stream
                InputStream errorStream = process.getErrorStream();
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));

                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    TestUtils.log().error("Error: {}", errorLine);
                }

                TestUtils.log().error("Failed to bring app to foreground. Exit code: {}", exitCode);
            }
        } catch (Exception e) {
            TestUtils.log().error("Exception while bringing app to foreground: ", e);
        }
    }





    /**
     * sendAppToBackground-This method is used to send application in background state
     *
     * @param udid - String
     * @return- String Date- 14/02/2023
     */

//    public String sendAppToBackground(String udid) {
//        String str = null;
//        StringBuilder info = new StringBuilder();
//        try {
//            Runtime rt = Runtime.getRuntime();
//            Process p = rt.exec(ADB_COMMAND + udid + "shell input keyevent 3");
//            InputStream is = p.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//
//            str = (reader.readLine());
//            do {
//                info = info.append(str + "\n");
//                str = reader.readLine();
//            } while (str != null);
//            is.close();
//            TestUtils.log().info("Application is successfully send into background");
//        } catch (Exception e) {
//            TestUtils.log().debug("Getting exception while app is running in Background ....");
//        }
//        return info.toString();
//    }

    public void sendAppToBackground(String udid) {
        try{
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
            driver.pressKey(new KeyEvent(AndroidKey.HOME));
        }catch (Exception e){
            TestUtils.log().debug("Getting exception while app is moving to Background ....");
        }
    }



//    public void appState(String appState, AndroidDriver driver){
//        if(appState.equalsIgnoreCase("Background")){
//            driver.runAppInBackground(Duration.ofSeconds(5));
//            TestUtils.log().info("App is running in background state....");
//        } else if (appState.equalsIgnoreCase("Foreground")) {
//            bringAppToForeground(driver, "com.hidglobal.mobilekeys.android.v3");
//            TestUtils.log().info("App is running in Foreground state....");
//        }else{
//            TestUtils.log().info("Please provide correct input");
//        }
//    }
//
    private void bringAppToForeground(AppiumDriver<MobileElement> driver, String appPackage) {

//        String adbPath = basePage.getADBPath();
//        String adbPath = "/opt/homebrew/bin/adb";
        String adbPath = ConfigLoader.getInstance().getAdbPath();
        String appMainActivity = getAppMainActivity(driver);
//        String adbCommand = String.format("%s shell am start -n %s/.%s", adbPath, appPackage, appMainActivity);
        ProcessBuilder processBuilder = new ProcessBuilder(adbPath, "shell", "am", "start", "-n", appPackage + "/." + appMainActivity);
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Application brought to foreground successfully.");
            } else {
                System.err.println("Failed to bring the application to foreground. Exit code: " + exitCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppMainActivity(AppiumDriver<MobileElement> driver) {
        return driver.getCapabilities().getCapability("appActivity").toString();
    }


    public void setDeviceState_Android(String strDeviceState) {
        if (strDeviceState.equalsIgnoreCase("Locked")) {
            lockUnlockDevice();
            basePage.waitForGivenTime(1);
        } else {
            TestUtils.log().info("Device is already in unlocked state....");
        }
    }

    public void setDisplayState(String displayState,String deviceState){
        try{
            if(deviceState.equalsIgnoreCase("Locked")){
                if(displayState.equalsIgnoreCase("On")){
                    AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
                    driver.pressKey(new KeyEvent(AndroidKey.POWER));
                    TestUtils.log().info("Display state is enabled ON....");
                }else{
                    TestUtils.log().info("Display state is already OFF....");
                }
            }else{
                TestUtils.log().info("Device is already in unlocked state and display is ON....");
            }
        }catch(Exception e){
            TestUtils.log().info("Exception while setting the display state....");
        }

    }

    public void lockUnlockDevice() {
        try {
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
            driver.pressKey(new KeyEvent(AndroidKey.POWER));
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while lock or unlock ....");
        }
    }


//    public void forceUnlock(String strDeviceState,String appState) {
//        try{
//            String mobilePin = ConfigLoader.getInstance().getAndroidMobilePin();
//            String appPackage = ConfigLoader.getInstance().getAndroidAppPackage();
//            if (strDeviceState.equalsIgnoreCase("Locked")) {
//                unlockDeviceWithPin(mobilePin);
//                TestUtils.log().info("Device is now in unlocked state....");
//                basePage.waitForGivenTime(1);
//            } else if (strDeviceState.equalsIgnoreCase("Unlocked")) {
//                TestUtils.log().info("Device is already in unlocked state....");
//            } else if(appState.equalsIgnoreCase("Killed")){
//                DriverManager.getDriver().activateApp(appPackage);
//                TestUtils.log().info("Application is launched again....");
//            }else {
//                TestUtils.log().info("Please provide correct input....");
//            }
//            basePage.waitForGivenTime(1);
//
//        }catch(Exception e){
//            TestUtils.log().info("exception.....",e);
//            TestUtils.log().info("Exception While force unlocking the device");
//        }
//
//    }

    public void forceUnlock(String strDeviceState, String appState) {
        String appPackage = null;
        try {
            String mobilePin = ConfigLoader.getInstance().getAndroidMobilePin();
            appPackage = ConfigLoader.getInstance().getAndroidAppPackage();

            // Log input values
            TestUtils.log().info("Device State: " + strDeviceState);
            TestUtils.log().info("App State: " + appState);

            // Check if driver session is valid
            if (DriverManager.getDriver() == null) {
                TestUtils.log().info("Driver session is not initialized.");
                DriverManager.getDriver().activateApp(appPackage);
            }

            if (strDeviceState.trim().equalsIgnoreCase("Locked")) {
                TestUtils.log().info("Device is locked, attempting to unlock with PIN.");
                unlockDeviceWithPin(mobilePin);
                TestUtils.log().info("Device is now in unlocked state....");
                basePage.waitForGivenTime(1);
            } else if (strDeviceState.equalsIgnoreCase("Unlocked")) {
                TestUtils.log().info("Device is already in unlocked state....");
            } else {
                TestUtils.log().info("Please provide correct input....");
            }

            if (appState.equalsIgnoreCase("Killed")) {
                TestUtils.log().info("App is killed, attempting to launch again.");
                unlockDeviceWithPin(mobilePin);
                DriverManager.getDriver().launchApp();
                TestUtils.log().info("Application is launched again..........");
            }
            basePage.waitForGivenTime(1);

        } catch (org.openqa.selenium.NoSuchSessionException e) {
            TestUtils.log().info("No active session found: ", e);
            DriverManager.getDriver().launchApp();
        } catch (Exception e) {
            TestUtils.log().info("Exception while force unlocking the device: ", e);
        }
    }


//
//    public void unlockDeviceWithPin(String pin){
//        try{
//            String adbPath = ConfigLoader.getInstance().getAdbPath();
//            if (adbPath != null) {
//                System.out.println("ADB Path: " + adbPath);
//            } else {
//                System.out.println("ADB Path not found.");
//            }
//                executeCommand(adbPath, "shell", "input", "keyevent", "82");
//                executeCommand(adbPath, "shell", "input", "text", pin);
//                Thread.sleep(1);
//                executeCommand(adbPath, "shell", "input", "keyevent", "66");
//
//        } catch (Exception e) {
//            TestUtils.log().info("Exception While force unlocking the device  "+e);
//        }
//    }
//

    public void unlockDeviceWithPin(String pin) {
        int retryCount = 3;  // Set the number of retries
        int retryDelay = 2000; // Set delay between retries (in milliseconds)

        while (retryCount > 0) {
            try {
                String adbPath = ConfigLoader.getInstance().getAdbPath();

                if (adbPath != null) {
                    System.out.println("ADB Path: " + adbPath);
                } else {
                    System.out.println("ADB Path not found.");
                    break;  // Exit if ADB Path is not found
                }

                // Check the phone's lock type and status (PIN or Swipe)
                if (isPhoneLocked(adbPath)) {
                    System.out.println("Phone is locked, proceeding to unlock.");

                    // If PIN lock is detected, unlock using PIN
                    if (isPinLock(adbPath)) {
                        unlockWithPin(adbPath, pin);
                    } else {
                        unlockWithSwipe(adbPath);
                    }

                    System.out.println("Device unlocked successfully.");
                    break;  // Exit loop if successful
                } else {
                    System.out.println("Phone is not locked, no need to unlock.");
                    break;  // Exit if no unlocking is needed
                }

            } catch (Exception e) {
                retryCount--;
                TestUtils.log().info("Error while unlocking the device: " + e);

                if (retryCount > 0) {
                    TestUtils.log().info("Retrying... Remaining attempts: " + retryCount);
                    try {
                        Thread.sleep(retryDelay);  // Wait before retrying
                    } catch (InterruptedException ie) {
                        TestUtils.log().error("Error during sleep: " + ie);
                    }
                } else {
                    TestUtils.log().error("Failed to unlock the device after retries.");
                }
            }
        }
    }

    /**
     * Helper method to check if the phone is locked.
     */
    private boolean isPhoneLocked(String adbPath) {
        try {
            // Check if the phone is locked by querying the status (screen lock status)
            String command = adbPath + " shell dumpsys window | grep mCurrentFocus";
            String result = executeCommandAndGetOutput(command); // Modify to capture output of the command

            // Check the result of the command to see if the device is locked
            if (result.contains("Keyguard")) {
                System.out.println("Phone is locked.");
                return true;  // Phone is locked
            } else {
                System.out.println("Phone is unlocked.");
                return false;  // Phone is unlocked
            }

        } catch (Exception e) {
            TestUtils.log().error("Error checking phone status: " + e);
            return false;  // Default to not locked in case of error
        }
    }

    /**
     * Helper method to determine if the phone is locked with a PIN.
     */
    private boolean isPinLock(String adbPath) {
        try {
            // Use the 'dumpsys' to determine if PIN is set as a lock type (this could vary based on device)
            String command = adbPath + " shell dumpsys keyguard | grep 'mSecurity'";  // Look for PIN or Swipe
            String result = executeCommandAndGetOutput(command);

            // If it contains 'PIN', it's locked with a PIN; else it's likely swipe or pattern
            if (result.contains("PIN")) {
                System.out.println("Phone is locked with a PIN.");
                return true;
            } else {
                System.out.println("Phone is locked with Swipe/Pattern.");
                return false;
            }
        } catch (Exception e) {
            TestUtils.log().error("Error checking lock type: " + e);
            return false;  // Default to swipe if error occurs
        }
    }

    /**
     * Unlock method using PIN.
     */
    private void unlockWithPin(String adbPath, String pin) {
        try {
            // Wake up the device (keyevent 82 = Power button)
            executeCommand(adbPath, "shell", "input", "keyevent", "82");

            // Enter the PIN
            executeCommand(adbPath, "shell", "input", "text", pin);

            // Optional sleep to ensure PIN input is processed
            Thread.sleep(1000);

            // Confirm the PIN input (keyevent 66 = Enter)
            executeCommand(adbPath, "shell", "input", "keyevent", "66");

        } catch (Exception e) {
            TestUtils.log().error("Error unlocking with PIN: " + e);
        }
    }

    /**
     * Unlock method using swipe.
     */
    private void unlockWithSwipe(String adbPath) {
        try {
            // Wake up the device (keyevent 82 = Power button)
            executeCommand(adbPath, "shell", "input", "keyevent", "82");

            // Simulate swipe action (this may vary based on device)
            executeCommand(adbPath, "shell", "input", "swipe", "500", "1000", "500", "500");

            // Optional sleep to ensure the swipe input is processed
            Thread.sleep(1000);

        } catch (Exception e) {
            TestUtils.log().error("Error unlocking with swipe: " + e);
        }
    }

    /**
     * Helper method to execute a command and return its output.
     */
    private String executeCommandAndGetOutput(String... command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        process.waitFor();
        return output.toString();
    }

    private static void executeCommand(String... command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();

        // Read the output (if needed)
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Command execution failed with exit code: " + exitCode);
        }
    }



}

