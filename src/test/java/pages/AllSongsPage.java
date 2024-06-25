package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    //Constructor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }
    //Locators
    @FindBy(css = ".all-songs tr.song-item:nth-child(1)")
    private WebElement getFirstSong;

    @FindBy(css = "li.playback")
    private WebElement playOption;

    @FindBy(css = "li a.songs")
    private WebElement getAllSongs;



    //Page Methods

    public void selectAllSongsBtn() {

        getAllSongs.click();
    }
    public void selectFirstSong() {


        getFirstSong.click();

//
//        actions.contextClick(firstSong).perform();
//
//        return null;
    }

    public void choosePlayOption(){

        playOption.click();
    }

}
