import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("leon.poyau@testpro.io");
        enterPassword("jTRCkwNf");
        submit();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        // Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    @Test
    public void loginEmptyEmailValidPassword() throws InterruptedException {
        navigateToPage();
        enterPassword("jTRCkwNf");
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        navigateToPage();
        enterEmail("leon.poyau@testpro.io");
        submit();

        Thread.sleep(2000); // Sleep or pause for 2 seconds (adjust as needed)
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), url); //https://qa.koel.app/
    }
}
