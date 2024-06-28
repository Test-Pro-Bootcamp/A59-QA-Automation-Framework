package pages;

import org.apache.hc.client5.http.psl.PublicSuffixList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //CONSTRUCTOR
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //LOCATORS
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    // PAGE METHODS
        public void provideEmail(String email) {
            findElement(emailField).sendKeys(email);
        }
        public void providePassword(String password) {
            findElement(passwordField).sendKeys(password);
        }
        public void clickSubmit() {
            findElement(submitButton).click();
        }

        public void login(){
            provideEmail("christina.taylor@testpro.io");
            providePassword("jKV0uSX6z1dv");
            clickSubmit();
        }
}


