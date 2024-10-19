import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeWorkTest18 extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {

        // navigate to page
        navigateToPage();
        //login
        enterEmail("apurva.singh@testpro.io");
        enterPassword("te$tpro$tudent1");
        submit();

        enterAllSongs();
        Thread.sleep(1000);
        selectSong();
        Thread.sleep(1000);
        enterButtonPlaySong();
        Thread.sleep(1000);
        clickPlayNextBtn();
        Thread.sleep(1000);

        assertTrue(isDisplayedPlayingSong());

    }

    private void enterAllSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        Thread.sleep(1000);
        allSongs.click();
    }
    private void selectSong() {
        WebElement song = driver.findElement(By.xpath("//tr[@class='song-item']"));
        song.click();
    }
    private void enterButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement(By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }
    private void clickPlayNextBtn() {
        WebElement playNext = driver.findElement(By.cssSelector("[class='next fa fa-step-forward control']"));
        playNext.click();
    }
    private boolean isDisplayedPlayingSong() {
        WebElement songIsPlaying = driver.findElement(By.xpath("//span[@title='Pause']"));
        return songIsPlaying.isDisplayed();
    }
}
