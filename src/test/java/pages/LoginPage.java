package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class LoginPage extends BasePage {

    // Constructor for LoginPage
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for LoginPage
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");

    // Page Methods for LoginPage
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void submitClick()  {
        findElement(submitBtn).click();
    }

    public void login() {
        provideEmail("leon.poyau+2@testpro.io");
        providePassword("N6wWY2Rx");
        submitClick();
    }

} // Ends LoginPage class
