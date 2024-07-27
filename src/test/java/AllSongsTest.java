import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllSongsTest extends BaseTest {
    @Test
    public void playSongWithRightClick() {
        // Step 1 - Login
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent");
        submit();

        // Step 2 - Navigate to All Songs page
        navigateToAllSongsPage();

        // Step 3 - Right/Context click on the first song
        rightClickFirstSong();

        // Step 4 - Choose Play from context menu
        choosePlayOption();

        // Validate & verify song is playing via assertion
        WebElement soundBar = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']/img")));
        Assert.assertTrue(isSongPlaying());

    }

    public void choosePlayOption() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
    }

    public void rightClickFirstSong() {
        WebElement firstSong = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//div[@class='song-list-wrap main-scroll-wrap all-songs']//table/tr[1]")));

        actions.contextClick(firstSong).perform();
    }

    public void navigateToAllSongsPage() {
        wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@id='sidebar']//li/a[@class='songs']"))).click();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='sound-bar-play']/img")));
        return soundBarVisualizer.isDisplayed();
    }

}
