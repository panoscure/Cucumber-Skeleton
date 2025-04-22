package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/searchPanoscure2.feature"
        },
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber.json"
        },
        monochrome = true
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}