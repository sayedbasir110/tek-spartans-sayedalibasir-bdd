package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class SearchForProductsSteps extends SeleniumUtility {
    @When("user enter {string} in search bar")
    public void userEnterInSearchBar(String searchText) {
        sendKeysToElement(HomePage.SEARCH_BAR, searchText);
    }
    @When("user click on search button")
    public void userClickOnSearchButton() {
        clickOnElement(HomePage.SEARCH_BTN);
    }
    @Then("validate displayed products contains {string} in their title")
    public void validateDisplayedProducts(String expectedText) {
        List<WebElement> products= getElements(HomePage.PRODUCTS_NAME);
        for (WebElement element : products){
            Assert.assertTrue(element.getText().toLowerCase().contains(expectedText.toLowerCase()));
        }
    }
}

