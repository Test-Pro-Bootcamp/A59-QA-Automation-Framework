import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import java.sql.Driver;
import java.time.Duration;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    protected void navigateToPage() {

    }

    protected void enterEmail(String emailAddress) {

    }

    protected void enterPassword(String password) {

    }

    protected void submit() {

    }
}
