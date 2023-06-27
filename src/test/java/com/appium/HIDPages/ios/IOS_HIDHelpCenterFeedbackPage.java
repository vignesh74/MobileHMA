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

    /**
     * isFeedbackScreenDisplayed- This method is used to verify the feedback screen is displayed or not Date-25/1/2023
     */
    public void isFeedbackScreenDisplayed() {
        try {
            waitForVisibility(txtFeedbackSupport);
            Assert.assertTrue(isElementVisible(txtBoxFeedbackDescribe));
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
}
