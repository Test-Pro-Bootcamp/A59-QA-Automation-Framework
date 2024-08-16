package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ActionsPage extends BasePage{

    //Constructor
    public ActionsPage(WebDriver givenDriver){
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }
    //Locators

//    @FindBy(xpath = "//a[contains(text(), 'A')]")
    @FindBy(xpath = "//a[contains(text(), 'TestPro Playlist')]")
//    @FindBy(xpath = "//a[contains(text(), playlistName)]")
    private WebElement getPlaylistByName;

    @FindBy(css = "section#playlistWrapper td.title")
    private List<WebElement> songList;

//    @FindBy(css = "section#playlistWrapper td.title")
//    private List<WebElement> playList;

    @FindBy(css = "section#playlistWrapper td.title")
    private WebElement countSongs;

    //Page Methods
    public void selectPlaylistByName() {

        waitForVisibility(getPlaylistByName).click();
    }

    public void displayAllSongs() {

        //count and display song names
        System.out.println("Number of Songs in the playlist: " + songList.size());

        for (WebElement e : songList) {
            System.out.println(e.getText());
        }
    }

    public void displayAllPlaylists() {
        List<WebElement> playlists = driver.findElements(By.className("playlist-class"));
        //count and display playlist names
        System.out.println("Number of playlists: " + playlists.size());

        for (WebElement e : playlists) {
            System.out.println(e.getText());
        }
    }

}
