import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    WebDriverWait wait;
    Wait<WebDriver> fluentWait;
    String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser(){
        // Pre-condition
        // Added ChromeOptions argument below to fix websocket error
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       fluentWait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(5))
               .pollingEvery(Duration.ofMillis(200));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    protected void submit() throws InterruptedException {
       // WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
       // to make it in a simplified way and above line and thread.sleep lime can be clubbed in a below way.
       WebElement submit = wait .until
               (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();
        Thread.sleep(1000);
    }

    protected void enterPassword(String password) {
      //  WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void enterEmail(String email) {

        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void navigateToPage() {
        driver.get(url);
    }
}