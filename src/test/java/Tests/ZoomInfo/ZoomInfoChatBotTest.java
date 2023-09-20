package Tests.ZoomInfo;

import DataProviders.DataProviderClass;
import Modules.ZoomInfoChatBotModule;
import Tests.BaseTest;
import Utils.ExtentReportsManager;
import Webpages.ZoomInfoChatBot.ZoomInfoChatBotMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

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


    @Test(enabled = true,priority = 1)
    public void validateMainPage() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if the ChatBotURL is Loaded Successfully");
        String ExpectedTitle = "Insent.ai";
        zoomInfoChatBotModule.VerifyWebPageIsLoadedSuccessFully(zoomInfoChatBotMainPage,ExpectedTitle);


    }
    @Test(enabled = true,priority = 2)
    public void VerifyReadandAcceptCookies() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if the Cookies are loaded on the first start and verify if they are closed after accepting");
String ExpectedPolicyWords = "Insent stores cookies on your computer to improve your website experience and provide more personalized services, both on this website, our chat and through other media. To find out more about the cookies we use, see our Privacy Policy.";
        zoomInfoChatBotModule.VerifyLoadAndAcceptCookies(zoomInfoChatBotMainPage,ExpectedPolicyWords);

    }

    @Test(enabled = true ,priority = 3 )
    public void VerifyWelcomeMessage() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if WELCOME MESSAGE is displayed appropriately in the chatBot");
        String expected = "Hi there, welcome";
        zoomInfoChatBotModule.VerifyWelcomeMessage(zoomInfoChatBotMainPage,expected);

    }
    @Test(enabled = true ,priority = 4 )
    public void VerifyWelcomeMessageCloseIcon() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if WELCOME MESSAGE is closed when close icon is hovered and clicked");
        zoomInfoChatBotModule.VerifyWelcomeMessageisClosedWhenHoverdAndClicked(zoomInfoChatBotMainPage);

    }
    @Test(enabled = true ,priority = 5 )
    public void VerifyUnReadMessageNotification() throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        ExtentReportsManager.startTest("Verify if Unread message notification icon is displayed in the chatbot icon and post reading it vanishes");
        zoomInfoChatBotModule.VerifyUnreadMessageNotification(zoomInfoChatBotMainPage);

    }

@AfterMethod
public void closeDriver(){
    driver.manage().deleteAllCookies();
    driver.close();
   driver.quit();
}

    @AfterTest
    public void teardown(){
       // driver.close();
       // driver.quit();


    }
}
