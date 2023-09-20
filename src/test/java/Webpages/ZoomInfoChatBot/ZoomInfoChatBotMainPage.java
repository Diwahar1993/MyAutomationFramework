package Webpages.ZoomInfoChatBot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ZoomInfoChatBotMainPage {
    WebDriver driver;

    private static final String URL="https://recruitment.web-test.insent.ai/fe-assignment";

    public ZoomInfoChatBotMainPage(WebDriver driver){
        this.driver=driver;
        driver.get(URL);
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();

    }

    // Xpath identification
    @FindBy(xpath = "")
    WebElement Home;




    // Page Functions

    public void launchChatBot() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(Home));
        }

    }


