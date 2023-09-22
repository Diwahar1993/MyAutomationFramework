package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver) throws IOException {
       String baseUri =  System.getProperty("user.dir");
        TakesScreenshot ts = (TakesScreenshot) driver; // 'driver' is your WebDriver instance
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filepath = baseUri+"/src/Screenshots/";
        System.out.println("file path is "+filepath);
        String screenshotPath = filepath + System.currentTimeMillis() + ".png"; // Specify your screenshot directory
        File destination = new File(screenshotPath);
        FileUtils.copyFile(source, destination);
        System.out.println(screenshotPath);
        return screenshotPath;
    }

}
