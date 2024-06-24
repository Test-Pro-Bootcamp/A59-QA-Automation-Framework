import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdatePassword extends BaseTest {
    @Test
    public void testNewPassword() throws InterruptedException {
//        String newName = getRandomString();
        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickLogOut();
        updatePassword();
        Assert.assertTrue(updatePassword());

//    }
//    public  String getRandomString(){
//        return UUID.randomUUID().toString().replace("-","");
    }
    public void clickLogOut() throws InterruptedException {
        WebElement clickBtnLogOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='view-profile']")));
        clickBtnLogOut.click();
        Thread.sleep(500);
    }
    private boolean updatePassword() throws InterruptedException {
        WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileNewPassword']")));
        newPassword.click();
        newPassword.clear();
        newPassword.sendKeys("te$tStudent");
        Thread.sleep(500);
       return newPassword.isDisplayed();

    }

}


