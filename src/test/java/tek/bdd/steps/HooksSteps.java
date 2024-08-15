package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tek.bdd.pages.AccountPage;
import tek.bdd.utility.RandomEmailGenerator;
import tek.bdd.utility.RandomPhoneNumberGenerator;
import tek.bdd.utility.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {

    @Before
    public void beforeEachScenario() {
        setupBrowser();
    }

    @After
    public void afterEachScenario (Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = takeScreenShot();
            scenario.attach(screenshot,"image/png","failed_scenario");
        }
        quitBrowser();
    }
//    @After("@UserStory6")
//    public void resetPassword () throws InterruptedException {
//        CommonSteps commonSteps = new CommonSteps();
//        Thread.sleep(5000);
//        commonSteps.userEnterInField("Johndoe$123","Previous Password");
//        commonSteps.userEnterInField("John@123", "New Password");
//        commonSteps.userEnterInField("John@123", "Confirm Password");
//        commonSteps.userClickOnButton("Change Password");
//    }


}
