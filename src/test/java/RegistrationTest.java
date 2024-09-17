import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
//Homework 16

public class RegistrationTest extends BaseTest {


    @Test
    public void registrationNavigation() {
        String url = "https://qa.koel.app/";
        String urlRegistration = "https://qa.koel.app/registration";
        loginPage.clickRegistrationLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), urlRegistration);
}
}

