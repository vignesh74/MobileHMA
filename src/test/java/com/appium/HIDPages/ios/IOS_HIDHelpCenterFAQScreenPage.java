package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterFAQScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Help Center FAQ Screen Page Date-25/10/2023
     */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FAQ\"]")
    private MobileElement btnHelpCenterFAQ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"FAQIcon\"]")
    private MobileElement btnHelpCenterFAQIcon;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"FAQ\"]")
    private MobileElement txtHelpCenterFAQ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"FAQIcon\"]//following-sibling::XCUIElementTypeImage")
    private MobileElement imgFAQForward;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"FAQ\"]")
    private MobileElement navBarFAQ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]")
    private MobileElement btnHelpCentreBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"FAQ\"]")
    private MobileElement txtFAQHeader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField[@name=\"Search\"]")
    private MobileElement boxSearchField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About HID Mobile Access\"]")
    private MobileElement txtAboutHIDMobAccess;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"SupportCenterBackofCard\"]")
    private MobileElement imgSupCentBackOfCard;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Effortless Contact Management\"]")
    private MobileElement txtEffortlessContact;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"SupportCenterFAQ\"]")
    private MobileElement imgSupCentFAQ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"HID Mobile Access FAQ\"]")
    private MobileElement txtHIDMobileFAQ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"SupportCenterNearbyReader\"]")
    private MobileElement imgSupCentNearbyReader;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Introducing Nearby Readers\"]")
    private MobileElement txtNearbyReaders;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Forward\"][1]")
    private MobileElement btnQuestForward;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Clear text\"]")
    private MobileElement btnClearText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sorry, no matching results could be found. Try rephrasing your query, or if you need assistance, please contact our Support Team.\"]")
    private MobileElement txtSorryNoMatch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Didn't find what you're looking for?\"]")
    private MobileElement txtLookingForQuest;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Tell us so that we can learn and show better results to you in the future!\"]")
    private MobileElement txtTellUs;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Let us know\"]")
    private MobileElement txtLetUsKnow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"SupportCenterFAQIcon\"]")
    private MobileElement imgSupCentFAQIcon;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/10/2023
     */

    public MobileElement getBtnHelpCenterFAQ() {
        return btnHelpCenterFAQ;
    }

    public MobileElement getBtnHelpCenterFAQIcon() {
        return btnHelpCenterFAQIcon;
    }

    public MobileElement getTxtHelpCenterFAQ() {
        return txtHelpCenterFAQ;
    }

    public MobileElement getImgFAQForward() {
        return imgFAQForward;
    }

    public MobileElement getNavBarFAQ() {
        return navBarFAQ;
    }

    public MobileElement getBtnHelpCentreBack() {
        return btnHelpCentreBack;
    }

    public MobileElement getTxtFAQHeader() {
        return txtFAQHeader;
    }

    public MobileElement getBoxSearchField() {
        return boxSearchField;
    }

    public MobileElement getTxtAboutHIDMobAccess() {
        return txtAboutHIDMobAccess;
    }

    public MobileElement getImgSupCentBackOfCard() {
        return imgSupCentBackOfCard;
    }

    public MobileElement getTxtEffortlessContact() {
        return txtEffortlessContact;
    }

    public MobileElement getImgSupCentFAQ() {
        return imgSupCentFAQ;
    }

    public MobileElement getTxtHIDMobileFAQ() {
        return txtHIDMobileFAQ;
    }

    public MobileElement getImgSupCentNearbyReader() {
        return imgSupCentNearbyReader;
    }

    public MobileElement getTxtNearbyReaders() {
        return txtNearbyReaders;
    }

//********************FAQ Methods Begins here*******************

    /**
     * clickOnFAQButton- This method is used to click on FAQ from Help centre screen Date-25/10/2023
     */
    public void clickOnFAQButton() {
        try {
            click(btnHelpCenterFAQ);
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while clicking on FAQ button in Help centre...");
        }
    }

    /**
     * isFAQScreenDisplayed- This method is used to identify the FAQ screen is displayed or not Date-25/10/2023
     */
    public void isFAQScreenDisplayed() {
        try {
            waitForVisibility(navBarFAQ);
            Assert.assertTrue(isElementVisible(txtFAQHeader));
            Assert.assertTrue(isElementVisible(btnHelpCentreBack));
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while displaying FAQ screen...");
        }
    }

    /**
     * checkFAQScreen- This method is used to verify the elements of FAQ screen Date - 25/10/2023
     */
    public void checkFAQScreen() {
        try {
            Assert.assertTrue(isElementVisible(boxSearchField));
            Assert.assertTrue(isElementVisible(txtAboutHIDMobAccess));
           /* if(imgSupCentBackOfCard.isDisplayed() | imgSupCentFAQ.isDisplayed() | imgSupCentNearbyReader.isDisplayed()) {
                TestUtils.log().info("FAQ screen is displayed with scroll view Banners");
            }
            else {
                TestUtils.log().info("FAQ screen is NOT displayed with scroll view Banners");
            } */
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the FAQ screen values...");
        }
    }

    /**
     * verifySearchFieldValid- This method is used to verify the search field of FAQ screen - Date - 25/10/2023
     */
    public void verifySearchFieldValid() {
        try {
            if(boxSearchField.isDisplayed()) {
                sendKeys(boxSearchField, "Test");
                Assert.assertTrue(isElementVisible(btnQuestForward));
                TestUtils.log().info("FAQ screen is displayed with searched element");
                click(btnClearText);
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the FAQ screen values...");
        }
    }

    /**
     * verifySearchFieldInValid- This method is used to verify the search field of FAQ screen - Date - 25/10/2023
     */
    public void verifySearchFieldInValid() {
        try {
            if(boxSearchField.isDisplayed()) {
                sendKeys(boxSearchField, "FHH");
                waitForVisibility(txtSorryNoMatch);
                Assert.assertTrue(isElementVisible(txtSorryNoMatch));
                Assert.assertTrue(isElementVisible(txtLookingForQuest));
                Assert.assertTrue(isElementVisible(txtTellUs));
                Assert.assertTrue(isElementVisible(txtLetUsKnow));
                Assert.assertTrue(isElementVisible(imgSupCentFAQIcon));
                TestUtils.log().info("FAQ screen is NOT displayed with searched element");
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the FAQ screen values...");
        }
    }

    /**
     * clickLetUsKnow- This method is used to click on Let us know from FAQ screen Date-25/10/2023
     */
    public void clickLetUsKnow() {
        try {
            click(txtLetUsKnow);
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while clicking on FAQ button in Help centre...");
        }
    }

    /**
     * clickFAQBackBtn- This method is used to click on Back button from FAQ screen Date-25/10/2023
     */
    public void clickFAQBackBtn() {
        try {
            click(btnHelpCentreBack);
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while clicking on FAQ back button in Help centre...");
        }
    }
}
