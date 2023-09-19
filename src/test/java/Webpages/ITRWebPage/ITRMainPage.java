package Webpages.ITRWebPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ITRMainPage {
    WebDriver driver;

    private static final String URL="https://www.incometax.gov.in/iec/foportal/";

    public ITRMainPage(WebDriver driver){
        this.driver=driver;
        driver.get(URL);
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();

    }

    // Xpath identification
    @FindBy(xpath = "//li[@id='login']//a")
    WebElement login;


    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(login));
        login.click();
        driver.switchTo().alert().sendKeys("somekey");
        System.out.println(driver.switchTo().alert().getText());
        //driver.switchTo().alert().accept();

    }
}
