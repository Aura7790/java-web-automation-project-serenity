package org.example.pages;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends PageObject {
    @FindBy(css = ".fc-button-label")
    private WebElementFacade cookiesConsentBtn;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElementFacade signupLoginLink;

    public void clickOnCookiesConsent() {
        clickOn(cookiesConsentBtn);
    }

    public void clickOnSignupLoginLink(){
        clickOn(signupLoginLink);
    }
}
