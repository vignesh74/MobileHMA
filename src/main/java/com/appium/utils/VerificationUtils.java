/**
 * VerificationUtils-This class is used to validate actual and expected response and log the file
 * Date-28/11/2022
 */
package com.appium.utils;

import org.testng.Assert;


public class VerificationUtils {

	private VerificationUtils(){}

	/**
	 * validate- This method is used to validate the actual and expected response and print the message
	 * @param actual- Object
	 * @param expected- Object
	 * @param message- String
	 * Date-28/11/2022
	 */

	public static void validate(Object actual, Object expected, String message) {

		try {
			logFile(actual, expected);
			Assert.assertEquals(actual, expected, message);
			TestUtils.log().info("Actual :: {} and Expected :: {}",actual,expected);

		} catch (AssertionError assertionError) {
			TestUtils.log().info("Actual :: {} and Expected :: {}",actual,expected);
			Assert.fail(message);
		}
	}
	/**
	 * logFile- This method is used to add log for actual and expected result
	 * @param actual- Object
	 * @param expected- Object
	 * Date-28/11/22
	 */
	private static void logFile(Object actual, Object expected) {
		TestUtils.log().info("Actual :: {}",actual);
		TestUtils.log().info("Expected :: {}",expected);
	}

	/**
	 * validateResponse-This method contain the validate the response of the result and print message
	 * @param result-boolean
	 * @param message-String
	 * Date-28/11/2022
	 */
	public static void validateResponse(boolean result, String message) {
		try {
			Assert.assertTrue(result);
			TestUtils.log().info(message);
		} catch (AssertionError assertionError) {
			TestUtils.log().info(message);
			Assert.fail(message);
		}
	}

}
