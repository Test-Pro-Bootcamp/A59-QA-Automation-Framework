import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {
        provideEmail("demo@testpro.io");
        providePassword("tes$t$tudent");
        clickSubmit();
        clickPay();
        Assert.assertTrue(isSongPlaying());

        public void clickPlay()  {
            WebElement playNextButton = driver.findElement(By.xpath("//1[@data-testid='play-next-btn']"));
            WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
            
            playNextButton.click();
            playButton.click();
            
            public boolean isSongPlaying() {
                WebElement soundbar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
                return soundbar.isDisplayed();

            
            }
        }
    }

    private void clickSubmit() {
    }

    private boolean isSongPlaying() {
    }

    private void clickPay() {
    }

    private void providePassword(String tes$t$tudent) {
    }

    private void provideEmail(String mail) {
    }
}
