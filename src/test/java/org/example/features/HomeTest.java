package org.example.features;
import org.junit.Test;

public class HomeTest extends BaseTest{

    @Test
    public void checkLogoIsDisplayedOnHomePage() {
        homeSteps.acceptCookies();
        homeSteps.checkLogoOnHomePage();
    }
}
