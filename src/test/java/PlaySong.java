import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaySongPage;

public class PlaySong extends BaseTest {

    @Test

    public void playSong() {
        loginPage.login();
        playSongPage.playBtn();
        playSongPage.allSongs();
        Assert.assertTrue(playSongPage.getIsDisplayedSoundBar().isDisplayed());

    }

}