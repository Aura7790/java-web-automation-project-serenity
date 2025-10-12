package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    @Step
    public void navigateToHomePage(){
        homePage.clickOnCookiesConsent();
    }

    @Step
    public void checkLogoOnHomePage(){
        Assert.assertTrue(homePage.isLogoVisible());
        homePage.isLogoVisible();
    }
}
