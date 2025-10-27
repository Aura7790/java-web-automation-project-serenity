package org.example.features;
import org.example.utils.TestDataGenerator;
import org.junit.Test;

public class HomeTest extends BaseTest{
    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();

    @Test
    public void checkLogoIsDisplayedOnHomePage() {
        homeSteps.acceptCookies();
        homeSteps.checkLogoOnHomePage();
    }

    @Test
    public void checkHomePageTitleIsDisplayed(){
        homeSteps.acceptCookies();
        homeSteps.checkHomePageTitle();
    }

    @Test
    public void checkHomePageLoadsSuccessfully(){
        homeSteps.acceptCookies();
        homeSteps.checkHomePageTitle();
        homeSteps.checkLogoOnHomePage();
        homeSteps.checkNavigationBarVisible();
        homeSteps.checkFooterIsVisible();
    }

    @Test
    public void checkUserSubscribeSuccessfully() {
        homeSteps.acceptCookies();
        homeSteps.subscribeWithEmail(uniqueEmail);
        homeSteps.checkSubscriptionSuccess();
    }
}
