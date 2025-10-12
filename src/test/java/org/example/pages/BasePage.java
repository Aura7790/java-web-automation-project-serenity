package org.example.pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {
    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }
}
