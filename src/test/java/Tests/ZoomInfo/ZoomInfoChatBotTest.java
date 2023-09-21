package Tests.ZoomInfo;

import DataProviders.DataProviderClass;
import Modules.ZoomInfoChatBotModule;
import POJO.EmailInputRoot;
import Tests.BaseTest;
import Utils.ExtentReportsManager;
import Utils.JsonUtils;
import Webpages.ZoomInfoChatBot.ZoomInfoChatBotMainPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * Author: Diwahar Pandian
 */
public class ZoomInfoChatBotTest extends BaseTest {
    WebDriver driver;
    ZoomInfoChatBotModule zoomInfoChatBotModule = new ZoomInfoChatBotModule();

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void intitializeDriver(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
    }

    // Test 1: Verify if the ChatBotURL is Loaded Successfully
    @Test(enabled = true, priority = 1)
    public void validateMainPage() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if the ChatBotURL is Loaded Successfully");
        String ExpectedTitle = "Insent.ai";
        zoomInfoChatBotModule.VerifyWebPageIsLoadedSuccessFully(zoomInfoChatBotMainPage, ExpectedTitle);
    }

    // Test 2: Verify if Cookies are loaded and can be accepted
    @Test(enabled = true, priority = 2)
    public void VerifyReadandAcceptCookies() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if the Cookies are loaded on the first start and verify if they are closed after accepting");
        String ExpectedPolicyWords = "Insent stores cookies on your computer to improve your website experience and provide more personalized services, both on this website, our chat and through other media. To find out more about the cookies we use, see our Privacy Policy.";
        zoomInfoChatBotModule.VerifyLoadAndAcceptCookies(zoomInfoChatBotMainPage, ExpectedPolicyWords);
    }

    // Test 3: Verify if Welcome Message is displayed appropriately
    @Test(enabled = true, priority = 3)
    public void VerifyWelcomeMessage() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if WELCOME MESSAGE is displayed appropriately in the chatBot");
        String expected = "Hi there, welcome";
        zoomInfoChatBotModule.VerifyWelcomeMessage(zoomInfoChatBotMainPage, expected);
    }

    // Test 4: Verify if Welcome Message can be closed when close icon is hovered and clicked
    @Test(enabled = true, priority = 4)
    public void VerifyWelcomeMessageCloseIcon() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if WELCOME MESSAGE is closed when close icon is hovered and clicked");
        zoomInfoChatBotModule.VerifyWelcomeMessageisClosedWhenHoverdAndClicked(zoomInfoChatBotMainPage);
    }

    // Test 5: Verify if Unread message notification icon is displayed and vanishes after reading
    @Test(enabled = true, priority = 5)
    public void VerifyUnReadMessageNotification() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if Unread message notification icon is displayed in the chatbot icon and post reading it vanishes");
        zoomInfoChatBotModule.VerifyUnreadMessageNotification(zoomInfoChatBotMainPage);
    }

    // Test 6: Verify if User Is Able To Enter a Valid Email ID or get an error with an invalid one
    @Test(enabled = true, priority = 6, dataProvider = "chatBotTestDataSet", dataProviderClass = DataProviderClass.class)
    public void VerifyifUserIsAbleToEnterValidEmailId(Object data) throws InterruptedException, JsonProcessingException {
        String dataObject = JsonUtils.objectToJSONString(data);
        ObjectMapper objectMapper = new ObjectMapper();
        EmailInputRoot emailInputRoot = objectMapper.readValue(dataObject, EmailInputRoot.class);

        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify " + emailInputRoot.getScenario());
        if (emailInputRoot.getUseCase().equals("valid")) {
            zoomInfoChatBotModule.verifyIfTheEmailInputIsValid(zoomInfoChatBotMainPage, emailInputRoot.getEmail());
        } else if (emailInputRoot.getUseCase().equals("invalid")) {
            zoomInfoChatBotModule.verifyifEmailFieldReturnsErrorwithInvalidEmail(zoomInfoChatBotMainPage, emailInputRoot.getEmail(), emailInputRoot.getMessage());
        }
    }
    @Test(enabled = true, priority = 7)
    public void VerifyifUserIsAbleToRestartTheConversation()  {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if user is able to restart the conversation");
        ExtentReportsManager.logInfoWithMarkup("1) Click open chat \n 2) Click on Restart \n 3) Verify if @mention incent bot is displayed \n 4) Verify if email input field is displayed ");
        zoomInfoChatBotModule.verifyIfUserIsAbleToRestarTheConversation(zoomInfoChatBotMainPage);
    }
    @Test(enabled = true, priority = 8)
    public void VerifyifUserIsAbleToOpenAndCloseThenConversation()  {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if user is able to Open and Close the conversation");
        ExtentReportsManager.logInfoWithMarkup("1) Click open chat \n 2) Click on chat to Open \n 3) Verify chat window is displayed \n 4) close the chat \n Verify if chat is closed correctly ");
        zoomInfoChatBotModule.verifyIfUserisAbleToOpenAndCloseTheChat(zoomInfoChatBotMainPage);
    }

    @AfterMethod
    public void closeDriver(){
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterTest
    public void teardown(){
       // any tear down method to be perfomed after executing test shall be included here
    }
    @AfterSuite
    public void afterSuite(){
        // to include any actions that needs to be performed After suite
        ExtentReportsManager.flushReport();
        while(driver!=null) {
            driver.quit();
            driver = null;
        }



    }
}
