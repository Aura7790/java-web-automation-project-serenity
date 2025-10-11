package org.example.features;

import com.sun.xml.bind.v2.TODO;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.CartSteps;
import org.example.steps.HomeSteps;
import org.example.steps.LoginSteps;
import org.example.steps.ProductsSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
public class CartTest {
    private static final Logger log = LoggerFactory.getLogger(CartTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private ProductsSteps productsSteps;

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private LoginSteps loginSteps;

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void checkCartAfterClickOnViewCart(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity("1");
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.clickViewCart();
        String cartUrl = "https://automationexercise.com/view_cart";
        cartSteps.checkCartPageUrl(cartUrl);
        cartSteps.isCartInfoVisible();
    }

    @Test
    public void checkCartAfterClickOnCartLink(){
        homeSteps.navigateToHomePage();
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
        cartSteps.checkCartPageUrl("https://automationexercise.com/view_cart");
        cartSteps.isCartInfoVisible();
    }

    @Test
    public void checkProceedToCheckout(){
        homeSteps.navigateToHomePage();
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
}
