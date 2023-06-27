/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author- Rohit Deokar FrameworkConstants- All constants are declared in this class Date-02/11/2022
 */

package com.appium.constants;

import com.appium.utils.ConfigLoader;
import com.appium.utils.OSInfoUtils;
import com.appium.utils.UsernameUtils;

import java.io.File;
import java.util.Date;

public class FrameworkConstants {

    public static final String PROJECT_LOCATION = System.getProperty("user.dir");
    public static final String RESOURCES_MAIN_PATH = PROJECT_LOCATION + "/src/main/resources/";
    public static final String RESOURCES_TEST_PATH = PROJECT_LOCATION + "/src/test/resources/";
    /* ICONS - START */
    public static final String ICON_SMILEY_PASS = "<i class='fa fa-smile-o' style='font-size:24px'></i>";
    public static final String ICON_SMILEY_SKIP = "<i class=\"fas fa-frown-open\"></i>";
    public static final String ICON_SMILEY_FAIL = "<i class='fa fa-frown-o' style='font-size:24px'></i>";
    public static final String ICON_BUG = "<i class='fa fa-bug' ></i>";
    public static final String ICON_LAPTOP = "<i class='fa fa-laptop' style='font-size:18px'></i>";
    public static final String ICON_MOBILE = "<i class='fa fa-mobile-phone' style='font-size:24px'></i>";
    public static final String ASSERTION_FOR = "Assertion for ";
    /* ICONS - END */
    public static final String LOGS = "artifacts" + File.separator + "logs";
    public static final String EXTENT_REPORT_NAME = "AutomationReport.html";
    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_LOCATION + "artifacts";
    /** Zip file of Extent Reports */
    public static final String ZIPPED_EXTENT_REPORTS_FOLDER_NAME = "ExtentReports.zip";
    public static final String PROJECT_NAME = "Automation Test Suite Report - Master Appium Framework";
    public static final String TEXT = "text";
    public static final String LABEL = "label";
    public static final long EXPLICIT_WAIT = 10;
    public static final String APPIUM_SERVER_LOGS = "artifacts/serverLogs/server.log";
    public static final String SERVER_LOGS = "artifacts/serverLogs";
    /* Log4J2 */
    public static final String ROUTINGKEY = "ROUTINGKEY";
    public static final String PLATFORM_ANDROID = "Android";
    public static final String PLATFORM_IOS = "iOS";
    public static final String TEST_DATA_JSON_FILE = "data/loginUsers.json";
    public static final String TEST_DATA_JSON_INVALID_USER = "invalidUser";
    public static final String TEST_DATA_JSON_INVALID_PASSWORD = "invalidPassword";
    public static final String TEST_DATA_JSON_VALID_USER = "validUser";
    public static final String TEST_DATA_JSON_USERNAME = "username";
    public static final String TEST_DATA_JSON_PASSWORD = "password";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String YES = "yes";
    public static final String NO = "no";
    /* Expected Data - START */
    public static final String EXPECTED_DATA_XML_FILE = "strings/strings.xml";
    public static final String EXPECTED_DATA_KEY_ERR_INAVLID_CREDENTIALS = "err_invalid_username_or_password";
    public static final String EXPECTED_DATA_KEY_PRODUCT_TITLE = "product_title";
    public static final String EXPECTED_DATA_KEY_PRODUCTS_PAGE_SLB_TITLE = "products_page_slb_title";
    public static final String EXPECTED_DATA_KEY_PRODUCTS_PAGE_SLB_DESCRIPTION = "products_details_page_slb_description";
    public static final String EXPECTED_DATA_KEY_PRODUCTS_PAGE_SLB_PRICE = "products_page_slb_price";
    /* COMMON for Android and iOS */
    public static final String CAPABILITY_APP = "app";
    /* ANDROID */
    public static final String CAPABILITY_ANDROID_APP_PACKAGE = "appPackage";
    /* Expected Data - END */

    /* Capabilities - START */
    public static final String CAPABILITY_ANDROID_APP_ACTIVITY = "appActivity";
    public static final String CAPABILITY_ANDROID_SYSTEM_PORT = "systemPort";
    public static final String CAPABILITY_ANDROID_CHROME_DRIVER_PORT = "chromeDriverPort";
    public static final String CAPABILITY_ANDROID_AVD = "avd";
    /* iOS */
    public static final String CAPABILITY_IOS_BUNDLE_ID = "bundleId";
    public static final String CAPABILITY_IOS_WDA_LOCAL_PORT = "wdaLocalPort";
    public static final String CAPABILITY_IOS_WEBKIT_DEBUG_PROXY_PORT = "webkitDebugProxyPort";
    /* Platform specific - START */
    /* WINDOWS */
    public static final String PLATFORM_OS_WIN = "win";
    public static final String PLATFORM_OS_WIN_NODE_INSTALLATION_PATH = "C:\\Program Files\\nodejs\\node.exe";// Cmd -> where node

