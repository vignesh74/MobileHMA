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
 * @author -Rohit Deokar
 * AppiumServerUtils-This class contains the utilities of appium server
 * Date-02/11/2022 
 */

package com.appium.utils;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

import static com.appium.constants.FrameworkConstants.PLATFORM_OS_WIN;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_WIN_NODE_INSTALLATION_PATH;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_WIN_APPIUM_INSTALLATION_PATH;
import static com.appium.constants.FrameworkConstants.APPIUM_SERVER_LOGS;
import static com.appium.constants.FrameworkConstants.PATH;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_MAC_VAR_ANDROID_HOME_VALUE;
import static com.appium.constants.FrameworkConstants.ANDROID_HOME;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_MAC_VAR_PATH_VALUE;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_MAC_NODE_INSTALLATION_PATH;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_MAC_APPIUM_INSTALLATION_PATH;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_NUX;
import static com.appium.constants.FrameworkConstants.PLATFORM_OS_MAC;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServerUtils {

	/**
	 * getAppiumServerDefault- This method gets default appium server
	 * @return-AppiumDriverLocalService
	 * Date-02/11/2022 
	 */
	public static AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}

	/**
	 * getAppiumService- This method sets the os info for platform window or Mac from ConfigLoader class
	 * This method gets the appium driver service
	 * @return-AppiumDriverLocalService
	 * Date-02/11/2022 
	 */
	public static AppiumDriverLocalService getAppiumService() {
		String os = OSInfoUtils.getOSInfo().toLowerCase();

		if (os.contains(PLATFORM_OS_WIN)) {
			return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(PLATFORM_OS_WIN_NODE_INSTALLATION_PATH))
					.withAppiumJS(new File(PLATFORM_OS_WIN_APPIUM_INSTALLATION_PATH)).withIPAddress("127.0.0.1").usingPort(4723)
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
					.withLogFile(new File(APPIUM_SERVER_LOGS)));
			

		} else if (os.contains(PLATFORM_OS_MAC)) {
		
			HashMap<String, String> environment = new HashMap<String, String>();
			environment.put(PATH,PLATFORM_OS_MAC_VAR_PATH_VALUE + System.getenv(PATH));
			environment.put(ANDROID_HOME, PLATFORM_OS_MAC_VAR_ANDROID_HOME_VALUE);

			return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File(PLATFORM_OS_MAC_NODE_INSTALLATION_PATH))
					.withAppiumJS(new File(PLATFORM_OS_MAC_APPIUM_INSTALLATION_PATH)).withIPAddress("127.0.0.1").usingPort(4723)
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE).withEnvironment(environment)
					.withLogFile(new File(APPIUM_SERVER_LOGS)));
			
		} else if (os.contains(PLATFORM_OS_NUX)) {
				TestUtils.log().info("You have selected Platform other than Windows and MAC");
		}
		return null;
	}
	
	/**
	 * checkIfAppiumServerIsRunnning-This method checks the appium server is running or not
	 * @param port- int
	 * @return-boolean
	 * @throws Exception
	 * Date-02/11/2022 
	 */
	public static boolean checkIfAppiumServerIsRunnning(int port) throws NullPointerException, IOException {
		boolean isAppiumServerRunning = false;
		ServerSocket socket = null;
		try {
			socket = new ServerSocket(port);
		} catch (IOException e) {
			isAppiumServerRunning = true;
		} finally {
			assert socket != null;
			socket.close();
		}
		return isAppiumServerRunning;
	}

}