/**
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