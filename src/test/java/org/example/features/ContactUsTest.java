package org.example.features;
import org.junit.Test;
import static org.example.utils.Constants.CONTACT_US_URL;

public class ContactUsTest extends BaseTest{

    @Test
    public void contactUsPageUrl(){
        contactUsSteps.openContactUsPage();
        contactUsSteps.checkContactUsPageUrl(CONTACT_US_URL);
    }

    @Test
    public void contactUsFormSubmitWithValidData(){
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
