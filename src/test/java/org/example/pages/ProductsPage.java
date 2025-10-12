package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
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

    public boolean isCategorySectionDisplayed(){
        categorySection.waitUntilVisible();
        return categorySection.isDisplayed();
    }

    public boolean isReviewSectionDisplayed(){
        reviewSection.waitUntilVisible();
        return reviewSection.isDisplayed();
    }

    public void setProductQuantity(String qty){
        typeInto(productQuantity, qty);
    }

    public void addProductToCart(){
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

}
