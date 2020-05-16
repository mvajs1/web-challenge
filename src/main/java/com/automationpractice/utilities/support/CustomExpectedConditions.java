package com.automationpractice.utilities.support;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public final class CustomExpectedConditions {

  private CustomExpectedConditions() { }

  public static ExpectedCondition<WebElement> proxyWebElementLocated(WebElement proxy) {
    return new ProxyWebElementLocated(proxy);
  }
}