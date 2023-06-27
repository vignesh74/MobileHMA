package com.appium.exceptions;

import org.openqa.selenium.WebDriverException;

public class StaleElementReferenceException extends WebDriverException
{
    /**
     * StaleElementReferenceException- This constructor used to send platform not supported exception message
     * @param reason-String
     * Date-24/11/2022
     */
    public StaleElementReferenceException(String reason) {
        super(reason);
    }
}
