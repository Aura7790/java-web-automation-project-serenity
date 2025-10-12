package org.example.features;

import org.junit.Test;

import static org.example.utils.Constants.PRODUCTS_URL;

public class ProductsTest extends BaseTest{

    @Test
    public void productsPageUrlContainsProducts(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        productsSteps.checkProductsPageUrl(PRODUCTS_URL);
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
}
