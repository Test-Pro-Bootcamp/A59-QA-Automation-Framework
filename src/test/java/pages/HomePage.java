package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    private final By userAvatarIcon = By.xpath("//*[@id='userBadge']/a[1]/img");
    private final By allSongsList = By.cssSelector("li a.songs");

    // PlaylistActions locators
    private final By clickPlaylist = By.linkText("Delete 1.1"); // Adjusted to original PlaylistActions locator
    private final By clearInfoSection = By.xpath("//*[@id='mainFooter']/div[2]/div[2]/div/button[1]");
    private final By deletePlaylistAction = By.cssSelector("button[title='Delete this playlist']");
    private final By successPopUp = By.cssSelector("div.success.show");

    // Methods
    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }

    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }

    // Page Methods from PlaylistActions
    public void selectPlayList() {
        WebElement clickPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(clickPlaylist));
        scrollToElement(clickPlaylistElement); // Reusing the scrollToElement method from PlaylistActions
        clickPlaylistElement.click();
        System.out.println("Clicked Playlist");
    }

    public void clearInfo() {
        WebElement clearInfoSectionElement = wait.until(ExpectedConditions.elementToBeClickable(clearInfoSection));
        clearInfoSectionElement.click();
        System.out.println("Cleared InfoSection");
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

    // Utility method to scroll to element using Actions class
    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}