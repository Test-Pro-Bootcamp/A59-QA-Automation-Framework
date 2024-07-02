import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;
import pages.BasePage;

public class PlayListTests extends BaseTest {

    @Test
    public void addSongToPlaylist() {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login();

//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playlistName);
        driver.navigate().refresh();

        // search for a song
        playListPage.selectSearchSongField(songName);

        // click view all button
        playListPage.selectViewAllSongs();

        // select first song from result
        playListPage.selectFirstSong();
        // click Add to Button
        playListPage.selectAddSongToBtn();

        // choose list to add song to
        playListPage.selectChoosePlayList();

        playListPage.selectPlayListToDelete();

//      THEN
        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
    }
}
