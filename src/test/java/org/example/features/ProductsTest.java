package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.HomeSteps;
import org.example.steps.ProductsSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
public class ProductsTest {
    private static final Logger log = LoggerFactory.getLogger(ProductsTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private ProductsSteps productsSteps;

    @Steps
    private HomeSteps homeSteps;

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void productsPageUrlContainsProducts(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        String productsUrl = "https://automationexercise.com/products";
        productsSteps.checkProductsPageUrl(productsUrl);
    }

    @Test
    public void productsListLoadsSuccessfully(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.checkProductsPageContentNotEmpty();
    }

    @Test
    public void productDetailPageOpens(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.isProductCategorySectionVisible();
        productsSteps.isProductReviewSectionVisible();
    }

    @Test
    public void addProductToCartWithValidQty(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity("1");
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.checkModalTitleText("Added!");
        productsSteps.checkModalSubtitleText("Your product has been added to cart.");
        productsSteps.clickContinueShopping();
        productsSteps.isProductDetailSectionVisible();
    }

    @Test
    public void searchFunctionReturnsResults() {
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        productsSteps.searchForProduct("Dress");
        productsSteps.verifySearchResultsAreNotEmpty();
    }
}
