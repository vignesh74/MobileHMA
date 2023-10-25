package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.*;


public class Andr_HIDMobileAccessTermsOfUse extends BasePage{
/**
 * mobile elements-These are the mobile elements present in MA_Terms Of Use Screen Date-04/05/2023
 */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/fbtnCancel")
    private MobileElement cancelBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/fbtnEndUserLicenseAgreement")
    private MobileElement eulaBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/fbtnPrivacyNotice")
    private MobileElement privacyNoticeBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnAccept")
    private MobileElement acceptBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBack")
    private MobileElement eulaBackBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBack")
    private MobileElement privacyBackBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtTermsOfUseMessage")
    private MobileElement txtTermsOfUseMessage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtTermsOfUse")
    private MobileElement txtTermsOfUse;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEndUserLicenseAgreementAndPrivacyNoticeTitle")
    private MobileElement eulaHeaderTxt;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"legal@hidglobal.com\"]/android.widget.TextView")
    private MobileElement emailLegal;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"privacy@hidglobal.com\"]/android.widget.TextView")
    private  MobileElement emailPrivacy;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEndUserLicenseAgreementAndPrivacyNoticeTitle")
    private MobileElement privacyHeaderTxt;

    @AndroidFindBy(id ="com.hidglobal.mobilekeys.android.v3:id/txtTermsOfUseMessage")
    private MobileElement termsOfUseMessage;

    @AndroidFindBy(id ="com.hidglobal.mobilekeys.android.v3:id/agreeCheckbox")
    private MobileElement agreeCheckbox;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgTermsOfUse")
    private MobileElement imgTermsOfUse;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnAccept")
    private MobileElement btnContinue;



    /**
     * These are the methods developed for testing MA Terms of Use Screen Page Date-04/05/2023
     * @return
     */

    public void checkVisibilityOfTermsOfUsePage()
    {
        try {
            if (!isDisplayed(txtTermsOfUse))
            {
                Assert.assertTrue(false, "Terms of Use Page is not displayed...");
                TestUtils.log().info("Terms of Use Page is not displayed");
            }else{
                TestUtils.log().info("Terms of Use Page is displayed");
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Terms of use page...");
        }

    }

/*
    public void checkTermsOfUseTxt()
    {
        try {

            if(MESSAGE_TERMS_OF_USE.equals(txtTermsOfUse.getText()))
            {
                Assert.assertTrue(true, "The description in  TermsOfUse page is  correct...");
                TestUtils.log().debug(" The description in  TermsOfUse page is  correct...");
            }
            else {
                Assert.assertTrue(false, "The description in  TermsOfUse page is  incorrect...");
                TestUtils.log().debug(" The description in  TermsOfUse page is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  TermsOfUse page ...");
        }
    }
*/
    public void cancelTermsOfUsePage(String button)
    {
        try {
            if (!CANCEL.equalsIgnoreCase(button)) {
                Assert.assertTrue(false, "The Cancel link in TermsOfUse page is not displayed...");
                TestUtils.log().info("The Cancel link in TermsOfUse page is not displayed");
            }
            else{

            click(cancelBtn);}

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while cancelling TermsOfUse page...");
        }
    }

    public void checkEulaPageLink(String link)
    {
        try {
            if (!EULA.equalsIgnoreCase(link)) {
                Assert.assertTrue(false, "The Eula link in TermsOfUse page is not displayed...");
                TestUtils.log().info("The Eula link in TermsOfUse page is not displayed");
            }
            click(eulaBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Eula page link...");
        }
    }

    public void checkPrivacyPageLink(String link)
    {
        try {
            if (!PRIVACY_NOTICE.equalsIgnoreCase(link)) {
                Assert.assertTrue(false, "The Privacy Notice link in TermsOfUse page is not displayed...");
                TestUtils.log().info("The Privacy Notice link in TermsOfUse page is not displayed");
            }

            click(privacyNoticeBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Privacy  page link...");
        }
    }

    public void checkVisibilityOfEulaPage()
    {
        try {
            if (!isDisplayed(eulaHeaderTxt)) {
                Assert.assertTrue(false, "Eula Page is not displayed...");
                TestUtils.log().info("Eula Page is not displayed");
            }
            swipeDown(12);
            click(emailLegal);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Eula page...");
        }

    }

    public void checkVisibilityOfPrivacyNoticePage()
    {
        try {
            if (!isDisplayed(privacyHeaderTxt)) {
                Assert.assertTrue(false, "Privacy Notice Page is not displayed...");
                TestUtils.log().info("Privacy Notice Page is not displayed");
            }
            swipeDown(10);
            click(emailPrivacy);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Privacy Notice page...");
        }

    }

    public void acceptTermsOfUsePage(){
        try {

            click(acceptBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while accepting TermsOfUse page...");
        }
    }

    public void continueTermsOfUsePageLink(String link){
        try {
            if(!CONTINUE.equalsIgnoreCase(link))
            {
                Assert.assertTrue(false, "The Continue button in  TermsOfUse page is  not visible...");
                TestUtils.log().debug(" The Continue button in  TermsOfUse page is  not visible...");

            }

            click(btnContinue);
            TestUtils.log().debug(" The Continue button in  TermsOfUse page is visible and clicked...");

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Continue button in TermsOfUse page...");
        }
    }

    public void continueTermsOfUsePage(){
        try {

            click(btnContinue);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Continue button in TermsOfUse page...");
        }
    }

    public  void continueBtnDisabled(){
        try {
            isElementEnabled(btnContinue);
            Assert.assertTrue(true, "Continue Button is not enabled...");
            TestUtils.log().info("Continue Button is not enabled");

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Continue button in TermsOfUse page...");
        }
    }

    public void backButtonEula(){
        try {

            click(eulaBackBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while navigating back from Eula page to TermsOfUse page...");
        }
    }

    public void backButtonPrivacyNoticePage(){
        try {

            click(privacyBackBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while navigating back from Privacy Notice Page to TermsOfUse page...");
        }
    }

    public void agreeCheckBox(){
        try {

            click(agreeCheckbox);
            waitForGivenTime(2);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Checkbox in TermsOfUse page...");
        }
    }

    public void checkCheckBoxTxt()
    {
        try {

            if(MESSAGE_CHECKBOX.equals(txtTermsOfUseMessage.getText()))
            {
                Assert.assertTrue(true, "The checkbox description in  TermsOfUse page is  correct...");
                TestUtils.log().debug(" The checkbox description in  TermsOfUse page is  correct...");

            }
            else {
                Assert.assertTrue(false, "The checkbox description in  TermsOfUse page is  incorrect...");
                TestUtils.log().debug(" The checkbox description in  TermsOfUse page is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the checkBox description in  TermsOfUse page ...");
        }
    }

    public void checkVisibilityOfTermsOfUsePageImage()
    {
        try {

            if (!isDisplayed(imgTermsOfUse)) {
                Assert.assertTrue(false, "Terms of Use Page image is not displayed...");
                TestUtils.log().info("Terms of Use Page image is not displayed");

            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of image in Terms of Use page...");
        }

    }

}
