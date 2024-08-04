package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaySongPage extends BasePage {

    //Constructor
    public PlaySongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator
    private final By clickPlayBtn = By.cssSelector("span.play");
    private final By enterAllSongs = By.cssSelector("a[href='#!/songs']");
    private final By isDisplayedSoundBar = By.cssSelector("img[alt='Sound bars']");

    public WebElement getclickPlayBtn(){
       return findElement(clickPlayBtn);
    }
    public void playBtn(){
        getclickPlayBtn().click();
    }

    public WebElement getclickAllSongs(){
       return findElement(enterAllSongs);
    }
    public void allSongs(){
        getclickAllSongs().click();
    }
    public WebElement getIsDisplayedSoundBar(){
        return findElement(isDisplayedSoundBar);
    }
}
