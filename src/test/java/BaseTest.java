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
import java.time.Duration;

public class BaseTest {
// Step 0 make WebDriver static
    public static WebDriver driver = null;
    //step2: public ChromeOptions options = new ChromeOptions();
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;
    public Actions actions = null;


    @BeforeSuite
    static void setupClass() {
        //WebDriverManager.chromedriver().setup();
        //step1 below and externalize setUp
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        /* Pre-condition
        - Added ChromeOptions argument below to fix websocket error
        - step2 comment out: options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "--lang=en");
        - step3 comment out: driver = new ChromeDriver(options);
        - step4 new firefox driver
        - driver = new FirefoxDriver();
        - step5: Not ideal to hardcode browsers so make it dynamic by creating browser method called here
         */

        driver = pickBrowser(System.getProperty("browser"));
        //driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);
    }
    // step 6: Add browser method and call the choice in the terminal
    public static WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        String gridURL = "http://192.168.1.121:4444";

        switch (browser) {
          case "firefox":
              WebDriverManager.firefoxdriver().setup();
              return driver = new FirefoxDriver();
              //break statement not necessary
          case "MicrosoftEdge":
              WebDriverManager.edgedriver().setup();
              EdgeOptions edgeOptions = new EdgeOptions();
              edgeOptions.addArguments("--remote-allow-origins=*");
              return driver = new EdgeDriver();
              //Edge and Safari require permission to automate
            //Grid Cases
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-firefox":
                caps.setCapability("browserName","firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":
                caps.setCapability("browserName","chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
          default:
              WebDriverManager.chromedriver().setup();
              ChromeOptions chromeOptions = new ChromeOptions();
              chromeOptions.addArguments("--remote-allow-origins=*");
              return driver = new ChromeDriver(chromeOptions);
// step7 - Update build.gradle file
// run of terminal as: gradle clean test  -Dbrowser=grid-firefox

      }
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void submit() throws InterruptedException {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();

    }

    protected void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailField = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }
}