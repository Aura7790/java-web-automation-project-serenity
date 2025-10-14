package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import java.util.List;

public class ProductsSteps extends BaseSteps {

    @Step
    public void openProductsPage() {
        homePage.clickOnCookiesConsent();
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
    public void setProductQuantity(int qty){
        productsPage.setProductQuantity(qty);
    }

    @Step
    public void clickAddToCartButton(){
        productsPage.addFirstProductToCart();
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

    @Step
    public void addFirstProductToCartAndContinue(){
        productsPage.addFirstProductToCartAndContinue();
    }

    @Step()
    public void checkAllProductsHavePrices() {
        List<WebElementFacade> prices = productsPage.getAllProductPrices();
        Assert.assertFalse(prices.isEmpty());

        for (WebElementFacade price : prices) {
            Assert.assertTrue(price.isDisplayed());
            Assert.assertFalse(price.getText().trim().isEmpty());
        }
    }

    @Step
    public String getFirstProductPriceFromListing() {
        List<WebElementFacade> productPrices = productsPage.getAllProductPrices();
        return productPrices.get(0).getText().trim();
    }

    @Step
    public void checkPriceMatchesInCart(String productPriceOnListing) {
        String cartPrice = cartPage.getFirstCartProductPrice();
        Assert.assertEquals(cartPrice, productPriceOnListing);
    }

    @Step
    public void filterByDressCategory() {
        productsPage.filterByWomenDressCategory();
    }

    @Step
    public void checkHeaderContains(String expectedText) {
        String actualText = productsPage.getFilterHeaderText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Step
    public void checkProductNamesContainCategory(String category) {
        List<String> names = productsPage.getFilteredProductNames();
        Assert.assertFalse("No products found after filtering", names.isEmpty());

        for (String name : names) {
            Assert.assertTrue(
                    "Product name '" + name + "' does not contain expected category '" + category + "'",
                    name.toLowerCase().contains(category.toLowerCase()));
        }
    }

    @Step
    public void filterByCategory(String mainCategory, String subCategory) {
        productsPage.filterByCategory(mainCategory, subCategory);
    }
}