    /* Capabilities - END */
    public static final String PLATFORM_OS_WIN_APPIUM_INSTALLATION_PATH = "C:\\Users\\" + UsernameUtils.getUserName()
            + "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
    /* MAC */
    public static final String PLATFORM_OS_MAC = "mac";
    public static final String PLATFORM_OS_MAC_NODE_INSTALLATION_PATH = "/opt/homebrew/bin/node";// Terminal -> where node
    public static final String PLATFORM_OS_MAC_APPIUM_INSTALLATION_PATH = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";// Terminal -> where appium
    public static final String PLATFORM_OS_MAC_VAR_PATH_VALUE = "/Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin:/Users/" + UsernameUtils.getUserName() + "/Library/Android/sdk/tools:/Users/" + UsernameUtils.getUserName() + "/Library/Android/sdk/platform-tools:/opt/homebrew/bin:/opt/homebrew/sbin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin"; // Terminal
    /* echo
     $PATH */
    public static final String PLATFORM_OS_MAC_VAR_ANDROID_HOME_VALUE = "/Users/" + UsernameUtils.getUserName() + "/Library/Android/sdk";
    public static final String PATH = "PATH";
    public static final String ANDROID_HOME = "ANDROID_HOME";
    /* LINUX */
    public static final String PLATFORM_OS_NUX = "nux";
    /* simultor /emulator variable */
    public static final String DEVICEFILEPATH = "/storage/emulated/0/Android/data";
    public static final String URLSIMULATOR = "https://www.google.com";
    /* Platform specific - END */
    public static final String MAPAPP = "https://www.google.co.in/maps/";
    public static final String IMAGELOCATION = PROJECT_LOCATION + "/src/test/resources/data/test.jpg";
    public static final String LOCAL_FILE_PATH = PROJECT_LOCATION + "/src/test/resources/data/";
    public static final String VIDEOLOCATION = PROJECT_LOCATION + "/src/test/resources/data/CalenderTest.mp4";
    public static final String CERTNAME = "mycertificate.cer";
    public static final String BUDNLEID = "com.example.my-app";
    public static final String APNFILENAME = "test.apns";
    public static final String PIN = "290518";
    public static final String DEEP_LINK_URL = "https://portal.origo.hidglobal.com/mi/auth/populateInvitationCodeInMobileApp?invitationCode=";
    public static final String PORT_NAME = "/dev/tty.usbserial-14340";

    /** ADB Commands */
    public static final String ADB_DEVICES = "adb devices";
    public static final String ADB_VERSION = "adb version";
    public static final String XCRUN_SIMCTL_LIST = "xcrun simctl list";
    public static final String XCRUN_SIMCTL_HELP = "xcrun simctl help";
    public static final String IOS_DEVICE_ID = "idevice_id -l";

    public static final String ADB_COMMAND=" adb -s ";
    public static final String ADB_VERSION_MESSAGE="*************** ADB version as below: ************";
    public static final String IOS_INFORMATION="*************** IOS Device information as below: ************";

    public static final String DESCRIPTIVEPORTNAME ="USB2.0-Serial";

    // Rest API and Robotic Arms Variables
    private static String extentReportFilePath = "";

    /**
     * Constructor Date-02/11/2022
     */
    private FrameworkConstants() {
    }

    /**
     * getExtentReportFilePath- This method returns the extent report file path
     *
     * @return- String Date-02/11/2022
     */
    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    /**
     * createReportPath- This method returns the extent report folder path and report name
     *
     * @return- String Date-02/11/2022
     */
    private static String createReportPath() {

        if (ConfigLoader.getInstance().getOverrideReports().equalsIgnoreCase(NO)) {

            return EXTENT_REPORT_FOLDER_PATH + OSInfoUtils.getOSInfo() + "_" + getCurrentDate() + "_"
                    + EXTENT_REPORT_NAME;
        } else {
            return EXTENT_REPORT_FOLDER_PATH + EXTENT_REPORT_NAME;
        }
    }

    /**
     * getCurrentDate- This method returns current date
     *
     * @return- String Date-02/11/2022
     */
    private static String getCurrentDate() {
        Date date = new Date();
        return date.toString().replace(":", "_").replace(" ", "_");
    }
}
