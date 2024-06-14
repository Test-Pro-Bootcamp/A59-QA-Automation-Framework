import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;



public class AllSongAI extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {

        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickButtonAllSong();
//        Assert.assertTrue(clickButtonAllSong());
    }
    public void clickButtonAllSong ()  {
        WebElement buttonAllSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='songs']")));
       buttonAllSong.click();
    }
}




