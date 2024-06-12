/**
 * MethodInterceptor - This listener helps to alter the methods that TestNG is supposed to run. 
 * It gets invoked just before TestNG invokes the methods.
 * Date-03/11/2022
 */

package com.appium.listeners;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.appium.utils.TestUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class MethodInterceptor implements IMethodInterceptor {

	/**
	 *intercept- returns an altered list of methods
	 *@param- methods-List<IMethodInstance>
	 *@param- context- ITestContext
	 *@return-List
	 *Date-03/11/2022
	 */
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		TestUtils.log().info("----------------METHOD INTERCEPTOR--------------------------");
		TestUtils.log().info("methods: {} ",methods);

		List<IMethodInstance> result = new ArrayList<IMethodInstance>();

		String testCategory = System.getProperty("testCategory");
		TestUtils.log().info("testCategory: {} ",testCategory);
		for (IMethodInstance method : methods) {
			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
			Set<String> groups = new HashSet<String>();
			for (String group : testMethod.groups()) {
				groups.add(group);
			}

			if (groups.contains(testCategory)) {
				result.add(method);
			}
		}
		if (testCategory == null) {
			TestUtils.log().info("Either You are not running the test execution from Maven"
					+ " command line or you are not giving the property -D=testCategory");
			return methods;
		} else {
			return result;
		}

	}
}
