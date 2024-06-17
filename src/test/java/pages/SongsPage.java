package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SongsPage extends BasePage {

    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By getVerifyNotificationMsg = By.cssSelector("div.success.show");
    By getPlayNextSongBtn = By.cssSelector("[data-testid='play-next-btn']");
    By getPlaySongBtn = By.cssSelector("[data-testid='play-btn']");
    By getSoundBars = By.cssSelector("img[alt='Sound bars']");
    By getFirstSongInListBtn = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By getAllSongsBtn = By.cssSelector("li a.songs");
    By getPlayBackBtn = By.cssSelector("li.playback");

    //Page Methods
    public void selectPlayBackBtn() {
        actions.moveToElement((WebElement) getPlayBackBtn).perform();
        actions.click((WebElement) getPlayBackBtn).perform();
    }

    public void selectFirstSongInListn() {
        actions.moveToElement((WebElement) getFirstSongInListBtn).perform();
        actions.click((WebElement) getFirstSongInListBtn).perform();
    }

    public void selectAllSongsBtn() {
        actions.moveToElement((WebElement) getAllSongsBtn).perform();
        actions.click((WebElement) getAllSongsBtn).perform();
    }

    public String selectVerifyNotificationMsg() {
        return findElement(getVerifyNotificationMsg).getText();
    }

    public void selectPlayNextSongBtn() {
        actions.moveToElement((WebElement) getPlayNextSongBtn).perform();
        actions.click((WebElement) getPlayNextSongBtn).perform();
    }

    public void selectPlaySongBtn() {
        actions.moveToElement((WebElement) getPlaySongBtn).perform();
        actions.click((WebElement) getPlaySongBtn).perform();
    }

    public WebElement selectSoundBars() {
        return findElement(getSoundBars);
    }

}
