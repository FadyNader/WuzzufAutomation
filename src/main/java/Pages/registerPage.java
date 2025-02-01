package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class registerPage extends base {
    Actions actions = new Actions(driver);

    final private By getStartedLocator = By.xpath("//*[@class=\"css-s5xdrg\"]/*[@href=\"/register\"]");
    final private By firstNameField = By.xpath("//*[@class=\"css-150a24d\"]/*[@id=\"firstname\"]");
    final private By lastNameField = By.xpath("//*[@class=\"css-150a24d\"]/*[@id=\"lastname\"]");
    final private By emailField=By.xpath("//*[@class=\"css-150a24d\"]/*[@id=\"email\"]");
    final private By passwordField = By.xpath("//*[@class=\"css-150a24d\"]/*[@name=\"password\"]");
    final private By titleField = By.xpath("//*[@class=\"css-1itq9hi ek82ord0\"]");
    final private By createAccountButton =By.cssSelector("button.css-12g3p01.ezfki8j0");
    final private By clickSignUpManuallyButton =By.className("css-110f84v");
    final private By dayLocator=By.xpath("//*[@class=\"css-1x21pox e1g066lk4\"]//*[@class=\"col-2-lg col-12\"]//*[@class=\" css-1hwfws3\"]");
    final private String dropDownDayOptionXpath = "//*[@class=' css-szlc4p-option' and text()='%s' ]";
    final private By monthLocator=By.xpath("//*[@class=\"css-1x21pox e1g066lk4\"]//*[@class=\"col-3-lg col-12\"][1]//*[@class=\" css-1hwfws3\"]");
    final private By yearLocator=By.xpath("//*[@class=\"css-1x21pox e1g066lk4\"]//*[@class=\"col-3-lg col-12\"][2]//*[@class=\" css-1hwfws3\"]");
    final private By radioLocator=By.xpath("//*[@class=\"css-1t6kodx e1kea1u62\"][1]//*[@class=\"css-bhwo3q e1kea1u61\"]");
    final private By nationalityLocator=By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][1]//*[@class=\"css-rpi6b5 e1g066lk4\"]//*[@class=\" css-1hwfws3\"]");
    final private By cityLocator=By.xpath("//*[@class=\"section-validation-error css-6hend0 e1v1l3u10\"][2]//*[@class=\"css-rpi6b5 e1g066lk4\"][2]//*[@class=\" css-1ph4zhu-placeholder\"]");
    final private By areaLocator=By.xpath("//*[@class=\" css-6hend0 e1v1l3u10\"]//*[@class=\" css-1ph4zhu-placeholder\"]");
    final private By phoneField=By.xpath("//*[@name=\"primaryPhone\"]");
    final private By continueButton1 = By.xpath("//*[@type=\"button\"]");
    final private By tellYourSelfLocator= By.xpath("//*[@class=\"css-15yw7ce\"]");
    final private By tellUsAboutYourEducationLocator=By.xpath("//*[@class=\"css-vlxyh0\"]");
    final private By bachelorDegreeLocator=By.xpath("//*[@class=\"css-1bt6nx3\"]/*[@class=\"css-1dy69p2 eequ2uf0\"][1]");
    final private By studyField=By.xpath("//*[@class=\"css-1a96k50 ek82ord0\"]");
    final private By clickUniversityField=By.xpath("//*[@style=\"margin-top: 20px;\"]//*[@class=\"css-10m6313 e1g066lk3\"]//*[@class=\" css-1ph4zhu-placeholder\"]"); //
    final private By degreeDropDownList=By.xpath("//*[@class=\"css-vbnqhq e1g066lk2\"]//*[@class=\" css-1hwfws3\"]");
    final private By gradeDropDownList=By.xpath("//*[@class=\"css-1guj1as\"]//*[@class=\" css-1hwfws3\"]");
    final private By continueButton2 = By.xpath("//*[@class=\"css-2dg8nw ezfki8j0\"]");
    final private By getTellUsAboutYourExperienceLocator=By.xpath("//*[@class=\"css-vlxyh0\"]");
    final private By experienceDropDown=By.xpath("//*[@type=\"extra-large\"]");
    final private By jobTitleField=By.xpath("//*[@name=\"jobTitle\"]");
    final private By companyNameField=By.xpath("//*[@name=\"companyName\"]");
    final private By jobCategoryField=By.xpath("//*[@data-field=\"jobCategories\"]//*[@class=\" css-1hwfws3\"]");
    final private By fullTimeLocator=By.xpath("//*[@class=\"css-olenq2 eequ2uf0\"][1]");
    final private By startMonthLocator=By.xpath("//*[@data-field=\"experienceDuration.startMonth\"]//*[@class=\" css-1hwfws3\"]");
    final private By startYearLocator=By.xpath("//*[@data-field=\"experienceDuration.startYear\"]//*[@class=\" css-1hwfws3\"]");
    final private By checkBox= By.xpath("//*[@type=\"checkbox\"]");
    final private By saveButton=By.xpath("//*[@name=\"Save_Work_Experience\"]");
    final private By continueButton3=By.xpath("//*[@class=\"css-x1i4hg\"]//*[@class=\"css-2dg8nw ezfki8j0\"]");
    final private By continueButton4=By.xpath("//*[@class=\"css-x1i4hg\"]/*[@type=\"button\"]");
    final private By continueButton5=By.xpath("//*[@class=\"css-x1i4hg\"]//*[@class=\"css-2dg8nw ezfki8j0\"]");
    final private By tellUsExpertiseLocator=By.xpath("//*[@class=\"css-vlxyh0\"]");
    final private By languageField=By.xpath("//*[@class=\"css-911kv1 e1g066lk0\"][1]//*[@class=\" css-1hwfws3\"]");
    final private By addButton=By.xpath("//*[@class=\"css-ksyb00 ezfki8j0\"]");
    final private By proficiencyField=By.xpath("//*[@class=\"css-911kv1 e1g066lk0\"][2]//*[@class=\" css-1hwfws3\"]");
    final private By skillField=By.xpath("//*[@class=\"css-1ie8yy5 e1g066lk4\"]//*[@class=\" css-1hwfws3\"]");
    final private By continueButton6=By.xpath("//*[@class=\"css-2dg8nw ezfki8j0\"]");
    final private By careerInterests=By.xpath("//*[@class=\"css-15yw7ce\"]//span");
    final private By entryLevelLocator=By.xpath("//*[@class=\"css-1dy69p2 eequ2uf0\"][2]");
    final private By internshipLocator=By.xpath("//*[@title=\"Internship\"]");
    final private By onSiteLocator=By.xpath("//*[@title=\"On-site\"]");
    final private By interestedLocator=By.xpath("//*[@class=\"css-vut953 e1ekn0hm0\"][1]");
    final private By minimumSalaryField=By.xpath("//*[@name=\"minimumSalary\"]");
    final private By checkBoxSalary=By.xpath("//*[@class=\"css-xda5ep\"]//*[@type=\"checkbox\"]");
    final private By continueButton7=By.xpath("//*[@class=\"css-2dg8nw ezfki8j0\"]");
    final private By getStartedButton=By.xpath("//*[@class=\"css-tm415q\"]//*[@class=\"css-pkb4uu ezfki8j0\"]");




    public registerPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open the application")
    public void clickGetStarted1(){
        click(getStartedLocator);
    }

    @Step ("Perform Register")
    public void fillRegisterData(String firstName,String lastName,String email,String password,String title) throws InterruptedException {
        setText(firstNameField,firstName);
        setText(lastNameField,lastName);
        setText(emailField,email);
        setText(passwordField,password);
        setText(titleField,title);
        Thread.sleep(2000);
    }
    public void clickCreateAccount() throws InterruptedException {
        click(createAccountButton);
        Thread.sleep(2000);
    }
    public void clickSignUpManually() throws InterruptedException {
        click(clickSignUpManuallyButton);
        Thread.sleep(2000);
    }
    @Step ("Add Birthday")
    public void selectBirthDay(String day,String month,String year) throws InterruptedException {
        WebElement dayElement = driver.findElement(dayLocator);
        WebElement monthElement = driver.findElement(monthLocator);
        WebElement yearElement = driver.findElement(yearLocator);
        actions.click(dayElement).build().perform();
        click(By.xpath(String.format(dropDownDayOptionXpath,day)));
        actions.click(monthElement).build().perform();
        click(By.xpath(String.format(dropDownDayOptionXpath,month)));
        actions.click(yearElement).build().perform();
        click(By.xpath(String.format(dropDownDayOptionXpath,year)));
        Thread.sleep(500);
    }

    public void selectRadio(){
        click(radioLocator);
    }
    public void selectNationality(String nationality) {
        click(nationalityLocator); // Click to open the Year dropdown
        click(By.xpath(String.format(dropDownDayOptionXpath, nationality)));// Select the year
    }
    public void selectCity(String city) {
        click(cityLocator); // Click to open the Year dropdown
        click(By.xpath(String.format(dropDownDayOptionXpath, city)));// Select the year
    }
    public void selectArea(String area) {
        click(areaLocator); // Click to open the Year dropdown
        click(By.xpath(String.format(dropDownDayOptionXpath, area)));
    }
    public void fillNumber(String number){
        setText(phoneField,number);
    }
    public void clickContinue1() throws InterruptedException {
        click(continueButton1);
        Thread.sleep(2000);
    }

    public String getTellYourSelfLocator() {
        return getText(tellYourSelfLocator);
    }
    public String getTellAboutYourEducation() {
        return getText(tellUsAboutYourEducationLocator);
    }
    public void clickBachelorDegree(){
        click(bachelorDegreeLocator);
    }
    public void fillStudy(String study){
        setText(studyField,study);
    }

    public void fillUniversity(String university) throws InterruptedException {
      WebElement element = driver.findElement(clickUniversityField);
      actions.sendKeys(element,university).build().perform();
      Thread.sleep(500);
      click(By.xpath(String.format(dropDownDayOptionXpath,"Helwan University")));
      Thread.sleep(500);

    }
    public void selectDegreeAndGrade(String degree,String grade) throws InterruptedException {
        click(degreeDropDownList);
        click(By.xpath(String.format(dropDownDayOptionXpath,degree)));
        click(gradeDropDownList);
        click(By.xpath(String.format(dropDownDayOptionXpath,grade)));
        Thread.sleep(500);
    }
    public void clickContinue2() throws InterruptedException {
        click(continueButton2);
        Thread.sleep(1000);
    }
    public String getTellAboutYourExperience() throws InterruptedException {
        Thread.sleep(1000);
        return getText(getTellUsAboutYourExperienceLocator);
    }
    public void selectExperience(String experience){
        click(experienceDropDown);
        click(By.xpath(String.format(dropDownDayOptionXpath, experience)));

    }
    public void fillTitleAndCompany(String title,String company){
        setText(jobTitleField,title);
        setText(companyNameField,company);
    }
    public void fillJobCategoryFiled(String category) throws InterruptedException{
        WebElement element = driver.findElement(jobCategoryField);
        actions.sendKeys(element,category).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"IT/Software Development")));
    }
    public void selectFullTime() throws InterruptedException {
        click(fullTimeLocator);
        Thread.sleep(1000);
    }
    public void selectCheckBox(){
        WebElement element = driver.findElement(checkBox);
        actions.click(element).build().perform();
    }
    public void selectStartingMonthAndYear(String month,String year) throws InterruptedException {
        WebElement element1 = driver.findElement(startMonthLocator);
        actions.sendKeys(element1,month).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"May")));
        WebElement element2 = driver.findElement(startYearLocator);
        actions.sendKeys(element2,year).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"2022")));
        Thread.sleep(1000);
    }
    public void clickSaveAndContinue3() throws InterruptedException {
        click(saveButton);
        Thread.sleep(1000);
        click(continueButton3);
        Thread.sleep(1000);
    }
    public void clickContinue4(){
        click(continueButton4);
    }
    public void clickContinue5(){
        click(continueButton5);
    }
    public String getTellUsAboutYourExpertise() throws InterruptedException {
        Thread.sleep(1000);
        return getText(tellUsExpertiseLocator);
    }
    public void selectLanguageAndProficiency(String language,String proficiency) throws InterruptedException {
        WebElement element1 = driver.findElement(languageField);
        actions.sendKeys(element1,language).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"English")));
        WebElement element2 = driver.findElement(proficiencyField);
        actions.sendKeys(element2,proficiency).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"Fluent")));
        Thread.sleep(1000);
        click(addButton);
    }
    public void fillSkillField(String skill1,String skill2) throws InterruptedException {
        WebElement element1 = driver.findElement(skillField);
        actions.sendKeys(element1,skill1).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"Android Software")));
        WebElement element2 = driver.findElement(skillField);
        actions.sendKeys(element2,skill2).build().perform();
        Thread.sleep(500);
        click(By.xpath(String.format(dropDownDayOptionXpath,"Software Engineering")));
    }
    public void clickContinue6() throws InterruptedException {
        click(continueButton6);
        Thread.sleep(3000);

    }
    public String getCareerInterest() throws InterruptedException {
        Thread.sleep(3000);
        return getText(careerInterests);
    }
    public void clickEntryLevel(){
        click(entryLevelLocator);
    }
    public void clickInternship(){
        click(internshipLocator);
    }
    public void clickOnSite(){
        click(onSiteLocator);
    }
    public void clickInterested(){
        click(interestedLocator);
    }
    public void fillSalary(String salary) throws InterruptedException {
        setText(minimumSalaryField,salary);
        WebElement element = driver.findElement(checkBoxSalary);
        actions.click(element).build().perform();
        Thread.sleep(1000);
    }
    public void clickContinue7(){
        click(continueButton7);
    }
    public void clickGetStarted2(){
        click(getStartedButton);
    }
}
