package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomEmailGenerator;
import tek.bdd.utility.RandomPhoneNumberGenerator;
import tek.bdd.utility.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {
    static String emailToUse;
    static String phoneNumberToUse;
    @When("user click on {string} link")
    public void userClickOnLink(String linkText) {
        clickOnElement(By.linkText(linkText));
    }
    @When("user click on {string} button")
    public void userClickOnButton(String buttonText) {
        String buttonXpath = "//button[text()='" + buttonText + "']";
        clickOnElement(By.xpath(buttonXpath));
    }
    @Then("user should see error {string}")
    public void userShouldSeeError(String error) {
        String errorText = getElementText(SignInPage.ERROR_MESSAGE);
        Assert.assertEquals(error,errorText);
    }
    @When("user enter {string} in {string} field")
    public void userEnterInField(String newValue, String field) {
        String fieldXpath = "//label[text()='"+ field +"']/..//input";
        if (newValue.equalsIgnoreCase("random phone number")) {
            phoneNumberToUse = RandomPhoneNumberGenerator.generateRandomPhoneNumber();
            sendKeysToElement(By.xpath(fieldXpath), phoneNumberToUse);
        }
        else if (newValue.equalsIgnoreCase("random email address")) {
            emailToUse = RandomEmailGenerator.generateRandomEmail();
            sendKeysToElement(By.xpath(fieldXpath), emailToUse);
        }
        else sendKeysToElement(By.xpath(fieldXpath), newValue);
    }
    @Then("user should be able to see {string} link")
    public void userShouldSeeLink (String linkName){
        boolean isLinkDisplayed = isElementDisplayed(By.linkText(linkName));
        Assert.assertTrue(isLinkDisplayed);
    }

}
