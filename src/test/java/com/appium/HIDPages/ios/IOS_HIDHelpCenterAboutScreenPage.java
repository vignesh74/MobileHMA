package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterAboutScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Help Center About Screen Page Date-25/1/2023
     */
    @iOSXCUITFindBy(xpath = "//*[@name='About']//following-sibling:: XCUIElementTypeStaticText")
    private MobileElement txtHelpCenterAbout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"APPLICATION INFO\"]")
    private MobileElement txtHelpCenterApplicationInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ENDPOINT INFO\"]")
    private MobileElement txtHelpCenterEndPointInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]")
    private MobileElement imgAboutBack;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getTxtHelpCenterAbout() {
        return txtHelpCenterAbout;
    }

    public MobileElement getBtnHelpCenterAboutBack() {
        return imgAboutBack;
    }

    public MobileElement getTxtHelpCenterApplicationInfo() {
        return txtHelpCenterApplicationInfo;
    }

    public MobileElement getTxtHelpCenterEndPointInfo() {
        return txtHelpCenterEndPointInfo;
    }

    public MobileElement getImgAboutBack() {
        return imgAboutBack;
    }

    /**
     * isAboutScreenDisplayed- This method is used to identify the about screen is displayed or not Date-25/1/2023
     */

    public void isAboutScreenDisplayed() {
        try {
            waitForVisibility(txtHelpCenterAbout);
            Assert.assertTrue(isElementVisible(txtHelpCenterApplicationInfo));
            Assert.assertTrue(isElementVisible(txtHelpCenterEndPointInfo));
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while displaying about screen...");
        }
    }

    /**
     * clickOnBackButtonAbout- This method is used to click on back from about screen Date-25/1/2023
     */
    public void clickOnBackButtonAbout() {
        try {
            click(imgAboutBack);
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking on back button about...");
        }
    }
}
