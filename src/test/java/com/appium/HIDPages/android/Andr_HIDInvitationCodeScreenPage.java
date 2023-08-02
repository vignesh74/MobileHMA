package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.INVITATION_PAGE_TEXT;

public class Andr_HIDInvitationCodeScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in invitation code page Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edInviteCode")
    private MobileElement txtbxInvitationCode;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnGetStarted")
    private MobileElement btnGetStarted;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtAbout")
    private MobileElement aboutBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtInviteCode")
    private MobileElement invCodePageHeader;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtInviteCodeMessage")
    private MobileElement txtInviteCodeMessage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnScanQrCode")
    private MobileElement btnScanQrCode;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBackAbout")
    private MobileElement imgBackAbout;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtAppPreferences")
    private MobileElement txtAboutScreenHeader;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgCopyClipIcon")
    private  MobileElement imgCopyClipIcon;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement allowBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private MobileElement denyBtn;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")
    private MobileElement denyAndDontAskAgain;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBack")
    private MobileElement scanQrCodeBackBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtScannerMessage")
    private MobileElement scannerMsg;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    private MobileElement toastMsg;


    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getInvitationTextBox() {
        return txtbxInvitationCode;
    }

    public MobileElement getGetStartedButton() {
        return btnGetStarted;
    }

    /**
     * enterInvitationCode- This method is used to enter the invitation code
     *
     * @param strInvitationCode
     *         - String Date-25/01/2023
     */
    public void enterInvitationCode(String strInvitationCode) {
        try {
            if (isDisplayed(txtbxInvitationCode)) {
                sendKeys(txtbxInvitationCode, strInvitationCode);
            } else {
                TestUtils.log().info("InvitationCode TextBox is not displayed");
            }
            click(btnGetStarted);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while entering invitation code...");
        }
    }


    public void checkVisibilityOfInvitationPage() {

        try {

            if (!isDisplayed(invCodePageHeader)) {
                Assert.assertTrue(false, "Invitation page is not displayed...");
                TestUtils.log().info("Invitation page is not displayed");

            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Invitation page...");
        }
    }

    public void checkDescriptionInvitationPage(){

        try {

            if(INVITATION_PAGE_TEXT.equals(txtInviteCodeMessage.getText()))

            {
                Assert.assertTrue(true, "The description in  Invitation page is  correct...");
                TestUtils.log().debug(" The description in  Invitation page is  correct...");
            }
            else
            {
                Assert.assertTrue(false, "The description in  Invitation page is  incorrect...");
                TestUtils.log().debug(" The description in  Invitation page is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  Invitation page ...");
        }
    }
    public void checkAboutInfo() {
        click(aboutBtn);
        try {

            if (!isDisplayed(txtAboutScreenHeader)) {
                Assert.assertTrue(false, "About Screen is not displayed...");
                TestUtils.log().info("About Screen is not displayed");
            }
            click(imgCopyClipIcon);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of About Screen ...");
        }
    }

    public void toastMessageAboutScreen() {
        try {

            if (isElementVisible(toastMsg)) {

                TestUtils.log().info("About Screen toast message is displayed");
            }
            click(imgBackAbout);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of About Screen toast message ...");
        }
       // return flag;
    }

    public void checkScanQrCodeButton() {

        try {

            if (!isDisplayed(scannerMsg)) {
                Assert.assertTrue(false, "Scanner message is not displayed...");
                TestUtils.log().info("Scanner is not displayed");
            }
            else{
                Assert.assertTrue(true, "Scanner message is  displayed...");
                TestUtils.log().info("Scanner is  displayed");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Scanner QR button ...");
        }

   }

    public void isEnabledScanQRButton() {
        try {
            if (!isElementEnabled(btnScanQrCode))
            {
                Assert.assertTrue(false, "Scan QR Code button is not enabled...");
                TestUtils.log().info("Scan QR Code button is not enabled");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating text in Twist&Go page...");
        }

    }
    public void isEnabledGetStartedButton() {
        try {
           if(isElementEnabled(btnGetStarted)){
               Assert.assertTrue(false, "Get Started button should  not be enabled...");
               TestUtils.log().info("Get Started button should  not be enabled");
           }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating text in Twist&Go page...");
        }

    }
}
