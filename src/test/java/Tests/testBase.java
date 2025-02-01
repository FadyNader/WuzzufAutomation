package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilites.ScreenshotUtil;

import java.time.Duration;

public class testBase {
    WebDriver driver;
    wuzzufTest wuzzufTest;
    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //wuzzufTest = new wuzzufTest();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://wuzzuf.net/jobs/egypt");
        ScreenshotUtil.captureScreenshot(driver, "Homepage Screenshot");

    }

    @AfterMethod
    public void after() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }


    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
