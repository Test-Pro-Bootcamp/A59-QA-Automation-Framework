package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    // Constructor for this Page class
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators for LoginPage
    // This will use @FindBy annotation approach to locate the Web Elements
    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    // Page Methods;
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitClick() {
        submitBtn.click();
    }
}
