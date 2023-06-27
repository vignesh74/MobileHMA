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
 * @author Vijyeta Gohil
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
