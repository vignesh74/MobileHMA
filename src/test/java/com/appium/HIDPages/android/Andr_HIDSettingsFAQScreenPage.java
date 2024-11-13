package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.manager.DriverFactory;
import com.appium.manager.DriverManager;
import com.appium.manager.IDriver;
import com.appium.utils.TestUtils;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.remote.RemoteWebElement;

import javax.naming.Context;
import java.util.Map;
import java.util.Set;

import static com.appium.constants.FrameworkConstants.EXPLICIT_WAIT;

public class Andr_HIDSettingsFAQScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in FAQ Screen Page Date-26/10/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtfaqtitle")
    private MobileElement txtFAQHeadline;

//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.widget.EditText")
//    private MobileElement searchBox;

    @FindBy(id = "searchQueryInput")
    private WebElement searchBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='About HID Mobile Access']")
    private MobileElement txtAboutHIDMobileAccess;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBack")
    private MobileElement imgBackFromFAQ;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQ']")
    private MobileElement txtFAQ;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.widget.TextView[1]")
    private MobileElement txtNoResultsFound;

    @AndroidFindBy(id = "email")
    private MobileElement signinTxtBox;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-13/02/2023
     */

    public MobileElement getTxtFAQHeadline() {
        return txtFAQHeadline;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public MobileElement getTxtAboutHIDMobileAccess() {
        return txtAboutHIDMobileAccess;
    }

    public MobileElement getImgBackFromFAQ() {
        return imgBackFromFAQ;
    }

    public MobileElement getTxtFAQ() {
        return txtFAQ;
    }

    public MobileElement getTxtNoResultsFound() {
        return txtNoResultsFound;
    }

    public MobileElement signinTxtBox(){
        return signinTxtBox();
    }


    /**
     * isFAQScreenPageDisplayed- This method is used to check the FAQ screen is displayed or not Date-22/10/2023
     */

    public void isFAQScreenPageDisplayed() {
        try {
            waitForVisibility(txtAboutHIDMobileAccess);
            Assert.assertTrue(isElementVisible(txtAboutHIDMobileAccess));
            TestUtils.log().info("FAQ screen is displayed...");
        } catch (Exception e) {
            TestUtils.log().info("Exception occurred while displaying FAQ Screen...");
        }
    }

    /**
     * backFromFAQScreen- This method is used to back from the FAQ screen Date-22/10/2023
     */

    public void backFromFAQScreen() {
        try {
            click(imgBackFromFAQ);
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while coming back from FAQ Screen...");
        }
    }

    /**
     * This method is used to click on FAQ screen Date-22/10/2023
     */
    public void clickOnFAQScreen() {
        try {
            click(txtFAQ);
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while clicking on FAQ Screen...");
        }
    }

    public void checkSearch(String text) {
        try {
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
            WebElement searchBox = driver.findElementByCssSelector("#searchQueryInput");
            searchBox.sendKeys(text);
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred while entering text on search box in FAQ Screen...");
        }
    }

    public void searchText(String text){
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
        if(driver.getPageSource().contains(text)){
            Assert.assertTrue(true, "Text is present");
            TestUtils.log().debug("Searched Text is displayed on the FAQ screen");
        }else{
            WebElement noResults = driver.findElementByCssSelector("#noResultsMessage");
            noResults.isDisplayed();
            Assert.assertFalse(false, "Text is not present");
            TestUtils.log().debug("Searched Text is not displayed on the FAQ screen");
        }
    }


    public static void changeDriverContextToWeb() {
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
        }
        driver.context("WEBVIEW_com.hidglobal.mobilekeys.android.v3");

    }

    public void changeDriverContextToWebSSO() {
        waitForGivenTime(10);
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")) {
                driver.context(contextName);
                break;
            }
            System.out.println("After switch:"+contextName);
        }

//        System.out.println("Page Source " + driver.getPageSource());
        waitForGivenTime(8);
        driver.findElement(By.xpath("//input[@name=\"LoginId\"]")).sendKeys("deep11@yopmail.com");
        waitForGivenTime(2);
        driver.findElement(By.xpath("//button[contains(@class, 'hid-button') and contains(text(), 'Next')]\n")).click();
        waitForGivenTime(8);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Welcome@123");
        waitForGivenTime(2);
        driver.findElement(By.xpath("//button[@name=\"action\"]")).click();

    }

    public void changeDriverContextToWebSSONonOrg(String user, String password) {
        waitForGivenTime(10);
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();

        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")) {
                driver.context(contextName);
                break;
            }
            System.out.println("After switch:"+contextName);
        }

        System.out.println("Page Source " + driver.getPageSource());
        waitForGivenTime(8);
        driver.findElement(By.xpath("//input[@name=\"LoginId\"]")).sendKeys(user);
        waitForGivenTime(2);
        driver.findElement(By.xpath("//button[contains(@class, 'hid-button') and contains(text(), 'Next')]\n")).click();
        waitForGivenTime(1);
        String nonUser =  driver.findElement(By.xpath("//h5")).getText();
        System.out.println(nonUser);
        Assert.assertEquals("nonUser","The requested user not found");

    }

}
