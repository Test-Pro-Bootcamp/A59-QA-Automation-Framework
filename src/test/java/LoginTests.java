import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    //Happy Path
    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        //Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Step1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@testpro.io");
        Thread.sleep(2000);
        //Step3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
        Thread.sleep(2000);
        //Step4
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //Avatar Icon for Actual vs Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertion - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
        //QuitBrowser
        driver.quit();
    }


    //Not so happy Path - Negative Test Case
    @Test
    public void LoginWithInvalidEmailValidPassword() throws InterruptedException {
        //Pre-Condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Step1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        //Step2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("Invalid@koel.io");
        Thread.sleep(2000);
        //Step3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("InvalidPassword");
        Thread.sleep(2000);
        //Step4
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
        //Expected Results - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Quit
        driver.quit();

    }


    public class Homework16{

        @Test
        //Test Case Registration Navigation
        public void RegistrationNavigation() throws InterruptedException {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            String url = "https://qa.koel.app/";
            driver.get(url);
            Thread.sleep(2000);

            WebElement registrationLink = driver.findElement(By.linkText("Registration"));
            registrationLink.click();

            String expectedTitle = "Registration";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(expectedTitle, actualTitle);
            driver.quit();
        }
    }
}






