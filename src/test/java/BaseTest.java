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
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

import java.net.URI;
import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public WebDriverWait wait = null;
    public Wait<WebDriver> fluentWait;
    public Actions actions = null;

    //String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException{
        //      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(BaseURL);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }


    public static WebDriver pickBrowser(String browser) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://172.20.10.13:4444";
        switch (browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();

                //Grid Cases
            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);


            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Old Methods
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    protected void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    protected void submit() {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
    }

}