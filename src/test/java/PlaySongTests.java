import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongTests extends BaseTest {

    @Test
    public void playSongs() throws InterruptedException {

        String expectedMessage = null;

        // Given
     //   navigateToPage();
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();
        Thread.sleep(2000);

        // When
        playNextSongBtn();
        playSongBtn();
        findSoundBars();

        // Then
        Assert.assertTrue(findSoundBars());
    }

    public void playNextSongBtn() throws InterruptedException {
        WebElement playNextSong = driver.findElement(By.xpath("//i[@role=\"button\"][@title=\"Play next song\"][@data-testid=\"play-next-btn\"]"));
        playNextSong.click();
        Thread.sleep(2000);
    }
    public void playSongBtn() throws InterruptedException {
        WebElement playSong = driver.findElement(By.xpath("//span[@title=\"Play or resume\"][@data-testid=\"play-btn\"]//i[@class=\"fa fa-play\"]"));
        playSong.click();
        Thread.sleep(2000);
    }

    public boolean findSoundBars() throws InterruptedException {
        WebElement verifySoundBar = driver.findElement(By.xpath("//div[@data-test=\"soundbars\"][@class=\"bars\"][@data-testid=\"sound-bar-play\"]"));
        return verifySoundBar.isDisplayed();
    }
}
