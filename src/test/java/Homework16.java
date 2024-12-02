import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

// Registration Page Object
public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Registration Page URL
    private static final String REGISTRATION_URL = "https://your-application.com/register";

    // Registration Page Elements
    @FindBy(xpath = "//h1[contains(text(), 'Create Your Account')]")
    private WebElement registrationPageHeader;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Method to navigate to registration page
    public void navigateToRegistrationPage() {
        driver.findElement(By.linkText("Register")).click();
    }

    // Verify registration page is displayed
    public boolean isRegistrationPageDisplayed() {
        try {
            wait.until(ExpectedConditions.urlContains("/register"));
            return registrationPageHeader.isDisplayed() &&
                    driver.getCurrentUrl().contains(REGISTRATION_URL);
        } catch (Exception e) {
            return false;
        }
    }
}

// Base Test Configuration (as in previous example)
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://your-application.com"); // Replace with actual URL
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

// Registration Navigation Test Class
public class RegistrationNavigationTest extends BaseTest {

    @Test
    public void registrationNavigation() {
        // Initialize Registration Page
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Navigate to Registration Page
        registrationPage.navigateToRegistrationPage();

        // Assert Registration Page is Displayed
        Assert.assertTrue(
                registrationPage.isRegistrationPageDisplayed(),
                "Failed to navigate to Registration page"
        );

        // Additional Verification (Optional)
        // Verify specific elements are present on the registration page
        WebElement registerButton = driver.findElement(By.id("register-button"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button is not visible");
    }

    @Test
    public void verifyRegistrationPageElements() {
        // Additional test to verify registration page elements
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateToRegistrationPage();

        // Add more specific assertions about registration page elements
        Assert.assertTrue(
                driver.findElement(By.id("first-name")).isDisplayed(),
                "First name input is missing"
        );
        Assert.assertTrue(
                driver.findElement(By.id("email")).isDisplayed(),
                "Email input is missing"
        );
    }
}