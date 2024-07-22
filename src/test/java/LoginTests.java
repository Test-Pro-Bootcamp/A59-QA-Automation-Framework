import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

import static Pages.LoginPage.provideEmail;


public class LoginTests extends BaseTest {
    private HomePage homePage;

    public LoginTests(HomePage homePage) {
        this.homePage = homePage;
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        provideEmail("demo@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }


    @Test
    public void loginValidEmailInvalidPassword(){
        provideEmail("demo@testpro.io");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.providePassword("tettudent");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
@Test
    public void loginInvalidEmailValidPassword(){

        provideEmail("@gmail.com");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.providePassword("te$t$tudent");
       loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

//      Added ChromeOptions argument below to fix websocket error
       /* ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments(("--no-sandbox"));
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
       */

        }
