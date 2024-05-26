import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class Homework16 {

    public static void main(String[] args) {

        //precondition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //step 1
        String url = "https://qa.koel.app/";
        driver.get(url);
        //step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("india.messam@testpro.io");
        //step 3
        WebElement passwordField =driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("slcTalgy");
        //step 4
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();

        WebElement avatarIcon = driver.findElement((By.cssSelector("img [class='avatar']")));
        //assertions
        Assert.assertTrue(avatarIcon.isDisplayed());

        //Quit Browser
        driver.quit();






    }
}

