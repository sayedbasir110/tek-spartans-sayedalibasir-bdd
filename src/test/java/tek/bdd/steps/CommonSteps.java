package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.SignInPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomPhoneNumberGenerator;
import tek.bdd.utility.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {
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
    @Then("validate user is in {string} page")
    public void validate_user_is_in_page(String pageSubTitle) {
        String titleXpath = "//h1[text()='"+ pageSubTitle +"']";
        String actualSubTitle = getElementText(By.xpath(titleXpath));
        Assert.assertEquals(pageSubTitle,actualSubTitle);
    }
    @When("user clear data and enter {string} in {string} field")
    public void user_clear_data_and_enter_in_field(String newValue, String field) {
        String fieldXpath = "//input[@name='"+ field + "']";
        String value = newValue.equalsIgnoreCase("random") ? RandomPhoneNumberGenerator.generateRandomPhoneNumber() : newValue;
        clearElementData(By.xpath(fieldXpath));
        sendKeysToElement(By.xpath(fieldXpath), value);
    }
}
