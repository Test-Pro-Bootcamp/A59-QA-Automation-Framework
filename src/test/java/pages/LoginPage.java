package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//CONSTRUCTOR
public class LoginPage extends BasePage{

private By submitButtonLocator = By.cssSelector("[type='submit']");
private By emailField = By.cssSelector("[type='email']");
private By passwordField = By.cssSelector("[type='password']");

    public LoginPage(WebDriver givenDriver){
    super(givenDriver);
}
public LoginPage clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
        return this;
}
public LoginPage provideEmail(String email){
    WebElement emailElement = driver.findElement(emailField);
        return this;
}
public LoginPage providePassword(String password){
    WebElement passwordElement = driver.findElement(passwordField);
    passwordElement.sendKeys(password);
    return this;
}


}


