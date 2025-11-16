package org.example.features;
import org.example.utils.TestDataGenerator;
import org.junit.Test;
import static org.example.utils.Constants.*;

public class CheckoutTests extends BaseTest{

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueName = dataGenerator.generateUniqueName();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();

    @Test
    public void loginAndCheckout(){
        loginSteps.navigateToRegisterLoginPage();
        loginSteps.loginWithExistentUser(USER_EMAIL, USER_PASSWORD, USER_NAME);
        // check cart and delete all products if not empty
        cartSteps.openCartPage();
        cartSteps.deleteProductAndCheckCartEmpty(CART_EMPTY_MESSAGE);
        productsSteps.searchForProductAndAddToCart("T-shirt", 1);
        cartSteps.checkProductAddedIsInCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.checkoutAndCheckOrderWasPlacedSuccessfully();
        cartSteps.openCartPage();
        cartSteps.deleteProductAndCheckCartEmpty(CART_EMPTY_MESSAGE);
        loginSteps.logoutUser();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void checkoutAndLogin(){
        productsSteps.openProductsPage();
        cartSteps.openCartPage();
        cartSteps.deleteProductAndCheckCartEmpty(CART_EMPTY_MESSAGE);
        productsSteps.searchForProductAndAddToCart("T-shirt", 2);
        cartSteps.checkProductAddedIsInCart();
        cartSteps.proceedToCheckout();
        cartSteps.checkCheckoutModalTitle("Checkout");
        cartSteps.checkLoginRegisterLinkText("Register / Login");
        cartSteps.goToRegisterLoginPage();
        loginSteps.loginWithExistentUser(USER_EMAIL, USER_PASSWORD, USER_NAME);
        cartSteps.openCartPage();
        cartSteps.checkProductAddedIsInCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.checkoutAndCheckOrderWasPlacedSuccessfully();
        cartSteps.openCartPage();
        cartSteps.deleteProductAndCheckCartEmpty(CART_EMPTY_MESSAGE);
        loginSteps.logoutUser();
        loginSteps.checkLoginHeading(LOGIN_HEADING);
    }

    @Test
    public void checkoutAsNewUser(){
        productsSteps.openProductsPage();
        cartSteps.openCartPage();
        cartSteps.deleteProductAndCheckCartEmpty(CART_EMPTY_MESSAGE);
        productsSteps.searchForProductAndAddToCart("T-shirt", 3);
        cartSteps.checkProductAddedIsInCart();
        cartSteps.proceedToCheckout();
        cartSteps.checkCheckoutModalTitle("Checkout");
        cartSteps.checkLoginRegisterLinkText("Register / Login");
        cartSteps.goToRegisterLoginPage();
        registerSteps.checkSignupHeading(SIGNUP_HEADING);
        registerSteps.registerNewUserWithValidData(uniqueName, uniqueEmail, uniquePassword);
        loginSteps.userIsLoggedIn(uniqueName);
        cartSteps.openCartPage();
        cartSteps.checkProductAddedIsInCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.checkoutAndCheckOrderWasPlacedSuccessfully();
        // delete account after purchase
        loginSteps.deleteAccountAndCheckIsDeleted("ACCOUNT DELETED!");
        homeSteps.checkHomePageTitle();
    }
}
