import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.By;

public class Homework16 extends BaseTest {
    @Test
    public void registrationNavigation() {
        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Step 1- Navigate to the URL
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Step 2- Locate and click the Registration link
        WebElement registrationLink = driver.findElement(By.xpath("//a[text()='Registration']"));
        registrationLink.click();

        // Verify redirection to Registration page (replace "expected_registration_page_url" with actual URL)
        String expectedRegistrationPageUrl = "expected_registration_page_url";
        Assert.assertEquals(driver.getCurrentUrl(), expectedRegistrationPageUrl);

        // Close the browser
        driver.quit();
    }
}
