package stepDefinitions;

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
import org.testng.annotations.AfterMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginStepDefinition {
    // we're not using BaseTest, so we need to declare webdriver and webdriverwait objects
    WebDriver driver;
    WebDriverWait wait;

    String baseURL = "https://qa.koel.app/";
    // String expectedHomeURL = "https://qa.koel.app/#!/home";

    //@Given("I open browser")
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @And("I open Koel Login Page")
    public void iOpenKoelLoginPage() {
        driver.get(baseURL);
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I click submit")
    public void iClickSubmit() {
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();*/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.submitClick();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        //Assert.assertEquals(driver.getCurrentUrl(),expectedHomeURL);
        /*Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("img.avatar"))).isDisplayed());*/
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    /* This validates/verifies that Login fails when doing negative testing*/
    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {
        /*HomePage homePage = new HomePage(driver);
        Assert.assertFalse(homePage.getUserAvatarIcon().isDisplayed());*/
        Assert.assertEquals(driver.getCurrentUrl(),baseURL);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}
