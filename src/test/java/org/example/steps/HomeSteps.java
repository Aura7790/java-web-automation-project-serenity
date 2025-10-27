package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    @Step
    public void acceptCookies(){
        homePage.clickOnCookiesConsent();
    }

    @Step
    public void checkLogoOnHomePage(){
        Assert.assertTrue(homePage.isLogoVisible());
        homePage.isLogoVisible();
    }

    @Step
    public void checkHomePageTitle(){
        Assert.assertEquals("Automation Exercise", homePage.getHomePageTitle());
    }

    @Step
    public void checkNavigationBarVisible(){
        Assert.assertTrue(homePage.isNavigationMenuVisible());
    }

    @Step
    public void checkFooterIsVisible(){
        Assert.assertTrue(homePage.isFooterVisible());
    }

    @Step
    public void subscribeWithEmail(String email){
        homePage.setSubscribeEmailField(email);
        homePage.clickOnSubscribeButton();
    }

    @Step
    public void checkSubscriptionSuccess() {
        Assert.assertTrue(homePage.isSubscriptionSuccessVisible());
    }
}
