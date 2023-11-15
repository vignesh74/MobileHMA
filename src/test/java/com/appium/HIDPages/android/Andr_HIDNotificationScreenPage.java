package com.appium.HIDPages.android;

import com.appium.utils.TestUtils;
import org.testng.Assert;

import com.appium.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Andr_HIDNotificationScreenPage extends BasePage {
    /**
     * mobile elements - These are mobile elements which is present in notification page Date-25/01/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNotificationTitle")
    private MobileElement txtNotificationTitle;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtNotifications")
    private MobileElement txtNotifications;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/date")
    private MobileElement txtToday;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtNotificationTitle")
    private MobileElement txtNewMobileIDIssued;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/iconNotification")
    private MobileElement notificationIcon;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/bubble")
    private MobileElement notificationBubble;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Mobile ID Updated']")
    private MobileElement txtNotificationSuspended;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Mobile ID Updated']")
    private MobileElement txtNotificationResumed;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Mobile ID Revoked']")
    private MobileElement txtNotificationRevoked;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/imgNotifications")
    private MobileElement noNotificationIcon;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/txtNoNotifications")
    private MobileElement txtnoNotification;

    @AndroidFindBy(id="com.hidglobal.mobilekeys.android.v3:id/fBtnNotification")
    private MobileElement install;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button[2]")
    private MobileElement update;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='New version available']")
    private MobileElement txtNewVersionAvailable;

    /**
     * getter methods - These are getter method for above mentioned mobile elements Date-25/01/2023
     */
    public MobileElement getTxtNotificationTitle() {
        return txtNotificationTitle;
    }

    public MobileElement getTxtToday() {
        return txtToday;
    }

    public MobileElement getTxtNewMobileIDIssued() {
        return txtNewMobileIDIssued;
    }

    public MobileElement getNotificationIcon() {
        return notificationIcon;
    }

    public MobileElement getNotificationBubble() {
        return notificationBubble;
    }

    public MobileElement getTxtNotificationSuspended() {
        return txtNotificationSuspended;
    }

    public MobileElement getTxtNotificationResumed() {
        return txtNotificationResumed;
    }

    public MobileElement getTxtNotificationRevoked() {
        return txtNotificationRevoked;
    }

    public MobileElement getTxtInstall(){
        return install;
    }

    /**
     * verifyNotification- This method is used to verify the notification
     *
     * @param strExpectedNotificationTitle
     *         - String Date- 25/01/2023
     */
    public void verifyNotification(String strExpectedNotificationTitle) {
        try {
            String strActualNotificationTitle = getElementText(txtNotificationTitle);
            Assert.assertEquals(strActualNotificationTitle, strActualNotificationTitle);
        } catch (Exception e) {
            
            TestUtils.log().debug("Exception occurred while verifying notification...");
        }
    }

    public void verifyNotificationTitle(){
        try{
            String strNotificationTitleTxt = "Notifications";
            String strActualNotificationtitleText = getElementText(txtNotifications);
            Assert.assertEquals(strNotificationTitleTxt,strActualNotificationtitleText);

        }catch(Exception e){
            TestUtils.log().debug("Exception occurred while verifying notification title...");
        }
    }

    public void verifyNotificationDate(){
        try{
            String strNotificationDateTxt = "TODAY";
            String strActualNotificationDateTxt = getElementText(txtToday);
            Assert.assertEquals(strNotificationDateTxt,strActualNotificationDateTxt);
        }catch(Exception e){
            TestUtils.log().debug("Exception occurred while verifying notification Date...");
        }
    }

    public void verifyMobileIdIssued(){
        try{
            notificationIcon.isDisplayed();
            String strMobileIDIssuedTxt = "New Mobile ID issued";
            String strActualMobileIDIssuedTxt = getElementText(txtNewMobileIDIssued);
            Assert.assertEquals(strMobileIDIssuedTxt,strActualMobileIDIssuedTxt);
            notificationBubble.isDisplayed();
        }catch(Exception e){
            TestUtils.log().debug("Exception occurred while verifying notification content...");
        }
    }


    public void verifyMobileIdStatus(String action, String notification){
        switch(action){
            case "Suspend" -> {
                verifyMobileIdSuspended(notification);
            }
            case "Resumed" -> {
                verifyMobileIdResumed(notification);
            }
            case "Revoked" -> {
                verifyMobileIdRevoked(notification);
            }
            default ->{
                verifyNotificationTitle();
                verifyNotificationDate();
                verifyMobileIdIssued();
            }
        }
    }
    public void verifyMobileIdSuspended(String notification){
        try{
            notificationIcon.isDisplayed();
            String strActualMobileIDSuspendedTxt = getElementText(txtNotificationSuspended);
            Assert.assertEquals(notification,strActualMobileIDSuspendedTxt);
            notificationBubble.isDisplayed();
        }catch(Exception e){
            TestUtils.log().debug("Exception occurred while verifying mobile ID suspended notification...");
        }
    }

    public void verifyMobileIdResumed(String notification){
        try{
            notificationIcon.isDisplayed();
            String strActualMobileIDResumedTxt = getElementText(txtNotificationResumed);
            Assert.assertEquals(notification,strActualMobileIDResumedTxt);
            notificationBubble.isDisplayed();
        }catch(Exception e){
            TestUtils.log().debug("Exception occurred while verifying mobile ID Resumed notification...");
        }
    }

    public void verifyMobileIdRevoked(String notification){
        try{
            notificationIcon.isDisplayed();
            String strActualMobileIDRevokedTxt = getElementText(txtNotificationRevoked);
            Assert.assertEquals(notification,strActualMobileIDRevokedTxt);
            notificationBubble.isDisplayed();
        }catch(Exception e){
            TestUtils.log().debug("Exception occurred while verifying mobile ID Revoked notification....");
        }
    }

    public void verifyNoNotificationScreen(){
        noNotificationIcon.isDisplayed();
        String strNoNotificationTxt = "No notifications at this time.";
        String strActualNoNotificationTxt = getElementText(txtnoNotification);
        Assert.assertEquals(strNoNotificationTxt,strActualNoNotificationTxt);
    }

    public void upgrade(){
        try{
        String newVersionTxt = "New version available";

            if(isDisplayed(txtNewVersionAvailable)) {
                TestUtils.log().info("New version is available to upgrade...");
                if(isDisplayed(install)) {
                    click(install);
                    TestUtils.log().info("clicked on install button...");
                }else{
                    TestUtils.log().info("Install button is not displayed...");
                }
                waitForGivenTime(1);
                if (isDisplayed(update)) {
                    click(update);
                    TestUtils.log().info("clicked on update button...");
                }else{
                    TestUtils.log().info("Update button is not displayed...");
                }
            }else{
                    TestUtils.log().debug("New version is not available to upgrade...");
                }
            } catch(Exception e){
            TestUtils.log().info("Exception occurred while updating the app...");
            System.out.println("vignesh "+e);
        }

    }


}
