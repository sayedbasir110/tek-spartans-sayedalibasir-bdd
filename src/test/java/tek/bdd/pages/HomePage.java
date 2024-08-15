package tek.bdd.pages;

import org.openqa.selenium.By;

public class HomePage {

    public static final By SING_IN_LINK = By.id("signinLink");
    public static final By ACCOUNT_LINK = By.id("accountLink");
    public static final By SEARCH_BAR = By.id("searchInput");
    public static final By SEARCH_BTN = By.xpath("//button[@id='searchBtn']");
    public static final By PRODUCTS_NAME = By.xpath("//p[@class='products__name']");
    public static final By CART_BUTTON = By.xpath("//div[@id=\"cartBtn\"]/p");


}