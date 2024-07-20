package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage{

    // Constructors
    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locator for Login Page Web Elements
    @FindBy(css = "input[type='email']")
        private WebElement emailField;

    @FindBy(css = "input[type='password']")
        private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
        private WebElement submitBtn;

    @FindBy(xpath = "//a[@href='registration']")
    private WebElement registrationLink;
    // This annotation is used to locate the registration link on the login page using CSS selector.

    @FindBy(css = ".fa-sign-out")
    private WebElement logOutLocator;

    @FindBy(linkText = "Registration / Forgot password")
    private WebElement getRegistrationLink;


    // This annotation is used to locate the logout element on the login page using CSS selector.
//    By emailField = By.cssSelector("input[type='email']");
//    By passwordField = By.cssSelector("input[type='password']");
//    By submitBtn = By.cssSelector("button[type='submit']");

    // Methods
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

    public LoginPage login() {
        HomePage homePage = new HomePage(driver);

        provideEmail("demo@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
//        Assert.assertTrue(homePage.isDisplayedUserAvatarIcon());
        driver.navigate().refresh();
        return this;
    }
    public WebElement getRegistrationLink() {
        return registrationLink;
        // This method returns the registrationLink WebElement, representing the registration link on the login page.
    }

    public String selectCurrentPage() {

        return StringUtils.substringBefore(driver.getCurrentUrl(), "?");
    }

    public void selectRegistrationLink() {

        waitForVisibility(getRegistrationLink).click();

    }
}