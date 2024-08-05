import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class HomeTest extends BaseTest {

    @Test
    public void hoverOverPlayButtonAndPlaySong() {
        // Step 1 - Login into Koel App.
        // -- Note - Navigate to Koel app login page already done with BaseTest @BeforeMethod
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
        // Thread.sleep(2000);

        // Step 2 - Hover over play button. Is button visible?
        Assert.assertTrue(hoverPlay().isDisplayed());

        // Step 3-  Click on play button and play a song
        clickOnVisiblePlayButton(hoverPlay());

        // Thread.sleep(900);
        // Step 5 - Validate/verify song is playing via assertion. Is the sound-bar displayed?
        Assert.assertTrue(isSongPlaying());
    }

    // Helper Methods
    @Test
    public void countSongsInPlaylist() {
        // Step 1 - Login into Koel App.
        // -- Note - Navigate to Koel app login page already done with BaseTest @BeforeMethod
        enterEmail("leon.poyau@testpro.io");
        enterPassword("jTRCkwNf");
        submit();

        // Step 2 - Find specific playlist element and click on it to select it. choose a playlist by name
        choosePlaylistByName("TestPro Playlist");

        // Display all songs

        // Verify number of songs in the playlist equals to what is displayed in the info section
        // Step 3 - Count the number of songs in the play list
        
    }

    public void choosePlaylistByName(String playlistName) {
//        WebElement playlist = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//li[4]")));
                wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='playlists']//li[contains(text(),'"+playlistName+"')]"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }

    public WebElement hoverPlay() {
        // Xpath locator //footer[@id='mainFooter']//span[@class='play']
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playBtn).perform();
        return wait.until(ExpectedConditions.visibilityOf(playBtn));
    }

    public void clickOnVisiblePlayButton(WebElement btn) {
        // WebElement playBtn = hoverPlay();
        btn.click();
    }
}
