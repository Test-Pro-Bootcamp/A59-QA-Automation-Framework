import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.time.Instant;

public class AllSongsTest extends BaseTest {

    @Test
    public void playSongWithRightClick() throws InterruptedException{

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AllSongsPage allSongsPage = new AllSongsPage(getDriver());

        // Login
        enterEmail(userName);
        enterPassword(userPassword);
        submit();

        // Navigate to All Songs Page
        navigateToChooseAllSongs();
        Thread.sleep(2000);
        // Right/Context Click on the first song
        contextClickFirstSong();
        Thread.sleep(2000);
        // Choose Play from context menu
        choosePlayOption();
        Thread.sleep(2000);
        // Verify if Song is being played
        Assert.assertTrue(isSongPlaying());
    }
    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("li.playback"))).click();
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() throws InterruptedException {
        WebElement firstSongElement= wait.until
                    (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));

        actions.contextClick(firstSongElement).perform();
    }

    public void navigateToChooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("li a.songs"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until
                    (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[data-testid = 'sound-bar-play")));

        return soundBarVisualizer.isDisplayed();
    }
}
