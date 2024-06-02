import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16Test extends BaseTest{

   @Test
   public void  registrationNavigation() throws InterruptedException {

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");

       WebDriver driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();

       //Step1
       String url = "https://qa.koel.app/";
       driver.get(url);
       Thread.sleep(2000);
       //Step2
       WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
       registrationLink.click();
       Thread.sleep(2000);
       //Step3 Assertion
       String urlReg = "https://qa.koel.app/registration";
       Assert.assertEquals(driver.getCurrentUrl(), urlReg);
       driver.quit();

   }
}
