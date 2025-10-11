package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class FooterPage extends PageObject {
    @FindBy(id = "susbscribe_email")
    WebElementFacade subscriptionEmailInput;

    @FindBy(id = "subscribe")
    WebElementFacade subscribeButton;

    @FindBy(css = "div#success-subscribe.alert-success")
    WebElementFacade subscriptionSuccessMessage;

    public void enterSubscriptionEmail(String email) {
        typeInto(subscriptionEmailInput, email);
    }

    public void clickSubscribeButton() {
        clickOn(subscribeButton);
    }

    public boolean isSubscriptionSuccessMessageVisible() {
        subscriptionSuccessMessage.waitUntilVisible();
        return subscriptionSuccessMessage.isDisplayed();
    }

    public String getSubscriptionSuccessMessageText(){
        return subscriptionSuccessMessage.getText();
    }
}
