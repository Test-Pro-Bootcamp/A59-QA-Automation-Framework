package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PlaySongsPage extends BasePage {

    // Constructors
    public PlaySongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By getPlayNextSongBtn =       By.cssSelector("[data-testid='play-next-btn']");
    By getPlaySongBtn =           By.cssSelector("[data-testid='play-btn']");
    By getSoundBars =             By.cssSelector("img[alt='Sound bars']");

    // Page Methods
    public void selectPlayNextSongBtn() {
        mouseOverAndClick(getPlayNextSongBtn);

//        actions.moveToElement((WebElement) getPlayNextSongBtn).perform();
//        actions.click((WebElement)getPlayNextSongBtn).perform();
    }

    public void selectPlaySongBtn() {
        mouseOverAndClick(getPlaySongBtn);

//        actions.moveToElement((WebElement) getPlaySongBtn).perform();
//        actions.click((WebElement) getPlaySongBtn).perform();
    }

    public WebElement selectSoundBars() {

        return findElement(getSoundBars);
    }

    public void mouseOverPlayBtn() {
        mouseOver(getPlaySongBtn);
    }

    public void selectPlayBtnToSingleClick() {
        singleClickBtn(getPlaySongBtn);
    }

    public void mouseOverPlayNextBtn() {
        mouseOver(getPlayNextSongBtn);
    }

    public void selectPlayNextBtnToSingleClick() {
        singleClickBtn(getPlayNextSongBtn);
    }

    public void findSoundBars() {

        PlaySongsPage playSongsPage = new PlaySongsPage(driver);


    }


}
