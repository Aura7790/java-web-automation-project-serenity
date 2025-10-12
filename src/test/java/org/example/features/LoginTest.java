package org.example.features;

import org.example.utils.TestDataGenerator;
import org.junit.Test;

import static org.example.utils.Constants.*;

public class LoginTest extends BaseTest{

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();

    @Test
    public void loginWithValidCredentials() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading("Login to your account");
        loginSteps.setUserEmail(USER_EMAIL);
        loginSteps.setUserPassword(USER_PASSWORD);
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn(USER_NAME);
        loginSteps.clickLogout();
    }

    @Test
    public void loginWithNotRegisteredUser(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.checkLoginHeading("Login to your account");
        loginSteps.setUserEmail(uniqueEmail);
        loginSteps.setUserPassword(uniquePassword);
        loginSteps.clickLogin();
        loginSteps.checkLoginFailed();
    }

}
