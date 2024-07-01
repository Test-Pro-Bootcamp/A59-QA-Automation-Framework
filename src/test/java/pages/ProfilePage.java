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

    @FindBy(css="input[type='password'][name='current_password'][id='inputProfileCurrentPassword']")
    private WebElement getInputProfileCurrentPasswordField;




    @FindBy(css="input[type='password'][name='current_password'][id='inputProfileCurrentPassword']")
    private WebElement selectedVioletTheme;

    @FindBy(css="input[type='password'][name='current_password'][id='inputProfileCurrentPassword']")
    private WebElement chooseVioletTheme;



    //Page Methods
    public void selectProfileNameBtn() {
        getProfileNameBtn.click();
    }

    public String generateUniqueName() {

        return UUID.randomUUID().toString().replace("-", "");
    }

    public void selectInputProfileNameField(String newName) {
        getInputProfileNameField.clear();
        getInputProfileNameField.sendKeys(newName + "\n");
    }

    public void selectInputProfilePasswordField(String userPassword) {
        getInputProfileCurrentPasswordField.clear();
        getInputProfileCurrentPasswordField.sendKeys(userPassword + "\n");

    }
    public String selectVerifyNotificationMsg() {

        return getUpdatedVerificationMsg.getText();
    }
    public void selectProfileSaveBtn() {

        getProfileSaveBtn.click();
    }

    public WebElement selectProfileSaveInfo() {

        return  getProfileSaveBtn;
    }

    public String selectUpdatedVerifyNotificationMsg(String test) {

        test = getUpdatedVerificationMsg.getText();
        return test;
//        return getUpdatedVerificationMsg.isDisplayed();
    }

    public boolean isVioletThemeSelected() {

        findElement(selectedVioletTheme);

        return  selectedVioletTheme.isDisplayed();
    }

    public ProfilePage chooseVioletTheme() {
        chooseVioletTheme().click(chooseVioletTheme);
        return this;

    }

}
