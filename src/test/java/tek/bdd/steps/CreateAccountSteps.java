package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.AccountPage;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomEmailGenerator;
import tek.bdd.utility.SeleniumUtility;

import javax.swing.text.Utilities;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateAccountSteps extends SeleniumUtility {

    @Then("validate user is in sign in page")
    public void validateUserIsInSignInPage() {
        String pageSubTitle = getElementText(SignInPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign in",pageSubTitle);
    }
    @Then("validate user is in sign Up page")
    public void validate_user_is_in_sign_up_page() {
        String pageSubTitle = getElementText(SignUpPage.PAGE_SUBTITLE);
        Assert.assertEquals("Sign Up",pageSubTitle);
    }

    @Then("validate user is in account page")
    public void validateUserIsInAccountPage() {
        String pageSubTitle = getElementText(AccountPage.PROFILE_PAGE_TITLE);
        Assert.assertEquals("Account page should contains Your Profile text",
                "Your Profile", pageSubTitle);
    }
    @Then("validate email address in account page matches with given email address")
    public void validateEmailAddressInAccountPageMatch() {
        String actualEmail = getElementText(AccountPage.PROFILE_EMAIL_TEXT);
        Assert.assertEquals("Email in Account page should match with email used in create account step",
                CommonSteps.emailToUse,actualEmail);
    }
    @Then("user should see error under each field")
    public void userShouldSeeErrorUnderEachField(DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMap();
        List<WebElement> errorElements = getElements(SignUpPage.FIELDS_ERROR_MESSAGES);
        Assert.assertEquals(expectedData.size(),errorElements.size());
        Map<String, String> actualErrors = new HashMap<>();
        for (WebElement element : errorElements){
            String text = element.getText();
            String key = text.split(" ")[0];
            actualErrors.put(key,text);
        }
        for (String key : expectedData.keySet()){
            Assert.assertEquals(expectedData.get(key),actualErrors.get(key));
        }
    }


}
