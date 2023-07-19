package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

public class Andr_HIDOnboardingScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in OnboardingScreen page Date-02/05/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtSkip")
    private MobileElement btnSkip;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnAccept")
    private MobileElement btnAccept;

    /**
    *mobile elements - These are mobile elements which is present in FavoriteReader Onboarding Screen Date-03/05/2023
    **/

   // @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtGetStarted")
  //  private  MobileElement btnGetStarted;

    /**
     *mobile elements - These are mobile elements which is present in Banners Onboarding Screen Date-03/06/2023
     **/
    @AndroidFindBy(id ="com.hidglobal.mobilekeys.android.v3:id/txtPermissionBanners")
    private MobileElement bannerScreenHeader;

    @AndroidFindBy(id ="com.hidglobal.mobilekeys.android.v3:id/txtPermissionBannersDescription")
    private MobileElement bannerScreenDesc;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtGetStarted")
    private  MobileElement btnGetStarted;

    /**
     * These are the mobile elements required to validate the descriptions in the Onboarding Screens Date-03/05/2023
     **/

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtConvenientDesc")
    private MobileElement convDesc;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtTwistAndGoDescription")
    private MobileElement twistAndGoDesc;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtFavReaderDescription")
    private MobileElement favReaderDesc;


    String convDescTxt="Your mobile device is your access card - even when you’re offline!";
    String twistAndGoDescTxt="Simply twist your phone in front of you… and go!";
    String favReaderDescTxt="Select the reader(s) you want to tag as favorite. When nearby, favorite readers are targeted for door opening.";

    String bannersDescTxt="An intuitive way to provide information about settings that can improve HID Mobile Access experience. Note! We do not track or store your location.";

    /*public MobileElement getBtnSkip() {
        return btnSkip;
    }
    */
    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    /*public MobileElement getEulaCloseIcon() {
        return btnClose;
    }*/


   /* public MobileElement getAcceptButton() {
        return btnAccept;
    }
    */

    /**
     * closeConvenientPage- This method is used to close the convenient page Date- 25/01/2023
     */
    /*
    public void closeConvenientPage() {
        try {
            click(btnClose);
            click(btnAccept);
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while closing convenient page...");
        }

    }*/

    /**
     * skipConvenientPage- This method is used to close the convenient page Date- 26/04/2023
    **/

    public void skipConvenientPage() {
        try {

            click(btnSkip);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating text in convenient page...");
        }

    }

    /**
     * skipTwistAndGoPage- This method is used to skip the TwistAndGo page Date- 26/04/2023
     **/

    public void skipTwistAndGoPage() {
        try {

            click(btnSkip);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating text in Twist&Go page...");
        }

    }


    /**
     * checkVisibilityOfConvenientPage- This method is used to check visibility of the convenient page Date- 25/01/2023
     */
    public boolean checkVisibilityOfConvenientPage() {
        boolean flag = false;
        try {

            if (!isDisplayed(btnSkip)) {
                TestUtils.log().info("Convenient page is not displayed");
                flag = true;
            }
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking visibility of convenient page...");
        }
        return flag;

    }

    /**
     * checkVisibilityOfTwistAndGoPage- This method is used to check visibility of the TwistAndGo page Date- 02/05/2023
     */
    public boolean checkVisibilityOfTwistAndGoPage() {
        boolean flag = false;
        try {
                checkVisibilityOfConvenientPage();
                swipeLeft(1);
            if (!isDisplayed(btnSkip)) {
                TestUtils.log().info("Twist&Go page is not displayed");
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Twist&Go page...");
        }
        return flag;
    }

    /**
     * checkVisibilityOfFavoriteReaderPage- This method is used to check visibility of the FavoriteReader page Date- 02/05/2023
     */
    public boolean checkVisibilityOfFavoriteReaderPage() {
        boolean flag = false;
        try {
                checkVisibilityOfConvenientPage();
                swipeLeft(1);
                swipeLeft(1);

            if (!isDisplayed(btnGetStarted)) {
                TestUtils.log().info("FavoriteReader page is not displayed");
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of FavoriteReader page...");
        }
        return flag;
    }

    /**
     * GetStartedPageFavoriteReaderPage- This method is used to close the FavoriteReader page Date- 26/04/2023
     **/

    public void GetStartedFavoriteReaderPage() {
        try {

            click(btnGetStarted);
           // click(btnAccept);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating description in FavoriteReader page...");
        }
        

    }
    /**
     * checkVisibilityOfFavoriteReaderPage- This method is used to check visibility of the FavoriteReader page Date- 02/05/2023
     */
    public boolean checkVisibilityOfBannersPage() {
        boolean flag = false;
        try {
            checkVisibilityOfConvenientPage();
            swipeLeft(1);
            swipeLeft(1);

            if (!isDisplayed(btnGetStarted)) {
                TestUtils.log().info("Banners page is not displayed");
                flag = true;
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Banners page...");
        }
        return flag;
    }

    /**
     * GetStartedPageFavoriteReaderPage- This method is used to close the FavoriteReader page Date- 26/04/2023
     **/

    public void GetStartedBannersPage() {
        try {

            click(btnGetStarted);
            // click(btnAccept);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating description in Banners page...");
        }


    }

    public void checkDescriptionTwistAndGoScreen(){

        try {

            if(twistAndGoDescTxt.equals(twistAndGoDesc.getText()))
            {
                Assert.assertTrue(true, "The description in  Twist&Go page is  correct...");
                TestUtils.log().debug(" The description in  Twist&Go page is  correct...");
            }
            else{
                Assert.assertTrue(false, "The description in  Twist&Go page is  incorrect...");
                TestUtils.log().debug(" The description in  Twist&Go page is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  Twist&Go page ...");
        }
    }

    public void checkDescriptionConvScreen(){

        try {

            if(convDescTxt.equals(convDesc.getText()))

            {
                Assert.assertTrue(true, "The description in  Convenient page is  correct...");
                TestUtils.log().debug(" The description in  Convenient page is  correct...");

            }
            else {
                Assert.assertTrue(false, "The description in  Convenient page is  incorrect...");
                TestUtils.log().debug(" The description in  Convenient page is  incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  Convenient page ...");
        }
    }

    public void checkDescriptionFavoriteReaderScreen(){

        try {

            if(favReaderDescTxt.equals(favReaderDesc.getText()))
            {
                Assert.assertTrue(true, "The description in  FavoriteReader Screen is correct...");
                TestUtils.log().debug(" The description in  FavoriteReader Screen is correct...");
            }
            else {

                Assert.assertTrue(false, "The description in  FavoriteReader Screen is incorrect...");
                TestUtils.log().debug(" The description in  FavoriteReader Screen is incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  FavoriteReader Screen ...");
        }
    }

    public void checkDescriptionBannersScreen(){

        try {

            if(bannersDescTxt.equals(bannerScreenDesc.getText()))
            {
                Assert.assertTrue(true, "The description in  Banners Screen is correct...");
                TestUtils.log().debug(" The description in  Banners Screen is correct...");

            }
            else {
                Assert.assertTrue(false, "The description in  Banners Screen is incorrect...");
                TestUtils.log().debug(" The description in  Banners Screen is incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  Banners Screen ...");
        }
    }

}
