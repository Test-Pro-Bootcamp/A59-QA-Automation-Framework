package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    //Constructor
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locator
    By userAvatarIcon = By.cssSelector("img.avatar");

    //Methods
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
}
