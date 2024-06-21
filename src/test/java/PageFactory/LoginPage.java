package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {


    @FindBy(css = "[type='submit']")
    private WebElement submitButtonLocator;

    @FindBy(css = "[type='email']")
    private WebElement emailField;

    @FindBy(css = "button[type='password']")
    private WebElement passwordField;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //PAGE METHODS
    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }

    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
       return this;
    }


    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }



}
