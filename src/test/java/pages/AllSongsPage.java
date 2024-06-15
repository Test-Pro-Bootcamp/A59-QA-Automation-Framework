package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AllSongsPage extends BasePage{

    //Constructor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locators
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");

    //Page Methods
    public void contextClickFirstSong(){
        actions.contextClick(findElement(firstSong)).perform();
    }

    public void choosePlayOption(){
        findElement(playOption).click();
    }

}