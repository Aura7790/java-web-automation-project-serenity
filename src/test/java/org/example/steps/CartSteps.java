package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class CartSteps extends BaseSteps {

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

    @Step
    public void deleteProductFromCart() {
        cartPage.deleteFirstProductFromCart();
    }

    @Step
    public void checkCartEmptyText(String expected_text){
        Assert.assertEquals(cartPage.getCartEmptyText(), expected_text);
    }

}
