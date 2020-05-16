package com.automationpractice.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.automationpractice.configuration.ConfigurationProvider;
import com.automationpractice.configuration.Properties;
import com.automationpractice.data.DataProvider;
import com.automationpractice.data.models.RegisterAccount;
import com.automationpractice.pages.AccountPage;
import com.automationpractice.pages.AuthenticationPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.tests.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class CreateAccountTests extends BaseTest {

  private HomePage homePage;
  private RegisterAccount accountData;

  @BeforeEach
  public void beforeEach() {
    homePage = new HomePage(getDriver());
    accountData = new DataProvider().getRandomRegisterAccountData();
    // Maximize browser and navigate to the Home Page
    getDriver().manage().window().maximize();
    getDriver().navigate().to(ConfigurationProvider.getProperty(Properties.BASE_URL));

    assertDoesNotThrow(homePage::waitForPageToOpen, "Home page did not open successfully.");
  }

  @Test
  @Execution(ExecutionMode.SAME_THREAD)
  @DisplayName("Verify that user can register with valid data")
  public void verifyUserCanRegisterWithValidDataTest() {
    // Click on the 'Sign in' button
    AuthenticationPage authenticationPage = homePage.clickOnSignInButton();

    assertDoesNotThrow(authenticationPage::waitForPageToOpen, "Authentication page did not open successfully.");

    // Enter e-mail and click on the 'Create an account' button
    authenticationPage.enterEmail(accountData.getEmail());
    CreateAccountPage createAccountPage = authenticationPage.clickOnCreateAccountButton();

    assertDoesNotThrow(createAccountPage::waitForPageToOpen, "Create account page did not open successfully.");

    // Enter personal information
    createAccountPage.selectTitle(accountData.getTitle());
    createAccountPage.enterFirstName(accountData.getFirstName());
    createAccountPage.enterLastName(accountData.getLastName());
    createAccountPage.enterPassword(accountData.getPassword());
    createAccountPage.selectDayOfBirth(accountData.getDateOfBirth().getDayOfMonth());
    createAccountPage.selectMonthOfBirth(accountData.getDateOfBirth().getMonthValue());
    createAccountPage.selectYearOfBirth(accountData.getDateOfBirth().getYear());
    createAccountPage.signUpForNewsletter(accountData.getSignUpForNewsletter());
    createAccountPage.optInForSpecialOffers(accountData.getReceiveOffers());

    // Enter address
    createAccountPage.enterAddressFirstName(accountData.getAddressFirstName());
    createAccountPage.enterAddressLastName(accountData.getAddressLastName());
    createAccountPage.enterCompanyName(accountData.getCompanyName());
    createAccountPage.enterAddressLine1(accountData.getAddressLine1());
    createAccountPage.enterAddressLine2(accountData.getAddressLine2());
    createAccountPage.enterCity(accountData.getCity());
    createAccountPage.selectState(accountData.getState());
    createAccountPage.enterPostalCode(accountData.getPostalCode());
    createAccountPage.selectCountry(accountData.getCountry());
    createAccountPage.enterAdditionalInformation(accountData.getAdditionalInformation());
    createAccountPage.enterHomePhone(accountData.getHomePhone());
    createAccountPage.enterMobilePhone(accountData.getMobilePhone());
    createAccountPage.enterAddressAlias(accountData.getAddressAlias());

    // Register
    AccountPage accountPage = createAccountPage.clickOnRegisterButton();

    assertDoesNotThrow(accountPage::waitForPageToOpen, "Account page did not open successfully after registration.");

    // Verify successful login
    assertThat("Sign out button is not visible, login unsuccessful.", accountPage.getSignOutButtonVisibility(), is(true));
  }
}
