package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    public HomePage(WebDriver givenDriver){
        super();
        userAvatarIcon = By.cssSelector("img.avatar");
    }
    //LOCATORS
    By userAvatarIcon;

    //METHODS
    public WebElement getUserAvatar (){

        return findElement((WebElement) userAvatarIcon);
    }

    private WebElement findElement(WebElement userAvatarIcon) {
        return null;
    }

}

