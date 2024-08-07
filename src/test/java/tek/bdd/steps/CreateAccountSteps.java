package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.AccountPage;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomEmailGenerator;
import tek.bdd.utility.SeleniumUtility;

import javax.swing.text.Utilities;
import java.util.Map;

public class CreateAccountSteps extends SeleniumUtility {
    private static String emailToUse;
    @Then("validate user is in sign in page")
    public void validateUserIsInSignInPage() {
        String pageSubTitle = getElementText(SignInPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign in",pageSubTitle);
    }
    @When("user enter {string} and {string}  and {string}")
    public void userEnterNewAccountInfo(String name, String email, String password) {
        emailToUse = email.equalsIgnoreCase("random") ?
                RandomEmailGenerator.generateRandomEmail() : email;
        sendKeysToElement(SignUpPage.NAME_INPUT,name);
        sendKeysToElement(SignUpPage.EMAIL_INPUT,emailToUse);
        sendKeysToElement(SignUpPage.PASSWORD_INPUT,password);
        sendKeysToElement(SignUpPage.CONFIRM_PASSWORD_INPUT,password);
    }

    @Then("validate user is in account page")
    public void validateUserIsInAccountPage() {
        String pageSubTitle = getElementText(AccountPage.PROFILE_PAGE_TITLE);
        Assert.assertEquals("Account page should contains Your Profile text",
                "Your Profile", pageSubTitle);
    }
    @Then("validate email address in account page match")
    public void validateEmailAddressInAccountPageMatch() {
        String actualEmail = getElementText(AccountPage.PROFILE_EMAIL_TEXT);
        Assert.assertEquals("Email in Account page should match with email used in create account step",
                emailToUse,actualEmail);
    }
    @Then("user should see error under each field")
    public void user_should_see_error_under_each_field(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap();
        String nameError = data.get("nameError");
        String emailError = data.get("emailError");
        String passwordError = data.get("passwordError");
        String confirmPasswordError = data.get("confirmPasswordError");
        String actualNameError = getElementText(SignUpPage.NAME_ERROR);
        String actualEmailError = getElementText(SignUpPage.EMAIL_ERROR);
        String actualPasswordError = getElementText(SignUpPage.PASSWORD_ERROR);
        String actualConfirmPasswordError = getElementText(SignUpPage.CONFIRM_PASSWORD_ERROR);
        Assert.assertEquals(nameError,actualNameError);
        Assert.assertEquals(emailError,actualEmailError);
        Assert.assertEquals(passwordError,actualPasswordError);
        Assert.assertEquals(confirmPasswordError,actualConfirmPasswordError);
    }


}
