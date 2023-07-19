package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Andr_HIDMobileIDScreenPage extends BasePage {
    /**
     * mobile elements - These are mobile elements which is present in mobile id page Date-25/01/2023
     */
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/mobile_ids", priority = 0)
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgMobileIdsContainer", priority = 1)
    private MobileElement txtViewMobileIdCard;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private MobileElement btnNext;
    @AndroidFindBy(xpath = "//*[@text='Got It']")
    private MobileElement btnGotIt;

    @AndroidFindBy(xpath = "//*[@text='Notifications']")
    private MobileElement tabNotifications;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnMobileIdsTab")
    private MobileElement tabMobileID;

    @AndroidFindBy(xpath = "//*[@text='Settings']")
    private MobileElement tabSettings;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertPositiveBtn")
    private MobileElement btnNFCTurnOn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertNegativeBtn")
    private MobileElement btnNFCTurnOff;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertPositiveBtn")
    private MobileElement btnBluetoothTurnOn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertNegativeBtn")
    private MobileElement btnBluetoothTurnOff;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnBluetoothPopUpAllow;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement btnHidMobileAccess;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ALLOW']", priority = 1)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow']", priority = 2)
    private MobileElement btnAllowPopUp;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement btnWhileUsingApp;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertPositiveBtn")
    private MobileElement btnTurnOnLocationDevicePermission;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertNegativeBtn")
    private MobileElement btnTurnOffLocationDevicePermission;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Allow Access to this Device’s Location']", priority = 0)
    private MobileElement txtAllowAccessToDevice;
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ALLOW']", priority = 0)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Allow']", priority = 1)
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn", priority = 2)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Yes']", priority = 3)
    private MobileElement btnAllow;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Turn on Location'] ")
    private MobileElement txtTurnOnLocation;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='TURN ON']", priority = 0)
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button", priority = 1)
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn", priority = 2)
    private MobileElement btnTurnOn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='An app wants to turn on Bluetooth.']")
    private MobileElement txtBleAccess;
    @AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='android:id/switch_widget']")
    private MobileElement tglBtnLocation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Turn On Bluetooth']")
    private MobileElement txtTurnOnBluetooth;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Activity Expand/Collapse Image\"]")
    private MobileElement btnActivityExpander;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"TODAY\"]")
    private MobileElement txtToday;

    //@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Successful Bluetooth transaction.\"])[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Category:\"])[1]/following-sibling::android.widget.TextView[2]")
    private MobileElement txtMessage;

    //@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Category:\"]/following-sibling::android.widget.TextView[1]/following-sibling::android.widget.ImageView[1]")
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Category:\"])[1]/following-sibling::android.widget.ImageView[1]")
    private MobileElement imgSuccessful;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_widget", priority = 0)
    @AndroidFindBy(id = "android:id/switch_widget", priority = 1)
    private MobileElement btnSettingsOnOff;
    @AndroidFindBy(id = "android:id/message")
    private MobileElement txtBluetoothAllowPopUpV7;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnBluetoothYes;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/allow_always_radio_button")
    private MobileElement rdoAllowAllTheTime;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Yes']")
    private MobileElement btnYes;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement btnLocAllowPopUp;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='SETTINGS']", priority = 0)
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn", priority = 1)
    private MobileElement btnSettings;



    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement btnTurnOnPermission;

    /**
     * These are the Mobile elements required for validating back of the card details
     */

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgMobileIdsContainer")
    private MobileElement mobileId;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtMobileIdDetails")
    private MobileElement txtMobileIdDetails;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNickName")
    private MobileElement txtNickName;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtName")
    private MobileElement txtName;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtMobileKeySetName")
    private MobileElement txtMobileKeySetName;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtCompany")
    private MobileElement txtCompany;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtIssued")
    private MobileElement txtIssued;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtExpires")
    private MobileElement txtExpires;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtIdno")
    private MobileElement txtIdNo;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgEditBtn")
    private MobileElement pencilEditIcon;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgCredentialContainer")
    private MobileElement imgCredentialContainer;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtCredentialName")
    private MobileElement txtCredentialName;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgCredentialPhoto")
    private MobileElement imgCredentialPhoto;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBackBtn")
    private MobileElement imgBackBtn;

    /**
     * These are the mobile elements for validating Nickname popup
     */

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/editTextDialog")
    private MobileElement editTextDialogBox;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement alertTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertNegativeBtn")
    private MobileElement cancelBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertPositiveBtn")
    private  MobileElement doneBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edtTxtIssueDescription")
    private MobileElement txtIssueDescriptionNickname;




    /**
     * These are the Mobile elements required for validating Warning Banners
     */

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFC Disabled']")
    private MobileElement nfcDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable NFC to use your Mobile ID by presenting your phone to the reader.']")
    private MobileElement nfcDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Location Permission']")
    private MobileElement locationPermissionDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We do not track your location. Enable Location to use your Mobile ID over Bluetooth.']")
    private MobileElement locationPermissionDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bluetooth Disabled']")
    private MobileElement bleDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enable Bluetooth to find readers nearby and use your Mobile ID over Bluetooth.']")
    private MobileElement bleDisabledText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GPS Disabled']")
    private MobileElement gpsDisabled;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='We do not track your location. Enable this to find readers nearby and use your Mobile ID over Bluetooth.']")
    private MobileElement gpsDisabledText;

    @AndroidFindBy(id = "com.android.settings:id/switch_widget")
    private MobileElement nfcTurnOn;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "com.android.settings:id/switch_widget", priority = 0)
    @AndroidFindBy(id = "android:id/switch_widget", priority = 1)
    private MobileElement nfcTurnOnOFF;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getRdoAllowAllTheTime() {
        return rdoAllowAllTheTime;
    }

    //While using the app
    public MobileElement getBtnAllowPopUp() {
        return btnAllowPopUp;
    }

    public MobileElement getTxtViewMobileIdCard() {
        return txtViewMobileIdCard;
    }

    public MobileElement getNotificationTab() {
        return tabNotifications;
    }

    public MobileElement getMobileIDTab() {
        return tabMobileID;
    }

    public MobileElement getSettingsTab() {
        return tabSettings;
    }

    public MobileElement getNextbtn() {
        return btnNext;
    }

    public MobileElement getGotItbtn() {
        return btnGotIt;
    }

    public MobileElement getNFCturnOnbtn() {
        return btnNFCTurnOn;
    }

    public MobileElement getNFCTurnOffbtn() {
        return btnNFCTurnOff;
    }

    public MobileElement getBluetoothturnOnbtn() {
        return btnBluetoothTurnOn;
    }

    public MobileElement getBluetoothTurnOffbtn() {
        return btnBluetoothTurnOff;
    }

    public MobileElement getBtnHidMobileAccess() {
        return btnHidMobileAccess;
    }

    public MobileElement getBtnActivityExpander() {
        return btnActivityExpander;
    }

    public MobileElement getTxtToday() {
        return txtToday;
    }

    public MobileElement getTxtMessage() {
        return txtMessage;
    }

    public MobileElement getImgSuccessful() {
        return imgSuccessful;
    }

    public MobileElement getBtnSettingsOnOff() {
        return btnSettingsOnOff;
    }

    public MobileElement getTxtBluetoothAllowPopUpV7() {
        return txtBluetoothAllowPopUpV7;
    }

    public MobileElement getBtnBluetoothYes() {
        return btnBluetoothYes;
    }

    public MobileElement getBtnTurnOnPermission() {
        return btnTurnOnPermission;
    }

    String checkHeader="Mobile ID Details";
    String checkNickname="Nickname";
    String checkName="Name";
    String checkMobileKeySet="Mobile Keyset";
    String checkOrganization="Organization";
    String checkIssuedOnDate="Issued On";
    String checkExpiresOn="Expires On";
    String checkID="ID#";

    /**
     * clickOnNextButton- This method is used click on the next button Date- 25/01/2023
     */
    public void clickOnNextButton() {
        try {
            if (isDisplayed(btnNext)) {
                click(btnNext);
            } else {
                TestUtils.log().info("Next Button is not displayed...");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Next button...");
        }
    }

    /**
     * clickOnGotItButton- This method is used click on the got it button Date- 25/01/2023
     */
    public void clickOnGotItButton() {
        try {
            if (isDisplayed(btnGotIt)) {
                click(btnGotIt);
            } else {
                TestUtils.log().info("GotIt Button is not displayed...");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Go button...");
        }
    }

    /**
     * toHandleNFCPopup- This method used to handle NFC popup Date- 25/01/2023
     */
    public void handleNFCPopUp() {
        try {
            if (isDisplayed(btnNFCTurnOn)) {
                click(btnNFCTurnOn);
                waitForGivenTime(2);
                click(btnSettingsOnOff);
                waitForGivenTime(2);
                String strSettings = getElementAttribute(btnSettingsOnOff, "checked");
                if (strSettings.equalsIgnoreCase("true")) {
                    TestUtils.log().info(" NFC is turned on now");
                } else {
                    TestUtils.log().info(" NFC is turned off now");
                }
                navigateBack();
            } else {
                TestUtils.log().info("No NFC Popup is displayed");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while handling NFC popup...");
        }
    }

    /**
     * to HandleNFCWarningBanner-This method is used to handle NFC warning Banner Date-10/05/2023
     */

    public void handleNFCWarningBanner(){
       try {
           if (isDisplayed(nfcDisabled)) {
               click(nfcDisabled);
               waitForGivenTime(2);
               click(nfcTurnOn);
               waitForGivenTime(2);
               navigateBack();

           }
       }catch(Exception e)
        {

        }
    }

    /**
     * toHandleBluetoothPopup- This method used to handle bluetooth popup Date- 25/01/2023
     */
    public void handleBluetoothPopUp() {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("12") || strPlatformVersion.equalsIgnoreCase("11") || strPlatformVersion.equalsIgnoreCase("10") || strPlatformVersion.equalsIgnoreCase("8") || strPlatformVersion.equalsIgnoreCase("7")) {
                if (isDisplayed(btnBluetoothTurnOn)) {
                    click(btnBluetoothTurnOn);
                    if (isDisplayed(btnBluetoothPopUpAllow)) {
                        click(btnBluetoothPopUpAllow);
                        TestUtils.log().info("Bluetooth Allow Popup is handled");
                    } else {
                        TestUtils.log().info("No Bluetooth Allow Popup is displayed");
                    }
                } else {
                    TestUtils.log().info("No Bluetooth Popup is displayed,Bluetooth is already ON");
                }
            } else if (strPlatformVersion.equalsIgnoreCase("9")) {
                if (isDisplayed(txtTurnOnBluetooth)) {
                    click(btnTurnOn);
                    TestUtils.log().info("clicked Turn On Bluetooth button");
                    if (isDisplayed(btnAllow)) {
                        click(btnAllow);
                        TestUtils.log().info("clicked Turn On Bluetooth Allow/Yes button");
                        waitForGivenTime(1);
                    }
                } else {
                    TestUtils.log().info(" No Turn On Bluetooth pop up displayed...");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while handling Bluetooth popup...{}",e.getMessage());
        }
    }

    /**
     * toHandleHIDMobileAccessPopup- This method used to handle HID mobile access popup Date- 25/01/2023
     */
    public void handleHIDMobileAccessPopUp() {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("12") || strPlatformVersion.equalsIgnoreCase("7") || strPlatformVersion.equalsIgnoreCase("8")) {
                if (isDisplayed(btnHidMobileAccess)) {
                    click(btnHidMobileAccess);
                } else {
                    TestUtils.log().info("No HID mobile access Popup is displayed");
                }
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while handling HID mobile access popup...");
        }
    }

    /**
     * toVerifyMobileID- This method used to verify the Mobile id Date- 25/01/2023
     */
    public void toVerifyMobileID() {

        try {
            loopHandle(txtViewMobileIdCard, "swipeUp", 5);
            if (isDisplayed(txtViewMobileIdCard)) {
                Assert.assertTrue(true, "MobileID is displayed successfully");
            } else {
                loopHandle(txtViewMobileIdCard, "swipeUp", 5);
                if (isDisplayed(txtViewMobileIdCard)) {
                    Assert.assertTrue(true, "MobileID is displayed successfully");
                } else {
                    Assert.assertTrue(false, "MobileID is not displayed");
                }
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying Mobile ID...");
        }
    }

    /**
     * to VerifyBackOfCard- These methods are used to verify back of the card
     */

    public void clickOnMobileID(){
        if(isDisplayed(txtViewMobileIdCard))
            click(mobileId);
    }

    public void checkHeaderMobileIdHeader(){

        try {

            if(!(checkHeader.equals(txtMobileIdDetails.getText())))
            {
                Assert.assertTrue(true, "The Header is  correct...");
                TestUtils.log().debug(" The Header is  correct...");
            }
            else{
                Assert.assertTrue(false, "The Header is  incorrect...");
                TestUtils.log().debug(" The Header is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the Header in  Back of Card ...");
        }
    }

    public void checkNickname(){

        try {

            if(!(checkNickname.equals(txtNickName.getText())))
            {
                Assert.assertTrue(true, "The Nickname text is  correct...");
                TestUtils.log().debug(" The Nickname text is  incorrect...");
            }
            else{
                Assert.assertTrue(false, "The Nickname text is  incorrect...");
                TestUtils.log().debug(" The Nickname text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the Nickname text in  Back of Card ...");
        }
    }

    public void checkName(){

        try {

            if(!(checkName.equals(txtName.getText())))
            {
                Assert.assertTrue(true, "The Name text is  correct...");
                TestUtils.log().debug(" The name text is  correct...");

            }
            else {
                Assert.assertTrue(false, "The Name text is  incorrect...");
                TestUtils.log().debug(" The name text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the name text in  Back of Card ...");
        }
    }


    public void checkMobileKeySet(){

        try {

            if(!(checkMobileKeySet.equals(txtMobileKeySetName.getText())))
            {
                Assert.assertTrue(true, "The mobile keyset  text is correct...");
                TestUtils.log().debug(" The mobile keyset  text is  correct...");

            }
            else {
                Assert.assertTrue(false, "The mobile keyset  text is incorrect...");
                TestUtils.log().debug(" The mobile keyset  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the mobile keyset text in  Back of Card ...");
        }
    }

    public void checkOrganization(){

        try {

            if(!(checkOrganization.equals(txtCompany.getText())))
            {
                Assert.assertTrue(true, "The organisation  text is  correct...");
                TestUtils.log().debug(" The organisation  text is  correct...");

            }
            else {
                Assert.assertTrue(false, "The organisation  text is  incorrect...");
                TestUtils.log().debug(" The organisation  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the organisation text in  Back of Card ...");
        }
    }

    public void checkIssuedOn(){

        try {

            if(!(checkIssuedOnDate.equals(txtIssued.getText())))
            {
                Assert.assertTrue(true, "The IssuedOn  text is  correct...");
                TestUtils.log().debug(" The IssuedOn  text is  correct...");
            }
            else
            {
                Assert.assertTrue(false, "The IssuedOn  text is  incorrect...");
                TestUtils.log().debug(" The IssuedOn  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the IssuedOn text in  Back of Card ...");
        }
    }

    public void checkExpiresOn(){

        try {

            if(!(checkExpiresOn.equals(txtExpires.getText())))
            {
                Assert.assertTrue(true, "The ExpiresOn  text is  correct...");
                TestUtils.log().debug(" The ExpiresOn  text is  correct...");
            }

            else {
                Assert.assertTrue(false, "The ExpiresOn  text is  incorrect...");
                TestUtils.log().debug(" The ExpiresOn  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the ExpiresOn text in  Back of Card ...");
        }
    }

    public void checkID(){

        try {

            if(!(checkID.equals(txtIdNo.getText())))
            {
                Assert.assertTrue(true, "The ID#  text is  correct...");
                TestUtils.log().debug(" The ID#  text is  correct...");
            }
            else {
                Assert.assertTrue(false, "The ID#  text is  incorrect...");
                TestUtils.log().debug(" The ID#  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the ID# text in  Back of Card ...");
        }
    }

    public boolean checkVisibilityOfEditNicknamePencilIcon() {
        boolean flag = false;
        try {

            if (!isDisplayed(pencilEditIcon)) {
                TestUtils.log().info("Pencil Edit icon is not displayed");
                flag = true;
            }

            else
            {click(pencilEditIcon);}

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Edit Pencil Icon...");
        }
        return flag;
    }

    public boolean checkVisibilityOfEditNicknamePopup() {
        boolean flag = false;
        try {

            if (!isDisplayed(editTextDialogBox)) {
                TestUtils.log().info("Edit Text Dialog Box is not displayed");
                flag = true;
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Nickname Dialog Box...");
        }
        return flag;
    }


    public boolean validateNicknameDialogBox() {
        boolean flag = false;
        try {

            if (!isDisplayed(alertTitle)) {
                TestUtils.log().info("Nickname Title is not displayed");
                flag = true;
            }
            else if (!isDisplayed(cancelBtn)) {
                TestUtils.log().info("Cancel Button is not displayed");
                flag = true;
            }
            else if(!isDisplayed(doneBtn)){
                TestUtils.log().info("Done Button is not displayed");
                flag = true;
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating Nickname dialog box...");
        }
        return flag;
    }

    public void enterNickname(){
        click(txtIssueDescriptionNickname);
        txtIssueDescriptionNickname.sendKeys("HID Employee @ CHENNAI");
        click(doneBtn);
        waitForGivenTime(5);
        click(imgBackBtn);

    }
 /*   public void enterNickname() throws AWTException {
        click(txtIssueDescriptionNickname);
        waitForGivenTime(10);
        Robot r=new Robot();

        r.keyPress(KeyEvent.VK_H);
        r.keyRelease(KeyEvent.VK_H);

        r.keyPress(KeyEvent.VK_I);
        r.keyPress(KeyEvent.VK_D);
       // r.keyPress(KeyEvent.VK_ENTER);

        click(doneBtn);
        click(imgBackBtn);
    }
Note: Robot class implementation is not supported with Ventura OS in Mac.
*/

    /**
     * clickOnNotificationTab- This method is used to click on the notification tab Date-25/01/2023
     */
    public void clickOnNotificationTab() {
        try {
            waitForElement(tabNotifications);
            click(tabNotifications);

        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Notification tab...");
        }
    }

    /**
     * clickOnSettingsTab- This method is used to click on the settings tab Date-25/01/2023
     */
    public void clickOnSettingsTab() {
        try {
            click(tabSettings);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while clicking on Settings tab...");
        }
    }

    /**
     * navigateBackToMobileID- This method is used to navigate back to Mobile Id screen from Setting Tab Date-25/01/2023
     */
    public void navigateBackToMobileID() {
        try {
            while (!isElementVisible(txtViewMobileIdCard)) {
                navigateBack();
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while navigating back to Mobile ID screen...");
        }
    }

    /**
     * expandActivityLogs- This method is used to expand the activity logs Date-25/01/2023
     */
    public void expandActivityLogs() {
        try {
            if (isDisplayed(btnActivityExpander)) {
                click(btnActivityExpander);
                TestUtils.log().info("Activity Log button is expanded");
            } else {
                TestUtils.log().info(" Activity Log Expand button is not visible");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while expanding activity logs...");
        }

    }

    /**
     * verifyDate- This method is used to verify date Date-25/01/2023
     */
    public String verifyDate() {
        String date = "";
        try {
            if (isDisplayed(txtToday)) {
                date = getElementText(txtToday);
                TestUtils.log().info("TODAY is displayed ");
            } else {
                TestUtils.log().info(" No any activity description is captured");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying date...");
        }
        return date;
    }

    /**
     * verifySuccessMessage- This method is used to verify success message Date-25/01/2023
     */
    public String verifySuccessMessage() {
        String message = "";
        try {

            if (isDisplayed(txtMessage)) {
                message = getElementText(txtMessage);
                TestUtils.log().info("Success message is displayed ");
            } else {
                TestUtils.log().info(" Success message is not displayed");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying success message...");
        }
        return message;
    }

    /**
     * verifySuccessIcon- This method is used to verify success icon Date-25/01/2023
     */
    public boolean verifySuccessIcon() {
        boolean bnFlag = false;
        try {
            if (isDisplayed(imgSuccessful)) {
                bnFlag = true;
                TestUtils.log().info("Success Icon is displayed ");
            } else {
                TestUtils.log().info(" Failure Icon is displayed or No Activity Logs are captured");
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying success icon...");
        }
        return bnFlag;
    }

    /**
     * checkVisibilityOFNextButton- This method is used to check visibility of the next button Date-25/01/2023
     */
    public boolean checkVisibilityOFNextButton() {
        boolean bnFlag = false;
        try {
            if (isDisplayed(btnNext)) {
                bnFlag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking visibility of Next button...");
        }
        return bnFlag;
    }

    /**
     * clickOnMobileIDTabAndVerify- This method is used to click and verify on Mobile Id Tab Date-25/01/2023
     */
    public void clickOnMobileIDTabAndVerify() {
        try {
            click(tabMobileID);
            toVerifyMobileID();
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying Mobile ID screen...");
        }
    }

    /**
     * allowAccessToDeviceLocationPopUp- This method is used to handle allow access to device location popup Date-25/01/2023
     */
    public void allowAccessToDeviceLocationPopUp() {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            switch (strPlatformVersion) {
                case "9","00" -> {
                    if (isDisplayed(txtAllowAccessToDevice)) {
                        if (isDisplayed(btnAllow)) {
                            click(btnAllow);
                            TestUtils.log().info("Clicked on the Allow Button");
                            if (isDisplayed(btnTurnOnPermission)) {
                                click(btnTurnOnPermission);
                                TestUtils.log().info("Clicked on the Allow Button for permission");
                            }
                            if (isDisplayed(btnTurnOn)) {
                                click(btnTurnOn);
                                TestUtils.log().info("Turn On Button clicked");
                                if (isDisplayed(tglBtnLocation)) {
                                    click(tglBtnLocation);
                                    TestUtils.log().info("Click on Location Toggle button");
                                    waitForGivenTime(1);
                                    navigateBack();
                                    waitForGivenTime(1);
                                }
                            }
                        }
                    } else {
                        TestUtils.log().info("No Allow Device Access Popup displayed...");
                    }
                }
                default -> {
                    if (isDisplayed(btnAllowPopUp)) {
                        click(btnAllowPopUp);
                        if (isDisplayed(btnTurnOnLocationDevicePermission)) {
                            click(btnTurnOnLocationDevicePermission);
                            TestUtils.log().info("Clicked on the Turn ON Button");
                            if (isDisplayed(btnSettingsOnOff)) {
                                click(btnSettingsOnOff);
                                waitForGivenTime(1);
                                navigateBack();
                                waitForGivenTime(1);
                            }
                        } else if (isDisplayed(btnWhileUsingApp)) {
                            click(btnWhileUsingApp);
                            TestUtils.log().info("Clicked on the While using app");
                        }
                    } else {
                        TestUtils.log().info("No Allow PopUp displayed...");
                    }
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while handling allow Access to Device Location PopUp {}...",e.getMessage());
        }
    }

    /**
     * handleBackgroundLocationPermissionPopUp- This method is used to handle background location permission popup Date-25/01/2023
     */
    public void handleBackgroundLocationPermissionPopUp() {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("11") || strPlatformVersion.equalsIgnoreCase("10")) {
                if (isDisplayed(btnTurnOnLocationDevicePermission)) {
                    click(btnTurnOnLocationDevicePermission);
                    TestUtils.log().info("Allow the Location Device Permission");
                    selectRadioButton(rdoAllowAllTheTime);
                    TestUtils.log().info("Allow all the time permission");
                } else {
                    TestUtils.log().info("No Location Device Permission PopUp is displayed");
                }
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while handling Background Location Permission PopUp...");
        }
    }

    /**
     * handleDeviceLocationPermissionPopUp-This method is used to handle device location permission for version 11
     *
     * @return-boolean
     */
    public boolean handleDeviceLocationPermissionPopUp() {
        boolean blnPopUpDisplayed = false;
        try {
            if (isDisplayed(btnAllowPopUp)) {
                click(btnAllowPopUp);
                if (isDisplayed(btnSettings)) {
                    click(btnSettings);
                    waitForGivenTime(1);
                    blnPopUpDisplayed = true;
                }
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while handling Device Location Permission PopUp...");
        }
        return blnPopUpDisplayed;
    }

    /**
     * checkVisibilityOfAllowButton- This method is used to check visibility of the Allow button Date-13/02/2023
     */
    public boolean checkVisibilityOfAllowButton() {
        boolean bnFlag = false;
        try {
            if (isDisplayed(btnAllow)) {
                bnFlag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking visibility of allow button...");
        }
        return bnFlag;
    }

    /**
     * checkVisibilityOFSettingsTab- This method is used to check visibility of the settings tab Date-09/02/2023
     */
    public boolean checkVisibilityOFSettingsTab() {
        boolean bnFlag = false;
        try {
            if (isDisplayed(tabSettings)) {
                bnFlag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking visibility of settings tab...");
        }
        return bnFlag;
    }

    /**
     * locationPermissionPopUpEnable - This method enable the location for the android device version 9 Date-09/02/2023
     */
    public void locationPermissionPopUpEnable() {
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("9")) {
                if (isDisplayed(btnAllow)) {
                    click(btnAllow);
                    if (isDisplayed(btnSettings)) {
                        click(btnSettings);
                        waitForGivenTime(1);
                    }
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking visibility of enable the location permission popup...{}",e.getMessage());
        }
    }

    /**
     * locationPopUpEnable-This method is used to handle location popup Date-20/02/2023
     */
    public void locationPopUpEnable() {
        waitForGivenTime(1);
        try {
            String strPlatformVersion = DriverManager.getPlatformVersion();
            if (strPlatformVersion.equalsIgnoreCase("9")) {
                if (isDisplayed(txtAllowAccessToDevice)) {
                    if (isDisplayed(btnAllow)) {
                        click(btnAllow);
                        TestUtils.log().info("Clicked on the Allow Button");
                    }
                    else if (isDisplayed(btnTurnOn)) {
                        click(btnTurnOn);
                        TestUtils.log().info("Allow/Turn on Button clicked");
                    }
                    else if (isDisplayed(tglBtnLocation)) {
                        click(tglBtnLocation);
                        TestUtils.log().info("Location Toggle Button clicked");
                        waitForGivenTime(1);
                    }
                    navigateBack();
                    waitForGivenTime(1);
                } else if (isDisplayed(btnTurnOn)) {
                    if (isDisplayed(btnTurnOn)) {
                        click(btnTurnOn);
                        TestUtils.log().info("Allow/Turn on Button clicked");
                    }
                    if (isDisplayed(tglBtnLocation)) {
                        click(tglBtnLocation);
                        TestUtils.log().info("Location Toggle Button clicked");
                        waitForGivenTime(1);
                    }
                    navigateBack();
                    waitForGivenTime(1);
                } else {
                    TestUtils.log().info("No Location Popup displayed...");
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while checking visibility of enable the location popup...{}", e.getMessage());
        }
    }

}