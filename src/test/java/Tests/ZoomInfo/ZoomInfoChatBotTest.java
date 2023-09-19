package Tests.ZoomInfo;

import DataProviders.DataProviderClass;
import Webpages.ZoomInfoChatBot.ZoomInfoChatBotMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ZoomInfoChatBotTest {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "chatBotTestDataSet",dataProviderClass = DataProviderClass.class)
    public void validateMainPage(Object data) throws InterruptedException {
        ZoomInfoChatBotMainPage zoomInfoChatBotMainPage = new ZoomInfoChatBotMainPage(driver);
        System.out.println(data);

    }


    @AfterTest
    public void teardown(){
        driver.close();
        driver.quit();


    }
}
