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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

import static org.openqa.selenium.chrome.ChromeOptions.*;


public class BaseTest {

    static WebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    String url = "https://qa.koel.app/";
    WebDriverWait wait;
    Wait<WebDriver> fluentwait;
    Actions actions;


    @BeforeSuite
    static void setupClass() {
      // WebDriverManager.chromedriver().setup();
        // for firefox browser
       //WebDriverManager.safaridriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String baseUrl) throws MalformedURLException {

        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        //not to hard code the browser we made the method at the bottom named picked browser
        driver=pickBrowser(System.getProperty("browser"));
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
       // for fire fox browser
       // driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        navigateToPage(baseUrl);
        fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));

        actions= new Actions(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void submit() throws InterruptedException {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
        Thread.sleep(1000);
    }

    protected void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }

    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();

    }

    public static WebDriver pickBrowser (String browserName) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.1.207:4444/";

    switch(browserName){

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return driver = new FirefoxDriver();
        case "MicrosoftEdge":
            WebDriverManager.edgedriver().setup();
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--remote-allow-origins=*");
            return driver = new EdgeDriver(edgeOptions);

            // grid related browser
        case "grid-edge":
            caps.setCapability("browser Name","Microsoftdge");
            return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);

        case "grid-firefox":
            caps.setCapability("browser Name","firefox");
            return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);

        case "grid-chrome":
            caps.setCapability("browser Name","chrome");
            return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);

        default:
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            return driver = new ChromeDriver(chromeOptions);

    }

    }
}