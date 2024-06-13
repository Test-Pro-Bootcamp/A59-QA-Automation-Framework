import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {
@Test
    public void playSongWithRightClick() {
        enterEmail("kristina.sarkisyan@testpro.io");
        enterPassword("o8URUDnW");
        submit();
        navigateToAllSongs();
        contextClickFirstSong();
        choosePlayOption();
        Assert.assertTrue(isSongPlaying());
        }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li.playback"))).click();
    }

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
actions.contextClick(firstSongElement).perform();
    }

    public void navigateToAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }



}
