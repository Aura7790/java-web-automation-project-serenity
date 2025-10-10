package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.AccountPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

    @Step
    public void navigateToRegisterLoginPage(){
        homePage.open();
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
    public void clickLogout(){
        accountPage.clickLogoutLink();
    }
}
