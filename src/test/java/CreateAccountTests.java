import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;

public class CreateAccountTests extends BaseTest{

    //Create account
    @Test
    public void registrationNavigation() {
        loginPage.clickRegistrationLink();
        registrationSubmit();
        Assert.assertTrue(registrationPage.getSuccessRegistrationMsg().isDisplayed());
    }
    //Email validation( must have- @, . , @testpro.io domain)
@Test(dataProvider = "emailRegistrationCredentials" , dataProviderClass = TestDataProvider.class)
    public void negativeEmailCredentials(String email){
    String registerUrl = "https://qa.koel.app/registration";
    enterEmail(email);
    registrationSubmit();
    Assert.assertEquals(getDriver().getCurrentUrl(), registerUrl);
}
//Login after password updated
    @Test
    public void loginWithNewPassword(){
        loginPage.newLoginPassword();
    }


}
