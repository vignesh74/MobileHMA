package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDMobileIDScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in mobile id Page Date-25/1/2023
     */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mobile IDs\"]")
    private MobileElement tabMobileIds;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile IDs\"]")
    private MobileElement txtMobileIds;

    @iOSXCUITFindBy(accessibility = "MOB0001")
    private MobileElement txtMOB0001;

    @iOSXCUITFindBy(accessibility = "Add")
    private MobileElement lnkAddLinkText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Notifications\"]")
    private MobileElement tabNotifications;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile ID suspended\"]")
    private MobileElement txtMobileIDSuspended;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"attentionRequiredIcon\"]")
    private MobileElement imgAttentionIcon;

    @iOSXCUITFindBy(accessibility = "Please contact your administrator for a new Invitation Code")
    private MobileElement txtMsgForSuspend;

    @iOSXCUITFindBy(accessibility = "warningSign")
    private MobileElement imgWarningSign;

    @iOSXCUITFindBy(accessibility = "No Mobile IDs yet")
    private MobileElement txtNoMobileIDsYet;

    @iOSXCUITFindBy(accessibility = "Invitation Code redeemed. Waiting for your administrator to issue a Mobile ID.")
    private MobileElement txtMsgForRevoke;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Mobile ID\"]")
    private MobileElement txtAddMobileID;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    private MobileElement btnMobileIDBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Invitation Code\"]")
    private MobileElement txtInvitationCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter the 16-digit code from your HID Mobile Access welcome email\"]")
    private MobileElement txtInvitationCodeMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Invitation Code\"]//following-sibling::XCUIElementTypeTextField")
    private MobileElement txtInvitationCodeBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Qr Code\"]")
    private MobileElement imgQRCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Scan QR Code\"]")
    private MobileElement txtScanQRCode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add Mobile ID\"]")
    private MobileElement btnAddMobileID;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Code not recognised. Please check and try again.\"]")
    private MobileElement txtInvalidCodeMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"No Internet connection\"]")
    private MobileElement txtNoInternetMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Welcome to HID Mobile Access\"]")
    private MobileElement txtWelcomeToHIDMsg;

    //Delete Device Pop Up
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile ID Deleted\"]")
    private MobileElement txtMobileIDDeleted;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Your administrator has removed your Mobile ID. Please contact your administrator for a new Invitation Code.\"]")
    private MobileElement txtDeletedMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private MobileElement btnDeletedOKBtn;

    //Dynamic App Review
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"popupAppLogo\"]")
    private MobileElement imgAppLogo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enjoying HID Mobile Access?\"]")
    private MobileElement txtHIDMobAccess;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"We’d love to know if you’re having a great experience\"]")
    private MobileElement txtPopUpMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Not Really\"]")
    private MobileElement btnNotReally;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"thumbsDown\"]")
    private MobileElement imgThumbsDown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Not Really\"]")
    private MobileElement txtNotReally;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Yes!\"]")
    private MobileElement btnYesPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"thumbsUp\"]")
    private MobileElement imgThumbsUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Yes!\"]")
    private MobileElement txtYesPopUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Redeem a Mobile ID by entering the 16 digit Invitation code or choose to Sign in with SSO.\"]")
    private MobileElement txtRedeemIDMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
    private MobileElement btnGetStarted;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About this app\"]")
    private MobileElement btnAboutApp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About this app\"]")
    private MobileElement txtAboutApp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icAboutInfo\"]")
    private MobileElement imgIconAboutInfo;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getTabMobileIds() {
        return tabMobileIds;
    }

    public MobileElement getTxtMOB0001() {
        return txtMOB0001;
    }

    public MobileElement getTabNotifications() {
        return tabNotifications;
    }

    public MobileElement getTxtMobileIds() {
        return txtMobileIds;
    }

    public MobileElement getLnkAddLinkText() {
        return lnkAddLinkText;
    }

    public MobileElement getTxtMobileIDSuspended() {
        return txtMobileIDSuspended;
    }

    public MobileElement getImgAttentionIcon() {
        return imgAttentionIcon;
    }

    public MobileElement getTxtMsgForSuspend() {
        return txtMsgForSuspend;
    }

    public MobileElement getImgWarningSign() {
        return imgWarningSign;
    }

    public MobileElement getTxtNoMobileIDsYet() {
        return txtNoMobileIDsYet;
    }

    public MobileElement getTxtMsgForRevoke() {
        return txtMsgForRevoke;
    }

    public MobileElement getTxtAddMobileID() {
        return txtAddMobileID;
    }

    public MobileElement getBtnMobileIDBack() {
        return btnMobileIDBack;
    }

    public MobileElement getTxtInvitationCode() {
        return txtInvitationCode;
    }

    public MobileElement getTxtInvitationCodeMsg() {
        return txtInvitationCodeMsg;
    }

    public MobileElement getTxtInvitationCodeBox() {
        return txtInvitationCodeBox;
    }

    public MobileElement getImgQRCode() {
        return imgQRCode;
    }

    public MobileElement getTxtScanQRCode() {
        return txtScanQRCode;
    }

    public MobileElement getBtnAddMobileID() {
        return btnAddMobileID;
    }

    public MobileElement getTxtInvalidCodeMsg() {
        return txtInvalidCodeMsg;
    }

    public MobileElement getTxtNoInternetMsg() {
        return txtNoInternetMsg;
    }

    public MobileElement getTxtWelcomeToHIDMsg() {
        return txtWelcomeToHIDMsg;
    }

    public MobileElement getImgAppLogo() {
    return imgAppLogo;
}

    public MobileElement getTxtHIDMobAccess() {
        return txtHIDMobAccess;
    }

    public MobileElement getTxtPopUpMessage() {
        return txtPopUpMessage;
    }

    public MobileElement getBtnNotReally() {
        return btnNotReally;
    }

    public MobileElement getImgThumbsDown() {
        return imgThumbsDown;
    }

    public MobileElement getTxtNotReally() {
        return txtNotReally;
    }

    public MobileElement getBtnYesPopUp() {
        return btnYesPopUp;
    }

    public MobileElement getImgThumbsUp() {
        return imgThumbsUp;
    }

    public MobileElement getTxtYesPopUp() {
        return txtYesPopUp;
    }

    public MobileElement getTxtRedeemIDMsg() { return txtRedeemIDMsg; }

    public MobileElement getBtnGetStarted() { return btnGetStarted; }

    public MobileElement getBtnAboutApp() { return btnAboutApp; }

    public MobileElement getTxtAboutApp() { return txtAboutApp; }

    public MobileElement getImgIconAboutInfo() { return imgIconAboutInfo; }

    /**
     * isMobileIdScreenDisplayed- This method is used to verify the mobile id screen is displayed or not
     *
     * @return- boolean Date-25/1/2023
     */
    public boolean isMobileIdScreenDisplayed() {
        return (isElementVisible(txtMobileIds));
    }

    /**
     * clickOnMobileIDTabAndVerify- This method is used to click and verify the mobile id screen Date-25/1/2023
     */
    public void clickOnMobileIDTabAndVerify() {
        try {
            click(tabMobileIds);
            Assert.assertTrue(isMobileIdScreenDisplayed());
            Assert.assertTrue(isElementVisible(lnkAddLinkText));
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Mobile ID Screen...");
        }
    }

    public void verifyMobileIDScreen(String strMobileID) {
        try{
            switch (strMobileID){
                case "Suspend" -> {
                    Assert.assertTrue(isElementVisible(txtMobileIDSuspended));
                    Assert.assertTrue(isElementVisible(imgAttentionIcon));
                    Assert.assertTrue(isElementVisible(txtMsgForSuspend));
                }
                case "Resume" -> {
                    Assert.assertFalse(isElementVisible(txtMobileIDSuspended));
                    Assert.assertFalse(isElementVisible(imgAttentionIcon));
                    Assert.assertFalse(isElementVisible(txtMsgForSuspend));
                }
                case "Revoke" -> {
                    Assert.assertTrue(isElementVisible(imgWarningSign));
                    Assert.assertTrue(isElementVisible(txtNoMobileIDsYet));
                    Assert.assertTrue(isElementVisible(txtMsgForRevoke));
                }
                default ->
                        TestUtils.log().info("Please select the correct mobile ID ");
            }
        }
        catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Mobile ID Screen...");
        }
    }

    public void clickOnAddButton() {
        try {
            click(lnkAddLinkText);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Mobile ID Screen...");
        }
    }

    public void chkAddMobileIDPage() {
        try {
            Assert.assertTrue(isElementVisible(txtAddMobileID));
            Assert.assertTrue(isElementVisible(btnMobileIDBack));
            Assert.assertTrue(isElementVisible(txtInvitationCode));
            Assert.assertTrue(isElementVisible(txtInvitationCodeMsg));
            Assert.assertTrue(isElementVisible(txtInvitationCodeBox));
            Assert.assertTrue(isElementVisible(imgQRCode));
            Assert.assertTrue(isElementVisible(txtScanQRCode));
            Assert.assertTrue(isElementVisible(btnAddMobileID));
            Assert.assertFalse(btnAddMobileID.isEnabled());
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Mobile ID Screen...");
        }
    }

    public void enterInvitationCode(String strInvitationCode) {
        try {
            if (isDisplayed(txtInvitationCodeBox)) {
                sendKeys(txtInvitationCodeBox, strInvitationCode);
            } else {
                TestUtils.log().info("InvitationCode TextBox is not displayed");
            }
            Assert.assertTrue(btnGetStarted.isEnabled());
            click(btnGetStarted);
            waitForVisibility(txtMobileIds);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while entering invitation code...");
        }
    }

    public void enterInvitationCode_ADD(String strInvitationCode) {
        try {
            if (isDisplayed(txtInvitationCodeBox)) {
                sendKeys(txtInvitationCodeBox, strInvitationCode);
            } else {
                TestUtils.log().info("InvitationCode TextBox is not displayed");
            }
            Assert.assertTrue(btnAddMobileID.isEnabled());
            click(btnAddMobileID);
            waitForVisibility(txtMobileIds);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while entering invitation code...");
        }
    }

    public void enterInvalidInvitationCode(String strInvalidCode) {
        try {
            if (isDisplayed(txtInvitationCodeBox)) {
                sendKeys(txtInvitationCodeBox, strInvalidCode);
            } else {
                TestUtils.log().info("InvitationCode TextBox is not displayed");
            }
            Assert.assertTrue(btnAddMobileID.isEnabled());
            click(btnAddMobileID);
            waitForVisibility(txtInvalidCodeMsg);
            Assert.assertTrue(isElementVisible(txtInvalidCodeMsg));
            Assert.assertFalse(btnAddMobileID.isEnabled());
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while entering invitation code...");
        }
    }

    public void chkNoInternet(String strInvitation) {
        try {
            if (isDisplayed(txtInvitationCodeBox)) {
                sendKeys(txtInvitationCodeBox, strInvitation);
            } else {
                TestUtils.log().info("InvitationCode TextBox is not displayed");
            }
            Assert.assertTrue(btnAddMobileID.isEnabled());
            click(btnAddMobileID);
            waitForVisibility(txtNoInternetMsg);
            Assert.assertTrue(isElementVisible(txtNoInternetMsg));
            Assert.assertFalse(btnAddMobileID.isEnabled());
            click(btnMobileIDBack);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while verifying the No Internet Error msg...");
        }
    }

    public void verifyHIDMobilePage() {
        try {
            waitForVisibility(txtWelcomeToHIDMsg);
            Assert.assertTrue(isElementVisible(txtWelcomeToHIDMsg));
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Mobile ID Screen...");
        }
    }

    public void isDeletePopUpDispalyed() {
        try {
            waitForVisibility(txtMobileIDDeleted);
            if(txtMobileIDDeleted.isDisplayed()) {
                Assert.assertTrue(isElementVisible(txtDeletedMsg));
                Assert.assertTrue(isElementVisible(btnDeletedOKBtn));
                click(btnDeletedOKBtn);
            } else {
                TestUtils.log().info("Delete Mobile ID pop up is not displayed...");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying the Delete device pop up...");
        }
    }

    public void chkDynamicAppReview(String review) {
        try {
            waitForVisibility(txtHIDMobAccess);
            if(txtHIDMobAccess.isDisplayed()) {
                Assert.assertTrue(isElementVisible(imgAppLogo));
                Assert.assertTrue(isElementVisible(txtHIDMobAccess));
                Assert.assertTrue(isElementVisible(txtPopUpMessage));
                //Not Really - Dislike button
                Assert.assertTrue(isElementVisible(btnNotReally));
                Assert.assertTrue(isElementVisible(imgThumbsDown));
                Assert.assertTrue(isElementVisible(txtNotReally));
                //Yes - Like Button
                Assert.assertTrue(isElementVisible(btnYesPopUp));
                Assert.assertTrue(isElementVisible(imgThumbsUp));
                Assert.assertTrue(isElementVisible(txtYesPopUp));
                //Click on Review feedback button
                if(review.equalsIgnoreCase("Yes")){
                    click(btnYesPopUp);
                } else if (review.equalsIgnoreCase("Not Really")) {
                    click(btnNotReally);
                }

            } else {
                TestUtils.log().info("Dynamic App review pop up is not displayed...");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying the Dynamic App review pop up...");
        }
    }

    public void verifyWelcomeHIDPage() {
        try {
            waitForVisibility(txtWelcomeToHIDMsg);
            Assert.assertTrue(isElementVisible(txtWelcomeToHIDMsg));
            Assert.assertTrue(isElementVisible(txtRedeemIDMsg));
            Assert.assertTrue(isElementVisible(txtInvitationCode));
            Assert.assertTrue(isElementVisible(txtInvitationCodeMsg));
            Assert.assertTrue(isElementVisible(txtInvitationCodeBox));
            Assert.assertTrue(isElementVisible(imgQRCode));
            Assert.assertTrue(isElementVisible(txtScanQRCode));
            Assert.assertTrue(isElementVisible(btnGetStarted));
            Assert.assertFalse(btnGetStarted.isEnabled());
            Assert.assertTrue(isElementVisible(btnAboutApp));
            Assert.assertTrue(isElementVisible(txtAboutApp));
            Assert.assertTrue(isElementVisible(imgIconAboutInfo));
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying Welcome to HID Mobile Access Screen...");
        }
    }

    public void clickAboutThisApp() {
        try {
            click(btnAboutApp);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on About in welcome screen...");
        }
    }

}
