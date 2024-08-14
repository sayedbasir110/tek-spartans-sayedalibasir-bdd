package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtility;

public class SetupTestSteps extends SeleniumUtility {

    @Then("validate top left corner is TEKSCHOOL")
    public void validateTopLeftCornerLogo() {
        String topLeftCornerText = getElementText(By.className("top-nav__logo"));
        Assert.assertEquals("TEKSCHOOL" , topLeftCornerText);
    }

    @Then("validate Sign in button is Enabled")
    public void validateSignInButtonEnabled() {
        boolean isSignInBtnEnabled = isElementEnabled(HomePage.SING_IN_LINK);
        Assert.assertTrue(isSignInBtnEnabled);
    }






}
