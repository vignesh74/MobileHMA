/**
 * # MIT License # # Organization   eInfochips # Copyright      COPYRIGHT 2022 EINFOCHIPS ALL RIGHTS RESERVED. # # Permission is hereby granted, free of charge, to any person obtaining a copy # of this software and associated documentation files (the "Software"), to deal # in the Software without restriction, including without limitation the rights # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell # copies of the Software, and to permit persons to whom the Software is # furnished to do so, subject to the following conditions: # # The above copyright notice and this permission notice shall be included in all # copies or substantial portions of the Software. # # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER #
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE # SOFTWARE. # #              EINFOCHIPS #             2025 Gateway Place, Suite #238, #              San Jose, CA 95110 #------------------------------------------------------------------------------------
 *
 * @author- Brijesh Mishra DeepLink-This class check the URL is deep link or not Date-28/11/2022
 */
package com.appium.utils;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.appium.constants.FrameworkConstants.PLATFORM_IOS;
import static com.appium.constants.FrameworkConstants.PLATFORM_ANDROID;

import com.appium.manager.DriverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class DeepLink {

	DeepLink()
	{
		//added default constructor
	}
	/**
	 * OpenAppWith- This method open the deep link for plaform android/IOS
	 * @param url-String
	 * Date-28/11/2022
	 */
	public static void openAppWith(String url) {
		AppiumDriver<?> driver = DriverManager.getDriver();
		String platform = DriverManager.getPlatform();
		try {
			if (platform.equalsIgnoreCase(PLATFORM_ANDROID)) {
				HashMap<String, String> deepUrl = new HashMap<String, String>();
				deepUrl.put("url", url);
				deepUrl.put("package", "com.swaglabsmobileapp");
				driver.executeScript("mobile: deepLink", deepUrl);


            } else if (platform.equalsIgnoreCase(PLATFORM_IOS)) {
                By urlBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'URL'");
                By urlFld = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeTextField' && name CONTAINS 'URL'");
                By openBtn = MobileBy.iOSNsPredicateString("type == 'XCUIElementTypeButton' && name CONTAINS 'Open'");
                driver.activateApp("com.apple.mobilesafari");
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlBtn)).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(urlFld)).sendKeys("" + url + "\uE007");
                wait.until(ExpectedConditions.visibilityOfElementLocated(openBtn)).click();
            }
        } catch (Exception e) {
            TestUtils.log().debug("Exception occurred");
        }
    }
}
