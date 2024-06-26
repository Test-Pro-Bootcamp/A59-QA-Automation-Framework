
package pgFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistActions extends BasePage {

    // Constructor
    public PlaylistActions(WebDriver givenDriver) {
        super(givenDriver);
    }

    // LOCATORS
    @FindBy(linkText = "Delete 1.1")
    private WebElement clickPlaylist;

    @FindBy(xpath = "//*[@id='mainFooter']/div[2]/div[2]/div/button[1]")
    private WebElement clearInfoSection;

    @FindBy(css = "button[title='Delete this playlist']")
    private WebElement deletePlaylistAction;

    @FindBy(css = "div.success.show")
    private WebElement successPopUp;

    // Page Methods
    public void selectPlayList() {
        scrollToElement(clickPlaylist);
        clickPlaylist.click();
        System.out.println("Clicked Playlist");
    }

    public void clearInfo() {
        waitForPresence(clearInfoSection).click();
        System.out.println("Cleared InfoSection");
    }

    public void deletePlaylist() {
        waitForElementToBeClickable(deletePlaylistAction).click();
        System.out.println("Deleted Playlist");
    }

    public void successPopUpBox() {
        waitForElementToBeVisible(successPopUp);
        System.out.println("Success Popup Displayed");
    }

    // Utility method to scroll to element using Actions class
    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
