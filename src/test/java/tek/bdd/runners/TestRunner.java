package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/", // Directory for Feature file
        glue = "tek.bdd.steps",
        dryRun = false, //Package for all the steps
        plugin = {
                "html:target/cucumber_report/index.html"
        }
)
public class TestRunner {
}
