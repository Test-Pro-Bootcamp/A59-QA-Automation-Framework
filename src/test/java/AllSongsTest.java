import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AllSongsTest extends BaseTest {

    @Test(priority = 1)
    public void playSongAndCheckForAlbumNameAndCover() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        String title = "Dark Days";
        String artist = "Grav";
        String album = "Dark Days EP";

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        homePage.chooseAllSongsList();
        allSongsPage.selectSongBtn(title, artist, album);

        Thread.sleep(3000);

//      THEN
        Assert.assertTrue(allSongsPage.isCoverOfPlayingSongPresent());
        Assert.assertTrue(allSongsPage.isDarkDaysAlbumPresent());
    }

    @Test(priority = 2)
    public void playSongAndCheckForLyrics() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        String title = "Dark Days";
        String artist = "Grav";
        String album = "Dark Days EP";
//        String lyrics = "Lyrics";

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        homePage.chooseAllSongsList();
        allSongsPage.selectSongBtn(title, artist, album);
        allSongsPage.selectSongBtn(title, artist, album);

        Thread.sleep(3000);

//      THEN
        Assert.assertTrue(allSongsPage.isLyricsMsgPresent());
    }

    @Test(priority = 3)
    public void playSongAndCheckForArtistIsDisplayed() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        String title = "Dark Days";
        String artist = "Grav";
        String album = "Dark Days EP";

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        homePage.chooseAllSongsList();
        driver.navigate().refresh();
        Thread.sleep(3000);
        allSongsPage.selectSongBtn(title, artist, album);

        Thread.sleep(3000);

//      THEN

        Assert.assertTrue(allSongsPage.isArtistNamePresent(artist));
    }

    @Test(priority = 4)
    public void playSongAndCheckForInfoPanelIsDisplayed() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        String title = "Dark Days";
        String artist = "Grav";
        String album = "Dark Days EP";

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        homePage.chooseAllSongsList();
        driver.navigate().refresh();
        allSongsPage.selectSongBtn(title, artist, album);

        Thread.sleep(3000);

//      THEN
        Assert.assertTrue(allSongsPage.isInfoPanelPresent());
    }

    @Test(priority = 5)
    public void playSongAndClickOnInfoBtnToHideInfoPanel() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        String title = "Dark Days";
        String artist = "Grav";
        String album = "Dark Days EP";

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        homePage.chooseAllSongsList();
        driver.navigate().refresh();
        allSongsPage.selectSongBtn(title, artist, album);
        allSongsPage.selectInfoBtn();

        Thread.sleep(3000);

//      THEN
        Assert.assertTrue(allSongsPage.isInfoPanelNotPresent());
    }


    @Test(priority = 6)
    public void playSongAndShuffleOrderOfPlayingSongsByArtistAndAlbum() throws InterruptedException {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        String title = "Dark Days";
        String artist = "Grav";
        String album = "Dark Days EP";
        String artistType = "Artist";
        String albumType = "Album";
        String expectedURL = "https://qa.koel.app/#!/queue";

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        homePage.chooseAllSongsList();
        driver.navigate().refresh();
        allSongsPage.selectSongBtn(title, artist, album);
        Thread.sleep(3000);

        allSongsPage.selectInfoTypeBtn(artistType);
        allSongsPage.selectShuffleArtistBtn(artist);
        Thread.sleep(3000);

        allSongsPage.selectInfoTypeBtn(albumType);
        allSongsPage.selectShuffleAlbumBtn(album);
        Thread.sleep(3000);

        String actualURL = StringUtils.substringBefore(driver.getCurrentUrl(), "?");
//        Thread.sleep(3000);

//      THEN
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test
    public void playSongWithRightClick() {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);

        // Login
        loginPage.login();

//      WHEN
        // Navigate to All Songs Page
        driver.navigate().refresh();
        homePage.chooseAllSongsList();

        // Right/Context Click on the first song
        allSongsPage.selectFirstSong();
        allSongsPage.rightClickOnSong();

        // Click on play button
        allSongsPage.selectPlayBtn();

//      THEN
        Assert.assertTrue(homePage.isSongPlaying());
    }

    //Methods

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until
                    (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[data-testid = 'sound-bar-play")));

        return soundBarVisualizer.isDisplayed();
    }
}
