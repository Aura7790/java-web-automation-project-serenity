package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.HomeSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
public class HomeTest {
    private static final Logger log = LoggerFactory.getLogger(HomeTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private HomeSteps homeSteps;

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void checkLogoIsDisplayedOnHomePage() {
        homeSteps.navigateToHomePage();
        homeSteps.checkLogoOnHomePage();
    }
}
