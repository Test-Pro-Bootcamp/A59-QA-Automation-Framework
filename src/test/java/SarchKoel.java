import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SarchKoel extends BaseTest{
    @Test
    public void funktionalatySearchField () throws InterruptedException {

        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Assert.assertTrue(btnSearchField());



    }

    public boolean btnSearchField() throws InterruptedException {
        WebElement clickBtnSearchField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='search']")));
        clickBtnSearchField.click();
        clickBtnSearchField.clear();
        clickBtnSearchField.sendKeys("Episode 2");
        Thread.sleep(1000);
        clickBtnSearchField.clear();
        return clickBtnSearchField.isDisplayed();
    }

}
