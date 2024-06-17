import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    ChromeOptions options = new ChromeOptions();
    @Test
    public void registrationNavigation() {
        // Pre-condition
        // add arguments for ChromeOptions to fix WebSock error
        options.addArguments("--remote-allow-origins=*");

        // Instantiate a WebDriver object
        WebDriver driver = new ChromeDriver(options);

    }
}
