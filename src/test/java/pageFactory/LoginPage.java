package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    // Constructor for this Page class

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
    // To make it a fluent interface method we add a return type of LoginPage
//    public void provideEmail(String email) {
//        emailField.sendKeys(email);
//        //findElement(emailField).sendKeys(email);
//    }
//     public LoginPage provideEmail(String email) {
//         emailField.sendKeys(email);
//         return this;
//         //findElement(emailField).sendKeys(email);
//     }

//     public LoginPage providePassword(String password) {
//         passwordField.sendKeys(password);
//         return this;
//         //findElement(passwordField).sendKeys(password);
//     }

//     public LoginPage submitClick() {
//         submitBtn.click();
//         return this;
//         //findElement(submitBtn).click();
//     }

  // Page Methods;
    public void login() {
        provideEmail("leon.poyau+2@testpro.io");
        providePassword("N6wWY2Rx");
        submitClick();
    }

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
