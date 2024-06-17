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
//HW FEEDBACK: make all the locators and WebElements private, because private keyword in java allows most restrictive access to variables and methods and offer strongest form of Encapsulation.
    //Locators
    private By userAvatarIcon = By.cssSelector("img.avatar");
    private By allSongsList = By.cssSelector("li a.songs");

    //Methods
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        findElement(allSongsList).click();
    }

}