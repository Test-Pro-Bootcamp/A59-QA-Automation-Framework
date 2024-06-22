package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaySongsPage extends BasePage {

    // Constructors
    public PlaySongsPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(css = "[data-testid='play-next-btn']")
    private WebElement getPlayNextSongBtn;

    @FindBy(css = "[data-testid='play-btn']")
    private WebElement getPlaySongBtn;

    @FindBy(css = "img[alt='Sound bars']")
    private WebElement getSoundBars;

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

        return getSoundBars;

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

}
