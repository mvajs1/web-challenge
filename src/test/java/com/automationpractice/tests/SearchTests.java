package com.automationpractice.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.automationpractice.configuration.ConfigurationProvider;
import com.automationpractice.configuration.Properties;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SearchResultsPage;
import com.automationpractice.tests.base.BaseTest;
import com.automationpractice.utilities.FileWriter;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

public class SearchTests extends BaseTest {

    private HomePage homePage;
    private FileWriter writer;

    @BeforeEach
    public void beforeEach() {
        homePage = new HomePage(getDriver());
        writer = new FileWriter();
        // Maximize browser and navigate to the Home Page
        getDriver().manage().window().maximize();
        getDriver().navigate().to(ConfigurationProvider.getProperty(Properties.BASE_URL));

        assertDoesNotThrow(homePage::waitForPageToOpen, "Home page did not open successfully.");
    }

    @Test
    @Execution(ExecutionMode.SAME_THREAD)
    @DisplayName("Output search results to file")
    public void outputSearchResultsToFileTest() {
        // Search for 'Printed dresses'
        SearchResultsPage searchResultsPage = homePage.search("Printed dresses");

        assertDoesNotThrow(searchResultsPage::waitForPageToOpen, "Search results page did not open successfully.");

        // Get search result titles in collection
        List<String> searchResults = searchResultsPage.getSearchResults()
                .stream().map(result -> result.getAttribute("title")).collect(Collectors.toList());

        // Output search results to file (file will be created in 'target' folder)
        writer.writeDataToFile(searchResults, String.format("search_results_%s.txt", System.currentTimeMillis()));
    }
}
