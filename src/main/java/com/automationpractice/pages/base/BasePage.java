package com.automationpractice.pages.base;

import com.automationpractice.utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

  protected WebDriver driver;
  protected Wait wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new Wait(driver);

    PageFactory.initElements(driver, this);
  }
}
