import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    //Happy Path - Login Test
@Test
    public void loginValidEmailPassword() throws InterruptedException {
    //navigateToPage();
    enterEmail("demo@testpro.io");
    enterPassword("te$t$tudent");
    submit();
    WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Assertions - Expected vs Actual
        Assert.assertTrue(avatarIcon.isDisplayed());
    }
    // Negative Test Case
    @Test
    public void loginWithInvalidEmailValidPassword() throws InterruptedException {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
       enterEmail("invalid@koel.io");
        enterPassword("te$t$tudent");
        submit();
        //Expected Results - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    //Negative Test Case 2
    @Test
    public void loginWithNoPassword() throws InterruptedException {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        enterEmail("invalid@koel.io");
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }
    @Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest (String email, String password) {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);

    }


}
