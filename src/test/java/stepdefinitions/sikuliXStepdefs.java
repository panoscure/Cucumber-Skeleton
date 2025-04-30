package stepdefinitions;

import io.cucumber.java.en.And;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import utils.ConfigReader;
import utils.Generic;
import utils.Logger;
import utils.sikuliX;

public class sikuliXStepdefs {
    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int wait) throws InterruptedException {
        Generic.delay(wait);
    }

    @And("I click the video")
    public void iClickTheVideo() throws FindFailed, InterruptedException {
        // Create a SikuliX Screen object
        Screen screen = new Screen();
        // Define the path to the button image
        String buttonImagePath1 = ConfigReader.getProperty("file.assert.path")+"Capture.PNG";
        // Create a SikuliX Pattern object for the button image with a percentage configuration
        Pattern buttonPattern = new Pattern(buttonImagePath1).similar(0.7f); // Adjust the similarity percentage as needed

        try {
            // Click the button using SikuliX
            screen.click(buttonPattern);
            Generic.delay(2);
            System.out.println("Button clicked successfully!");

        } catch (Exception e) {
            System.out.println("Button not found or unable to click: " + e.getMessage());
        }
        sikuliX getText = new sikuliX();
        String text_from_screenshot;
        text_from_screenshot = getText.takeScreenshotReturnText(ConfigReader.getProperty("file.assert.path"));
        Logger.info(text_from_screenshot);
    }
}
