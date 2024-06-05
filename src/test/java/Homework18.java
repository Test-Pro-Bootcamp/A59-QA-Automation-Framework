import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        // GIVEN
        // Initialization of test data.
        // WHEN
        // Performing actions: login, select the play next song btn.
        login("india.messam@testpro.io", "slcTalgy");
        Thread.sleep(2000);

      }

    // Find and click the Play next song.
    public void playSong(String nameSong) throws InterruptedException {
        // Locating the play next song btn.
        WebElement searchField = driver.findElement(By.cssSelector("title='Play next song']"));
        searchField.sendKeys(nameSong);
        Thread.sleep(2000);


    }
}



