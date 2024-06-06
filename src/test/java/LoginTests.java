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

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    //Happy Path-Login Test
    @Test

    public void loginValidEmailPassword() throws InterruptedException {

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
        emailField.sendKeys("aleksei.koksharov@testpro.io");
        Thread.sleep(2000);

        //Step3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("ak1234!@#$");
        Thread.sleep(2000);

        //Step4
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread. sleep(4000);

        //Avatar Icon for Actual vs Expected
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit Browser
        driver.quit();



    }

    //Negative Test

    @Test

    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Step1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("alekseikoksharov@testproio");
        Thread.sleep(2000);

        //Step3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("ak1234!@#$");
        Thread.sleep(2000);

        //Step4
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread. sleep(4000);

        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Quit
        driver.quit();
    }

    //Negative Test - empty password field
    @Test

    public void loginValidEmailEmptyPassword() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Step1
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("aleksei.koksharov@testpro.io");
        Thread.sleep(2000);

        //Step3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("");
        Thread.sleep(2000);

        //Step4
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
        Thread.sleep(4000);

        //Expected Result - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), url);

        //Quit
        driver.quit();
    }

}
