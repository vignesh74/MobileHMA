/**
 * PlatformNotSupportedException-This class contains the platform not supported exception
 * Date-24/11/2022
 */

package com.appium.exceptions;

public class PlatformNotSupportedException extends IllegalStateException {

	private static final long serialVersionUID = 949289258622486413L;

	/**
	 * PlatformNotSupportedException- This constructor used to send platform not supported exception message
	 * @param reason-String
	 * Date-24/11/2022
	 */
	public PlatformNotSupportedException(String reason) {
		super(reason);
	}
}


