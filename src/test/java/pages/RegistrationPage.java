package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By registrationBtn = By.cssSelector("a[href='registration']");

    private void registrationBtnClick() {
       findElement(registrationBtn).click();
    }
}
