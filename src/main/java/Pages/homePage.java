package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class homePage extends base{
    Actions actions = new Actions(driver);
    final private By searchBar= By.xpath("//*[@class=\"css-sg52ec e1n2h7jb1\"]");
    final private By searchButton = By.xpath("//*[@class=\"css-1sn5x2o ezfki8j0\"]");
    final private By jobTitleResults =By.xpath("//*[@class=\"css-9i2afk\"]//*[@class=\"css-m604qf\"]");
    final private By jobsNumber=By.xpath("//*[@class=\"css-xkh9ud\"]/strong");
    //final private By jobsNumber2=By.xpath("//*[@class=\"css-tbpo9i\"]/span[2]/strong");
    final private By datePostedLocator=By.xpath("//*[@class=\"css-18uqayh\"]");
    final private By pastWeekLocator=By.xpath("//*[@class=\"css-18uqayh\"]//*[@class=\"css-19idom\"][3]//*[@class=\"css-bhwo3q e1kea1u61\"]");
    final private By firstJobLink =By.xpath("//*[@class=\"css-1gatmva e1v1l3u10\"][1]//*[@class=\"css-m604qf\"]//a");
    final private By firstJobLocator =By.xpath("//*[@class=\"css-1gatmva e1v1l3u10\"][1]//h2");
    final private By applyButton=By.xpath("//*[@class=\"css-1ur9mvu\"]/button");
    final private By gotItButton=By.xpath("//*[@class=\"css-tjo4qw\"]/button");
    final private By saveLaterButton=By.xpath("//*[@class=\"css-3c7xez\"]/*[@type=\"button\"][1]");
    final private By savedJobLocator=By.xpath("//*[@class=\"css-1v01ggk e1ojjapo0\"]");
    public homePage(WebDriver driver) {
        super(driver);
    }
    public void fillSearch(String search) throws InterruptedException {
        WebElement element = driver.findElement(searchBar);
        actions.sendKeys(element,search).build().perform();
        Thread.sleep(500);
    }
    public void clickSearch(){
        click(searchButton);
    }
    public List<WebElement> getJobListings() {
        return driver.findElements(jobTitleResults);
    }
    private double calculateRelevanceScore(String[] keywordWords, String[] jobTitleWords) {
        int matchCount = 0;
        // Compare each keyword word with words in the job title
        for (String keywordWord : keywordWords) {
            for (String jobTitleWord : jobTitleWords) {
                if (jobTitleWord.equalsIgnoreCase(keywordWord)) {
                    matchCount++;
                    break; // Move to the next keyword word once a match is found
                }
            }
        }
        // Calculate score as a ratio of matched words to total keyword words
        return (double) matchCount / keywordWords.length;
    }
    public boolean areJobListingsRelevant(String keyword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleResults));
        List<WebElement> listings = getJobListings();

        boolean allRelevant = true;
        String[] keywordWords = keyword.toLowerCase().split("\\s+");

        for (WebElement listing : listings) {
            String jobTitle = listing.getText().toLowerCase().trim();

            // Split job title into individual words
            String[] jobTitleWords = jobTitle.split("\\s+");
            double relevanceScore = calculateRelevanceScore(keywordWords, jobTitleWords);

            if (relevanceScore < 0.01) {
                System.out.println("Irrelevant Job Found: " + jobTitle + " listing.getText() " +  " | Relevance Score: " + relevanceScore);
                allRelevant = false; // Mark as irrelevant if the score is below the threshold
            }
            else {
                System.out.println("relevant Job Found: " + jobTitle );
            }
        }
        return allRelevant;
    }

    public boolean isResultsCountDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobsNumber));
        return !driver.findElements(jobsNumber).isEmpty(); // Check if the element exists
    }
 /*   public boolean isResultsCountDisplayed2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobsNumber2));
        return !driver.findElements(jobsNumber2).isEmpty(); // Check if the element exists
    }
*/
    // Method to get the results count value
    public String getResultsText() throws InterruptedException {
        WebElement element = driver.findElement(jobsNumber);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return getText(element);

    }
    public int getResultsNumber() throws InterruptedException {
        if (isResultsCountDisplayed()) {
            String resultsCountString = driver.findElement(jobsNumber).getText();
            return extractNumberFromText(resultsCountString);
        }
        return 0;


    }



    // Helper: Extract a number from text (e.g., "100 results" -> 100)
    public int extractNumberFromText(String text) {
        try {
            return Integer.parseInt(text.replaceAll("[^0-9]", "")); // Keep only digits
        } catch (NumberFormatException e) {
            System.err.println("Failed to extract number from text: " + text);
            return 0;
        }
    }

    public void clickFilters() throws InterruptedException {
        WebElement element=driver.findElement(datePostedLocator);
        actions.click(element).build().perform();
    }
    public void clickPastWeek() throws InterruptedException{
        WebElement element=driver.findElement(pastWeekLocator);
        Thread.sleep(1000);
        actions.click(element).build().perform();
    }
    public String getResultsCount2() throws InterruptedException {

        driver.switchTo().defaultContent();
        //driver.navigate().refresh();
        Thread.sleep(5000);
        WebElement element = driver.findElement(jobsNumber);
        Thread.sleep(1000);
        return getElementTextUsingJS(element);
    }
    public void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) {
            String readyState = js.executeScript("return document.readyState").toString();
            if (readyState.equals("complete")) {
                break;
            }
        }
    }
    public String getElementTextUsingJS(WebElement element) {
        // Create a JavascriptExecutor instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute JavaScript to retrieve the text
        String text = (String) js.executeScript("return arguments[0].textContent || arguments[0].innerText;", element);

        return text;
    }
    public String getFirstJobName() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstJobLocator));
        Thread.sleep(3000);
        return getText(linkElement);
    }
    public void openFirstJob() throws InterruptedException {
        Thread.sleep(2000);
        openInNewTab(firstJobLink);
        Thread.sleep(2000);
    }
    public String getSavedJobName() throws InterruptedException {
        return getText(savedJobLocator);
    }
    public void clickApply(){
        click(applyButton);
    }
    public void clickSaveLater() throws InterruptedException {
        Thread.sleep(1000);
        click(saveLaterButton);
    }
    public void clickGotIt(){
        WebElement element=driver.findElement(gotItButton);
        actions.click(element).build().perform();
    }

}
