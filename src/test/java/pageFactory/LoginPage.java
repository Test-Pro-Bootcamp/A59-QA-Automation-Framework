package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;

public class LoginPage extends BasePage {

    //CONSTRUCTOR
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //LOCATORS
    // By emailField = By.cssSelector("input[type='email']");
    // By passwordField = By.cssSelector("input[type='password']");
    // By submitButton = By.cssSelector("button[type='submit']");

     @FindBy(css = "input[type='email']")
     WebElement emailField;

     @FindBy(css = "input[type='password']")
     WebElement passwordField;

     @FindBy(css = "button[type='submit']")
     WebElement submitButton;

    // PAGE METHODS
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
       // findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
       // findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
       // findElement(submitButton).click();
        return this;
    }


    public void login() {
        provideEmail("christina.taylor@testpro.io");
        providePassword("jKV0uSX6z1dv");
        clickSubmit();


    }

}

