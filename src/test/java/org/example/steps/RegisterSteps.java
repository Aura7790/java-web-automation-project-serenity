package org.example.steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class RegisterSteps extends BaseSteps {

    @Step
    public void checkSignupHeading(String headingText){
        Assert.assertEquals(headingText, registerPage.getSignupHeadingText());
    }

    @Step
    public void setUserName(String name){
        registerPage.setNameField(name);
    }

    @Step
    public void setEmail(String emailAddress){
        registerPage.setEmailField(emailAddress);
    }

    @Step
    public void clickSignup(){
        registerPage.clickSignupButton();
    }

    @Step
    public void checkSignupForm(String formText){
        registerPage.isSignupFormVisible();
        Assert.assertEquals(formText, registerPage.getSignupFormText());
    }

    @Step
    public void checkNameFieldText(String name){
        Assert.assertEquals(registerPage.getNameFieldText(), name);
    }

    @Step
    public void checkEmailFieldText(String email){
        Assert.assertEquals(registerPage.getEmailFieldText(), email);
    }

    @Step
    public void setAccountInformation(String title, String password, String day, String month, String year){
        registerPage.fillAccountInformation(title, password, day, month, year);
    }

    @Step
    public void setAddressInformation(){
        registerPage.fillAddressInformation("John", "Doe", "Example Ex.", "1234 Street", "12",
                "United States", "California", "Los Angeles", "2004", "456789");
    }

    @Step
    public void clickCreateAccount(){
        registerPage.clickCreateAccountButton();
    }

    @Step
    public void checkAccountCreatedMessage(){
        registerPage.isAccountCreatedMessageVisible();
        Assert.assertEquals("ACCOUNT CREATED!", registerPage.getAccountCreatedText());
    }

    @Step
    public void clickContinue(){
        registerPage.clickContinueButton();
    }
}
