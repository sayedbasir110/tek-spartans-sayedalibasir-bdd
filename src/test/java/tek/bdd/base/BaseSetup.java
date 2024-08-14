package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import tek.bdd.browsers.BaseBrowser;
import tek.bdd.browsers.ChromeBrowser;
import tek.bdd.browsers.EdgeBrowser;
import tek.bdd.browsers.FireFoxBrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
    private static final Logger logger = LogManager.getLogger(BaseSetup.class);
    private static WebDriver driver;
    private Properties properties;
    public BaseSetup() {
        //System.getProperty("user.dir") return the locator of your project.
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";
            logger.info("Reading config file" + configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            throw new RuntimeException("Something wrong with Config file", ex);
        }
    }
    public void setupBrowser () {
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        logger.info("Running on browser {} and isHeadless {}",browserType, isHeadless);
        BaseBrowser browser;
        if (browserType.equalsIgnoreCase("chrome")) browser = new ChromeBrowser();
        else if (browserType.equalsIgnoreCase("edge")) browser = new EdgeBrowser();
        else if (browserType.equalsIgnoreCase("firefox")) browser = new FireFoxBrowser();
        else throw new RuntimeException("Wrong browser type, choose between chrome, firefox or edge");
        driver = browser.openBrowser(isHeadless);

        String url = properties.getProperty("ui.url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void quitBrowser() {
        if (driver != null) driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
