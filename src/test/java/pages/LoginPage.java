package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static java.sql.DriverManager.getDriver;

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
    private WebElement submitBtnForLogin;

    @FindBy(xpath = "//input[@type='submit' and @id='button' and @value='Submit']")
    private WebElement submitBtnForRegistration;

    @FindBy(xpath = "//a[@href='registration']")
    private WebElement registrationLink;
    // This annotation is used to locate the registration link on the login page using CSS selector.

    @FindBy(css = ".fa-sign-out")
    private WebElement logOutLocator;

    @FindBy(linkText = "Registration / Forgot password")
    private WebElement getRegistrationLink;

    @FindBy(css = "input:invalid")
    private WebElement getInvalidMsg;

//    @FindBy(css = "a[data-testid='btn-logout']")
    @FindBy(css = "i.fa.fa-sign-out")
    private WebElement submitBtnForLogout;

    @FindBy(xpath= "//img[@src='./images/logo.svg?8a2f5cec8d12d85f91ae82ef106ecb28']")
    private WebElement getLoginAvatar;


    // This annotation is used to locate the logout element on the login page using CSS selector.
//    By emailField = By.cssSelector("input[type='email']");
//    By passwordField = By.cssSelector("input[type='password']");
//    By submitBtn = By.cssSelector("button[type='submit']");

    // Methods
    public LoginPage provideEmail(String email) {

        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {

        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {

        try {
            waitForVisibility(submitBtnForLogin).click();
        } catch (NoSuchElementException e) {

            waitForVisibility(submitBtnForRegistration).click();
        }
        return this;
    }

    public LoginPage login() {

//        HomePage homePage = new HomePage(driver);

        provideEmail("james.mar@testpro.io");
        providePassword("te$t$tudent1");
        clickSubmit();
//        homePage.isDisplayedUserAvatarIcon();
//        driver.navigate().refresh();
        return this;
    }

    public void logOut() {

        waitForVisibility(submitBtnForLogout).click();
    }

    public LoginPage logoutUser() {

        waitForVisibility(submitBtnForLogout).click();
        driver.navigate().refresh();
        return this;
    }

    public WebElement getRegistrationLink() {

        return waitForVisibility(registrationLink);
        // This method returns the registrationLink WebElement, representing the registration link on the login page.
    }

    public String selectCurrentPage() {

        // Get current URL
        return StringUtils.substringBefore(driver.getCurrentUrl(), "?");
    }

    public void selectRegistrationLink() {

        waitForVisibility(getRegistrationLink).click();
    }

    public boolean isDisplayedValidationMsg() {

        return waitForVisibility(getInvalidMsg).isDisplayed();
    }

    public boolean isDisplayedLoginAvatar() {

        return waitForVisibility(getLoginAvatar).isDisplayed();
    }
}