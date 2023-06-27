package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Andr_HIDConvenientScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in convenient page Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnClose")
    private MobileElement btnClose;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnAccept")
    private MobileElement btnAccept;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getEulaCloseIcon() {
        return btnClose;
    }

    public MobileElement getAcceptButton() {
        return btnAccept;
    }

    /**
     * closeConvenientPage- This method is used to close the convenient page Date- 25/01/2023
     */
    public void closeConvenientPage() {
        try {
            click(btnClose);
            click(btnAccept);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while closing convenient page...");
        }

    }

    /**
     * checkVisibilityOfConvenientPage- This method is used to check visibility of the convenient page Date- 25/01/2023
     */
    public boolean checkVisibilityOfConvenientPage() {
        boolean flag = false;
        try {
            if (!isDisplayed(btnClose)) {
                TestUtils.log().info("Convenient page is not displayed");
                flag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking visibility of convenient page...");
        }
        return flag;
    }

}
