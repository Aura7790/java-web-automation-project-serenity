package org.example.features;

import org.junit.Assert;
import org.junit.Test;
import org.example.utils.TestDataGenerator;

public class FooterTest extends BaseTest {

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();


    @Test
    public void footerSubscriptionWithValidEmail() {
        productsSteps.openProductsPage();
        footerSteps.enterFooterEmail(uniqueEmail);
        footerSteps.clickFooterSubscribe();
        // The success message disappears automatically after few seconds
        Assert.assertTrue((driver.getPageSource()).contains("You have been successfully subscribed!"));
        // footerSteps.verifySubscriptionSuccess();
        // footerSteps.checkSubscriptionSuccessText("You have been successfully subscribed!");
    }
}
