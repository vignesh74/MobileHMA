/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author - Vijyeta Gohil ConfigLoader- This class contains the methods to load config.properties file Date-02/11/2022
 */

package com.appium.utils;

import com.appium.exceptions.AutomationException;

import java.util.Properties;

import static com.appium.constants.FrameworkConstants.RESOURCES_MAIN_PATH;

/*Singleton Design pattern*/
public class ConfigLoader {

    private static final String SEND_EMAIL_TO_USERS = "send_email_to_users";
    private static final String OVERRIDE_REPORTS = "override_reports";
    private static final String SKIPPED_STEPS_SCREENSHOT = "skipped_steps_screenshot";
    private static final String PASSED_STEPS_SCREENSHOT = "passed_steps_screenshot";
    private static final String FAILED_STEPS_SCREENSHOT = "failed_steps_screenshot";
    private static final String RETRY_FAILED_TESTS = "retry_failed_tests";

    private static final String RETRY_FAILED_TESTS_COUNT = "retry_failed_tests_count";

    private static final String FAILED_TESTS_VIDEO = "failed_tests_video";
    private static final String PASSED_TESTS_VIDEO = "passed_tests_video";
    private static final String SKIPPED_TESTS_VIDEO = "skipped_tests_video";

    private static final String BASE64SCREENSHOT_NEEDED = "base64screenshot_needed";

    private static final String APPIUM_URL = "appiumURL";
    private static final String APPIUM_GRID_URL = "appiumGridURL";
    private static final String ANDROID_AUTOMATION_NAME = "androidAutomationName";
    private static final String ANDROID_APP_PACKAGE = "androidAppPackage";
    private static final String ANDROID_APP_ACTIVITY = "androidAppActivity";
    private static final String ANDROID_APP_LOCATION = "androidAppLocation";

    private static final String ANDROID_APP_LOCATION_NEW = "androidAppLocationNew";
    private static final String IOS_AUTOMATION_NAME = "iOSAutomationName";
    private static final String IOS_BUNDLE_ID = "iOSBundleId";
    private static final String IOS_HOME_BUNDLE_ID = "iOSHomeBundleId";
    private static final String IOS_APP_LOCATION = "iOSAppLocation";

    private static final String CONFIG_PROPERTIES = "config.properties";
    private static ConfigLoader configLoader;
    private Properties properties;

    private static final String ADB_PATH = "adbPath";

    private static final String ANDROID_MOBILE_PIN = "androidMobilePin";
    private static final String BASE_URL_TESTRAIL = "baseUrlTestRail";
    private static final String USERNAME_TESTRAIL = "usernameTestRail";
    private static final String APIKEY_TESTRAIL = "apiKeyTestRail";
    private static final String TESTRUN_TESTRAIL = "testRunTestRail";

    /**
     * ConfigLoader- Constructor load the config.properties Date-02/11/2022
     */
    private ConfigLoader() {
        properties = getConfigPropertyFile(CONFIG_PROPERTIES);
    }

    /**
     * getInstance-This method returns the instance of the config loader
     *
     * @return- ConfigLoader Date-02/11/2022
     */
    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    /**
     * getConfigPropertyFile-This method gets the property file
     *
     * @param configFile-
     *         String
     * @return- Properties Date-02/11/2022
     */
    private Properties getConfigPropertyFile(String configFile) {
        return PropertyUtils.propertyLoader(RESOURCES_MAIN_PATH + configFile);
    }

    /**
     * getPropertyValue- This method returns the property value
     *
     * @param propertyKey-
     *         String
     * @return- String Date-02/11/2022
     */
    private String getPropertyValue(String propertyKey) {
        String prop = properties.getProperty(propertyKey);
        if (prop != null) {
            return prop.trim();
        } else {
            throw new AutomationException("Property " + propertyKey + " is not specified in the config.properties file");
        }
    }

    /**
     * getAppiumURL- This method returns the appium url
     *
     * @return- String Date-02/11/2022
     */
    public String getAppiumURL() {
        return getPropertyValue(APPIUM_URL);
    }

    /**
     * getAppiumGridURL- This method returns the appium grid url
     *
     * @return- String Date-02/11/2022
     */
    public String getAppiumGridURL() {
        return getPropertyValue(APPIUM_GRID_URL);
    }

    /**
     * getAndroidAutomationName- This method returns the android automation name
     *
     * @return- String Date-02/11/2022
     */
    public String getAndroidAutomationName() {
        return getPropertyValue(ANDROID_AUTOMATION_NAME);
    }

    /**
     * getAndroidAppPackage- This method returns the android app package
     *
     * @return- String Date-02/11/2022
     */
    public String getAndroidAppPackage() {
        return getPropertyValue(ANDROID_APP_PACKAGE);
    }

    /**
     * getAndroidAppActivity- This method returns the android app activity
     *
     * @return- String Date-02/11/2022
     */
    public String getAndroidAppActivity() {
        return getPropertyValue(ANDROID_APP_ACTIVITY);
    }

