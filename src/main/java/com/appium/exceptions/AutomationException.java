/**
 * AutomationException- This class handles the automation exception of the its super class.
 * Date-24/11/2022
 */
package com.appium.exceptions;

public class AutomationException extends RuntimeException {

    private static final long serialVersionUID = -8710980695994382082L;

    /**
     * AutomationException-This is default overloading method for handling the exception
     * Date-24/11/2022
     */
    public AutomationException() {
        super("Automation Error");
    }

    /**
     * AutomationException- This is overloaded method with one parameter for handling the exception
     *
     * @param message-String Date-24/11/2022
     */
    public AutomationException(String message) {
        super("Automation Error: " + message);
    }

    /**
     * AutomationException- This is overloaded method with one parameter,throwable exception for handling the exception
     *
     * @param message-String
     * @param cause-Throwable Date-24/11/2022
     */
    public AutomationException(String message, Throwable cause) {
        super("Automation Error: " + message, cause);
    }
}