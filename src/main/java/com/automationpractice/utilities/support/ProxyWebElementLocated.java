package com.automationpractice.utilities.support;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class ProxyWebElementLocated implements ExpectedCondition<WebElement> {

  private WebElement proxy;

  public ProxyWebElementLocated(WebElement proxy) {
    this.proxy = proxy;
  }

  @Override
  public WebElement apply(WebDriver d) {
    try {
      proxy.getTagName();
    } catch (NoSuchElementException e) {
      return null;
    }
    return proxy;
  }
}
