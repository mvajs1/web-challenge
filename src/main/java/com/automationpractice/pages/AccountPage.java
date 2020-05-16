package com.automationpractice.pages;

import com.automationpractice.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) { super(driver); }

    //region General
    @FindBy(how = How.XPATH, using = "//h1[text()='My account']")
    private WebElement titleLabel;

    public void waitForPageToOpen() {
        wait.waitUntilElementIsPresent(titleLabel);
    }
    //

    //region NavigationBar
    @FindBy(how = How.CSS, using = "a.logout")
    private WebElement signOutButton;

    public HomePage signOut() {
        signOutButton.click();
        return new HomePage(driver);
    }

    public Boolean getSignOutButtonVisibility() {
        return signOutButton.isDisplayed();
    }
    //endregion
}
