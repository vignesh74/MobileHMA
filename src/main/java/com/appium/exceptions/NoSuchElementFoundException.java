package com.appium.exceptions;

import java.util.NoSuchElementException;

public class NoSuchElementFoundException extends NoSuchElementException
{
    public NoSuchElementFoundException(String reason)
    {
        super(reason);
    }
}
