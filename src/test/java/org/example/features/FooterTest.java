package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.FooterSteps;
import org.example.steps.HomeSteps;
import org.example.steps.ProductsSteps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.utils.TestDataGenerator;

import static net.serenitybdd.core.Serenity.getDriver;

@RunWith(SerenityRunner.class)
public class FooterTest {
    private static final Logger log = LoggerFactory.getLogger(FooterTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private ProductsSteps productsSteps;

    @Steps
    private FooterSteps footerSteps;

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void footerSubscriptionWithValidEmail() {
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        footerSteps.enterFooterEmail(uniqueEmail);
        footerSteps.clickFooterSubscribe();
        // The success message disappears automatically after few seconds
        Assert.assertTrue((driver.getPageSource()).contains("You have been successfully subscribed!"));
        // footerSteps.verifySubscriptionSuccess();
        // footerSteps.checkSubscriptionSuccessText("You have been successfully subscribed!");
    }
}
