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
 * @author-Brijesh Mishra
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
