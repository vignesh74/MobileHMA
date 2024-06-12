/**
 * ZipUtils- This class contains the method to zip report folder Date-02/11/2022
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