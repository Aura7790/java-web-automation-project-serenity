package org.example.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class RegisterPage extends BasePage {
    @FindBy(xpath= "//h2[text()='New User Signup!']")
    private WebElementFacade signupHeading;

    @FindBy(name = "name")
    private WebElementFacade nameField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElementFacade emailField;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElementFacade signupButton;

    @FindBy(css = ".login-form")
    private WebElementFacade signupForm;

    @FindBy(xpath= "//b[text()='Enter Account Information']")
    private WebElementFacade signupFormText;

    @FindBy(id = "email")
    private WebElementFacade emailFieldForm;

    @FindBy(id = "id_gender1")
    private WebElementFacade titleMr;

    @FindBy(id = "id_gender2")
    private WebElementFacade titleMrs;

    @FindBy(id = "password")
    private WebElementFacade passwordField;

    @FindBy(id = "days")
    private WebElementFacade daysDropdown;

    @FindBy(id = "months")
    private WebElementFacade monthsDropdown;

    @FindBy(id = "years")
    private WebElementFacade yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElementFacade newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElementFacade specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElementFacade firstNameField;

    @FindBy(id = "last_name")
    private WebElementFacade lastNameField;

    @FindBy(id = "company")
    private WebElementFacade companyField;

    @FindBy(id = "address1")
    private WebElementFacade address1Field;

    @FindBy(id = "address2")
    private WebElementFacade address2Field;

    @FindBy(id = "country")
    private WebElementFacade countryField;

    @FindBy(id = "state")
    private WebElementFacade stateField;

    @FindBy(id = "city")
    private WebElementFacade cityField;

    @FindBy(id = "zipcode")
    private WebElementFacade zipcodeField;

    @FindBy(id = "mobile_number")
    private WebElementFacade mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElementFacade createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElementFacade accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElementFacade continueButton;

    @FindBy(xpath = "//p[contains(text(),'Email Address already exist!')]")
    private WebElementFacade existingEmailError;

    public String getSignupHeadingText(){
        return signupHeading.getText();
    }

    public void setNameField(String name) {
        typeInto(nameField, name);
    }

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void clickSignupButton() {
        clickOn(signupButton);
    }

    public void isSignupFormVisible(){
        signupForm.waitUntilVisible();
    }

    public String getSignupFormText(){
        return signupFormText.getText();
    }

    public String getNameFieldText(){
        return nameField.getValue();
    }

    public String getEmailFieldText(){
        return emailFieldForm.getValue();
    }

    public void fillAccountInformation(String title, String password, String day, String month, String year) {
        if (Objects.equals(title, "titleMr"))
            clickOn(titleMr);
        else if (Objects.equals(title, "titleMrs"))
            clickOn(titleMrs);
        typeInto(passwordField, password);
        selectFromDropdown(daysDropdown, day);
        selectFromDropdown(monthsDropdown, month);
        selectFromDropdown(yearsDropdown, year);
        clickOn(newsletterCheckbox);
        clickOn(specialOffersCheckbox);
    }

    public void fillAddressInformation(String firstName, String lastName, String company, String address1, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        typeInto(firstNameField, firstName);
        typeInto(lastNameField, lastName);
        typeInto(companyField, company);
        typeInto(address1Field, address1);
        typeInto(address2Field, address2);
        selectFromDropdown(countryField, country);
        typeInto(stateField, state);
        typeInto(cityField, city);
        typeInto(zipcodeField, zipcode);
        typeInto(mobileNumberField, mobileNumber);
    }

    public void selectFromDropdown(WebElement dropdown, String value) {
        clickOn(dropdown.findElement(By.xpath(".//option[text()='" + value + "']")));
    }

    public void clickCreateAccountButton() {
        clickOn(createAccountButton);
    }

    public void isAccountCreatedMessageVisible(){
        accountCreatedMessage.waitUntilVisible();
    }

    public String getAccountCreatedText(){
        return accountCreatedMessage.getText();
    }

    public void clickContinueButton(){
        clickOn(continueButton);
    }

    public String getEmailAlreadyExistsText(){
        return existingEmailError.getText();
    }

    public String getNameFieldValidationMessage() {
        return getValidationMessageFor(nameField);
    }

    public String getEmailFieldValidationMessage() {
        return getValidationMessageFor(emailField);
    }

}

