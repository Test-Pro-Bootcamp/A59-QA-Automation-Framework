package stepDefinitions;

import com.google.j2objc.annotations.Weak;
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
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition {

    WebDriver driver;

    WebDriverWait wait;

@Before
public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @And("I open Koel Login Page")
    public void iOpenKoelLoginPage() {
        driver.get("https://qa.koel.app/");
    }
    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).clear();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).sendKeys(email);
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).clear();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(password);
    }
    @And("I click submit")
    public void iClickSubmit() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickSubmit();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
    }
    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
    HomePage homePage = new HomePage(driver);
    homePage.getUserAvatar();
    Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
//        Assert.assertTrue(wait.until
//                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }



    @After
    public void closeBrowser(){
        driver.quit();
    }
//
    @When("I enter invalid email {string}")
    public void iEnterInvalidEmail(String invalidEmail) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(invalidEmail);
    }
    @And("I enter password \\{string}")
    public void iEnterPasswordString(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @Then("I should be staying in Login Page")
    public void iShouldBeStayingInLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInvalidEmail();
        String expectedUrl = "https://qa.koel.app/";

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }


}
