package org.example.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://automationexercise.com/")
public class HomePage extends BasePage {
    @FindBy(css = "div.logo.pull-left")
    private WebElementFacade logo;

    @FindBy(css = ".fc-button-label")
    private WebElementFacade cookiesConsentBtn;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    private WebElementFacade signupLoginLink;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/']")
    private WebElementFacade homeNavigation;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/contact_us']")
    private WebElementFacade contactUsNavigation;

    @FindBy(css = "ul.nav.navbar-nav > li > a[href='/products']")
    private WebElementFacade productsNavigation;

    @FindBy(css = "div.footer-widget")
    private WebElementFacade footerSection;

    @FindBy(css = "input#susbscribe_email")
    private WebElementFacade subscriptionEmailField;

    @FindBy(css = "button#subscribe")
    private WebElementFacade subscribeButton;

    @FindBy(css = "div#success-subscribe")
    private WebElementFacade subscriptionSuccessMessage;

    public boolean isLogoVisible() {
        return logo.isDisplayed();
    }

    public boolean isCookiesConsentVisible(){
        return cookiesConsentBtn.isVisible();
    }

    public void clickOnCookiesConsent() {
        clickOn(cookiesConsentBtn);
    }

    public void clickOnSignupLoginLink(){
        clickOn(signupLoginLink);
    }

    public String getHomePageTitle(){
        return getDriver().getTitle();
    }

    public boolean isNavigationMenuVisible() {
        return homeNavigation.isVisible() &&
                contactUsNavigation.isVisible() &&
                productsNavigation.isVisible();
    }

    public boolean isFooterVisible() {
        return footerSection.isVisible();
    }

    public void setSubscribeEmailField(String email){
        typeInto(subscriptionEmailField, email);
    }

    public void clickOnSubscribeButton() {
        clickOn(subscribeButton);
    }

    public boolean isSubscriptionSuccessVisible() {
        return subscriptionSuccessMessage.isVisible();
    }

}
