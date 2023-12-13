package Tests.NADA;

import Webpages.NADA.FormMainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FormAutomationUITest {
    private WebDriver driver;
    private FormMainPage formMainPage;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        driver=new ChromeDriver(options);
driver = new ChromeDriver();
        formMainPage= new FormMainPage(driver);

    }
    @Test
    public void fillForm() throws IOException {
        formMainPage.setCompany("Tesla");
        formMainPage.setJob("QA");
        formMainPage.setMobilenumber("97901111908");
        double random = Math.random();
        formMainPage.setEmail("tapqatekion+"+random+"@gmail.com");
       formMainPage.SetFirstAndLastName("random","check");
       formMainPage.setInterestButton("Enterprise Cloud");
       formMainPage.hitSubmit();


    }
    @AfterTest
    public void tearDown(){
       /* driver.close();
        driver.quit();*/
    }
}
