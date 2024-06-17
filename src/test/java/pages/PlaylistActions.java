package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class PlaylistActions extends BasePage {

    // Constructor
    public PlaylistActions(WebDriver givenDriver) {
        super(givenDriver);
    }

    // LOCATORS


    private final By clickPlaylist = By.cssSelector(".playlist:nth-child(3)");
    //private By clickPlaylist = By.xpath("//*[@id='playlists']/ul/li[3]/a");
    private final By deletePlaylistAction = By.cssSelector(".btn-delete-playlist");

    // private By deletePlaylistAction = By.xpath("//*[@class='del btn-delete-playlist']");
    private final By successPopUp = By.cssSelector("div.success.show");
    //By confirmDelete = By.xpath("//*[@class='del btn-delete-playlist']");

    // Page Methods


    public void selectPlayList() {
        WebElement clickPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(clickPlaylist));
        clickPlaylistElement.click();
        System.out.println("Clicked Playlist");
    }

    public void deletePlaylist() {
        WebElement deletePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistAction));
        deletePlaylistElement.click();
        System.out.println("Deleted Playlist");
    }

    public WebElement successPopUpBox() {
        WebElement successPopUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successPopUp));
        System.out.println("Success Popup Displayed");
        return successPopUpElement;
    }
}


