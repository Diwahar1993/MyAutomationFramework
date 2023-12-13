package Tests.Amazon;


import Webpages.Amazon.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AmazonTest {
    private WebDriver driver;
    private LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage=new LoginPage(driver);

    }
//@Test(testName = "method1")
//public void method1(){
//    System.out.println("Sample TESTNG Execution");
//    loginPage.isLoginPageLoaded();
//}
//
//    @Test(testName = "method2")
//    public void method2(){
//        System.out.println("Sample TESTNG Execution method 2");
//        loginPage.isLoginPageLoaded();
//    }

    @Test(testName = "loginCheck")
    public void Login() throws IOException {
        loginPage.isLoginPageLoaded();
        loginPage.clickonLogin();
    }
    @AfterTest
    public void teardown(){
//        driver.close();
//        driver.quit();
    }
}
