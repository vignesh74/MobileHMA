/**
 * AnnotationFramework- This Interface provides custom annotation for author and category of the test cases
 * Date-24/11/2022
 **/

package com.appium.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnnotationFramework {

	/**
	 * author- This returns the author name
	 * @return-AuthorType
	 * Date-24/11/2022
	 */
	public AuthorType[] author();

	/**
	 * category- This returns the test category
	 * @return-CategoryType
	 * Date-24/11/2022
	 */
	public CategoryType[] category();



}