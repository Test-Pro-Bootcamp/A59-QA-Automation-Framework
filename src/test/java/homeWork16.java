import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class homeWork16 extends BaseTest {

    @Test
    public void registrationNavigation(){


        String registrationPage = "https://qa.koel.app/registration";


        String url = "https://qa.koel.app/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(url);
        WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        registrationLink.click();
        Assert.assertEquals(driver.getCurrentUrl(),registrationPage);


    }

}
