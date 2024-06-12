/**
 * OSInfoUtils-This class is used to get os information of working local system
 * Date-28/11/2022
 */
package com.appium.utils;

public final class OSInfoUtils {

	/**
	 * OSInfoUtils- Private constructor to avoid external instantiation
	 * Date- 28/11/2022
	 */
	private OSInfoUtils() {
	}

	/**
	 * getOSInfo- This method is used to get os info of working machine
	 * @return- String
	 * Date-28/11/2022
	 */
	public static String getOSInfo() {

		return System.getProperty("os.name").replace(" ", "_");

	}

}
