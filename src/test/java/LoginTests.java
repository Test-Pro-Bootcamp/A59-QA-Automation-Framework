import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTests extends BaseTest {
    private WebDriver driver;

    @Test
public void loginValidEmailPassword() throws InterruptedException {

   LoginPage loginPage = new LoginPage(getDriver());
   HomePage homepage = new HomePage(getDriver());

   loginPage.provideEmail("india.messam@testpro.io");
   loginPage.providePassword("slcTalgy");
   loginPage.clickSubmitBtn();

   Assert.assertTrue(homepage.getUserAvatar().isDisplayed());

    }
public void LoginInvalidEmailValidPassword ()throws InterruptedException{
    //navigate to page
    String expectedUrl ="https://qa.koel.app/";
    //steps
    enterEmail("indi.messam@testpro.io");
    enterPassword("slcTalgy");
    submit();

    //expected result
    Assert.assertEquals(driver.getCurrentUrl(),expectedUrl); //https://qa.koel.app/

    }

    public void submit() {

    }

    private void enterPassword(String slcTalgy) {

    }

    private void enterEmail(String mail) {

    }

    public void LoginValidEmailEmptyPassword()throws InterruptedException {
    //navigate to page
    String expectedUrl = "https://qa.koel.app/";
    enterEmail("india.messam@testpro.io");
    submit();
    //expected result
    Assert.assertEquals(driver.getCurrentUrl(),expectedUrl); //https://qa.koel.app/

    }
//@Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
public void negativeLoginTest(String email, String password) throws InterruptedException {
    String expectedUrl = "https://qa.koel/app/";
    enterEmail(email);
    enterPassword(password);
    submit();
    Assert.assertEquals(getDriver().getCurrentUrl(),expectedUrl);
}

}
