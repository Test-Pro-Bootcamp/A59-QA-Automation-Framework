import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {
    ChromeOptions options = new ChromeOptions();
    @Test
    public void registrationNavigation() throws InterruptedException {
        // Pre-condition
        // add arguments for ChromeOptions to fix WebSock error
        options.addArguments("--remote-allow-origins=*");

        // Instantiate a WebDriver object
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 1 - Navigate to "https://qa.koel.app/"
        String url = "https://qa.koel.app/";
        driver.get(url);
        Thread.sleep(2000);

        // Step 2 - Click on Registration Link
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();
        Thread.sleep(2000);

        // Validate and Verify that Registration link was clicked on via Assertion
        String expectedURL = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        // Quit browser
        driver.quit();

    }
}
