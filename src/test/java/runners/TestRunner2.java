package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/SearchPanoscure2.feature"
        },
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report-TestRunner2.html",
                "json:target/cucumber-reports/TestRunner2.json"
        },
        monochrome = true
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}
