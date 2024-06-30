import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;
import pages.BasePage;

import java.sql.Driver;

public class PlayListTests extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        driver.navigate().refresh();

//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playlistName);
        // search for a song
        driver.navigate().refresh();
        playListPage.selectSearchSongField(songName);
        // click view all button
        playListPage.selectViewAllSongs();
        // select first song from result
        playListPage.selectFirstSong();
        // click Add to Button
        playListPage.selectAddSongToBtn();
        // select playlist to delete
        playListPage.selectChoosePlayList();
        // I need at least 1 of these thread.sleep, it just won't work without it.
        Thread.sleep(3000);
        playListPage.selectPlayListToDelete();

//      THEN
        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
    }
}
