/*package pgFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaylistActions {
    public final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public PlaylistActions(WebDriver givenDriver) {
       // this.driver = givenDriver;
       // this.wait = new WebDriverWait(driver, 20);
        this.driver = givenDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // LOCATORS
    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement clickPlaylist;

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistAction;

    @FindBy(css = "div.success.show")
    private WebElement successPopUp;

    // Page Methods
    public void selectPlayList() {
        wait.until(ExpectedConditions.elementToBeClickable(clickPlaylist)).click();
        System.out.println("Clicked Playlist");
    }

    public void deletePlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistAction)).click();
        System.out.println("Deleted Playlist");
    }

    public void successPopUpBox() {
        WebElement successPopUpElement = wait.until(ExpectedConditions.visibilityOf(successPopUp));
        System.out.println("Success Popup Displayed");
    }
}

 */
package pgFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlaylistActions extends BasePage {


    // Constructor
    public PlaylistActions(WebDriver givenDriver) {
        super(givenDriver);
    }

    // LOCATORS
    @FindBy(linkText = "Delete2Sample Edited PlaylistSample Edited PlaylistSample Edited PlaylistSample Edited Playlist")
    private WebElement clickPlaylist;

    @FindBy(css = "button[title='Delete this playlist']")
    private WebElement deletePlaylistAction;

    @FindBy(css = "div.success.show")
    private WebElement successPopUp;

    // Page Methods
    public void selectPlayList() {
        waitForPresence(clickPlaylist).click();
        System.out.println("Clicked Playlist");
    }

    public void deletePlaylist() {
        waitForClickable(deletePlaylistAction);
        System.out.println("Deleted Playlist");
    }

    public void successPopUpBox() {
        waitForPresence(successPopUp);
        System.out.println("Success Popup Displayed");
    }
}
