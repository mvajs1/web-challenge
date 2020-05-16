package com.automationpractice.tests.base;

import com.automationpractice.configuration.ConfigurationProvider;
import com.automationpractice.configuration.Properties;
import com.automationpractice.driver.DriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

  private final ThreadLocal<WebDriver> driver;

  protected BaseTest() {
    driver = new ThreadLocal<>();
  }

  protected WebDriver getDriver() {
    if (driver.get() == null) {
      driver.set(DriverProvider
          .getDriver(ConfigurationProvider.getProperty(Properties.TARGET_BROWSER)));
    }

    return driver.get();
  }

  @AfterEach
  protected void afterEach() {
    driver.get().quit();
    driver.remove();
  }
}
