/**
 # MIT License
 #
 # Organization   eInfochips
 # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED.
 #
 # Permission is hereby granted, free of charge, to any person obtaining a copy
 # of this software and associated documentation files (the "Software"), to deal
 # in the Software without restriction, including without limitation the rights
 # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 # copies of the Software, and to permit persons to whom the Software is
 # furnished to do so, subject to the following conditions:
 #
 # The above copyright notice and this permission notice shall be included in all
 # copies or substantial portions of the Software.
 #
 # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 # LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 # SOFTWARE.
 #
 #              EINFOCHIPS
 #             2025 Gateway Place, Suite #238,
 #              San Jose, CA 95110
 #------------------------------------------------------------------------------------
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
