package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");


    public WebElement getUserAvatar(){
        return  findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        findElement(allSongsList).click();
    }
}