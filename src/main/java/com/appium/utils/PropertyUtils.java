/**
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