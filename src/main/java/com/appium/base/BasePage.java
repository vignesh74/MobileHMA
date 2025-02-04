/**
 * BasePage class -It used to initializes the appium driver. method used for the various operations perform on real devices/emulator/simulator Date-02/11/2022
 */
package com.appium.base;

import com.appium.deviceinfo_action.AndroidDeviceAction;
import com.appium.exceptions.AutomationException;
import com.appium.manager.DriverManager;
import com.appium.utils.ConfigLoader;
import com.appium.utils.TestUtils;
import com.appium.utils.VerificationUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.appium.constants.FrameworkConstants.*;
import static com.appium.utils.SerialPortUtils.basePage;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {
    TouchAction<?> touchAction;

    /**
     * constructor -initialize the mobile elements Date-02/11/2022
     */
    public BasePage() {

        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    /**
     * tapByCoordinates- It taps on mobileElement by its coordinates
     *
     * @param x
     *         -int
     * @param y
     *         -int Date-02/11/2022
     */
    public static void tapByCoordinates(int x, int y) {
        try {
            tap(x, y, 250);
            TestUtils.log().debug("Tap is done by coordinates");
        } catch (Exception e) {
            TestUtils.log().debug("Getting Exception while performing tap by coordinates");
        }

    }

    /**
     * tap- Perform tap action by using point options
     *
     * @param x
     *         -int
     * @param y
     *         -int
     * @param delay
     *         -int
     * @return- boolean Date-02/11/2022
     */
    public static boolean tap(int x, int y, int delay) {
        try {
            new TouchAction<>(DriverManager.getDriver()).tap(point(x, y))
                    .waitAction(waitOptions(ofMillis(delay))).perform();
            TestUtils.log().debug("Tap perform successfully");
            return true;
        } catch (Exception e) {
            TestUtils.log().debug("Unable to perform tap action by point");
            return false;
        }

    }

    /**
     * waitForVisibility()- It waits for element till visibility
     *
     * @param mobileElement-MobileElement
     *         Date- 02/11/2022
     */
    public void waitForVisibility(MobileElement mobileElement) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while waited for the{} ", mobileElement);
        }
    }

    /**
     * swipeDown()- It swipe down device screen by provided swipe count
     *
     * @param swipeCount-int
     *         Date-02/11/2022
     */
