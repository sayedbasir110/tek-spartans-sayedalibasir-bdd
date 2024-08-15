package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountPage;
import tek.bdd.utility.SeleniumUtility;

public class UpdateUserInfoSteps extends SeleniumUtility {
    @Then("validate account name is {string}")
    public void validateAccountName(String accountName) {
        String actualAccountName = getElementText(AccountPage.ACCOUNT_USER_NAME);
        Assert.assertEquals(accountName,actualAccountName);
    }
    @Then("validate success toast message is {string}")
    public void validateSuccessToastMessage(String expectedToastMessage) {
        String actualToastMessage = getElementText(AccountPage.TOAST_MESSAGE);
        Assert.assertEquals(expectedToastMessage, actualToastMessage);
    }
//    @When("wait for {int} seconds")
//    public void waitForSeconds(Integer seconds) throws InterruptedException {
//            Thread.sleep(seconds*1000);
//    }


}
