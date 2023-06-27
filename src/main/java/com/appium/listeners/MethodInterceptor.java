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
 * @author- Nishant Rithe
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
