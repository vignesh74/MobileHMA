package com.appium.deviceinfo_action;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.appium.constants.FrameworkConstants;
import com.appium.utils.TestUtils;


public class AndroidDeviceInfo
{
     /**
     * getCpuInfo- This method returns the CPU information of the device
     *
     * @param udid-String
     * @return- String
     *          Date-10/11/2022
     */

    public String getCpuInfo(String udid) {
        StringBuilder info = new StringBuilder();
        String s = null;
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell cat /proc/cpuinfo");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device CPU information as below: ************");
            s = (reader.readLine());

            do {

               info = info.append(s +"\n");
                s = reader.readLine();

            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device CPU details.....");
        }
        return info.toString();

    }

    /**
     * getMemoryInfo- This method returns the memory information of the device
     *
     * @param udid
     * @return- String
     *          Date-10/11/2022
     */
    public String getMemoryInfo(String udid) {
        StringBuilder info = new StringBuilder();
        String s = null;
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell cat /proc/meminfo");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Memory information as below: ************");
            s = (reader.readLine());
            do {
                info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device memory details...");
        }

        return info.toString();
    }

    /**
     * getPixelInfo- This method returns the pixel information if the device
     *
     * @param udid-String
     * @return-String
     *                Date-10/11/2022
     */
    public String getPixelInfo(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell wm size");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Pixel information as below: ************\n");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device pixel details...");
        }
        return info.toString();
    }

    /**
     * getInstalledPackage- This method return the list of the installed package
     *
     * @param udid
     * @return- String
     *          Date-10/11/2022
     */
    public String getInstalledPackage(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell pm list packages");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Package information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device installed package details...");
        }
        return info.toString();

    }

    /**
     * getThirdPartyInstalledPackage- This method returns the list of third party installed package
     *
     * @param udid
     * @return-String
     *                Date-10/11/2022
     */
    public String getThirdPartyInstalledPackage(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell pm list packages -3");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Third Party Package information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting details of third party installed package...");
        }
        return info.toString();

    }

    /**
     * getDeviceConnected-This method returns the list of the
     *
     * @return- String
     *          Date-10/11/2022
     */
    public String getDeviceConnected() {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_DEVICES);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device connected  information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting connected device details...");
        }
        return info.toString();

    }

    /**
     * getDevicewithProductandModel- This method returns the product and model information of the given device
     *
     * @param udid-
     *            String
     * @return-String
     *                Date-10/11/2022
     */
    public String getDevicewithProductandModel(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("adb " + udid + " devices -l");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device information with Product and Model as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device with production and modal details...");
        }
        return info.toString();

    }

    /**
     * getListOfDirectory- This method get the list of the directory present in the device
     *
     * @param udid-String
     * @return- String
     *          Date- 10/11/2022
     */
    public String getListOfDirectory(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell ls");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** list of directory as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting list of directory...");
        }
        return info.toString();
    }

    /**
     * getDeviceState-This method returns the states of the device
     *
     * @param udid-String
     * @return-String
     *                Date-10/11/2022
     */
    public String getDeviceState(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " get-state");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** device state as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while get device state...");
        }
        return info.toString();
    }

    /**
     * getSerialNo- This method return the serial number of the device
     *
     * @param udid-
     *            String
     * @return- String
     *          Date- 10/11/2022
     */
    public String getSerialNo(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " get-serialno");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Serial Number as below: ************");
            s = (reader.readLine());
            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting serial no.....");
        }
        return info.toString();
    }

    /**
     * getDeviceIMEINumber- This returns the IMEI number of the device
     *
     * @param udid-String
     * @return- String
     *          Date-10/11/2022
     */
    public String getDeviceIMEINumber(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell service call iphonesubinfo");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device IMEI Number as below: ************");
            s = (reader.readLine());
            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device IMEI number.....");
        }
        return info.toString();
    }

    /**
     * getNetworkConnectivityDetails-This method returns the network connection details
     *
     * @param udid
     * @return-String
     *                Date-10/11/2022
     */
    public String getNetworkConnectivityDetails(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell netstat");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Network Connectivity Details as below: ************");
            s = (reader.readLine());
            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting network connectivity details.....");
        }
        return info.toString();

    }

    /**
     * getCurrentWorkingDirectory- This method returns name of the current working directory
     *
     * @param udid-String
     * @return- String
     *          Date-10/11/2022
     */
    public String getCurrentWorkingDirectory(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell pwd");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Current Working Directory as below: ************");
            s = (reader.readLine());
            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting current working directory.....");
        }
        return info.toString();
    }

    /**
     * getBatteryStatus- This method returns the device battery information
     *
     * @param udid-String
     * @return- String
     *          Date-10/11/2022
     */
    public String getBatteryStatus(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell dumpsys battery");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Battery information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting battery status...");
        }
        return info.toString();

    }

    /**
     * getPhoneFeatureDetails-This method returns the feature list of device
     *
     * @param udid-String
     * @return-String
     *                Date-10/11/2022
     */
    public String getPhoneFeatureDetails(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND+ udid + " shell pm list features");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Feature Details information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting phone feature details...");
        }
        return info.toString();
    }

    /**
     * getPhoneServices-This method used for the service list information of the given device
     *
     * @param udid-String
     * @return-String
     *                Date-10/11/2022
     */
    public String getPhoneServices(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND+ udid + "shell service list");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Service list information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting phone services...");
        }
        return info.toString();

    }

    /**
     * getProcessStatus-This method returns the process status information of the device
     *
     * @param- udid - String
     * @return-String
     *                Date-10/11/2022
     */
    public String getProcessStatus(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell ps");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device process status information as below: ************");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting process status...");
        }
        return info.toString();
    }

    /**
     * getADBVersion- This method returns the adb version
     *
     * @return-String
     *                Date-10/11/2022
     */
    public String getADBVersion() {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_VERSION);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("{}\n",FrameworkConstants.ADB_VERSION_MESSAGE);
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting ADB version details...");
        }
        return info.toString();
    }

    /**
     * pushdataFromLocaltoDevice- This method copy the file from the local to device location
     *
     * @param udid-String
     * @param localFilePath-String
     * @param deviceFilePath-String
     * @return-String
     *                Date-10/11/2022
     */
    public String pushdataFromLocaltoDevice(String udid, String localFilePath, String deviceFilePath) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " push " + localFilePath + " " + deviceFilePath);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("{} \n",FrameworkConstants.ADB_VERSION_MESSAGE);
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while push data from local to device...");
        }
        return info.toString();
    }

    /**
     * pullfromPhonetoLocal- This method copy a file from device to local
     *
     * @param udid-String
     * @param deviceFilePath-String
     * @param localFilePath-String
     * @return-String
     *                Date-10/11/2022
     */
    public String pullfromPhonetoLocal(String udid, String deviceFilePath, String localFilePath) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " pull " + deviceFilePath + " " + localFilePath);
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("{} \n",FrameworkConstants.ADB_VERSION_MESSAGE);
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while pulling from phone to local...");
        }
        return info.toString();
    }

    /**
     * getDeviceIdleStatus-This method return the device idle status
     *
     * @param udid-String
     * @return-String
     *                Date-10/11/2022
     */
    public String getDeviceIdleStatus(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell dumpsys deviceidle step");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** Device Idle as below: ************\n");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while getting device idle status...");
        }
        return info.toString();

    }



    /**
     * toKillActiveTask- This method kills the all open task in device
     *
     * @param udid-
     *            String
     * @return String
     *         Date-10/11/2022
     */
    public String toKillActiveTask(String udid) {
        String s = null;
        StringBuilder info = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(FrameworkConstants.ADB_COMMAND + udid + " shell am kill-all");
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            TestUtils.log().info("*************** active task killed  ************\n");
            s = (reader.readLine());

            do {
               info = info.append(s +"\n");
                s = reader.readLine();
            } while (s != null);
            is.close();
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while killing active task...");
        }
        return info.toString();
    }

}
