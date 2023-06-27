package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterScreenPage extends BasePage {

    /**
     * object created to access methods from page classes  Date- 25/1/2023
     */
    IOS_HIDHelpCenterActivityLogScreenPage activityLogScreen = new IOS_HIDHelpCenterActivityLogScreenPage();
    IOS_HIDHelpCenterAboutScreenPage aboutScreen = new IOS_HIDHelpCenterAboutScreenPage();
    IOS_HIDHelpCenterLegalScreenPage termAndConditionScreen = new IOS_HIDHelpCenterLegalScreenPage();
    IOS_HIDHelpCenterSupportScreenPage supportScreen = new IOS_HIDHelpCenterSupportScreenPage();

    /**
     * mobile elements - These are mobile elements which is present in Help Center Page Date-25/1/2023
     */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Help Centre\"]")
    private MobileElement txtHelpCenter;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    private MobileElement imgBackFromHelpCenter;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"helpCenterSupport\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Support\"]", priority = 1)
    private MobileElement imgHelpCenterSupport;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Support']//following-sibling:: XCUIElementTypeStaticText[@name='Support']", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Support\"]", priority = 1)
    private MobileElement txtHelpCenterSupport;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Support']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Support\"]", priority = 1)
    private MobileElement imgArrowHelpCenterSupport;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"helpCenterActivityLog\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activity Log\"]", priority = 1)
    private MobileElement imgHelpCenterActivityLog;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Activity Log']//following-sibling:: XCUIElementTypeStaticText[@name='Activity Log']", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activity Log\"]", priority = 1)
    private MobileElement txtHelpCenterActivityLog;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Activity Log']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activity Log\"]", priority = 1)
    private MobileElement imgArrowHelpCenterActivityLog;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"helpCenterAbout\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About\"]", priority = 1)
    private MobileElement imgHelpCenterAbout;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='About']//following-sibling:: XCUIElementTypeStaticText[@name='About']", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About\"]", priority = 1)
    private MobileElement txtHelpCenterAbout;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='About']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About\"]", priority = 1)
    private MobileElement imgArrowHelpCenterAbout;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"helpCenterLegal\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Terms of Use and Privacy Notice\"]", priority = 1)
    private MobileElement imgHelpCenterLegal;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms of Use and Privacy Notice\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Terms of Use and Privacy Notice\"]", priority = 1)
    private MobileElement txtHelpCenterLegal;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='Terms of Use and Privacy Notice']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Terms of Use and Privacy Notice\"]", priority = 1)
    private MobileElement imgArrowHelpCenterLegal;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DIAGNOSTICS\"]")
    private MobileElement txtHelpCenterDiagnostics;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Log file\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Log file\"]", priority = 1)
    private MobileElement txtHelpCenterLogFile;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Log file\"]|/XCUIElementTypeSwitch", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Log file\"]", priority = 1)
    private MobileElement tglBtnHelpCenterLogFile;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */
    public MobileElement getTxtHelpCenter() {
        return txtHelpCenter;
    }

    public MobileElement getImgBackFromHelpCenter() {
        return imgBackFromHelpCenter;
    }

    public MobileElement getImgArrowHelpCenterSupport() {
        return imgArrowHelpCenterSupport;
    }

    public MobileElement getTxtHelpCenterSupport() {
        return txtHelpCenterSupport;
    }

    public MobileElement getImgHelpCenterSupport() {
        return imgArrowHelpCenterSupport;
    }

    public MobileElement getImgArrowHelpCenterActivityLog() {
        return imgArrowHelpCenterActivityLog;
    }

    public MobileElement getTxtHelpCenterActivityLog() {
        return txtHelpCenterActivityLog;
    }

    public MobileElement getImgHelpCenterActivityLog() {
        return imgArrowHelpCenterActivityLog;
    }

    public MobileElement getImgArrowHelpCenterAbout() {
        return imgArrowHelpCenterAbout;
    }

    public MobileElement getTxtHelpCenterAbout() {
        return txtHelpCenterAbout;
    }

    public MobileElement getImgHelpCenterAbout() {
        return imgArrowHelpCenterAbout;
    }

    public MobileElement getImgArrowHelpCenterLegal() {
        return imgArrowHelpCenterLegal;
    }

    public MobileElement getTxtHelpCenterLegal() {
        return txtHelpCenterLegal;
    }

    public MobileElement getImgHelpCenterLegal() {
        return imgArrowHelpCenterLegal;
    }

    public MobileElement getTxtHelpCenterDiagnostics() {
        return txtHelpCenterDiagnostics;
    }

    public MobileElement getTxtHelpCenterLogFile() {
        return txtHelpCenterLogFile;
    }

    public MobileElement getTglBtnHelpCenterLogFile() {
        return tglBtnHelpCenterLogFile;
    }

    /**
     * isHelpCenterScreenDisplayed- This method is used to verify the help center screen is displayed or not Date-25/1/2023
     */
    public void isHelpCenterScreenDisplayed() {
        try {
            waitForVisibility(txtHelpCenter);
            Assert.assertTrue(isElementVisible(txtHelpCenterSupport));
            Assert.assertTrue(isElementVisible(txtHelpCenterAbout));
            Assert.assertTrue(isElementVisible(txtHelpCenterActivityLog));
            Assert.assertTrue(isElementVisible(txtHelpCenterLegal));

        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Help Center Screen...");
        }
    }

    /**
     * verifyLogFileToggleButtonState- This method is used to verify the state of toggle switch for log file
     *
     * @param- switchState- String Date-25/1/2023
     */
    public void verifyLogFileToggleButtonState(String switchState) {
        try {
            isElementVisible(txtHelpCenterLogFile);
            switch (switchState) {
                case "Enable" -> {
                    if (tglBtnHelpCenterLogFile.getAttribute(MessageConstants.VALUE_STRING).equals("0")) {
                        TestUtils.log().info("Log file toggle button is initially in Disable state");
                    } else {
                        tapByElement(tglBtnHelpCenterLogFile);
                        Assert.assertEquals(tglBtnHelpCenterLogFile.getAttribute(MessageConstants.VALUE_STRING), "0");
                        TestUtils.log().info("Log file toggle button is set in Disable state");
                    }
                    tapByElement(tglBtnHelpCenterLogFile);
                    Assert.assertEquals(tglBtnHelpCenterLogFile.getAttribute(MessageConstants.VALUE_STRING), "1");
                    TestUtils.log().info("Log file toggle button is set in Enable state");
                }
                case "Disable" -> {
                    if (tglBtnHelpCenterLogFile.getAttribute(MessageConstants.VALUE_STRING).equals("1")) {
                        TestUtils.log().info("Log file toggle button is initially in Enable state");
                    } else {
                        tapByElement(tglBtnHelpCenterLogFile);
                        Assert.assertEquals(tglBtnHelpCenterLogFile.getAttribute(MessageConstants.VALUE_STRING), "1");
                        TestUtils.log().info("Log file toggle button is set in Enable state");
                    }
                    tapByElement(tglBtnHelpCenterLogFile);
                    Assert.assertEquals(tglBtnHelpCenterLogFile.getAttribute(MessageConstants.VALUE_STRING), "0");
                    TestUtils.log().info("Log file toggle button is set in Disable state");
                }
                default ->
                    TestUtils.log().info("Please select the correct switch value of log file");

            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying log file toggle button...");
        }
    }

    /**
     * clickOnActivityLogAndVerify- This method is used to click and verify the active log screen Date-25/1/2023
     */
    public void clickOnActivityLogAndVerify() {
        try {
            waitForVisibility(txtHelpCenterActivityLog);
            click(imgArrowHelpCenterActivityLog);
            Assert.assertTrue(activityLogScreen.isActivityLogScreenDisplayed());
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while click and verify Activity Log...");
        }
    }

    /**
     * clickOnActivityLogAndVerify- This method is used to click and verify the active log screen Date-25/1/2023
     */
    public void clickOnAboutAndVerify() {
        try {
            waitForVisibility(txtHelpCenterAbout);
            click(imgArrowHelpCenterAbout);
            aboutScreen.isAboutScreenDisplayed();
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying About Screen...");
        }
    }

    /**
     * clickOnTermsOfUseAndVerify- This method is used to click and verify the terms of use and privacy notice screen Date-25/1/2023
     */
    public void clickOnTermsOfUseAndVerify() {
        try {
            waitForVisibility(txtHelpCenterLegal);
            click(imgArrowHelpCenterLegal);
            termAndConditionScreen.isTermsOfUseScreenDisplayed();
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying Term and Condition Screen...");
        }
    }

    /**
     * clickOnSupportAndVerify- This method is used to click and verify the support screen Date-25/1/2023
     */
    public void clickOnSupportAndVerify() {
        try {
            waitForVisibility(txtHelpCenterSupport);
            click(imgArrowHelpCenterSupport);
            supportScreen.isSupportScreenDisplayed();
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while verifying support Screen...");
        }
    }
}
