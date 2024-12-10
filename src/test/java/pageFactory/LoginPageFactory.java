package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPageFactory extends BasePage {
    public LoginPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    //page Factory element
    @FindBy(css = "[type = 'submit']")
    WebElement submitBtn;
    @FindBy(css = "[type = 'email']")
    WebElement emailField;
    @FindBy(css = "[type = 'password']")
    WebElement passwordField;

    //helper method

    public LoginPageFactory clickSubmitBtn(){
        submitBtn.click();
        return this;
    }
    public LoginPageFactory provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPageFactory providePassword(String password){
        passwordField.sendKeys(password);
    return this;
    }
}
