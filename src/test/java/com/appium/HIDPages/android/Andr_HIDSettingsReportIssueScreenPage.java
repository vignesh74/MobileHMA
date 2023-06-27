package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class Andr_HIDSettingsReportIssueScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Report Issue Screen Page Date-Date-13/02/2023
     */

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtReportIssue")
    private MobileElement txtReportIssueHeadline;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBackButton")
    private MobileElement imgBackFromReportIssue;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtDescription")
    private MobileElement txtDescription;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edtTxtIssueDescription")
    private MobileElement tbxDescription;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnSubmit")
    private MobileElement btnSubmit;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-13/02/2023
     */

    public MobileElement getTxtReportIssueHeadline() {
        return txtReportIssueHeadline;
    }

    public MobileElement getImgBackFromReportIssue() {
        return imgBackFromReportIssue;
    }

    public MobileElement getTxtDescription() {
        return txtDescription;
    }

    public MobileElement getTbxDescription() {
        return tbxDescription;
    }

    public MobileElement getBtnSubmit() {
        return btnSubmit;
    }

    /**
     * isReportIssuePageDisplayed- This method is used to check the report issue screen is displayed or not Date-13/02/2023
     */

    public void isReportIssuePageDisplayed() {
        try {
            waitForVisibility(txtDescription);
            Assert.assertTrue(isElementVisible(txtReportIssueHeadline));
            Assert.assertTrue(isElementVisible(tbxDescription));
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while displaying Report Issue Screen...");
        }
    }

    /**
     * verifySubmitButtonEnable- This method is used to verify submit button enable or not Date-13/02/2023
     */

    public void verifySubmitButtonEnable(String text) {
        try {
            if (!btnSubmit.isEnabled()) {
                isElementVisible(tbxDescription);
                sendKeys(tbxDescription, text);
                hideKeyboard();
                Assert.assertTrue(btnSubmit.isEnabled());
            } else {
                TestUtils.log().info("Fail to Enable the submit button");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while enable and verifying Submit button...");
        }
    }

    /**
     * backFromReportIssue- This method is used to back from the report issue screen Date-13/02/2023
     */

    public void backFromReportIssue() {
        try {
            click(imgBackFromReportIssue);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while coming back from Report Screen...");
        }
    }

}
