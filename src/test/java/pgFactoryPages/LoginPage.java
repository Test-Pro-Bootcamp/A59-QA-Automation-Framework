package pgFactoryPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LoginPage extends BasePage {

    // CONSTRUCTOR
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this); // Initialize elements using PageFactory
    }

    // LOCATORS
    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    // PAGE METHODS
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public void login(String email, String password) {
        provideEmail("giovanna.silva@testpro.io");
        providePassword("ShakaMaya1302!");
        clickSubmit();
        // loginPage.login("giovanna.silva@testpro.io", "ShakaMaya1302!");
    }
}