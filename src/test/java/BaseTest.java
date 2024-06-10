import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver = null;

    // Setting up WebDriverManager for Chrome before the test suite runs.
    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    // Method to set up WebDriver with Chrome options before each test method.
    @BeforeMethod
    //Use @Parameters for passing baseUrl from the TestNG config file to the tests.
    @Parameters({"BaseUrl"})
    public void launchBrowser(String baseUrl) {
        // Configuring Chrome options for local testing.
        ChromeOptions optionsChromeLocal = new ChromeOptions();
        optionsChromeLocal.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized", "--lang=en");
        driver = new ChromeDriver(optionsChromeLocal);

        // Configuring implicit wait for the driver and navigating to the specified URL.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to the specified URL.
        navigateToPage(baseUrl);
    }

    // Method to close the browser after each test method.
    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null; // Nullify the driver to avoid memory leaks.
        }
    }

    // Method for performing login action with provided email and password.
    public void login(String email, String password) {
        // Locating email, password, and login button elements and performing login action.
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    // Method to navigate to a specified URL.
    protected void navigateToPage(String url) {
        driver.get(url);
    }
}
