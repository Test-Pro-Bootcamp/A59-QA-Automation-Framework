import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import pages.PlayListPage;

import java.net.URI;
import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;



public class BaseTest {

    public static WebDriver driver = null;
    public static ChromeOptions options = new ChromeOptions();
    public static WebDriverWait wait;
    public static Wait<WebDriver> fluentWait;
    public static Actions actions = null;
    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static final ThreadLocal<WebElement>dynamicDriver = new ThreadLocal<>();

    // This method returns the WebDriver instance stored in the ThreadLocal variable.
    public static WebDriver getDriver() {

        return threadDriver.get();
    }

    public static WebElement getDynamicDriver() {

        return dynamicDriver.get();
    }

//    String url = "https://qa.koel.app/";
//
//    String expectedCreatedMsg = "Created playlist "  + "\"TestPro Playlist.\"";
//    String expectedDeletedMsg = "Delete playlist "   + "\"TestPro Playlist.\"";
//    String expectedAddedMsg =   "Added 1 song into " + "\"TestPro Playlist.\"";
//    String songName = "grav";
//    String playlistName = "TestPro Playlist";
//    String userName = "demo@testpro.io";
//    String userPassword = "te$t$tudent";

    protected String urlStartPoint =        "https://qa.koel.app/";
    protected String songName =             "grav";
    protected String userName =             "demo@testpro.io";
    protected String userPassword =         "te$t$tudent1";
    protected String userEmail =            "demo@testpro.io";
    protected String expectedCreatedMsg =   "Created playlist \""  + PlayListPage.playlistName + ".\"";
    protected String expectedAddedMsg =     "Added 1 song into \"" + PlayListPage.playlistName + ".\"";
    protected String expectedDeletedMsg =   "Deleted playlist \""  + PlayListPage.playlistName + ".\"";

    protected String playlistNameWithZeroCharacters =   "";

    protected String playlistNameWithOneCharacter =     PlayListPage.playlistNameWithOneCharacter;
    protected String expectedCreatedMsgOneCharacter =   "Created playlist \""  + PlayListPage.playlistNameWithOneCharacter + ".\"";
    protected String expectedAddedMsgOneCharacter =     "Added 1 song into \"" + PlayListPage.playlistNameWithOneCharacter + ".\"";
    protected String expectedDeletedMsgOneCharacter =   "Deleted playlist \""  + PlayListPage.playlistNameWithOneCharacter + ".\"";

    protected String playlistNameWith256Characters =    PlayListPage.playlistNameWith256Characters;
    protected String expectedCreatedMsg256Character =   "Created playlist \""  + PlayListPage.playlistNameWith256Characters + ".\"";
    protected String expectedAddedMsg256Character =     "Added 1 song into \"" + PlayListPage.playlistNameWith256Characters + ".\"";
    protected String expectedDeletedMsg256Character =   "Deleted playlist \""  + PlayListPage.playlistNameWith256Characters + ".\"";


    ///////////////////////////////////////////////////


    @BeforeSuite
    static void setupClass() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
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

        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // was 10
//        getDriver().manage().window().maximize();
        System.out.println("Browser setup by Thread "
                + Thread.currentThread().getId()
                + " and Driver reference is : "
                + getDriver());

//        driver = pickBrowser(System.getProperty("browser"));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        getDriver().manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // was 10

        fluentWait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);
    }

    protected void navigateToPage(String url) {

        getDriver().get(url);
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

    // This method selects the browser based on the provided input and returns the corresponding WebDriver instance.
    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

         String gridURL = "http://192.168.55.103:4444";  //replace with your gird url,  localhost:4444
//        String gridURL = "http://localhost:4444";  //replace with your gird url,  localhost:4444

        switch(browser) {
            case "firefox":  // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--no-notifications");
                firefoxOptions.addArguments("-width=1920", "-height=1020", "-private");
                firefoxOptions.addPreference("dom.webnotifications.enabled", false);
                return driver = new FirefoxDriver(firefoxOptions);

            case "edge":          // gradle clean test -Dbrowser=edge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");   // Allow automations to be run
                edgeOptions.addArguments("--disable-notifications");    // disabling notifications
                edgeOptions.addArguments("--inprivate");                // launching in incognito mode
                edgeOptions.addArguments("--window-position=250,0");    // move the window over to the right
                return driver = new EdgeDriver();

            case "grid-edge":    // gradle clean test -Dbrowser=grid-edge
                caps.setCapability("browserName", "edge");
                return driver = new  RemoteWebDriver(URI.create(gridURL).toURL(), caps);
//            return driver = driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
//            return driver = driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome":  // gradle clean test -Dbrowser=grid-chrome
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
//            return driver = driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-cloud":   // gradle clean test -Dbrowser=grid-cloud
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--Remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");    // disabling notifications
                chromeOptions.addArguments("--incognito");                // launching in incognito mode
                chromeOptions.addArguments("--window-position=250,0");    // move the window over to the right
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    @AfterMethod
    public void tearDown() {

        threadDriver.get().close();
        threadDriver.remove();
    }

//    @AfterMethod
//    public void closeBrowser() {
//
//      driver.quit();
//    }

    public static WebDriver lambdaTest() throws MalformedURLException {

        String hubURL = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("125");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("browserVersion", "125");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("user", "james.mar");
        ltOptions.put("accessKey", "BePEK6FjkSm4CLTUXloeqsEjqTVc0zVrrhNsVmMzTMOHT1T84n");
        ltOptions.put("build", "TestProBuild");
        ltOptions.put("project", "CloudExecution");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", browserOptions);

        return new RemoteWebDriver(new URL(hubURL), caps);
    }
}