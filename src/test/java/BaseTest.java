import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {


   public  WebDriver driver= null;
   public  ChromeOptions options = new ChromeOptions();
   public   WebDriverWait wait;
   public  FluentWait<WebDriver> fluentWait;
   public Actions actions = null;



   // String url = "https://qa.koel.app/";
  //  String password = "jKV0uSX6z1dv";
 //   String email = "christina.taylor@testpro.io";
@BeforeSuite

    static void setup() {
WebDriverManager.chromedriver().setup();

}
        @BeforeMethod
        @Parameters({"BaseURL"})
        public void launchBrowser(String baseURL){

            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);

            fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(200));
            navigateToPage(baseURL);


        }
 @AfterMethod

    public void closeBrowser(){
    driver.quit();
 }

    protected void submit()  {
        WebElement submit =wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[type='submit']")));
        submit.click();

    }

    protected void enterPassword(String password) {
       // WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    protected void enterEmail(String email) {
       // WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    protected void navigateToPage(String url) {
        driver.get(url);
    }
}


