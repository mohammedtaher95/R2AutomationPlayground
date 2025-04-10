package utilities;

import driverfactory.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ScreenshotManager {

    static String screenshotsDirectoryPath = "./screenshots";
    private static final File screenshotsDirectory = new File(screenshotsDirectoryPath);

    private ScreenshotManager() {

    }

    public static Path captureScreenshot(Driver driver, String screenshotName) {

        if (!screenshotsDirectory.exists()) {
            boolean created = screenshotsDirectory.mkdirs();
            if (created) {
                System.out.println("Screenshots Directory Created");
            }
        }

        Path destination = Paths.get("./screenshots", screenshotName + ".jpg");
        byte[] byteArray = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(destination, byteArray, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println("Unable to capture Screenshot " + e.getMessage());
        }
        return destination;
    }
}
