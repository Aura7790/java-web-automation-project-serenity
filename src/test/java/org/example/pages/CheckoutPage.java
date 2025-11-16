package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage extends BasePage{
    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    private WebElementFacade reviewOrderHeader;

    @FindBy(xpath = "//a[contains(text(), 'Place Order')]")
    private WebElementFacade placeOrderButton;

    @FindBy(name = "name_on_card")
    private WebElementFacade nameOnCardField;

    @FindBy(name = "card_number")
    private WebElementFacade cardNumberField;

    @FindBy(name = "cvc")
    private WebElementFacade cvcField;

    @FindBy(name = "expiry_month")
    private WebElementFacade expiryMonthField;

    @FindBy(name = "expiry_year")
    private WebElementFacade expiryYeaField;

    @FindBy(id = "submit")
    private WebElementFacade payAndConfirmOrderButton;

    @FindBy(xpath = "//p[contains(text(),'Your order has been confirmed!')]")
    private WebElementFacade orderPlacedSuccessMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElementFacade orderContinueButton;

    public boolean isReviewOrderPageDisplayed() {
        return reviewOrderHeader.isDisplayed();
    }

    public void scrollToViewPlaceOrderButton(){
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
    }

    public void clickPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public void fillPaymentName(String name){
        typeInto(nameOnCardField, name);
    }

    public void fillPaymentCardNumber(String number){
        typeInto(cardNumberField, number);
    }

    public void fillPaymentCvcCode(String cvcCode){
        typeInto(cvcField, cvcCode);
    }

    public void fillPaymentExpiryMonth(String month){
        typeInto(expiryMonthField, month);
    }

    public void fillPaymentExpiryYear(String year){
        typeInto(expiryYeaField, year);
    }

    public void scrollToViewPayAndConfirmOrderButton(){
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", payAndConfirmOrderButton);
    }

    public void clickPayAndConfirmOrderButton() {
        clickOn(payAndConfirmOrderButton);
    }

    public String getOrderSuccessValidationMessage() {
        orderPlacedSuccessMessage.waitUntilVisible();
        return orderPlacedSuccessMessage.getText();
    }

    public void clickOrderContinueButton() {
        clickOn(orderContinueButton);
    }
}
