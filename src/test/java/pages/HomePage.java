package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePage extends BasePage{

    //Constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locators
    By userAvatarIcon = By.cssSelector("img.avatar");
    By allSongsList = By.cssSelector("li a.songs");

    //Methods
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        findElement(allSongsList).click();
    }

}