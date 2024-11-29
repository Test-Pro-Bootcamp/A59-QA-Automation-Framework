package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By soundBarVisualizer = By.cssSelector("[data-testid = 'sound-bar-play']");

public BasePage(WebDriver givenDriver) {
    driver = givenDriver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    actions = new Actions(driver);
    PageFactory.initElements(driver,this);
}
public WebElement findElement(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
    public boolean isSongPlaying() {
        return findElement(soundBarVisualizer).isDisplayed();
    }
    public void click (By locator) {
    findElement(locator).click();
    }
public void doubleClick (By locator) {
    actions.doubleClick(findElement(locator)).perform();

}
}
