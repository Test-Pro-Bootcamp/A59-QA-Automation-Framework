import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlayListPage;
import pages.BasePage;

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
//        createPlayListBtn(playlistName);
        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playlistName);
        driver.navigate().refresh();
        // search for a song
//        searchSong(songName);
        playListPage.selectSearchSongField(songName);
        // click view all button
        Thread.sleep(3000);
//        viewAllSongs();
        playListPage.selectViewAllSongs();

        // select first song from result
//        driver.navigate().refresh();
//        selectFirstSong();
        playListPage.selectFirstSong();
        // click Add to Button
//        Thread.sleep(3000);
//        addSongToBtn();
        playListPage.selectAddSongToBtn();
//        Thread.sleep(3000);
        // choose list to add song to
//        choosePlayList();
        playListPage.selectChoosePlayList();
        driver.navigate().refresh();
//        deletePlayListBtn();
        playListPage.selectPlayListToDelete();

//      THEN
//      All the Asserts are part of the methods
        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
    }

    public void createPlayListBtn(String playlistName) {

        PlayListPage playListPage = new PlayListPage(driver);

        driver.navigate().refresh();
        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playlistName);

        Assert.assertEquals(playListPage.selectCreatedVerifyNotificationMsg(), expectedCreatedMsg);
    }

    public void deletePlayListBtn() {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectPlayListToDelete();

        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
    }

    public void choosePlayList() {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectChoosePlayList();

        Assert.assertEquals(playListPage.selectAddedVerifyNotificationMsg(), expectedAddedMsg);
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
