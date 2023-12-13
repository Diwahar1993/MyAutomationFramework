package Webpages.Amazon;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class LoginPage {
private WebDriver driver;
private String basePath = System.getProperty("user.dir");
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get("https://www.amazon.in/");

    }

    // element identification
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement loginNavigate;

    public void isLoginPageLoaded(){
        System.out.println(driver.getTitle());
            Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in",driver.getTitle());


    }
    public void clickonLogin() throws IOException {
      Actions actions = new Actions(driver);
        loginNavigate.click();
        actions.moveToElement(loginNavigate).click();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File file = new File(basePath+"/screenshotAmazon.png");
        FileUtils.copyFile(screenshot,file);
    }
}
