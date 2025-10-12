package org.example.features;

import org.junit.Test;

public class SearchTest extends BaseTest{
    @Test
    public void searchFunctionReturnsResults() {
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        searchSteps.searchForProduct("Dress");
        searchSteps.verifySearchResultsAreNotEmpty();
    }

    @Test
    public void searchForProductKeyword(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        searchSteps.searchForProduct("top");
        searchSteps.checkProductIsInResults("Blue Top");
    }

    @Test
    public void searchForProductFullName(){
        homeSteps.navigateToHomePage();
        productsSteps.openProductsPage();
        searchSteps.searchForProduct("Stylish Dress");
        searchSteps.checkProductIsInResults("Stylish Dress");
    }
}
