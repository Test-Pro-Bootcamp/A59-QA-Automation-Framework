import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "error-message")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }
}

public class LoginTest {
    @Test
    public void testValidLogin() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://example.com/login");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.login("validUser", "validPass");


            assertFalse(loginPage.isErrorDisplayed(), "Login should be successful");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testInvalidLogin() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://example.com/login");
            LoginPage loginPage = new LoginPage(driver);

            loginPage.login("invalidUser", "wrongPass");


            assertTrue(loginPage.isErrorDisplayed(), "Login should fail");
        } finally {
            driver.quit();
        }
    }
}



