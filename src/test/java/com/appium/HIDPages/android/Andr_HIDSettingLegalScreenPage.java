package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

public class Andr_HIDSettingLegalScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in legal page Date-13/02/2023
     */

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtLegal")
    private MobileElement txtLegalHeaderTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBackLegal")
    private MobileElement imgBackFromLegal;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='End User License Agreement']")
    private MobileElement txtEndUserLicenseAgreement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Notice']")
    private MobileElement txtPrivacyNotice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Third Party Licenses']")
    private MobileElement txtThirdPartyLicenses;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='End User License Agreement']")
    private MobileElement txtEndUserLicenseTitle;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@text='Mobile Application License and User Agreement']")
    private MobileElement txtEndUserLicenseAgreementPageData;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Notice']")
    private MobileElement txtPrivacyNoticeTitle;

    @AndroidFindBy(xpath = "//android.webkit.WebView[@text='HID® Mobile Access® Application Privacy Notice']")
    private MobileElement txtPrivacyNoticePageData;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Third Party Licenses']")
    private MobileElement txtThirdPartyLicensesTitle;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Third-party licenses']", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Third Party Licenses']", priority = 1)
    private MobileElement txtThirdPartyLicensesPageData;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Back Arrow\"]")
    private MobileElement imgBackToLegalPage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Legal']")
    private MobileElement txtLegal;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-13/02/2023
     */

    public MobileElement getTxtLegalHeaderTitle() {
        return txtLegalHeaderTitle;
    }

    public MobileElement getImgBackFromLegal() {
        return imgBackFromLegal;
    }

    public MobileElement getTxtEndUserLicenseAgreement() {
        return txtEndUserLicenseAgreement;
    }

    public MobileElement getTxtPrivacyNotice() {
        return txtPrivacyNotice;
    }

    public MobileElement getTxtThirdPartyLicenses() {
        return txtThirdPartyLicenses;
    }

    public MobileElement getTxtEndUserLicenseTitle() {
        return txtEndUserLicenseTitle;
    }

    public MobileElement getTxtEndUserLicenseAgreementPageData() {
        return txtEndUserLicenseAgreementPageData;
    }

    public MobileElement getTxtPrivacyNoticeTitle() {
        return txtPrivacyNoticeTitle;
    }

    public MobileElement getTxtPrivacyNoticePageData() {
        return txtPrivacyNoticePageData;
    }

    public MobileElement getTxtThirdPartyLicensesTitle() {
        return txtThirdPartyLicensesTitle;
    }

    public MobileElement getTxtThirdPartyLicensesPageData() {
        return txtThirdPartyLicensesPageData;
    }

    public MobileElement getImgBackToLegalPage() {
        return imgBackToLegalPage;
    }

    public MobileElement getTxtLegal() {
        return txtLegal;
    }

    /**
     * isLegalScreenPageDisplayed- This method is used to check the legal screen is displayed or not Date-13/02/2023
     */

    public void isLegalScreenPageDisplayed() {
        try {
            waitForVisibility(txtThirdPartyLicenses);
            Assert.assertTrue(isElementVisible(txtLegalHeaderTitle));
            Assert.assertTrue(isElementVisible(txtEndUserLicenseAgreement));
            Assert.assertTrue(isElementVisible(txtPrivacyNotice));
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while displaying Legal screen page...");
        }
    }

    /**
     * backFromLegalScreen- This method is used to back from the legal screen Date-13/02/2023
     */

    public void backFromLegalScreen() {
        try {
            click(imgBackFromLegal);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while coming back from Legal screen...");
        }
    }

    /**
     * backToLegalScreen- This method is used to back to the legal screen Date-13/02/2023
     */

    public void backToLegalScreen() {
        try {
            click(imgBackToLegalPage);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while coming back to Legal screen...");
        }
    }

    /**
     * verifyEndUserLicenseScreenPageDisplayed- This method is used to verify the end user license screen is displayed or not Date-13/02/2023
     */

    public void verifyEndUserLicenseScreenPageDisplayed() {
        try {
            click(txtEndUserLicenseAgreement);
            waitForVisibility(txtEndUserLicenseAgreementPageData);
            Assert.assertTrue(isElementVisible(txtEndUserLicenseTitle));
            backToLegalScreen();
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while displaying EndUser License Screen...");
        }
    }

    /**
     * verifyPrivacyNoticeScreenPageDisplayed- This method is used to verify the privacy notice screen is displayed or not Date-13/02/2023
     */

    public void verifyPrivacyNoticeScreenPageDisplayed() {
        try {
            click(txtPrivacyNotice);
            waitForVisibility(txtPrivacyNoticePageData);
            Assert.assertTrue(isElementVisible(txtPrivacyNoticeTitle));
            backToLegalScreen();
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while displaying Privacy Notice Screen...");
        }
    }

    /**
     * clickAndVerifyLegalScreen- This method is used to click on legal screen Date-13/02/2023
     */
    public void clickOnLegalScreen() {
        try {
            click(txtLegal);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Legal screen...");
        }
    }

    /**
     * verifyThirdPartyLicensesScreenPageDisplayed- This method is used to verify the third party licenses screen is displayed or not Date-13/02/2023
     */

    public void verifyThirdPartyLicensesScreenPageDisplayed() {
        try {
            click(txtThirdPartyLicenses);
            waitForVisibility(txtThirdPartyLicensesPageData);
            Assert.assertTrue(isElementVisible(txtThirdPartyLicensesTitle));
            backToLegalScreen();
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while displaying ThirdParty Licenses Screen...");
        }
    }
}
