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

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver = null;
    public ChromeOptions options = new ChromeOptions();
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;
    public Actions actions = null;
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
//String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
       // WebDriverManager.firefoxdriver().setup();
    }

    /*@BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        //Pre-Condition
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--disable-notifications");
        //options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
       // driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);

    }*/
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);
    }

    public void navigateToPage(String url) {
        getDriver().get(url);
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.108:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();
            case "grid-edge":
                caps.setCapability("browserName", "Microsoft Edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud": return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

/////////////////////////////////////////////////////////
    //old methods
    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submit() {
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }
    /*@AfterMethod
    public void closeBrowser() {
        driver.quit();*/
@AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }
public static WebDriver lambdaTest() throws MalformedURLException {
    String hubUrl = "https://hub.lambdatest.com/wd/hub";

    /*DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability();*/


    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("125");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", "kristina.sarkisyan");
    ltOptions.put("accessKey", "lN8L2Ud26CKRzPuuPha4aisuzaDqBBdfqphMuRYiYRP8iXU6KI");
    ltOptions.put("build", "TestProBuild");
    ltOptions.put("project", "Homework-25");
    ltOptions.put("selenium_version", "4.0.0");
    ltOptions.put("w3c", true);
    browserOptions.setCapability("LT:Options", ltOptions);

    return new RemoteWebDriver(new URL(hubUrl), browserOptions);

}



}