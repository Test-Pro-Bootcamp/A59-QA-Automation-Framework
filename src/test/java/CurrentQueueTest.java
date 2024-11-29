import io.cucumber.java.bs.A;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CurrentQueueTest extends BaseTest{

    //After Login


    // Current Queue page display currently played songs
@Test
    public void currentQueuePlaySong(){
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());
        loginPage.login();
        homePage.currentQueueSongs();
        Assert.assertTrue(currentQueuePage.getIsDisplayedCurrentQueueList().isDisplayed());
}
    //Total count of songs and total duration count of all songs, ID, Title, Artist, Album, and Time is displayed

@Test
    public void countOfSongsAndDuration(){
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());
    loginPage.login();
    homePage.currentQueueSongs();
    Assert.assertTrue(allSongsPage.getToAllSongsCount().isDisplayed());
}
//After click on song from Album page, song start playing in Current Queue page

@Test
    public void songsAlbumPlayingCurrentQueue(){
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    AlbumsPage albumsPage = new AlbumsPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());
    loginPage.login();
    homePage.albumsList();
    albumsPage.playFirstSong();
    Assert.assertTrue(currentQueuePage.getCurrentQueuePlayingSong().isDisplayed());
}
//After click on song from Artists page, song start playing in Current Queue page

@Test
    public void songsArtistsPlayingCurrentQueue(){
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    ArtistsPage artistsPage = new ArtistsPage(getDriver());
    CurrentQueuePage currentQueuePage = new CurrentQueuePage(getDriver());
    loginPage.login();
    homePage.artistsList();
    artistsPage.firstSongPlaying();
    Assert.assertTrue(currentQueuePage.getCurrentQueuePlayingSong().isDisplayed());
}



//After click "Clear" button Current Queue page is empty and  'No songs queued. How about shuffling all songs?' message is appear.
    @Test
    public void emptyPage(){
    loginPage.login();
    homePage.currentQueueSongs();
    currentQueuePage.clearBtn();
    Assert.assertTrue(currentQueuePage.getNoSongsMessage().isDisplayed());
    }
//Songs are appeared on the Current Queue page  when clicking on the 'shuffling all songs'
    @Test
    public void songsIsAppear(){
    loginPage.login();
    homePage.currentQueueSongs();
    currentQueuePage.shufflingAllSongsBtn();
    Assert.assertTrue(currentQueuePage.getIsDisplayedCurrentQueueList().isDisplayed());

    }

}
