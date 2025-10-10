package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {
    @FindBy(css = ".cart_info")
    private WebElementFacade cartInfo;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    private WebElementFacade cartLink;

    public boolean isCartInfoDisplayed(){
        cartInfo.waitUntilVisible();
        return cartInfo.isDisplayed();
    }

    public void clickOnCartLink(){
        cartLink.waitUntilVisible();
        clickOn(cartLink);
    }
}
