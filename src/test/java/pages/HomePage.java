package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By userAvatarIcon = By.cssSelector("img[class='avatar']");
//  By userAvatarIcon = By.cssSelector("img.avatar");
//  By passwordField = By.cssSelector("input[type='password']");
//  By submitBtn = By.cssSelector("button[type='submit']");


    //  Page Methods
    //  public WebElement getUserAvatar;
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }

}