//    public void swipeDown(int swipeCount) { // old code
//        try {
//            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
//            int startX = dimension.width / 2;
//            int endX = startX;
//            int startY = (int) (dimension.height * 0.9);
//            int endY = (int) (dimension.height * 0.1);
//            for (int i = 0; i < swipeCount; i++) {
//                touchAction = new TouchAction<>(DriverManager.getDriver());
//                touchAction.press(point(startX, startY)).
//                        /* It'll take 2 seconds to complete swipe operation */
//                                waitAction(waitOptions(ofMillis(2000))).
//                        // moveTo(PointOption.point(494, 386))
//                                moveTo(point(endX, endY)).release().perform();
//                TestUtils.log().debug("Swipe is performed successfully");
//            }
//        } catch (Exception e) {
//            TestUtils.log().debug("Getting exception while performing swipe down operation",e);
//        }
//    }

    public void swipeDown(int swipeCount) {  //Working code
        try {
            AppiumDriver driver = DriverManager.getDriver();
            Dimension dimension = driver.manage().window().getSize();
            int startX = dimension.width / 2;
            int startY = (int) (dimension.height * 0.8);
            int endY = (int) (dimension.height * 0.2);

            for (int i = 0; i < swipeCount; i++) {
                TouchAction touchAction = new TouchAction(driver);
                touchAction.press(point(startX, startY))
                        .waitAction(waitOptions(ofMillis(1000)))
                        .moveTo(point(startX, endY))
                        .release()
                        .perform();
                Thread.sleep(2000); // To simulate the wait
                TestUtils.log().debug("Swipe is performed successfully");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing swipe down operation", e);
        }
    }

    public void swipeDowne(String text) {
        try {
            AppiumDriver driver = DriverManager.getDriver();
            MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                            ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
            TestUtils.log().info("Swipping ......to "+text);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing swipe down operation", e);
        }
    }



    /**
     * swipeUp()- It swipe up device screen by provided swipe count
     *
     * @param swipeCount-int
     *         Date-02/11/2022
     */
    public void swipeUp(int swipeCount) {
        try {
            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            int startX = dimension.width / 2;
            int endX = startX;
            int startY = (int) (dimension.height * 0.2);
            int endY = (int) (dimension.height * 0.5);

            for (int i = 0; i < swipeCount; i++) {
                touchAction = new TouchAction<>(DriverManager.getDriver());
                touchAction.press(point(startX, startY)).
                        waitAction(waitOptions(ofMillis(2000))).
                        moveTo(point(endX, endY)).release().perform();
                TestUtils.log().debug("Swipe Up is performed successfully");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing swipe up operation",e);
        }
    }

    /**
     * click()-It is used to click on the mobile element
     *
     * @param mobileElement-
     *         MobileElement Date-02/11/2022
     */
    public void click(MobileElement mobileElement) {
        try {
            waitForVisibility(mobileElement);
//            TestUtils.log().debug("{} is clicked", mobileElement.getText());
            mobileElement.click();
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing click operation",e);
        }
    }

    /**
     * click-It is used to click on the mobile element with element name
     *
     * @param mobileElement-
     *         MobileElement
     * @param elementName-
     *         String Date-02/11/2022
     */
    public void click(MobileElement mobileElement, String elementName) {
        try {
            waitForVisibility(mobileElement);
            TestUtils.log().debug("{} is clicked", elementName);
            mobileElement.click();
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing click operation",e);
        }
    }

    /**
     * clear- It is used to clear previous text
     *
     * @param mobileElement-
     *         MobileElement
     * @param elementName-
     *         String Date-02/11/2022
     */
    public void clear(MobileElement mobileElement, String elementName) {
        try {
            waitForVisibility(mobileElement);
            TestUtils.log().debug("Clearing: {}", elementName);
            mobileElement.clear();
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing clear operation",e);
        }
    }

    /**
     * sendkeys- It is Used to send value in textbox of mobileElement
     *
     * @param mobileElement-
     *         MobileElement
     * @param txt-
     *         String Date-02/11/2022
     */
    public void sendKeys(MobileElement mobileElement, String txt) {
        try {
            waitForVisibility(mobileElement);
            TestUtils.log().debug("Filling {} in {}", txt, mobileElement.getText());
            clear(mobileElement, txt);
            mobileElement.sendKeys(txt);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing sendkeys operation",e);
        }
    }

    /**
     * sendKeys-Used to send value in textbox of mobileElement with elementName
     *
     * @param mobileElement-
     *         MobileElement
     * @param txt-
     *         String
     * @param elementName-
     *         String Date-02/11/2022
     */
    public void sendKeys(MobileElement mobileElement, String txt, String elementName) {
        try {
            waitForVisibility(mobileElement);
            TestUtils.log().debug("Filling {} in {}", txt, elementName);
            clear(mobileElement, elementName);
            mobileElement.sendKeys(txt);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing sendkeys operation",e);
        }
    }

    /**
     * getElementAttribute- It returns the attribute of the mobileElement
     *
     * @param mobileElement
     * @param attribute
     * @return String Date-02/11/2022
     */
    public String getElementAttribute(MobileElement mobileElement, String attribute) {
        try {
            waitForVisibility(mobileElement);
            TestUtils.log().debug("Attribute:{} value for{} is {}", attribute, mobileElement.getText(), mobileElement.getAttribute(attribute));
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting element's attribute value",e);
        }
        return mobileElement.getAttribute(attribute);
    }

    /**
     * getElementTagName - It returns the tagName of the given mobileElement
     *
     * @param mobileElement-
     *         MobileElement
     * @param tag-
     *         String
     * @return String Date-02/11/2022
     */
    public String getElementTagName(MobileElement mobileElement, String tag) {
        try {
            waitForVisibility(mobileElement);
            TestUtils.log().debug("TagName: {}  value for {} is - {}", tag, mobileElement.getText(), mobileElement.getTagName());
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting element's tag name");
        }
        return mobileElement.getTagName();
    }

    /**
     * getElementText -It returns the text value of mobileElement for Android and IOS
     *
     * @param- mobileElement
     * @return- String Date-02/11/2022
     */
    public String getElementText(MobileElement mobileElement) {
        String attrName = null;
        try {
            waitForVisibility(mobileElement);
            String platformName = DriverManager.getPlatform();
            if (platformName.equalsIgnoreCase(PLATFORM_ANDROID)) {
                TestUtils.log().debug("Attribute: text - value for {} is - {} ", mobileElement.getText(), mobileElement.getAttribute(TEXT));
                attrName = mobileElement.getAttribute(TEXT);

            } else if (platformName.equalsIgnoreCase(PLATFORM_IOS)) {
                TestUtils.log().debug("Attribute: label - value for {} is - {}", mobileElement.getText(), mobileElement.getAttribute(LABEL));
                attrName = mobileElement.getAttribute(LABEL);
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting element's text");
            attrName = "Getting exception while getting element's text";
        }
        return attrName;
    }

    /**
     * waitForGivenTime- It waits for the provided time
     *
     * @param time-long
     *         Date-02/11/2022
     */
    public void waitForGivenTime(long time) {
        try {
            Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while waiting....");
        }
    }

    /**
     * webElementPresent - It Check for the MobileElement presence
     *
     * @param mobileElement
     *         - MobileElement
     * @param elementName-
     *         String Date-02/11/2022
     */
    public void webElementPresent(MobileElement mobileElement, String elementName) {
        try {
            VerificationUtils.validate(isDisplayed(mobileElement), true, elementName + " presence");
            TestUtils.log().debug("{} is displayed on the screen ", mobileElement);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while checking element is present",e);
        }
    }

    /**
     * webElementAbsent- It check for the mobileElement absence
     *
     * @param mobileElement-MobileElement
     * @param elementName-String
     *         Date-02/11/2022
     */
    public void webElementAbsent(MobileElement mobileElement, String elementName) {
        try {
            VerificationUtils.validate(isDisplayed(mobileElement), false, elementName + " absence");
            TestUtils.log().debug("{} is not displayed on the screen", mobileElement);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while checking element is absent");
        }
    }

    /**
     * isDisplayed-It check whether mobileElement displayed or not
     *
     * @param element-MobileElement
     * @return -boolean Date-02/11/2022
     */
    public boolean isDisplayed(MobileElement element) {
        boolean flag = false;
        try {
            waitForVisibility(element);
            flag = element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException exception) {
            TestUtils.log().debug("{} is not displayed on the screen", element);
        }
        return flag;
    }

    /**
     * doubleClick-It double clicks on mobileElement
     *
     * @param mobileElement
     * @return boolean Date-02/11/2022
     */
    public boolean doubleClick(MobileElement mobileElement) {
        boolean flag = false;
        try {
            waitForVisibility(mobileElement);
            new TouchActions(DriverManager.getDriver()).moveToElement(mobileElement).doubleClick().perform();
            TestUtils.log().debug("{} is doubleClicked", mobileElement.getText());
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug(" Unable to perform doubleClick on {}", mobileElement);
            flag = false;
        }
        return flag;
    }

    /**
     * getSizeofElement-returns the size of the mobileElement
     *
     * @param element
     * @return String Date-02/11/2022
     */
    public String getSizeofElement(MobileElement element) {
        String sizeOfElement = null;
        try {
            waitForVisibility(element);
            int h = element.getSize().getHeight();
            int w = element.getSize().getWidth();
            sizeOfElement = (String) (" Height " + h + " Width " + w);
            TestUtils.log().debug("Size of element {}", element.getSize());
        } catch (NoSuchElementException | TimeoutException exception) {
            TestUtils.log().debug("Unable to return the size of element");
            sizeOfElement = ("Unable to return the size of element");
        }
        return sizeOfElement;
    }

    /**
     * getLocationofElement-It returns the location of the mobileElement
     *
     * @param element-
     *         MobileElement
     * @return- String Date-02/11/2022
     */
    public String getLocationofElement(MobileElement element) {
        String locOfElement = null;
        try {
            waitForVisibility(element);
            int h = element.getLocation().getX();
            int w = element.getLocation().getY();
            TestUtils.log().debug("Size of given element {}", element.getLocation());
            locOfElement = (String) (" Height " + h + " Width " + w);
        } catch (NoSuchElementException | TimeoutException exception) {
            TestUtils.log().debug("Unable to return the location of element");
            locOfElement = ("Unable to return the location of element");
        }
        return locOfElement;
    }

    /**
     * isKeyboardVisible-It checks for the visibility of the keyboard
     *
     * @return- boolean Date-02/11/2022
     */
    public boolean isKeyboardVisible() {
        boolean isVisible = false;
        try {
            if (((AndroidDriver) DriverManager.getDriver()).isKeyboardShown()
                    || ((IOSDriver) DriverManager.getDriver()).isKeyboardShown()) {
                TestUtils.log().debug("Keyboard is visible in screen");
                isVisible = true;
            } else {
                TestUtils.log().debug("Keyboard is already closed");
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while keyboard is visible...");
        }
        return isVisible;
    }

    /**
     * tapByElement- It perform tap action on mobileElement
     *
     * @param mobileElement-MobileElement
     * @return- boolean Date-02/11/2022
     */
    public boolean tapByElement(MobileElement mobileElement) {
        boolean flag = false;
        try {
            new TouchAction<>(DriverManager.getDriver()).tap(tapOptions().withElement(element(mobileElement))).waitAction(waitOptions(ofMillis(250))).perform();
            TestUtils.log().debug("Tap is performed successfully on {}", mobileElement);
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("Unable to perform tap action on {}", mobileElement);
        }
        return flag;
    }

    /**
     * doubleTapOnElement-Perform double tap action on mobileElement
     *
     * @param element
     * @return -boolean Date-02/11/2022
     */
    public boolean doubleTapOnElement(MobileElement element) {
        boolean flag = false;
        try {
            new TouchAction<>(DriverManager.getDriver()).press(point(element.getLocation())).release()
                    .perform().press(point(element.getLocation())).release().perform();
            TestUtils.log().debug("Double Tap is performed successfully on {}", element);
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("Unable to perform the doubleTap on {}", element);
        }
        return flag;
    }

    /**
     * holdAndDrag- perform hold and drag action on mobileElement
     *
     * @param startX-
     *         int
     * @param startY-
     *         int
     * @param endX-
     *         int
     * @param endY-
     *         int
     * @param delay-
     *         int Date-02/11/2022
     */
    public void holdAndDrag(int startX, int startY, int endX, int endY, int delay) {
        try {
            new TouchAction<>(DriverManager.getDriver()).press(point(startX, startY))
                    .waitAction(waitOptions(ofMillis(delay)))
                    .moveTo(point(endX, endY)).release().perform();
            TestUtils.log().info("Performed the hold and drag operation");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing the hold and drag operation....");
        }
    }

    /**
     * scrollUpTillElement-Perform scrollup action till mobileElement
     *
     * @param element-int
     * @param steps-
     *         int
     * @param slow-
     *         int Date-02/11/2022
     */
    public void scrollUpTillElement(MobileElement element, int steps, double slow) {
        try {
            Dimension size = DriverManager.getDriver().manage().window().getSize();
            int anchor = (int) (size.width * 0.60);
            int startPoint = (int) (size.height * 0.90);
            int endPoint = (int) (size.height * (0.40 + slow));
            holdAndDrag(anchor, startPoint, anchor, endPoint, steps);
            TestUtils.log().info("Performed scroll up operation till element to visible");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing scroll up till element to visible....");
        }
    }

    /**
     * scrollDownTillElement- Perform scroll down action on mobileElement
     *
     * @param steps-int
     * @param slow-double
     *         Date-02/11/2022
     */
    public void scrollDownTillElement(int steps, double slow) {
        try {
            Dimension size = DriverManager.getDriver().manage().window().getSize();
            int anchor = (int) (size.width * 0.30);
            int starty = (int) (size.height * (0.80 - slow));
            int endy = (int) (size.height * 0.40);
            holdAndDrag(anchor, endy, anchor, starty, steps);
            TestUtils.log().info("Performed scroll down operation till element to visible");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing scroll down till element to visible....");
        }
    }

    /**
     * dragAndDropByElement-It drag and drop mobileElement
     *
     * @param source-MobileElement
     * @param destination-
     *         MobileElement
     * @param wait-
     *         int
     * @return- boolean Date-02/11/2022
     */
    public boolean dragAndDropByElement(MobileElement source, MobileElement destination, int wait) {
        boolean flag = false;
        try {
            new TouchAction<>(DriverManager.getDriver()).longPress(element(source))
                    .waitAction(waitOptions(ofMillis(wait)))
                    .moveTo(element(destination)).release().perform();
            TestUtils.log().debug("Performed drag and drop operation from {} to {}", source, destination);
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing drag and drop operation from {} to {}", source, destination);
        }
        return flag;
    }

    /**
     * isElementVisible- This method checks the visibility of the element
     *
     * @param element-MobileElement
     * @return- boolean Date-02/11/2022
     */
    public boolean isElementVisible(MobileElement element) {
        boolean flag = false;
        try {
            element.isDisplayed();
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while element to visible....");
        }
        return flag;
    }

    /**
     * scrollRight-This method will scroll right from MobileElement
     *
     * @param element-
     *         MobileElement Date-02/11/2022
     */
    public void scrollRight(MobileElement element) {
        try {
            Dimension size = element.getSize();
            int x = element.getLocation().getX();
            int starty = size.height / 2;
            int startx = (int) ((size.width * 0.70) + x);
            int endx = (int) ((size.width * 0.30) + x);
            holdAndDrag(startx, starty, endx, starty, 1000);
            TestUtils.log().debug("Element is successfully performed scroll right");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing element to scroll right....");
        }
    }

    /**
     * scrollLeft- This method will scroll left from mobileElement
     *
     * @param element-
     *         MobileElement int Date-02/11/2022
     */
    public void scrollLeft(MobileElement element) {
        try {
            Dimension size = element.getSize();
            int x = element.getLocation().getX();
            int starty = size.height / 2;
            int startx = (int) ((size.width * 0.70) + x);
            int endx = (int) ((size.width * 0.30) + x);
            holdAndDrag(startx, starty, endx, starty, 1000);
            TestUtils.log().info("Element is successfully performed scroll left");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing element to scroll left....");
        }
    }

    /**
     * openNotification- This method will open notification bar Date-02/11/2022
     */
    public void openNotification() {
        try {
            Dimension size = DriverManager.getDriver().manage().window().getSize();
            int starty = size.height * 0;
            int endy = (int) (size.height * 0.90);
            int startx = size.width / 2;
            holdAndDrag(startx, starty, startx, endy, 500);
            TestUtils.log().info("Notification is open successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while opening the notification....");
        }
    }

    /**
     * isElementEnable- This method checks that element is enable or not
     *
     * @param element-
     *         MobileElement
     * @return- boolean Date-02/11/2022
     */
    public boolean isElementEnable(MobileElement element) {
        boolean flag = false;
        try {
            waitForVisibility(element);
            TestUtils.log().info("{} Element is enabled", element);
            flag = element.isEnabled();
        } catch (NoSuchElementException | TimeoutException exception) {
            TestUtils.log().debug("Getting exception while enable the element...");
            flag = false;
        }
        return flag;
    }

    /**
     * clickSeekbar-This method clicks on seekbar
     *
     * @param seekbar-MobileElement
     * @param slider-
     *         MobileElement
     * @param position-
     *         int Date-02/11/2022
     */
    public void clickSeekbar(MobileElement seekbar, MobileElement slider, int position) {
        try {
            int offset = seekbar.getLocation().getX();
            int end = seekbar.getSize().getWidth();
            int y = slider.getLocation().getY();

            // Select till which position you want to move the seekbar
            int moveTo;
            if (position == 0)
                moveTo = (end * position / 100) + offset;
            else if (position == 100)
                moveTo = (end * position / 100) + offset;
            else if (position >= 50)
                moveTo = (end * position / 100) + offset - ((position - 50) * (end / 100) / 10);
            else
                moveTo = (end * position / 100) + offset + ((50 - position) * (end / 100) / 10);
            tapByCoordinates(moveTo, y);
            TestUtils.log().info("Clicking to seekbar successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while clicking to seekbar....");
        }
    }

    /**
     * navigateBack- This method navigate back to previous page Date-02/11/2022
     */
    public void navigateBack() {
        try {
            DriverManager.getDriver().navigate().back();
            TestUtils.log().info("Performed navigating back successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing navigating back....");
        }
    }

    /**
     * hideKeyboard- This method will hide the keyboard Date-02/11/2022
     */
    public void hideKeyboard() {
        try {
            if (!(DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID))) {
                DriverManager.getDriver().findElement(MobileBy.AccessibilityId("Done")).click();
            } else {
                DriverManager.getDriver().hideKeyboard();
            }
            TestUtils.log().info("Hide keyboard successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while hiding keyboard....");
        }
    }

    /**
     * checkMarktheCheckBox- This method checks the checkbox
     *
     * @param element
     * @return- boolean Date-02/11/2022
     */
    public boolean checkMarktheCheckBox(MobileElement element) {
        boolean flag = false;
        try {
            if (!element.isSelected()) {
                element.click();
                TestUtils.log().info("{} Checkmark the checkbox for element", element);
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            TestUtils.log().info("{} Unable to checkmark the checkbox for element", element);
            TestUtils.log().debug("Getting exception while checkmark the checkbox for element");
            return flag;
        }
    }

    /**
     * uncheckTheCheckBox-This method unchecks the checkbox
     *
     * @param element-MobileElement
     * @return- boolean Date-02/11/2022
     */
    public boolean uncheckTheCheckBox(MobileElement element) {
        boolean flag = false;
        try {
            if (element.isSelected()) {
                element.click();
                TestUtils.log().info("{} Uncheck mark the checkbox for element", element);
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            TestUtils.log().info("{} Unable to uncheck mark the checkbox for element", element);
            TestUtils.log().debug("Getting exception while uncheck mark the checkbox for element");
            return flag;
        }
    }

    /**
     * clickAndHoldElement-This method click on hold the mobileElement
     *
     * @param mobileElement-
     *         MobileElement
     * @return- boolean Date-02/11/2022
     */
    public boolean clickAndHoldElement(MobileElement mobileElement) {
        boolean flag = false;
        try {
            waitForVisibility(mobileElement);
            new TouchActions(DriverManager.getDriver()).clickAndHold(mobileElement);
            TestUtils.log().debug("{} is clicked and hold the element", mobileElement);
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("{} Unable to perform clicked and hold the element", mobileElement);
            TestUtils.log().debug("Getting exception while perform clicked and hold the element");
        }
        return flag;
    }

    /**
     * longPressOnElement- This method performs long press on the mobile element
     *
     * @param mobileElement-
     *         MobileElement
     * @return-boolean Date-02/11/2022
     */
    public boolean longPressOnElement(MobileElement mobileElement) {
        boolean flag = false;
        try {
            waitForVisibility(mobileElement);
            new TouchActions(DriverManager.getDriver()).longPress(mobileElement).perform();
            TestUtils.log().debug("{} is successfully performed long press", mobileElement);
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("{} Unable to perform long press", mobileElement);
            TestUtils.log().debug("Getting exception while perform long press");
        }
        return flag;
    }

    /**
     * tapAndHoldElement- This method performs tap and hold action on the mobile element
     *
     * @param mobileElement-
     *         MobileElement
     * @return-boolean Date-02/11/2022
     */
    public boolean tapAndHoldElement(MobileElement mobileElement) {
        boolean flag = false;
        try {
            waitForVisibility(mobileElement);
            new TouchAction<>(DriverManager.getDriver())
                    .longPress(LongPressOptions.longPressOptions().withElement(element(mobileElement))).perform();
            TestUtils.log().debug("{} is Successfully tap and hold element", mobileElement);
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("{} Unable to tap and hold element", mobileElement);
            TestUtils.log().debug("Getting exception while perform tap and hold element");
        }
        return flag;
    }

    /**
     * releaseTheElement- this method performs release action on the mobile element
     *
     * @param mobileElement-
     *         MobileElement
     * @return- boolean Date-02/11/2022
     */
    public boolean releaseTheElement(MobileElement mobileElement) {
        boolean flag = false;
        try {
            waitForVisibility(mobileElement);
            new TouchActions(DriverManager.getDriver()).release(mobileElement).perform();
            TestUtils.log().debug("{} is successfully performed release action", mobileElement.getText());
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("{} Unable to perform release action", mobileElement.getText());
            TestUtils.log().debug("Getting exception while perform release action");
        }
        return flag;
    }

    /**
     * identifyAppState- This method identifies the app state Date-02/11/2022 Current the target app status. (Clients wrap the response properly) 0 is not installed. 1 is not running. 2 is running in background or suspended. 3 is running in background. 4 is running in foreground. (number)
     */
    public void identifyAppState() {
        try {
            if ((DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID))
                    || (DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_IOS))) {

                String bundelId = ConfigLoader.getInstance().getiOSBundleID();
                String appPackage = ConfigLoader.getInstance().getAndroidAppPackage();
                if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.RUNNING_IN_FOREGROUND))
                        || (DriverManager.getDriver().queryAppState(bundelId) == (ApplicationState.RUNNING_IN_FOREGROUND))) {
                    TestUtils.log().info("{} Application is running at foreground ", appPackage);
                } else if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.RUNNING_IN_BACKGROUND))
                        || (DriverManager.getDriver().queryAppState(bundelId) == (ApplicationState.RUNNING_IN_BACKGROUND))) {
                    TestUtils.log().info("{} Application is running at background ", appPackage);
                } else if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.NOT_RUNNING))
                        || (DriverManager.getDriver().queryAppState(bundelId) == (ApplicationState.NOT_RUNNING))) {
                    TestUtils.log().info("{} Application is not running ", appPackage);
                } else {
                    TestUtils.log().info("{} Application is not installed ", appPackage);
                }
            }
        } catch (Exception e) {
            TestUtils.log().info("Do not get the application status ");
            TestUtils.log().debug("Getting exception while identifying app state");
        }
    }

    /**
     * waitForPageLoad-This method waits till page to load
     *
     * @param waitTime
     *         Date-02/11/2022
     */
    protected void waitForPageLoad(int waitTime) {
        try {
            DriverManager.getDriver().manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
            TestUtils.log().info("Waiting for page to load for {}", waitTime);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while waiting for page to load with in specific time duration");
        }
    }

    /**
     * doClear-This method clears the mobile element
     *
     * @param element-
     *         MobileElement Date-02/11/2022
     */
    protected void doClear(MobileElement element) {
        try {
            element.clear();
            TestUtils.log().info("Successfully clear the text field/text box");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while clearing the text field/text box...");
        }
    }

    /**
     * getServerStatus-This method gets server status Date-02/11/2022
     */
    protected void getServerStatus() {
        try {
            DriverManager.getDriver().getStatus();
            TestUtils.log().info("Successfully get the server status");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while to get the server status...");
        }
    }

    /**
     * setOrientation- This method sets the screen orientation
     *
     * @param screenOrientationType-
     *         ScreenOrientation Date-02/11/2022
     */
    protected void setOrientation(ScreenOrientation screenOrientationType) {
        switch (screenOrientationType) {
            case LANDSCAPE:
                try {
                    DriverManager.getDriver().rotate(ScreenOrientation.LANDSCAPE);
                    TestUtils.log().info("Device Orientation is set to Landscape");
                } catch (Exception e) {
                    TestUtils.log().debug("Getting exception while device Orientation is set to Landscape...");
                }
                break;
            case PORTRAIT:
                try {
                    DriverManager.getDriver().rotate(ScreenOrientation.PORTRAIT);
                    TestUtils.log().info("Device Orientation is set to Portrait");
                } catch (Exception e) {
                    TestUtils.log().debug("Getting exception while device Orientation is set to Portrait...");
                }
                break;
            default:
                TestUtils.log().info("Unexpected value in Screen Orientation: {}", screenOrientationType);
                throw new IllegalStateException("Unexpected value in Screen Orientation: " + screenOrientationType);
        }
    }

    /**
     * backgroundApp- This method allows to run app in background Date-02/11/2022
     */
    protected void sendAppInBackground(int time) {
        try {
            DriverManager.getDriver().runAppInBackground(Duration.ofSeconds(time));
            TestUtils.log().info("App is running in background");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while App is running in background...");
        }
    }

    /**
     * isElementEnabled-This method checks whether the element is enabled or not
     *
     * @param element-
     *         MobileElement
     * @return- boolean
     */
    protected boolean isElementEnabled(MobileElement element) {
        boolean flag = false;
        try {
            TestUtils.log().debug("{} element is getting enabled", element);
            flag = element.isEnabled();
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while element is getting enabled...");
        }
        return flag;
    }

    /**
     * getActiveElement-This method
     *
     * @return- WebElement Date-02/11/2022
     */
    protected Object getActiveElement() {
        try {
            TestUtils.log().info("Active element is getting successfully");
            return DriverManager.getDriver().switchTo().activeElement();
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception to get active element...");
            return "Getting exception to get active element...";
        }
    }

    /**
     * doubleClickOnElement- This method performs the double click action on mobile element
     *
     * @param element
     *         Date-02/11/2022
     */
    protected void doubleClickOnElement(WebElement element) {
        try {
            new Actions(DriverManager.getDriver())
                    .moveToElement(element)
                    .doubleClick()
                    .perform();
            TestUtils.log().info("Double click on element : {}", element);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception to perform double click on element...");
        }
    }

    /**
     * acceptAlert- This method will accept the alert Date-02/11/2022
     */
    public void acceptAlert() {
        try {
            DriverManager.getDriver().executeScript("mobile:acceptAlert");
            TestUtils.log().info("Accept Alert");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception to accept alert...");
        }
    }

    /**
     * dismissAlert- This method will dismiss the alert\ Date-02/11/2022
     */
    public void dismissAlert() {
        try {
            DriverManager.getDriver().executeScript("mobile:dismissAlert");
            TestUtils.log().info("Dismiss Alert");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception to dismiss alert...");
        }
    }

    /**
     * selectRadioButton- This method select the RadioButton
     *
     * @param element
     * @return- boolean Date-29/12/2022
     */
    public boolean selectRadioButton(MobileElement element) {
        boolean flag = false;
        try {
            if (!element.isSelected()) {
                element.click();
                TestUtils.log().info("{} Select the radio button for element", element.getText());
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            TestUtils.log().info("Unable to select the radio button for element");
            TestUtils.log().debug("Getting exception to unable to select the radio button for element");
            return flag;
        }
    }

    public boolean switchToAnotherApp(String bundleIdOrAppPackage) {
        boolean flag = false;
        try {
            DriverManager.getDriver().activateApp(bundleIdOrAppPackage);
            TestUtils.log().info("Switch to another app successfully");
            flag = true;
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while switching to another app...");
            throw new AutomationException(
                    "Error occurred : Not able to switch to another app with bundleId or AppPackage as "
                            + bundleIdOrAppPackage + "\n" + e.getMessage());
        }
        return flag;
    }

    public String getAppState() {
        String strAppState = "";
        try {
            if ((DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID))
                    || (DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_IOS))) {
                String bundleId = ConfigLoader.getInstance().getiOSBundleID();
                String appPackage = ConfigLoader.getInstance().getAndroidAppPackage();
                if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.RUNNING_IN_FOREGROUND))
                        || (DriverManager.getDriver().queryAppState(bundleId) == (ApplicationState.RUNNING_IN_FOREGROUND))) {
                    TestUtils.log().info("{} Application is running at foreground ", appPackage);
                    strAppState = "Foreground";
                } else if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.RUNNING_IN_BACKGROUND))
                        || (DriverManager.getDriver().queryAppState(bundleId) == (ApplicationState.RUNNING_IN_BACKGROUND))) {
                    TestUtils.log().info("{} Application is running at background ", appPackage);
                    strAppState = "Background";
                } else if ((DriverManager.getDriver().queryAppState(appPackage) == (ApplicationState.NOT_RUNNING))
                        || (DriverManager.getDriver().queryAppState(bundleId) == (ApplicationState.NOT_RUNNING))) {
                    TestUtils.log().info("{} Application is not running ", appPackage);
                    strAppState = "Killed";
                }
            }
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while getting the app state...");
        }
        return strAppState;
    }

    /**
     * This method contains Flaunt wait for Clickable element to be load within the polling period
     *
     * @param element
     * @throws InterruptedException
     */
    public void waitForElementClickable(MobileElement element) throws AutomationException {
        try {
            FluentWait fluentwait = new FluentWait(DriverManager.getDriver());
            fluentwait.pollingEvery(5, TimeUnit.SECONDS);
            waitForGivenTime(40);
            fluentwait.until(ExpectedConditions.elementToBeClickable(element));
            TestUtils.log().info("Waiting for element to be clickable");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while waiting for element to be clickable...");
        }
    }

    /**
     * This method custom wait for Clickable element to be load
     *
     * @param element
     * @throws InterruptedException
     */
    public void waitForElement(WebElement element) {
        int count = 0;
        try {
            while (count < 20) {
                try {
                    element.click();
                    break;
                } catch (Exception e) {
                    waitForGivenTime(10000);
                    count++;
                }
            }
            TestUtils.log().info("Waiting for element");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while waiting for element...");
        }
    }

    /***
     * toUnlock() - This method is used for unlock the device Date-08/02/2023
     */
    public void toUnlock() {
        waitForGivenTime(1);
        try {
            if (DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID)) {
                AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) DriverManager.getDriver();
                driver.unlockDevice();
            } else {
                IOSDriver<MobileElement> driver = (IOSDriver<MobileElement>) DriverManager.getDriver();
                driver.unlockDevice();
            }
            TestUtils.log().info("To Unlock the phone");
        } catch (Exception e) {

            TestUtils.log().debug("Getting exception while unlock the phone...");
        }
        waitForGivenTime(1);
    }

    /***
     * toLock() - This method is used for lock the device Date-08/02/2023
     */
    public void toLock() {
        try {
            if (DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID)) {
                AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) DriverManager.getDriver();
                driver.lockDevice();
            } else {
                IOSDriver<MobileElement> driver = (IOSDriver<MobileElement>) DriverManager.getDriver();
                driver.lockDevice();
            }
            TestUtils.log().info("To Lock the phone");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while lock the phone...");
        }
    }

    /***
     * clickByJavaScript - This method is used to click on to the web page through Java script Date-08/02/2023
     *
     * @param element
     */
    public void clickByJavaScript(MobileElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
            executor.executeScript("arguments[0].click();", element);
            TestUtils.log().info("Clicking to an element via JavascriptExecutor");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while clicking to an element via JavascriptExecutor...");
        }
    }

    /***
     * loopHandle - This method is used to handle the loop related problems Date-08/02/2023
     *
     * @param element
     * @param actionType
     * @param timeDuration
     */
    public void loopHandle(MobileElement element, String actionType, int timeDuration) {
        try {
            long start = System.currentTimeMillis();
            while (!isElementVisible(element)) {
                long end = System.currentTimeMillis();
                float sec = (end - start) / 1000F;
                if (sec > timeDuration) {
                    TestUtils.log().info("Respective page not found/application issue!!!!!");
                    break;
                } else {
                    switch (actionType) {
                        case "navigateBack" -> {
                            navigateBack();
                            TestUtils.log().info("Navigating Back !!!!!!");
                        }
                        case "swipeUp" -> {
                            swipeUp(1);
                            TestUtils.log().info("Doing Swipe up !!!!!!");
                        }
                        case "swipeDown" -> {
//                            swipeDown(1);
                            TestUtils.log().info("Doing Swipe Down !!!!!!");
                        }

                        default -> TestUtils.log().info("Please provided right input ");
                    }
                }
            }
            TestUtils.log().info("{} : operation successfully done", actionType);
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing : {}", e);
        }
    }

    /***
     * iOSScrollDownTillElement - This method is used perform scroll till element for IOS  Date-08/02/2023
     *
     * @param e
     * @return
     */
    public MobileElement iOSScrollDownTillElement(MobileElement e) {
        try {
            RemoteWebElement element = ((RemoteWebElement) e);
            String elementID = element.getId();
            HashMap<String, String> scrollObject = new HashMap<String, String>();
            scrollObject.put("element", elementID);
            scrollObject.put("toVisible", "e");
            DriverManager.getDriver().executeScript("mobile:scroll", scrollObject);
            TestUtils.log().info("Performed scroll down till the element successfully");
        } catch (Exception ex) {
            TestUtils.log().debug("Getting exception while performing scroll down till the element");
        }
        return e;
    }

    /**
     * find - This method is used to find an element   Date-08/02/2023
     *
     * @param element
     * @param timeout
     * @return
     */
    private boolean find(final MobileElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
            TestUtils.log().info("Successfully find element : {}", element);
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while finding element...");
            return false;
        }
    }

    /***
     * iosScrollUpAndDownToElement - This method is used perform scroll till element (Up/Down) for IOS  Date-08/02/2023
     *
     * @param element
     * @param direction
     * @return
     * @throws Exception
     */
    public MobileElement iosScrollUpAndDownToElement(MobileElement element, String direction) throws AutomationException {
        try {
            Dimension size = DriverManager.getDriver().manage().window().getSize();
            int startX = (int) (size.width * 0.5);
            int endX = (int) (size.width * 0.5);
            int startY = 0;
            int endY = 0;
            boolean isFound = false;

            switch (direction) {
                case "up":
                    endY = (int) (size.height * 0.4);
                    startY = (int) (size.height * 0.6);
                    break;

                case "down":
                    endY = (int) (size.height * 0.6);
                    startY = (int) (size.height * 0.4);
                    break;

                default:
                    TestUtils.log().info("Please provided the right direction for scroll");
            }

            for (int i = 0; i < 5; i++) {
                if (find(element, 1)) {
                    isFound = true;
                    break;
                } else {
                    holdAndDrag(startX, startY, endX, endY, 1000);
                }
            }
            if (!isFound) {
                throw new AutomationException("Element not found");
            }
            TestUtils.log().info("Performed scroll {} till the element successfully", direction);
        } catch (Exception ex) {
            TestUtils.log().debug("Getting exception while performing scroll {} till the element", direction);
        }
        return element;
    }

    /**
     * toKnowDeviceState- This method is used to get the device state (Locked)
     *
     * @return -boolean Date-08/02/2023
     */
    public boolean toKnowDeviceLockedState() {
        boolean bnFlag = false;
        try {
            if (DriverManager.getPlatform().equalsIgnoreCase(PLATFORM_ANDROID)) {
                    if (isDeviceLocked()) {
                        TestUtils.log().info("***** Device is Locked *****");
                        bnFlag = true;
                    }
            } else {
                IOSDriver<MobileElement> driver = (IOSDriver<MobileElement>) DriverManager.getDriver();
                if (driver.isDeviceLocked()) {
                    TestUtils.log().info("***** Device is Locked *****");
                    bnFlag = true;
                }
            }
        } catch (Exception ex) {
            TestUtils.log().debug("Getting exception while performing to get device locked state");
        }
        return bnFlag;
    }
    public boolean isDeviceLocked() {
        try {
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
            return driver.isDeviceLocked();
        } catch (Exception e) {
            TestUtils.log().error("Error checking device lock state, retrying...", e);
            waitForGivenTime(2);
            return retryCheckLockState();  // Call a retry method
        }
    }

    private boolean retryCheckLockState() {
        try {
            AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
            return driver.isDeviceLocked();
        } catch (Exception e) {
            TestUtils.log().error("Retry failed. Device lock state unknown.", e);
            return false;
        }
    }

    // Method to check if the device is locked using ADB
