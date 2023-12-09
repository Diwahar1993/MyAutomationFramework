package Tests.OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SampleWebsiteAutomate {

    static void takeScreenShot(WebDriver driver) throws IOException {
        String fileName = "screenshot" + System.currentTimeMillis() + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define a standard directory for storing screenshots
        String directoryPath = "/Users/diwaharpandian/MyGIT/MyAutomationFramework/src/test/java/Modules/Screenshots";
        File targetFile = new File(directoryPath, fileName);

        // Create the directory if it doesn't exist
        FileUtils.forceMkdirParent(targetFile);

        // Copy the screenshot to the target file
        FileUtils.copyFile(screenshot, targetFile);


    }

    public static void main(String[] args) throws IOException {




        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        //xpath
        // login page
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password' and @placeholder = 'Password' ]"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(username));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        submitButton.click();
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().back();
        System.out.println(driver.getTitle());
        takeScreenShot(driver);






    }
}
