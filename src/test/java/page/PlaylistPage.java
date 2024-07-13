package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {

    //Constructor

    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Locator

    By playlistNameField = By.cssSelector("[name='name']");
    By  doubleClickPlaylist = By.cssSelector(".playlist:nth-child(4)");
    By successMessage = By.cssSelector("div.success.show");

    //Methods

    public void renamePlaylist(String newName) {
        WebElement playlistField = wait.until(ExpectedConditions.presenceOfElementLocated(playlistNameField));
        playlistField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistField.sendKeys(newName);
        playlistField.sendKeys(Keys.ENTER);

    }

    public void  doubleClickPlaylist() {
        findElement( doubleClickPlaylist).click();
    }

    public String successMessage() {
        return findElement(successMessage).getText();
    }
    ;

}

