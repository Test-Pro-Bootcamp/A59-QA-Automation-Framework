package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // CONSTRUCTOR
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // LOCATORS
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");

    // PAGE METHODS
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void login(String username, String password) {
        provideEmail(username);
        providePassword(password);
        clickSubmit();
    }

    // Default login method
    public void login() {
        login("giovanna.silva@testpro.io", "ShakaMaya1302!");
    }
}