package com.automationpractice.pages;

import com.automationpractice.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthenticationPage extends BasePage {

  public AuthenticationPage(WebDriver driver) {
    super(driver);
  }

  //region General
  @FindBy(how = How.XPATH, using = "//h1[text()='Authentication']")
  private WebElement titleLabel;

  public void waitForPageToOpen() {
    wait.waitUntilElementIsPresent(titleLabel);
  }
  //endregion

  //region CreateAccount
  @FindBy(how = How.ID, using = "email_create")
  private WebElement registerEmailInput;

  @FindBy(how = How.ID, using = "SubmitCreate")
  private WebElement createAccountButton;

  public void enterEmail(String text) {
    registerEmailInput.sendKeys(text);
  }

  public CreateAccountPage clickOnCreateAccountButton() {
    createAccountButton.click();
    return new CreateAccountPage(driver);
  }
  //endregion
}
