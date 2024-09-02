package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    // Constructor for HomePage
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for HomePage class
    By userAvatarIcon = By.cssSelector("img.avatar");

    // Methods for HomePage class
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }
}
