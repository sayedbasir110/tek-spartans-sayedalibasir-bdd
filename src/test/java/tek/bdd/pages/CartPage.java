package tek.bdd.pages;

import org.openqa.selenium.By;

public class CartPage {
    public static final By CART_ITEMS = By.xpath("//a[@class='cart__item-product-name']");
    public static final By DELETE_ITEM_BTN = By.className("cart__item-delete");
    public static final By CART_EMPTY_TITLE = By.className("cart__empty-title");
}
