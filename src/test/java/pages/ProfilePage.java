package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By getVerifyNotificationMsg = By.cssSelector("div.success.show");
    By getProfileNameBtn = By.cssSelector("span.name");
    By getProfileSaveBtn = By.cssSelector("btn-submit");
    By getProfileNameDisplayed = By.cssSelector("span.name");
    By getInputProfileNameField = By.cssSelector("input[type='text'][name='name']");
    By getInputProfileCurrentPasswordField = By.cssSelector("input[type='password'][name='current_password'][id='inputProfileCurrentPassword']");

    //Page Methods
    public void selectProfileNameBtn() {
        findElement(getProfileNameBtn).click();
    }

    public void selectInputProfileNameField(String newName) {
        findElement(getInputProfileNameField).clear();
        findElement(getInputProfileNameField).sendKeys(newName + "\n");
    }

    public void selectInputProfilePasswordField(String userPassword) {
        findElement(getInputProfileCurrentPasswordField).clear();
        findElement(getInputProfileCurrentPasswordField).sendKeys(userPassword + "\n");

    }
    public String selectVerifyNotificationMsg() {
        return findElement(getVerifyNotificationMsg).getText();
    }
    public void selectProfileSaveBtn() {
        findElement(getProfileSaveBtn).click();
    }

    public WebElement selectProfileSaveInfo() {
       return  findElement(getProfileSaveBtn);
    }
}
