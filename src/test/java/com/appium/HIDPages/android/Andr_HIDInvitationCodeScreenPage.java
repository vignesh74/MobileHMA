package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Andr_HIDInvitationCodeScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in invitation code page Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edInviteCode")
    private MobileElement txtbxInvitationCode;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnGetStarted")
    private MobileElement btnGetStarted;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getInvitationTextBox() {
        return txtbxInvitationCode;
    }

    public MobileElement getGetStartedButton() {
        return btnGetStarted;
    }

    /**
     * enterInvitationCode- This method is used to enter the invitation code
     *
     * @param strInvitationCode
     *         - String Date-25/01/2023
     */
    public void enterInvitationCode(String strInvitationCode) {
        try {
            if (isDisplayed(txtbxInvitationCode)) {
                sendKeys(txtbxInvitationCode, strInvitationCode);
            } else {
                TestUtils.log().info("InvitationCode TextBox is not displayed");
            }
            click(btnGetStarted);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while entering invitation code...");
        }
    }
}
