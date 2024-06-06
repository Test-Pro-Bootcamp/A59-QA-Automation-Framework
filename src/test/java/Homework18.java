import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration; // Add this import for Duration

public class Homework18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
        // Given
        // Initialization of test data.

        // Performing actions: login, search song, select 1st results, add to playlist
        // LOGIN
        login("giovanna.silva@testpro.io", "ShakaMaya1302!");
        Thread.sleep(2000);

        // Hover over the play button to see the "play next" option
        hoverOverPlayButton();

        // Click «Play next song» (media player controls), then the Play button, to play a song.
        clickPlayNextSong();

        // Click «Play song» (media player controls)
        clickPlaySong();

        // Wait for the toggle visualizer button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Use Duration.ofSeconds(10) instead of just 10

        WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='toggle-visualizer-btn']")));

        // Assert that the toggle visualizer button is present and clickable
        Assert.assertNotNull(toggleButton, "Toggle visualizer button is not present or clickable");

        // Quitting the WebDriver session
        driver.quit();
    }

    public void hoverOverPlayButton() {
        // Locating the play button
        WebElement playButton = driver.findElement(By.xpath("//*[@id='mainFooter']/div[1]/span/span[2]"));

        // Creating Actions object
        Actions actions = new Actions(driver);

        // Performing hover over the play button
        actions.moveToElement(playButton).perform();
    }

    public void clickPlayNextSong() throws InterruptedException {
        // Locating and clicking the "Add To" button.
        WebElement playNext = driver.findElement(By.xpath("//i[@class='next fa fa-step-forward control']"));
        playNext.click();
        Thread.sleep(2000);
    }
    public void  clickPlaySong() throws InterruptedException {
        // Locating and clicking the "Add To" button.
        WebElement playSong = driver.findElement(By.xpath("//*[@title='Play or resume']"));
        playSong.click();
        Thread.sleep(2000);
    }
}