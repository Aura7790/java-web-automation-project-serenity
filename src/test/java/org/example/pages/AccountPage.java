package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {
    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElementFacade loggedInText;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElementFacade logoutLink;

    public String getLoggedInText(String username){
        return loggedInText.getText();
    }

    public void isLogoutLink(String element) {
        logoutLink.shouldContainOnlyText("Logout");
    }

    public void logout() {
        clickOn(logoutLink);
    }
}
