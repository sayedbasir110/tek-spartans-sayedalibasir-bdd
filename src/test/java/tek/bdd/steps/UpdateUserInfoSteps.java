package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.AccountPage;
import tek.bdd.utility.SeleniumUtility;

public class UpdateUserInfoSteps extends SeleniumUtility {
    @Then("validate success toast message is displayed")
    public void validate_success_toast_message_is_displayed() {
        boolean isToastMessageDisplayed = isElementDisplayed(AccountPage.TOAST_MESSAGE);
        Assert.assertTrue(isToastMessageDisplayed);
    }
}
