package com.appium.exceptions;

import org.openqa.selenium.ElementClickInterceptedException;

public class ElementNotClickableException extends ElementClickInterceptedException
{
  public ElementNotClickableException(String reason)
  {
      super(reason);

  }

}
