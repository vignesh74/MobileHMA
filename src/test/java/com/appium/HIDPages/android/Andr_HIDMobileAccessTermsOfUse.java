package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;


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

    String messageTermsOfUse="By tapping “Accept”, you acknowledge you have reviewed and agreed to the HID Mobile Access End User License Agreement and Privacy Notice.";
    String messageCheckBox="I have read and agree to the End User License Agreement and Privacy Notice for this application.";
    /**
     * These are the methods developed for testing MA Terms of Use Screen Page Date-04/05/2023
     * @return
     */

    public boolean checkVisibilityOfTermsOfUsePage()
    {
        boolean flag = false;
        try {

            if (!isDisplayed(txtTermsOfUse)) {
                TestUtils.log().info("Terms of Use Page is not displayed");
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of FavoriteReader page...");
        }
        return flag;
    }


    public void checkTermsOfUseTxt()
    {
        try {

            if(messageTermsOfUse.equals(txtTermsOfUse.getText()))
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

    public void cancelTermsOfUsePage()
    {
        try {

            click(cancelBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while cancelling TermsOfUse page...");
        }
    }

    public void checkEulaPageLink()
    {
        try {
            click(eulaBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Eula page link...");
        }
    }

    public void checkPrivacyPageLink()
    {
        try {

            click(privacyNoticeBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Privacy  page link...");
        }
    }

    public boolean checkVisibilityOfEulaPage()
    {
        boolean flag = false;
        try {

            if (!isDisplayed(eulaHeaderTxt)) {
                TestUtils.log().info("Eula Page is not displayed");
                flag = true;
            }

           //scrollDownTillElement(8,0.20);
           // click(emailLegal);
            swipeDown(17);
            click(emailLegal);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Eula page...");
        }
        return flag;
    }

    public boolean checkVisibilityOfPrivacyNoticePage()
    {
        boolean flag = false;
        try {

            if (!isDisplayed(privacyHeaderTxt)) {
                TestUtils.log().info("Privacy Notice Page is not displayed");
                flag = true;
            }

           // scrollDownTillElement(25,0.00);
           // click(emailPrivacy);
            swipeDown(17);
            click(emailPrivacy);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Privacy Notice page...");
        }
        return flag;
    }

    public void acceptTermsOfUsePage(){
        try {

            click(acceptBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while accepting TermsOfUse page...");
        }
    }

    public void continueTermsOfUsePage(){
        try {

            click(btnContinue);

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

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on Checkbox in TermsOfUse page...");
        }
    }

    public void checkCheckBoxTxt()
    {
        try {

            if(messageCheckBox.equals(termsOfUseMessage.getText()))
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

    public boolean checkVisibilityOfTermsOfUsePageImage()
    {
        boolean flag = false;
        try {

            if (!isDisplayed(imgTermsOfUse)) {
                TestUtils.log().info("Terms of Use Page image is not displayed");
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of image in Terms of Use page...");
        }
        return flag;
    }

}
