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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Report Issue']")
    private MobileElement txtReportIssueHeadline;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Back Arrow\"]")
    private MobileElement imgBackFromReportIssue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']")
    private MobileElement txtDescription;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement tbxDescription;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SUBMIT']")
    private MobileElement btnSubmit;

    @AndroidFindBy(id = "android:id/button_once")
    private MobileElement justOnce;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement txtEdit;

    @AndroidFindBy(id = "com.google.android.gm:id/attachment_tile_title")
    private MobileElement txtAttachement;

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

    public MobileElement getJustOnce() {
        return justOnce;
    }

    public MobileElement getTxtEdit() {
        return txtEdit;
    }

    public MobileElement getTxtAttachement() {
        return txtAttachement;
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
            sendKeys(tbxDescription, text);
            hideKeyboard();
            String attr = getElementAttribute(btnSubmit,"enabled");
            Assert.assertEquals(attr,"true");

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

    public void shareLogs(){
        try{
            click(getJustOnce());
            getTxtEdit().getText().contains("Issue Description");
        }catch (Exception e){
            TestUtils.log().debug("Exception occurred while sharing the logs");
        }
    }

    public void checkAttachment(String DebugLogs){
        try{
            if(DebugLogs.equalsIgnoreCase("Enable")){
                hideKeyboard();
                scrollDownTillElement( 80000, 5);
                waitForVisibility(txtAttachement);
                Assert.assertTrue(isElementVisible(txtAttachement));
                getTxtAttachement().getText().contains(".log");
                TestUtils.log().debug("Attachment is visible");

            }else if(DebugLogs.equalsIgnoreCase("Disable")){
                hideKeyboard();
                if(!isElementVisible(txtAttachement)){
                    TestUtils.log().debug("Attachment is not visible");
                }
            }

        }catch (Exception e){
            TestUtils.log().debug("Exception occurred while checking the attachment.");
        }
    }


}
