import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class Homework16 extends BaseTest {
    @Test
    public void  registrationNavigation()  {

//      Added ChromeOptions argument below to fix websocket error
        //Step 1
        String url = "https://qa.koel.app/";
        driver.get(url);


        //Step 2
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        registrationLink.click();


        
        //Step 3
        String urlRegistration = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), urlRegistration);
        driver.quit();
    }
    
}

