package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {


    public String playlistName = "test";

    // Constructors
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath ="//div[@class='messages' and contains(text(), \"We've sent a confirmation link to the email. Please continue by clicking on it\")]")
    private WebElement getRegisterationVerificationMsg;

    //Page Methods

    public boolean selectRegistrationVerificationMsg() {

        return waitForVisibility(getRegisterationVerificationMsg).isDisplayed();
    }
}
