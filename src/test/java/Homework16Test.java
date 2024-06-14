import Pages.HomePage;
import Pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation () {
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.registrationBtnClick();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.koel.app/registration"));
        driver.quit();


        //navigateToPage();
       /* WebElement registrationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='registration']")));
        registrationBtn.click();*/








    }




}
