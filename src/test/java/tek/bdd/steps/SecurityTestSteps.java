package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {


    @When("user enters {string} and {string}")
    public void user_enters_and(String email, String password) {
        sendKeysToElement(SignInPage.EMAIL_INPUT,email);
        sendKeysToElement(SignInPage.PASSWORD_INPUT,password);
    }
    @Then("user should be able to see account link")
    public void user_should_be_able_to_see_account_link() {
        boolean isAccountLinkDisplayed = isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isAccountLinkDisplayed);
    }


}
