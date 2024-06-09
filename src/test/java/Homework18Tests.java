import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18Tests extends BaseTest {

    @Test
    public void playSong() throws InterruptedException {
    //navigate to page
        navigateToPage();
    //login
        enterEmail(email);
        enterPassword(password);
        submit();
        Thread.sleep(1000);
    //Click Play next song on media player controls
        playNextSong();
        Thread.sleep(1000);
    //click Play button
        clickPlay();
        Thread.sleep(1000);
    //Validate sound bar OR pause button is displayed
        validateButton();
    }

    private void validateButton() {
        WebElement pauseBtn = driver.findElement(By.cssSelector("[data-testid='pause-btn'] i[class='fa fa-pause']"));
        Assert.assertNotNull(pauseBtn, "Pause button is not found on the page");
    }

    private void clickPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        play.click();
    }

    private void playNextSong() {
        WebElement playNextSong = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNextSong.click();
    }


}
