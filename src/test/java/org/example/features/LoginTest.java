package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
public class LoginTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithValidCredentialsTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.setUserEmail("test171@gmail.com");
        loginSteps.setUserPassword("test1234#");
        loginSteps.clickLogin();
        loginSteps.userIsLoggedIn("test");
    }

}
