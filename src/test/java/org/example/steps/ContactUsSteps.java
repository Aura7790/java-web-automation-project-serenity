package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.example.pages.ContactUsPage;
import org.example.pages.ProductsPage;
import org.junit.Assert;

public class ContactUsSteps extends ScenarioSteps {
    private ContactUsPage contactUsPage;
    private ProductsPage productsPage;

    @Step
    public void openContactUsPage(){
        contactUsPage.clickContactUsLink();
    }

    @Step
    public void checkContactUsPageUrl(String url){
        Assert.assertEquals(productsPage.getCurrentUrl(), url);
    }

    @Step
    public void isContactUsFormVisible(){
        Assert.assertTrue(contactUsPage.isContactUsFormDisplayed());
    }

    @Step
    public void fillInNameField(String name){
        contactUsPage.setNameField(name);
    }

    @Step
    public void fillInEmailField(String email){
        contactUsPage.setEmailField(email);
    }

    @Step
    public void fillInSubjectField(String subject){
        contactUsPage.setSubjectField(subject);
    }

    @Step
    public void fillInMessageField(String message){
        contactUsPage.setMessageField(message);
    }

    @Step
    public void submitFormAndHandleAlert(){
        contactUsPage.clickSubmitFormButtonAndHandleAlert();
    }

    @Step
    public void checkSubmitFormSuccessMessage(String expectedMessage){
        Assert.assertEquals(contactUsPage.getSuccessMessageText(), expectedMessage);
    }
}
