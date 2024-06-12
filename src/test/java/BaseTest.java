import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver = null;
    WebDriverWait wait;
    Wait<WebDriver>fluentWait;
    Actions actions;

    //public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser (String baseURL){
        //pre-condition
        //added ChromeOptions
        ChromeOptions optionsChromeLocal = new ChromeOptions();
        optionsChromeLocal.addArguments("--disable-notifications","--remote-allow-origins=*","incognito","--start-maximized","-lang=en");
        driver = new ChromeDriver(optionsChromeLocal);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30));
        actions = new Actions(driver);
        driver.get(baseURL);

    }

    @AfterMethod
    public void closeBrowser(){
        if(driver !=null){
            driver.quit();
        }

    }
    public void login(String email, String password){
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("[type='submit']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}