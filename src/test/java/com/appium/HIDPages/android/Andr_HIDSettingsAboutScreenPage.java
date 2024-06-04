package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class Andr_HIDSettingsAboutScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in About Screen Page Date-13/02/2023
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private MobileElement txtAboutHeadline;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='APPLICATION INFO']")
    private MobileElement txtApplicationInfo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ENDPOINT INFO']")
    private MobileElement txtEndPointInfo;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Back Arrow\"]")
    private MobileElement imgBackFromAbout;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private MobileElement txtAbout;


    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-13/02/2023
     */

    public MobileElement getTxtAboutHeadline() {
        return txtAboutHeadline;
    }

    public MobileElement getTxtApplicationInfo() {
        return txtApplicationInfo;
    }

    public MobileElement getTxtEndPointInfo() {
        return txtEndPointInfo;
    }

    public MobileElement getImgBackFromAbout() {
        return imgBackFromAbout;
    }
    public MobileElement getTxtAbout() {
        return txtAbout;
    }


    /**
     * isAboutScreenPageDisplayed- This method is used to check the about screen is displayed or not Date-13/02/2023
     */

    public void isAboutScreenPageDisplayed() {
        try {
            waitForVisibility(txtEndPointInfo);
            Assert.assertTrue(isElementVisible(txtAboutHeadline));
            Assert.assertTrue(isElementVisible(txtApplicationInfo));
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while displaying About Screen...");
        }
    }

    /**
     * backFromAboutScreen- This method is used to back from the about screen Date-13/02/2023
     */

    public void backFromAboutScreen() {
        try {
            click(imgBackFromAbout);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while coming back from About Screen...");
        }
    }

    /**
     * clickAndVerifyAboutScreen- This method is used to click on About screen Date-13/02/2023
     */
    public void clickOnAboutScreen() {
        try {
            click(txtAbout);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on About Screen...");
        }
    }

}
