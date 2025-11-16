package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.*;
import org.example.utils.Constants;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public abstract class BaseTest {
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    protected LoginSteps loginSteps;
    @Steps
    protected ProductsSteps productsSteps;
    @Steps
    protected HomeSteps homeSteps;
    @Steps
    protected CartSteps cartSteps;
    @Steps
    protected ContactUsSteps contactUsSteps;
    @Steps
    protected FooterSteps footerSteps;
    @Steps
    protected RegisterSteps registerSteps;
    @Steps
    protected SearchSteps searchSteps;
    @Steps
    protected CheckoutSteps checkoutSteps;

    @Before
    public void initTests(){
        driver.manage().window().maximize();
        driver.get(Constants.BASE_URL);
    }
}
