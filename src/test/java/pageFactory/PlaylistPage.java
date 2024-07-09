package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {

    //Constructor

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locator

    //By playlistNameField = By.cssSelector("[name='name']");
   // By chosePlayList = By.cssSelector(".playlist:nth-child(4)");

    @FindBy(css = "[name='name']")
    WebElement playlistNameField;

    @FindBy (css = ".playlist:nth-child(4)")
    WebElement chosePlayList;

    //Methods
    public void renamePlaylist() {
        playlistNameField.isDisplayed();


    }
     public void choosePLayList(){
        chosePlayList.click();


        }
    }
