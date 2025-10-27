package org.example.features;
import org.example.utils.TestDataGenerator;
import org.junit.Test;
import static org.example.utils.Constants.USER_EMAIL;

public class RegisterTest extends BaseTest {

    TestDataGenerator dataGenerator = new TestDataGenerator();
    private final String uniqueName = dataGenerator.generateUniqueName();
    private final String uniqueEmail = dataGenerator.generateUniqueEmail();
    private final String uniquePassword = dataGenerator.generateUniquePassword();
    private final String signupHeading = "New User Signup!";
    private final String emptyFieldMessage = "please fill in this field";

    @Test
    public void signUpWithValidData(){
        // first part of the form
        loginSteps.navigateToRegisterLoginPage();
        registerSteps.checkSignupHeading(signupHeading);
        registerSteps.setUserName(uniqueName);
        registerSteps.setEmail(uniqueEmail);
        registerSteps.clickSignup();
        // second part of the form
        registerSteps.checkSignupForm("ENTER ACCOUNT INFORMATION");
        registerSteps.checkNameFieldText(uniqueName);
        registerSteps.checkEmailFieldText(uniqueEmail);
        registerSteps.setAccountInformation("titleMr", uniquePassword, "17", "July", "1900");
        registerSteps.setAddressInformation();
        registerSteps.clickCreateAccount();
        registerSteps.checkAccountCreatedMessage();
        registerSteps.clickContinue();
        loginSteps.userIsLoggedIn(uniqueName);
        loginSteps.logoutUser();
    }

    @Test
    public void signupWithExistentEmail(){
        loginSteps.navigateToRegisterLoginPage();
        registerSteps.checkSignupHeading(signupHeading);
        registerSteps.setUserName(uniqueName);
        registerSteps.setEmail(USER_EMAIL);
        registerSteps.clickSignup();
        registerSteps.checkEmailAlreadyExistsMessage("Email Address already exist!");
    }

    @Test
    public void signupWithEmptyName(){
        loginSteps.navigateToRegisterLoginPage();
        registerSteps.checkSignupHeading(signupHeading);
        registerSteps.setUserName("");
        registerSteps.setEmail(uniqueEmail);
        registerSteps.clickSignup();
        registerSteps.checkNameFieldEmptyMessage(emptyFieldMessage);
    }

    @Test
    public void signupWithEmptyEmail(){
        loginSteps.navigateToRegisterLoginPage();
        registerSteps.checkSignupHeading(signupHeading);
        registerSteps.setUserName(uniqueName);
        registerSteps.setEmail("");
        registerSteps.clickSignup();
        registerSteps.checkEmailFieldErrorMessage(emptyFieldMessage);
    }

    @Test
    public void signupWithInvalidEmailFormat() {
        loginSteps.navigateToRegisterLoginPage();
        registerSteps.checkSignupHeading(signupHeading);
        registerSteps.setUserName(uniqueName);
        registerSteps.setEmail("invalid-email");
        registerSteps.clickSignup();
        registerSteps.checkEmailFieldErrorMessage("please include an '@' in the email address");
    }
}
