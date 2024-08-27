package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage {

    //Constuctor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locator
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By playOption = By.cssSelector("li.playback");
    By toAllSongsCount = By.xpath("//section[@id='songsWrapper']//span[text()='66 songs • 04:32:57']");

    //Methods
    public void contextClickFirstSong(){
        actions.contextClick(findElement(firstSong)).perform();
    }
    public void choosePlayOption(){
        findElement(playOption).click();
    }
    public WebElement getToAllSongsCount(){
        return findElement(toAllSongsCount);
    }

}
