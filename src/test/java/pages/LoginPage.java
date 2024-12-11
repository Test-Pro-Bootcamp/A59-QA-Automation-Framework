package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    static By emailField = By.cssSelector("input[type = 'email']");
    static By passwordField = By.cssSelector("input[type = 'password']");
    static By submitButton = By.cssSelector("button[type = 'submit']");

//Helper Method
public static void provideEmail(String email){
 findElement(emailField).sendKeys(email);

}
public static void providePassword(String password) {
    findElement(passwordField).sendKeys(password);

}
public static void clickSubmit(){

    findElement(submitButton).click();
}

public static void login() {
    provideEmail("apurva.singh@testpro.io");
    providePassword("te$tpro$tudent1");
    clickSubmit();
}


    public void loginValidEmailInvalidPassword(){
        provideEmail("apurva.singh@testpro.io");
        providePassword("tettudent");
        clickSubmit();
    }

    public void loginInvalidEmailValidPassword(){
        provideEmail("@gmail.com");
        providePassword("te$tpro$tudent1");
        clickSubmit();
    }
}