package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By profileIcon = By.cssSelector("a.view-profile");
    By userAvatarIcon = By.cssSelector("img[class='avatar']");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By allSongsList = By.cssSelector("li a.songs");

    public HomePage clickProfileIcon() {
        click(profileIcon);
        return this;

    }


    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg (){
        return findElement(renamePlaylistSuccessMsg).getText();
    }
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }
}
