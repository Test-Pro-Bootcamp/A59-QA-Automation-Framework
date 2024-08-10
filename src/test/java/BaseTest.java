import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class BaseTest {

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    public static WebDriver driver = null;
    public WebDriverWait wait;
    public Actions actions = null;
    public ChromeOptions options = new ChromeOptions();
    public String url = "https://qa.koel.app/";


    String email = "rfkayoub12@gmail.com";
String password = "te$t$tudent";
    @BeforeSuite
    static void setupClass() {

        //  WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }



    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        //ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--disable-notifications","--remote-allow-origins=*","--start-maximized");

        //  driver = new ChromeDriver(options);
       // driver = new FirefoxDriver();
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        threadDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         wait = new WebDriverWait(threadDriver.get(), Duration.ofSeconds(10));
         actions = new Actions(threadDriver.get());
        url = baseURL;
        threadDriver.get().get(url);

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
    public void submit(){
        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submitBtn.click();
    }

    @AfterMethod
    public void closeBrowser() {

        threadDriver.get().close();
        threadDriver.remove();
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.248:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                 return driver = new FirefoxDriver();

            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--start-maximized");
               return driver = new ChromeDriver(options);
        }


    }

    public static WebDriver lambdaTest() throws MalformedURLException {

        String hubUrl = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("125");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "ayoub.rafiqui");
        ltOptions.put("accessKey", "6LidJdX30K6sCilU2bVnJGObjIMdEBOY1SdXEARYgNDejUr7KF");
        ltOptions.put("build", "TestProBuild");
        ltOptions.put("project", "CloudExecution");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubUrl), browserOptions);

    }
}
