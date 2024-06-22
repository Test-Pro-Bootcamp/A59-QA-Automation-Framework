import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import java.time.Duration;

public class RegistrationTest extends BaseTest {

    @Test
    public void clickRegistrationTest() {
        LoginPage loginPage = new LoginPage(driver);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//      String url = "https://qa.koel.app/";
        driver.get(urlStartPoint);

        loginPage.login();

        String urlRegistration = "http://qa.koel.app/registration";
        driver.findElement(By.linkText("Registration / Forgot password")).click();

        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);

//      driver.quit();
    }
}
