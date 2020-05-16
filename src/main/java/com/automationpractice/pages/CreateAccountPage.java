package com.automationpractice.pages;

import com.automationpractice.pages.base.BasePage;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) { super(driver); }

    //region General
    @FindBy(how = How.XPATH, using = "//h1[text()='Create an account']")
    private WebElement titleLabel;
    @FindBy(how = How.ID, using = "submitAccount")
    private WebElement registerButton;

    public void waitForPageToOpen() {
        wait.waitUntilElementIsPresent(titleLabel);
    }

    public AccountPage clickOnRegisterButton() {
        registerButton.click();
        return new AccountPage(driver);
    }

    //endregion

    //region PersonalInformation
    @FindBy(how = How.NAME, using = "id_gender")
    private List<WebElement> titleRadioList;

    @FindBy(how = How.ID, using = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(how = How.ID, using = "customer_lastname")
    private WebElement lastNameInput;
    @FindBy(how = How.ID, using = "email")
    private WebElement emailInput;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = "days")
    private WebElement dayOfBirthDropdown;
    @FindBy(how = How.ID, using = "months")
    private WebElement monthOfBirthDropdown;
    @FindBy(how = How.ID, using = "years")
    private WebElement yearOfBirthDropdown;

    @FindBy(how = How.ID, using = "newsletter")
    private WebElement signUpForNewsletterCheckbox;
    @FindBy(how = How.ID, using = "optin")
    private WebElement receiveSpecialOffersCheckbox;

    public void selectTitle(String value) {
        titleRadioList.stream().filter(element -> element.getAttribute("value").equals(value))
                .findFirst().orElseThrow(
                        () -> new NoSuchElementException(String.format("Unable to find title with value %s.", value)))
                .click();
    }

    public void enterFirstName(String text) {
        firstNameInput.sendKeys(text);
    }

    public void enterLastName(String text) {
        lastNameInput.sendKeys(text);
    }

    public void enterEmail(String text) {
        emailInput.sendKeys(text);
    }

    public void enterPassword(String text) {
        passwordInput.sendKeys(text);
    }

    public void selectDayOfBirth(int value) {
        new Select(dayOfBirthDropdown).selectByValue(String.valueOf(value));
    }

    public void selectMonthOfBirth(int value) {
        new Select(monthOfBirthDropdown).selectByValue(String.valueOf(value));
    }

    public void selectYearOfBirth(int value) {
        new Select(yearOfBirthDropdown).selectByValue(String.valueOf(value));
    }

    public void signUpForNewsletter(Boolean value) {
        if (!signUpForNewsletterCheckbox.isSelected() && value || signUpForNewsletterCheckbox.isSelected() && !value) {
            signUpForNewsletterCheckbox.click();
        }
    }

    public void optInForSpecialOffers(Boolean value) {
        if (!receiveSpecialOffersCheckbox.isSelected() && value || receiveSpecialOffersCheckbox.isSelected() && !value) {
            receiveSpecialOffersCheckbox.click();
        }
    }
    //endregion

    //region YourAddress
    @FindBy(how = How.ID, using = "firstname")
    private WebElement addressFirstNameInput;
    @FindBy(how = How.ID, using = "lastname")
    private WebElement addressLastNameInput;
    @FindBy(how = How.ID, using = "company")
    private WebElement companyNameInput;
    @FindBy(how = How.ID, using = "address1")
    private WebElement addressLine1Input;
    @FindBy(how = How.ID, using = "address2")
    private WebElement addressLine2Input;
    @FindBy(how = How.ID, using = "city")
    private WebElement cityInput;
    @FindBy(how = How.ID, using = "id_state")
    private WebElement stateDropdown;
    @FindBy(how = How.ID, using = "postcode")
    private WebElement postalCodeInput;
    @FindBy(how = How.ID, using = "id_country")
    private WebElement countryDropdown;
    @FindBy(how = How.ID, using = "other")
    private WebElement additionalInformationTextArea;
    @FindBy(how = How.ID, using = "phone")
    private WebElement homePhoneInput;
    @FindBy(how = How.ID, using = "phone_mobile")
    private WebElement mobilePhoneInput;
    @FindBy(how = How.ID, using = "alias")
    private WebElement addressAliasInput;

    public void enterAddressFirstName(String text) {
        addressFirstNameInput.sendKeys(text);
    }

    public void enterAddressLastName(String text) {
        addressLastNameInput.sendKeys(text);
    }

    public void enterCompanyName(String text) {
        companyNameInput.sendKeys(text);
    }

    public void enterAddressLine1(String text) {
        addressLine1Input.sendKeys(text);
    }

    public void enterAddressLine2(String text) {
        addressLine2Input.sendKeys(text);
    }

    public void enterCity(String text) {
        cityInput.sendKeys(text);
    }

    public void selectState(String value) {
        new Select(stateDropdown).selectByValue(value);
    }

    public void enterPostalCode(String text) {
        postalCodeInput.sendKeys(text);
    }

    public void selectCountry(String value) {
        new Select(countryDropdown).selectByValue(value);
    }

    public void enterAdditionalInformation(String text) {
        additionalInformationTextArea.sendKeys(text);
    }

    public void enterHomePhone(String text) {
        homePhoneInput.sendKeys(text);
    }

    public void enterMobilePhone(String text) {
        mobilePhoneInput.sendKeys(text);
    }

    public void enterAddressAlias(String text) {
        addressAliasInput.clear();
        addressAliasInput.sendKeys(text);
    }
    //endregion
}
