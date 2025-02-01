package Tests;

import Pages.homePage;
import Pages.loginPage;
import Pages.registerPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class wuzzufTest extends testBase {
    registerPage register;
    homePage home;
    loginPage login;

    @Test
    public void wzzufTest() throws InterruptedException {
        register = new registerPage(driver);
        home = new homePage(driver);
        login= new loginPage(driver);
        SoftAssert softAssert= new SoftAssert();
        Random random = new Random();
        Faker faker = new Faker();
        String firstName= faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String phoneNumber = "01" + faker.number().numberBetween(0, 3) + faker.number().digits(8);
        String jobTitle= "Software Engineer";
        String city= "Cairo";
        String nationality="Egypt";
        String area="Helwan";
        String study="Computer Science";
        int degreeDate=ThreadLocalRandom.current().nextInt(1950, 2034);
        int day = random.nextInt(30) + 1;
        int year = ThreadLocalRandom.current().nextInt(1990, 2016);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        int randomIndex = ThreadLocalRandom.current().nextInt(0, months.length);
        String month = months[randomIndex];
        System.out.println(email + "\n" + password);


        //Register
        register.clickGetStarted1();
        register.fillRegisterData(firstName,lastName,email,password,jobTitle);
        register.clickCreateAccount();
        register.clickSignUpManually();
        softAssert.assertEquals(register.getTellYourSelfLocator(),"Tell Us About Yourself");
        register.selectBirthDay(String.valueOf(day),month,String.valueOf(year));
        register.selectRadio();
        register.selectCity(city);
        register.selectNationality(nationality);
        register.selectArea(area);
        register.fillNumber(phoneNumber);
        register.clickContinue1();
        softAssert.assertEquals("Tell Us About Your "+register.getTellAboutYourEducation(),"Tell Us About Your Education");
        register.clickBachelorDegree();
        register.fillStudy(study);
        register.fillUniversity("H");
        register.selectDegreeAndGrade(String.valueOf(degreeDate),"Not specified");
        register.clickContinue2();
        softAssert.assertEquals("Tell Us About Your "+register.getTellAboutYourExperience(),"Tell Us About Your Experience");
        register.selectExperience("1 year");
        register.fillTitleAndCompany("Software Tester","Semi Corner");
        register.fillJobCategoryFiled("S");;
        register.selectFullTime();
        register.selectStartingMonthAndYear("a","2");
        register.selectCheckBox();
        register.clickSaveAndContinue3();
        register.clickContinue4();
        register.clickContinue5();
        softAssert.assertEquals("Tell Us About Your "+register.getTellUsAboutYourExpertise(),"Tell Us About Your Expertise");
        register.selectLanguageAndProficiency("e","e");
        register.fillSkillField("sof","sof");
        register.clickContinue6();
        softAssert.assertEquals("Tell Us About Your "+register.getCareerInterest(),"Tell Us About Your Career Interests");
        register.clickEntryLevel();
        register.clickInternship();
        register.clickOnSite();
        register.clickInterested();
        register.fillSalary("5000");
        register.clickContinue7();
        register.clickGetStarted2();
        //end of registerModule

        //Search
        home.fillSearch("Software Engineer");
        home.clickSearch();
        softAssert.assertTrue(!home.getJobListings().isEmpty(), "No job listings found!");
        boolean areRelevant = home.areJobListingsRelevant("Software Engineer");
        softAssert.assertTrue(areRelevant, "Some job listings are not relevant to 'Software Engineer'.");
        System.out.println("Test Passed: All job listings are relevant to 'Software Engineer'.");
        softAssert.assertTrue(home.isResultsCountDisplayed(), "Results count is not displayed!");
        System.out.println("All Result is : "+home.getResultsText());
        Thread.sleep(3000);
        home.clickFilters();
        home.clickPastWeek();
        home.waitForPageLoad();
        System.out.println("Past Week is : "+home.getResultsCount2());
        String first = home.getFirstJobName();
        home.openFirstJob();
        home.clickGotIt();
        home.clickApply();
        home.clickSaveLater();
        String saved = home.getSavedJobName();
        softAssert.assertEquals(first,saved,"Error");
        Thread.sleep(1000);
        login.clickProfileIcon();
        login.clickAccountSettings();
        login.deleteAccount();
        softAssert.assertEquals(login.getDeletedMessage(),"Your account has been deleted successfully.");

        softAssert.assertAll();
    }

}
