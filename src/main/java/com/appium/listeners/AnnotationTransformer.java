/**
 * Author-Rohit Deokar
 * AnnotationTransformer- This class defined for the customize annotations
 * Date-03/11/2022
 */

package com.appium.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer
{
	/**
	 * transform-This method used for the re-execution of failed tests
	 * Date-03/11/2022
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		/**
		 * I don't need to add these details with Test case
		 *
		 * @Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
		 */
		annotation.setRetryAnalyzer(RetryFailedTests.class);


	}
}
