import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation () throws InterruptedException {



        navigateToPage();
        Thread.sleep(2000);
        WebElement registrationBtn = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationBtn.click();
        Thread.sleep(2000);
        //Assertion - Expected vs Actual
        Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.koel.app/registration"));
        //Post-Condition
        driver.quit();








    }




}
