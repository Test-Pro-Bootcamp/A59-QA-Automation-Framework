import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.net.URI;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;


public class BaseTest {

    public static WebDriver driver = null;
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;
    public Actions actions = null;
    public ChromeOptions options = new ChromeOptions();
    //public String url = "https://qa.koel.app/";

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }


    @BeforeSuite
    static void setupClass() {

        // WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }

    /*@BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(@Optional("https://qa.koel.app/") String baseURL) throws MalformedURLException {
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--start-maximized");

        driver = pickBrowser(System.getProperty("browser"));
        //driver = new ChromeDriver(options);
        // driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        url = baseURL;
        driver.get(url);

    }*/


    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(@Optional("https://qa.koel.app/") String baseURL) throws MalformedURLException {
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--start-maximized");

        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver = new ChromeDriver(options);
        // driver = new FirefoxDriver();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().window().maximize();

        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage((baseURL));

        actions = new Actions(driver);
        //url = baseURL;
        // driver.get(url);

    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement PasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        PasswordField.clear();
        PasswordField.sendKeys(password);
    }

    public void submit() {
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitBtn.click();
    }

    /*@AfterMethod
    public void closeBrowser() {
        driver.quit();
    }*/


    public void navigateToPage(String url) {
        driver.get(url);
    }

    public static WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability();


        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("125");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "brittany.torelli");
        ltOptions.put("accessKey", "Xa59dX4BCFPTn5Cwgt8cZzw0C8x3Kk12lG58jZXcgNhgxCian7");
        ltOptions.put("project", "Untitled");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);

    }

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.80:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            //Grid Cases

            case "grid-edge":
                caps.setCapability("browser", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);


            case "grid-firefox":
                caps.setCapability("browser", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":
                caps.setCapability("browser", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud": return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }

    }
}