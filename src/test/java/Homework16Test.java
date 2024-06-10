import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework16Test extends BaseTest {
    @Test
    public void registrationNavigation ()  {



        //navigateToPage();
        WebElement registrationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='registration']")));
        registrationBtn.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://qa.koel.app/registration"));
        driver.quit();








    }




}
