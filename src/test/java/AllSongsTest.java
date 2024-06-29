import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {


    @Test
    public void playSongWithRightClick()  {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        //Navigate to All Songs Page
        navigateToChooseAllSong();

        //Right/Context Click on the first song
        contextClickFirstSong();

        //ChoosePlay from context menu
        choosePlayOption();

        //Verify the song is being played.
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