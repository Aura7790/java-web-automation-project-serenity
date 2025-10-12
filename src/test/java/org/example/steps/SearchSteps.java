package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class SearchSteps extends BaseSteps{

    @Step
    public void searchForProduct(String keyword) {
        productsPage.searchFor(keyword);
        productsPage.clickSearchButton();
    }

    @Step
    public void verifySearchResultsAreNotEmpty() {
        Assert.assertTrue(productsPage.isSearchResultNotEmpty());
        Assert.assertNotEquals(0, productsPage.getSearchResultCount());
        System.out.println("Search results found: " + productsPage.getSearchResultCount());
    }

    @Step
    public void checkProductIsInResults(String productName){
        Assert.assertTrue("The product " + productName + " was not found in the list. ", searchResultsPage.isProductInList(productName));
    }
}
