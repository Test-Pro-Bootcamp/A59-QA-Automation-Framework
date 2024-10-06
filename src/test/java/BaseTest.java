import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    // we are making these members below a public scope (by adding the public keyword)
    public static WebDriver driver = null;
    // public ChromeOptions options;
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;
    public Actions actions;
    public Robot robot;

    // String url = "https://qa.koel.app/";
    @DataProvider(name = "NegativeLoginTestData")
    public Object[][] getDataFromDataProviders() {
        return new Object[][] {
                {"invalid@testpro.io","invalidPassword"},
                {"leon.poyau+2@testpro.io","invalidPassword"},
                {"invalid@testpro.io","N6wWY2Rx"},
                {"leon.poyau+2@testpro.io",""},
                {"","N6wWY2Rx"},
        };
    }
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws AWTException, MalformedURLException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        // options = new ChromeOptions();
        // options.addArguments("--remote-allow-origins=*");
        // driver = new ChromeDriver(options);
          // driver = new FirefoxDriver();
        // Replaced above lines with line below to dynamically assign a browser value for driver using pickBrowser()   method
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        robot = new Robot();

        // using fluentWait took a long time for span.name element to be interactable and clicked on in
        // navigateToProfilePage() method called in changeProfileName() method
        // Even with Thread.sleep() used after login() method in ProfileTests class. This is almost useless.
        // Best to use wait along with Thread.sleep(1500) after login() in changeProfileName that's in ProfileTests class
        // There are times that we indeed cannot get away from Thread.sleep(). This is such an example.
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }
    // Browser Factory method allowing us to create an instance of any browser on Selenium Grid and run our tests remotely
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.50.193:4444";
        switch(browser) {
            case "firefox": // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "microsoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome": // gradle clean test -Dbrowser=chrome
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    /////////////////////////////////////////////////////////////////////////////
    // OLD METHODS
    /////////////////////////////////////////////////////////////////////////////

    protected void submit()  {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
        //Thread.sleep(1000);
        robot.delay(2000);
    }

    protected void enterPassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void enterEmail(String email) {
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }


}