package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    //Constructor for pageFactory HomePage class
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for this Factory HomePage class
    @FindBy(css = "span.name")
    WebElement userAvatarIcon;

    // Methods for this pageFactory HomePage class
    public WebElement getUserAvatarIcon() {
        return wait.until(ExpectedConditions.elementToBeClickable(userAvatarIcon));
    }
}
