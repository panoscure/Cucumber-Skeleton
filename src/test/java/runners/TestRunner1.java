package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/SearchPanoscure.feature"
        },
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report-TestRunner1.html",
                "json:target/cucumber-reports/TestRunner1.json"
        },
        monochrome = true
)
public class TestRunner1 extends AbstractTestNGCucumberTests {
}
