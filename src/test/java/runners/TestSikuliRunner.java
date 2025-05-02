package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/sikuliX_example.feature"
        },
        glue = {"stepdefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report-TestSikuliRunner.html",
                "json:target/cucumber-reports/TestSikuliRunner.json"
        },
        monochrome = true
)
public class TestSikuliRunner extends AbstractTestNGCucumberTests {
}
