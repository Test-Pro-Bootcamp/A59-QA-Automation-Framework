import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected Actions actions;

    @BeforeSuite

        public static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }


    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser(String baseUrl) {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver); // Initialize Actions after driver creation
        navigateToPage(baseUrl);*/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Initialize Actions object
        actions = new Actions(driver); // Initialize Actions after driver creation

        navigateToPage(baseUrl);

    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public void login(String email, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }
}