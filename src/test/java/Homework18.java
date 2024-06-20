import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test

    public void playSong() throws InterruptedException {

        //login
        navigateToPage();
        enterEmail("aleksei.koksharov@testpro.io");
        enterPassword("ak1234!@#$");
        submit();
        Thread.sleep(4000);
        //from Home page click play button
        clickPlayBtn();
        Thread.sleep(2000);
        validatePauseButton();
    }//



    public void clickPlayBtn() {
            WebElement playBtn = driver.findElement(By.cssSelector("span.play"));
            playBtn.click();
        }
        public void validatePauseButton() {
            WebElement pauseBtn = driver.findElement(By.cssSelector("span.pause"));
            //Assertions - Expected vs Actual
            Assert.assertTrue(pauseBtn.isDisplayed());
        }


    }