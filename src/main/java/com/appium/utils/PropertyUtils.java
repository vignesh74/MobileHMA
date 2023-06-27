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

 * @author Nishant Rithe
 * PropertyUtils- This class contains the method to load property file
 * Date-02/11/2022
 */

package com.appium.utils;

import com.appium.exceptions.AutomationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	private PropertyUtils()
	{

	}

	/**
	 * propertyLoader-This method loads the property file 
	 * @param filePath
	 * @return- Properties
	 * Date-02/11/2022
	 */
	public static Properties propertyLoader(String filePath) {
		Properties properties = new Properties();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e1) {
			
			throw new AutomationException("Properties file not found at: " + filePath);
		}
		try {
			properties.load(reader);
			reader.close();
		} catch (IOException e) {
			
			throw new AutomationException("Failed to load the Properties file: " + filePath);
		}
		return properties;
	}

}