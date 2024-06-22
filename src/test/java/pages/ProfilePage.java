package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class ProfilePage extends BasePage {

    // Constructors
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By getUpdatedVerificationMsg = By.xpath("//*[contains(text(), 'Profile updated.')]");
    By getProfileNameBtn = By.cssSelector("span.name");
    By getProfileSaveBtn = By.cssSelector("btn-submit");
    By getProfileNameDisplayed = By.cssSelector("span.name");
    By getInputProfileNameField = By.cssSelector("input[type='text'][name='name']");
    By getInputProfileCurrentPasswordField = By.cssSelector("input[type='password'][name='current_password'][id='inputProfileCurrentPassword']");

    //Page Methods
    public void selectProfileNameBtn() {
        findElement(getProfileNameBtn).click();
    }

    public String generateUniqueName() {

        return UUID.randomUUID().toString().replace("-", "");
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

        return findElement(getUpdatedVerificationMsg).getText();
    }
    public void selectProfileSaveBtn() {

        findElement(getProfileSaveBtn).click();
    }

    public WebElement selectProfileSaveInfo() {

        return  findElement(getProfileSaveBtn);
    }

    public String selectUpdatedVerifyNotificationMsg(String test) {

        test = findElement(getUpdatedVerificationMsg).getText();
        return test;
//        return findElement(getUpdatedVerificationMsg).isDisplayed();
    }
}