//    private boolean isDeviceLocked() {
//        try {
//            // First, try checking keyguard status using dumpsys
//            String command = ConfigLoader.getInstance().getAdbPath() + " shell dumpsys window | grep mShowingLockscreen";
//            String result = AndroidDeviceAction.executeCommandAndGetOutput(command);
//
//            if (result.toLowerCase().contains("mShowingLockscreen=true")) {
//                return true; // Device is locked
//            }
//
//            // If the first check fails, try an alternative approach
//            command = "adb shell dumpsys keyguard | grep 'mDeviceLocked'";
//            result = AndroidDeviceAction.executeCommandAndGetOutput(command);
//
//            if (result.toLowerCase().contains("mDeviceLocked=true")) {
//                return true; // Device is locked
//            }
//
//            return false; // Device is not locked
//        } catch (Exception e) {
//            TestUtils.log().error("Error checking device lock state: " + e.getMessage(), e);
//            return false; // Assume unlocked in case of an error
//        }
//    }

    /**
     * swipeUp()- It swipe left device screen by provided swipe count
     *
     * @param swipeLeftCount-int
     *         Date-02/05/2023
     */
    public void  swipeLeft(int swipeLeftCount) {
        try {
            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            int startX = (int) (dimension.width * 0.9);
            int endX = (int) (dimension.width * 0.1);
            int y = dimension.height / 2;

            TouchAction touchAction1 = new TouchAction<>(DriverManager.getDriver());

            touchAction1.press(PointOption.point(startX, y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(endX, y))
                    .release()
                    .perform();
            TestUtils.log().debug("Swipe Left is performed successfully");
        } catch (Exception e) {
            TestUtils.log().debug("Getting exception while performing swipe left operation");
        }
    }

    public String getADBPath() {
        TestUtils.log().info("Entered &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        String androidHome = System.getenv("ANDROID_HOME");

        // If ANDROID_HOME is set and not empty
        if (androidHome != null && !androidHome.isEmpty()) {
            // Construct the path to the ADB executable
            File platformToolsDir = new File(androidHome, "platform-tools");

            // Check if the platform-tools directory exists
            if (platformToolsDir.exists()) {
                File adbExecutable = new File(platformToolsDir, "adb");

                // Check if the ADB executable exists
                if (adbExecutable.exists()) {
                    // Return the absolute path to the ADB executable
                    return adbExecutable.getAbsolutePath();
                }
            }
        }

        // If ADB path is not found, return null or handle accordingly
        return null;
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win");
    }
}

