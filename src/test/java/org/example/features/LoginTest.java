package org.example.features;

import org.example.utils.TestDataGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.utils.Constants.*;

public class LoginTest extends BaseTest{

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();
    private final String loginHeading = "Login to your account";
    private final String expectedLoginFailedMessage = "Your email or password is incorrect!";
    private final String emptyFieldMessage = "please fill in this field";

    @Test
    public void loginWithValidCredentials() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail(USER_EMAIL);
        loginSteps.setUserPassword(USER_PASSWORD);
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn(USER_NAME);
        loginSteps.clickLogout();
    }

    @Test
    public void loginWithNotRegisteredUser(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword(uniquePassword);
        loginSteps.clickLogin();
        loginSteps.checkLoginFailedMessage(expectedLoginFailedMessage);
    }

    @Test
    public void loginWithWrongPassword() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword("WrongPassword");
        loginSteps.clickLogin();
        loginSteps.checkLoginFailedMessage(expectedLoginFailedMessage);
        loginSteps.checkLoginHeading(loginHeading);
    }
    @Test
    public void loginWithEmptyPassword() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword("");
        loginSteps.clickLogin();
        loginSteps.checkPasswordFieldEmptyMessage(emptyFieldMessage);
        loginSteps.checkLoginHeading(loginHeading);
    }

    @Test
    public void loginWithEmptyEmail() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail("");
        loginSteps.setUserPassword(uniquePassword);
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage(emptyFieldMessage);
        loginSteps.checkLoginHeading(loginHeading);
    }

    @Test
    public void loginWithEmptyCredentials(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail("");
        loginSteps.setUserPassword("");
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage(emptyFieldMessage);
        loginSteps.checkLoginHeading(loginHeading);
    }

    @Test
    public void loginInvalidEmailFormat(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail("test");
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage("is missing an '@'");
        loginSteps.checkLoginHeading(loginHeading);
    }

    @Test
    public void loginWithIncompleteEmailAddress(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(loginHeading);
        loginSteps.setUserEmail("test171@");
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage("'test171@' is incomplete");
        loginSteps.checkLoginHeading(loginHeading);
    }
}
