package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.UUID;

public class ProfilePage extends BasePage {

    // Constructors
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath ="//*[contains(text(), 'Profile updated.')]")
    private WebElement getUpdatedVerificationMsg;

    @FindBy(css = "span.name")
    private WebElement getProfileNameBtn;

    @FindBy(css = "btn-submit")
    private WebElement getProfileSaveBtn;

    @FindBy(css = "span.name")
    private WebElement getProfileNameDisplayed;

    @FindBy(css = "input[type='text'][name='name']")
    private WebElement getInputProfileNameField;

    @FindBy(css = "input[type='email'][id='inputProfileEmail']")
    private WebElement getInputEmailField;

    @FindBy(css="input[type='password'][name='current_password'][id='inputProfileCurrentPassword']")
    private WebElement getInputProfileCurrentPasswordField;

    @FindBy(css="input[type='password'][name='new_password'][id='inputProfileNewPassword']")
    private WebElement getInputProfileNewPasswordField;

    @FindBy(xpath="//div[@class=\"theme selected\"]")
    private WebElement getCurrentTheme;

    @FindBy(xpath="//div[@data-testid=\"theme-card-violet\"][@class=\"theme\"]")
    private WebElement getVioletTheme;

    @FindBy(xpath="//div[@data-testid=\"theme-card-violet\"][@class=\"theme selected\"]")
    private WebElement getIsVioletThemeSelected;


    //Page Methods
    public void selectProfileNameBtn() {
        getProfileNameBtn.click();
    }

    public String generateUniqueName() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    public void selectInputProfileNameField(String newName) {

        waitForVisibility(getInputProfileNameField).clear();
        waitForVisibility(getInputProfileNameField).sendKeys(newName + "\n");
    }

    public void selectInputProfileCurrentPasswordField(String userPassword) {

        waitForVisibility(getInputProfileCurrentPasswordField).clear();
        waitForVisibility(getInputProfileCurrentPasswordField).sendKeys(userPassword + "\n");
    }

    public void selectInputProfileNewPasswordField(String userPassword) {

        waitForVisibility(getInputProfileNewPasswordField).clear();
        waitForVisibility(getInputProfileNewPasswordField).sendKeys(userPassword + "\n");
    }

    public void selectInputProfileEmailField(String userEmail) {

        waitForVisibility(getInputEmailField).clear();
        waitForVisibility(getInputEmailField).sendKeys(userEmail + "\n");
    }

    public String selectVerifyNotificationMsg() {

        return waitForVisibility(getUpdatedVerificationMsg).getText();
    }
    public void selectProfileSaveBtn() {

        waitForVisibility(getProfileSaveBtn).click();
    }

    public WebElement selectProfileSaveInfo() {

        return  getProfileSaveBtn;
    }

    public String selectUpdatedVerifyNotificationMsg(String test) {

        test = waitForVisibility(getUpdatedVerificationMsg).getText();
        return test;
//        return getUpdatedVerificationMsg.isDisplayed();
    }

    public boolean isVioletThemeSelected() {

        return waitForVisibility(getIsVioletThemeSelected).isDisplayed();
    }

    public ProfilePage selectVioletTheme() {

        waitForVisibility(getVioletTheme).click();
        return this;
    }

    public String selectCurrentTheme() {

        return waitForVisibility(getCurrentTheme).getAttribute("data-testid");
    }

}
