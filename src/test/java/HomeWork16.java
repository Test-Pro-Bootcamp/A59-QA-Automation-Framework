import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

   public class HomeWork16 {

       //Test Case Registration Navigation
       @Test
       public void RegistrationNavigation() throws InterruptedException {
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--remote-allow-origins=*");

           WebDriver driver = new ChromeDriver(options);
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.manage().window().maximize();

           String url = "https://qa.koel.app/";
           driver.get(url);
           Thread.sleep(2000);

           WebElement registrationLink = driver.findElement(By.linkText("Registration"));
           registrationLink.click();

           String expectedTitle = "Registration";
           String actualTitle = driver.getTitle();
           Assert.assertEquals(expectedTitle, actualTitle);
           driver.quit();
       }

   }

   //