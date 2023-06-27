/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author- Rohit Deokar ZipUtils- This class contains the method to zip report folder Date-02/11/2022
 */

package com.appium.utils;

import static com.appium.constants.FrameworkConstants.EXTENT_REPORT_FOLDER_PATH;
import static com.appium.constants.FrameworkConstants.PROJECT_LOCATION;
import static com.appium.constants.FrameworkConstants.ZIPPED_EXTENT_REPORTS_FOLDER_NAME;

import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

public class ZipUtils {

    /**
     * zip- This method is used to zip extent report folder
     * Date-02/11/2022
     */
    public static void zip() {

        ZipUtil.pack(new File(EXTENT_REPORT_FOLDER_PATH),
                new File(ZIPPED_EXTENT_REPORTS_FOLDER_NAME));

        TestUtils.log().info("Zipped ExtentReports folder successfuly");
    }

    public void toZipReport() {
        TestUtils.log().info("FrameworkConstants.getExtentReportFolderPath(): {}",EXTENT_REPORT_FOLDER_PATH);
        TestUtils.log().info("FrameworkConstants.getZipped_ExtentReports_Folder_Name(): {}",ZIPPED_EXTENT_REPORTS_FOLDER_NAME);
        String reportsLocation = PROJECT_LOCATION + "/ExtentReports";
        ZipUtil.pack(new File(reportsLocation), new File("ExtentReports.zip"));

    }

}