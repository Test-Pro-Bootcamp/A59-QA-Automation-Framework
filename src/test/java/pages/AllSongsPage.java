package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllSongsPage extends BasePage {

    //Constuctor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locator
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");

    //Methods
    public void contextClickFirstSong(){
        actions.contextClick(findElement(firstSong)).perform();
    }
    public void choosePlayOption(){
        findElement(playOption).click();
    }

}
