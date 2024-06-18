package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


    public class LoginPage extends BasePage {

        //Constructor
        public LoginPage(WebDriver givenDriver) {
            super(givenDriver);
        }

        //Locators
        //By emailField = By.cssSelector("input[type='email']");
        //By passwordField = By.cssSelector("input[type='password']");
        //By submitBtn = By.cssSelector("button[type='submit']");
        @FindBy(css = "input[type='email']")
        WebElement emailField;
        @FindBy(css = "input[type='password']")
        WebElement passwordField;
        @FindBy(css = "button[type='submit']")
        WebElement submitBtn;

        //Page Methods
        public LoginPage provideEmail(String email) {
            emailField.clear();
            emailField.sendKeys();
            return this;
            //findElement(emailField).clear();
           // findElement(emailField).sendKeys(email);

        }
        public LoginPage providePassword (String password) {
           passwordField.clear();
           passwordField.sendKeys();
            //findElement(passwordField).clear();
            //(passwordField).sendKeys(password);
            return this;
        }
        public LoginPage clickSubmit() {
           submitBtn.click();
            // findElement(submitBtn).click();
            return this;
        }
        public void login() {
            provideEmail("kristina.sarkisyan@testpro.io");
            providePassword("o8URUDnW");
            clickSubmit();
        }




}
