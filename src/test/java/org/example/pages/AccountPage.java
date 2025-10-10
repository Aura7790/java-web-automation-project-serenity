package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountPage extends PageObject {
    private static final Logger log = LoggerFactory.getLogger(AccountPage.class);
    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElementFacade loggedInText;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElementFacade logoutLink;

    public String getLoggedInText(String username){
        return loggedInText.getText();
    }

    public void isLogoutLinkVisible(){
        logoutLink.waitUntilVisible();
    }

    public void checkLogoutLinkText(String element) {
        logoutLink.shouldContainOnlyText("Logout");
    }

    public void clickLogoutLink() {
        clickOn(logoutLink);
    }
}
