package com.appium.HIDPages.android;

import com.appium.base.BasePage;

import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.NAVIGATE_BACK;

public class Andr_DeviceNFCSettingsPage extends BasePage {
    /**
     * object created to access methods from page classes Date- 25/01/2023
     */
    Andr_HIDAppPreferencesScreenPage appPrefencesScreenPage = new Andr_HIDAppPreferencesScreenPage();
    Andr_HIDMobileIDScreenPage mobileIDScreenPage=new Andr_HIDMobileIDScreenPage();
    Andr_HIDSettingsScreenPage settingsScreenPage=new Andr_HIDSettingsScreenPage();
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

    @AndroidFindBy(id="com.android.settings:id/switch_widget")
    private MobileElement btnNFCOnOff;

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

    public MobileElement getBtnNFCOnOff() {
        return btnNFCOnOff;
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
                if (DriverManager.getPlatformVersion().equalsIgnoreCase("13")) {
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    waitForGivenTime(1);
                }else{
                    waitForVisibility(nfcTab);
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    waitForGivenTime(1);
                }

                /**LOCATORS ARE NOT MODIFIED.THE OUTPUT IS NOT AS EXPECTED.SEPARATE METHOD HAS BEEN WRITTEN **/

          /*      if (isDisplayed(txtSwitchOnOff)) {
                    String strActualNFCStatus = getElementText(txtSwitchOnOff);
                    TestUtils.log().info("NFC has been set as {}",strActualNFCStatus);
                    Assert.assertTrue(strNFCStatus.equalsIgnoreCase(strActualNFCStatus), "NFC status set as" + strActualNFCStatus);
                    TestUtils.log().info("NFC as: {}",strActualNFCStatus);
                }*/
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

    public void setNFCStatus1(String strNFCStatus) {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            String strNFCStatusValue = getElementText(appPrefencesScreenPage.getTxtNFCStatusValue());
            if (!strNFCStatus.equalsIgnoreCase(strNFCStatusValue)) {
                appPrefencesScreenPage.clickOnNFCTab();
                switch (strPlatformVersion) {
                    case "9","00" -> {
                        click(btnNFCOnOff);
                        String strAttr = getElementAttribute(btnNFCOnOff, "Checked");
                        if (strAttr.equalsIgnoreCase("false")) {
                            TestUtils.log().info("NFC Status set as {}", btnNFCOnOff);
                        }
                        loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), NAVIGATE_BACK, 10);
                    }
                    case "19" ->{
                        System.out.println("Entered");
                        click(btnNFCOnOff);
                        String strAttr = getElementAttribute(btnNFCOnOff, "Checked");
                        if (strAttr.equalsIgnoreCase("false")) {
                            TestUtils.log().info("NFC Status set as {}", strNFCStatus);
                        }
                        loopHandle(appPrefencesScreenPage.getTxtAppPreferences(), NAVIGATE_BACK, 10);
                    }

                    default -> {
                        click(btnNFCOnOff);
                        String strActualNFCStatus = getElementText(txtSwitchOnOff);
                        TestUtils.log().info("NFC has been set as {}",strActualNFCStatus);
                        System.out.println("strActualNFCStatus  "+ strActualNFCStatus);
                        Assert.assertTrue(strNFCStatus.equalsIgnoreCase(strActualNFCStatus));
                        loopHandle(appPrefencesScreenPage.getTxtBluetoothStatusValue(), NAVIGATE_BACK, 10);
                        Assert.assertTrue(strActualNFCStatus.equalsIgnoreCase(appPrefencesScreenPage.getTxtNFCStatusValue().getText()));
                    }
                }

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

                    /**LOCATORS ARE NOT MODIFIED.THE OUTPUT IS NOT AS EXPECTED.SEPARATE METHOD HAS BEEN WRITTEN **/
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

                    /**LOCATORS ARE NOT MODIFIED.THE OUTPUT IS NOT AS EXPECTED.SEPARATE METHOD HAS BEEN WRITTEN **/
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

    public void setNFCStatusWbWf3(String strNFCStatus) {
        try {
            String strNFCStatusValue = getElementText(appPrefencesScreenPage.getTxtNFCStatusValue());

            if (!strNFCStatus.equalsIgnoreCase(strNFCStatusValue)) {
                if(strNFCStatusValue.equalsIgnoreCase("Off")){
                    loopHandle(mobileIDScreenPage.getTxtMobileIdsTab(), "navigateBack", 10);
                    click(nfcDisabled);
                    waitForVisibility(nfcTab);
                    click(nfcTab);
                    waitForVisibility(btnOnOff);
                    click(btnOnOff);
                    waitForGivenTime(1);

                    loopHandle(mobileIDScreenPage.getTxtMobileIdsTab(), "navigateBack", 10);
                    waitForGivenTime(1);
                    settingsScreenPage.traverseToSettingsPage();
                    settingsScreenPage.clickOnAppPreferences();
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

                    /**LOCATORS ARE NOT MODIFIED.THE OUTPUT IS NOT AS EXPECTED.SEPARATE METHOD HAS BEEN WRITTEN **/
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
