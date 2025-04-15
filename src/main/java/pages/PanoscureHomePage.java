package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PanoscureHomePage {

    WebDriver driver;

    // Define top XPath constants here
    public String homeTextXPath = "//h1[contains(text(),'System')]";
    public String searchBoxXPath = "//*[@id=\"sidebar\"]/form/p[1]/input";


    public PanoscureHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String term) {
        driver.findElement(By.xpath(searchBoxXPath)).sendKeys(term);
    }

    public String getMainText() {
        return driver.findElement(By.xpath(homeTextXPath)).getText();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }
}
