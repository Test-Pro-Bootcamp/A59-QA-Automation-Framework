package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage {
    // Constructor for SongsPage
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for SongsPage Class
    // By allSongsHome = By.cssSelector("#sidebar a.songs");
    By shuffleAllSongsBtn = By.cssSelector("button.btn-shuffle-all");
    By lyricsBtn = By.cssSelector("button#extraTabLyrics");
    By artistBtn = By.cssSelector("button#extraTabArtist");
    By albumBtn = By.cssSelector("button#extraTabAlbum");
    By firstSong = By.cssSelector("tr.song-item:nth-child(1)");
    By secondSong = By.cssSelector("tr.song-item:nth-child(2)");
    By ThirdSong = By.cssSelector("tr.song-item:nth-child(3)");
    By fourthSong = By.cssSelector("tr.song-item:nth-child(4)");
    By fithSong = By.cssSelector("tr.song-item:nth-child(5)");
    By contextMenuPlayback = By.cssSelector("li.playback");
    //By soundBarVisualizer = By.cssSelector("div[data-testid='sound-bar-play'] img");

    // Page Methods
    // Moved to BasePage since it's applicable to multiple pages (i.e Home Page, Songs Page, Album Page, etc)
//    public void navigateToAllSongsPage() {
//        findElement(allSongsHome).click();
//    }

    public void rightClickFirstSong() {
        actions.contextClick(findElement(firstSong)).perform();
    }

    public void choosePlayOption() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
        findElement(contextMenuPlayback).click();
    }

    // Moved to BasePage since it's applicable to multiple pages (i.e Home Page, Songs Page, Album Page, etc)
//    public boolean isSongPlaying() {
//        return findElement(soundBarVisualizer).isDisplayed();
//    }
}
