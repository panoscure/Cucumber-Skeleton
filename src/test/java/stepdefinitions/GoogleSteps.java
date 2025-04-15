package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSteps {

    WebDriver driver;

    @Given("the user opens the Google homepage")
    public void the_user_opens_google_homepage() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String term) {
        driver.findElement(By.name("q")).sendKeys(term + Keys.ENTER);

    }

    @Then("the search results are displayed")
    public void search_results_displayed() {
        assert driver.getTitle().contains("OpenAI");
        driver.quit();
    }
}