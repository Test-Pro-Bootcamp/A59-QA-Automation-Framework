import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaySongAndNextSongPage;


public class PlaySongAndNextSongTests extends BaseTest {

    @Test
    public void playSongs() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

 //     WHEN
        homePage.mouseOverPlayBtn();
        homePage.selectPlayBtnToSingleClick();

        Thread.sleep(3000);  // Wanted to give it a little time, so I notice next song is playing
        homePage.mouseOverPlayNextBtn();
        homePage.selectPlayNextBtnToSingleClick();

//      THEN
        Assert.assertTrue(basePage.isSongPlaying());
    }

    public void findSoundBars() {

        PlaySongAndNextSongPage playSongsAndNextPage = new PlaySongAndNextSongPage(driver);

        Assert.assertTrue(playSongsAndNextPage.selectSoundBars().isDisplayed());
    }
}
