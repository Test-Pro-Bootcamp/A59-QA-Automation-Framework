package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    By violetTheme = By.cssSelector("[data-testid='theme-card-violet']");
    By selectedVioletTheme = By.cssSelector("[data-testid='theme-card-violet'][class='theme selected']");

    public boolean isVioletThemeSelected() {
        findElement(selectedVioletTheme);
        return findElement(selectedVioletTheme).isDisplayed();
    }
    public ProfilePage chooseVioletTheme(){
        click(violetTheme);
        return this;
    }
}
