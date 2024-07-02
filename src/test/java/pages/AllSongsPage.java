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
    private WebElement getFirstSong;

    @FindBy(css = "li a.songs")
    private WebElement getAllSongs;

    @FindBy(css = "li.playback")
    private WebElement getPlayBtn;

    //Page Methods

    public void selectAllSongsBtn() {

        getAllSongs.click();
    }

    public void selectFirstSong() {

        getFirstSong.click();

    }

    public void selectPlayBtn() {

        waitForVisibility(getPlayBtn).click();
    }

    public void rightClickOnSong() {

        selectRightClick(getFirstSong);
    }

}
