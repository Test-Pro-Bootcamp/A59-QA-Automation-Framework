package pages;

import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // Constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    //Page Methods
    // Very basic methods
    public void provideEmail(String email) {
      //  findElement(emailField).clear();
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
      //  findElement(passwordField).clear();
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void login() {
        provideEmail(userName);
        providePassword(userPassword);
        clickSubmit();
    }
}
