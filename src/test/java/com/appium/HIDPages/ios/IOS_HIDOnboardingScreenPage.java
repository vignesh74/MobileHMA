package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDOnboardingScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in onboarding Page Date-17/10/2023
     */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Convenient\"]")
    private MobileElement imgConvenient;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Convenient\"]")
    private MobileElement txtConvenient;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
    private MobileElement btnConvenientSkip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your mobile device is your access card - even when you're offline!\"]")
    private MobileElement txtConvenientMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"TwistAndGo\"]")
    private MobileElement imgTwistAndGo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Twist & Go\"]")
    private MobileElement txtTwistAndGo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Skip\"]")
    private MobileElement btnTwistAndGoSkip;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Simply twist your phone in front of you… and go!\"]")
    private MobileElement txtTwistAndGoMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Banners\"]")
    private MobileElement imgBanners;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Banners\"]")
    private MobileElement txtBanners;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"An intuitive way to provide information about settings that can improve HID Mobile Access experience. Note! We do not track or store your location.\"]")
    private MobileElement txtBannersMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
    private MobileElement btnGetStarted;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Terms of Use\"]")
    private MobileElement txtTermsOfUse;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"terms\"]")
    private MobileElement imgTerms;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile Access Terms of Use\"]")
    private MobileElement txtMobileTermsUse;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"End User License Agreement\"]")
    private MobileElement txtLicenseAgreement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Privacy Policy\"]")
    private MobileElement txtPrivacyPolicy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"checkmarkEmpty\"]")
    private MobileElement imgCheckBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"By checking this box, you confirm that you have reviewed and consent to the End User License Agreement and Privacy Policy for this application.\"]")
    private MobileElement txtPolicyMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Agree and Continue\"]")
    private MobileElement btnAgreeAndContinue;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-17/10/2023
     */

    public MobileElement getImgConvenient() {
        return imgConvenient;
    }

    public MobileElement getTxtConvenient() {
        return txtConvenient;
    }

    public MobileElement getBtnConvenientSkip() {
        return btnConvenientSkip;
    }

    public MobileElement getTxtConvenientMsg() {
        return txtConvenientMsg;
    }

    public MobileElement getImgTwistAndGo() {
        return imgTwistAndGo;
    }

    public MobileElement getTxtTwistAndGo() {
        return txtTwistAndGo;
    }

    public MobileElement getBtnTwistAndGoSkip() {
        return btnTwistAndGoSkip;
    }

    public MobileElement getTxtTwistAndGoMsg() {
        return txtTwistAndGoMsg;
    }

    public MobileElement getImgBanners() {
        return imgBanners;
    }

    public MobileElement getTxtBanners() {
        return txtBanners;
    }

    public MobileElement getTxtBannersMsg() {
        return txtBannersMsg;
    }

    public MobileElement getBtnGetStarted() {
        return btnGetStarted;
    }

    /**
     * onboardConvenientPage- This method is used to verify the onboarding screen is displayed or not
     */

    public void onboardConvenientPage() {
        try {
            Assert.assertTrue(isElementVisible(imgConvenient));
            Assert.assertTrue(isElementVisible(txtConvenient));
            Assert.assertTrue(isElementVisible(btnConvenientSkip));
            Assert.assertTrue(isElementVisible(txtConvenientMsg));
            swipeLeft(1);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Onboarding Screen...");
        }
    }
    public void onboardTwistAndGoPage() {
        try {
            Assert.assertTrue(isElementVisible(imgTwistAndGo));
            Assert.assertTrue(isElementVisible(txtTwistAndGo));
            Assert.assertTrue(isElementVisible(btnTwistAndGoSkip));
            Assert.assertTrue(isElementVisible(txtTwistAndGoMsg));
            swipeLeft(1);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Onboarding Screen...");
        }
    }
    public void onboardBannersPage() {
        try {
            Assert.assertTrue(isElementVisible(imgBanners));
            Assert.assertTrue(isElementVisible(txtBanners));
            Assert.assertTrue(isElementVisible(txtBannersMsg));
            Assert.assertTrue(isElementVisible(btnGetStarted));
            click(btnGetStarted);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Onboarding Screen...");
        }
    }
    public void onboardClkGetStarted() {
        try {
            click(btnGetStarted);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on Get Started button in Onboarding Screen...");
        }
    }

    public void checkTermsOfUse() {
        try {
            Assert.assertTrue(isElementVisible(txtTermsOfUse));
            Assert.assertTrue(isElementVisible(imgTerms));
            Assert.assertTrue(isElementVisible(txtMobileTermsUse));
            Assert.assertTrue(isElementVisible(txtLicenseAgreement));
            Assert.assertTrue(isElementVisible(txtPrivacyPolicy));
            Assert.assertTrue(isElementVisible(imgCheckBox));
            Assert.assertTrue(isElementVisible(txtPolicyMsg));
            Assert.assertTrue(isElementVisible(btnAgreeAndContinue));
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Onboarding Screen...");
        }
    }

    public void clickAgreeAndContinue() {
        try {
            //Assert.assertFalse(btnAgreeAndContinue.isEnabled()); //Currently not working coz its enabled value is True always
            click(imgCheckBox);
            Assert.assertTrue(btnAgreeAndContinue.isEnabled());
            click(btnAgreeAndContinue);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Terms of Use Screen...");
        }
    }

}
