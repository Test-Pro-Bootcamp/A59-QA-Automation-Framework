import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


@Test
    public void loginEmptyEmailPassword() throws InterruptedException {

        String expectedURL= "https://qa.koel.app/";
        //navigateToPage();
        enterEmail("");
        enterPassword("jKV0uSX6z1dv");
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Thread.sleep(2000);
        driver.quit();
    }
@Test

    public void loginValidEmailPassword() throws InterruptedException {



       // navigateToPage();

        enterEmail("christina.taylor@testpro.io");

        enterPassword("jKV0uSX6z1dv");


        submit();
        Thread.sleep(2000);

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar"));
        Thread.sleep(2000);
        Assert.assertTrue(avatarIcon.isDisplayed());



    }

@Test

    public void loginInvalidEmailValidPassword() throws InterruptedException {



       // navigateToPage();

        String expectedURL= "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");

        enterPassword("jKV0uSX6z1dv");


        submit();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);



    }

@Test

    public void loginEmailEmptyPassword() throws InterruptedException {



      //  navigateToPage();
        String expectedURL= "https://qa.koel.app/";
        enterEmail("christina.taylor@testpro.io");

        submit();


        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);


    }
    @Test( dataProvider ="NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void loginNegativeTest(String email, String password) throws InterruptedException {

        String expectedURL= "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);


    }

}


