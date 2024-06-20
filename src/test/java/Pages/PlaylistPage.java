package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaylistPage extends BasePage {

    private By addPlaylistIcon = By.xpath("//*[@id='playlists']/h1/i");
    private By newPlaylistOption = By.xpath("//*[@id='playlists']/nav/ul/li[1]");
    private By playlistNameInput = By.xpath("//*[@id='playlists']/form/input");
    private By activePlaylist = By.xpath("//*[@id='playlists']/ul/li/a[@class='active']");
    private By inlinePlaylistNameInput = By.cssSelector("[data-testid='inline-playlist-name-input']");
    private By successPopup = By.xpath("//*/div[2]/div[@class='success show']");

    public PlaylistPage(WebDriver driver) {
        super(driver);
    }

    public void createPlaylist(String playlistName) {
        WebElement addPlaylistIconElement = findElement(addPlaylistIcon);
        addPlaylistIconElement.click();

        WebElement newPlaylistOptionElement = findElement(newPlaylistOption);
        newPlaylistOptionElement.click();

        WebElement playlistNameInputElement = findElement(playlistNameInput);
        playlistNameInputElement.sendKeys(playlistName);
        playlistNameInputElement.sendKeys(Keys.RETURN);
    }

    public void renamePlaylist(String newName) {
        WebElement activePlaylistElement = findElement(activePlaylist);
        actions.moveToElement(activePlaylistElement).doubleClick().perform();

        WebElement inputField = findElement(inlinePlaylistNameInput);
        inputField.click();
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE, newName, Keys.RETURN);
    }

    public WebElement getSuccessPopup() {
        return findElement(successPopup);
    }
}