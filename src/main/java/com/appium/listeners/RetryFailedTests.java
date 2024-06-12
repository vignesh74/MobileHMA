/**
 * RetryFailedTests-This class retry to run failed test cases Date-03/11/2022
 */

package com.appium.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.appium.constants.FrameworkConstants.YES;

import com.appium.utils.ConfigLoader;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private int retries = ConfigLoader.getInstance().getRetryFailedTestsCount();

    /**
     * retry-This method will be called once a test method fails.
     * @param-result- ITestResult
     * Date-03/11/2022
     */
    public boolean retry(ITestResult result) {

        boolean value = false;
        if (ConfigLoader.getInstance().getRetryFailedTests().equalsIgnoreCase(YES) && count < retries)
        {
                count++;
                value=true;
        }
        return value;
    }
}
