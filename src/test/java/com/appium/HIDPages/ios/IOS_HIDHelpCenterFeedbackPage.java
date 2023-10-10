package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterFeedbackPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Help Center Feedback Page Date-25/1/2023
     */

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Support\"]")
    private MobileElement imgBackFromFeedback;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Support\"]")
    private MobileElement txtFeedbackSupport;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Describe the issue here')]//preceding :: XCUIElementTypeTextView", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@index='2']", priority = 1)
    private MobileElement txtBoxFeedbackDescribe;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Terms of Use\"]")
    private MobileElement lknFeedbackTermsOfUse;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
    private MobileElement btnSubmitFeedback;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Information that you send to HID will be processed in accordance with the Privacy Policy that you have already accepted.\"]")
    private MobileElement txtPolicyMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Message Body\"]/XCUIElementTypeOther//following-sibling::XCUIElementTypeButton")
    private MobileElement btnLogFile;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mail.cancelSendButton\"]")
    private MobileElement btnCancelButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mail.sendButton\"]")
    private MobileElement btnSendButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mail.compose.popoverAlert.deleteDraft\"]")
    private MobileElement btnDeleteDraft;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"Horizontal scroll bar, 1 page\"])[2]")
    private MobileElement txtLastPage;


    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getImgBackFromFeedback() {
        return imgBackFromFeedback;
    }

    public MobileElement getTxtFeedbackSupport() {
        return txtFeedbackSupport;
    }

    public MobileElement getTxtBoxFeedbackDescribe() {
        return txtBoxFeedbackDescribe;
    }

    public MobileElement getLknFeedbackTermsOfUse() {
        return lknFeedbackTermsOfUse;
    }

    public MobileElement getBtnSubmitFeedback() {
        return btnSubmitFeedback;
    }

    public MobileElement getTxtPolicyMsg() {
        return txtPolicyMsg;
    }

    public MobileElement getBtnLogFile() {
        return btnLogFile;
    }

    public MobileElement getBtnCancelButton() {
        return btnCancelButton;
    }

    public MobileElement getBtnSendButton() {
        return btnSendButton;
    }

    public MobileElement getBtnDeleteDraft() {
        return btnDeleteDraft;
    }

    public MobileElement getTxtLastPage() {
        return txtLastPage;
    }

    /**
     * isFeedbackScreenDisplayed- This method is used to verify the feedback screen is displayed or not Date-25/1/2023
     */
    public void isFeedbackScreenDisplayed() {
        try {
            waitForVisibility(txtFeedbackSupport);
            Assert.assertTrue(isElementVisible(txtBoxFeedbackDescribe));
            Assert.assertTrue(isElementVisible(txtPolicyMsg));
            Assert.assertTrue(isElementVisible(lknFeedbackTermsOfUse));
            Assert.assertTrue(isElementVisible(btnSubmitFeedback));
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Feedback screen...");
        }
    }

    /**
     * isSubmitFeedbackButtonEnable- This method is used to verify that submit feedback button is enable or not Date-25/1/2023
     */
    public void isSubmitFeedbackButtonEnable(String text) {
        try {
            if (!btnSubmitFeedback.isEnabled()) {
                click(txtFeedbackSupport);
                sendKeys(txtBoxFeedbackDescribe, text);
                Assert.assertTrue(btnSubmitFeedback.isEnabled());
                clickOnBackToSupportScreen();
            } else {
                TestUtils.log().info("Submit feedback button is failed to enable");
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while enabling Feedback button...");
        }
    }

    /**
     * clickOnBackToSupportScreen- This method is used to click on back to support screen Date-25/1/2023
     */
    public void clickOnBackToSupportScreen() {
        try {
            click(imgBackFromFeedback);
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while clicking on back to support screen...");
        }
    }

    /**
     * getStatusSubmitFeedbackButton- This method is used to click on back to support screen
     *
     * @return- boolean Date-25/1/2023
     */
    public boolean getStatusSubmitFeedbackButton() {
        return btnSubmitFeedback.isEnabled();
    }

    public void chkDebugLogFile(String log, String text) {
        try {
            if (!btnSubmitFeedback.isEnabled()) {
                click(txtFeedbackSupport);
                sendKeys(txtBoxFeedbackDescribe, text);
                Assert.assertTrue(btnSubmitFeedback.isEnabled());
                click(btnSubmitFeedback);
                isLogFileDisplayed(log);
                clickOnBackToSupportScreen();
            } else {
                TestUtils.log().info("Submit feedback button is failed to enable");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while enabling Feedback button...");
        }
    }

    public void isLogFileDisplayed(String log) {
        try {
            Assert.assertTrue(isElementVisible(btnCancelButton));
            Assert.assertTrue(isElementVisible(btnSendButton));
            if(log.equals("Enable")) {
                click(btnLogFile);
                Assert.assertTrue(btnLogFile.isDisplayed());
            }
            else if (log.equals("Disable")) {
                iOSScrollDownTillElement(txtLastPage);
                Assert.assertFalse(btnLogFile.isDisplayed());
            }
            click(btnCancelButton);
            click(btnDeleteDraft);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on back to support screen...");
        }
    }

    public void chkSupportTermsOfUse() {
        try {
            click(lknFeedbackTermsOfUse);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Feedback screen...");
        }
    }

}
