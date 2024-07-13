package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class AllSongsPage extends BasePage {

    //Constructor
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    By fistSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");
    By selectFirstInList = By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]");
    By searchForSong = By.cssSelector("div#searchForm input[type='search']");
    By removePlaylist = By.cssSelector("button[class='del btn-delete-playlist']");
    //Methods

    public void contextClickFirstSong() {
        actions.contextClick(findElement(fistSong)).perform();
    }
    public void choosePlayOption() {
        findElement(playOption).click();
    }
    public void selectFirstSong() {
        findElement(selectFirstInList).click();
    }
    public void searchSong(String songName) {
        findElement(searchForSong).sendKeys(songName);
    }
    public void removePlaylist(){
        actions.contextClick(findElement(removePlaylist)).perform();
    }
}

