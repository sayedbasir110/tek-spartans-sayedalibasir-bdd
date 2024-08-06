package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.SignUpPage;
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
        String errorXpath = "//div[text()='"+ error +"']";
        String errorText = getElementText(By.xpath(errorXpath));
        Assert.assertEquals(error,errorText);
    }
    @Then("validate user is in {string} page")
    public void validate_user_is_in_page(String pageSubTitle) {
        String titleXpath = "//h1[text()='"+ pageSubTitle +"']";
        String actualSubTitle = getElementText(By.xpath(titleXpath));
        Assert.assertEquals(pageSubTitle,actualSubTitle);
    }
}
