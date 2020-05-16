package com.automationpractice.pages;

import com.automationpractice.pages.base.BasePage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
  }

  //region General
  @FindBy(how = How.XPATH, using = "//h1[text()='Automation Practice Website']")
  private WebElement titleLabel;

  @FindBy(how = How.ID, using = "search_query_top")
  private WebElement searchInput;

  public void waitForPageToOpen() {
    wait.waitUntilElementIsPresent(titleLabel);
  }

  public SearchResultsPage search(String text) {
    searchInput.sendKeys(text);
    searchInput.sendKeys(Keys.ENTER);
    return new SearchResultsPage(driver);
  }
  //endregion

  //region NavigationBar
  @FindBy(how = How.CSS, using = "a.login")
  public WebElement signInButton;

  public AuthenticationPage clickOnSignInButton() {
    wait.waitUntilElementIsPresent(signInButton).click();
    return new AuthenticationPage(driver);
  }
  //endregion

  //region ProductCategories
  @FindBy(how = How.CSS, using = "a[href='#homefeatured']")
  private WebElement popularCategoryTab;
  @FindBy(how = How.CSS, using = "a[href='#blockbestsellers']")
  private WebElement bestSellerCategoryTab;
  @FindBy(how = How.CSS, using = "ul#homefeatured a.product_img_link")
  private List<WebElement> products;

  public void clickOnPopularCategoryTab() {
    popularCategoryTab.click();
  }

  public void clickOnBestSellerCategoryTab() {
    bestSellerCategoryTab.click();
  }

  public List<WebElement> getProducts() {
    return products;
  }
  //endregion
}
