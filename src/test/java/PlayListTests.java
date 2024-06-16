
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PlayListPage;

public class PlayListTests extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {

        // create a playlist
        createPlayListBtn(playListName);
        // search for a song
        Thread.sleep(3000);
        searchSong(songName);
        // click view all button
        viewAllSongs();
        // select first song from result

        selectFirstSong();
        // click Add to Button
        addSongToBtn();
        // choose list to add song to
        Thread.sleep(3000);
        choosePlayList();
        Thread.sleep(5000);
        deletePlayListBtn();
    }

    public void createPlayListBtn(String playListName) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);

        loginPage.login();
        Thread.sleep(2000);
        playListPage.selectCreateNewPlayListBtn();
        playListPage.selectNewPlayListBtn();
        playListPage.selectTitleNameField(playListName);
        Thread.sleep(2000);
        Assert.assertEquals(playListPage.selectVerifyNotificationMsg(), expectedCreatedMessage);
        Thread.sleep(2000);
    }

    public void deletePlayListBtn() throws InterruptedException {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectPlayListToDelete();
        Assert.assertEquals(playListPage.selectVerifyNotificationMsg(), expectedDeleteMessage);
    }

    public void searchSong(String songName) throws InterruptedException {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectSearchSongField(songName);
    }

    public void viewAllSongs() throws InterruptedException {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectViewAllSongs();
    }

    public void selectFirstSong() throws InterruptedException {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectFirstSong();
      }

    public void addSongToBtn() throws InterruptedException {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectAddSongToBtn();
    }

    public void choosePlayList() throws InterruptedException {

        PlayListPage playListPage = new PlayListPage(driver);

        playListPage.selectChoosePlayList();
        Assert.assertEquals(playListPage.selectVerifyNotificationMsg(), expectedAddMessage);
    }
}
