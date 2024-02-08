package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterLegalScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Help Center Legal Page Date-25/1/2023
     */

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Cancel\"]")
    private MobileElement btnLegalCancel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"txtTermsOfUse\"]")
    private MobileElement txtTermsOfUse;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"imgTermsOfUse\"]")
    private MobileElement imgTermsOfUse;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"End User Licence Agreement\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"End User License Agreement\"]", priority = 1)
    private MobileElement lnkEndUserLicenceAgreement;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Notice\"]", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Policy\"]", priority = 1)
    private MobileElement lnkPrivacyNotice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"imgBack\"]")
    private MobileElement imgBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value=\"Privacy Notice\"]")
    private MobileElement txtPrivacyNotice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value=\"End User Licence Agreement\"]")
    private MobileElement txtEndUserLicenceAgreement;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getBtnLegalCancel() {
        return btnLegalCancel;
    }

    public MobileElement getTxtTermsOfUse() {
        return txtTermsOfUse;
    }

    public MobileElement getImgTermsOfUse() {
        return imgTermsOfUse;
    }

    public MobileElement getLnkEndUserLicenceAgreement() {
        return lnkEndUserLicenceAgreement;
    }

    public MobileElement getLnkPrivacyNotice() {
        return lnkPrivacyNotice;
    }

    public MobileElement getImgBack() {
        return imgBack;
    }

    public MobileElement getTxtPrivacyNotice() {
        return txtPrivacyNotice;
    }

    public MobileElement getTxtEndUserLicenceAgreement() {
        return txtEndUserLicenceAgreement;
    }

    /**
     * clickOnPrivacyNoticeLinkAndVerify- This method is used to click and verify the privacy notice link screen Date-25/1/2023
     */
    public void clickOnPrivacyNoticeLinkAndVerify() {
        try {
            click(lnkPrivacyNotice);
            waitForVisibility(imgBack);
            Assert.assertTrue(isElementVisible(txtPrivacyNotice));
            click(imgBack);
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while click and verify the Privacy notice link...");
        }
    }

    /**
     * clickOnEndUserLicenceAgreementAndVerify- This method is used to click and verify the end user licence link screen Date-25/1/2023
     */
    public void clickOnEndUserLicenceAgreementAndVerify() {
        try {
            click(lnkEndUserLicenceAgreement);
            waitForVisibility(imgBack);
            Assert.assertTrue(isElementVisible(txtEndUserLicenceAgreement));
            click(imgBack);
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while click and verify the End user Licence Agreement...");
        }
    }

    /**
     * isTermAndConditionScreenDisplayed- This method is used to verify the terms of use and privacy notice Date-25/1/2023
     */
    public void isTermsOfUseScreenDisplayed() {
        try {
            waitForVisibility(txtTermsOfUse);
            Assert.assertTrue(isElementVisible(imgTermsOfUse));
            Assert.assertTrue(isElementVisible(lnkEndUserLicenceAgreement));
            Assert.assertTrue(isElementVisible(lnkPrivacyNotice));
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Terms Of Use Screen...");
        }
    }

    /**
     * clickOnCancelButton- This method is used to click on cancel button of terms of use and privacy notice screen Date-25/1/2023
     */
    public void clickOnCancelButton() {
        try {
            click(btnLegalCancel);
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while clicking on cancel button...");
        }
    }

}
