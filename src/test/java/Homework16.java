import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
        String url = "https://qa.koel.app/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement registrationlink = driver.findElement(By.cssSelector("a[href='registration'"));
        registrationlink.click();
        Thread.sleep(3000);

        // Now use an Assert to evaluate whether the test passes as expected.
        String registration_url = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(),registration_url);

        driver.quit();
    }
}
