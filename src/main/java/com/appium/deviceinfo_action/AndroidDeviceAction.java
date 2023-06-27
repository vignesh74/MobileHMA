/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author- Nishant Rithe AndroidDeviceAction- This class provides action for android like wifi, gps, bluetooth and data ON/OFF Date-24/11/2022
 **/

package com.appium.deviceinfo_action;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import io.appium.java_client.appmanagement.ApplicationState;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.appium.constants.FrameworkConstants.*;
import static com.appium.constants.MessageConstants.EXCEPTION_OCCURRED_MESSAGE;

public class AndroidDeviceAction {
    BasePage basePage = new BasePage();

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
            Process p = rt.exec(" adb -s " + udid + " shell input keyevent 26");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device locked by entring pin ************");
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
     * @param displayStatus-
     *         String
     * @param udid-
     *         String Date- 14/02/2023
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
     * @param locationStatus-
     *         String
     * @param udid-
     *         String Date- 14/02/2023
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
     * @param deviceState-
     *         String
     * @param udid-
     *         String Date- 14/02/2023
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
     * @param strAppState-
     *         String
     * @param strAppPackage-
     *         String
     * @param strUdid-
     *         String Date- 14/02/2023
     */
    public void setAppState(String strAppState, String strAppPackage, String strUdid) {
        try {
            if (getAppState().equalsIgnoreCase(strAppState)) {
                TestUtils.log().info("Application is already running in {} state", strAppState);
            } else {
                switch (strAppState) {
                    case "Foreground" -> {
                        basePage.waitForGivenTime(7);
                        sendAppToForground(strAppPackage, strUdid);
                        TestUtils.log().info("Application set to {} state ", strAppState);
                    }
                    case "Background" -> {
                        TestUtils.log().info("Application running  in {}", strAppState);
                        sendAppToBackground(strUdid);
                    }
                    default -> TestUtils.log().info("Please provide correct app state");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while app is running in {} .... ", strAppState);
        }
    }

    /**
     * sendAppToForeground-This method is used to set application in foreground
     *
     * @param appPackage-
     *         String
     * @param udid-
     *         String
     * @return- String Date- 14/02/2023
     */
    public String sendAppToForground(String appPackage, String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell monkey -p  " + appPackage + " 1");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Application is successfully send into foreground");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while app is running in Foreground ....");
        }
        return info.toString();
    }

    /**
     * sendAppToBackground-This method is used to send application in background state
     *
     * @param udid
     *         - String
     * @return- String Date- 14/02/2023
     */

    public String sendAppToBackground(String udid) {
        String str = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(ADB_COMMAND + udid + " shell input keyevent 3");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            str = (reader.readLine());
            do {
                info = info.append(str + "\n");
                str = reader.readLine();
            } while (str != null);
            is.close();
            TestUtils.log().info("Application is successfully send into background");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while app is running in Background ....");
        }
        return info.toString();
    }

}
