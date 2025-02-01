package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class base {
    WebDriver driver;



    public base(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void click(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    protected void click(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void setText(By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(text);
    }

    protected void setText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected String getText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
       return driver.findElement(by).getText();
    }
    protected String getText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
    protected int getSize(By by){
        return driver.findElements(by).size();
    }
    protected void selectByIndex(By by,int index){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    protected void selectByIndex(WebElement element,int index){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    protected Double convertToDouble(String text){
        text =text.replaceAll("[^0-9.]","");
        Double num = Double.parseDouble(text);
        return num;
    }
    //Open in new tab
    public void openInNewTab(By by){
        //Actions actions = new Actions(driver);
        String originalWindow = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement linkElement = driver.findElement(by);
        js.executeScript("window.open(arguments[0].href, '_blank');", linkElement);
        //actions.keyDown(Keys.CONTROL).click(driver.findElement(by)).keyUp(Keys.CONTROL).build().perform();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle); // Switch to the new tab
                break; // Exit the loop after switching to the new tab
            }
        }
    }
    //Scroll to Element (WebElement) --> Javascript Executor
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Scroll to Element (By) --> Javascript Executor
    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void fillFieldWithJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = arguments[1];", element, text);
    }


}
