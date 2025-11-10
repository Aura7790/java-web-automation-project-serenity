package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElementFacade loginHeading;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElementFacade emailField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    private WebElementFacade failedLogin;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElementFacade deleteAccountButton;

    @FindBy(xpath = "//b[text()='Account Deleted!']")
    private WebElementFacade accountDeletedText;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElementFacade continueAfterDeleteButton;

    public String getHeadingText() {
        return loginHeading.getText();
    }

    public void setEmailField(String value) {
        typeInto(emailField, value);
    }

    public void setPasswordField(String value){
        typeInto(passwordField, value);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public String getLoginFailedMessage(){
        waitFor(failedLogin);
        return failedLogin.getText();
    }

    public String getEmailFieldValidationMessage() {
        return getValidationMessageFor(emailField);
    }

    public String getPasswordFieldValidationMessage() {
        return getValidationMessageFor(passwordField);
    }

    public void clickDeleteAccountButton(){
        clickOn(deleteAccountButton);
    }

    public String getDeleteAccountSuccessMessage(){
        return accountDeletedText.getText();
    }

    public void clickContinueBtnAfterDeleteAccount(){
        waitFor(continueAfterDeleteButton);
        clickOn(continueAfterDeleteButton);
    }

}
