package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class LoginPage extends PageObject {
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

    public boolean isLoginFailed(){
        return failedLogin.isDisplayed();
    }

}
