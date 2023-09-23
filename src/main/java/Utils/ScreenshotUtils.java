package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenShot(WebDriver webDriver) {
        String imageName = "IMG_"+System.currentTimeMillis() + ".png";
        File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String baseUri =  System.getProperty("user.dir");
        String filepath = baseUri+"/Report/";
        File targetFile = new File(filepath, imageName);
        try {
            FileUtils.copyFile(screenshotFile, targetFile);
        } catch (IOException e) {
        }
        return targetFile.getName();
    }

}
