import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork18 extends BaseTest{



    @Test
    public void playSong(){
       // navigateToPage();
        enterEmail(email);
        enterPassword(password);
        submit();
        clickPlayNext();
        validateSongPlaying();

    }

public void clickPlayNext(){
    WebElement nextSongBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Play next song']")));
    nextSongBtn.click();

}

public void validateSongPlaying(){
    WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='plyr__progress']")));
    Assert.assertTrue(soundBar.isDisplayed());


}
}