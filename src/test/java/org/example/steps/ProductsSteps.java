package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.ProductsPage;
import org.junit.Assert;

public class ProductsSteps extends ScenarioSteps {
    private ProductsPage productsPage;

    @Step
    public void openProductsPage() {
        productsPage.clickProductsLink();
    }

    @Step
    public void checkProductsPageUrl(String url){
        Assert.assertEquals(productsPage.getCurrentUrl(), url);
    }

    @Step
    public void checkProductsListDisplayed() {
        Assert.assertTrue(productsPage.isProductListVisible());
    }

    @Step
    public void checkProductsPageContentNotEmpty(){
        int number_of_products = productsPage.productCount();
        Assert.assertNotEquals(0, number_of_products);
    }

    @Step
    public void scrollToFirstViewProduct(){
        productsPage.scrollToViewProductButton();
    }

    @Step
    public void clickViewFirstProductLink(){
        productsPage.clickViewProductLink();
    }

    @Step
    public void isProductDetailSectionVisible(){
        Assert.assertTrue(productsPage.isProductDetailsDisplayed());
    }

    @Step
    public void isProductCategorySectionVisible(){
        Assert.assertTrue(productsPage.isCategorySectionDisplayed());
    }

    @Step
    public void isProductReviewSectionVisible(){
        Assert.assertTrue(productsPage.isReviewSectionDisplayed());
    }

    @Step
    public void setProductQuantity(String qty){
        productsPage.setProductQuantity(qty);
    }

    @Step
    public void clickAddToCartButton(){
        productsPage.addProductToCart();
    }

    @Step
    public void isCartModalVisible(){
        Assert.assertTrue(productsPage.isCartModalDisplayed());
    }

    @Step
    public void checkModalTitleText(String expectedTitle){
        Assert.assertEquals(productsPage.getCartModalTitleText(), expectedTitle);
    }

    @Step
    public void checkModalSubtitleText(String expectedSubtitle){
        Assert.assertEquals(productsPage.getCartModalSubtitleText(), expectedSubtitle);
    }

    @Step
    public void clickViewCart(){
        productsPage.clickViewCartLink();
    }

    @Step
    public void clickContinueShopping(){
        productsPage.clickContinueShoppingButton();
    }
}
