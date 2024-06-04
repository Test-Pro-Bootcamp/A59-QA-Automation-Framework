import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = null;
    ChromeOptions options = new ChromeOptions();
    String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
        @BeforeMethod
        public void launchBrowser () {

            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();


        }

        @AfterMethod
        public void closeBrowser () {
            driver.quit();

        }


    protected void submit() {
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        submitBtn.click();
    }

    protected void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type=password]"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type=email]"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void navigateToPage() {
        driver.get(url);
    }
}

