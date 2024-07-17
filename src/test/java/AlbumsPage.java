import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlbumsPage extends BaseTest{



    @Test
    public void testLogin() throws InterruptedException {

        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        Assert.assertTrue(clickButtonAllSong());

    }
    private boolean clickButtonAllSong () throws InterruptedException {
        WebElement buttonAllSong = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='songs']")));
        Thread.sleep(500);
        return buttonAllSong.isDisplayed();

    }
}




