package org.example.features;

import net.serenitybdd.annotations.WithTag;
import org.junit.Test;

public class HomeTest extends BaseTest{

    @Test
    @WithTag(name = "type", value = "smoke")
    public void checkLogoIsDisplayedOnHomePage() {
        homeSteps.acceptCookies();
        homeSteps.checkLogoOnHomePage();
    }
}
