package com.appium.HIDPages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Andr_HIDFavoriteReadersPage {

    /**
     * These mobile elements are used in  MobileID Screen to detect NearbyReaders  Date-08/05/2023
     */

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtManage")
    private MobileElement txtManage;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtNearByReader")
    private MobileElement txtNearByReader;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/errorText")
    private MobileElement bleAndLocationdisablederrorText;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/errorIcon")
    private MobileElement bleDisabledIcon;

    /**
     * These mobile elements are used in Manage FavoriteReaders Screen Date-08/05/2023
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtManageFavReaderHeading")
    private MobileElement txtManageFavReaderHeading;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtFavoriteReaderEmptyHeading")
    private MobileElement txtFavoriteReaderEmptyHeading;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEmptyFavReaderDesc")
    private MobileElement txtEmptyFavReaderDesc;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgEmptyFavHeart")
    private MobileElement imgEmptyFavHeart;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtOtherReaderEmptyHeading")
    private MobileElement txtOtherReaderEmptyHeading;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtEmptyOtherReaderDesc")
    private MobileElement txtEmptyOtherReaderDesc;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgEmptyTransaction")
    private MobileElement imgEmptyTransaction;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgBackBtn")
    private MobileElement imgBackBtn;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/errorText")
    private MobileElement errorTextNoReadersNearby;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/errorIcon")
    private MobileElement errorIconNoReadersNearby;

    /**
     * These mobile elements are used to validate Nearby Readers
     */
    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgLockUnlockStatus")
    private MobileElement imgLockUnlockStatus;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgHeart")
    private MobileElement imgHeart;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/imgFabReaderPhoto")
    private MobileElement imgFabReaderPhoto;

    @AndroidFindBy(id = "com.hidglobal.mobilekeys.android.v3:id/txtFavReaderName")
    private MobileElement txtFavReaderName;

    @AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Default Photo ID\"])[4]")
    private MobileElement lockStatus;


}
