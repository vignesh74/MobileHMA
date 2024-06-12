/**
 * IOSDeviceInfo - This class contains the method which has different IOS device operation run through command line Date-10/11/2022
 **/
package com.appium.deviceinfo_action;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.appium.base.BasePage;
import com.appium.constants.FrameworkConstants;
import com.appium.utils.TestUtils;

public class IOSDeviceInfo {
    BasePage basepage = new BasePage();

    /**
     * getDeviceConnectedIOS- This method returns the list of IOS device connected
     *
     * @return- String Date-10/11/2022
     */
    public String getDeviceConnectedIOS() {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.XCRUN_SIMCTL_LIST);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** IOS Device connected  information as below: ************");
            s = (reader.readLine());

            do {
                info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting IOS devices connected details...");
        }
        return info.toString();

    }

    /**
     * toStartSimulator- This method used to start the IOS simulator
     *
     * @param devicename-
     *         String
     * @return-String Date-10/11/2022
     */
    public String toStartSimulator(String devicename) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl boot " + devicename);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info(FrameworkConstants.IOS_INFORMATION);
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while to start the simulator...");
        }
        return info.toString();
    }

    /**
     * OpenURLInSimulator- this method used to open specific url into simulator
     *
     * @param url-String
     * @return-String Date-10/11/2022
     */
    public String OpenURLInSimulator(String url) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl openurl booted  " + url);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info(FrameworkConstants.IOS_INFORMATION);
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while opening URL in simulator...");
        }
        return info.toString();

    }

    /**
     * openMapApp- This method used to open the map app in simulator
     *
     * @param mapapp-String
     * @return-String Date-10/11/2022
     */
    public String openMapApp(String mapapp) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl openurl booted  " + mapapp);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info(FrameworkConstants.IOS_INFORMATION);
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while opening MAP app in iOS...");
        }
        return info.toString();
    }

    /**
     * addImageinSimulator-this method used to add image in simulator
     *
     * @param imageLocation-
     *         String
     * @return-String Date-10/11/2022
     */
    public String addImageinSimulator(String imageLocation) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl addmedia booted  " + imageLocation);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info(FrameworkConstants.IOS_INFORMATION);
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while adding image in simulator...");
        }
        return info.toString();
    }

    /**
     * toTakeScreenshotinSimulator-This method used to take screenshot of the current screen of the simulator
     *
     * @param imageLocation-String
     * @return-String Date-10/11/2022
     */
    public String toTakeScreenshotinSimulator(String imageLocation) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl io booted screenshot " + imageLocation);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info(FrameworkConstants.IOS_INFORMATION);
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while taking screenshot in simulator...");
        }
        return info.toString();
    }

    /**
     * addVideoinSimulator- This method used to add video in simulator
     *
     * @param videoLocation-String
     * @return-String Date-10/11/2022
     */
    public String addVideoinSimulator(String videoLocation) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl io booted recordVideo  " + videoLocation);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** IOS Device information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while adding video in simulator...");
        }
        return info.toString();
    }

    /**
     * addCertificateinSimulator- This method used to add certificate in the simulator
     *
     * @param certName-String
     * @return-String Date-10/11/2022
     */
    public String addCertificateinSimulator(String certName) {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl keychain booted add-root-cert   " + certName);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** IOS Device information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while adding certificate in simulator...");
        }
        return info.toString();
    }

    /**
     * pushdatatoIOSDevice- This method used to copy file in simulator
     *
     * @param devicename-String
     * @param bundleId-String
     * @param apnsFileName-String
     * @return-String Date-10/11/2022
     */
    public String pushdatatoIOSDevice(String devicename, String bundleId, String apnsFileName) {

        //	xcrun simctl push <SIMULATOR_DEVICE_ID> <YOUR_APP_BUNDLE_ID> <APNS_FILE_NAME>
        //xcrun simctl push A0AF405F-FE73-45DA-8D7D-F1FE37821992 com.example.my-app test.apns

        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("xcrun simctl push " + devicename + " " + bundleId + " " + apnsFileName);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("***************push command  information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while pushing data to iOS device...");
        }
        return info.toString();

    }

    /**
     * getHelpForSimulator-This method used to get any help for command.
     *
     * @return-String Date-10/11/2022
     */
    public String getHelpForSimulator() {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.XCRUN_SIMCTL_HELP);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("***************help command  information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting help for simulator...");
        }
        return info.toString();

    }

    /**
     * getRealDeviceUDID-This method used to get udid of the IOS device
     *
     * @return-String Date-10/11/2022
     */
    public String getRealDeviceUDID() {
        String s = null;
         StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.IOS_DEVICE_ID);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().debug("*************** information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s + "\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting real device UDID...");
        }
        return info.toString();
    }

    /**
     * setDeviceState- This method used to set the application status
     *
     * @param deviceState-String
     *         Date-10/11/2022
     */
    public void setIOSDeviceState(String deviceState) {
        try {
            switch (deviceState) {
                case "Locked" -> {
                    basepage.toLock();
                    TestUtils.log().info("Device State set as {} ",deviceState);
                } case "Unlocked" -> {
                    basepage.toUnlock();
                    TestUtils.log().info("Device State set as {} ",deviceState);
                } case "ForcedUnlock" -> {
                    if (basepage.toKnowDeviceLockedState()) {
                        basepage.toUnlock();
                        basepage.waitForGivenTime(1);
                        TestUtils.log().info("Device is going to Forced Unlock");
                    } else {
                        TestUtils.log().info("Device is already unlocked");
                    }
                }
                default -> TestUtils.log().info("Please provide correct device state");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while setting device status to {} ...",deviceState);
        }
    }
}

