package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    //Locators
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;


    //Page Methods
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit(){
        submitBtn.click();
        return this;
    }

    public void login(){
        provideEmail("aleksei.koksharov@testpro.io").providePassword("ak1234!@#$").clickSubmit();
    }

    public void loginInvalidEmail(){
        provideEmail("alekseikoksharov@testproio").providePassword("ak1234!@#$").clickSubmit();
    }

    public void loginEmptyPassword(){
        provideEmail("aleksei.koksharov@testpro.io").providePassword(" ").clickSubmit();
    }

    public void loginEmptyEmailPassword(){
        provideEmail(" ").providePassword(" ").clickSubmit();
    }


}
