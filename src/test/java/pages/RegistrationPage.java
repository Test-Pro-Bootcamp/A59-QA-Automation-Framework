package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

By successRegistrationMsg = By.cssSelector("div.messages");


    public WebElement getSuccessRegistrationMsg(){
        return findElement(successRegistrationMsg);
    }

}
