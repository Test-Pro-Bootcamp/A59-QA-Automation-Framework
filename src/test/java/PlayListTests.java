import org.testng.Assert;
import org.testng.annotations.Test;
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
        loginPage.login();
        Thread.sleep(2000);

//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playlistName);
        // search for a song
        driver.navigate().refresh();
        playListPage.selectSearchSongField(songName);
        // click view all button
        Thread.sleep(2000);
        playListPage.selectViewAllSongs();
        // select first song from result
        playListPage.selectFirstSong();
        // click Add to Button
        playListPage.selectAddSongToBtn();
        // select playlist to delete
        playListPage.selectChoosePlayList();
//        driver.navigate().refresh();
        Thread.sleep(3000);
        playListPage.selectPlayListToDelete();

//      THEN
        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
    }

    public void createPlayListBtn(String playlistName) {

        PlayListPage playListPage = new PlayListPage(driver);
        BasePage basePage = new BasePage(driver);

        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playlistName);

//        Assert.assertEquals(playListPage.selectCreatedVerifyNotificationMsg(), expectedCreatedMsg);
    }

    public void deletePlayListBtn() {

        PlayListPage playListPage = new PlayListPage(driver);
//        driver.navigate().refresh();
//        playListPage.selectPlayListToDelete();

        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
    }

    public void choosePlayList() {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectChoosePlayList();

//        Assert.assertEquals(playListPage.selectAddedVerifyNotificationMsg(), expectedAddedMsg);
    }
        public void searchSong (String songName) {

            PlayListPage playListPage = new PlayListPage(driver);

            playListPage.selectSearchSongField(songName);
        }

        public void viewAllSongs () {

            PlayListPage playListPage = new PlayListPage(driver);

            playListPage.selectViewAllSongs();
        }

        public void selectFirstSong () {

            PlayListPage playListPage = new PlayListPage(driver);

            playListPage.selectFirstSong();
        }

        public void addSongToBtn () {

            PlayListPage playListPage = new PlayListPage(driver);

            playListPage.selectAddSongToBtn();
        }
    }
