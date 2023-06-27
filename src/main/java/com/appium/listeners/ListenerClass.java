/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author-Brijesh Mishra ListenerClass- This class is used to implements interface ITestListener,ISuiteListener Date-03/11/2022
 */
package com.appium.listeners;

import static com.appium.constants.FrameworkConstants.ICON_BUG;
import static com.appium.constants.FrameworkConstants.ICON_SMILEY_FAIL;
import static com.appium.constants.FrameworkConstants.ICON_SMILEY_PASS;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appium.reports.ExtentLogger;
import com.appium.reports.ExtentReport;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass implements ITestListener, ISuiteListener {

    int countPassedTCs;
     int countSkippedTCs;
     int countFailedTCs;
     int countTotalTCs;

    /**
     * onStart-This is over ridden method of the Isuite listener is used to initializes the extent report
     *
     * @param suite-Isuite
     *         Date-25/11/2022
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    /**
     * onFinish- This is over ridden method of the Isuite listener is used flush the report,zip the extend report and send the email.
     *
     * @param suite-Isuite
     *         Date-25/11/2022
     */
    @Override
    public void onFinish(ISuite suite) throws UnsupportedOperationException {
            //it not flushes the report for BDD
           }

    /**
     * onTestStart-This is over ridden method of the ITestListener which is used to add TestMethod,author,device,category and application details
     *
     * @param-result- ITestResult Date-25/11/2022
     */

    @Override
    public void onTestStart(ITestResult result) {


        countTotalTCs++;
        ExtentReport.createTest(result.getMethod().getMethodName());
        ExtentReport.createTest(result.getMethod().getDescription());

        ExtentReport.addDevices();
        ExtentReport.addApplicationDetails();
    }

    /**
     * onTestSuccess-This is over ridden method of the ITestListener which is used to add success result to report
     *
     * @param-result- ITestResult Date-25/11/2022
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        countPassedTCs++;

        String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>" + "  " + ICON_SMILEY_PASS;
        Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ExtentLogger.pass(markupMessage);

    }

    /**
     * onTestFailure-This is over ridden method of the ITestListener which is used to add failure result to report
     *
     * @param-result- ITestResult Date-25/11/2022
     */
    @Override
    public void onTestFailure(ITestResult result) {
        countFailedTCs = countFailedTCs + 1;
        ExtentLogger.fail(ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());

        String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
                + ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + exceptionMessage.replace(",", "<br>")
                + "</details> \n";
        ExtentLogger.fail(message);

        String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>" + "  " + ICON_SMILEY_FAIL;
        Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.RED);
        ExtentLogger.fail(markupMessage, true);

    }

    /**
     * onTestSkipped-This is over ridden method of the ITestListener which is used to add skipped result to report
     *
     * @param-result- ITestResult Date-25/11/2022
     */
    @Override
    public void onTestSkipped(ITestResult result) {

        countSkippedTCs = countSkippedTCs + 1;

        ExtentLogger.skip(ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
        String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>" + "  " + ICON_SMILEY_FAIL;
        Markup markupMessage = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        ExtentLogger.skip(markupMessage, true);

    }

}
