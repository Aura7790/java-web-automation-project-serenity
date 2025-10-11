package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.CartPage;
import org.example.pages.ProductsPage;
import org.junit.Assert;

public class CartSteps extends ScenarioSteps {
    private CartPage cartPage;
    private ProductsPage productsPage;

    @Step
    public void checkCartPageUrl(String url){
        Assert.assertEquals(productsPage.getCurrentUrl(), url);
    }

    @Step
    public void isCartInfoVisible(){
        Assert.assertTrue(cartPage.isCartInfoDisplayed());
    }

    @Step
    public void openCartPage(){
        cartPage.clickOnCartLink();
    }

    @Step
    public void proceedToCheckout(){
        cartPage.clickProceedToCheckoutButton();
    }

    @Step
    public void isCheckoutModalVisible(){
        Assert.assertTrue(cartPage.isCheckoutModalDisplayed());
    }

    @Step
    public void checkCheckoutModalTitle(String expectedTitle){
        Assert.assertEquals(cartPage.getCheckoutModalTitle(), expectedTitle);
    }

    @Step
    public void checkLoginRegisterLinkText(String expectedText){
        Assert.assertEquals(cartPage.getCheckoutRegisterLoginLinkText(), expectedText);
    }

    @Step
    public void goToRegisterLoginPage(){
        cartPage.clickRegisterLoginLink();
    }

    @Step
    public void checkContinueOnCartText(String expectedText){
        Assert.assertEquals(cartPage.getContinueOnCartText(), expectedText);
    }

    @Step
    public void continueOnCart(){
        cartPage.clickContinueOnCartButton();
    }

}
