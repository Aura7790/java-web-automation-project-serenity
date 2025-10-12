package org.example.features;

import org.example.utils.TestDataGenerator;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueName = dataGenerator.generateUniqueName();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();

    @Test
    public void signUpWithValidData(){
        // first part of the form
        loginSteps.navigateToRegisterLoginPage();
        registerSteps.checkSignupHeading("New User Signup!");
        registerSteps.setUserName(uniqueName);
        registerSteps.setEmail(uniqueEmail);
        registerSteps.clickSignup();
        // second part of the form
        registerSteps.checkSignupForm("ENTER ACCOUNT INFORMATION");
        registerSteps.checkNameFieldText(uniqueName);
        registerSteps.checkEmailFieldText(uniqueEmail);
        registerSteps.setAccountInformation("titleMr", uniquePassword, "17", "July", "1900");
        registerSteps.setAddressInformation();
        registerSteps.clickCreateAccount();
        registerSteps.checkAccountCreatedMessage();
        registerSteps.clickContinue();
        loginSteps.userIsLoggedIn(uniqueName);
        loginSteps.clickLogout();
    }
}
