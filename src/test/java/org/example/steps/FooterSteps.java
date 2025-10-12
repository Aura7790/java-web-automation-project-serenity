package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class FooterSteps extends BaseSteps {

    @Step
    public void enterFooterEmail(String email) {
        footerPage.enterSubscriptionEmail(email);
    }

    @Step
    public void clickFooterSubscribe() {
        footerPage.clickSubscribeButton();
    }

    @Step
    public void verifySubscriptionSuccess() {
       Assert.assertTrue(footerPage.isSubscriptionSuccessMessageVisible());

    }

    @Step
    public void checkSubscriptionSuccessText(String expected_text){
        Assert.assertEquals(footerPage.getSubscriptionSuccessMessageText(), expected_text);
    }

}
