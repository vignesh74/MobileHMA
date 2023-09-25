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

}
