
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;

import java.time.Duration;


public class BaseTest {
    public WebDriver driver = null;
    public WebDriverWait wait;
    public Actions actions = null;
    public ChromeOptions options = new ChromeOptions();
    public String url = "https://qa.koel.app/";


    String email = "demo@testpro.io";
    String password = "te$t$tudent";
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

@BeforeMethod
@Parameters({"BaseURL"})
public void launchBrowser(@Optional("https://qa.koel.app/") String baseURL) {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-notifications","--remote-allow-origins=*","--start-maximized");

    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    actions = new Actions(driver);
    url = baseURL;
    driver.get(url);

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
    driver.quit();

    }
}