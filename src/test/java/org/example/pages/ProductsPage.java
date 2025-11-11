package org.example.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Products')]")
    private WebElementFacade productsLink;

    @FindBy(css = ".features_items .product-image-wrapper")
    private List<WebElementFacade> productCards;

    @FindBy(xpath = "//a[contains(text(), 'View Product')]")
    private WebElementFacade firstViewProductLink;

    @FindBy(xpath = "//div[@class='product-information']")
    private WebElementFacade productDetailsSection;

    @FindBy(xpath = "//h2[contains(text(), 'Blue Top')]")
    private WebElementFacade productName;

    @FindBy(xpath = "//p[contains(text(), 'Category: Women > Tops')]")
    private WebElementFacade productCategoryWomenTops;

    @FindBy(xpath = "//p[2][contains(text(), 'In Stock')]")
    private WebElementFacade productAvailability;

    @FindBy(xpath = "//p[3][contains(text(), 'New')]")
    private WebElementFacade productCondition;

    @FindBy(xpath = "//p[4][contains(text(), 'Polo')]")
    private WebElementFacade productBrand;

    @FindBy(xpath = "//div[@class='left-sidebar']/h2[text()='Category']")
    private WebElementFacade categorySection;

    @FindBy(className = "shop-details-tab")
    private WebElementFacade reviewSection;

    @FindBy(id = "quantity")
    private WebElementFacade productQuantity;

    @FindBy(css = "button.cart")
    private WebElementFacade firstAddToCartButton;

    @FindBy(id = "cartModal")
    private WebElementFacade cartModal;

    @FindBy(css = ".modal-title")
    private WebElementFacade cartModalTitle;

    @FindBy(xpath = "//p[text()='Your product has been added to cart.']")
    private WebElementFacade cartModalSubtitle;

    @FindBy(xpath = "//u[text()='View Cart']")
    private WebElementFacade viewCartLink;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElementFacade continueShoppingButton;

    @FindBy(id = "search_product")
    private WebElementFacade searchInput;

    @FindBy(id = "submit_search")
    private WebElementFacade searchButton;

    @FindBy(css = ".features_items .product-image-wrapper")
    private List<WebElementFacade> searchResults;

    @FindBy(css = ".features_items .productinfo h2")
    private List<WebElementFacade> productPrices;

    @FindBy(xpath = "//*[contains(text(),'Rs.')]")
    private WebElementFacade productDetailPrice;

    // Category: Women > Dress
    @FindBy(xpath = "//a[@href='#Women']")
    private WebElementFacade womenCategory;

    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
    private WebElementFacade womenDressSubcategory;

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElementFacade productsHeader;

    @FindBy(css = ".features_items .productinfo p")
    private List<WebElementFacade> productNames;

    public void clickProductsLink(){
        clickOn(productsLink);
    }

    public boolean isProductListVisible() {
        return !productCards.isEmpty();
    }

    public int productCount() {
        return productCards.size();
    }

    public void scrollToViewProductButton(){
        ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", firstViewProductLink);
    }

    public void clickViewProductLink(){
        clickOn(firstViewProductLink);
    }

    public boolean isProductDetailsDisplayed(){
        productDetailsSection.waitUntilVisible();
        return productDetailsSection.isDisplayed();
    }

    public String getProductName(){
        return productName.getText();
    }

    public String getProductCategory(){
        return productCategoryWomenTops.getText();
    }

    public String getProductAvailability(){
        return productAvailability.getText();
    }

    public String getProductCondition(){
        return productCondition.getText();
    }

    public String getProductBrand(){
        return productBrand.getText();
    }

    public boolean isCategorySectionDisplayed(){
        categorySection.waitUntilVisible();
        return categorySection.isDisplayed();
    }

    public boolean isReviewSectionDisplayed(){
        reviewSection.waitUntilVisible();
        return reviewSection.isDisplayed();
    }

    public void setProductQuantity(int qty){
        productQuantity.clear();
        typeInto(productQuantity, String.valueOf(qty));
    }

    public void addFirstProductToCart(){
        firstAddToCartButton.isEnabled();
        clickOn(firstAddToCartButton);
    }

    public boolean isCartModalDisplayed(){
        cartModal.waitUntilVisible();
        return cartModal.isDisplayed();
    }

    public String getCartModalTitleText(){
        return cartModalTitle.getText();
    }

    public String getCartModalSubtitleText(){
        return cartModalSubtitle.getText();
    }

    public void clickViewCartLink(){
        clickOn(viewCartLink);
    }

    public void clickContinueShoppingButton(){
        continueShoppingButton.isEnabled();
        clickOn(continueShoppingButton);
    }

    public void searchFor(String keyword) {
        typeInto(searchInput, keyword);

    }

    public void clickSearchButton(){
        clickOn(searchButton);
    }

    public boolean isSearchResultNotEmpty() {
        return !searchResults.isEmpty();
    }

    public int getSearchResultCount() {
        return searchResults.size();
    }

    public List<WebElementFacade> getAllProductPrices() {
        return productPrices;
    }

    public void addFirstProductToCartAndContinue() {
        clickOn(firstAddToCartButton);
        clickOn(waitFor(continueShoppingButton));
    }

    public int getUnitPrice() {
        // Example price: "Rs. 500"
        String priceText = productDetailPrice.getText().replaceAll("[^0-9]", "").trim();
        return Integer.parseInt(priceText);
    }

    public void filterByWomenDressCategory() {
        clickOn(womenCategory);
        clickOn(waitFor(womenDressSubcategory));
    }

    public String getFilterHeaderText() {
        return productsHeader.getText().trim(); // e.g., "WOMEN - DRESS PRODUCTS"
    }

    public List<String> getFilteredProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement product : productNames) {
            String name = product.getText().trim();
            if (!name.isEmpty()) {
                names.add(name);
            }
        }
        return names;
    }

    public void filterByCategory(String mainCategory, String subCategory) {
        WebElementFacade mainCategoryElement = find(By.xpath("//a[@href='#" + mainCategory + "']"));
        clickOn(mainCategoryElement);

        WebElementFacade subCategoryElement = find(By.xpath("//div[@id='Women']//a[contains(text(), '" + subCategory + "')]"));
        clickOn(waitFor(subCategoryElement));
    }
}
