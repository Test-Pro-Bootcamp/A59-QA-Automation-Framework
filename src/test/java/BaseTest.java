import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    // This is a change
    // Another change
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}