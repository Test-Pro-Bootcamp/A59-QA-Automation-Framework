import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class UpdatePassword extends BaseTest{

    @Test
    public void  testNewPassword() throws InterruptedException {
        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickLogOut();
        fillFieldNewPassword();
    }
    public void clickLogOut(){
        WebElement clickBtnLogOut = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='view-profile']")));
        clickBtnLogOut.click();

    }
    public void fillFieldNewPassword(){
        WebElement clickFillNewField= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='inputProfileNewPassword']")));
        clickFillNewField.click();


    }
}
