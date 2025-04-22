package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;


public class Hooks {

    private static WebDriver driver;
    String executionMode = ConfigReader.getProperty("execution.mode");


    @Before
    public void setUp() throws MalformedURLException {
        driver = DriverManager.initializeDriver("chrome",executionMode);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
        }
    }

    // Static getters (leave these static!)
    public static WebDriver getDriver() {
        return driver;
    }


}
