package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage  extends BasePage{
    //CONSTRUCTOR
    public AllSongsPage(WebDriver giveDriver){
        super(giveDriver);
    }

    //LOCATORS
    By firstSong = By.cssSelector(".allsongs tr.song-item:nth-child(1)");


    //PAGE METHODS
    public void contextClickFirstSong(){
        actions.contextClick(findElement((WebElement) firstSong)).perform();
    }
}
