package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.constants.MessageConstants;
import com.appium.manager.DriverManager;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class IOS_HIDHelpCenterAboutScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Help Center About Screen Page Date-25/1/2023
     */
    @iOSXCUITFindBy(xpath = "//*[@name='About']//following-sibling:: XCUIElementTypeStaticText")
    private MobileElement txtHelpCenterAbout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"APPLICATION INFO\"]")
    private MobileElement txtHelpCenterApplicationInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"ENDPOINT INFO\"]")
    private MobileElement txtHelpCenterEndPointInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]")
    private MobileElement imgAboutBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"HID Mobile Access Version\"]")
    private MobileElement txtAboutMobileAccessVersion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"HID Mobile Access Version\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutMobileAccessValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"HID Origo SDK Version\"]")
    private MobileElement txtAboutOrigoSDKVersion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"HID Origo SDK Version\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutOrigoSDKValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Opening Mode\"]")
    private MobileElement txtAboutOpeningMode;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Opening Mode\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutOpeningModeValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Readers\"]")
    private MobileElement txtAboutReaders;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Readers\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutReadersValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Endpoint Status\"]")
    private MobileElement txtAboutEndpointStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Endpoint Status\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutEndpointStatusValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Seos ID\"]")
    private MobileElement txtAboutSeosID;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Seos ID\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutSeosIDValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Last Server Communication\"]")
    private MobileElement txtAboutLastServerComm;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Last Server Communication\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutLastServerCommValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Endpoint App Version\"]")
    private MobileElement txtAboutEndpointAppVer;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Endpoint App Version\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutEndpointAppValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Environment\"]")
    private MobileElement txtAboutEnvironment;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Environment\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutEnvironmentValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DEVICE INFO\"]")
    private MobileElement txtAboutDeviceInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OS Version\"]")
    private MobileElement txtAboutOSVersion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"OS Version\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutOSVersionValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bluetooth\"]")
    private MobileElement txtAboutBluetooth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Bluetooth\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutBluetoothValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Location Services\"]")
    private MobileElement txtAboutLocationServ;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Location Services\"]/following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtAboutLocationServValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"icCopy\"]")
    private MobileElement txtAbouticCopy;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"icDone\"]")
    private MobileElement txtAbouticDone;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    private MobileElement imgBackFromHelpCenter;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name='About']//following-sibling:: XCUIElementTypeImage", priority = 0)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"About\"]", priority = 1)
    private MobileElement imgArrowHelpCenterAbout;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"About\"]")
    private MobileElement navAboutInHome;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */

    public MobileElement getTxtHelpCenterAbout() {
        return txtHelpCenterAbout;
    }

    public MobileElement getBtnHelpCenterAboutBack() {
        return imgAboutBack;
    }

    public MobileElement getTxtHelpCenterApplicationInfo() {
        return txtHelpCenterApplicationInfo;
    }

    public MobileElement getTxtHelpCenterEndPointInfo() {
        return txtHelpCenterEndPointInfo;
    }

    public MobileElement getImgAboutBack() {
        return imgAboutBack;
    }

    public MobileElement getNavAboutInHome() {
        return navAboutInHome;
    }

    /**
     * isAboutScreenDisplayed- This method is used to identify the about screen is displayed or not Date-25/1/2023
     */

    public void isAboutScreenDisplayed() {
        try {
            waitForVisibility(txtHelpCenterAbout);
            Assert.assertTrue(isElementVisible(txtHelpCenterApplicationInfo));
            Assert.assertTrue(isElementVisible(txtHelpCenterEndPointInfo));
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while displaying about screen...");
        }
    }

    /**
     * clickOnBackButtonAbout- This method is used to click on back from about screen Date-25/1/2023
     */
    public void clickOnBackButtonAbout() {
        try {
            click(imgAboutBack);
        } catch (Exception e) {
            
            TestUtils.log().info("Getting Exception while clicking on back button about...");
        }
    }

    /**
     * aboutScreenVerify- This method is used to verify the elements of About screen Date - 19/9/2023
     */
    public void aboutScreenVerify(String Mode, String Env, String BLE, String LocSev) {
        try{
            waitForVisibility(txtHelpCenterAbout);
            Assert.assertTrue(isElementVisible(txtHelpCenterApplicationInfo));
            Assert.assertTrue(isElementVisible(txtAboutMobileAccessVersion));
            verifyValueNotEmpty(txtAboutMobileAccessValue);

            Assert.assertTrue(isElementVisible(txtAboutOrigoSDKVersion));
            verifyValueNotEmpty(txtAboutOrigoSDKValue);

            Assert.assertTrue(isElementVisible(txtAboutOpeningMode));
            Assert.assertEquals(getElementText(txtAboutOpeningModeValue), Mode);

            Assert.assertTrue(isElementVisible(txtAboutReaders));
            verifyValueNotEmpty(txtAboutReadersValue);

            Assert.assertTrue(isElementVisible(txtAboutEndpointStatus));
            verifyValueNotEmpty(txtAboutEndpointStatusValue);

            Assert.assertTrue(isElementVisible(txtAboutSeosID));
            verifyValueNotEmpty(txtAboutSeosIDValue);

            Assert.assertTrue(isElementVisible(txtAboutLastServerComm));
            verifyValueNotEmpty(txtAboutLastServerCommValue);

            Assert.assertTrue(isElementVisible(txtAboutEndpointAppVer));
            verifyValueNotEmpty(txtAboutEndpointAppValue);

            iOSScrollDownTillElement(txtAboutLocationServ);
            isElementVisible(txtAboutLocationServ);

            Assert.assertTrue(isElementVisible(txtAboutEnvironment));
            Assert.assertEquals(getElementText(txtAboutEnvironmentValue), Env);

            Assert.assertTrue(isElementVisible(txtAboutDeviceInfo));
            Assert.assertTrue(isElementVisible(txtAboutOSVersion));
            verifyValueNotEmpty(txtAboutOSVersionValue);

            Assert.assertTrue(isElementVisible(txtAboutBluetooth));
            Assert.assertEquals(getElementText(txtAboutBluetoothValue), BLE);

            Assert.assertTrue(isElementVisible(txtAboutLocationServ));
            Assert.assertEquals(getElementText(txtAboutLocationServValue), LocSev);

        }catch (Exception e) {

            TestUtils.log().info("Getting Exception while displaying about screen...");
        }
    }

    /**
     * clickOnAboutCopyButton- This method is used to click on copy from about screen Date-20/9/2023
     */
    public void clickOnAboutCopyButton() {
        try {
            Assert.assertTrue(isElementVisible(txtAbouticCopy));
            click(txtAbouticCopy);
            Assert.assertTrue(isElementVisible(txtAbouticDone));
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while clicking on copy button from about screen...");
        }
    }

    public void verifyValueNotEmpty(MobileElement element) {
        try {
            String strValue = element.getAttribute(MessageConstants.VALUE_STRING);
            Assert.assertTrue(isElementVisible(element));
            if(strValue.isEmpty()) {
                TestUtils.log().info("About screen is not displayed with value " + strValue);
            }
            else {
                TestUtils.log().info("About screen is displayed with value " + strValue);
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the about screen values...");
        }
    }

    public void verifyAboutInHome(String Mode, String BLE, String LocSev) {
        try{
            waitForVisibility(navAboutInHome);
            Assert.assertTrue(isElementVisible(txtHelpCenterApplicationInfo));
            Assert.assertTrue(isElementVisible(txtAboutMobileAccessVersion));
            verifyValueNotEmpty(txtAboutMobileAccessValue);

            Assert.assertTrue(isElementVisible(txtAboutOrigoSDKVersion));
            verifyValueNotEmpty(txtAboutOrigoSDKValue);

            Assert.assertTrue(isElementVisible(txtAboutOpeningMode));
            Assert.assertEquals(getElementText(txtAboutOpeningModeValue), Mode);

            Assert.assertTrue(isElementVisible(txtAboutReaders));
            verifyValueIsEmpty(txtAboutReadersValue);

            Assert.assertTrue(isElementVisible(txtAboutEndpointStatus));
            verifyValueNotEmpty(txtAboutEndpointStatusValue);

            Assert.assertTrue(isElementVisible(txtAboutSeosID));
            verifyValueIsEmpty(txtAboutSeosIDValue);

            Assert.assertTrue(isElementVisible(txtAboutLastServerComm));
            verifyValueNotEmpty(txtAboutLastServerCommValue);

            Assert.assertTrue(isElementVisible(txtAboutEndpointAppVer));
            verifyValueNotEmpty(txtAboutEndpointAppValue);

            iOSScrollDownTillElement(txtAboutLocationServ);
            isElementVisible(txtAboutLocationServ);

            Assert.assertTrue(isElementVisible(txtAboutEnvironment));
            verifyValueIsEmpty(txtAboutEnvironmentValue);

            Assert.assertTrue(isElementVisible(txtAboutDeviceInfo));
            Assert.assertTrue(isElementVisible(txtAboutOSVersion));
            verifyValueNotEmpty(txtAboutOSVersionValue);

            Assert.assertTrue(isElementVisible(txtAboutBluetooth));
            Assert.assertEquals(getElementText(txtAboutBluetoothValue), BLE);

            Assert.assertTrue(isElementVisible(txtAboutLocationServ));
            Assert.assertEquals(getElementText(txtAboutLocationServValue), LocSev);

            click(imgBackFromHelpCenter);
        }catch (Exception e) {
            TestUtils.log().info("Getting Exception while displaying about in Welcome screen...");
        }
    }

    public void verifyValueIsEmpty(MobileElement element) {
        try {
            String strValue = element.getAttribute(MessageConstants.VALUE_STRING);
            if(strValue.isEmpty() | strValue == null) {
                TestUtils.log().info("About screen value is empty as expected " + strValue);
            }
            else {
                TestUtils.log().info("About screen is displayed with value, which is not as expected" + strValue);
            }
        } catch (Exception e) {
            TestUtils.log().info("Getting Exception while checking the about screen values...");
        }
    }

   /* public void getClipboardContent() {
        try{
            DriverManager.getDriver().getClipboard(ClipboardContentType.PLAINTEXT); // get plaintext
            DriverManager.getDriver().getClipboardText();
        }
        catch (Exception e) {
            TestUtils.log().info("Getting Exception while verifying the clipboard content...");
        }
    }*/
}
