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
    public void checkProductAddedIsInCart(){
        Assert.assertTrue(cartPage.checkProductId28Text().contains("T-Shirt"));
    }

    @Step
    public void checkCartEmptyText(String expected_text){
        Assert.assertEquals(cartPage.getCartEmptyText(), expected_text);
    }

    @Step
    public void checkTotalPriceMatchesQuantityAndUnit(int qty) {
        int unitPrice = productsPage.getUnitPrice();
        int totalPrice = cartPage.getCartTotalPrice();
        int expectedTotal = unitPrice * qty;
        Assert.assertEquals(totalPrice, expectedTotal);
    }

    @Step
    public void deleteProductAndCheckCartEmpty(String expected_text){
        cartPage.deleteFirstProductFromCart();
        Assert.assertEquals(cartPage.getCartEmptyText(), expected_text);
    }

}
