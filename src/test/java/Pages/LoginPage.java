package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    // By emailField = By.cssSelector("input[type='email']");
    // By passwordField = By.cssSelector("input[type='password']");
    // By submitBtn = By.cssSelector("button[type='submit']");

    @FindBy(css = "input[type='email']")
    static WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    public static void provideEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);

        //  findElement(emailField).clear();
        //findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);

        // findElement(passwordField).clear();
        //findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        //findElement(submitBtn).click();
        submitBtn.click();
    }

    public void login(){
        provideEmail("demo@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }

    public void loginValidEmailInvalidPassword(){
        provideEmail("demo@testpro.io");
        providePassword("tettudent");
        clickSubmit();
    }

    public void loginInvalidEmailValidPassword(){
        provideEmail("@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}