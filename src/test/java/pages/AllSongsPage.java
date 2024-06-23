package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class AllSongsPage extends BasePage{

    //Constructor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement firstSong;

    @FindBy(css = "li.playback")
    private WebElement playOption;

    //Page Methods
    public AllSongsPage contextClickFirstSong(){

        actions.contextClick(firstSong).perform();

        return null;
    }

    public void choosePlayOption(){

        playOption.click();
    }

}
