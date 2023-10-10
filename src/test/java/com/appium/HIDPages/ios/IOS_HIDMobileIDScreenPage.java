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

    //XCUIElementTypeOther/XCUIElementTypeImage - Card Image

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
            Assert.assertTrue(btnAddMobileID.isEnabled());
            click(btnAddMobileID);
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
}
