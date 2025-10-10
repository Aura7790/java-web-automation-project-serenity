package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.HomePage;
import org.junit.Assert;

public class HomeSteps extends ScenarioSteps {
    private HomePage homePage;

    @Step
    public void navigateToHomePage(){
        homePage.open();
        homePage.clickOnCookiesConsent();
    }

    @Step
    public void checkLogoOnHomePage(){
        Assert.assertTrue(homePage.isLogoVisible());
        homePage.isLogoVisible();
    }
}
