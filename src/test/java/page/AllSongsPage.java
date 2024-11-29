package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage{

    //Constructors
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");

    //Page Methods
    public void contextClickFirstSong() {
        actions.contextClick(findElement(firstSong)).perform();
    }
    public void choosePlayOption() {
        findElement(playOption).click();
    }
}
