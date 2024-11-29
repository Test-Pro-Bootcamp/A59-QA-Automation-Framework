import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword() {
        loginPage.loginEmptyEmailPassword();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);

    }

    @Test
    public void loginValidEmailPassword(){
        loginPage.login();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    //Negative Test
    @Test
    public void loginWithInvalidEmailValidPassword() {
        loginPage.loginInvalidEmail();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
    }

    //Negative Test - empty password field
    @Test
    public void loginValidEmailEmptyPassword()  {
        loginPage.loginEmptyPassword();
        String expectedUrl = "https://qa.koel.app/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);                 //https://qa.koel.app/
    }

    @Test(dataProvider = "NegativeLoginTestData" , dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) {
    String expectedUrl = "https://qa.koel.app/";
    enterEmail(email);
    enterPassword(password);
    submit();
    Assert.assertEquals(getDriver().getCurrentUrl(),expectedUrl);
}


}
