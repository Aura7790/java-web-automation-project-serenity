package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {

    @Step
    public void navigateToRegisterLoginPage(){
        homePage.clickOnCookiesConsent();
        homePage.clickOnSignupLoginLink();
    }

    @Step
    public void checkLoginHeading(String heading){
        Assert.assertEquals(heading, loginPage.getHeadingText());
    }

    @Step
    public void setUserEmail(String email){
        loginPage.setEmailField(email);
    }

    @Step
    public void setUserPassword(String password){
        loginPage.setPasswordField(password);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLoginButton();
    }

    @Step
    public void userIsLoggedIn(String username){
        accountPage.isLogoutLinkVisible();
        Assert.assertEquals("Logged in as " + username, accountPage.getLoggedInText(username));
        accountPage.checkLogoutLinkText("Logout");
    }

    @Step
    public void logoutUser(){
        accountPage.clickLogoutLink();
    }

    @Step
    public void checkLoginFailedMessage(String expectedFailedMessage){
        Assert.assertEquals(expectedFailedMessage, loginPage.getLoginFailedMessage());
    }

    @Step
    public void checkPasswordFieldEmptyMessage(String message){
        String validationMessage = loginPage.getPasswordFieldValidationMessage();
        Assert.assertTrue("Expected browser validation message", validationMessage.toLowerCase().contains(message));
    }

    @Step
    public void checkEmailFieldErrorMessage(String message){
        String validationMessage = loginPage.getEmailFieldValidationMessage();
        Assert.assertTrue("Expected browser validation message", validationMessage.toLowerCase().contains(message));
    }

    @Step
    public void loginWithExistentUser(String email, String password, String username){
        setUserEmail(email);
        setUserPassword(password);
        clickLogin();
        accountPage.isLogoutLinkVisible();
        Assert.assertEquals("Logged in as " + username, accountPage.getLoggedInText(username));
    }

    @Step
    public void deleteAccountAndCheckIsDeleted(String message){
        loginPage.clickDeleteAccountButton();
        Assert.assertEquals(message, loginPage.getDeleteAccountSuccessMessage());
        loginPage.clickContinueBtnAfterDeleteAccount();
    }

}
