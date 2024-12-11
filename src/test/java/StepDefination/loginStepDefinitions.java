package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class loginStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

   // @Given("I open browser")
    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("I open login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app");

    }

    @When("I enter login email {string}")
    public void iEnterLoginEmail(String email) {
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("[type='email']"))).sendKeys(email);*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("login password{string}")
    public void loginPassword(String password) {
       /* wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("[type='password']"))).sendKeys(password);*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);

    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @And("I Submit")
    public void iSubmit() {
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("[type='submit']"))).click(); */
        LoginPage loginPage = new LoginPage(driver);
        LoginPage.clickSubmit();
        
    }

    @Then("I am logged in.")
    public void iAmLoggedIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("img.avatar"))).isDisplayed();
    }

    @Then("I should not get log in")
    public void iShouldNotGetLogIn() {
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }



}

