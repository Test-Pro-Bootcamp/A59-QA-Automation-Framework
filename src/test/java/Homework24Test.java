import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.HomePage;
import pageFactory.LoginPageFromFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class Homework24Test extends BaseTest{
    public static WebDriver getDriver = null;
    public ChromeOptions options = new ChromeOptions();
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;
    public Actions actions = null;


    public void navigateToPage(String url) {
        getDriver().get(url);
    }
@Test
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.108:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }
    @Test
    public void loginValidEmailPassword()  {
        LoginPageFromFactory loginPageFromFactory = new LoginPageFromFactory(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPageFromFactory.provideEmail("kristina.sarkisyan@testpro.io").providePassword("o8URUDnW").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());


    }
}
