/**
 * @author - Brijesh Mishra
 * ApplicationInfoUtils-This class contains the utility of the application information
 * Date-28/11/2022
 */

package com.appium.utils;

import com.appium.constants.FrameworkConstants;
import com.appium.manager.DriverManager;

import io.github.martinschneider.justtestlah.mobile.tools.ApplicationInfo;
import io.github.martinschneider.justtestlah.mobile.tools.ApplicationInfoService;

public class ApplicationInfoUtils {

	/**
	 * getVersionName- This method is used to get application version name
	 * @return- String
	 * Date-28/11/2022
	 */
	public static String getVersionName() {
		String versionName = null;
		try {
			if (DriverManager.getPlatform().equalsIgnoreCase(FrameworkConstants.PLATFORM_ANDROID)) {
				ApplicationInfo appInfo = new ApplicationInfoService()
						.getAppInfo(FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getAndroidApplocation());
				versionName = appInfo.getVersionName();
			} else {
				ApplicationInfo appInfo = new ApplicationInfoService()
						.getAppInfo(FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());
				versionName = appInfo.getVersionName();
			}
			TestUtils.log().info("Application version name :: {}",versionName);
		}catch (Exception e){
			TestUtils.log().debug("Exception Occurred while getting version name...");
		}
		return versionName;
	}

	/**
	 * getVersionCode- This method is used to get application version code
	 * @return- String
	 * Date-28/11/2022
	 */
	public static String getVersionCode() {
		String versionCode = null;
		try {
			if (DriverManager.getPlatform().equalsIgnoreCase(FrameworkConstants.PLATFORM_ANDROID)) {
				ApplicationInfo appInfo = new ApplicationInfoService()
						.getAppInfo(FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getAndroidApplocation());
				versionCode = appInfo.getVersionCode();
			} else {
				ApplicationInfo appInfo = new ApplicationInfoService()
						.getAppInfo(FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());
				versionCode = appInfo.getVersionCode();
			}
			TestUtils.log().info("Application version :: {}",versionCode);
		}catch (Exception e){
			TestUtils.log().debug("Exception Occurred while getting version code...");
		}
		return versionCode;
	}

	/**
	 * getApplicationName- This method is used to get application name
	 * @return- String
	 * Date-28/11/2022
	 */
	public static String getApplicationName() {
		String appName = null;
		try {
			if (DriverManager.getPlatform().equalsIgnoreCase(FrameworkConstants.PLATFORM_ANDROID)) {
				ApplicationInfo appInfo = new ApplicationInfoService()
						.getAppInfo(FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getAndroidApplocation());
				appName = appInfo.getApplicationName();
			} else {
				ApplicationInfo appInfo = new ApplicationInfoService()
						.getAppInfo(FrameworkConstants.RESOURCES_TEST_PATH + ConfigLoader.getInstance().getiOSAppLocation());
				appName = appInfo.getApplicationName();
			}
			TestUtils.log().info("Application name :: {}",appName);
		}catch (Exception e){
			TestUtils.log().debug("Exception Occurred while getting application name...");
		}
		return appName;
	}

}
