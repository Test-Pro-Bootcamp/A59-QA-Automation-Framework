package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.UUID;

public class ProfilePage extends BasePage {

    // Constructor for ProfilePage Class invoking super class constructor
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for ProfilePage class
    By profileName = By.cssSelector("span.name");
    By nameField = By.cssSelector("input#inputProfileName");
    By passwordField = By.cssSelector("input#inputProfileCurrentPassword");
//    WebElement newPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputProfileNewPassword")));
//    WebElement emailAddressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#inputProfileEmail")));
    By submitBtn = By.cssSelector("button.btn-submit");
//    WebElement themeClassicBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-card-classic']")));
//    WebElement themeVioletBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-card-violet']")));
//    WebElement themeOakBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-card-oak']")));
//    WebElement themeSlateBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-slate-classic']")));
//    WebElement themeMadisonBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='theme-card-madison']")));

    // ProfilePage Methods
    public void navigateToProfilePage() {
       findElement(profileName).click();
    }

    public String getProfileName() {
        return findElement(profileName).getText();

    }

    public String generateUniqueName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public void changeName(String name) throws InterruptedException {
        enterCurrentPassword("N6wWY2Rx");
        enterNewName(name);
        saveChanges();
        Thread.sleep(1000);
    }

    public void enterCurrentPassword(String password) {
        findElement(passwordField).sendKeys(password);

    }

    public void enterNewName(String newName) {
        findElement(nameField).clear();
        findElement(nameField).sendKeys(newName);
    }

    public void saveChanges() {
        findElement(submitBtn).click();
    }


}
