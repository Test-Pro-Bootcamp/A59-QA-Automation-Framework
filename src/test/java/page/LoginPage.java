package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;//Constructor
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Locators
    @FindBy(css = "input[type='email']" )
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    /*By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");*/

    //Page Methods
    public LoginPage provideEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
       return this;

    }
    public LoginPage providePassword (String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }
    public void login() {
        provideEmail("kristina.sarkisyan@testpro.io");
        providePassword("o8URUDnW");
        clickSubmit();
    }


}

