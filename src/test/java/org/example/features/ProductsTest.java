package org.example.features;
import org.junit.Test;
import static org.example.utils.Constants.PRODUCTS_URL;

public class ProductsTest extends BaseTest{

    @Test
    public void productsPageUrlContainsProducts(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsPageUrl(PRODUCTS_URL);
    }

    @Test
    public void productsListLoadsSuccessfully(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.checkProductsPageContentNotEmpty();
    }

    @Test
    public void productDetailPageOpens(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.isProductCategorySectionVisible();
        productsSteps.isProductReviewSectionVisible();
    }

    @Test
    public void checkProductDetails(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.checkProductName("Blue Top");
        productsSteps.checkProductCategory("Category: Women > Tops");
        productsSteps.checkProductAvailability("Availability: In Stock");
        productsSteps.checkProductCondition("Condition: New");
        productsSteps.checkProductBrand("Brand: Polo");
    }

    @Test
    public void addProductToCartWithValidQty(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity(1);
        productsSteps.clickAddToCartButton();
        productsSteps.isCartModalVisible();
        productsSteps.checkModalTitleText("Added!");
        productsSteps.checkModalSubtitleText("Your product has been added to cart.");
        productsSteps.clickContinueShopping();
        productsSteps.isProductDetailSectionVisible();
    }

    @Test
    public void checkPriceIsDisplayedForAllProducts(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        productsSteps.checkAllProductsHavePrices();
    }

    @Test
    public void verifyProductPriceMatchesBetweenListingAndCart() {
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.scrollToFirstViewProduct();
        String productPriceOnListing = productsSteps.getFirstProductPriceFromListing();
        productsSteps.clickViewFirstProductLink();
        productsSteps.isProductDetailSectionVisible();
        productsSteps.setProductQuantity(1);
        productsSteps.addFirstProductToCartAndContinue();
        cartSteps.openCartPage();
        cartSteps.isCartInfoVisible();
        productsSteps.checkPriceMatchesInCart(productPriceOnListing);
    }

    @Test
    public void checkUIHeaderChangesAfterFiltering() {
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.filterByDressCategory();
        productsSteps.checkHeaderContains("WOMEN - DRESS PRODUCTS");
    }

    @Test
    public void checkFilteredProductsMatchCategory() {
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.filterByDressCategory();
        productsSteps.checkProductNamesContainCategory("Dress");
    }

    @Test
    public void checkDynamicFilterByCategory(){
        productsSteps.openProductsPage();
        productsSteps.checkProductsListDisplayed();
        productsSteps.filterByCategory("Women", "Dress");
        productsSteps.checkHeaderContains("WOMEN - DRESS PRODUCTS");
    }
}
