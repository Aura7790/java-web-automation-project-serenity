package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ContactUsPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Contact us')]")
    private WebElementFacade contactUsLink;

    @FindBy(id = "contact-page")
    private WebElementFacade contactUsForm;

    @FindBy(xpath = "//input[@data-qa='name']")
    private WebElementFacade nameInput;

    @FindBy(xpath = "//input[@data-qa='email']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@data-qa='subject']")
    private WebElementFacade subjectInput;

    @FindBy(id = "message")
    private WebElementFacade messageInput;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    private WebElementFacade submitButton;

    @FindBy(css = "div.status.alert.alert-success")
    private WebElementFacade successMessage;

    public void clickContactUsLink(){
        clickOn(contactUsLink);
    }

    public boolean isContactUsFormDisplayed(){
        contactUsForm.waitUntilVisible();
        return contactUsForm.isDisplayed();
    }

    public void setNameField(String name) {
        typeInto(nameInput, name);
    }

    public void setEmailField(String email){
        typeInto(emailInput, email);
    }

    public void setSubjectField(String subject){
        typeInto(subjectInput, subject);
    }

    public void setMessageField(String message){
        typeInto(messageInput, message);
    }

    public void clickSubmitFormButtonAndHandleAlert(){
        clickOn(submitButton);
        // Handle browser alert after submission
        getDriver().switchTo().alert().accept();
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }
}
