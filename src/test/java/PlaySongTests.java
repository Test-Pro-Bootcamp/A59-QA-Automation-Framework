import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaySongsPage;
import pages.BasePage;

public class PlaySongTests extends BaseTest {

    @Test
    public void playSongs() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        PlaySongsPage playSongsPage = new PlaySongsPage(driver);
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        Thread.sleep(2000);

 //     WHEN
        homePage.mouseOverPlayBtn();
        homePage.selectPlayBtnToSingleClick();

        Thread.sleep(3000);  // Wanted to give it a little time, so I notice next song is playing
        homePage.mouseOverPlayNextBtn();
        homePage.selectPlayNextBtnToSingleClick();

//      THEN
        Assert.assertTrue(basePage.isSongPlaying());
    }

    public void playSongBtn() throws InterruptedException {

        PlaySongsPage playSongsPage = new PlaySongsPage(driver);

        playSongsPage.selectPlaySongBtn();
    }

    public void playNextSongBtn() throws InterruptedException {

        PlaySongsPage playSongsPage = new PlaySongsPage(driver);

        playSongsPage.selectPlayNextSongBtn();
    }

    public void findSoundBars() throws InterruptedException {

        PlaySongsPage playSongsPage = new PlaySongsPage(driver);

        Assert.assertTrue(playSongsPage.selectSoundBars().isDisplayed());

    }
}
