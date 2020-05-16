package com.automationpractice.driver;

import com.automationpractice.configuration.ConfigurationProvider;
import com.automationpractice.configuration.Properties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverProvider {

  private static final String ARGUMENTS_DELIMITER = " ";

  private DriverProvider() {}
  private static final Map<String, Function<List<String>, WebDriver>> browserMap = new HashMap<>();

  static {
    String chromeDriverUrl = ConfigurationProvider.getProperty(Properties.CHROME_DRIVER_URL);
    if (chromeDriverUrl != null) {
      System.setProperty(Properties.CHROME_DRIVER_URL, chromeDriverUrl);
    }

    setDriverUrl(Properties.CHROME_DRIVER_URL);
    setDriverUrl(Properties.GECKO_DRIVER_URL);

    browserMap.put("chrome", args -> new ChromeDriver(new ChromeOptions().addArguments(args)));
    browserMap.put("firefox", args -> new FirefoxDriver(new FirefoxOptions().addArguments(args)));
  }

  private static void setDriverUrl(String driverPropertyName) {
    String driverUrl = ConfigurationProvider.getProperty(driverPropertyName);
    if (driverUrl != null) {
      System.setProperty(driverPropertyName, driverUrl);
    }
  }

  private static List<String> getDriverOptions(String browserName) {
    String arguments = ConfigurationProvider
        .getProperty(String.format("webdriver.%s.arguments", browserName.toLowerCase()));
    if (arguments == null) {
      return new ArrayList<>();
    }

    return Arrays.asList(arguments.split(ARGUMENTS_DELIMITER));
  }

  /**
   * Returns instance of WebDriver
   *
   * @param browserName Name of the browser
   * @return Instance of WebDriver
   */
  public static WebDriver getDriver(String browserName) {
    if (browserName == null) {
      throw new RuntimeException("Browser name parameter is required.");
    }

    if (!browserMap.containsKey(browserName.toLowerCase())) {
      throw new RuntimeException(
          String.format("Unable to find ui.challenge.configuration for browser: %s", browserName));
    }

    return browserMap.get(browserName.toLowerCase()).apply(getDriverOptions(browserName));
  }
}
