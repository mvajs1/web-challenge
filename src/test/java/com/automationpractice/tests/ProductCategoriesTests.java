package com.automationpractice.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.automationpractice.configuration.ConfigurationProvider;
import com.automationpractice.configuration.Properties;
import com.automationpractice.pages.HomePage;
import com.automationpractice.tests.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class ProductCategoriesTests extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    public void beforeEach() {
        homePage = new HomePage(getDriver());
        // Maximize browser and navigate to the Home Page
        getDriver().manage().window().maximize();
        getDriver().navigate().to(ConfigurationProvider.getProperty(Properties.BASE_URL));

        assertDoesNotThrow(homePage::waitForPageToOpen, "Home page did not open successfully.");
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("Verify that 'Popular' category has 7 products")
    public void verifyPopularCategoryHas7ProductsTest() {
        homePage.clickOnPopularCategoryTab();
        assertEquals(7, homePage.getProducts().size(), "Category 'Popular' does not contain 7 products.");
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("Verify that 'Best Sellers' category has 7 products")
    public void verifyBestSellersCategoryHas7ProductsTest() {
        homePage.clickOnBestSellerCategoryTab();
        assertEquals(7, homePage.getProducts().size(), "Category 'Best Sellers' does not contain 7 products.");
    }
}
