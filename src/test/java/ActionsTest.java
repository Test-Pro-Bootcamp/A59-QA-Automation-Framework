import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActionsPage;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class ActionsTest extends BaseTest {

    //Test #1 Contextual Click
//    @Test
    public void playSong() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        //loginPage.provideEmail("demo@class.com");
        //loginPage.providePassword("te$t$tudent");
        //loginPage.clickSubmit();
        loginPage.login();

        //Choose All Songs
        homePage.chooseAllSongsList();
//        chooseAllSongsList();
        //Contextual Click on the first song
        allSongsPage.selectFirstSong();
        allSongsPage.rightClickOnSong();
//        contextClickFirstSong();
//        Thread.sleep(8000);
        //Click on Play from the menu
        allSongsPage.selectPlayBtn();
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs"))).click();
    }

    public void contextClickFirstSong() {

        AllSongsPage allSongsPage = new AllSongsPage(driver);

        WebElement firstSongElement = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//        actions.contextClick(firstSongElement).perform();
        try {
            firstSongElement.click();
            allSongsPage.selectFirstSong();
            allSongsPage.rightClickOnSong();

        } catch (NoSuchElementException e) {

            System.err.println("Play button element was not found" + e.getMessage());
        }
    }

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li.playback"))).click();
    }

    public boolean isPlaying() {
        WebElement soundBarVisualizer = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[data-testid = 'sound-bar-play']")));
        return soundBarVisualizer.isDisplayed();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Test #2 Mouse Hover
    //@Test
    public void hoverOverPlayButton() {
        //bg steps
        enterEmail("demo@testpro.io");
        enterPassword("te$t$tudent1");
        submit();
        //hover and verify play
        Assert.assertTrue(hoverPlay().isDisplayed());
    }

    public WebElement hoverPlay() {
        WebElement play = driver.findElement
                (By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Test #3 WebElements
    @Test
    public void countSongsInPlaylist() {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ActionsPage actionsPage = new ActionsPage(driver);

        loginPage.login();

//      WHEN
        actionsPage.selectPlaylistByName();

//        actionsPage.displayAllSongs();
//        actionsPage.displayAllPlaylists();
        actionsPage.selectStandardHyperLinks();
//        actionsPage.selectAlbumHyperLinks();
//        actionsPage.uniqueWebElements();
//        actionsPage.selectCheckPageAccessibility();


//        displayAllSongs();

//        displayAllPlaylists();

//      THEN
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
//        System.out.println("Playlist Details: " + getPlaylistDetails());
    }


    @Test
    public void navigateThroughAllPages() {

//      GIVEN
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ActionsPage actionsPage = new ActionsPage(driver);
        String expectedUrl = "https://qa.koel.app/#!/playlist/98995";

        loginPage.login();

//      WHEN
        actionsPage.selectStandardHyperLinks();

//      THEN
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);

    }

    public void choosePlaylistByName(String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(text(),'" + playlistName + "')]"))).click();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements
                (By.cssSelector("section#playlistWrapper td.title"));

        //count and display song names
        System.out.println("Number of Songs in the playlist: " + countSongs());

        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public int countSongs() {

        return driver.findElements(
                By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails() {

        return driver.findElement(
                By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }


    public void displayAllPlaylists() {
        List<WebElement> playlists = driver.findElements(By.className("playlist-class"));
        //count and display playlist names
        System.out.println("Number of playlists: " + playlists.size());

        for (WebElement e : playlists) {
            System.out.println(e.getText());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    //Test #4 Double Click
    String newPlaylistName = "Sample Edited Playlist";

    //@Test
    public void renamePlaylist() {
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName + ".\"";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        doubleClickPlaylist();
        enterNewPlaylistName();
        Assert.assertEquals(getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    public void doubleClickPlaylist() {
        WebElement playlistElement = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                         (By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
        WebElement notification = wait.until
                (ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
