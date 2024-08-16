package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.CartPage;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ProductPage;
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
        List<WebElement> products= getElements(HomePage.ALL_SEARCH_RESULT_TITLE);
        Assert.assertFalse(products.isEmpty());
        for (WebElement element : products){
            Assert.assertTrue(element.getText().toLowerCase().contains(expectedText.toLowerCase()));
        }
    }
    @When("user click on a product")
    public void userClickOnAProduct() {
        List<WebElement> products = getElements(HomePage.ALL_SEARCH_RESULT_TITLE);
        clickOnElement(products.get(0));
    }
    @Then("validate user is in product page")
    public void validateUserIsInProductPage() {
        boolean isProductNameDisplayed = isElementDisplayed(ProductPage.PRODUCT_NAME);
        Assert.assertTrue(isProductNameDisplayed);
    }
    @When("user click on Add to Cart button")
    public void userClickOnAddToCartButton() {
        clickOnElement(ProductPage.ADD_TO_CART_BUTTON);
    }
    @Then("validate item is added to the cart")
    public void validateItemIsAddedToTheCart() {
        boolean isMessageDisplayed = isElementDisplayed(ProductPage.ADDED_TO_CART_MESSAGE);
        Assert.assertTrue(isMessageDisplayed);
    }
    @When("user click on Cart button")
    public void userClickOnCartButton() {
        clickOnElement(HomePage.CART_BUTTON);
    }
    @Then("validate {int} item is in the cart")
    public void validateOnlyOneItemIsInTheCart(int expectedNumber) {
        List<WebElement> itemsInCart = getElements(CartPage.CART_ITEMS);
        Assert.assertEquals(expectedNumber,itemsInCart.size());
    }
    @When("user delete item from the cart")
    public void userDeleteItemFromTheCart() {
        clickOnElement(CartPage.DELETE_ITEM_BTN);
    }
    @Then("validate item is deleted from the cart")
    public void validateItemIsDeletedFromTheCart() {
        String emptyCartTitle = getElementText(CartPage.CART_EMPTY_TITLE);
        Assert.assertEquals("Your Shopping Cart is Empty", emptyCartTitle);
    }
}

