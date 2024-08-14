package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.AccountPage;
import tek.bdd.utility.SeleniumUtility;

public class UpdateUserInfoSteps extends SeleniumUtility {
    @Then("validate success toast message is displayed")
    public void validateSuccessToastMessageIsDisplayed() {
        boolean isToastMessageDisplayed = isElementDisplayed(AccountPage.TOAST_MESSAGE);
        Assert.assertTrue(isToastMessageDisplayed);
    }
    @Then("validate account name is {string}")
    public void validateAccountName(String accountName) {
        String actualAccountName = getElementText(AccountPage.ACCOUNT_USER_NAME);
        Assert.assertEquals(accountName,actualAccountName);
    }
}
