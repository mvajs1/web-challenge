package com.automationpractice.utilities;

import com.automationpractice.configuration.ConfigurationProvider;
import com.automationpractice.configuration.Properties;
import com.automationpractice.utilities.support.CustomExpectedConditions;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class Wait {

  private static final long DEFAULT_WAIT_TIME  = 30000;
  private WebDriver driver;

  public Wait(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement waitUntilElementIsPresent(WebElement element, Duration timeout) {
    removeImplicitWait();
    try {
      org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(driver)
          .withTimeout(timeout)
          .pollingEvery(Duration.ofSeconds(1))
          .ignoring(ElementNotVisibleException.class)
          .ignoring(NoSuchElementException.class)
          .ignoring(WebDriverException.class);

      wait.until(CustomExpectedConditions.proxyWebElementLocated(element));
    } catch (NotFoundException | TimeoutException e) {
      setDefaultImplicitWait();
      throw e;
    }
    return element;
  }

  public WebElement waitUntilElementIsPresent(WebElement element) {
    String waitTime = ConfigurationProvider.getProperty(Properties.DEFAULT_WAIT);
    try {
      return waitUntilElementIsPresent(element, Duration.ofMillis(Long.parseLong(waitTime)));
    } catch (NumberFormatException e) {
      return waitUntilElementIsPresent(element, Duration.ofMillis(DEFAULT_WAIT_TIME));
    }
  }

  public void removeImplicitWait() {
    driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
  }

  public void setDefaultImplicitWait() {
    String implicitWait = ConfigurationProvider.getProperty(Properties.DEFAULT_IMPLICIT_WAIT);
    try {
      driver.manage().timeouts()
          .implicitlyWait(Long.parseLong(implicitWait), TimeUnit.SECONDS);
    } catch(NumberFormatException e) {
      driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.MILLISECONDS);
    }
  }
}
