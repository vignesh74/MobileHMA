/**
 * IDriver- This interface used to contains method to get appium url
 * Date-04/11/2022 
 */
package com.appium.manager;

import com.appium.utils.ConfigLoader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface IDriver {


	/**
	 * createInstance- This method creates the device instance.
	 * @param udid- String
	 * @param platformVersion- String
	 * @param deviceName- String
	 * @param installApp- boolean
	 * @param emulator- Boolean
	 * @param systemPort- String
	 * @return- AppiumDriver
	 * Date-04/11/2022 
	 */
	AppiumDriver<MobileElement> createInstance(String udid, String platformVersion, String deviceName, boolean installApp, boolean emulator, int systemPort);
	/**
	 * appiumUrl- This method return the appium url
	 * @return - String
	 * Date-04/11/2022
	 */

	default String appiumUrl() {
		return ConfigLoader.getInstance().getAppiumURL();
	}
}
