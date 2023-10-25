package com.appium.HIDPages.android;

import com.appium.base.BasePage;
import com.appium.utils.TestUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import static com.appium.constants.MessageConstants.*;

public class Andr_HIDOnboardingScreenPage extends BasePage {

    /**
     * mobile elements - These are mobile elements which is present in OnboardingScreen page Date-02/05/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtSkip")
    private MobileElement btnSkip;
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/btnAccept")
    private MobileElement btnAccept;
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Skip']")
    private MobileElement skipBtn;

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

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Get Started']")
    private MobileElement GetStartedBtn;

    /**
     * These are the mobile elements required to validate the descriptions in the Onboarding Screens Date-03/05/2023
     **/

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtConvenientDesc")
    private MobileElement convDesc;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtTwistAndGoDescription")
    private MobileElement twistAndGoDesc;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Select the reader(s) you want to tag as favorite. When nearby, favorite readers are targeted for door opening.']")
    private MobileElement favReaderDesc;





/** THE COMMENTED OUT METHODS BELONGS TO AN OLDER VERSION OF APP **/


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

                click(skipBtn);
            }

        catch(Exception e){

            TestUtils.log().debug("Exception occurred while skipping/validating text in convenient page...");
        }
    }
    public void skipConvenientPageOnboardingScreen(String button) {
        try {
            if (!SKIP.equalsIgnoreCase(button)) {
                Assert.assertTrue(false, "The SKIP link in Convenient page is not displayed...");
                TestUtils.log().info("The SKIP link in Convenient page is not displayed");
            }
            else
            {
                click(skipBtn);
            }
        }
         catch(Exception e){

                TestUtils.log().debug("Exception occurred while skipping/validating text in convenient page...");
            }
        }


    /**
     * skipTwistAndGoPage- This method is used to skip the TwistAndGo page Date- 26/04/2023
     **/

    public void skipTwistAndGoPage(String button) {
        try {
            swipeLeft(1);
            if(button.equalsIgnoreCase(skipBtn.getText())){
                if(isDisplayed(favReaderDesc)){
                    Assert.assertTrue(true, "The SKIP link in Twist&Go page is working...");
                    TestUtils.log().info("The SKIP link in Twist&Go is working");
                }else {
                    TestUtils.log().info("The SKIP link in Twist&Go is not working");
                }
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating text in Twist&Go page...");
        }

    }


    /**
     * checkVisibilityOfConvenientPage- This method is used to check visibility of the convenient page Date- 25/01/2023
     *
     * @return
     */
    public boolean checkVisibilityOfConvenientPage() {

        try {

            if (isDisplayed(convDesc)) {
                Assert.assertTrue(true, "The Convenient page is  displayed...");
                TestUtils.log().info("Convenient page is  displayed");
            }else{
                TestUtils.log().info("Convenient page is not displayed");
            }

        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while checking visibility of convenient page...");
        }


        return false;
    }

    /**
     * checkVisibilityOfTwistAndGoPage- This method is used to check visibility of the TwistAndGo page Date- 02/05/2023
     */
    public void checkVisibilityOfTwistAndGoPage() {

        try {
                checkVisibilityOfConvenientPage();
                swipeLeft(1);
            if (isDisplayed(twistAndGoDesc)) {
                Assert.assertTrue(true, "Twist&Go page is displayed...");
                TestUtils.log().info("Twist&Go page is displayed");
            }else{
                TestUtils.log().info("Twist&Go page is not displayed");
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Twist&Go page...");
        }

    }

    /**
     * checkVisibilityOfFavoriteReaderPage- This method is used to check visibility of the FavoriteReader page Date- 02/05/2023
     */

    public void checkVisibilityOfFavoriteReaderPage() {

        try {
                swipeLeft(1);

            if (isDisplayed(GetStartedBtn)) {
                TestUtils.log().info("FavoriteReader page is displayed");
            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of FavoriteReader page...");
        }
    }

    /**
     * GetStartedPageFavoriteReaderPage- This method is used to close the FavoriteReader page Date- 26/04/2023
     **/

    public void GetStartedFavoriteReaderPage() {
        try {

            click(GetStartedBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating description in FavoriteReader page...");
        }
        

    }
    /**
     * checkVisibilityOfFavoriteReaderPage- This method is used to check visibility of the FavoriteReader page Date- 02/05/2023
     */
    public void checkVisibilityOfBannersPage() {

        try {
            checkVisibilityOfConvenientPage();
            swipeLeft(1);
            swipeLeft(1);

            if (!isDisplayed(GetStartedBtn)) {
                Assert.assertTrue(true, "Favorite Reader Page is not displayed...");
                TestUtils.log().info("Favorite Reader page is not displayed");

            }
        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while checking visibility of Banners page...");
        }

    }

    /**
     * GetStartedPageFavoriteReaderPage- This method is used to close the FavoriteReader page Date- 26/04/2023
     **/

    public void GetStartedBannersPage(String button) {
        try {
            if (!GET_STARTED.equalsIgnoreCase(button)) {
                Assert.assertTrue(false, "The Get Started link in Favorite Reader screen is not displayed...");
                TestUtils.log().info("The Get Started link in Favorite Reader screen is not displayed...");
            }
            else
            click(GetStartedBtn);

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while skipping/validating description in Favorite Reader screen...");
        }


    }

    public void checkDescriptionTwistAndGoScreen(){

        try {

            if(TWIST_AND_GO_DESCRIPTION_TXT.equals(twistAndGoDesc.getText()))
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

            if(CONVENIENT_DESCRIPTION_TXT.equals(convDesc.getText()))

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

            if(FAVORITE_READER_DESCRIPTION_TXT.equals(favReaderDesc.getText()))
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

            if(BANNERS_DESCRIPTION_TXT.equals(bannerScreenDesc.getText()))
            {
                Assert.assertTrue(true, "The description in  Favorite Reader screen is correct...");
                TestUtils.log().debug(" The description in  Banners Screen is correct...");

            }
            else {
                Assert.assertTrue(false, "The description in  Favorite Reader is incorrect...");
                TestUtils.log().debug(" The description in  Banners Screen is incorrect...");
            }

        } catch (Exception e) {

            TestUtils.log().debug("Exception occurred while validating the description in  Favorite Reader Screen ...");
        }
    }

}
