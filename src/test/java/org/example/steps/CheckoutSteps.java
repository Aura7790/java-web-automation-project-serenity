package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps extends BaseSteps{
    @Step
    public void verifyReviewOrderPageDisplayed() {
        Assert.assertTrue("Review Order page is not displayed!", checkoutPage.isReviewOrderPageDisplayed());
    }

    @Step
    public void clickPlaceOrder(){
        checkoutPage.scrollToViewPlaceOrderButton();
        checkoutPage.clickPlaceOrderButton();
    }

    @Step
    public void fillPaymentDetails(String name, String cardNumber, String cvc, String month, String year) {
        checkoutPage.fillPaymentName(name);
        checkoutPage.fillPaymentCardNumber(cardNumber);
        checkoutPage.fillPaymentCvcCode(cvc);
        checkoutPage.fillPaymentExpiryMonth(month);
        checkoutPage.fillPaymentExpiryYear(year);
    }

    @Step
    public void clickPayAndConfirmOrder() {
        checkoutPage.scrollToViewPayAndConfirmOrderButton();
        checkoutPage.clickPayAndConfirmOrderButton();
    }

    @Step
    public void checkOrderIsSuccessfull(String expectedOrderSuccessMessage) {
        Assert.assertEquals(expectedOrderSuccessMessage, checkoutPage.getOrderSuccessValidationMessage());
    }

    @Step
    public void clickContinueAfterOrderPlaced(){
        checkoutPage.clickOrderContinueButton();
    }

    @Step
    public void checkoutAndCheckOrderWasPlacedSuccessfully(){
        verifyReviewOrderPageDisplayed();
        clickPlaceOrder();
        fillPaymentDetails("Test User", "4111111111111111", "123", "12", "2025");
        clickPayAndConfirmOrder();
        checkOrderIsSuccessfull("Congratulations! Your order has been confirmed!");
        clickContinueAfterOrderPlaced();
    }
}
