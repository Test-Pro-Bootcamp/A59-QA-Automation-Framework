package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    // By fistSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    // By playOption = By.cssSelector("li.playback");
    // By selectFirstSong =By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]");
    // By searchForSong = By.cssSelector("div#searchForm input[type='search']");
    //  By removePlaylist = By.cssSelector("button[class='del btn-delete-playlist']");

    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement fistSong;

    @FindBy(css = "li.playback")
    WebElement playOption;

    @FindBy(xpath = "//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")
    WebElement selectFirstInList;

    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    WebElement searchForSong;

    @FindBy(css = "button[class='del btn-delete-playlist']")
    WebElement removePlaylist;

    //Methods

    public void contextClickFirstSong() {
        fistSong.click();


        // actions.contextClick(findElement(fistSong)).perform();
    }

    public void choosePlayOption() {
        playOption.click();

        // findElement(playOption).click();
    }

    public void selectFirstSong() {
        selectFirstInList.click();

    }

    public void searchSong(String songName) {
        searchForSong.sendKeys(songName);
    }

    public void deletePlaylist() {
        removePlaylist.click();

    }
}
