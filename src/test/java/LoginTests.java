import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        LoginPage LoginPage = loginPage.provideEmail("india.messam@testpro.io");
        LoginPage = loginPage.providePassword("slcTalgy");
        Assert.assertTrue(homepage.getUserAvatar().isDisplayed());

    }
}
