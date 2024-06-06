import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    Thread.sleep(2000);
    enterEmail("demo@testpro.io");
    Thread.sleep(2000);
    enterPassword("te$t$tudent");
    Thread.sleep(2000);
    submit();
    Thread.sleep(4000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
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
        Thread.sleep(2000);
        submit();
        Thread.sleep(4000);
        //Expected Results - Assertions
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
    //Negative Test Case 2
    @Test
    public void loginWithNoPassword() throws InterruptedException {
        //navigateToPage();
        String expectedURL = "https://qa.koel.app/";
        //Step 2
        enterEmail("invalid@koel.io");
        //Step 3
        submit();
        Thread.sleep(4000);
        //Expected Results - Assertions
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
