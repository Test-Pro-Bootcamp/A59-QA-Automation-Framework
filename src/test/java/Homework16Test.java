import page.HomePage;
import page.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation () {
        HomePage homePage = new HomePage(getDriver());
        RegistrationPage registrationPage = new RegistrationPage(getDriver());

        registrationPage.registrationBtnClick();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://qa.koel.app/registration"));



        //navigateToPage();
       /* WebElement registrationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='registration']")));
        registrationBtn.click();*/








    }




}
