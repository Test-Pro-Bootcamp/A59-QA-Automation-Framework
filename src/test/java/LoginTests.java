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
//import pageFactory.LoginPage;

import java.awt.*;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword()  {
        // Create an instance of the LoginPage & HomePage class below
        // And use them instead of enterEmail() and enterPassword() from BaseTest class.

         LoginPage loginPage = new LoginPage(driver);
         HomePage homePage = new HomePage(driver);

        // Step 1 - Login into Koel app
//        loginPage.login();
        loginPage.provideEmail("leon.poyau+2@testpro.io");
        loginPage.providePassword("N6wWY2Rx");
        loginPage.submitClick();
        //Using Fluent Interface way/style(lambda style) instead of the above 3 lines as shown below
        // Note - We had to import pageFactory.LoginPage since this class has the method that returns
        // an object of type LoginPage to allow use of Fluent Interface.
        // the regular POM pages.LoginPage import had to also be commented out. Otherwise it won't work.
        // loginPage.provideEmail("leon.poyau+2@testpro.io").providePassword("N6wWY2Rx").submitClick();

        // Validate and Verify that user logged successfully via assertion. Is the User Avatar Icon displayed on home page
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test(dataProvider="NegativeLoginTestData")
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        String expectedURL = "https://qa.koel.app/";

        // Step -1 // Attempt to log into Koel app using negative data. Unhappy path.
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.submitClick();
        // Verify that login attempts have failed via assertion. Login page should still be available
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
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
    //public void loginValidEmailEmptyPassword() throws InterruptedException {

        /*// navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("leon.poyau+2@testpro.io");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL); //https://qa.koel.app/

    }
    */
}