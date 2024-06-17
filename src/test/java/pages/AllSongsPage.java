package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllSongsPage extends BasePage{

    //Constructor
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locators
    private By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    private By playOption = By.cssSelector("li.playback");
    private By soundBarVisualizer = By.cssSelector("[data-testid='sound-bar-play']");
    //Page Methods
    public void contextClickFirstSong(){
        actions.contextClick(findElement(firstSong)).perform();
    }

    public void choosePlayOption(){
        findElement(playOption).click();
    }
    public boolean isSongPlaying(){
        WebElement soundBarVisualizerElement = findElement(soundBarVisualizer);
        return soundBarVisualizerElement.isDisplayed();
    }

}