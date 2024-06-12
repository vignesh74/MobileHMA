/**
 * ScreenshotUtils- This class contains method to get screenshot
 * Date-02/11/2022
 */

package com.appium.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.appium.manager.DriverManager;

public final class ScreenshotUtils {
		/**
	 	* ScreenshotUtils- default constructor
	 	* Date-02/11/2022
	 	*/
		private ScreenshotUtils() {
	}
		
		/**
		 * getBase64Image- This method returns the name of base 64 image
		 * Date-02/11/2022
		 */

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
