package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
import utils.WaitUtils;
import static org.testng.Assert.assertEquals;


public class PanoscureHomePage {

    WebDriver driver;

    // Define top XPath constants here
    public String homeTextXPath = "(//span[@class='headertext1'])[1]";
    public String searchBoxXPath = "//*[@id=\"sidebar\"]/form/p[1]/input";
    public String clickTabXPath(String tab_name){ return "//a[text()='"+ tab_name +"']";}


    public PanoscureHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String term) {
        //driver.findElement(By.xpath(searchBoxXPath)).sendKeys(term);
        WebElement searchBox = WaitUtils.waitForElement(driver, By.xpath(searchBoxXPath), Long.parseLong(ConfigReader.getProperty("wait.seconds")));
        searchBox.sendKeys(term);
    }

    public String getMainText() {
        WebElement text = WaitUtils.waitForElement(driver,By.xpath(homeTextXPath), Long.parseLong(ConfigReader.getProperty("wait.seconds")));
        return text.getText();
        //return driver.findElement(By.xpath(homeTextXPath)).getText();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    public void assertMainText(String actual_text, String expectedText) {
        assertEquals(actual_text, expectedText);
    }

    public void clickTab(String tab_name) {
        WebElement home_text = WaitUtils.waitForElement(driver,By.xpath(clickTabXPath(tab_name)), 10);
        home_text.click();
        //driver.findElement(By.xpath(clickTabXPath(tab_name))).click();
    }
}
