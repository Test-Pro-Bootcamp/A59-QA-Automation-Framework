package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
   // By fistSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
   // By playOption = By.cssSelector("li.playback");

    @FindBy (css= ".all-songs tr.song-item:nth-child(1)")
    WebElement fistSong;

    @FindBy (css= "li.playback")
    WebElement playOption;

    //Methods

    public void contextClickFirstSong() {
            fistSong.click();

       // actions.contextClick(findElement(fistSong)).perform();
    }
    public void choosePlayOption() {
        playOption.click();

       // findElement(playOption).click();
    }
}
