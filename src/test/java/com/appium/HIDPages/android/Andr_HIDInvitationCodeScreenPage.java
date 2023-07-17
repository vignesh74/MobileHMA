package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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

    String InvitationPageTxt = "Enter the 16-digit code from your HID Mobile Access welcome email.";
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


    public boolean checkVisibilityOfInvitationPage() {
        boolean flag = false;
        try {

            if (!isDisplayed(invCodePageHeader)) {
                TestUtils.log().info("Invitation page is not displayed");
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Invitation page...");
        }
        return flag;
    }

    public void checkDescriptionInvitationPage(){

        try {

            if(InvitationPageTxt.equals(txtInviteCodeMessage.getText()))

            {
                TestUtils.log().debug(" The description in  Invitation page is  correct...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  Invitation page ...");
        }
    }
    public boolean checkAboutInfo() {
        click(aboutBtn);
        boolean flag = false;
        try {

            if (!isDisplayed(txtAboutScreenHeader)) {
                TestUtils.log().info("About Screen is not displayed");
                flag = true;
            }
            click(imgCopyClipIcon);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of About Screen ...");
        }
        return flag;
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

    public boolean checkScanQrCodeButton() {

        boolean flag = false;

        try {

            if (!isDisplayed(scannerMsg)) {
                TestUtils.log().info("Scanner is not displayed");
                flag = true;
            }
            click(scanQrCodeBackBtn);
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Scanner QR button ...");
        }
        return flag;
   }

    public void clickScanQRButton() {
        try {

            click(btnScanQrCode);
            click(allowBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating text in Twist&Go page...");
        }

    }
}
