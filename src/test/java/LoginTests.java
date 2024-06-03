import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void registrationNavigation(){

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), urlLogin);
        driver.findElement(By.linkText("Registration / Forgot password")).click();
    }


    @Test(enabled=false)
    public void loginValidEmailPassword() throws InterruptedException {

        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), urlLogin);
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), urlHome);

    //    driver.quit();
    }
}
