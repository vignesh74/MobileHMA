/**
 * ExtentManager- This class is used to manage extent report
 * Date-04/11/2022
 */

package com.appium.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager() {
    }

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    /**
     * getExtentTest- This method returns the extent test
     * @return- ExtentTest
     * Date-04/11/2022
     */

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    /**
     * setExtentTest- This method sets the extent test
     * @param test
     * Date-04/11/2022
     */
    static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    /**
     * unload-This method used to remove extent test
     * Date-04/11/2022
     */
    static void unload() {
        extentTest.remove();
    }

}
