package Webpages.ZoomInfoChatBot;

import Utils.ExtentReportsManager;
import Utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ZoomInfoChatBotMainPage {
    WebDriver driver;
    private ExtentTest test; // ExtentTest instance for logging

    // URL for the ZoomInfo Chat Bot page
    private static final String URL="https://recruitment.web-test.insent.ai/fe-assignment";

    // Constructor
    public ZoomInfoChatBotMainPage(WebDriver driver) throws IOException {
        this.driver=driver;
        driver.get(URL);
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();

    }

    // Xpath identification for various elements
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
    @FindBy(xpath ="//span[text()='Restart conversation']")
    WebElement restartConversationButton;
    @FindBy(xpath="(//div[@id='insent-text-message-message-wrapper-client-message'])[last()]")
    WebElement insentBotmentioninChat;
    @FindBy(xpath ="//div[@id='insent-conversation-list']")
    WebElement insentConversationList;
    @FindBy(xpath ="//div[@data-testId='insent-test-card-close']")
    WebElement closeIcon;

    // Page Functions

    // Get the title of the current page
    public String getTitle(){
        return driver.getTitle();
    }

    // Read and return the policy wording text
    public String readPolicyWording(){
        return policyWording.getText();
    }

    // Click the accept policy button
    public void acceptPolicy() throws IOException {
        ExtentReportsManager.logScreenshot(ScreenshotUtils.captureScreenshot(driver),"first Screenshot");
        acceptButton.click();
    }

    // Get the welcome message from the instant pop-up
    public String getInstantPopUpMessage(){
        switchToChatBotFrame();
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(instantPopUpWelcomeMessage));
        return instantPopUpWelcomeMessage.getText();
    }

    // Hover over the close icon and click it
    public void hoverToCloseIconAndClick(){
        Actions action = new Actions(driver);
        action.moveToElement(insentPopUpMessageDetails).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(instantPopCloseIcon)).click();
    }

    // Check if the Insent launcher icon is displayed
    public boolean isinsentLauncherIconIsDisplayed(){
        switchToChatBotFrame();
        return insentLauncherIcon.isDisplayed();
    }

    // Switch to the chat bot iframe
    public void switchToChatBotFrame(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame("insent-iframe");
    }

    // Check if the unread message notification is displayed
    public boolean isUnreadNotificationDisplayed() {
        System.out.println("is unread Notification displayed ? "+unreadMessageNotification.isDisplayed());
        return unreadMessageNotification.isDisplayed();
    }

    // Wait for a specified amount of time
    public void waitforSometime(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    // Click to open the chat bot window
    public void clickOpenChatBotWindow(){
        insentPopUpMessageDetails.click();
    }

    // Check if the email input box is visible
    public boolean checkifEmailInputBoxisVisible(){
        return emailInput.isDisplayed();
    }

    // Enter an email address
    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    // Submit the email address
    public void submitEmail() {
        emailSubmitButton.click();
    }

    // Check if the default "How do you know about Zoominfo?" message is displayed
    public boolean isDefaultHowDoYouKnowDisplayed(){
        return howDoYouKnowZoomDefault.isDisplayed();
    }

    // Get the text of the default "How do you know about Zoominfo?" message
    public String getHowDoYouKnowText() {
        return howDoYouKnowZoomDefault.getText();
    }

    // Get an error toaster message with the provided expected message
    public String getErrorToasterMessage(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.xpath(xpath.replace("{message}",expectedMessage)));
        return errorMessage.getText();
    }

    public void clickRestartConversation() {
        restartConversationButton.click();

    }
    public String getLastChatBotMentionText(){
        return insentBotmentioninChat.getText();
    }

    public boolean conversationListIsDisplayed() {
      try{
          ExtentReportsManager.logInfo("Chat window displayed "+insentConversationList.isDisplayed());
          return insentConversationList.isDisplayed();
      }catch(Exception e){
          ExtentReportsManager.logInfo("Chat window is not  displayed ");
          return false;
      }
    }

    public void CloseIconAndClick() {
        closeIcon.click();
    }

    public void openNewTabAndLoadGoogleAndWaitfor10SecAndReturnBackToChat(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open('', '_blank');");
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> handleList = new ArrayList<String>(windowHandles);
      driver.switchTo().window(handleList.get(1));
      driver.get(url);
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.switchTo().window(handleList.get(0));



    }
    public String getCurrentWindowTitle(){
        return driver.getTitle();
    }

    public void takeScreenshot(){

    }
}
