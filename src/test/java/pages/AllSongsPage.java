package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //page Element
    By playBackBtn = By.cssSelector("li.playback");

    // Helper method
    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playBackBtn)).click();

    }
    public void enterButtonPlaySong() {
        WebElement buttonPlaySong = driver.findElement
                (By.xpath("//span[@title='Play or resume']"));
        Actions actions = new Actions(driver);
        actions.click(buttonPlaySong).perform();
    }
  public void clickPlayNextBtn() {
        WebElement playNext = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[class='next fa fa-step-forward control']")));
        playNext.click();
    }
}
