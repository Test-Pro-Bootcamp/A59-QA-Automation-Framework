package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrentQueuePage extends BasePage{
    public CurrentQueuePage(WebDriver givenDriver) {
        super(givenDriver);}


    By clickShufflingAllSongsBtn = By.cssSelector("a[class='start']");
    By isDisplayedCurrentQueueList = By.cssSelector("section[id='queueWrapper']");
    By currentQueuePlayingSong = By.cssSelector("input[class='plyr__progress--seek']");
    By clickClearBtn = By.cssSelector("button.btn-clear-queue");
    By noSongsMessage = By.xpath("//div//div[contains(text(),'queued')]");


    public WebElement getShufflingAllSongsBtn(){
        return findElement(clickShufflingAllSongsBtn);
    }
    public void shufflingAllSongsBtn(){
        getShufflingAllSongsBtn().click();
    }
    public WebElement getIsDisplayedCurrentQueueList(){
        return findElement(isDisplayedCurrentQueueList);
    }
    public WebElement getCurrentQueuePlayingSong(){
        return findElement(currentQueuePlayingSong);
    }
    public WebElement getClickClearBtn(){
        return findElement(clickClearBtn);}
    public void clearBtn(){
        getClickClearBtn().click();
    }
    public WebElement getNoSongsMessage(){
        return findElement(noSongsMessage);
    }



}
