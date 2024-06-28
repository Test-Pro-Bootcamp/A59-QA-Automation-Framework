package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By userAvatar = By.cssSelector("img.avatar");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserAvatarDisplayed() {
        return driver.findElement(userAvatar).isDisplayed();
    }
}

