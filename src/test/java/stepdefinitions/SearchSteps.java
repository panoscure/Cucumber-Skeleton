package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.PanoscureHomePage;
import utils.ConfigReader;
import utils.Logger;


public class SearchSteps {

    WebDriver driver = Hooks.getDriver();  // Static access
    PanoscureHomePage panoscurePage= new PanoscureHomePage(driver);


    @Given("I am on Panos page")
    public void i_am_on_panos_page() {
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        Logger.debug("This is a debug message");
        Logger.info("Everything is working fine");
        Logger.warning("Something might need attention");
        Logger.error("Something went wrong");
        Logger.critical("Critical failure occurred");
    }

    @When("I search for {string}")
    public void i_search_for(String term) {
        panoscurePage.enterSearchTerm(term);
    }


    @Then("I should be redirected to Panoscure home page and see {string}")
    public void i_should_see_expected_text(String expectedText) {
        String actual_text = panoscurePage.getMainText();
        panoscurePage.assertMainText(actual_text,expectedText);

        driver.quit();
    }

    @And("I refresh the page")
    public void iRefreshThePage() {
        panoscurePage.refreshCurrentPage();
    }
}
