package org.example.features;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.utils.Constants.*;

public class CartTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(CartTest.class);
    private final String cartEmptyText = "Cart is empty! Click here to buy products.";

    @Test
    public void checkCartAfterClickOnViewCart(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity(1);
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickViewCart();
        cartSteps.checkCartPageUrl(CART_URL);
        cartSteps.isCartInfoVisible();
    }

    @Test
    public void checkCartAfterClickOnCartLink(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity(1);
        productsSteps.addFirstProductToCartAndContinue();
        productsSteps.isProductDetailSectionVisible();
        cartSteps.openCartPage();
        cartSteps.checkCartPageUrl(CART_URL);
        cartSteps.isCartInfoVisible();
    }

    @Test
    public void checkProceedToCheckout(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity(1);
        productsSteps.addFirstProductToCartAndContinue();
        productsSteps.isProductDetailSectionVisible();
        cartSteps.openCartPage();
        cartSteps.isCartInfoVisible();
        cartSteps.proceedToCheckout();
        cartSteps.isCheckoutModalVisible();
        cartSteps.checkCheckoutModalTitle("Checkout");
        cartSteps.checkLoginRegisterLinkText("Register / Login");
        cartSteps.checkContinueOnCartText("Continue On Cart");
        cartSteps.goToRegisterLoginPage();
        loginSteps.checkLoginHeading("Login to your account");
    }

    @Test
    public void deleteProductFromCart() {
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity(1);
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickViewCart();
        cartSteps.deleteProductFromCart();
        cartSteps.checkCartEmptyText(cartEmptyText);
    }

    @Test
    public void  checkCartTotalUpdatesCorrectlyWithQuantity() {
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.addProductToCartWithQuantity(3);
        productsSteps.isProductDetailSectionVisible();
        cartSteps.openCartPage();
        cartSteps.isCartInfoVisible();
        cartSteps.checkTotalPriceMatchesQuantityAndUnit(3);
    }

    @Test
    public void loginSearchAddToCartDeleteAndLogout() {
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.loginWithExistentUser(USER_EMAIL, USER_PASSWORD, USER_NAME);
        productsSteps.searchForProductAndAddToCart("T-Shirt", 1);
        cartSteps.checkProductAddedIsInCart();
        cartSteps.deleteProductAndCheckCartEmpty(cartEmptyText);
        loginSteps.logoutUser();
    }
}
