import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;


public class AllSongAI extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {

        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickButtonAllSong();
        Assert.assertTrue(clickButtonAllSong());
    }
    private boolean clickButtonAllSong () throws InterruptedException {
        WebElement buttonAllSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='songs']")));
        Thread.sleep(1000);
        return buttonAllSong.isDisplayed();
    }
}




