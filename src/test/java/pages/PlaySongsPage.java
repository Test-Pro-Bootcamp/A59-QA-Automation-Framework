package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaySongsPage extends BasePage {

    public PlaySongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By getVerifyNotificationMsg = By.cssSelector("div.success.show");
    By getPlayNextSongBtn = By.cssSelector("[data-testid='play-next-btn']");
    By getPlaySongBtn = By.cssSelector("[data-testid='play-btn']");
    By getSoundBars = By.cssSelector("img[alt='Sound bars']");

    //Page Methods
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

//    public void selectProfileSaveBtn() {
//        findElement(getProfileSaveBtn).click();
//    }
}
