import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlayListPage;
import pages.BasePage;

public class PlayListTests extends BaseTest {

    private final String playlistName =                     "Sounds-Great-01";
    private final String playlistNameWithOneCharacter =     "J";
    private final String playlistNameWith256Characters =    "1234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678123456781234567812345678";
    private final String playlistNameWithZeroCharacters =   "";
    private final String songName =                         "grav";
    private final String expectedBlankErrorMsg =            "Please fill out this field.";

    private final String expectedCreatedMsg =               "Created playlist \""  + playlistName + ".\"";
    private final String expectedAddedMsg =                 "Added 1 song into \"" + playlistName + ".\"";
    private final String expectedDeletedMsg =               "Deleted playlist \""  + playlistName + ".\"";

    private final String expectedCreatedMsgOneCharacter =   "Created playlist \""  + playlistNameWithOneCharacter + ".\"";
    private final String expectedAddedMsgOneCharacter =     "Added 1 song into \"" + playlistNameWithOneCharacter + ".\"";
    private final String expectedDeletedMsgOneCharacter =   "Deleted playlist \""  + playlistNameWithOneCharacter + ".\"";

    private final String expectedCreatedMsg256Character =   "Created playlist \""  + playlistNameWith256Characters + ".\"";
    private final String expectedAddedMsg256Character =     "Added 1 song into \"" + playlistNameWith256Characters + ".\"";
    private final String expectedDeletedMsg256Character =   "Deleted playlist \""  + playlistNameWith256Characters + ".\"";

    @Test (enabled = false)
    public void addSongToPlaylist() throws InterruptedException {

//      GIVEN
        LoginPage loginPage =       new LoginPage(getDriver());
        HomePage homePage =         new HomePage(getDriver());
        PlayListPage playListPage = new PlayListPage(getDriver());
        loginPage.login();

//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlaylistBtn();
        playListPage.selectNewPlaylistBtn();
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
        playListPage.selectPlaylist(playlistName);
        Thread.sleep(3000);
//        driver.navigate().refresh();

        playListPage.selectPlaylistToDelete(playlistName);

//      THEN
        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsg(), expectedDeletedMsg);
//        System.out.println("Part 1: " + playListPage.selectDeletedVerifyNotificationMsg());
//        System.out.println("Part 2: " + expectedDeletedMsg);
    }

    @Test(enabled = false)
    public void createPlaylistWithOneCharacter() throws InterruptedException {

//      GIVEN
        LoginPage loginPage =       new LoginPage(getDriver());
        HomePage homePage =         new HomePage(getDriver());
        PlayListPage playListPage = new PlayListPage(getDriver());
        loginPage.login();

//      WHEN
        // create a playlist
        homePage.isDisplayedUserAvatarIcon();
        driver.navigate().refresh();
        playListPage.selectCreateNewPlaylistBtn();
        playListPage.selectNewPlaylistBtn();
        playListPage.selectTitleNameField(playlistNameWithOneCharacter);
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
        playListPage.selectPlaylistWithOneCharacter(playlistNameWithOneCharacter);
        Thread.sleep(3000);
        driver.navigate().refresh();

        playListPage.selectPlaylistWithOneCharacterToDelete(playlistNameWithOneCharacter);

//      THEN

        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsgForOneCharacter(), expectedDeletedMsgOneCharacter);
//        System.out.println("Part 1: " + playListPage.selectDeletedVerifyNotificationMsgForOneCharacter());
//        System.out.println("Part 2: " + expectedDeletedMsgOneCharacter);
    }

    @Test(enabled = false)
    public void createPlaylistWithMoreThan256Characters() throws InterruptedException{

//      GIVEN
        LoginPage loginPage =       new LoginPage(getDriver());
        HomePage homePage =         new HomePage(getDriver());
        PlayListPage playListPage = new PlayListPage(getDriver());
        loginPage.login();

//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlaylistBtn();
        playListPage.selectNewPlaylistBtn();
        playListPage.selectTitleNameField(playlistNameWith256Characters);
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
        playListPage.selectPlaylistWith256Characters(playlistNameWith256Characters);
        Thread.sleep(3000);
        driver.navigate().refresh();

        playListPage.selectPlaylistWith256CharactersToDelete(playlistNameWith256Characters);

//      THEN
        Assert.assertEquals(playListPage.selectDeletedVerifyNotificationMsgFor256Characters(), expectedDeletedMsg256Character);
    }

    @Test (enabled = false)
    public void createPlaylistWithZeroCharacters() {

//      GIVEN
        LoginPage loginPage =       new LoginPage(getDriver());
        HomePage homePage =         new HomePage(getDriver());
        PlayListPage playListPage = new PlayListPage(getDriver());
        loginPage.login();

//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlaylistBtn();
        playListPage.selectNewPlaylistBtn();
        playListPage.selectTitleNameField(playlistNameWithZeroCharacters);

//      THEN
        Assert.assertEquals(playListPage.selectTextEmailValidationMessage(), expectedBlankErrorMsg);
    }

    @Test
    public void createSmartPlaylist() {

//      GIVEN
        LoginPage loginPage =       new LoginPage(getDriver());
        HomePage homePage =         new HomePage(getDriver());
        PlayListPage playListPage = new PlayListPage(getDriver());
        loginPage.login();


//      WHEN
        // create a playlist
        playListPage.selectCreateNewPlaylistBtn();
        playListPage.selectNewSmartPlaylistBtn();
        playListPage.selectTitleNameField(playlistName);
        driver.navigate().refresh();

        // search for a song



        // click Add to Button
        playListPage.selectAddSongToBtn();


//      THEN


    }
}
