import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;

import java.net.URI;
import java.net.MalformedURLException;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
//    public static WebDriver driver = null;
    public static ChromeOptions options = new ChromeOptions();
    public static WebDriverWait wait;
    public static Wait<WebDriver> fluentWait;
    public static Actions actions = null;

//    String url = "https://qa.koel.app/";
//
//    String expectedCreatedMsg = "Created playlist " + "\"TestPro Playlist.\"";
//    String expectedDeletedMsg = "Delete playlist " + "\"TestPro Playlist.\"";
//    String expectedAddedMsg = "Added 1 song into " + "\"TestPro Playlist.\"";
//    String songName = "grav";
//    String playlistName = "TestPro Playlist";
//    String userName = "demo@testpro.io";
//    String userPassword = "te$t$tudent";

    protected String urlStartPoint =        "https://qa.koel.app/";
    protected String songName =             "grav";
    protected String playlistName =         "TestPro Playlist";
    protected String userName =             "demo@testpro.io";
    protected String userPassword =         "te$t$tudent";
    protected String userEmail =            "demo@testpro.io";
    protected String expectedCreatedMsg =   "Created playlist \""  + playlistName + ".\"";
    protected String expectedDeletedMsg =   "Deleted playlist \""  + playlistName + ".\"";
    protected String expectedAddedMsg =     "Added 1 song into \"" + playlistName + ".\"";



    ///////////////////////////////////////////////////


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error for Chrome
//        options.addArguments("--remote-allow-origins=*");   // allowing remote origins
//        options.addArguments("--disable-notifications");    // disabling notifications
//
//        options.addArguments("--incognito");                // launching in incognito mode
//        options.addArguments("--window-position=250,0");    // move the window over to the right
//        driver = new ChromeDriver(options);

//      options.addArguments("--start-maximized");          // launching in maximized mode


//        End of Chrome Options

//        driver = new FirefoxDriver();
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);
    }

    protected void navigateToPage(String url) {

        driver.get(url);
    }

    ///////////////
    // OLD METHODS
    ///////////////

    protected void enterEmail(String email) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(email);
    }

    protected void enterPassword(String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.providePassword(password);
    }

    protected void submit() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickSubmit();
    }

    @AfterMethod
    public void closeBrowser() {
//  driver.quit();
    }
    //throw MalformedURLException
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

         String gridURL = "http://192.168.55.103:4444";  //replace with your gird url,  localhost:4444
//        String gridURL = "http://localhost:4444";  //replace with your gird url,  localhost:4444

        switch(browser) {
            case "firefox":  // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--remote-allow-origins=*");
                firefoxOptions.addArguments("-width=1920", "-height=1020", "-private");
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                return driver = new FirefoxDriver();

            case "edge":   // gradle clean test -Dbrowser=edge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");   // Allow automations to be run
                edgeOptions.addArguments("--disable-notifications");    // disabling notifications
                edgeOptions.addArguments("--inprivate");                // launching in incognito mode
                edgeOptions.addArguments("--window-position=250,0");    // move the window over to the right
                return driver = new EdgeDriver();

            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": // gradle clean test - Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver  = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":  // gradle clean test - Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--Remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");    // disabling notifications
                chromeOptions.addArguments("--incognito");                // launching in incognito mode
                chromeOptions.addArguments("--window-position=250,0");    // move the window over to the right
                return driver = new ChromeDriver(chromeOptions);
        }
    }
}