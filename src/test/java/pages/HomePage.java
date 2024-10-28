package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class HomePage extends BasePage {
    // Constructor for HomePage
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for HomePage class
    By userAvatarIcon = By.cssSelector("img.avatar");
    By thirdPlayList = By.cssSelector(".playlist:nth-child(3)");
    By playlistInput = By.cssSelector("[name='name']");
    By successNotification = By.cssSelector("div.success.show");

    // Methods for HomePage class
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }

    public void doubleClickPlayList() {
       //actions.doubleClick(findElement(thirdPlayList)).perform();
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li.playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }

    public void enterNewName(String name) {
//        WebElement playlistInputField = findElement(playlistInput);
        // Used Keys.chord(Keys.CONTROL, "A") instead below
        // because playlistInputField.Clear() will not work on this text field
        // Below uses a sequence of keystrokes, Control-A then Back_space
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(name);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg() {
                return findElement(successNotification).getText();
    }

}
