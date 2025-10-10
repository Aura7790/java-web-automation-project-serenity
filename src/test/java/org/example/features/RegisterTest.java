package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.LoginSteps;
import org.example.steps.RegisterSteps;
import org.example.utils.TestDataGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
public class RegisterTest {
    private static final Logger log = LoggerFactory.getLogger(RegisterTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private RegisterSteps registerSteps;

    @Steps
    private LoginSteps loginSteps;

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueName = dataGenerator.generateUniqueName();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

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
