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
    By clickPlaylist = By.xpath("//*[@id='playlists']/ul/li[3]/a");
    By deletePlaylistAction = By.xpath("//*[@class='del btn-delete-playlist']");
    By successPopUp = By.xpath("//*/div[2]/div[@class='success show']");
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
/*
    public void confirmDeleteBox() {
        // Check if success popup is displayed
        WebElement successPopup = successPopUpBox();
        Assert.assertTrue(successPopup.isDisplayed(), "Success popup should be displayed after deleting the playlist");
    }*/
}