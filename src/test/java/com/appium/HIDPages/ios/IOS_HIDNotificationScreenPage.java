package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDNotificationScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in notification Page Date-25/1/2023
     */
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Notifications\"]")
    private MobileElement tabNotifications;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Notifications\"]")
    private MobileElement txtNotifications;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"New Mobile ID issued\"]")
    private MobileElement txtMessage1Notifications;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A new Mobile ID is now ready for use\"]")
    private MobileElement txtMessage2Notifications;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getTxtNotifications() {
        return txtNotifications;
    }

    public MobileElement getTabNotifications() {
        return tabNotifications;
    }

    public MobileElement getMsg1Notifications() {
        return txtMessage1Notifications;
    }

    public MobileElement getTxtMessage2Notifications() {
        return txtMessage2Notifications;
    }

    /**
     * isNotificationScreenDisplay- This method is used to verify the notification screen is displayed or not
     *
     * @return- boolean Date-25/1/2023
     */
    public boolean isNotificationScreenDisplay() {
        return isElementVisible(txtNotifications);
    }

    /**
     * clickOnNotificationAndVerify- This method is used to click and verify the notification screen Date-25/1/2023
     */
    public void clickOnNotificationAndVerify(String strMessage1, String strMessage2) {
        try {
            if (DriverManager.getPlatformVersion().contains("14")) {
                TestUtils.log().info("Notification Screen is not displayed in this iOS version");
            } else {
                click(tabNotifications);
                iOSScrollDownTillElement(txtMessage2Notifications);
                Assert.assertTrue(isNotificationScreenDisplay());
                Assert.assertEquals(getElementText(txtMessage1Notifications), strMessage1);
                Assert.assertEquals(getElementText(txtMessage2Notifications), strMessage2);
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while displaying Notification Screen...");
        }
    }

}
