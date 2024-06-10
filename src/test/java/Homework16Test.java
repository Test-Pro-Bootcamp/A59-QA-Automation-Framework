import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation () throws InterruptedException {



        //navigateToPage();
        WebElement registrationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='registration']")));
        registrationBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.koel.app/registration"));
        driver.quit();








    }




}
