package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
//        provideEmail("demo@testpro.io");
//        providePassword("te$t$tudent");
        clickSubmit();
    }
}
