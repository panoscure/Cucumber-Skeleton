package hooks;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;


public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverManager.initializeDriver("chrome");
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
