package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomEmailGenerator;
import tek.bdd.utility.SeleniumUtility;

import javax.swing.text.Utilities;

public class CreateAccountSteps extends SeleniumUtility {

    @When("User click on Sign in button")
    public void userClickOnSignInButton() {
        clickOnElement(HomePage.SING_IN_LINK);
    }
    @Then("Validate user is in Sign in page")
    public void validateUserIsInSignInPage() {
        String pageSubtitle = getElementText(SignInPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign in", pageSubtitle);
    }
    @When("User click on Create New Account button")
    public void userClickOnCreateNewAccountButton() {
        clickOnElement(SignInPage.CREATE_NEW_ACCOUNT);
    }
    @Then("Validate user is in Sign Up page")
    public void validateUserIsInSignUpPage() {
        String pageSubtitle = getElementText(SignUpPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign Up", pageSubtitle);
    }
    @When("User enter new account information and click on Sign Up button")
    public void userEnterNewAccountInformationAndClickOnSignUpButton() {
        sendKeysToElement(SignUpPage.NAME_INPUT, "Name");
        sendKeysToElement(SignUpPage.EMAIL_INPUT, RandomEmailGenerator.generateRandomEmail());
        sendKeysToElement(SignUpPage.PASSWORD_INPUT, "Password@123");
        sendKeysToElement(SignUpPage.CONFIRM_PASSWORD_INPUT, "Password@123");
        clickOnElement(SignUpPage.SIGN_UP_BTN);
    }
    @Then("Validate new account created")
    public void validateNewAccountCreated() {
        boolean isProfileImageDisplayed = isElementDisplayed(SignUpPage.PROFILE_IMAGE);
        Assert.assertTrue(isProfileImageDisplayed);
    }

}
