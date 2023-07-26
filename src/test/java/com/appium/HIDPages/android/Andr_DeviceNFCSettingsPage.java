package com.appium.HIDPages.android;

import com.appium.base.BasePage;

import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

public class Andr_DeviceNFCSettingsPage extends BasePage {
    /**
     * object created to access methods from page classes Date- 25/01/2023
     */
    Andr_HIDAppPreferencesScreenPage appPrefencesScreenPage = new Andr_HIDAppPreferencesScreenPage();
    /**
     * mobile elements - These are mobile elements which is present in device NFC settings page Date-25/01/2023
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_text", priority = 0)
    @AndroidFindBy(id = "android:id/switch_text", priority = 1)
    private MobileElement txtSwitchOnOff;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_widget", priority = 0)
    @AndroidFindBy(id = "android:id/switch_widget", priority = 1)
    private MobileElement btnOnOff;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='NFC']")
    private MobileElement nfcTab;

    /**
     * These mobile elements are used for validating NFC Warning Banners
     */
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC Disabled']")
    private MobileElement nfcDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable NFC to use your Mobile ID by presenting your phone to the reader.']")
    private MobileElement nfcDisabledText;


    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getTxtSwitchOnOff() {
        return txtSwitchOnOff;
    }

    public MobileElement getBtnOnOff() {
        return btnOnOff;
    }

    /**
     * setNFCStatus- This method is used to set the NFC status
     *
     * @param -
     *         strNFCStatus - String Date-25/01/2023
     */
    public void setNFCStatus(String strNFCStatus) {
        try {
            String strNFCStatusValue = getElementText(appPrefencesScreenPage.getTxtNFCStatusValue());
            if (!strNFCStatus.equalsIgnoreCase(strNFCStatusValue)) {
                appPrefencesScreenPage.clickOnNFCTab();
                waitForVisibility(nfcTab);
                click(nfcTab);
                waitForVisibility(btnOnOff);
                click(btnOnOff);
                waitForGivenTime(1);
                if (isDisplayed(txtSwitchOnOff)) {
                    String strActualNFCStatus = getElementText(txtSwitchOnOff);
                    TestUtils.log().info("NFC has been set as {}",strActualNFCStatus);
                    Assert.assertTrue(strNFCStatus.equalsIgnoreCase(strActualNFCStatus), "NFC status set as" + strActualNFCStatus);
                    TestUtils.log().info("NFC as: {}",strActualNFCStatus);
                }
                loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), "navigateBack", 10);
                waitForGivenTime(1);
                Assert.assertTrue(strNFCStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtNFCStatusValue().getText()));
                TestUtils.log().info("NFC has been set as {}",appPrefencesScreenPage.getTxtNFCStatusValue().getText());
            } else {
                TestUtils.log().info("NFC is already set as {}",strNFCStatus);
            }

        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while setting the NFC status...{}",e.getMessage());
        }

    }
    public void setNFCStatusWb(String strNFCStatus) {
        try {
            String strNFCStatusValue = getElementText(appPrefencesScreenPage.getTxtNFCStatusValue());

            if (!strNFCStatus.equalsIgnoreCase(strNFCStatusValue)) {
                if(strNFCStatusValue.equalsIgnoreCase("Off")){
                    click(nfcDisabled);
                    waitForVisibility(nfcTab);
                    click(nfcTab);
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    waitForGivenTime(1);
                 /*   if (isDisplayed(txtSwitchOnOff)) {
                        String strActualNFCStatus = getElementText(txtSwitchOnOff);
                        TestUtils.log().info("NFC has been set as {}", strActualNFCStatus);
                        Assert.assertTrue(strNFCStatus.equalsIgnoreCase(strActualNFCStatus), "NFC status set as" + strActualNFCStatus);
                        TestUtils.log().info("NFC as: {}", strActualNFCStatus);
                    }*/
                    loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), "navigateBack", 10);
                    waitForGivenTime(1);
                    Assert.assertTrue(strNFCStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtNFCStatusValue().getText()));
                    TestUtils.log().info("NFC has been set as {}", appPrefencesScreenPage.getTxtNFCStatusValue().getText());
                }
                else if(strNFCStatusValue.equalsIgnoreCase("On")){
                    appPrefencesScreenPage.clickOnNFCTab();
                    waitForVisibility(nfcTab);
                    click(nfcTab);
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    waitForGivenTime(1);
                  /*  if (isDisplayed(txtSwitchOnOff)) {
                        String strActualNFCStatus = getElementText(txtSwitchOnOff);
                        TestUtils.log().info("NFC has been set as {}", strActualNFCStatus);
                        Assert.assertTrue(strNFCStatus.equalsIgnoreCase(strActualNFCStatus), "NFC status set as" + strActualNFCStatus);
                        TestUtils.log().info("NFC as: {}", strActualNFCStatus);
                    }*/
                    loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), "navigateBack", 10);
                    waitForGivenTime(1);
                    Assert.assertTrue(strNFCStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtNFCStatusValue().getText()));
                    TestUtils.log().info("NFC has been set as {}", appPrefencesScreenPage.getTxtNFCStatusValue().getText());
                }
            }
            else
            {
                TestUtils.log().info("NFC is already set as {}",strNFCStatus);
            }

        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while setting the NFC status...{}",e.getMessage());
        }

    }
}
