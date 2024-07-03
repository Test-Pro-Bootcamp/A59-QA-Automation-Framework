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

    //Methods

    public void contextClickFirstSong() {
        actions.contextClick(findElement(fistSong)).perform();
    }
    public void choosePlayOption() {
        findElement(playOption).click();
    }
}
