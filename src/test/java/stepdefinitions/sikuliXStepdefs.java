package stepdefinitions;

import io.cucumber.java.en.And;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import utils.ConfigReader;
import utils.Generic;
import utils.Logger;
import utils.sikuliX;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class sikuliXStepdefs {
    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int wait) throws InterruptedException {
        Generic.delay(wait);
    }

    @And("I click the video")
    public void iClickTheVideo() throws FindFailed, InterruptedException {
        String projectRoot = System.getProperty("user.dir");
        // Create a SikuliX Screen object
        // Get and clean the relative path from properties
        String relativePath = ConfigReader.getProperty("file.assert.path").trim(); // trims invisible characters

        // Use Paths.get to safely build the full image path
        Path imagePath = Paths.get(projectRoot, relativePath, "Capture.PNG").toAbsolutePath().normalize();

        // Log the full path
        Logger.info("Image path resolved to: " + imagePath);

        Screen screen = new Screen();
        // Define the path to the button image
        //String buttonImagePath1 = projectRoot + File.separator + ConfigReader.getProperty("file.assert.path")+"Capture.PNG";
        // Create a SikuliX Pattern object for the button image with a percentage configuration
        String imagePathStr = imagePath.toAbsolutePath().toString().replace("\\", "/");
        Pattern buttonPattern = new Pattern(imagePathStr).similar(0.7f);

        try {
            // Click the button using SikuliX
            screen.click(buttonPattern);
            Generic.delay(2);
            System.out.println("Button clicked successfully!");

        } catch (Exception e) {
            System.out.println("Button not found or unable to click: " + e.getMessage());
        }
        sikuliX getText = new sikuliX();
        Path screenshotFolderPath = Paths.get(projectRoot, relativePath).toAbsolutePath().normalize();

        String screenshotPathStr = screenshotFolderPath.toString().replace("\\", "/");
        Logger.info("Screenshot folder resolved to: " + screenshotPathStr);
        String textFromScreenshot = getText.takeScreenshotReturnText(screenshotPathStr);

        //text_from_screenshot = getText.takeScreenshotReturnText(projectRoot + File.separator + ConfigReader.getProperty("file.assert.path"));
        Logger.info(textFromScreenshot);
    }
}
