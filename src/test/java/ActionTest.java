import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.AllSongsPage;
import page.HomePage;
import page.LoginPage;


public class ActionTest extends BaseTest {


    @Test
    public void playSongWithRightClick() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        loginPage.login();

        //Navigate to All Songs Page
        homePage.chooseAllSongsList();
        //Right/Context Click on the first song
        allSongsPage.contextClickFirstSong();
        //ChoosePlay from context menu
        allSongsPage.choosePlayOption();

        //Verify the song is being played.
        Assert.assertTrue(allSongsPage.isSongPlaying());


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

    public void chooseAllSong() {

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs"))).click();

    }

    public boolean isSongPlaying() {

        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-testid = 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }
}