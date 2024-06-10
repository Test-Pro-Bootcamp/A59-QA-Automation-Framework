import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    WebDriver driver = null;
    ChromeOptions options = new ChromeOptions();

    String url = "https://qa.koel.app/";
    String email = "demo@testpro.io";
    String password = "te$t$tudent";
    //String email = "oksana.chaklosh@testpro.io";
    //String password = "8qUBYosp";


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String baseURL){
        //Pre-Condition
        //Added ChromeOptions argument below to fix websocket error
        /*--remote-allow-origins=* argument suggests allowing remote origins. It means that
        the application will accept requests from any remote origin, which can be helpful for testing
        scenarios where requests are made from various sources.
        */
       options.addArguments("--remote-allow-origins=*");
       /*--disable-notifications argument suggests disabling notifications. This could be useful during
       automated testing to prevent interruptions from notifications that may interfere with the testing process.
        */
       options.addArguments("--disable-notifications");
       /*--incognito argument indicates launching the application in incognito mode. Incognito mode typically
       means that the browser doesn't store browsing history or cookies, which can be beneficial for testing
       scenarios where a clean browsing session is required.
        */
       options.addArguments("--incognito");
       options.addArguments("--start-maximized");
       /*This setting seems to be specific to ChromeDriver, a tool for automated testing with Google Chrome.
       It suggests excluding the switch enable-automation, which is a Chrome feature indicating that Chrome is
       being controlled by automated test software. By excluding this switch, it can help avoid detection by
       websites or applications that may behave differently when they detect automated testing.
        */
       options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage(baseURL);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
        }

    protected void navigateToPage(String url) {
        driver.get(url);
    }

    protected void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }

    protected void submit() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }
}

    //This is a change
