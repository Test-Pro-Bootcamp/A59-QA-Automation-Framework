package pages;

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
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;
    @FindBy(css = "a[href='registration']")
    private WebElement registrationLink;


    //Page Methods
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage provideNewPassword(String newPassword){
        passwordField.sendKeys(newPassword);
        return this;
    }
    public void clickSubmit(){
        submitBtn.click();
    }
    public void clickRegistrationLink(){
        registrationLink.click();
    }
    public void login(){
        provideEmail("aleksei.koksharov@testpro.io").providePassword("ak1234!@#$").clickSubmit();
    }

    public void newLogin(){ provideEmail("aleksei.koksharov@testpro.io").provideNewPassword("Ilya!461"); }

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