    /**
     * getAndroidApplocation- This method returns the android app location
     *
     * @return- String Date-02/11/2022
     */
    public String getAndroidApplocation() {
        return getPropertyValue(ANDROID_APP_LOCATION);
    }

    public String getAndroidAppLocationNew(){
        return getPropertyValue(ANDROID_APP_LOCATION_NEW);
    }

    /**
     * getiOSAutomationName- This method returns the IOS automation name
     *
     * @return- String Date-02/11/2022
     */
    public String getiOSAutomationName() {
        return getPropertyValue(IOS_AUTOMATION_NAME);
    }

    /**
     * getiOSBundleID- This method returns the IOS bundle id
     *
     * @return- String Date-02/11/2022
     */
    public String getiOSBundleID() {
        return getPropertyValue(IOS_BUNDLE_ID);
    }

    /**
     * getiOSAppLocation- This method returns the IOS app location
     *
     * @return- String Date-02/11/2022
     */
    public String getiOSAppLocation() {
        return getPropertyValue(IOS_APP_LOCATION);
    }

    /**
     * getFailedStepsScreenshot- This method gets the value of failed step screenshot
     *
     * @return- String Date-02/11/2022
     */
    public String getFailedStepsScreenshot() {
        return getPropertyValue(FAILED_STEPS_SCREENSHOT);
    }

    /**
     * getPassedStepsScreenshot- This method gets the value of passed step screenshot
     *
     * @return- String Date-02/11/2022
     */
    public String getPassedStepsScreenshot() {
        return getPropertyValue(PASSED_STEPS_SCREENSHOT);
    }

    /**
     * getSkippedStepsScreenshot- This method gets the value of skipped step screenshot
     *
     * @return- String Date-02/11/2022
     */
    public String getSkippedStepsScreenshot() {
        return getPropertyValue(SKIPPED_STEPS_SCREENSHOT);
    }

    /**
     * getRetryFailedTests- This method returns the value of retry failed tests
     *
     * @return- String Date-02/11/2022
     */
    public String getRetryFailedTests() {
        return getPropertyValue(RETRY_FAILED_TESTS);
    }

    /**
     * getRetryFailedTestsCount- This method returns the value of retry failed tests count
     *
     * @return- Integer Date-07/02/2023
     */
    public int getRetryFailedTestsCount() {

        return Integer.parseInt(getPropertyValue(RETRY_FAILED_TESTS_COUNT));
    }

    /**
     * getOverrideReports- This method returns the value of override reports
     *
     * @return- String Date-02/11/2022
     */
    public String getOverrideReports() {
        return getPropertyValue(OVERRIDE_REPORTS);
    }

    /**
     * getSendEmailToUsers- This method returns the value of sent emails to users
     *
     * @return- String Date-02/11/2022
     */
    public String getSendEmailToUsers() {
        return getPropertyValue(SEND_EMAIL_TO_USERS);
    }

    /**
     * getFailedTestsVideo- This method returns the value of failed tests video
     *
     * @return- String Date-02/11/2022
     */
    public String getFailedTestsVideo() {
        return getPropertyValue(FAILED_TESTS_VIDEO);
    }

    /**
     * getPassedTestsVideo- This method returns the value of passed tests video
     *
     * @return- String Date-02/11/2022
     */
    public String getPassedTestsVideo() {
        return getPropertyValue(PASSED_TESTS_VIDEO);
    }

    /**
     * getSkippedTestsVideo- This method returns the value of skipped tests video
     *
     * @return- String Date-02/11/2022
     */
    public String getSkippedTestsVideo() {
        return getPropertyValue(SKIPPED_TESTS_VIDEO);
    }

    /**
     * getBase64Screenshot- This method return the base64 screenshot flag
     *
     * @return- String Date-02/11/2022
     */
    public String getBase64Screenshot() {
        return getPropertyValue(BASE64SCREENSHOT_NEEDED);
    }

    /**
     * getiOSBundleID- This method returns the IOS bundle id apple home
     *
     * @return- String Date-02/11/2022
     */
    public String getiOSHomeBundleId() {
        return getPropertyValue(IOS_HOME_BUNDLE_ID);
    }

    public String getAdbPath(){
        return getPropertyValue(ADB_PATH);
    }

    public String getAndroidMobilePin(){
        return getPropertyValue(ANDROID_MOBILE_PIN);
    }

    public String getBaseUrlTestRail(){
        return getPropertyValue(BASE_URL_TESTRAIL);
    }

    public String getUsernameTestRail(){
        return getPropertyValue(USERNAME_TESTRAIL);
    }
    public String getApikeyTestRail(){ return getPropertyValue(APIKEY_TESTRAIL);
    }
    public String getTestRunTestRail(){ return getPropertyValue(TESTRUN_TESTRAIL);
    }

}
