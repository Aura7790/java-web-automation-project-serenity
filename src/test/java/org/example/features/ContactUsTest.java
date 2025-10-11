package org.example.features;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.example.steps.ContactUsSteps;
import org.example.steps.HomeSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
public class ContactUsTest {
    private static final Logger log = LoggerFactory.getLogger(ContactUsTest.class);
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private ContactUsSteps contactUsSteps;

    @Before
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test
    public void contactUsPageUrl(){
        homeSteps.navigateToHomePage();
        contactUsSteps.openContactUsPage();
        String contactUsUrl = "https://automationexercise.com/contact_us";
        contactUsSteps.checkContactUsPageUrl(contactUsUrl);
    }

    @Test
    public void contactUsFormSubmitWithValidData(){
        homeSteps.navigateToHomePage();
        contactUsSteps.openContactUsPage();
        contactUsSteps.isContactUsFormVisible();
        contactUsSteps.fillInNameField("John Doe");
        contactUsSteps.fillInEmailField("john_doe01@email.com");
        contactUsSteps.fillInSubjectField("Complaint - Order was not delivered");
        contactUsSteps.fillInMessageField("Hello! It has been passed more than 2 weeks and did not received my order. Please check, order #895634");
        contactUsSteps.submitFormAndHandleAlert();
        contactUsSteps.checkSubmitFormSuccessMessage("Success! Your details have been submitted successfully.");
    }
}
