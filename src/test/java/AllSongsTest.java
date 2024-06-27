import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {


    @Test
    public void playSongWithRightClick() throws InterruptedException {


        //Login
        enterEmail("christina.taylor@testpro.io");
        enterPassword("jKV0uSX6z1dv");
        submit();

        //Navigate to All Songs Page
        navigateToChooseAllSong();
        Thread.sleep(1000);
        //Right/Context Click on the first song
        contextClickFirstSong();

        //ChoosePlay from context menu
        choosePlayOption();
        Thread.sleep(1000);
        //Verify the song is being played.
        Assert.assertTrue(isSongPlaying());
        Thread.sleep(1000);

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

    public void navigateToChooseAllSong() {

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs"))).click();

    }

    public boolean isSongPlaying() {

        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-testid = 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
}