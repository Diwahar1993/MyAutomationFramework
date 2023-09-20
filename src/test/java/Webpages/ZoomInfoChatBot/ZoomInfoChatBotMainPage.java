package Webpages.ZoomInfoChatBot;

import Utils.ExtentReportsManager;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class ZoomInfoChatBotMainPage {
    WebDriver driver;
    private ExtentTest test; // ExtentTest instance for logging

    private static final String URL="https://recruitment.web-test.insent.ai/fe-assignment";

    public ZoomInfoChatBotMainPage(WebDriver driver){
        this.driver=driver;
        driver.get(URL);
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();

    }

    // Xpath identification
    @FindBy(xpath = "//div[@id='hs-eu-policy-wording']/p")
    WebElement policyWording;
    @FindBy(xpath = "//a[@id='hs-eu-confirmation-button']")
    WebElement acceptButton;

    @FindBy(xpath ="//div[@id='insent-popup-content']")
    WebElement instantPopUpWelcomeMessage;

    @FindBy(xpath ="//div[@id='insent-launcher-icon']")
    WebElement instantPopUpIcon;

    @FindBy(xpath ="//iframe[@id='insent-iframe']")
    WebElement chatIframe;

    @FindBy(xpath = "//div[@id='insent-popup-card-close']")
    WebElement instantPopCloseIcon;

    @FindBy(xpath="//div[@id='insent-launcher-icon']")
    WebElement insentLauncherIcon;

    @FindBy(xpath ="//div[@class='sc-iybRtq iOhcFq']")
    WebElement unreadMessageNotification;

@FindBy(xpath = "//div[@id='insent-popup-message-detail']")
WebElement insentPopUpMessageDetails;

@FindBy(xpath ="//input[@name='email']")
WebElement emailInput;

@FindBy(xpath = "//button[@class='sc-ckVGcZ gRuMQg']")
WebElement emailSubmitButton;

@FindBy(xpath = "//div[@class='sc-iwsKbI cWzUpN' and contains(text(), 'How do you know about Zoominfo?')]")
WebElement howDoYouKnowZoomDefault;

    String xpath = "//div[@class='sc-kEYyzF faNzMh' and contains(text(), '{message}')]";






    // Page Functions



        public String getTitle(){
       return driver.getTitle();
        }

        public String readPolicyWording(){
            return policyWording.getText();
        }
        public void acceptPolicy(){
            acceptButton.click();
        }
        public String getInstantPopUpMessage(){

            switchToChatBotFrame();
            System.out.println(driver.getTitle());

            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));

            wait.until(ExpectedConditions.visibilityOf(instantPopUpWelcomeMessage));

            return instantPopUpWelcomeMessage.getText();
        }

        public void hoverToCloseIconAndClick(){
            Actions action = new Actions(driver);
            action.moveToElement(insentPopUpMessageDetails).build().perform();
           // action.moveToElement(instantPopCloseIcon);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
            wait.until(ExpectedConditions.elementToBeClickable(instantPopCloseIcon)).click();
            //instantPopCloseIcon.click();

        }
        public boolean isinsentLauncherIconIsDisplayed(){
            switchToChatBotFrame();
            return insentLauncherIcon.isDisplayed();
        }
        public void switchToChatBotFrame(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.switchTo().frame("insent-iframe");
        }

    public boolean isUnreadNotificationDisplayed() {
        System.out.println("is unread Notification displayed ? "+unreadMessageNotification.isDisplayed());
            return unreadMessageNotification.isDisplayed();
    }
    public void waitforSometime(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void clickOpenChatBotWindow(){
        insentPopUpMessageDetails.click();

    }
    public boolean checkifEmailInputBoxisVisible(){
            return emailInput.isDisplayed();
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void submitEmail() {
        emailSubmitButton.click();
    }
    public boolean isDefaultHowDoYouKnowDisplayed(){
            return howDoYouKnowZoomDefault.isDisplayed();
    }


    public String getHowDoYouKnowText() {
            return howDoYouKnowZoomDefault.getText();
    }


    public String getErrorToasterMessage(String expectedMessage) {
           WebElement errorMessage = driver.findElement(By.xpath(xpath.replace("{message}",expectedMessage)));
           return errorMessage.getText();

    }
}


