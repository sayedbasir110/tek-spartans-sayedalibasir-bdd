package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.utility.SeleniumUtility;

public class SecurityTestSteps extends SeleniumUtility {

    @When("user click on sign in button")
    public void UserClickOnSignInButton() {
        clickOnElement(HomePage.SING_IN_LINK);
    }
    @When("User enters {string} and {string} and click on Login button")
    public void userEntersValidUsernameAndPasswordAndClickOnLoginButton(String username, String password) {
    sendKeysToElement(SignInPage.EMAIL_INPUT,username);
    sendKeysToElement(SignInPage.PASSWORD_INPUT,password);
    clickOnElement(SignInPage.LOGIN_BUTTON);
    }
    @Then("User should be able to see account link")
    public void UserShouldBeAbleToSeeAccountLink() {
        boolean isAccountLinkDisplayed = isElementDisplayed(HomePage.ACCOUNT_LINK);
        Assert.assertTrue(isAccountLinkDisplayed);
    }
    @When("User enters {string} and {string} and click on login button")
    public void userEntersInvalidCredentialsAndClickOnLoginButton(String username, String password) {
        sendKeysToElement(SignInPage.EMAIL_INPUT,username);
        sendKeysToElement(SignInPage.PASSWORD_INPUT,password);
        clickOnElement(SignInPage.LOGIN_BUTTON);

    }
    @Then("User should be able to see error {string}")
    public void userShouldBeAbleToSeeError(String errorMessage) {
        String actualErrorMessage = getElementText(SignInPage.ERROR_MESSAGE);
        Assert.assertEquals(errorMessage,actualErrorMessage);
    }

}
