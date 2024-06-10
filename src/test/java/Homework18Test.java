import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework18Test extends BaseTest{
    @Test
 //navigateToPage();
 enterEmail("kristina.sarkisyan@testpro.io");
 enterPassword("o8URUDnW");
 submit();
 playNextSong();
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
 playBtn();
 WebElement pauseBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//footer[@id='mainFooter']/div[@class='side player-controls']/span[@class='album-thumb-wrapper']/span[@data-testid='pause-btn']/i[@class='fa fa-pause']")));
 Assert.assertTrue(pauseBtn.isDisplayed(),"Pause button is not displayed, indicating song is not playing.");
 closeBrowser();
 }

    public void playBtn() {
        WebElement clickPlayBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//footer[@id='mainFooter']/div[@class='side player-controls']/span[@class='album-thumb-wrapper']/span[@data-testid='play-btn']/i[@class='fa fa-play']")));
        clickPlayBtn.click();
    }

    public void playNextSong() {
        WebElement clickPlayNextSong = driver.findElement(By.xpath("//footer[@id='mainFooter']//i[@title='Play next song']"));
        clickPlayNextSong.click();
    }

}

