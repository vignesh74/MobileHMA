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

}
