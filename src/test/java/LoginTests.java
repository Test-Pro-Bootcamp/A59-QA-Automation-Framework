import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.awt.*;

public class LoginTests extends BaseTest {


    @Test
    public void loginValidEmailPassword()  {
        // Create an instance of the LoginPage & HomePage class below
        // And use them instead of enterEmail() and enterPassword() from BaseTest class.

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());

        // navigateToPage();
        /*
        enterEmail("demo@testpro.io");
        enterPassword("N6wWY2Rx");
        submit();
        // Thread.sleep(2000);
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img[class='avatar']")));
        // WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));

        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

         */
    }

    // @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {

        // navigateToPage() ;
        String expectedURL = "https://qa.koel.app/";
        // Steps
        enterEmail("invalid@testpro.io");
        enterPassword("N6wWY2Rx");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL); // https://qa.koel.app/
    }

    // @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        /*// navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("leon.poyau+2@testpro.io");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL); //https://qa.koel.app/
         */
    }

    //@Test(dataProvider="NegativeLoginTestData")
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedURL = "https://qa.koel.app/";
        enterEmail(email);
        enterEmail(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
}