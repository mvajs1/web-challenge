package com.automationpractice.pages;

import com.automationpractice.pages.base.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) { super(driver); }

    //region General
    @FindBy(how = How.XPATH, using = "//h1[contains(text(), 'Search')]")
    private WebElement titleLabel;

    public void waitForPageToOpen() {
        wait.waitUntilElementIsPresent(titleLabel);
    }

    //region SearchResults
    @FindBy(how = How.CSS, using = "div#center_column ul a.product_img_link")
    private List<WebElement> searchResults;

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
    //endregion
}
