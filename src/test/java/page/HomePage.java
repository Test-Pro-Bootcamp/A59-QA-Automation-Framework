package page;

import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage extends BasePage {

    //CONSTRUCTOR

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //LOCATOR
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");

    //METHODS
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }


    public void chooseAllSongsList() {

        findElement(allSongsList).click();
    }
}



