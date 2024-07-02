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

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        String urlRegistration = "https://qa.koel.app/registration";

//      WHEN
        loginPage.selectRegistrationLink();

//      THEN
        Assert.assertEquals(loginPage.selectCurrentPage(), urlRegistration);

//     driver.quit();
    }
}
