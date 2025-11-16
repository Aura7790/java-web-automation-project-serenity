package org.example.features;
import org.junit.Test;
import static org.example.utils.Constants.*;

public class CartTest extends BaseTest {

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
    public void checkProceedToCheckoutModal(){
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
        loginSteps.checkLoginHeading(LOGIN_HEADING);
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
        cartSteps.checkCartEmptyText(CART_EMPTY_MESSAGE);
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
        cartSteps.deleteProductAndCheckCartEmpty(CART_EMPTY_MESSAGE);
        loginSteps.logoutUser();
    }
}
