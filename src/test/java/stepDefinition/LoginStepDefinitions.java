package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import page.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    Actions actions = null;
    WebDriverWait wait;

    @Given("I open browser")
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

    }
    @And("I open Login page")
    public void openLoginPage() {
        driver.get("https://qa.koel.app/");
    }

    @When("I enter email {string}")
    public void i_enter_email(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.provideEmail(email);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }

    @And("I submit")
    public void clickSubmit() {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmit();
    }

    @Then("I am logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }

    @And("I enter incorrect password {string}")
    public void i_enter_IncorrectPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
    }

    @Then("I am not logged in")
    public void user_isNot_LoggedIn() {
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

        @When("I navigate to AllSongs")
        public void navigateToAllSongs() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
            WebDriverManager.chromedriver().setup();
        }

        @And("Context click on first song")
        public void contextClickOnFirstSong() {

            WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
            actions.contextClick(firstSongElement).perform();
        }

        @And("Choose Play Option")
        public void choosePlayOption() {
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("li.playback"))).click();
        }

        @Then("Song is playing")
        public boolean songIsPlaying() {
            WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
            return soundBarVisualizer.isDisplayed();
        }
    }


