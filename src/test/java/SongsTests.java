
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SongsPage;

public class SongsTests extends BaseTest {

    @Test
    public void playSongs() throws InterruptedException {

        playSongBtn();
        Thread.sleep(5000);
        playNextSongBtn();
        findSoundBars();
        //    verifyDeleteNotificationMessage();
    }

    @Test
    public void playSongWithRightClick() throws InterruptedException{

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
//        enterEmail(userName);
//        enterPassword(userPassword);
//        submit();

        // Navigate to All Songs Page
        Thread.sleep(2000);
        navigateToChooseAllSongs();
        Thread.sleep(2000);
        // Right/Context Click on the first song
        contextClickFirstSong();
        Thread.sleep(2000);
        // Choose Play from context menu
        choosePlayOption();
        Thread.sleep(2000);
        // Verify if Song is being played
        isSongPlaying();
    }

    public void choosePlayOption() {

        SongsPage songsPage = new SongsPage(driver);
        songsPage.selectPlayBackBtn();

//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector("li.playback"))).click();
    }

    public void navigateToChooseAllSongs() {

        SongsPage songsPage = new SongsPage(driver);
        songsPage.selectAllSongsBtn();

//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() {

        SongsPage songsPage = new SongsPage(driver);

        songsPage.selectFirstSongInListn();

//        WebElement firstSongElement= wait.until
//                (ExpectedConditions.visibilityOfElementLocated
//                        (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//
//        actions.contextClick(firstSongElement).perform();
    }


    public void isSongPlaying() {

        SongsPage songsPage = new SongsPage(driver);
        Assert.assertTrue(songsPage.selectSoundBars().isDisplayed());

//        WebElement soundBarVisualizer = wait.until
//                (ExpectedConditions.visibilityOfElementLocated
//                        (By.cssSelector("[data-testid = 'sound-bar-play'")));
    }

    public void playNextSongBtn() {

        SongsPage songsPage = new SongsPage(driver);
        songsPage.selectPlayNextSongBtn();
    }

    public void playSongBtn() {

        LoginPage loginPage = new LoginPage(driver);
        SongsPage songsPage = new SongsPage(driver);

        loginPage.login();

        songsPage.selectPlaySongBtn();

    }

    public void findSoundBars() {

        SongsPage songsPage = new SongsPage(driver);

        Assert.assertTrue(songsPage.selectSoundBars().isDisplayed());

    }

    public void verifyDeleteNotificationMessage() {

        SongsPage songsPage = new SongsPage(driver);

        Assert.assertEquals(songsPage.selectVerifyNotificationMsg(), expectedDeleteMessage);

    }

}
