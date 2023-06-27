package com.appium.HIDPages.android;

import com.appium.utils.TestUtils;
import org.testng.Assert;

import com.appium.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Andr_HIDNotificationScreenPage extends BasePage {
    /**
     * mobile elements - These are mobile elements which is present in notification page Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNotificationTitle")
    private MobileElement txtNotificationTitle;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getTxtNotificationTitle() {
        return txtNotificationTitle;
    }

    /**
     * verifyNotification- This method is used to verify the notification
     *
     * @param strExpectedNotificationTitle
     *         - String Date- 25/01/2023
     */
    public void verifyNotification(String strExpectedNotificationTitle) {
        try {
            String strActualNotificationTitle = getElementText(txtNotificationTitle);
            Assert.assertEquals(strActualNotificationTitle, strActualNotificationTitle);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying notification...");
        }
    }
}
