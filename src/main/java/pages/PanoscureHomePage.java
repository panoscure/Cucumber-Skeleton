package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;


public class PanoscureHomePage {

    WebDriver driver;

    // Define top XPath constants here
    public String homeTextXPath = "(//span[@class='headertext1'])[1]";
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

    public void assertMainText(String actual_text, String expectedText) {
        assertEquals(actual_text, expectedText);
    }
}
