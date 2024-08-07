package tek.bdd.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    // method to return WebDriverWait for explicit wait
    private WebDriverWait getWait() {
        return  new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }
    // method to wait for visibility of an element and return it
    private WebElement waitForVisibility (By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // method to click on a given locator
    public void clickOnElement (By locator){
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    // method to send string to a given locator
    public void sendKeysToElement (By locator, String value) {
        waitForVisibility(locator).sendKeys(value);
    }
    // method to return text of an element
    public String getElementText (By locator){
        return waitForVisibility(locator).getText();
    }
    public boolean  isElementEnabled(By locator){
        return waitForVisibility(locator).isEnabled();
    }
    public boolean isElementDisplayed(By locator) {
        return waitForVisibility(locator).isDisplayed();
    }
    public List<WebElement> getElements(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public byte[] takeScreenShot () {
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }


}
