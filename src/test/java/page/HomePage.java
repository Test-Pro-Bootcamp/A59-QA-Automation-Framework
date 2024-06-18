package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By userAvatarIcon = By.cssSelector("img[class='avatar']");
    By allSongsList = By.cssSelector("li a.songs");

    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }
}
