package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(css = ".cart_info")
    private WebElementFacade cartInfo;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    private WebElementFacade cartLink;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElementFacade checkoutButton;

    @FindBy(id = "checkoutModal")
    private WebElementFacade checkoutModal;

    @FindBy(xpath = "//h4[text()='Checkout']")
    private WebElementFacade checkoutModalTitle;

    @FindBy(xpath = "//u[contains(text(), 'Register / Login')]")
    private WebElementFacade registerLoginLink;

    @FindBy(xpath = "//button[text()='Continue On Cart']")
    private WebElementFacade continueOnCartButton;

    @FindBy(css = "a.cart_quantity_delete")
    private WebElementFacade deleteButton;

    @FindBy(css = ".cart_info tbody tr")
    private List<WebElementFacade> cartItems;

    @FindBy(id = "empty_cart")
    private WebElementFacade emptyCart;

    public boolean isCartInfoDisplayed(){
        cartInfo.waitUntilVisible();
        return cartInfo.isDisplayed();
    }

    public void clickOnCartLink(){
        cartLink.waitUntilVisible();
        clickOn(cartLink);
    }

    public void clickProceedToCheckoutButton(){
        clickOn(checkoutButton);
    }

    public boolean isCheckoutModalDisplayed(){
        checkoutModal.waitUntilVisible();
        return checkoutModal.isDisplayed();
    }

    public String getCheckoutModalTitle(){
        return checkoutModalTitle.getText();
    }

    public String getCheckoutRegisterLoginLinkText(){
        return registerLoginLink.getText();
    }

    public void clickRegisterLoginLink(){
        clickOn(registerLoginLink);
    }

    public String getContinueOnCartText(){
        return continueOnCartButton.getText();
    }

    public void clickContinueOnCartButton(){
        clickOn(continueOnCartButton);
    }

    public void deleteFirstProductFromCart() {
        if (!cartItems.isEmpty()) {
            deleteButton.click();
        }
    }

    public String getCartEmptyText(){
        return emptyCart.getText();
    }
}
