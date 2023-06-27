package com.appium.HIDPages.ios;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOS_HIDHelpCenterActivityLogScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in Help Center Activity Log Screen Page Date-25/1/2023
     */

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Help Centre\"]")
    private MobileElement imgBackFromActivity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activity\"]")
    private MobileElement txtActivity;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"TODAY\"]")
    private MobileElement txtToday;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"TODAY\"]//following-sibling::XCUIElementTypeStaticText)[1]")
    private MobileElement txtMobileIdRead;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Mobile ID Read\"])[1]//following-sibling::XCUIElementTypeStaticText[1]")
    private MobileElement txtTime;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"TODAY\"]//following-sibling::XCUIElementTypeStaticText)[3]")
    private MobileElement txtSuccessMessage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"TODAY\"]//following-sibling::XCUIElementTypeStaticText)[4]")
    private MobileElement txtActionName;
    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"signoReader\"])[1]", priority = 0)
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"TODAY\"]//following-sibling:: XCUIElementTypeImage)[1]", priority = 1)
    private MobileElement imgReader;

    /**
     * getter methods - These are getter methods for above mentioned mobile elements Date-25/1/2023
     */
    public MobileElement getImgBackFromActivity() {
        return imgBackFromActivity;
    }

    public MobileElement getTxtActivity() {
        return txtActivity;
    }

    public MobileElement getTxtToday() {
        return txtToday;
    }

    public MobileElement getTxtMobileIdRead() {
        return txtMobileIdRead;
    }

    public MobileElement getTxtSuccessMessage() {
        return txtSuccessMessage;
    }

    public MobileElement getTxtActionName() {
        return txtActionName;
    }

    public MobileElement getImgReader() {
        return imgReader;
    }

    public MobileElement getTxtTime() {
        return txtTime;
    }

    /**
     * getTodayDate- This method is used to get the reader action date in string from activity log
     *
     * @return- String Date-25/1/2023
     */
    public String getTodayDate() {
        String date = "";
        try {
            if (isDisplayed(txtToday)) {
                date = getElementText(txtToday);
            } else
                TestUtils.log().info("Today's date is not displayed");
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while getting today's date...");
        }
        return date;
    }

    /**
     * getMobileIDRead- This method is used to get the mobile Ids in string from activity log
     *
     * @return- String Date-25/1/2023
     */
    public String getMobileIDRead() {
        String mobileRead = "";
        try {
            if (isDisplayed(txtMobileIdRead)) {
                mobileRead = getElementText(txtMobileIdRead);
            } else
                TestUtils.log().info("Mobile ID reader text is not displayed");
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while getting Mobile ID reader text...");
        }
        return mobileRead;
    }

    /**
     * getSuccessMessage- This method is used to get the reader action success message in string from activity log
     *
     * @return- String Date-25/1/2023
     */
    public String getSuccessMessage() {
        String successMessage = "";
        try {
            if (isDisplayed(txtSuccessMessage)) {
                successMessage = getElementText(txtSuccessMessage);
            } else
                TestUtils.log().info("Success message is not displayed");
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while getting success message...");
        }
        return successMessage;
    }

    /**
     * getTime- This method is used to get the reader action time in string from activity log
     *
     * @return- String Date-25/1/2023
     */
    public String getTime() {
        String time = "";
        try {
            if (isDisplayed(txtTime)) {
                time = getElementText(txtTime);
            } else
                TestUtils.log().info("No time is displayed");
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while getting time...");
        }
        return time;
    }

    /**
     * getActionName- This method is used to get the reader action name in string from activity log
     *
     * @return- String Date-25/1/2023
     */
    public String getActionName() {
        String action = getElementText(txtActionName);
        String[] actionName = action.split("\\|");
        try {

            if (isDisplayed(txtActionName)) {
                TestUtils.log().info("Action Name is : {}",actionName[0]);
            } else {
                TestUtils.log().info("Action name is not displayed");
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while getting Action name...");
        }
        return actionName[0].trim();
    }

    /**
     * getReaderName- This method is used to get the reader name in string from activity log
     *
     * @return- String Date-25/1/2023
     */
    public String getReaderName() {

        String reader = getElementText(txtActionName);
        String[] readerName = reader.split("\\|");
        try {
            if (isDisplayed(imgReader)) {
                TestUtils.log().info("Reader name is : {}",readerName[1]);
            } else {
                TestUtils.log().info("Reader name is not displayed");
            }
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while getting Reader name...");
        }
        return readerName[1].trim();
    }

    /**
     * isActivityLogScreenDisplayed- This method is used to verify the activity screen is displayed or not
     *
     * @return- boolean Date-25/1/2023
     */
    public boolean isActivityLogScreenDisplayed() {
        return isElementEnable(txtActivity);
    }

    /**
     * clickOnBackToHelpCenter- This method is used to click on back button from help center Date-25/1/2023
     */
    public void clickOnBackToHelpCenter() {
        try {
            click(imgBackFromActivity);
        } catch (Exception e) {
            
            TestUtils.log().info("Exception occurred while clicking on back to help center button...");
        }
    }
}
