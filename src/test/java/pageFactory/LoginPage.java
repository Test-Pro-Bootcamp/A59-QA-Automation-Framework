package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    // Constructor for LoginPage
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for LoginPage
//    By emailField = By.cssSelector("input[type='email']");
//    By passwordField = By.cssSelector("input[type='password']");
//    By submitBtn = By.cssSelector("button[type='submit']");

    // Now using @FindBy to locate Web Element instead of the above normal way
    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    // Page Methods for LoginPage under loginPage package/folder
    public void provideEmail(String email) {
        emailField.sendKeys(email);
        //findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.sendKeys(password);
        //findElement(passwordField).sendKeys(password);
    }

    public void submitClick() {
        submitBtn.click();
        //findElement(submitBtn).click();
    }

    public void login() {
        provideEmail("leon.poyau+2@testpro.io");
        providePassword("N6wWY2Rx");
        submitClick();
    }
}
