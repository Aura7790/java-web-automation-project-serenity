package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage extends PageObject {
    public String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

    public String getValidationMessageFor(WebElementFacade element) {
        return getJavascriptExecutorFacade().executeScript("return arguments[0].validationMessage;", element).toString();
    }
}
