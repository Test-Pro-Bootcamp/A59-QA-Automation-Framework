import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.annotation.meta.When;
import java.awt.*;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
```

        2. Login Page (LoginPage.java):
        ```java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By userField = By.id("username");
    private By passField = By.id("password");
    private By loginBtn = By.id("loginBtn");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        By driver;
        driver.findElement(userField).sendKeys(username);
        driver.findElement(passField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoggedIn() {
        WebDriver driver;
        return driver.getCurrentUrl().contains("/dashboard");
    }
}
```

        3. Login Test (LoginTest.java):
        ```java
package testcases;

import org.testng.Assert;
import org.testng.annotations.*;
        import pages.LoginPage;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.createDriver("chrome");
        loginPage = new LoginPage(driver);
        driver.get("https://example.com/login");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean expectedResult) {
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.isLoggedIn(), expectedResult);
    }

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        return new Object[][] {
                {"validUser", "validPass", true},
                {"invalidUser", "wrongPass", false}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
```

        4. Cucumber Feature (login.feature):
        ```gherkin
Taskbar.Feature: User Login
Scenario Outline: Login with different credentials
Given I am on the login page
When I login with "" and ""
Then login should be ""



        5. WebDriver Factory (WebDriverFactory.java):
        ```java
public class WebDriverFactory {
    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome": return new ChromeDriver();
            case "firefox": return new FirefoxDriver();
            default: throw new IllegalArgumentException("Unsupported browser");
        }
    }
}