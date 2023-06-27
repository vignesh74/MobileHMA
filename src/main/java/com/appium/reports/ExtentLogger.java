/**
 # MIT License
 #
 # Organization   eInfochips
 # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED.
 #
 # Permission is hereby granted, free of charge, to any person obtaining a copy
 # of this software and associated documentation files (the "Software"), to deal
 # in the Software without restriction, including without limitation the rights
 # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 # copies of the Software, and to permit persons to whom the Software is
 # furnished to do so, subject to the following conditions:
 #
 # The above copyright notice and this permission notice shall be included in all
 # copies or substantial portions of the Software.
 #
 # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 # LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 # SOFTWARE.
 #
 #              EINFOCHIPS
 #             2025 Gateway Place, Suite #238,
 #              San Jose, CA 95110
 #------------------------------------------------------------------------------------
 *@author Brijesh Mishra
 * ExtentLogger-This class is used for the add pass,fail,skip logs in report
 * Date-04/11/2022
 */

package com.appium.reports;

import static com.appium.constants.FrameworkConstants.YES;

import com.appium.utils.ConfigLoader;
import com.appium.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

public final class ExtentLogger {

    /**
     * ExtentLogger- default constructor
     * Date-04/11/2022
     */
    private ExtentLogger() {
    }

    /**
     * pass- This method is used to add info in the pass step
     * @param message-String
     * Date-04/11/2022
     */
    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    /**
     * pass- This method is used to add info in the pass step
     * @param message-String
     * Date-04/11/2022
     */
    public static void pass(Markup message) {
        ExtentManager.getExtentTest().pass(message);
    }

    /**
     * fail -This method is used to add info in the fail step
     * @param message-String
     * Date-04/11/2022
     */
    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    /**
     * fail -This method is used to add info in the fail step
     * @param message-String
     * Date-04/11/2022
     */
    public static void fail(Markup message) {
        ExtentManager.getExtentTest().fail(message);
    }

    /**
     * fail - This method is used to add info in the fail step
     * @param message-String
     * Date-04/11/2022
     */
    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    /**
     * skip-This method is used to add info in the skip step
     * @param message-String
     * Date-04/11/2022
     */
    public static void skip(Markup message) {
        ExtentManager.getExtentTest().skip(message);
    }

    /**
     * skip-This method is used to add info in the skip step
     * @param message-String
     * Date-04/11/2022
     */
    public static void info(Markup message) {
        ExtentManager.getExtentTest().info(message);
    }

    /**
     * info-This method is used to add info
     * @param message-String
     * Date-04/11/2022
     */
    public static void info(String message) {
        ExtentManager.getExtentTest().info(message);
    }

    /**
     * pass- This method is used to add info and screenshot in pass step
     * @param message-String
     * @param isScreeshotNeeded-boolean
     * Date-04/11/2022
     */
    public static void pass(String message, boolean isScreeshotNeeded) {
        if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreeshotNeeded) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            pass(message);
        }
    }

    /**
     * pass- This method is used to add info and screenshot in pass step
     * @param message-String
     * @param isScreeshotNeeded-boolean
     * Date-04/11/2022
     */
    public static void pass(Markup message, boolean isScreeshotNeeded) {

        if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreeshotNeeded) {

            ExtentManager.getExtentTest().pass(
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().pass(message);
        } else {
            pass(message);
        }
    }

    /**
     * fail- This method is used to add info and screenshot for the fail step
     * @param message-String
     * @param isScreeshotNeeded-boolean
     * Date-04/11/2022
     */
    public static void fail(String message, boolean isScreeshotNeeded) {

        if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreeshotNeeded) {
            ExtentManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            fail(message);
        }
    }

    /**
     * fail- This method is used to add info and screenshot for the fail step
     * @param message-String
     * @param isScreeshotNeeded-boolean
     * Date-04/11/2022
     */
    public static void fail(Markup message, boolean isScreeshotNeeded) {

        if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreeshotNeeded) {

            ExtentManager.getExtentTest().fail(
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().fail(message);
        } else {
            fail(message);
        }
    }

    /**
     * skip- This method used to add info and screenshot for the skip step
     * @param message-String
     * @param isScreeshotNeeded-boolean
     * Date-04/11/2022
     */
    public static void skip(String message, boolean isScreeshotNeeded) {

        if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreeshotNeeded) {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else {
            skip(message);
        }
    }

    /**
     * skip- This method used to add info and screenshot for the skip step
     * @param message-String
     * @param isScreeshotNeeded-boolean
     * Date-04/11/2022
     */
    public static void skip(Markup message, boolean isScreeshotNeeded) {

        if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(YES)
                && isScreeshotNeeded) {
                 ExtentManager.getExtentTest().skip(
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
            ExtentManager.getExtentTest().skip(message);
        } else {
            skip(message);
        }
    }

}
