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
 * @author- Vijyeta Gohil
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
