package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class Andr_HIDSettingsScreenPage extends BasePage {
    Andr_HIDMobileIDScreenPage mobileIDScreenPage = new Andr_HIDMobileIDScreenPage();
    Andr_HIDAppPreferencesScreenPage appPrefencesScreenPage = new Andr_HIDAppPreferencesScreenPage();

    /**
     * mobile elements - These are mobile elements which is present in Settings page
     * Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtSettings")
    private MobileElement txtSettingsTitle;
    @AndroidFindBy(xpath = "//*[@text='App Preferences']")
    private MobileElement txtAppPreference;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
    private MobileElement txtAbout;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Legal']")
    private MobileElement txtLegal;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Report Issue']")
    private MobileElement txtReportIssue;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtLegal")
    private MobileElement txtLegalHeadline;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtReportIssue")
    private MobileElement txtReportIssueHeadline;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edtTxtIssueDescription")
    private MobileElement txtareaDescription;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnSubmit")
    private MobileElement btnSubmit;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Unregister This Device']")
    private MobileElement txtUnRegisterThisDevice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Confirm Unregister']")
    private MobileElement txtConfirmUnregisterPopUpTitle;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='UNREGISTER']")
    private MobileElement btnUnRegister;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='You have successfully unregistered from HID Mobile Access. All your Mobile IDs have been deleted.']")
    private MobileElement txtDeviceUnRegistredMessage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnOk")
    private MobileElement btnOk;

    public MobileElement getTxtConfirmUnregisterPopUpTitle() {
        return txtConfirmUnregisterPopUpTitle;
    }

    public MobileElement getBtnUnRegister() {
        return btnUnRegister;
    }

    public MobileElement getTxtUnRegisterThisDevice() {
        return txtUnRegisterThisDevice;
    }

    public MobileElement getTxtAppPreference() {
        return txtAppPreference;
    }

    public MobileElement getTxtAbout() {
        return txtAbout;
    }

    public MobileElement getTxtLegal() {
        return txtLegal;
    }

    public MobileElement getTxtReportIssue() {
        return txtReportIssue;
    }

    public MobileElement getTxtLegalHeadline() {
        return txtLegalHeadline;
    }

    public MobileElement getTxtReportIssueHeadline() {
        return txtReportIssueHeadline;
    }

    public MobileElement getTxtareaDescription() {
        return txtareaDescription;
    }

    public MobileElement getBtnSubmit() {
        return btnSubmit;
    }

    public void clickOnAppPreferences() {
        try {
            click(txtAppPreference);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on app preferences...");
        }

    }

    /**
     * checkReportIssue- This method click on report issue and verify the report issue headline
     * Date-25/01/2023
     */
    public void checkReportIssue() {
        try {
            click(txtReportIssue);
            Assert.assertTrue(txtReportIssueHeadline.isDisplayed());
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking report issue...");
        }
    }

    /**
     * sendTextInReportIssue- This method send text to description area in report issue screen Date-25/01/2023
     */
    public void sendTextInReportIssue(String text) {
        try {
            sendKeys(txtareaDescription, text);
            Assert.assertTrue(btnSubmit.getAttribute("enabled").equals("true"));
            navigateBack();
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while sending text in report issue...");
        }
    }

    /**
     * checkLegalScreen- It is used to verify legal screen headline
     * Date-25/01/2023
     */
    public void checkLegalScreen() {
        try {
            click(txtLegal);
            Assert.assertTrue(txtLegalHeadline.isDisplayed());
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking Legal Screen...");
        }
    }

    /**
     * checkAboutScreen- It is used to verify About screen headline
     * Date-25/01/2023
     */
    public void checkAboutScreen() {
        try {
            navigateBack();
            click(txtAbout);
            waitForGivenTime(2);
            Assert.assertTrue(txtAbout.isDisplayed());
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking About Screen...");
        }
    }

   /**
     * unRegisterThisDevice - This method is used to unregister mobile device
     * Date-25/01/2023
     */
    public void unRegisterThisDevice() {
        try {
            if (isElementVisible(txtUnRegisterThisDevice)) {
                click(txtUnRegisterThisDevice);
                if (isDisplayed(txtConfirmUnregisterPopUpTitle)) {
                    click(btnUnRegister);
                    waitForGivenTime(2);
                    if (isDisplayed(txtDeviceUnRegistredMessage)) {
                        click(btnOk);
                        waitForGivenTime(2);
                        TestUtils.log().info("Device has been Unregistered");
                    }
                }
            }
        }catch (Exception e){
            
            TestUtils.log().info("Getting Exception while performing device unregister.");
        }
    }

    /**
     * traverseToSettingsPage- This method is used to traverse to the setting page from app preferences or mobile id page
     * Date-22/02/2023
     */
    public void traverseToSettingsPage()
    {
        try {
            if (isDisplayed(appPrefencesScreenPage.getTxtAppPreferences()))
            {
                loopHandle(mobileIDScreenPage.getSettingsTab(), "navigateBack", 3);
                if (isElementVisible(mobileIDScreenPage.getSettingsTab())) {
                    TestUtils.log().info("Setting page is displayed");
                }
            } else if (isDisplayed(mobileIDScreenPage.getTxtViewMobileIdCard())) {
                click(mobileIDScreenPage.getSettingsTab());
                waitForGivenTime(2);
            }
        }catch(Exception e){
            
            TestUtils.log().info("Getting Exception while coming to settings screen");
        }
    }

    /**
     * VerifySettingsScreen- This method is used to verify Settings screen displayed or not Date-13/02/2023
     */
    public void verifySettingsScreen() {
        try {
            waitForVisibility(txtAbout);
            Assert.assertTrue(isElementVisible(txtSettingsTitle));
            Assert.assertTrue(isElementVisible(txtAppPreference));
            Assert.assertTrue(isElementVisible(txtLegal));
            Assert.assertTrue(isElementVisible(txtReportIssue));
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while verifying to settings screen...");
        }
    }

    /**
     * clickAndVerifyLegalScreen- This method is used to click on legal screen Date-13/02/2023
     */
    public void clickOnLegalScreen() {
        try {
            click(txtLegal);
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking on Legal Screen...");
        }
    }

    /**
     * clickAndVerifyReportIssueScreen- This method is used to click on report issue screen Date-13/02/2023
     */
    public void clickOnReportIssueScreen() {
        try {
            click(txtReportIssue);
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking on Report Issue Screen...");
        }
    }

    /**
     * clickAndVerifyAboutScreen- This method is used to click on About screen Date-13/02/2023
     */
    public void clickOnAboutScreen() {
        try {
            click(txtAbout);
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking on About Screen...");
        }
    }


}
