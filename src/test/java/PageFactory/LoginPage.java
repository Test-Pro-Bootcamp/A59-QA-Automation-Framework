package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {


    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //PAGE METHODS
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);

        //findElement(emailField).sendKeys(email)
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        //findElement(passwordField).sendKeys();

        return null;
    }


    public LoginPage clickSubmit() {
        submitBtn.click();
        //findElement(submitBtn).click();
        return null;
    }

    public LoginPage login() {
        provideEmail("india.messam@testpro.io");
        providePassword("slcTalgy");
        clickSubmit();

        return null;
    }

}
