import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongTestLesson21 extends BaseTest {

@Test
    public void playSongWithRightClick() {

        //login
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();

        //Navigate to AllSongs Page
        navigateToChooseAllSongs();
        
        //ContextClick on the first song
        contextClickFirstSong();

        //Choose Play from context menu
        choosePlayOption();
        //Verify if Song being played.
        Assert.assertTrue(isSongPlaying());


    }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public void contextClickFirstSong() {
       WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated
               (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
       actions.contextClick(firstSongElement).perform();
    }

    public void navigateToChooseAllSongs() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs"))).click();

    }

    public boolean isSongPlaying(){
        WebElement songBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid = 'sound-bar-play']")));
        return songBarVisualizer.isDisplayed();

    }

}
