package tek.bdd.pages;

import org.openqa.selenium.By;

public class ProductPage {
    public static final By PRODUCT_NAME = By.className("product__name");
    public static final By ADDED_TO_CART_MESSAGE = By.className("product__cart-exists");
    public static final By ADD_TO_CART_BUTTON = By.id("addToCartBtn");
}
