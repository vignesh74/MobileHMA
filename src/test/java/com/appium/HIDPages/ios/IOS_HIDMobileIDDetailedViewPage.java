package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDMobileIDDetailedViewPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Detailed view Page Date-25/1/2023
     */
    //Org Specific Information
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Mobile Access\"]//XCUIElementTypeCell//XCUIElementTypeOther//XCUIElementTypeImage")
    private MobileElement imgHIDDigiCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Detailed View\"]")
    private MobileElement navDetailedView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    private MobileElement btnDetViewBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Detailed View\"]")
    private MobileElement txtDetailedView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"defaultProfilePic\"]")
    private MobileElement imgProfilePic;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"defaultProfilePic\"]//following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtNickname;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Highlight\"]")
    private MobileElement btnHighlight;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SUPPORT\"]")
    private MobileElement txtSupportHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Call\"]")
    private MobileElement imgCall;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Call\"]")
    private MobileElement txtCall;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Get Mail\"]")
    private MobileElement imgGetMail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"E-Mail\"]")
    private MobileElement txtGetEMail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"rectangle.portrait.and.arrow.right.fill\"]")
    private MobileElement imgWebsite;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Website\"]")
    private MobileElement txtWebsite;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"INFORMATION\"]")
    private MobileElement txtInformation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile User Name\"]")
    private MobileElement txtMobileUserName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile User Name\"]//following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtMobileUserValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile ID friendly name\"]")
    private MobileElement txtFriendlyName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Mobile ID friendly name\"]//following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtFriendlyValue;

    //Phone call option
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeWindow[@name=\"SBSwitcherWindow\"]")
    private MobileElement wndSwitchCall;

    //Email Pop up
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Send E-Mail\"]")
    private MobileElement txtSendEmailHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Send E-Mail\"]//following-sibling::XCUIElementTypeStaticText")
    private MobileElement txtEmailMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    private MobileElement btnCancelMail;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Open in Mail\"]")
    private MobileElement btnOpenMail;

    //Website pop up
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Open Website\"]")
    private MobileElement txtWebsiteHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Do you wish to leave the app and load the link via your browser?\"]")
    private MobileElement txtWebsiteMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Visit Website\"]")
    private MobileElement btnViewWebsite;

    //Email part
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"New Message\"]")
    private MobileElement navEmailNewMsg;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mail.cancelSendButton\"]")
    private MobileElement btnEmailCancel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Delete Draft\"]")
    private MobileElement btnEmailDelete;

    //Edit NickName
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"defaultProfilePic\"]//following-sibling::XCUIElementTypeTextField")
    private MobileElement txtEditNickName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
    private MobileElement btnNickNameDone;

    //card Nick name
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Mobile Access\"]//XCUIElementTypeCell//XCUIElementTypeOther//XCUIElementTypeImage//following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtCardNickName;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */
    public MobileElement getImgHIDDigiCard() {
        return imgHIDDigiCard;
    }

    public MobileElement getNavDetailedView() {
        return navDetailedView;
    }

    public MobileElement getBtnDetViewBack() {
        return btnDetViewBack;
    }

    public MobileElement getTxtDetailedView() {
        return txtDetailedView;
    }

    public MobileElement getImgProfilePic() {
        return imgProfilePic;
    }

    public MobileElement getTxtNickname() {
        return txtNickname;
    }

    public MobileElement getBtnHighlight() {
        return btnHighlight;
    }

    public MobileElement getTxtSupportHeader() {
        return txtSupportHeader;
    }

    public MobileElement getImgCall() {
        return imgCall;
    }

    public MobileElement getTxtCall() {
        return txtCall;
    }

    public MobileElement getImgGetMail() {
        return imgGetMail;
    }

    public MobileElement getTxtGetEMail() {
        return txtGetEMail;
    }

    public MobileElement getImgWebsite() {
        return imgWebsite;
    }

    public MobileElement getTxtWebsite() {
        return txtWebsite;
    }

    public MobileElement getTxtInformation() {
        return txtInformation;
    }

    public MobileElement getTxtMobileUserName() {
        return txtMobileUserName;
    }

    public MobileElement getTxtMobileUserValue() {
        return txtMobileUserValue;
    }

    public MobileElement getTxtFriendlyName() {
        return txtFriendlyName;
    }

    public MobileElement getTxtFriendlyValue() {
        return txtFriendlyValue;
    }

    public MobileElement getWndSwitchCall() {
        return wndSwitchCall;
    }

    public MobileElement getTxtSendEmailHeader() {
        return txtSendEmailHeader;
    }

    public MobileElement getTxtEmailMessage() {
        return txtEmailMessage;
    }

    public MobileElement getBtnCancelMail() {
        return btnCancelMail;
    }

    public MobileElement getBtnOpenMail() {
    return btnOpenMail;
}

    public MobileElement getTxtWebsiteHeader() {
        return txtWebsiteHeader;
    }

    public MobileElement getTxtWebsiteMessage() {
        return txtWebsiteMessage;
    }

    public MobileElement getBtnViewWebsite() {
        return btnViewWebsite;
    }

    public MobileElement getNavEmailNewMsg() {
        return navEmailNewMsg;
    }

    public MobileElement getBtnEmailCancel() {
        return btnEmailCancel;
    }

    public MobileElement getBtnEmailDelete() {
        return btnEmailDelete;
    }

    public MobileElement getTxtEditNickName() {
        return txtEditNickName;
    }

    public MobileElement getBtnNickNameDone() {
        return btnNickNameDone;
    }

    public MobileElement getTxtCardNickName() {
        return txtCardNickName;
    }

    /**
     * clickHIDCard- This method is used to click the card in mobile ID screen
     *
     * @return- boolean Date-25/1/2023
     */
    public void clickHIDCard() {
        try {
            //click(imgHIDDigiCard);
            imgHIDDigiCard.click();
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on HID Card in Mobile IDs screen...");
        }
    }

    public void chkOrgSpecificInfo() {
        try {
            waitForVisibility(navDetailedView);
            if(navDetailedView.isDisplayed()) {
                Assert.assertTrue(isElementVisible(txtDetailedView));
                Assert.assertTrue(isElementVisible(btnDetViewBack));
                    //Profile
                Assert.assertTrue(isElementVisible(imgProfilePic));
                Assert.assertTrue(isElementVisible(txtNickname));
                Assert.assertTrue(isElementVisible(btnHighlight));
                    //Support
                Assert.assertTrue(isElementVisible(txtSupportHeader));
                    //Call
                Assert.assertTrue(isElementVisible(imgCall));
                Assert.assertTrue(isElementVisible(txtCall));
                    //Email
                Assert.assertTrue(isElementVisible(imgGetMail));
                Assert.assertTrue(isElementVisible(txtGetEMail));
                    //Website
                Assert.assertTrue(isElementVisible(imgWebsite));
                Assert.assertTrue(isElementVisible(txtWebsite));
                    //Information
                Assert.assertTrue(isElementVisible(txtInformation));
                Assert.assertTrue(isElementVisible(txtMobileUserName));
                Assert.assertTrue(isElementVisible(txtMobileUserValue));
                Assert.assertTrue(isElementVisible(txtFriendlyName));
                Assert.assertTrue(isElementVisible(txtFriendlyValue));
            } else {
                TestUtils.log().info("Detailed view of information is not displayed...");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying the Detailed view of information...");
        }
    }

    public void clickCallButton() {
        try {
            if(txtCall.isEnabled()) {
                click(txtCall);
                Assert.assertTrue(isElementVisible(wndSwitchCall));
                click(wndSwitchCall);
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on Call in Org specific screen...");
        }
    }

    public void clickEmailButton() {
        try {
            if(txtGetEMail.isEnabled()) {
                click(txtGetEMail);
                Assert.assertTrue(isElementVisible(txtSendEmailHeader));
                Assert.assertTrue(isElementVisible(txtEmailMessage));
                Assert.assertTrue(isElementVisible(btnCancelMail));
                Assert.assertTrue(isElementVisible(btnOpenMail));
                click(btnCancelMail);
                //Open in Mail
                click(txtGetEMail);
                click(btnOpenMail);
                Assert.assertTrue(isElementVisible(navEmailNewMsg));
                click(btnEmailCancel);
                click(btnEmailDelete);
                switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on Email in Org specific screen...");
        }
    }

    public void clickWebsiteButton() {
        try {
            if(txtWebsite.isEnabled()) {
                click(txtWebsite);
                Assert.assertTrue(isElementVisible(txtWebsiteHeader));
                Assert.assertTrue(isElementVisible(txtWebsiteMessage));
                Assert.assertTrue(isElementVisible(btnCancelMail));
                Assert.assertTrue(isElementVisible(btnViewWebsite));
                click(btnCancelMail);
                //Open in Mail
                click(txtWebsite);
                click(btnViewWebsite);
                switchToAnotherApp(ConfigLoader.getInstance().getiOSBundleID());
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on Website in Org specific screen...");
        }
    }

    public void clickDetailedViewBack() {
        try {
            click(btnDetViewBack);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on back button from detailed view screen...");
        }
    }

    public void addNickName(String nickName) {
        try {
            click(btnHighlight);
            sendKeys(txtEditNickName, nickName);
            click(btnNickNameDone);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while adding the nick name in detailed view screen...");
        }
    }

    public void chkEditedNickname(String nickName) {
        try {
            String strValue = txtCardNickName.getAttribute(MessageConstants.VALUE_STRING);
            if(strValue.equals(nickName)) {
                TestUtils.log().info("Nick Name value is displayed as expected in the card...");
            } else {
                TestUtils.log().info("Nick Name value is NOT displayed as expected in the card...");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the Nick name in the card...");
        }
    }

}
