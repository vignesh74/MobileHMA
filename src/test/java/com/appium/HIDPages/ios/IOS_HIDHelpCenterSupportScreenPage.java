package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterSupportScreenPage extends BasePage {

    /**
     * object created to access methods from page classes  Date- 25/1/2023
     */
    IOS_HIDHelpCenterFeedbackPage feedbackScreen = new IOS_HIDHelpCenterFeedbackPage();

    /**
     * mobile elements - These are mobile elements which is present in Help Center Support Page Date-25/1/2023
     */

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]")
    private MobileElement imgBackFromSupport;

    @iOSXCUITFindBy(xpath = "//*[@name='Help Centre']//following-sibling:: XCUIElementTypeStaticText")
    private MobileElement txtTitleHelpCenterSupport;

    @iOSXCUITFindBy(xpath = "//*[@name='Submit Feedback to HID']//preceding-sibling:: XCUIElementTypeStaticText[@name='Support']")
    private MobileElement txtHelpCenterSupport;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"https://support.hidglobal.com\"]")
    private MobileElement lnkHelpCenterSupportHID;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit Feedback to HID\"]")

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */
    private MobileElement btnSupportSubmitFeedback;

    public MobileElement getImgBackFromSupport() {
        return imgBackFromSupport;
    }

    public MobileElement getTxtTitleHelpCenterSupport() {
        return txtTitleHelpCenterSupport;
    }

    public MobileElement getTxtHelpCenterSupport() {
        return txtHelpCenterSupport;
    }

    public MobileElement getLnkHelpCenterSupportHID() {
        return lnkHelpCenterSupportHID;
    }

    public MobileElement getBtnSupportSubmitFeedback() {
        return btnSupportSubmitFeedback;
    }

    /**
     * clickOnSubmitFeedbackButtonAndVerify- This method is used to click and verify the submit feedback button Date-25/1/2023
     */
    public void clickOnSubmitFeedbackButtonAndVerify() {
        try {
            if (btnSupportSubmitFeedback.isEnabled()) {
                click(btnSupportSubmitFeedback);
                Assert.assertFalse(feedbackScreen.getStatusSubmitFeedbackButton());
            } else {
                TestUtils.log().info("Fail to click on submit feedback button on support Page");
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying feedback Screen...");
        }
    }

    /**
     * isSupportScreenDisplayed- This method is used to verify the support screen is displayed or not Date-25/1/2023
     */
    public void isSupportScreenDisplayed() {
        try {
            waitForVisibility(txtTitleHelpCenterSupport);
            Assert.assertTrue(isElementVisible(txtHelpCenterSupport));
            Assert.assertTrue(isElementVisible(lnkHelpCenterSupportHID));
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Support Screen...");
        }
    }

    /**
     * clickOnBackToHelpCenter- This method is used to click on back to help center screen Date-25/1/2023
     */
    public void clickOnBackToHelpCenter() {
        try {
            click(imgBackFromSupport);
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Help Center Screen...");
        }
    }

}
