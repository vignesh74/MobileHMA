package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;
import static com.appium.constants.MessageConstants.*;
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

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtMobileIds")
    private MobileElement txtMobileIdsTab;

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

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Activity Expand/Collapse Image']")
    private MobileElement btnActivityExpander;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"TODAY\"]")
    private MobileElement txtActivityToday;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='TODAY']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView[1]")
    private MobileElement txtActivityMobileIDRead;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='TODAY']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView[3]")
    private MobileElement txtActivityMsg;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='TODAY']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView[4]")
    private MobileElement txtActivityActionName;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='TODAY']/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup[1]/android.widget.TextView[5]")
    private MobileElement txtActivityReaderName;

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

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtCompany")
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
    private MobileElement doneBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edtTxtIssueDescription")
    private MobileElement txtIssueDescriptionNickname;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNoMobileIdTitle")
    private MobileElement noMobileIDTitleTxt;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNoMobileIdMessage")
    private MobileElement noMobileIDMsg;


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

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgNoMobileIdImage")
    private MobileElement noMobileIDImage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtMobileIDs")
    private MobileElement txtAddMobileIDTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEnterInvitationCode")
    private MobileElement txtEnterInvitationCodeTab;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtInviteCode")
    private MobileElement txtInvitationCode;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/edInviteCode")
    private MobileElement invitationCodeTxtBox;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='XXXX-XXXX-XXXX-XXXX']")
    private MobileElement invitationCodeTxtBoxPlaceHolder;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtInviteCodeMessage")
    private MobileElement invitationCodeMessageTxt;

    @AndroidFindBy(xpath = "//android.widget.Button[@enabled='false']")
    private MobileElement disabledEnterBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@enabled='true']")
    private MobileElement enabledEnterBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtScanQrCode")
    private MobileElement txtScanQRCodeTab;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertMessage")
    private MobileElement wrongInvitationCodeAlert;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement wrongInvitationCodeAlertBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgAdd")
    private MobileElement addmobileIDIcon;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertTitle")
    private MobileElement mobileIDDeletedTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertMessage")
    private MobileElement mobileIDDeletedContent;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/alertBtn")
    private MobileElement mobileIDDeletedOKBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNearByReader")
    private MobileElement nearbyReaderTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgNearbyReaderInfo")
    private MobileElement nearbyReaderDataIcon;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtManage")
    private MobileElement nearbyReaderManageBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/errorIcon")
    private MobileElement noNearbyReaderImg;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/errorText")
    private MobileElement noNearbyReaderText;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtManageFavReaderHeading")
    private MobileElement txtManageReadersTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtFavoriteReaderEmptyHeading")
    private MobileElement txtFavoriteReaders;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgEmptyFavHeart")
    private MobileElement imgNoFavoriteReader;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEmptyFavReaderDesc")
    private MobileElement txtNoFavoriteReader;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtOtherReaderEmptyHeading")
    private MobileElement txtSuccessfulTxnLogTitle;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgEmptyTransaction")
    private MobileElement imgSuccessfulTxnLogImg;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEmptyOtherReaderDesc")
    private MobileElement txtNoTxnMessage;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getTxtMobileIdsTab() {
        return txtMobileIdsTab;
    }

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

    public MobileElement getNearbyReaderTitle() {
        return nearbyReaderTitle;
    }

    public MobileElement getNearbyReaderDataIcon() {
        return nearbyReaderDataIcon;
    }

    public MobileElement getNearbyReaderManageBtn() {
        return nearbyReaderManageBtn;
    }

    public MobileElement getNoNearbyReaderImg() {
        return noNearbyReaderImg;
    }

    public MobileElement getNoNearbyReaderText() {
        return noNearbyReaderText;
    }


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

    public void handleNFCWarningBanner() {
        try {
            if (isDisplayed(nfcDisabled)) {
                click(nfcDisabled);
                waitForGivenTime(2);
                click(nfcTurnOn);
                waitForGivenTime(2);
                navigateBack();

            }
        } catch (Exception e) {

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
            TestUtils.log().debug("Exception occurred while handling Bluetooth popup...{}", e.getMessage());
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

    public void clickOnMobileID() {
        if (isDisplayed(txtViewMobileIdCard))
            click(mobileId);
    }

    public void checkHeaderMobileIdHeader() {

        try {

            if ((CHECK_HEADER.equals(txtMobileIdDetails.getText()))) {
                Assert.assertTrue(true, "The Header is  correct...");
                TestUtils.log().debug(" The Header is  correct...");
            } else {
                Assert.assertTrue(false, "The Header is  incorrect...");
                TestUtils.log().debug(" The Header is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the Header in  Back of Card ...");
        }
    }

    public void checkNickname() {

        try {

            if ((CHECK_NICKNAME.equals(txtNickName.getText()))) {
                Assert.assertTrue(true, "The Nickname text is  correct...");
                TestUtils.log().debug(" The Nickname text is  incorrect...");
            } else {
                Assert.assertTrue(false, "The Nickname text is  incorrect...");
                TestUtils.log().debug(" The Nickname text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the Nickname text in  Back of Card ...");
        }
    }

    public void checkName() {

        try {

            if ((CHECK_NAME.equals(txtName.getText()))) {
                Assert.assertTrue(true, "The Name text is  correct...");
                TestUtils.log().debug(" The name text is  correct...");

            } else {
                Assert.assertTrue(false, "The Name text is  incorrect...");
                TestUtils.log().debug(" The name text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the name text in  Back of Card ...");
        }
    }


    public void checkMobileKeySet() {

        try {

            if ((CHECK_MOBILE_KEY_SET.equals(txtMobileKeySetName.getText()))) {
                Assert.assertTrue(true, "The mobile keyset  text is correct...");
                TestUtils.log().debug(" The mobile keyset  text is  correct...");

            } else {
                Assert.assertTrue(false, "The mobile keyset  text is incorrect...");
                TestUtils.log().debug(" The mobile keyset  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the mobile keyset text in  Back of Card ...");
        }
    }

    public void checkOrganization() {

        try {

            if ((CHECK_ORGANIZATION.equals(txtCompany.getText()))) {
                Assert.assertTrue(true, "The organisation  text is  correct...");
                TestUtils.log().debug(" The organisation  text is  correct...");

            } else {
                Assert.assertTrue(false, "The organisation  text is  incorrect...");
                TestUtils.log().debug(" The organisation  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the organisation text in  Back of Card ...");
        }
    }

    public void checkIssuedOn() {

        try {

            if ((CHECK_ISSUED_ON.equals(txtIssued.getText()))) {
                Assert.assertTrue(true, "The IssuedOn  text is  correct...");
                TestUtils.log().debug(" The IssuedOn  text is  correct...");
            } else {
                Assert.assertTrue(false, "The IssuedOn  text is  incorrect...");
                TestUtils.log().debug(" The IssuedOn  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the IssuedOn text in  Back of Card ...");
        }
    }

    public void checkExpiresOn() {

        try {

            if ((CHECK_EXPIRES_ON.equals(txtExpires.getText()))) {
                Assert.assertTrue(true, "The ExpiresOn  text is  correct...");
                TestUtils.log().debug(" The ExpiresOn  text is  correct...");
            } else {
                Assert.assertTrue(false, "The ExpiresOn  text is  incorrect...");
                TestUtils.log().debug(" The ExpiresOn  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the ExpiresOn text in  Back of Card ...");
        }
    }

    public void checkID() {

        try {

            if ((CHECK_ID.equals(txtIdNo.getText()))) {
                Assert.assertTrue(true, "The ID#  text is  correct...");
                TestUtils.log().debug(" The ID#  text is  correct...");
            } else {
                Assert.assertTrue(false, "The ID#  text is  incorrect...");
                TestUtils.log().debug(" The ID#  text is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the ID# text in  Back of Card ...");
        }
    }

    public void checkVisibilityOfEditNicknamePencilIcon() {

        try {

            if (!isDisplayed(pencilEditIcon)) {
                Assert.assertTrue(false, "Pencil Edit icon is not displayed...");
                TestUtils.log().info("Pencil Edit icon is not displayed");

            } else {
                Assert.assertTrue(true, "Pencil Edit icon is  displayed...");
                TestUtils.log().info("Pencil Edit icon is displayed");
                click(pencilEditIcon);
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Edit Pencil Icon...");
        }

    }

    public void checkVisibilityOfEditNicknamePopup() {

        try {

            if (!isDisplayed(alertTitle)) {
                Assert.assertTrue(false, "Edit Text Dialog Box is not displayed...");
                TestUtils.log().info("Edit Text Dialog Box is not displayed");

            } else {
                Assert.assertTrue(true, "Edit Text Dialog Box is displayed...");
                TestUtils.log().info("Edit Text Dialog Box is  displayed");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Nickname Dialog Box...");
        }

    }


    public void validateNicknameDialogBox() {

        try {

            if (!isDisplayed(alertTitle)) {
                Assert.assertTrue(false, "Nickname Title is not displayed...");
                TestUtils.log().info("Nickname Title is not displayed");


            } else if (!isDisplayed(cancelBtn)) {
                Assert.assertTrue(false, "Cancel Button is not displayed...");
                TestUtils.log().info("Cancel Button is not displayed");

            } else if (!isDisplayed(doneBtn)) {
                Assert.assertTrue(false, "Done Button is not displayed...");
                TestUtils.log().info("Done Button is not displayed");

            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating Nickname dialog box...");
        }

    }

    public void enterNickname() {
        click(txtIssueDescriptionNickname);
        txtIssueDescriptionNickname.sendKeys("HID Employee @ CHENNAI");
        click(doneBtn);
        waitForGivenTime(5);

    }

    public void removeNickname() {
        click(pencilEditIcon);
        click(txtIssueDescriptionNickname);
        txtIssueDescriptionNickname.clear();
        click(doneBtn);
        waitForGivenTime(5);
        click(imgBackBtn);

    }

    /**Note: Robot class implementation is not supported with Ventura OS in Mac.**/
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
                case "9", "00" -> {
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
            TestUtils.log().debug("Exception occurred while handling allow Access to Device Location PopUp {}...", e.getMessage());
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
            TestUtils.log().debug("Exception occurred while checking visibility of enable the location permission popup...{}", e.getMessage());
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
                    } else if (isDisplayed(btnTurnOn)) {
                        click(btnTurnOn);
                        TestUtils.log().info("Allow/Turn on Button clicked");
                    } else if (isDisplayed(tglBtnLocation)) {
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

    public void verifyMobileIDScreen() {
        try {
            isDisplayed(txtMobileIdsTab);
            isDisplayed(noMobileIDImage);
            isDisplayed(noMobileIDTitleTxt);
            isDisplayed(noMobileIDMsg);
            isDisplayed(addmobileIDIcon);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the mobileID screen");
        }
    }

    public void verifyAddMobileIDScreen() {
        try {
            isDisplayed(txtAddMobileIDTitle);
            isDisplayed(txtEnterInvitationCodeTab);
            isDisplayed(txtScanQRCodeTab);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the Add mobileID screen");
        }
    }

    public void plusIcon() {
        try {
            isDisplayed(addmobileIDIcon);
            click(addmobileIDIcon);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on the Add mobileID icon");
        }
    }

    public void clickOnEnterInvitationCodeTab() {
        try {
            click(txtEnterInvitationCodeTab);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while clicking on the 'Enter invitation code tab'");
        }
    }

    public void verifyInvitationCodeScreen() {
        try {
            isDisplayed(txtInvitationCode);
            isDisplayed(invitationCodeTxtBox);
            isDisplayed(invitationCodeTxtBoxPlaceHolder);
            isDisplayed(invitationCodeMessageTxt);
            isDisplayed(disabledEnterBtn);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying on the invitation code screen");
        }
    }

    public void verifyEnterButton(String type, String invitation_code) {
        try {
            if (type.equalsIgnoreCase("valid")) {
                click(invitationCodeTxtBox);
                invitationCodeTxtBox.clear();
                invitationCodeTxtBox.sendKeys(invitation_code);
                isDisplayed(enabledEnterBtn);
                Assert.assertTrue(true, "Enter button is enabled");
                TestUtils.log().info("Valid Invitation code is entered");
            } else if (type.equalsIgnoreCase("invalid")) {
                click(invitationCodeTxtBox);
                invitationCodeTxtBox.clear();
                invitationCodeTxtBox.sendKeys(invitation_code);
                isDisplayed(disabledEnterBtn);
                Assert.assertTrue(true, "Enter button is disabled");
                TestUtils.log().info("InValid Invitation code is entered");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying Enter button");
        }
    }

    public void verifyPopupContent(String type, String invitation_code) {
        try {
            if (type.equalsIgnoreCase("valid")) {
                click(invitationCodeTxtBox);
                invitationCodeTxtBox.clear();
                invitationCodeTxtBox.sendKeys(invitation_code);
                isDisplayed(enabledEnterBtn);
                Assert.assertTrue(true, "Enter button is enabled");
                TestUtils.log().info("Wrong Invitation code is entered...");
                click(enabledEnterBtn);
                waitForGivenTime(2);
                isDisplayed(wrongInvitationCodeAlert);
                Assert.assertTrue(true, "Wrong invitation code alert is displayed");
                click(wrongInvitationCodeAlertBtn);
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the wrong invitation code popup");
        }
    }

    public void verifyDeleteDeviceAlert() {
        try {
            if (isDisplayed(mobileIDDeletedTitle)) {
                Assert.assertTrue(true, "Mobile ID Deleted Title is displayed");
                TestUtils.log().info("Mobile ID Deleted Title is displayed...");
            }
            if (isDisplayed(mobileIDDeletedContent)) {
                Assert.assertTrue(true, "Mobile ID Deleted Message is displayed");
                TestUtils.log().info("Mobile ID Deleted Message is displayed...");
            }

            click(mobileIDDeletedOKBtn);

        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying delete device alert");
        }

    }

    public void verifyShowActivity(String activity) {
        try {
            if (activity.equalsIgnoreCase("Enable")) {
                isDisplayed(btnActivityExpander);
                Assert.assertTrue(true, "Activity expand and collapse button is displayed");
                expandActivityLogs();
            } else {
                if (!isDisplayed(btnActivityExpander)) {
                    Assert.assertTrue(true, "Activity expand and collapse button is not displayed");
                }
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying show activity");
        }
    }

    public void verifyMobileIDWithID() {
        try {
            isDisplayed(txtMobileIdsTab);
            isDisplayed(txtViewMobileIdCard);
            isDisplayed(addmobileIDIcon);
            isDisplayed(txtViewMobileIdCard);
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying Mobile ID screen when having mobile ID");
        }
    }

    public void verifyNearByReaders(String nearbyReaderCount) {
        try {
            waitForVisibility(noNearbyReaderText);
            int readerCount = Integer.parseInt(nearbyReaderCount);
            if (readerCount > 0) {
                TestUtils.log().info("NearbyReaders are present");
            } else {
                isDisplayed(noNearbyReaderText);
                isDisplayed(noNearbyReaderImg);
                isDisplayed(nearbyReaderManageBtn);
                isDisplayed(nearbyReaderDataIcon);
            }

        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the nearby reader section");
        }
    }

    public void verifyManageReaders(String nearbyReaderCount) {
        try {
            click(nearbyReaderManageBtn);
            int readerCount = Integer.parseInt(nearbyReaderCount);
            if (readerCount > 0) {
                TestUtils.log().info("NearbyReaders are present");
            } else {
                isDisplayed(txtManageReadersTitle);
                isDisplayed(txtFavoriteReaders);
                isDisplayed(imgNoFavoriteReader);
                isDisplayed(txtSuccessfulTxnLogTitle);
                isDisplayed(imgSuccessfulTxnLogImg);
                isDisplayed(txtNoTxnMessage);
            }

        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the manage reader section");
        }
    }

    public void setNearbyReaderStatus(String nearbyReaderStatus) {
        try {

        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while setting the NearbyReaderStatus..");
        }
    }

    public String getTodayDate() {
        String date = "";
        try {
            if (isDisplayed(txtActivityToday)) {
                date = getElementText(txtActivityToday);
            } else {
                TestUtils.log().info("Today is not displayed");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the today's date.");
        }
        return date;
    }

    public String getMobileIDRead() {
        String mobileRead = "";
        try {
            if (isDisplayed(txtActivityMobileIDRead)) {
                mobileRead = getElementText(txtActivityMobileIDRead);
            } else {
                TestUtils.log().info("MobileIDRead is not displayed");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the MobileIDRead....");
        }
        return mobileRead;
    }

    public String getSuccessMessage() {
        String actMsg = "";
        try {
            if(isDisplayed(txtActivityMsg)){
                 actMsg = getElementText(txtActivityMsg);
            }else {
                TestUtils.log().info("activity msg is not displayed");
            }
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while verifying the activity msg....");
        }
        return actMsg;
    }

    public String getActionName(){
        String actionName = "";
        try{
            if(isDisplayed(txtActivityActionName)){
                actionName = getElementText(txtActivityActionName);
            }else {
                TestUtils.log().info("activity actionName is not displayed");
            }
        }catch(Exception e){
            TestUtils.log().info("Exception occurred while verifying the activity name.....");
        }
        return actionName;
    }

    public String getReaderName(){
        String readerName = "";
        try{
            if(isDisplayed(txtActivityReaderName)){
                readerName = getElementText(txtActivityReaderName);
            }else{
                TestUtils.log().info("activity readerName is not displayed");
            }
        }catch(Exception e){
            TestUtils.log().info("Exception occurred while verifying the activity reader name....");
        }
        return readerName;
    }

}