package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class loginPage extends base{
    Actions action = new Actions(driver);
    final private By loginButton = By.xpath("//*[@href=\"/login\"]");
    final private By emailField=By.xpath("//*[@name=\"email\"]");
    final private By passwordField=By.xpath("//*[@name=\"password\"]");
    final private By signInButton=By.xpath("//*[@class=\"css-jwgvmq\"]//*[@class=\"css-14ghl4e ezfki8j0\"]");
    final private By profileIcon=By.xpath("//*[@class=\"css-1y21uxh e52wflf2\"]");
    final private By accountSettings=By.xpath("//*[@class=\"css-123hd9o epb9wcb2\"][9]");
    final private By deleteAccountButton=By.xpath("//*[@class=\"css-1jt07a0 e1v1l3u10\"]/button");
    final private By confirmDelete=By.xpath("//*[@class=\"css-1jbawm2\"]//*[@class=\"css-5oy7fs\"]");
    final private By submitDelete=By.xpath("//*[@class=\"css-1ifqz3c\"]//*[@type=\"submit\"]");
    final private By deletedMessage=By.xpath("//*[@class=\"css-18nekxb\"]");

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogIn(){
        click(loginButton);
    }
    public void fillLogin(String email,String password){
        setText(emailField,email);
        setText(passwordField,password);
    }
    public void clickSignIn(){
        click(signInButton);
    }

    public void clickProfileIcon(){
        WebElement element= driver.findElement(profileIcon);
        action.click(element).build().perform();
    }
    public void clickAccountSettings(){
        click(accountSettings);
    }
    public void deleteAccount() throws InterruptedException {
        click(deleteAccountButton);
        Thread.sleep(1000);
        click(confirmDelete);
        Thread.sleep(1000);
        click(submitDelete);

    }
    public String getDeletedMessage(){
        WebElement deleted=driver.findElement(deletedMessage);
        return getText(deleted);
    }
}
