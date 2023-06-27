package com.appium.exceptions;

import org.openqa.selenium.TimeoutException;

public class TimeOutException extends TimeoutException
{
    public TimeOutException(String reason){super(reason);}
}
