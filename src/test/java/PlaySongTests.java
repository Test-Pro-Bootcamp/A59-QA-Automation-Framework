import org.testng.Assert;
import org.testng.annotations.Test;
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

        loginPage.login();
        Thread.sleep(2000);

 //     WHEN
        playSongsPage.mouseOverPlayBtn();
        playSongsPage.selectPlayBtnToSingleClick();

        Thread.sleep(3000);  // Wanted to give it a little time so I notice next song is playing
        playSongsPage.mouseOverPlayNextBtn();
        playSongsPage.selectPlayNextBtnToSingleClick();

//      THEN
        Assert.assertTrue(playSongsPage.selectSoundBars().isDisplayed());
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
