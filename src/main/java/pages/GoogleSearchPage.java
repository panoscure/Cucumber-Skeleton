package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    WebDriver driver;

    // Parametric XPaths
    public String searchBoxXPath = "//textarea[@name='q']";
    public String resultLinkXPath = "//a[contains(@href, 'panoscure.synology.me')]";

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String term) {
        driver.findElement(By.xpath(searchBoxXPath)).sendKeys(term + "\n");
    }

    public void clickResultLink() {
        driver.findElement(By.xpath(resultLinkXPath)).click();
    }
}