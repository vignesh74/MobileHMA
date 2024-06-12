/**
 * UsernameUtils-This class is used to get user name
 * Date-28/11/2022
 */

package com.appium.utils;

public class UsernameUtils {

	/**
	 * UsernameUtils-This is default constructor
	 * Date-28/11/2022
	 */
	private UsernameUtils()
	{ }

	/**
	 * getUserName- This method is used to get user name
	 * @return-String
	 * Date-28/11/2022
	 */
	public static String getUserName()
	{
		return System.getProperty("user.name");
	}

}
