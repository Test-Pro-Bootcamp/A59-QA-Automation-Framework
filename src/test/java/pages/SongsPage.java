package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SongsPage extends BasePage {
    // Constructor for SongsPage
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for SongsPage Class
    By allSongsHome = By.cssSelector("#sidebar a.songs");
    By shuffleAllSongsBtn = By.cssSelector("button.btn-shuffle-all");
    By lyricsBtn = By.cssSelector("button#extraTabLyrics");
    By artistBtn = By.cssSelector("button#extraTabArtist");
    By albumBtn = By.cssSelector("button#extraTabAlbum");
    By firstSong = By.cssSelector("tr.song-item:nth-child(1)");
    By secondSong = By.cssSelector("tr.song-item:nth-child(2)");
    By ThirdSong = By.cssSelector("tr.song-item:nth-child(3)");
    By fourthSong = By.cssSelector("tr.song-item:nth-child(4)");
    By fithSong = By.cssSelector("tr.song-item:nth-child(5)");

    // Page Methods
    public void navigateToAllSongsPage() {
        findElement(allSongsHome).click();
    }
}
