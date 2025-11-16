package org.example.features;
import org.example.utils.TestDataGenerator;
import org.junit.Test;
import static org.example.utils.Constants.*;

public class LoginTest extends BaseTest{

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();
    private final String expectedLoginFailedMessage = "Your email or password is incorrect!";

    @Test
    public void loginWithValidCredentials() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail(USER_EMAIL);
        loginSteps.setUserPassword(USER_PASSWORD);
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn(USER_NAME);
        loginSteps.logoutUser();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void loginWithNotRegisteredUser(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword(uniquePassword);
        loginSteps.clickLogin();
        loginSteps.checkLoginFailedMessage(expectedLoginFailedMessage);
    }

    @Test
    public void loginWithWrongPassword() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword("WrongPassword");
        loginSteps.clickLogin();
        loginSteps.checkLoginFailedMessage(expectedLoginFailedMessage);
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }
    @Test
    public void loginWithEmptyPassword() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword("");
        loginSteps.clickLogin();
        loginSteps.checkPasswordFieldEmptyMessage(EMPTY_FIELD_MESSAGE);
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void loginWithEmptyEmail() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail("");
        loginSteps.setUserPassword(uniquePassword);
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage(EMPTY_FIELD_MESSAGE);
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void loginWithEmptyCredentials(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail("");
        loginSteps.setUserPassword("");
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage(EMPTY_FIELD_MESSAGE);
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void loginInvalidEmailFormat(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail("test");
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage("is missing an '@'");
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void loginWithIncompleteEmailAddress(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
        loginSteps.setUserEmail("test171@");
        loginSteps.clickLogin();
        loginSteps.checkEmailFieldErrorMessage("'test171@' is incomplete");
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }
}
