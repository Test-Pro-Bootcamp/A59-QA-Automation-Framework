package stepDefinition;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pgFactoryPages.HomePage;
import pgFactoryPages.LoginPage;

import java.time.Duration;
//new class for homework 27
public class LoginStepDefinition {
    WebDriver driver;
    WebDriverWait wait;

   @Before
    public void openBrowser() { // steps to open browser
        WebDriverManager.chromedriver().setup();;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        System.out.println("Browser success");

    }

    @And("I open Koel Login Page")
    public void iOpenKoelLoginPage() {
        driver.get ("https://qa.koel.app/");
        System.out.println("Hit Website");
        
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
       LoginPage loginPage= new LoginPage(driver);
       loginPage.provideEmail(email);
       System.out.println("Email entered");
   }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
       LoginPage loginPage= new LoginPage(driver);
       loginPage.providePassword(password);
        System.out.println("Password entered");
   }

    @And("I click submit")
    public void iClickSubmit() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.clickSubmit();
        System.out.println("Clicked submit");
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        HomePage homePage = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOf(homePage.getUserAvatar()));
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed(), "User avatar is not displayed");
    }

    @After
    //@after from cucumber
    public void closeBrowser () {
        driver.quit();
    }
}
