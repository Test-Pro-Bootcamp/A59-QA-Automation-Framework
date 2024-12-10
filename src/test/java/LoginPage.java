import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By emailField = By.cssSelector("input[type = 'email']");
    By passwordField = By.cssSelector("input[type = 'password']");
    By submitButton = By.cssSelector("button[type = 'submit']");

//Helper Method
public void provideEmail(String email){
 findElement(emailField).sendKeys(email);

}
public void providePassword(String password) {
    findElement(passwordField).sendKeys(password);

}
public void clickSubmit(){
    findElement(submitButton).click();
}

public void login(){
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