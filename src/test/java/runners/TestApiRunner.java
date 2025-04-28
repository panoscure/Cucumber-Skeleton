package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {
                "src/test/resources/features/api.feature"
        },
        glue = {"stepdefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report-ApiRunner.html",
                "json:target/cucumber-reports/ApiRunner.json"
        },
        monochrome = true
)
public class TestApiRunner extends AbstractTestNGCucumberTests {
}