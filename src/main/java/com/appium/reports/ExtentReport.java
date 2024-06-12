/**
 * ExtentReport-This class contain methods to generate extent report Date-04/11/2022
 */

package com.appium.reports;

import static com.appium.constants.FrameworkConstants.ICON_MOBILE;
import static com.appium.constants.FrameworkConstants.PROJECT_NAME;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.appium.constants.FrameworkConstants;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.manager.DriverManager;
import com.appium.utils.ApplicationInfoUtils;
import com.appium.utils.TestUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {

    private static ExtentReports extent;

    /**
     * ExtentReport- This is the default constructor Date-04/11/2022
     */
    private ExtentReport() {
    }

    /**
     * initReports-This method initialize the extent report. It used to add system information in the extent report Date-04/11/2022
     */
    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            spark.getExecuted();
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle(PROJECT_NAME + " - ALL");
            spark.config().setReportName(PROJECT_NAME + " - ALL");
            extent.setSystemInfo("Organization", "HID Global LTD");
            extent.setSystemInfo("Employee", "Rajasekar Akkayasamy");
            extent.setSystemInfo("ProjectName", "HID Global");
            extent.setSystemInfo("ApplicationType", "Mobile");
            extent.setSystemInfo("SupportPlatform", "Android/iOS");
        }
    }

    /**
     * flushReports- This method is used to flush the report. Erases any previous data on a relevant report and creates a whole new report. flush method writes/updates the test information for report. Date-04/11/2022
     */
    public static void flushReports() {

        if (Objects.nonNull(extent)) {
            extent.flush();
        }

        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException ignored) {
            TestUtils.log().debug("IOException Occurred ....");
        }
    }

    /**
     * createTest-This method adds the test name in extent report
     *
     * @param testCaseName-String
     *         Date-04/11/2022
     */
    public static void createTest(String testCaseName) {
        ExtentManager.setExtentTest(extent.createTest(ICON_MOBILE + " : " + testCaseName));
    }

    /**
     * addAuthors- This method is used to add author in extent report
     *
     * @param authors-String
     *         Date-04/11/2022
     */
    public static synchronized void addAuthors(AuthorType[] authors) {
        for (AuthorType author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author.toString());
        }
    }

    /**
     * addCategories-This method is used to categories in extent report
     *
     * @param categories-String
     *         Date-04/11/2022
     */

    public static synchronized void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentManager.getExtentTest().assignCategory(category.toString());

        }

    }

    /**
     * addDevices-This method is used to add devices,platform,platform version in extent report Date-24/11/2022
     */
    public static synchronized void addDevices() {
        ExtentManager.getExtentTest().assignDevice(DriverManager.getPlatform() + ":"
                + DriverManager.getDeviceName() + ":"
                + "V" + "-" + DriverManager.getPlatformVersion());
    }

    /**
     * addApplicationDetails-This method used to add the working application version Date-24/11/2022
     */
    public static synchronized void addApplicationDetails() {
        ExtentManager.getExtentTest().info(MarkupHelper
                .createLabel("ApplicationVersion-" + ApplicationInfoUtils.getVersionName(), ExtentColor.INDIGO));
    }

}
