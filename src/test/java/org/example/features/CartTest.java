package org.example.features;
import org.junit.Test;

import static org.example.utils.Constants.CART_URL;

public class CartTest extends BaseTest {

    @Test
    public void checkCartAfterClickOnViewCart(){
        homeSteps.acceptCookies();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity("1");
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickViewCart();
        cartSteps.checkCartPageUrl(CART_URL);
        cartSteps.isCartInfoVisible();
    }

    @Test
    public void checkCartAfterClickOnCartLink(){
        homeSteps.acceptCookies();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity("1");
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickContinueShopping();
        productsSteps.isProductDetailSectionVisible();
        cartSteps.openCartPage();
        cartSteps.checkCartPageUrl(CART_URL);
        cartSteps.isCartInfoVisible();
    }

    @Test
    public void checkProceedToCheckout(){
        homeSteps.acceptCookies();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity("1");
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickContinueShopping();
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
        homeSteps.acceptCookies();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity("1");
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickViewCart();
        cartSteps.deleteProductFromCart();
        cartSteps.checkCartEmptyText("Cart is empty! Click here to buy products.");
    }
}
